package io.jxxchallenger.springinaction.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jxxchallenger.springinaction.spittr.data.SpittleRepository;

@Controller
@RequestMapping(value = {"/spittles"})
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;
    
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
}
