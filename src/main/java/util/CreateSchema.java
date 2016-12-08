/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.Persistence;

/**
 *
 * @author lucasmfredmark
 */
public class CreateSchema {
    public static void main(String[] args) {
        Persistence.generateSchema("pu_test", null);
    }
}
