package com.afb.mansys.dao;

import com.afb.mansys.model.MemFee;

import java.util.List;

public interface MemFeeDao {

    List<MemFee> getAllMemFees();

    List<MemFee> getAllMemFeesForMember(int memberID); //TODO

    String insertMemFee(MemFee memFee);

    String updateLastFeeForMember(MemFee memFee, int memberID); //TODO
}
