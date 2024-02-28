package com.project.testing.controller;

import com.project.testing.entities.Input;
import com.project.testing.services.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TriangleController {
    @Autowired
    private TriangleService triangleService;

    @GetMapping("/triangle")
    public String triangle() {
        return "triangle";
    }

    @GetMapping("/triangle/generate")
    public String generate(Model model) {
        Input input = new Input();

        model.addAttribute("value", input);

        triangleService.execute(input);
        model.addAttribute("triangles", triangleService.listAll());

        return "triangle";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
