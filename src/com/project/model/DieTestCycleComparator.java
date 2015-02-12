/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.util.Comparator;

/**
 *
 * @author tintinmj
 */
public class DieTestCycleComparator implements Comparator<Die> {

    @Override
    public int compare(Die first, Die second) {
        // compareTo should return -1 if `first` is supposed to be
        // less than `second`, 1 if `first` is supposed to be greater than 
        // `second` and 0 if they are supposed to be equal
        int firstTestCycle = first.getTestCycle();
        int secondTestCycle = second.getTestCycle();
        
        if (firstTestCycle > secondTestCycle) {
            return 1;
        }
        else if (firstTestCycle == secondTestCycle) {
            return 0;
        }
        
        else
            return -1;
    }
    
}
