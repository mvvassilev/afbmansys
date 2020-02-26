package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Member> getMemberByID(UUID id){
        return DB.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst();
    }

    @Override
    public String deleteMember(UUID id) {
        Optional<Member> member = getMemberByID(id);
        if(member.isEmpty()){
            return "NOTE: Delete called on member with ID: " + id.toString()+ " BUT such member does NOT EXIST!";
        }
        DB.remove(member.get());
        return "NOTE: Delete called on member with ID: " + id.toString();
    }

    @Override
    public String updateMemberByID(UUID id, Member updateMember) {
        return getMemberByID(id)
                .map(member -> {
                    int indexOfMemberToUpdate = DB.indexOf(member);
                    if(indexOfMemberToUpdate >= 0){
                        DB.set(indexOfMemberToUpdate, new Member(id, updateMember.getName(),
                                updateMember.getPersonalID(), updateMember.getMajor(), updateMember.getSex(),
                                updateMember.getPhoto(), updateMember.getPhoneNumber(), updateMember.getRegisterDate(),
                                updateMember.getRegion(), updateMember.getMembershipID(), updateMember.getRegisterAddress(),
                                updateMember.getMainAddress(), updateMember.getEmail(), updateMember.getWorkContractID(),
                                updateMember.isDeclaration(), updateMember.getPenaltyID()));
                        return "NOTE: Update called on member with ID: " + id.toString();
                    }
                    return "NOTE: Update called on member with ID: " + id.toString() +
                            " BUT such member does NOT EXIST!";
                }).orElse("NOTE: Update NOT CALLED!");
    }
}
