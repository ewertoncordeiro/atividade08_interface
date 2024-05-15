/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ewerton
 */
public class JanelaPasseioImpressao implements ActionListener {


    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    private JDialog telaPasseio = new JDialog();
    private String[] colunas = {"Placa", "Marca","Qtd Pass.", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Max.", "Qtd. Pistões", "Potência"};
    private DefaultTableModel model = new DefaultTableModel(colunas, 0);
    private JTable tableDados = new JTable(model);
    private JScrollPane barraRolagemLista = new JScrollPane(tableDados);
    private JButton btImprimirTodos = new JButton();
    private JButton btExcluirTodos = new JButton();
    private JButton btSair = new JButton();
    private int larg = 800, alt = 400;
    
   
    public void carregaJanela() {
         
        telaPasseio.setLayout(new GridLayout(0, 1, 10, 10));
        telaPasseio.setSize(larg, alt);
        telaPasseio.getContentPane().setBackground(Color.WHITE);               
        telaPasseio.setTitle("Imprimir/Excluir todos");
        btImprimirTodos.setText("Imprimir Todos");
        btImprimirTodos.setMnemonic('I');
        btImprimirTodos.addActionListener(this);
        btExcluirTodos.setText("Excluir Todos");
        btExcluirTodos.setMnemonic('E');
        btExcluirTodos.addActionListener(this);
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        btSair.addActionListener(this);
        telaPasseio.add(barraRolagemLista);
        JPanel opPanel = new JPanel();
        opPanel.setLayout(new FlowLayout());   
        btImprimirTodos.setPreferredSize(new Dimension(200, 30));
        btExcluirTodos.setPreferredSize(new Dimension(200, 30));
        btSair.setPreferredSize(new Dimension(200, 30));
        opPanel.add(btImprimirTodos);
        opPanel.add(btExcluirTodos);
        opPanel.add(btSair);
        telaPasseio.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        opPanel.setPreferredSize(new Dimension(600, 200));
        telaPasseio.add(opPanel);
        telaPasseio.setLocationRelativeTo(null); 
        telaPasseio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent act) {

        if (act.getSource().equals(btImprimirTodos)) {
            imprimeDadosPasseio();
        } else if (act.getSource().equals(btExcluirTodos)) {
            if (excluirTodosDados()) {
                JOptionPane.showMessageDialog(null, "Dados removidos", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel model = new DefaultTableModel(colunas, 0);
                tableDados.setModel(model);
            }
        } else if (act.getSource().equals(btSair)) {
            telaPasseio.dispose();
        }
    }

    public void imprimeDadosPasseio() {
        
        if (bdpass.getBdPas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há dados cadastrados.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            model = new DefaultTableModel(colunas, 0);
            for (Passeio passeio : bdpass.getBdPas()) {
                String[] dados = {passeio.getPlaca(), passeio.getMarca(),
                    String.valueOf(passeio.getQtdPassageiros()),
                    passeio.getModelo(),
                    passeio.getCor(), 
                    String.valueOf(passeio.getQtdRodas()), 
                    Float.toString(passeio.getVelocMax()),
                    String.valueOf(passeio.getMotor().getQtdPist()), 
                    String.valueOf(passeio.getMotor().getPotencia())}; 
                model.addRow(dados);
                tableDados.setModel(model);
            }
        }     
    }

    public boolean excluirTodosDados() {
        if (bdpass.getBdPas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há dados a serem removidos.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            BDVeiculos.excluirAll();
            return true;
        }
    }
}
