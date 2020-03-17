package com.afb.mansys.service;

import com.afb.mansys.dao.DiplomaDao;
import com.afb.mansys.model.Diploma;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiplomaService {

    private final DiplomaDao diplomaDao;

    public DiplomaService(@Qualifier("postgres") DiplomaDao diplomaDao) {
        this.diplomaDao = diplomaDao;
    }

    public String insertDiploma(Diploma diploma) {
        return diplomaDao.insertDiploma(diploma);
    }

    public Optional<Diploma> getDiplomaByID(String id) {
        return diplomaDao.getDiplomaByID(id);
    }
}
