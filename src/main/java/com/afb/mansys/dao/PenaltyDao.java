package com.afb.mansys.dao;

import com.afb.mansys.model.Penalty;

import java.util.List;

public interface PenaltyDao {

    List<Penalty> getPenaltiesForMember(int memberID);

    List<Penalty> getAllPenalties();
}
