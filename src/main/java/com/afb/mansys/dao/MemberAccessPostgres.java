package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class MemberAccessPostgres implements MemberDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberAccessPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String insertMember(Member member) {
        final String sql = "INSERT INTO member(name, personalID, major, sex, photo, phoneNumber, registerDate, region, " +
                "membershipID, registerAddress, mainAddress, workAddress, email, workContractID, declaration, penaltyID) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

        jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getSex(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getMembershipID(), member.getRegisterAddress(), member.getMainAddress(), member.getWorkAddress(),
                member.getEmail(), member.getWorkContractID(), member.isDeclaration(), member.getPenaltyID());

        return "Member added successfully";
    }

    @Override
    public List<Member> getAllMembers() {
        final String sql = "SELECT * FROM member";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String sex = resultSet.getString("sex");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String region = resultSet.getString("region");
            String membershipID = resultSet.getString("membershipID");
            String registerAddress = resultSet.getString("registerAddress");
            String mainAddress = resultSet.getString("mainAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            boolean declaration = Boolean.parseBoolean(resultSet.getString("declaration"));
            String penaltyID = resultSet.getString("penaltyID");

            return new Member(id, name, personalID, major, sex, photo, phoneNumber, registerDate, region,
                    membershipID, registerAddress, mainAddress, workAddress, email, workContractID,
                    declaration, penaltyID);
        });
    }

    @Override
    public Optional<Member> getMemberByID(int id) {
        final String sql = "SELECT * FROM member WHERE id = ?";
        Member member = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int memberID = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String sex = resultSet.getString("sex");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String region = resultSet.getString("region");
            String membershipID = resultSet.getString("membershipID");
            String registerAddress = resultSet.getString("registerAddress");
            String mainAddress = resultSet.getString("mainAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            boolean declaration = Boolean.parseBoolean(resultSet.getString("declaration"));
            String penaltyID = resultSet.getString("penaltyID");

            return new Member(memberID, name, personalID, major, sex, photo, phoneNumber, registerDate, region,
                    membershipID, registerAddress, mainAddress, workAddress, email, workContractID,
                    declaration, penaltyID);
        });
        return Optional.ofNullable(member);
    }

    @Override
    public String deleteMember(int id) {
        return null;
    }

    @Override
    public String updateMemberByID(int id, Member member) {
        return null;
    }
}
