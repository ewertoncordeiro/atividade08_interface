/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

/**
 *
 * @author Ewerton
 */
public class VeicExistException extends Exception {

    public VeicExistException() {
        System.out.println("Ja existe um veiculo com esta placa \n");
    }
}
