package com.afb.mansys.api;

import com.afb.mansys.model.Diploma;
import com.afb.mansys.service.DiplomaService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JsonSerialize
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
    public String insertDiploma(@Valid @NotNull @RequestBody Diploma diploma) {
        return diplomaService.insertDiploma(diploma);
    }

    @GetMapping(path = "all")
    public List<Diploma> getAllDiplomas(){
        return diplomaService.getAllDiplomas();
    }

    public Optional<Diploma> getDiplomaForMember(@PathVariable("memberID") int memberID){
        return diplomaService.getDiplomaForMember(memberID);
    }
}
