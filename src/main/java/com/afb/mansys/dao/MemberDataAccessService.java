package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class MemberDataAccessService implements MemberDao {
    @Override
    public String insertMember(UUID id, Member member) {
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public Optional<Member> getMemberByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public String deleteMember(UUID id) {
        return null;
    }

    @Override
    public String updateMemberByID(UUID id, Member member) {
        return null;
    }
}
