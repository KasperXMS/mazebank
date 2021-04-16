package com.kasperx.mazebank.desktop;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Kasper Sergeievic
 */
@Mapper
public interface TransactionMapper {
    @Select("SELECT * FROM TRANSACTIONS")
    List<Transactions> getAllTransactions();

    @Select("SELECT * FROM TRANSACTIONS WHERE srcAccountNo=#{accNo}")
    List<Transactions> getTransactionsFromAccount(long accNo);

    @Select("SELECT * FROM TRANSACTIONS WHERE destAccountNo=#{accNo}")
    List<Transactions> getTransactionsToAccount(long accNo);

    @Insert("INSERT INTO TRANSACTIONS(srcAccountNo, destAccountNo, amount, time, type, location, comment) " +
            "VALUES (#{srcAccountNo}, #{destAccountNo}, #{amount}, #{time}, #{type}, #{location}, #{comment})")
    void addTransaction(Transactions t);
}
