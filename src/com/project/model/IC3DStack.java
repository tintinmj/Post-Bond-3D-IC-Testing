/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tintinmj
 */
public final class IC3DStack {
    private static List<Layer> layerStack = new ArrayList<>();
    
    public static List<Layer> getAllLayers() {
        return layerStack;
    }

    public static void addLayer(Layer layer) {
        layerStack.add(layer);
    }
    
    public static Layer getTopLayer() {
        return layerStack.get(layerStack.size() - 1);
    }
    
    public static Layer getBottomLayer() {
        return layerStack.get(0);
    }
    
    public static Layer getPreviousLayer(Layer currentLayer) {
        // first layer so return it
        if(getBottomLayer().equals(currentLayer)) {
            return currentLayer;
        }
        
        Layer l = null;
        for(int i = 1; i < layerStack.size(); i++) {
            if(layerStack.get(i).equals(currentLayer)) {
                l = layerStack.get(i - 1);
            }
        }
        return l;
    }
    
    public static int getCumulativeTestCycle() {
        int total = 0;
        for(Layer l : layerStack) {
            total += l.getMaxTestCycle();
        }
        return total;
    }

    public static String getStackDescription() {
        StringBuilder sb = new StringBuilder();
        
        for(int i = layerStack.size() - 1; i >= 0; i--) {
            sb.append(layerStack.get(i).toString());
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
