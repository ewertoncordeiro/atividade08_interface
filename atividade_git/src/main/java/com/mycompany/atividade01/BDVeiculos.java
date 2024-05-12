/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ewerton
 */
public class BDVeiculos {

    private static List<Passeio> listaPasseio = new ArrayList<Passeio>();
    private static List<Carga> listaCarga = new ArrayList<Carga>();
    private static BDVeiculos BDVeiculosUnic;

    private BDVeiculos() {
        listaPasseio = new ArrayList<Passeio>();
        listaCarga = new ArrayList<Carga>();
    }

    public static BDVeiculos gerarGerpes() {
        if (BDVeiculosUnic == null) {
            BDVeiculosUnic = new BDVeiculos();
        }
        return BDVeiculosUnic;
    }

    //metodos classe passeio
    //buscar
    public static void achatodasPlacaPasseio() {
        for (int i = 0; i < listaPasseio.size(); i++) {
            imprimePasseio(listaPasseio.get(i));
        }
    }

    public Passeio achaPlacaPasseio(Passeio veiculoPasseio) {
        for (int i = 0; i < listaPasseio.size(); i++) {
            if (veiculoPasseio.getPlaca().equalsIgnoreCase(listaPasseio.get(i).getPlaca())) {
                return listaPasseio.get(i);
            }
        }
        return null;
    }

    //delete
    public Passeio removePesCod(Passeio pas) {
        Passeio pas1 = achaPlacaPasseio(pas);
        if (pas1 != null) {
            listaPasseio.remove(pas1);
            return null;
        } else {
            return pas;
        }
    }

    // insert
    public Passeio cadPas(Passeio pas) throws VeicExistException {
        if (achaPlacaPasseio(pas) == null) {
            listaPasseio.add(pas);
            return pas;
        } else {
            return null;
        }
    }

    //metodos classe carga
    //buscar
    public static void achatodasPlacaCarga() {
        for (int i = 0; i < listaCarga.size(); i++) {
            imprimeCarga(listaCarga.get(i));
        }
    }

    public Carga achaPlacaCarga(Carga veiculocarga) {
        for (int i = 0; i < listaCarga.size(); i++) {
            if (veiculocarga.getPlaca().equalsIgnoreCase(listaCarga.get(i).getPlaca())) {
                return listaCarga.get(i);
            }
        }
        return null;
    }

    //delete
    public Carga removePesCod(Carga car) {
        Carga car1 = achaPlacaCarga(car);
        if (car1 != null) {
            listaCarga.remove(car1);
            return null;
        } else {
            return car;
        }
    }

    // insert
    public Carga cadPas(Carga car) throws VeicExistException {
        if (achaPlacaCarga(car) == null) {
            listaCarga.add(car);
            return car;
        } else {
            return null;
        }
    }

    public static void imprimePasseio(Passeio passeio) {
        System.out.println("Impressao da placa: ");
        System.out.println("Marca........" + passeio.getMarca());
        System.out.println("Modelo......." + passeio.getModelo());
        System.out.println("Placa........" + passeio.getPlaca());
        System.out.println("Velocidade..." + passeio.getVelocMax());
        System.out.println("Cor.........." + passeio.getCor());
        System.out.println("Qtd Rodas...." + passeio.getQtdRodas());
        System.out.println("Passageitos.." + passeio.getQtdPassageiros());
        System.out.println("Potencia....." + passeio.getMotor().getPotencia());
        System.out.println("Pistoes......" + passeio.getMotor().getQtdPist());
        System.out.println("Qtd caracteres......" + passeio.calcular());
        passeio.calcVel();
        System.out.println("-------------------------");
    }

    public static void imprimeCarga(Carga carga) {
        System.out.println("Marca........" + carga.getMarca());
        System.out.println("Modelo......." + carga.getModelo());
        System.out.println("Placa........" + carga.getPlaca());
        System.out.println("Velocidade..." + carga.getVelocMax());
        System.out.println("Cor.........." + carga.getCor());
        System.out.println("Qtd Rodas...." + carga.getQtdRodas());
        System.out.println("Carga maxima." + carga.getCargaMax());
        System.out.println("Tara........." + carga.getTara());
        System.out.println("Potencia....." + carga.getMotor().getPotencia());
        System.out.println("Pistoes......" + carga.getMotor().getQtdPist());
        System.out.println("Soma dos valores ......" + carga.calcular());
        carga.calcVel();
        System.out.println("-------------------------");
    }

}
