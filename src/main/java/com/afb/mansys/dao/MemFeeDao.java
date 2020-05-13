package com.afb.mansys.dao;

import com.afb.mansys.model.MemFee;

import java.util.List;

public interface MemFeeDao {

    List<MemFee> getAllMemFees(); //TODO

    List<MemFee> getAllMemFeesForMember(int memberID); //TODO
}
