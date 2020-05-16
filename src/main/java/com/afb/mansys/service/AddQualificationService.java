package com.afb.mansys.service;

import com.afb.mansys.dao.AddQualificationDao;
import com.afb.mansys.model.AddQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddQualificationService {

    private final AddQualificationDao addQualificationDao;

    @Autowired
    public AddQualificationService(@Qualifier("postgres") AddQualificationDao addQualificationDao) {
        this.addQualificationDao = addQualificationDao;
    }

    public String insertAddQualification(AddQualification addQualification){
        return addQualificationDao.insertAddQualification(addQualification);
    }

    public List<AddQualification> getAllAddQualifications(){
        return addQualificationDao.getAllAddQualifications();
    }

    public Optional<AddQualification> getAddQualificationForMember(int memberID){
        return addQualificationDao.getAddQualificationForMember(memberID);
    }
}
