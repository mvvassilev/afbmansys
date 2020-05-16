package com.afb.mansys.api;

import com.afb.mansys.model.AddQualification;
import com.afb.mansys.service.AddQualificationService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("aQ")
@RestController
public class AddQualificationController {

    private final AddQualificationService addQualificationService;

    @Autowired
    public AddQualificationController(AddQualificationService addQualificationService) {
        this.addQualificationService = addQualificationService;
    }

    @PostMapping(path = "new")
    public String insertAddQualification(@Valid @NotNull @RequestBody AddQualification addQualification){
        return addQualificationService.insertAddQualification(addQualification);
    }

    @GetMapping(path = "all")
    public List<AddQualification> getAllAddQualifications(){
        return addQualificationService.getAllAddQualifications();
    }

    @GetMapping(path = "memberID/{id}")
    public Optional<AddQualification> getAddQualificationForMember(@PathVariable("memberID") int memberID){
        return addQualificationService.getAddQualificationForMember(memberID);
    }
}
