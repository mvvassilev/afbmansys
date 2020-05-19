package com.afb.mansys.dao;

import com.afb.mansys.model.Penalty;

import java.util.List;
import java.util.Optional;

public interface PenaltyDao {

    Optional<List<Penalty>> getPenaltiesForMember(int memberID);

    List<Penalty> getAllPenalties();

    String insertPenalty(Penalty penalty);
}