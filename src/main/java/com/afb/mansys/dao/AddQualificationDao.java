package com.afb.mansys.dao;

import com.afb.mansys.model.AddQualification;

import java.util.List;
import java.util.Optional;

public interface AddQualificationDao {
    String insertAddQualification(AddQualification diploma);

    List<AddQualification> getAllAddQualifications();

    Optional<AddQualification> getAddQualificationForMember(int memberID);
}
