/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.odc.falsepositives;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeremy
 */
public class AutoObjectTest {

    /**
     * Test of close method, of class AutoObject.
     */
    @Test
    public void testClose() throws Exception {
        try (AutoObject instance = new AutoObject()) {
        } finally {
            System.out.println("finally closed");
        }
    }

}
