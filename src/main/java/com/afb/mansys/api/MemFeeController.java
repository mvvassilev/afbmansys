package com.afb.mansys.api;

import com.afb.mansys.model.MemFee;
import com.afb.mansys.service.MemFeeService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("memfee")
@RestController
public class MemFeeController {

    private final MemFeeService memFeeService;

    @Autowired
    public MemFeeController(MemFeeService memFeeService) {
        this.memFeeService = memFeeService;
    }

    @GetMapping(path = "all")
    public List<MemFee> getAllMemFees() {
        return memFeeService.getAllMemFees();
    }

    @GetMapping(path = "{memberID}")
    public List<MemFee> getAllMemFeesForMember(@PathVariable("memberID") int memberID) {
        return memFeeService.getAllMemFeesForMember(memberID);
    }

    @PostMapping(path = "new")
    public String insertMemFee(@Valid @NotNull @RequestBody MemFee memFee) {
        return memFeeService.insertMemFee(memFee);
    }

    @PutMapping(path = "{memberID}")
    public String updateLastFeeForMember(@Valid @NotNull @RequestBody MemFee memFee,
                                         @PathVariable("memberID") int memberID) {
        return memFeeService.updateLastFeeForMember(memFee, memberID);
    }
}
