package com.afb.mansys.service;

import com.afb.mansys.dao.DiplomaDao;
import com.afb.mansys.model.Diploma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomaService {
    private final DiplomaDao diplomaDao;

    @Autowired
    public DiplomaService(@Qualifier("postgres") DiplomaDao diplomaDao) {
        this.diplomaDao = diplomaDao;
    }

    public String insertDiploma(Diploma diploma){
        return diplomaDao.insertDiploma(diploma);
    }

    public List<Diploma> getAllDiplomas(){
        return diplomaDao.getAllDiplomas();
    }

    public Optional<List<Diploma>> getDiplomaForMember(int memberID){
        return diplomaDao.getDiplomaForMember(memberID);
    }
}
