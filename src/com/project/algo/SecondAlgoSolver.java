/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.project.algo;
//
//import com.project.model.Die;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
///**
// *
// * @author tintinmj
// */
//public final class SecondAlgoSolver implements ISolver {
//
//    @Override
//    public void solve(List<Die> dies, int maxTestPins, int maxTSV) {
//        int testLength = 0;
//        for (int dieNo = 2; dieNo < dies.size(); dieNo++) {
//            int partialStackTestTime = 0;
//            List<Die> chosenDies = new ArrayList<>();
//            
//            for(int i = 1; i<= dieNo; i++) {
//                chosenDies.add(dies.get(i));
//            }
//            
//            while (!chosenDies.isEmpty()) {
//                boolean assign = false;
//                int maxTestLength = 0;
//                
//                if(sumOfTestPins(chosenDies) <= maxTestPins) {
//                    assign = TSVCheck(chosenDies);
//                    
//                    if(assign) {
//                        maxTestLength = Collections.max(chosenDies, new Comparator<Die>() {
//                            
//                            // compare dies with respect to the cycles
//Collections.max(chosenDies, new Comparator<Die>() {
//                            
//                            // compare dies with respect to the cycles
//                            @Override
//                            public int compare(Die first, Die second) {
//                                if (first.getTestCycle() > second.getTestCycle())
//                                    return 1;
//                                else if (first.getTestCycle() < second.getTestCycle())
//                                    return -1;
//                                else
//                                    return 0;
//                            }
//                            
//                        }).getTestCycle();
//                    }
//                    chosenDies.clear();
//                }
//                
//                else {
//                    
//                }
//            }
//        }
//    }
//    
//    // not completed
//    private boolean TSVCheck(List<Die> dies) {
//        boolean canAssign = false;
//        int TSV = 0;
//        
//        List<Die> tempDies = new ArrayList<>();
//        return false;
//    }
//    
//    private int sumOfTestPins(List<Die> dies) {
//        int total = 0;
//        for (Die die : dies) {
//            total += die.getTSV();
//        }
//        return total;
//    }
//    
//}
