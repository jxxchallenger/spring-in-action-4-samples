package io.jxxchallenger.springinaction.spittr.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String home() {
        return "home";
    }
}
