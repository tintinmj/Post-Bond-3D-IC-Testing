/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.util.Objects;

/**
 *
 * @author tintinmj
 */
public class Die {
    
    private String serialNo;
    private int TSV;
    private int testCycle;

    public Die(int TSV, int testCycle, String serialNo) {
        this.TSV = TSV;
        this.testCycle = testCycle;
        this.serialNo = serialNo;
    }

    public int getTestCycle() {
        return testCycle;
    }

    public void setTestCycle(int testCycle) {
        this.testCycle = testCycle;
    }

    public int getTSV() {
        return TSV;
    }

    public void setTSV(int TSV) {
        this.TSV = TSV;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return serialNo + " : " + TSV + " : " + testCycle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.serialNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Die other = (Die) obj;
        return Objects.equals(this.serialNo, other.serialNo);
    }    
}
