package com.afb.mansys.service;

import com.afb.mansys.dao.PenaltyDao;
import com.afb.mansys.model.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PenaltyService {

    private final PenaltyDao penaltyDao;

    @Autowired
    public PenaltyService(@Qualifier("postgres") PenaltyDao penaltyDao) {
        this.penaltyDao = penaltyDao;
    }

    public Optional<List<Penalty>> getPenaltiesForMember(int memberID){
        return penaltyDao.getPenaltiesForMember(memberID);
    }

    public List<Penalty> getAllPenalties(){
        return penaltyDao.getAllPenalties();
    }

    public String insertPenalty(Penalty penalty) {
        return penaltyDao.insertPenalty(penalty);
    }
}
