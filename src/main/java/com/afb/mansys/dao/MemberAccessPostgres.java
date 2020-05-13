package com.afb.mansys.dao;

import com.afb.mansys.model.*;
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
public class MemberAccessPostgres implements MemberDao, CourseDao, AddQualificationDao, CoordinatorDao, DiplomaDao,
        PenaltyDao, MemFeeDao, MemberCourseDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberAccessPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //##################################################################################################################
    //########################################     M E M B E R    ######################################################
    //##################################################################################################################

    /**
     * Inserts a new member to the database
     *
     * @param member
     * @return a message "Member added successfully"
     */
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

    /**
     * Get all members from the database
     *
     * @return the list of members
     */
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
     * Gets all members from a region
     *
     * @param region
     * @return The list of members from that region
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

    /**
     * Gets the member with the provided ID
     *
     * @param id
     * @return A member with the provided ID or null
     */
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

    /**
     * Deletes a row from the member database with the provided ID
     *
     * @param id
     * @return A message saying "Member updated successfully! Deleted rows 1"
     */
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

        int rows = jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getGender(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getRegisterAddress(), member.getCurrentAddress(), member.getWorkAddress(), member.getEmail(),
                member.getWorkContractID(), member.isDeclaration(), id);

        System.out.println("Member updated successfully! Deleted rows " + Integer.toString(rows));
        return "Member updated successfully! Deleted rows " + Integer.toString(rows);
    }

    /**
     * Updates a row in the member database to the new member object
     *
     * @param id
     * @param member
     * @return A message saying "Member updated successfully!"
     */
    @Override
    public String updateMemberByID(int id, Member member) {
        final String sql = "UPDATE member SET name = ?, personalID = ?, major = ?, gender = ?, " +
                "photo = ?, phonenumber = ?, registerdate = ?, region = ?," +
                "registeraddress = ?, currentaddress = ?, workaddress = ?, email = ?," +
                "workcontractid = ?, declaration = ? WHERE id = ?";

        jdbcTemplate.update(sql, member.getName(), member.getPersonalID(), member.getMajor(), member.getGender(),
                member.getPhoto(), member.getPhoneNumber(), member.getRegisterDate(), member.getRegion(),
                member.getRegisterAddress(), member.getCurrentAddress(), member.getWorkAddress(), member.getEmail(),
                member.getWorkContractID(), member.isDeclaration(), id);

        return "Member updated successfully!";
    }

    //##################################################################################################################
    // ############################################  C O U R S E  ######################################################
    //##################################################################################################################

    @Override
    public String insertCourse(Course course) {
        return null;
    }

    @Override
    public String updateCourseByID(Course course, int id) {
        return null;
    }

    @Override
    public List<Course> getAllCoursesByMemberID(int memberID) {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    //##################################################################################################################
    // ####################################  A D D Q U A L I F I C A T I O N S  ########################################
    //##################################################################################################################

    @Override
    public String insertAddQualification(AddQualification diploma) {
        return null;
    }

    @Override
    public List<AddQualification> getAllAddQualifications() {
        return null;
    }

    @Override
    public Optional<AddQualification> getAddQualificationForMember(int memberID) {
        return Optional.empty();
    }

    //##################################################################################################################
    // ##########################################  C O O R D I N A T O R  ##############################################
    //##################################################################################################################

    @Override
    public String insertCoordinator(Coordinator coordinator) {
        return null;
    }

    @Override
    public String updateCoordinatorByUsername(Coordinator coordinator, String username) {
        return null;
    }

    @Override
    public List<Coordinator> getAllCoordinators() {
        return null;
    }

    @Override
    public Boolean isCoordinator(String username, String password) {
        return null;
    }

    //##################################################################################################################
    //#############################################    D I P L O M A    ################################################
    //##################################################################################################################

    @Override
    public String insertDiploma(Diploma diploma) {
        return null;
    }

    @Override
    public List<Diploma> getAllDiplomas() {
        return null;
    }

    @Override
    public Optional<Diploma> getDiplomaForMember(int memberID) {
        return Optional.empty();
    }

    //##################################################################################################################
    //############################################     P E N A L T Y     ###############################################
    //##################################################################################################################

    @Override
    public List<Penalty> getPenaltiesForMember(int memberID) {
        return null;
    }

    @Override
    public List<Penalty> getAllPenalties() {
        return null;
    }

    //##################################################################################################################
    //##############################################    M E M F E E     ################################################
    //##################################################################################################################

    @Override
    public List<MemFee> getAllMemFees() {
        return null;
    }

    @Override
    public List<MemFee> getAllMemFeesForMember(int memberID) {
        return null;
    }

    //##################################################################################################################
    //#######################################    M E M B E R C O U R S E     ###########################################
    //##################################################################################################################

    @Override
    public List<MemberCourse> getAllMembersInCourse(int courseID) {
        return null;
    }

    @Override
    public List<MemberCourse> getAllCoursesForMember(int memberID) {
        return null;
    }
}
