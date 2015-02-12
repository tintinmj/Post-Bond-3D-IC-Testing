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
public class Layers {
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
}
