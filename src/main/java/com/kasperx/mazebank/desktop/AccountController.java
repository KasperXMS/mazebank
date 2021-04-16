package com.kasperx.mazebank.desktop;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2020-04-16
 * @description mapping requests for account operation
 */
@RestController
public class AccountController {

    @Autowired
    AccountMapper am;

    @Autowired
    TransactionMapper tm;

    @GetMapping("/getCurrentAccountByNo")
    public String getCurrentAccountByNo(@RequestParam long accountNo){
        Account acc = am.getCurrentAccountByAccountNo(accountNo);
        return acc.toString();
    }

    @GetMapping("/getCreditAccountByNo")
    public String getCreditAccountByNo(@RequestParam long accountNo){
        CreditAccount acc = am.getCreditAccountByAccountNo(accountNo);
        return acc.toString();
    }

    @GetMapping("/getAllAccountListByUser")
    public String getAllAccountListByUser(@RequestParam int userId){
        List<Account> currentList = am.getCurrentAccountListByUser(userId);
        List<CreditAccount> creditList = am.getCreditAccountListByUser(userId);
        return JSON.toJSONString(currentList) +
                JSON.toJSONString(creditList);
    }

    @PostMapping("/addNewCurrentAccount")
    public void addNewCurrentAccount(@RequestParam long accountNo, @RequestParam String password,
                                     @RequestParam int checksum, @RequestParam String availableDateTime,
                                     @RequestParam int userProfileId){
        Account acc = new Account(accountNo, password, checksum, availableDateTime, userProfileId);
        am.addNewCurrentAccount(acc);
    }

    @PostMapping("/addNewCreditAccount")
    public void addNewCreditAccount(@RequestParam long accountNo, @RequestParam String password,
                                     @RequestParam int checksum, @RequestParam String availableDateTime,
                                     @RequestParam int userProfileId){
        CreditAccount acc = new CreditAccount(accountNo, password, checksum, availableDateTime, userProfileId);
        am.addNewCreditAccount(acc);
    }

    @PutMapping("/depositCurrent")
    public boolean depositCurrent(@RequestParam long accountNo, @RequestParam double amount, @RequestParam int type,
                               @RequestParam int location, @RequestParam String comment){
        Account acc = am.getCurrentAccountByAccountNo(accountNo);
        boolean isSuccessful = acc.deposit(amount);
        if(isSuccessful){
            Transactions t = new Transactions(location, acc.getAccountNo(), amount,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), type, location, comment);
            tm.addTransaction(t);
            am.setCurrentAccountBalance(acc.getAccountNo(), acc.getBalance());
        }
        return isSuccessful;
    }
}
