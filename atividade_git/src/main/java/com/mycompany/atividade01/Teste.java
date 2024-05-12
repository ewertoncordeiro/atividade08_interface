/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atividade01;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ewerton teste comit
 */
public class Teste {

  
    private static Carga veiculoCarga = new Carga();

   
    private static BDVeiculos bdcar = BDVeiculos.gerarGerpes();
    private static boolean opcaoContinuar = true;

    //janela
    private static JFrame jan1 = new JFrame("Titulo Inicial");
    private static JLabel rtCod = new JLabel("Texto Inicial");

    
    private static JMenuItem itMenuSair = new JMenuItem("Sair");
   
    private static JMenu itMenuCarga = new JMenu("Carga");
    
    private static JMenu menuPrincipal = new JMenu("Menu");
    private static JMenu menuPasseio = new JMenu("Passeio");
    private static JMenuItem itMenuPasseioCad = new JMenuItem("Cadastrar");
    private static JMenuItem itMenuPasseioCon = new JMenuItem("Consultar / Excluir pela placa");
    private static JMenuItem itMenuPasseioImpE = new JMenuItem("Imprimir / Excluir todos");
    private static JMenuBar barraMenu = new JMenuBar();


    public static void main(String args[]) {

        int larg = 300, alt = 200;

        jan1.setSize(larg, alt);
        jan1.setTitle("Gestão de Veículos");
        jan1.setDefaultCloseOperation(jan1.EXIT_ON_CLOSE);


        // Adicionando os componentes ao painel
        rtCod.setText("Selecione um item do Menu");
      ///  cxCod.setColumns(10);
        //btSair.setText("Sair");

        //adicionar “Item de Menu” ao “Menu”
        //submenus
            
        menuPasseio.add(itMenuPasseioCad); 
        menuPasseio.add(itMenuPasseioCon);
        menuPasseio.add(itMenuPasseioImpE);
        
        
        
        menuPrincipal.add(menuPasseio);  
       
        menuPrincipal.add(itMenuCarga); 
        menuPrincipal.add(itMenuSair); 
    
        barraMenu.add(menuPrincipal); 
        jan1.setJMenuBar(barraMenu);

        jan1.add(rtCod);
     //   jan1.add(cxCod);
       // jan1.add(btSair);
        jan1.setLayout(new FlowLayout());
        jan1.setVisible(true);
        jan1.setLocationRelativeTo(null);
     //   jan1.revalidate();
   //     jan1.repaint();

        
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
            }}
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
    }
}
