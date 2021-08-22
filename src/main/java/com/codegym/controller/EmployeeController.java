package com.codegym.controller;

import moduls.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IEmployeeService;
//import validate.ValidateAge;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
//    @Autowired
//    ValidateAge validateAge;

    @GetMapping("show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iEmployeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("list", employee);
            return modelAndView;
        }
        iEmployeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("list", iEmployeeService.findById(id));
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iEmployeeService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iEmployeeService.delete(iEmployeeService.findById(id));
        return new ModelAndView("redirect:/show");
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Employee employee) {
        iEmployeeService.edit(employee);
        return new ModelAndView("redirect:/show");
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("list", iEmployeeService.findById(id));
        return modelAndView;
    }
}
