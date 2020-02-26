package com.afb.mansys.dao;

import com.afb.mansys.model.Member;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MemberDao {
    /**
     * TODO: Member methods:
     * insert a member
     * update a member
     * delete a member
     */

    String insertMember(UUID id, Member member);

    default String insertMember(Member member){
        UUID id = UUID.randomUUID(); //TODO: auto increment
        return insertMember(id, member);
    }

    List<Member> getAllMembers();
}
