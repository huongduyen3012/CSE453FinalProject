package com.project.testing.controller;

import com.project.testing.entities.Triangle;
import com.project.testing.services.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TriangleController {
    @Autowired
    private TriangleService triangleService;

    @GetMapping("/triangle")
    public String triangle() {
        return "TriangleGenerator";
    }

    @GetMapping("/triangle/generate")
    public String generate(Model model, @RequestParam("testType") String testType,
                           @RequestParam("from") int from, @RequestParam("to") int to) {
        triangleService.execute(testType, from, to);
        List<Triangle> triangles = triangleService.listAll();
        model.addAttribute("triangles", triangles);

        return "TriangleGenerator";
    }

}
