package com.afb.mansys.service;

import com.afb.mansys.dao.CoordinatorDao;
import com.afb.mansys.model.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatorService {

    private final CoordinatorDao coordinatorDao;

    @Autowired
    public CoordinatorService(@Qualifier("postgres") CoordinatorDao coordinatorDao) {
        this.coordinatorDao = coordinatorDao;
    }

    public String insertCoordinator(Coordinator coordinator){
        return coordinatorDao.insertCoordinator(coordinator);
    }

    public String updateCoordinatorByUsername(Coordinator coordinator, String username){
        return coordinatorDao.updateCoordinatorByUsername(coordinator, username);
    }

    public List<Coordinator> getAllCoordinators(){
        return coordinatorDao.getAllCoordinators();
    }

    public Boolean isCoordinator(String username, String password){
        return coordinatorDao.isCoordinator(username, password);
    }

    public Optional<Coordinator> getCoordinatorByID(int memberID){
        return coordinatorDao.getCoordinatorByID(memberID);
    }

    public Optional<Coordinator> getCoordinatorByUsername(String username){
        return coordinatorDao.getCoordinatorByUsername(username);
    }
}
