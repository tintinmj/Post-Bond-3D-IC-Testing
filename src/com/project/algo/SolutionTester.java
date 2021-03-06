/*
 * Copyright 2015 tintinmj.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.project.algo;

import com.project.model.Die;
import com.project.model.IC3DStack;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tintinmj
 */
public class SolutionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Die> dies = new ArrayList<>();
        
        dies.add(new Die(30, 2608870, "D1"));
        dies.add(new Die(25, 2743317, "D2"));
        dies.add(new Die(25, 1333098, "D3"));
        dies.add(new Die(20,  700665, "D4"));
        dies.add(new Die(15,  106391, "D5"));
        
        OurSolution solution = new OurSolution(dies);
        OurSolution.TSV_MAX = 70;
        solution.solve();
        System.out.println("Total Test Cycle : " + solution.totalTestCycle);
        System.out.println(IC3DStack.getStackDescription());
    }
    
}
