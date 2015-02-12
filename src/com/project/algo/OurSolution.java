/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.algo;

import com.project.model.Constant;
import com.project.model.Die;
import com.project.model.DieTestCycleComparator;
import com.project.model.Layer;
import com.project.model.Layers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tintinmj
 */
public class OurSolution {
    
    public Layer layer;
    public Layers layers;
    public List<Die> allDies;
    
    public int totalTestCycle = 0;
    public int layerTestCycle = 0;
    
    public OurSolution(){
        this.layer = new Layer();
        this.layers = new Layers();
    }
    
    public void takeInputDie() {
        // console reader
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Maximum TSV : ");
        Constant.TSV_MAX = Integer.parseInt(sc.nextLine());
        System.out.println("No of dies : ");
        int noOfDies = Integer.parseInt(sc.nextLine());
        
        
        allDies = new ArrayList<>();
        
        for(int i = 0; i < noOfDies; i++) {
            System.out.println("Serial no : ");
            String serialNo = sc.nextLine();
            System.out.println(serialNo + "'s TSV : ");
            int TSV = Integer.parseInt(sc.nextLine());
            System.out.println(serialNo + "'s test cycle : ");
            int testCycle = Integer.parseInt(sc.nextLine());
            
            Die d = new Die(TSV, testCycle, serialNo);
            allDies.add(d);
        }
    }
    
    public void solve() {
        // sort the dies with respect to test cycles
        Collections.sort(allDies, new DieTestCycleComparator());
        
        // logic for first layer
        Layer firstlayer = new Layer();
        int i = 0;
        int tempTSV = 0;
        int maxTimeCycle = Integer.MIN_VALUE;
        while(i < allDies.size() && // if there are dies
                // check if after taking next pin it satisfies
                // the maximum tsv constraint
                (tempTSV + allDies.get(i).getTSV() <= Constant.TSV_MAX)) {
            
            // calculate the tsv
            tempTSV = tempTSV + allDies.get(i).getTSV(); 
            
            // get the maximum test cycle
            if(maxTimeCycle <= allDies.get(i).getTestCycle()) {
                maxTimeCycle = allDies.get(i).getTestCycle();
            }
            
            i++;
        }
    }
}
