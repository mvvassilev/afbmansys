package com.afb.mansys.service;

import com.afb.mansys.dao.MemberDao;
import com.afb.mansys.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Member> getMemberByID(UUID id){
        return memberDao.getMemberByID(id);
    }

    public String deleteMember(UUID id){
        return memberDao.deleteMember(id);
    }

    public String updateMember(UUID id, Member newMember){
        return memberDao.updateMemberByID(id, newMember);
    }
}
