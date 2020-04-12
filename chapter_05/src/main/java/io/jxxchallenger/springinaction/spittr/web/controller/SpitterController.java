package io.jxxchallenger.springinaction.spittr.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jxxchallenger.springinaction.spittr.data.SpitterRepostitory;
import io.jxxchallenger.springinaction.spittr.model.Spitter;

@Controller
@RequestMapping(value = {"/spitter"})
public class SpitterController {

    @Autowired
    private SpitterRepostitory spitterRepostitory;
    
    @GetMapping(value = {"/register"})
    public String showRegistrationForm() {
        return "registerForm";
    }
    
    @PostMapping(value = {"/register"})
    public String processRegistration(@Valid Spitter spitter, Errors errors) {
        
        if(errors.hasErrors()) {
            return "registerForm";
        }
        
        this.spitterRepostitory.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }
    
    @GetMapping(value = {"/{username}"})
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(this.spitterRepostitory.findByUsername(username));
        return "profile";
    }
}
