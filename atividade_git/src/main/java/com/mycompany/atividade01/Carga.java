/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

/**
 *
 * @author Ewerton
 */
public final class Carga extends Veiculo implements Calcular{

    private int cargaMax;
    private int tara;

    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public void calcVel() {
        System.out.println("Velocidade calculada carga " + getVelocMax() * 10000 + "cm/h");
    }

    @Override
    public int calcular() {
  
        return super.getQtdRodas()
                + this.cargaMax 
                + this.tara 
                + this.getMotor().getQtdPist() 
                + this.getMotor().getPotencia();
    }

}
