package com.afb.mansys.api;


import com.afb.mansys.model.Diploma;
import com.afb.mansys.model.Member;
import com.afb.mansys.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin("http://localhost:4200")
@RequestMapping("diplomas")
@RestController
public class DiplomaController {

    private final DiplomaService diplomaService;

    @Autowired
    public DiplomaController(DiplomaService diplomaService) {
        this.diplomaService = diplomaService;
    }

    @PostMapping(path = "new")
    public void insertDiploma(@Valid @NotNull @RequestBody Diploma diploma) {
        diplomaService.insertDiploma(diploma);
    }

    @GetMapping(path = "{id}")
    public Diploma getMemberByID(@PathVariable("id") String id) {
        return diplomaService.getDiplomaByID(id)
                .orElse(null);
    }
}
