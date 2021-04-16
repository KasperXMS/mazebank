package com.kasperx.mazebank.desktop;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2020-04-16
 * @description mapping CRUD operations on accounts
 */
@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM CREDIT_ACCOUNT")
    List<CreditAccount> getAllCreditAccount();

    @Select("SELECT * FROM CURRENT_ACCOUNT")
    List<Account> getAllCurrentAccount();

    @Select("SELECT * FROM CURRENT_ACCOUNT WHERE userProfileId=#{userId}")
    List<Account> getCurrentAccountListByUser(int userId);

    @Select("SELECT * FROM CREDIT_ACCOUNT WHERE userProfileId=#{userId}")
    List<CreditAccount> getCreditAccountListByUser(int userId);

    @Select("SELECT * FROM CURRENT_ACCOUNT WHERE accountNo=#{accountNo}")
    Account getCurrentAccountByAccountNo(long accountNo);

    @Select("SELECT * FROM CREDIT_ACCOUNT WHERE accountNo=#{accountNo}")
    CreditAccount getCreditAccountByAccountNo(long accountNo);

    @Insert("INSERT INTO CURRENT_ACCOUNT (accountNo, password, balance, checksum, availableDateTime," +
            " userProfileId, isSuspended) VALUES (#{accountNo}, password(#{password}), #{balance}, #{checksum}," +
            " #{availableDateTime}, #{userProfileId}, #{isSuspended})")
    void addNewCurrentAccount(Account acc);

    @Insert("INSERT INTO CREDIT_ACCOUNT (accountNo, password, balance, checksum, overdraftLimit, " +
            "availableDateTime, userProfileId, isSuspended) VALUES (#{accountNo}, password(#{password}), " +
            "#{balance}, #{checksum}, #{overdraftLimit}, #{availableDateTime}, #{userProfileId}, #{isSuspended})")
    void addNewCreditAccount(Account acc);

    @Update("UPDATE CURRENT_ACCOUNT SET balance=#{balance} WHERE accountNo=#{accountNo}")
    void setCurrentAccountBalance(long accountNo, double balance);

    @Update("UPDATE CREDIT_ACCOUNT SET balance=#{balance} WHERE accountNo=#{accountNo}")
    void setCreditAccountBalance(long accountNo, double balance);
}
