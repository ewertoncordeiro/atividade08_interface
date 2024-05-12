/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import javax.swing.JOptionPane;

/**
 *
 * @author Ewerton
 */
public class VeiculoPlacaException extends Exception {

    public VeiculoPlacaException(String message) {
        JOptionPane.showMessageDialog(null, message);

    }
}
