/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.odc.falsepositives;

/**
 *
 * @author jeremy
 */
public class AutoObject implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("auto-closed");
    }
    
}
