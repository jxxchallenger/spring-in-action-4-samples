package io.jxxchallenger.springinaction.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.jxxchallenger.springinaction.spittr.data.SpittleRepository;
import io.jxxchallenger.springinaction.spittr.model.Spittle;

@Controller
@RequestMapping(value = {"/spittles"})
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;
    
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String spittles(@RequestParam(defaultValue = "9223372036854775807") long max, @RequestParam(defaultValue = "20") int count, Model model) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }
    
    @GetMapping(value = {"/{spittleId}"})
    public String spittle(@PathVariable long spittleId, Model model) {
        model.addAttribute(this.spittleRepository.findOne(spittleId));
        return "spittle";
    }
    
    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    public String handlerEmpty() {
        return "404";
    }
    
    @PostMapping
    public String saveSpittle(Spittle spittle) {
        this.spittleRepository.save(spittle);
        return "redirect:/spittles";
    }
}
