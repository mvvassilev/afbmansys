package com.afb.mansys.dao;

import com.afb.mansys.model.Diploma;

import java.util.Optional;

public interface DiplomaDao {

    String insertDiploma(Diploma diploma);

    Optional<Diploma> getDiplomaByID(String id);
}
