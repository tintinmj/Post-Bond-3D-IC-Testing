/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tintinmj
 */
public class Layer {
    private List<Die> dies;
    
    public Layer(List<Die> Dies) {
        this.dies = Dies;
    }
    
    public Layer() {
        dies = new ArrayList<>();
    }
    
    public void addDie(Die d) {
        dies.add(d);
    }
    
    public Die getDie(int dieIndex) {
        return dies.get(dieIndex);
    }
    
    public int getMaxTestCycle() {
        Die d = Collections.max(dies, new DieTestCycleComparator());
        return d.getTestCycle();
    }
    
    public int getTotalTSV() {
        int totalTSV = 0;
        for(Die d : dies) {
            totalTSV += d.getTSV();
        }
        return totalTSV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.dies);
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
        final Layer other = (Layer) obj;
        if (!Objects.equals(this.dies, other.dies)) {
            return false;
        }
        return true;
    }
}
