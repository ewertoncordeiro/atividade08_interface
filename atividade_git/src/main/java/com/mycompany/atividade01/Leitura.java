/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ewerton
 */
public class Leitura {

    public String entDados(String rotulo) {

        System.out.println(rotulo);
        String ret = "";

        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);

       
        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("\nERRO\n");
        }
        return ret;


      
    }

}
