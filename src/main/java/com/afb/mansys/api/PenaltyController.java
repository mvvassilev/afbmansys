package com.afb.mansys.api;

import com.afb.mansys.model.Penalty;
import com.afb.mansys.service.PenaltyService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("pens")
@RestController
public class PenaltyController {

    private final PenaltyService penaltyService;

    @Autowired
    public PenaltyController(PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @GetMapping(path = "memberID/{memberID}")
    public List<Penalty> getPenaltiesForMember(@PathVariable("memberID") int memberID) {
        return penaltyService.getPenaltiesForMember(memberID);
    }

    @GetMapping(path = "all")
    public List<Penalty> getAllPenalties(){
        return penaltyService.getAllPenalties();
    }

    @PostMapping(path = "new")
    public String insertPenalty(@Valid @NotNull @RequestBody Penalty penalty){
        return penaltyService.insertPenalty(penalty);
    }
}
