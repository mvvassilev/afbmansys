package com.afb.mansys.dao;

import com.afb.mansys.model.Diploma;
import com.afb.mansys.model.Member;
import org.postgresql.PGConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        final String sql = "INSERT INTO member(name, personalid, major, gender, photo, phonenumber, " +
                " registerdate, region, registeraddress, currentaddress, workaddress," +
                " email, workcontractid, declaration) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?);";

        jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getGender(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getRegisterAddress(), member.getCurrentAddress(), member.getWorkAddress(),
                member.getEmail(), member.getWorkContractID(), member.isDeclaration());

        return "Member added successfully";
    }

    @Override
    public List<Member> getAllMembers() {
        final String sql = "SELECT * FROM member ORDER BY id";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String gender = resultSet.getString("gender");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String region = resultSet.getString("region");
            String registerAddress = resultSet.getString("registerAddress");
            String currentAddress = resultSet.getString("currentAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            String declaration = resultSet.getString("declaration");

            return new Member(id, name, personalID, major, gender, photo, phoneNumber, registerDate, region,
                    registerAddress, currentAddress, declaration, workAddress, email, workContractID);
        });
    }

    /**
     * @param region
     * @return All the members in a specific region
     */
    @Override
    public List<Member> getMembersInRegion(String region) {
        final String sql = "SELECT * FROM member WHERE region = '?' ORDER BY id";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String gender = resultSet.getString("gender");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String registerAddress = resultSet.getString("registerAddress");
            String currentAddress = resultSet.getString("currentAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            String declaration = resultSet.getString("declaration");

            return new Member(id, name, personalID, major, gender, photo, phoneNumber, registerDate, region,
                    registerAddress, currentAddress, declaration, workAddress, email, workContractID);
        });
    }

    @Override
    public Optional<Member> getMemberByID(int id) {
        final String sql = "SELECT * FROM member WHERE id = ?";
        Member member = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String gender = resultSet.getString("gender");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String region = resultSet.getString("region");
            String registerAddress = resultSet.getString("registerAddress");
            String currentAddress = resultSet.getString("currentAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            String declaration = resultSet.getString("declaration");

            return new Member(id, name, personalID, major, gender, photo, phoneNumber, registerDate, region,
                    registerAddress, currentAddress, declaration, workAddress, email, workContractID);
        });
        return Optional.ofNullable(member);
    }

    @Override
    public String deleteMember(int id) {

        final String sql = "DELETE FROM member WHERE id = ?";

        Member member = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            String personalID = resultSet.getString("personalID");
            String major = resultSet.getString("major");
            String gender = resultSet.getString("gender");
            String photo = resultSet.getString("photo");
            String phoneNumber = resultSet.getString("phoneNumber");

            Date registerDate = null;
            try {
                registerDate = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("registerDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String region = resultSet.getString("region");
            String registerAddress = resultSet.getString("registerAddress");
            String currentAddress = resultSet.getString("currentAddress");
            String workAddress = resultSet.getString("workAddress");
            String email = resultSet.getString("email");
            String workContractID = resultSet.getString("workContractID");
            String declaration = resultSet.getString("declaration");

            return new Member(id, name, personalID, major, gender, photo, phoneNumber, registerDate, region,
                    registerAddress, currentAddress, declaration, workAddress, email, workContractID);
        });

        jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getGender(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getRegisterAddress(), member.getCurrentAddress(), member.getWorkAddress(), member.getEmail(),
                member.getWorkContractID(), member.isDeclaration(), id);

        return "Member deleted successfully!";
    }

    @Override
    public String updateMemberByID(int id, Member member) {
        final String sql = "UPDATE member SET name = ?, personalID = ?, major = ?, gender = ?, " +
                "photo = ?, phonenumber = ?, registerdate = ?, region = ?," +
                "registeraddress = ?, currentaddress = ?, workaddress = ?, email = ?," +
                "workcontractid = ?, declaration = ? WHERE id = ?";

        int rows = jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getGender(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getRegisterAddress(), member.getCurrentAddress(), member.getWorkAddress(), member.getEmail(),
                member.getWorkContractID(), member.isDeclaration(), id);

        System.out.println("Member updated successfully! Deleted rows " + Integer.toString(rows));
        return "Member updated successfully! Deleted rows " + Integer.toString(rows);
    }
}
