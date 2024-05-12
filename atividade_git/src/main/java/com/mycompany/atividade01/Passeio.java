/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

/**
 *
 * @author Ewerton
 */
public final class Passeio extends Veiculo implements Calcular {

    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public void calcVel() {
        System.out.println("Velocidade calculada passeio " + getVelocMax() * 1000 + " m/h");
    }

   
    @Override
    public int calcular() {
        
        return super.getPlaca().length()
                + super.getMarca().length()
                + super.getModelo().length()
                + super.getCor().length();

    }

}
