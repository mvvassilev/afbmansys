package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeMemberDataAccessService implements MemberDao{

    private static List<Member> DB = new ArrayList<>();

    @Override
    public String insertMember(UUID id, Member member) {
        DB.add(new Member(id, member.getName(), member.getPersonalID(), member.getMajor(), member.getSex(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getMembershipID(), member.getRegisterAddress(), member.getMainAddress(), member.getEmail(),
                member.getWorkContractID(), member.isDeclaration(), member.getPenaltyID()));
        return "NOTE: Inserted a new Member (ID:" + id.toString() + ", NAME: " + member.getName() + ")";
    }

    @Override
    public List<Member> getAllMembers() {
        return DB;
    }
}
