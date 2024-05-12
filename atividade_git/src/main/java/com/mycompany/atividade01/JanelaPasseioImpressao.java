/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ewerton
 */
public class JanelaPasseioImpressao implements ActionListener {
    

   // private static Passeio veiculoPasseio = new Passeio();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    
     private JFrame telaPasseio = new JFrame("Cadastro Passeio");

    private String[] colunas = {"Nome", "Idade","email"};

    private DefaultTableModel model = new DefaultTableModel(colunas,0);
    private JTable tableDados = new JTable(model);
    private JScrollPane barraRolagemLista = new JScrollPane(tableDados);

    private JButton btImprimirTodos = new JButton();
    private JButton btExcluirTodos = new JButton();
    private JButton btSair = new JButton();

    private int larg = 600, alt =500;

    public void carregaJanela() {

        telaPasseio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPasseio.setLayout(new GridLayout(4,1,10,10));
        telaPasseio.setSize(larg,alt);
        telaPasseio.setTitle("Exemplo de JPanel");
        telaPasseio.getContentPane().setBackground(Color.WHITE);

        telaPasseio.setTitle("Imprimir/Excluir todos");

        btImprimirTodos.setText("Imprimir Todos");
        btImprimirTodos.setMnemonic('I');
        btImprimirTodos.addActionListener(this);

        btExcluirTodos.setText("Excluir Todos");
        btExcluirTodos.setMnemonic('E');
        btExcluirTodos.addActionListener(this);
        btExcluirTodos.setPreferredSize(new Dimension(40, 40));

        btSair.setText("Sair");
        btSair.setMnemonic('S');
        btSair.addActionListener(this);

        telaPasseio.add(barraRolagemLista);
        telaPasseio.add(btImprimirTodos);
        telaPasseio.add(btExcluirTodos);
        telaPasseio.add(btSair);

        telaPasseio.setVisible(true);
      
    }

    @Override
    public void actionPerformed(ActionEvent act) {

        if(act.getSource().equals(btImprimirTodos)) {

            imprimeDadosPessoa();

        }else if(act.getSource().equals(btExcluirTodos)) {

            if(excluirTodosDados()) {

                JOptionPane.showMessageDialog(null,"Dados removidos" , "Sucesso",  JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel model = new DefaultTableModel(colunas,0);
                tableDados.setModel(model);
            }


        }else if(act.getSource().equals(btSair)) {
            telaPasseio.dispose();
        }
    }
    public void imprimeDadosPessoa() {
       
            model = new DefaultTableModel(colunas,0);
            for(Passeio passeio : bdpass.getBdPas()) {
                String[] dados = {passeio.getPlaca(), String.valueOf(passeio.getQtdPassageiros()), passeio.getMarca()};
                model.addRow(dados);

            tableDados.setModel(model);
        }
    }

    public boolean excluirTodosDados() {

     //  if(bdcar.isEmpty()) {
     //      JOptionPane.showMessageDialog(null,"Não há dados a serem removidos." , "ERRO",  JOptionPane.ERROR_MESSAGE);
    //      return false;
    //   }else {

          // bdpass.getBdPas() = new ArrayList<>();
           bdpass = BDVeiculos.gerarGerpes();
    //   
      return true;
   }
}
    