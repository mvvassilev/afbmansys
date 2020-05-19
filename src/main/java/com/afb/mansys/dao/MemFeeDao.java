package com.afb.mansys.dao;

import com.afb.mansys.model.MemFee;

import java.util.List;
import java.util.Optional;

public interface MemFeeDao {

    List<MemFee> getAllMemFees();

    Optional<List<MemFee>> getAllMemFeesForMember(int memberID);

    String insertMemFee(MemFee memFee);

    String updateLastFeeForMember(MemFee memFee, int memberID); //TODO
}
