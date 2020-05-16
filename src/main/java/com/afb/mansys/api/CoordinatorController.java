package com.afb.mansys.api;

import com.afb.mansys.model.Coordinator;
import com.afb.mansys.service.CoordinatorService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("coordinators")
@RestController
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    @Autowired
    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping(path = "new")
    public String insertCoordinator(@Valid @NotNull @RequestBody Coordinator coordinator) {
        return coordinatorService.insertCoordinator(coordinator);
    }

    @PutMapping(path = "{username}")
    public String updateCoordinatorByUsername(@Valid @NotNull @RequestBody Coordinator coordinator,
                                              @PathVariable("username") String username) {
        return coordinatorService.updateCoordinatorByUsername(coordinator, username);
    }

    @GetMapping(path = "all")
    public List<Coordinator> getAllCoordinators() {
        return coordinatorService.getAllCoordinators();
    }

    public Boolean isCoordinator(String username, String password) {
        return coordinatorService.isCoordinator(username, password);
    }
}
