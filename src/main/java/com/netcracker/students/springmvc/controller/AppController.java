package com.netcracker.students.springmvc.controller;

import com.netcracker.students.springmvc.model.Employee;
import com.netcracker.students.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

    private final EmployeeService service;

    private final MessageSource messageSource;

    @Autowired
    public AppController(EmployeeService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
                               ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())) {
            FieldError ssnError = new FieldError("employee", "ssn", messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.saveEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
                                 ModelMap model, @PathVariable String ssn) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())) {
            FieldError ssnError = new FieldError("employee", "ssn", messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{ssn}-employee"}, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }
}
