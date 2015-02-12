/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.algo;

import com.project.model.Die;
import java.util.List;

/**
 *
 * @author tintinmj
 */
public interface ISolver {
    public void solve(List<Die> dies, final int maxTestPins, final int maxTSV);
}
