package com.project.testing.controller;

import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import com.project.testing.services.BoundaryValueService;
import com.project.testing.services.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TriangleController {
    @Autowired private TriangleService triangleService;
    @Autowired private BoundaryValueService valueService;

    @GetMapping("/triangle/generate")
    public String generate(){
        triangleService.deleteAll();



        return "TriangleGenerator";
    }
}
