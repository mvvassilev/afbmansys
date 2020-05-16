package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.util.List;
import java.util.Optional;

public interface MemberDao {

    String insertMember(Member member);

    List<Member> getAllMembers();

    Optional<Member> getMemberByID(int id);

    String deleteMember(int id);

    String updateMemberByID(int id, Member member);

    List<Member> getMembersInRegion(String region); //TODO
}
