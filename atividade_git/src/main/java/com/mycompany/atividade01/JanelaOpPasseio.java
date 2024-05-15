/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ewerton
 */
public class JanelaOpPasseio implements ActionListener {

    private JDialog jan = new JDialog();
    private JButton btCadastrar = new JButton();
    private JButton btConsultar = new JButton();
    private JButton btImprimir = new JButton();
    private JButton btSair = new JButton();
    private int larg = 400, alt = 300;

    public void carregaJanela() {

        jan.setSize(larg, alt);
        jan.setLayout(new GridLayout(4, 2, 10, 10));
        jan.setTitle("Veículos de Passeio");
        btCadastrar.setText("Cadastrar");
        btConsultar.setText("Consultar / Excluir pela placa");
        btImprimir.setText("Imprimir / Excluir Todos");
        btSair.setText("Sair");
        btCadastrar.addActionListener(this);
        btSair.addActionListener(this);
        btConsultar.addActionListener(this);
        btCadastrar.addActionListener(this);
        btImprimir.addActionListener(this);
        jan.add(btCadastrar);
        jan.add(btConsultar);
        jan.add(btImprimir);
        jan.add(btSair);
        jan.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jan.setLocationRelativeTo(null);
        jan.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(btSair)) {
            jan.dispose();
        } else if (act.getSource().equals(btCadastrar)) {
            JanelaPasseio jpass = new JanelaPasseio();
            jpass.carregaJanela();
        } else if (act.getSource().equals(btConsultar)) {
            JanelaPasseioConsulta jpass = new JanelaPasseioConsulta();
            jpass.carregaJanela();
        } else if (act.getSource().equals(btImprimir)) {
            JanelaPasseioImpressao jpass = new JanelaPasseioImpressao();
            jpass.carregaJanela();
        }
        throw new UnsupportedOperationException("Erro");
    }
}
