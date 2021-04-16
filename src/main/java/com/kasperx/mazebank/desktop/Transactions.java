package com.kasperx.mazebank.desktop;

import com.alibaba.fastjson.JSON;

/**
 * @author Kasper Sergeievic
 */
public class Transactions {
    private int transactonId;
    private long srcAccountNo;
    private long destAccountNo;
    private double amount;
    private String time;
    private int type;
    private int location;
    private String comment;

    public Transactions(long srcAccountNo, long destAccountNo, double amount, String time,
                        int type, int location, String comment) {
        this.transactonId = 1;
        this.srcAccountNo = srcAccountNo;
        this.destAccountNo = destAccountNo;
        this.amount = amount;
        this.time = time;
        this.type = type;
        this.location = location;
        this.comment = comment;
    }

    public int getTransactonId() {
        return transactonId;
    }

    public void setTransactonId(int transactonId) {
        this.transactonId = transactonId;
    }

    public long getSrcAccountNo() {
        return srcAccountNo;
    }

    public void setSrcAccountNo(long srcAccountNo) {
        this.srcAccountNo = srcAccountNo;
    }

    public long getDestAccountNo() {
        return destAccountNo;
    }

    public void setDestAccountNo(long destAccountNo) {
        this.destAccountNo = destAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
