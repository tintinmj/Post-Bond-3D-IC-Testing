/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author tintinmj
 */
public class Layers {
    private Deque<Layer> layerStack;
    
    public Layers(Deque<Layer> layer) {
        this.layerStack = layer;
    }

    public Layers() {
        layerStack = new ArrayDeque<>();
    }
    
    public Deque<Layer> getAllLayers() {
        return this.layerStack;
    }

    public void addLayer(Layer layer) {
        layerStack.push(layer);
    }
}
