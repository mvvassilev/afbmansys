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
        PenaltyDao, MemFeeDao, MemberCourseDao {

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
        final String sql = "SELECT * FROM member WHERE region = ? ORDER BY id";

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

        jdbcTemplate.update(sql, id);

        return "Member deleted successfully!";
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
        final String sql = "INSERT INTO course (name, date, lector) values (?, ?, ?);";

        jdbcTemplate.update(sql, course.getName(), course.getDate(), course.getLector());

        return "Course added successfully";
    }

    @Override
    public String updateCourseByID(Course course, int id) {
        final String sql = "UPDATE course SET name = ?, date = ?, lector = ? WHERE id = ?";

        jdbcTemplate.update(sql, course.getName(), course.getDate(), course.getLector(), id);

        return "Course updated successfully!";
    }

    @Override
    public List<Course> getAllCoursesByMemberID(int memberID) {
        final String sql = "SELECT course.* FROM course, member WHERE memberid = ?;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(("id")));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String name = resultSet.getString("name");
            String lector = resultSet.getString("lector");

            return new Course(id, name, date, lector);
        });
    }

    @Override
    public List<Course> getAllCourses() {
        final String sql = "SELECT * FROM course ORDER BY id;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(("id")));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String name = resultSet.getString("name");
            String lector = resultSet.getString("lector");

            return new Course(id, name, date, lector);
        });
    }

    public Optional<Course> getCourseByID(int id) {
        final String sql = "SELECT * FROM course WHERE id = ?;";

        Course course = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String name = resultSet.getString("name");
            String lector = resultSet.getString("lector");

            return new Course(id, name, date, lector);
        });
        return Optional.ofNullable(course);
    }

    //##################################################################################################################
    // ####################################  A D D Q U A L I F I C A T I O N S  ########################################
    //##################################################################################################################

    @Override
    public String insertAddQualification(AddQualification addQualification) {
        final String sql = "INSERT INTO addqualification (degree, university, major, duration, memberid)" +
                "values (?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, addQualification.getDegree(), addQualification.getUniversity(),
                addQualification.getMajor(), addQualification.getDuration(), addQualification.getMemberID());

        return "Additional Qualification added successfully";
    }

    @Override
    public List<AddQualification> getAllAddQualifications() {
        final String sql = "SELECT * FROM addqualification ORDER BY id;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String degree = resultSet.getString("degree");
            String university = resultSet.getString("university");
            String major = resultSet.getString("major");
            String duration = resultSet.getString("duration");
            int memberID = Integer.parseInt(resultSet.getString("memberID"));

            return new AddQualification(id, degree, university, major, duration, memberID);
        });
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
        final String sql = "INSERT INTO coordinator (username, memberid, password, region)" +
                "values (?, ?, ?, ?);";

        jdbcTemplate.update(sql, coordinator.getUsername(), coordinator.getMemberID(), coordinator.getPassword(),
                coordinator.getRegion());

        return "Coordinator added successfully";
    }

    @Override
    public String updateCoordinatorByUsername(Coordinator coordinator, String username) {
        final String sql = "UPDATE coordinator SET password = ?, region = ? WHERE username = ?";

        jdbcTemplate.update(sql, coordinator.getPassword(), coordinator.getRegion(), username);

        return "Coordinator updated successfully!";
    }

    @Override
    public List<Coordinator> getAllCoordinators() {
        final String sql = "SELECT * FROM coordinator ORDER BY memberID;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String username = resultSet.getString("username");
            int memberID = Integer.parseInt(resultSet.getString("memberID"));
            String password = resultSet.getString("password");
            String region = resultSet.getString("region");

            return new Coordinator(username, memberID, password, region);
        });
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
        final String sql = "INSERT INTO diploma (degree, university, major, duration, memberid)" +
                "values (?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, diploma.getDegree(), diploma.getUniversity(), diploma.getMajor(),
                diploma.getDuration(), diploma.getMemberID());

        return "Diploma added successfully";
    }

    @Override
    public List<Diploma> getAllDiplomas() {
        final String sql = "SELECT * FROM diploma ORDER BY id;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String degree = resultSet.getString("degree");
            String university = resultSet.getString("university");
            String major = resultSet.getString("major");
            String duration = resultSet.getString("duration");
            int memberID = Integer.parseInt(resultSet.getString("memberID"));

            return new Diploma(id, degree, university, major, duration, memberID);
        });
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
        final String sql = "SELECT * FROM penalty ORDER BY id;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            Date startDate = null;
            try {
                startDate = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("startDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String name = resultSet.getString("name");
            String isCancelled = resultSet.getString("isCancelled");
            int memberID = Integer.parseInt(resultSet.getString("memberID"));

            return new Penalty(id, startDate, name, isCancelled, memberID);
        });
    }

    @Override
    public String insertPenalty(Penalty penalty) {
        final String sql = "INSERT INTO penalty (startDate, name, isCancelled, memberID) values (?, ?, ?, ?)";

        jdbcTemplate.update(sql, penalty.getStartDate(), penalty.getName(), penalty.getIsCancelled(),
                penalty.getMemberID());

        return "Penalty inserted successfully!";
    }

    //##################################################################################################################
    //##############################################    M E M F E E     ################################################
    //##################################################################################################################

    @Override
    public List<MemFee> getAllMemFees() {
        final String sql = "SELECT * FROM memfee ORDER BY id;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String type = resultSet.getString("type");
            String year = resultSet.getString("year");
            int memberID = Integer.parseInt(resultSet.getString("memberID"));

            return new MemFee(id, type, year, memberID);
        });
    }

    @Override
    public List<MemFee> getAllMemFeesForMember(int memberID) {
        final String sql = "SELECT * FROM memfee WHERE memberID = ?";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String type = resultSet.getString("type");
            String year = resultSet.getString("year");

            return new MemFee(id, type, year, memberID);
        });
    }

    @Override
    public String insertMemFee(MemFee memFee) {
        final String sql = "INSERT INTO memfee (type, year, memberID) values (?, ?, ?)";

        jdbcTemplate.update(sql, memFee.getType(), memFee.getYear(), memFee.getMemberID());

        return "MemFee inserted successfully!";
    }

    @Override
    public String updateLastFeeForMember(MemFee memFee, int memberID) {
        return null;
    }

    //##################################################################################################################
    //#######################################    M E M B E R C O U R S E     ###########################################
    //##################################################################################################################

    @Override
    public List<MemberCourse> getAllMembersInCourse(int courseID) {
        final String sql = "SELECT * FROM membercourse WHERE courseID = ?";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int memberID = Integer.parseInt(resultSet.getString("memberID"));

            return new MemberCourse(memberID, courseID);
        });
    }

    @Override
    public List<MemberCourse> getAllCoursesForMember(int memberID) {
        final String sql = "SELECT * FROM membercourse WHERE memberID = ?";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int courseID = Integer.parseInt(resultSet.getString("courseID"));

            return new MemberCourse(memberID, courseID);
        });
    }

    @Override
    public String insertMemberCourse(MemberCourse memberCourse) {
        final String sql = "INSERT INTO membercourse (memberID, courseID) values (?, ?)";

        jdbcTemplate.update(sql, memberCourse.getMemberID(), memberCourse.getCourseID());

        return "MemberCourse inserted successfully!";
    }
}
