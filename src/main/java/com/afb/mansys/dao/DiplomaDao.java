package com.afb.mansys.dao;

import com.afb.mansys.model.Diploma;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.util.List;
import java.util.Optional;

public interface DiplomaDao {

    String insertDiploma(Diploma diploma); //TODO

    List<Diploma> getAllDiplomas(); //TODO

    Optional<Diploma> getDiplomaForMember(int memberID); //TODO
}
