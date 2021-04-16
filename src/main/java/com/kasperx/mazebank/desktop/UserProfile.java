package com.kasperx.mazebank.desktop;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2021-04-15
 * @description A model of user profile.
 */
public class UserProfile {
    private int userProfileId;
    private String forename;
    private String surname;
    private String idNumber;
    private boolean gender;
    private String birthday;
    private String username;
    private String password;
    private String email;
    private String tel;
    private String address1;
    private String address2;
    private String address3;

    public UserProfile(int userProfileId, String forename, String surname, String idNumber, boolean gender,
                       String birthday, String username, String password, String email, String tel,
                       String address1, String address2, String address3) {
        this.userProfileId = userProfileId;
        this.forename = forename;
        this.surname = surname;
        this.idNumber = idNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Override
    public java.lang.String toString() {
        return "UserProfile{" +
                "userProfileId=" + userProfileId +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                '}';
    }
}
