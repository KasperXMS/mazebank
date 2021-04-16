package com.kasperx.mazebank.desktop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2020-04-16
 * @description general model for account
 */
public class Account {
    private long accountNo;

    @JSONField(serialize = false)
    private String password;

    private double balance;
    private int checksum;
    private String availableDateTime;
    private int userProfileId;
    private boolean isSuspended;

    public Account(long accountNo, String password, int checksum, String availableDateTime, int userProfileId) {
        this.accountNo = accountNo;
        this.password = password;
        this.checksum = checksum;
        this.availableDateTime = availableDateTime;
        this.userProfileId = userProfileId;
        this.balance = 0.0;
        this.isSuspended = false;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public boolean setBalance(double balance) {
        if(!isSuspended){
            this.balance = balance;
            return true;
        }
        return false;
    }

    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    public String getAvailableDateTime() {
        return availableDateTime;
    }

    public void setAvailableDateTime(String availableDateTime) {
        this.availableDateTime = availableDateTime;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean deposit(double amount){
        return setBalance(balance + amount);
    }

    public boolean withdraw(double amount){
        if(balance - amount >= 0){
            return setBalance(balance - amount);
        }
        return false;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
