package com.afb.mansys.dao;

import com.afb.mansys.model.Member;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemberDao {
    /**
     * TODO: Member methods:
     * insert a member
     * update a member
     * delete a member
     */

    String insertMember(Member member);

    List<Member> getAllMembers();

    Optional<Member> getMemberByID(int id);

    String deleteMember(int id);

    String updateMemberByID(int id, Member member);
}
