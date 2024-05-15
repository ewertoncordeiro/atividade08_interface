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
class VelocException extends Exception {

    public VelocException() {
        JOptionPane.showMessageDialog(null, "A velocidade maxima esta fora dos limites brasileiros");
    }
}
    
