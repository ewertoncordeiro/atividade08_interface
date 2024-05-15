/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ewerton
 */
public class JanelaCargaImpressao implements ActionListener {

    private static BDVeiculos bdcar = BDVeiculos.gerarGerpes();
    private JDialog telaCarga = new JDialog();
    private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Max.", "Qtd. Pistões", "Potência", "Tara", "Carga Max."};
    private DefaultTableModel model = new DefaultTableModel(colunas, 0);
    private JTable tableDados = new JTable(model);
    private JScrollPane barraRolagemLista = new JScrollPane(tableDados);
    private JButton btImprimirTodos = new JButton();
    private JButton btExcluirTodos = new JButton();
    private JButton btSair = new JButton();
    private int larg = 800, alt = 400;

    public void carregaJanela() {

        telaCarga.setLayout(new GridLayout(0, 1, 10, 10));
        telaCarga.setSize(larg, alt);
        telaCarga.getContentPane().setBackground(Color.WHITE);
        telaCarga.setTitle("Imprimir/Excluir todos");
        btImprimirTodos.setText("Imprimir Todos");
        btImprimirTodos.setMnemonic('I');
        btImprimirTodos.addActionListener(this);
        btExcluirTodos.setText("Excluir Todos");
        btExcluirTodos.setMnemonic('E');
        btExcluirTodos.addActionListener(this);
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        btSair.addActionListener(this);
        telaCarga.add(barraRolagemLista);
        JPanel opPanel = new JPanel();
        opPanel.setLayout(new FlowLayout());
        btImprimirTodos.setPreferredSize(new Dimension(200, 30));
        btExcluirTodos.setPreferredSize(new Dimension(200, 30));
        btSair.setPreferredSize(new Dimension(200, 30));
        opPanel.add(btImprimirTodos);
        opPanel.add(btExcluirTodos);
        opPanel.add(btSair);
        telaCarga.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        opPanel.setPreferredSize(new Dimension(600, 200));
        telaCarga.add(opPanel);
        telaCarga.setLocationRelativeTo(null);
        telaCarga.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent act) {

        if (act.getSource().equals(btImprimirTodos)) {
            imprimeDadosCarga();
        } else if (act.getSource().equals(btExcluirTodos)) {
            if (excluirTodosDados()) {
                JOptionPane.showMessageDialog(null, "Dados removidos", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel model = new DefaultTableModel(colunas, 0);
                tableDados.setModel(model);
            }
        } else if (act.getSource().equals(btSair)) {
            telaCarga.dispose();
        }
    }

    public void imprimeDadosCarga() {

        if (bdcar.getBdCar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há dados cadastrados.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            model = new DefaultTableModel(colunas, 0);
            for (Carga carga : bdcar.getBdCar()) {
                String[] dados = {carga.getPlaca(), carga.getMarca(),
                    carga.getModelo(),
                    carga.getCor(),
                    String.valueOf(carga.getQtdRodas()),
                    Float.toString(carga.getVelocMax()),
                    String.valueOf(carga.getMotor().getQtdPist()),
                    String.valueOf(carga.getMotor().getPotencia()),
                    String.valueOf(carga.getTara()),
                    String.valueOf(carga.getCargaMax())};
                model.addRow(dados);
                tableDados.setModel(model);
            }
        }
    }

    public boolean excluirTodosDados() {
        if (bdcar.getBdCar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há dados a serem removidos.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            BDVeiculos.excluirAll();
            return true;
        }
    }

}
