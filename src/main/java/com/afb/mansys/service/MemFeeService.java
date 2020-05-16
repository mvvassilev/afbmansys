package com.afb.mansys.service;

import com.afb.mansys.dao.MemFeeDao;
import com.afb.mansys.model.MemFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemFeeService {

    private final MemFeeDao memFeeDao;

    @Autowired
    public MemFeeService(@Qualifier("postgres") MemFeeDao memFeeDao) {
        this.memFeeDao = memFeeDao;
    }

    public List<MemFee> getAllMemFees() {
        return memFeeDao.getAllMemFees();
    }

    public List<MemFee> getAllMemFeesForMember(int memberID) {
        return memFeeDao.getAllMemFeesForMember(memberID);
    }

    public String insertMemFee(MemFee memFee){
        return memFeeDao.insertMemFee(memFee);
    }

    public String updateLastFeeForMember(MemFee memFee, int memberID){
        return memFeeDao.updateLastFeeForMember(memFee, memberID);
    }
}
