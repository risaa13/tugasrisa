/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.homework.controller;

import com.spboot.homework.interfaces.TodoInterface;
import com.spboot.homework.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Naga
 */
@Controller
public class MainController {

    @Autowired
    private TodoInterface todoInterface;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", todoInterface.getAll());
        return "index";
    }

    @GetMapping("/inventories/create")
    public String create(Model model) {
        
        Todo inventories = new Todo();
        model.addAttribute("inventories", inventories);
        
        return "create";
    }

    @PostMapping("/inventories/store")
    public String store(@ModelAttribute("todo") Todo inventories) {
        todoInterface.store(inventories);
        return "redirect:/";
    }
    
     @GetMapping("/inventories/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        Todo inventories = todoInterface.getById(id);

        model.addAttribute("inventories", inventories);
        return "edit";
    }

    @PostMapping("/inventories/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        todoInterface.delete(id);
        return "redirect:/";
    }
}