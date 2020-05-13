package com.afb.mansys.dao;

import com.afb.mansys.model.Coordinator;

import java.util.List;
import java.util.Optional;

public interface CoordinatorDao {
    String insertCoordinator(Coordinator coordinator); //TODO

    String updateCoordinatorByUsername(Coordinator coordinator, String username); //TODO

    List<Coordinator> getAllCoordinators(); //TODO

    Boolean isCoordinator(String username, String password); //TODO
}
