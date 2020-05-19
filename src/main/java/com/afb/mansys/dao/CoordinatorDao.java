package com.afb.mansys.dao;

import com.afb.mansys.model.Coordinator;

import java.util.List;
import java.util.Optional;

public interface CoordinatorDao {
    String insertCoordinator(Coordinator coordinator);

    String updateCoordinatorByUsername(Coordinator coordinator, String username);

    List<Coordinator> getAllCoordinators();

    Boolean isCoordinator(String username, String password); //TODO

    Optional<Coordinator> getCoordinatorByID(int memberID); //TODO

    Optional<Coordinator> getCoordinatorByUsername(String username);
}
