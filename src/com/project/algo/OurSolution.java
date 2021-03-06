/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.algo;

import com.project.model.Die;
import com.project.model.DieTestCycleComparator;
import com.project.model.Layer;
import com.project.model.IC3DStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tintinmj
 */
public class OurSolution {
    
    public List<Die> availableDies;
    public static int TSV_MAX;
    public int totalTestCycle = 0;
    
    // when taking dynamic input use this constructor
    public OurSolution(){
        availableDies = new ArrayList<>();
        takeInputDie();
    }
    
    // when hardcoding input use this constructor
    public OurSolution(List<Die> availableDies) {
        this.availableDies = availableDies;
    }
    
    private void takeInputDie() {
        // console reader
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Maximum TSV : ");
        TSV_MAX = Integer.parseInt(sc.nextLine());
        System.out.println("No of dies : ");
        int noOfDies = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < noOfDies; i++) {
            System.out.println("Serial no : ");
            String serialNo = sc.nextLine();
            System.out.println(serialNo + "'s TSV : ");
            int TSV = Integer.parseInt(sc.nextLine());
            System.out.println(serialNo + "'s test cycle : ");
            int testCycle = Integer.parseInt(sc.nextLine());
            
            Die d = new Die(TSV, testCycle, serialNo);
            availableDies.add(d);
        }
    }
    
    
    public void solve() {
        solve(availableDies);
    }
    
    
    private void solve(List<Die> dies) {
        // sort the dies with respect to test cycles
        Collections.sort(dies, new DieTestCycleComparator());
        
        // logic for first layer
        Layer firstlayer = new Layer();
        int i = 0;
        int tempTSV = 0;
        
        // In first layer, we are placing the dies in one go, with out seperately
        // testing them.
        while(i < dies.size() && // if there are dies
                // check if after taking next die it satisfies
                // the maximum tsv constraint
                (tempTSV + dies.get(i).getTSV() <= TSV_MAX)) {
            
            // calculate the tsv
            tempTSV = tempTSV + dies.get(i).getTSV(); 
            
            // place the die in layer
            firstlayer.addDie(dies.get(i));
            
            // go to next die
            i++;
        }
        
        // update total test cycle
        totalTestCycle = firstlayer.getMaxTestCycle();
        
        
        IC3DStack.addLayer(firstlayer);
        
        
        // logic for upper layer stack
        while(i < dies.size()) {
            
            // make a new layer
            Layer currentLayer = new Layer();
            tempTSV = 0;
            
            // check if after taking next die it satisfies
            // the maximum tsv constraint
            while(i < dies.size() && 
                    (tempTSV + dies.get(i).getTSV() <= TSV_MAX)) {
                
                // calculate the tsv
                tempTSV = tempTSV + dies.get(i).getTSV(); 
                
                // place the current die into the layer
                currentLayer.addDie(dies.get(i));
                
                // get the cumulative test cycle
                int totalPreviousLayersTestCycle = 
                        IC3DStack.getCumulativeTestCycle();
                
                // add the maximum test cycle of current layer with the
                // cumulative test cycles of previous layers
                // and then add it with the total test cycle
                totalTestCycle += 
                        totalPreviousLayersTestCycle + currentLayer.getMaxTestCycle();
                
                i++;
            }
            
            // add the current layer to the stack
            IC3DStack.addLayer(currentLayer);
        }
    }
}
