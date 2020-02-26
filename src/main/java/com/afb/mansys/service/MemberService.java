package com.afb.mansys.service;

import com.afb.mansys.dao.MemberDao;
import com.afb.mansys.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberService(@Qualifier("fakeDao") MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String insertMember(Member member){
        return memberDao.insertMember(member);
    }

    public List<Member> getAllMembers(){
        return memberDao.getAllMembers();
    }
}
