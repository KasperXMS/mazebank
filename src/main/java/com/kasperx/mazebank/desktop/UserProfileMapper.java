package com.kasperx.mazebank.desktop;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2021-04-16
 * @description Mapping CRUD options of user profiles.
 */
@Mapper
public interface UserProfileMapper {

    /**
     * retrieve all users' profiles
     * @return List of UserProfile objects
     */
    @Select("SELECT * FROM USER_PROFILE")
    List<UserProfile> getAllUsers();

    /**
     * retrieve user profile by its identifier code
     * @param id user profile od
     * @return single UserProfile object
     */
    @Select("SELECT * FROM USER_PROFILE WHERE userProfileId=#{id}")
    UserProfile getUserById(int id);

    /**
     * Search user profile by name. For administrators only.
     * @param fname forename
     * @param sname surname
     * @return list of UserProfile objects
     */
    @Select("SELECT * FROM USER_PROFILE WHERE Forename=#{fname} and Surname=#{sname}")
    List<UserProfile> getUsersByName(String fname, String sname);

    /**
     * authorize login by username and password.
     * @param username username
     * @param password password
     * @return UserProfile object if correct or null.
     */
    @Select("SELECT * FROM USER_PROFILE WHERE username=#{username} AND password=password(#{password})")
    UserProfile authLoginByUsername(String username, String password);

    /**
     * authorize login by telephone number and password
     * @param tel phone number
     * @param password password
     * @return UserProfile object if correct or null.
     */
    @Select("SELECT * FROM USER_PROFILE WHERE tel=#{tel} AND password=password(#{password})")
    UserProfile authLoginByTelNumber(String tel, String password);

    /**
     * Add new user profile to database
     * @param up UserProfile object
     */
    @Insert("INSERT INTO USER_PROFILE (Forename, Surname, idNumber, gender, birthday, username, password, email, " +
            "tel, address1, address2, address3) VALUES (#{forename}, #{surname}, #{idNumber}, #{gender}, #{birthday}," +
            " #{username}, password(#{password}), #{email}, #{tel}, #{address1}, #{address2}, #{address3})")
    void addNewUser(UserProfile up);

    /**
     * After a successful login, a unique sessionId is created for a user and load to database.
     * @param sessionId session id generated
     * @param userId user profile id
     */
    @Insert("INSERT INTO SESSION (sessionId, userId) VALUES (#{sessionId}, #{userId})")
    void addNewSession(int sessionId, int userId);

    /**
     * if the user is in in online status, the session id will be updated
     * so that only most recent logged user can access
     * @param sessionId session id generated
     * @param userId user profile id
     */
    @Update("UPDATE SESSION SET sessionId=#{sessionId} WHERE userId=#{userId}")
    void updateSession(int sessionId, int userId);

    /**
     * Check if user is online
     * @param userId user profile id
     * @return session id that just used
     */
    @Select("SELECT COUNT(sessionId) FROM SESSION WHERE userId=#{userId}")
    int checkSessionIdGet(int userId);
}