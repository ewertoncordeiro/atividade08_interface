/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ewerton
 */
public class JanelaPrincipal {

    private static JFrame jan1 = new JFrame("Titulo Inicial");
    private static JMenuItem itMenuSair = new JMenuItem("Sair");
    private static JMenu menuCarga = new JMenu("Carga");
    private static JMenuItem itMenuCargaCad = new JMenuItem("Cadastrar");
    private static JMenuItem itMenuCargaCon = new JMenuItem("Consultar / Excluir pela placa");
    private static JMenuItem itMenuCargaImpE = new JMenuItem("Imprimir / Excluir todos");
    private static JMenu menuPrincipal = new JMenu("Menu");
    private static JMenu menuPasseio = new JMenu("Passeio");
    private static JMenuItem itMenuPasseioCad = new JMenuItem("Cadastrar");
    private static JMenuItem itMenuPasseioCon = new JMenuItem("Consultar / Excluir pela placa");
    private static JMenuItem itMenuPasseioImpE = new JMenuItem("Imprimir / Excluir todos");
    private static JMenuBar barraMenu = new JMenuBar();
    private JButton btPasseio = new JButton();
    private JButton btCarga = new JButton();
    private int larg = 300, alt = 200;

    public void carregaJanela() {

        jan1.setSize(larg, alt);
        jan1.setTitle("Gestão de Veículos");
        jan1.setDefaultCloseOperation(jan1.EXIT_ON_CLOSE);
        menuPasseio.add(itMenuPasseioCad);
        menuPasseio.add(itMenuPasseioCon);
        menuPasseio.add(itMenuPasseioImpE);
        menuCarga.add(itMenuCargaCad);
        menuCarga.add(itMenuCargaCon);
        menuCarga.add(itMenuCargaImpE);
        menuPrincipal.add(menuPasseio);
        menuPrincipal.add(menuCarga);
        menuPrincipal.add(itMenuSair);
        barraMenu.add(menuPrincipal);
        jan1.setJMenuBar(barraMenu);
        btPasseio.setText("Passeio");
        jan1.add(btPasseio);
        btCarga.setText("Carga");
        jan1.add(btCarga);
        jan1.setLayout(new GridLayout(0, 1, 10, 10));
        jan1.setVisible(true);
        jan1.setLocationRelativeTo(null);

        itMenuSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    jan1.dispose();
                }
            }
        }
        );

        itMenuPasseioCad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaPasseio jpass = new JanelaPasseio();
                jpass.carregaJanela();
            }
        }
        );

        itMenuPasseioCon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaPasseioConsulta jpass = new JanelaPasseioConsulta();
                jpass.carregaJanela();
            }
        }
        );

        itMenuPasseioImpE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaPasseioImpressao jpass = new JanelaPasseioImpressao();
                jpass.carregaJanela();
            }
        }
        );

        itMenuCargaCad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaCarga jcar = new JanelaCarga();
                jcar.carregaJanela();
            }
        }
        );

        itMenuCargaCon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaCargaConsulta jcar = new JanelaCargaConsulta();
                jcar.carregaJanela();
            }
        }
        );
        itMenuCargaImpE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaCargaImpressao jcar = new JanelaCargaImpressao();
                jcar.carregaJanela();
            }
        }
        );

        btPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaOpPasseio jan = new JanelaOpPasseio();
                jan.carregaJanela();
            }
        }
        );
        btCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JanelaOpCarga jan = new JanelaOpCarga();
                jan.carregaJanela();
            }
        }
        );

    }
}
