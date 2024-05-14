/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ewerton
 */
public class JanelaCarga extends JFrame{
    
    
    private static Carga veiculoCarga = new Carga();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    private JFrame telaCarga = new JFrame("Cadastro Carga");
    private JButton btCdastrar = new JButton();
    private JButton btLimpar = new JButton();
    private JButton btNovo = new JButton();
    private JButton btSair = new JButton();
    private JTextField cxTara = new JTextField(20);
    private JTextField cxCarga = new JTextField(20);
    private JTextField cxPlaca = new JTextField(20);
    private JTextField cxMarca = new JTextField(20);
    private JTextField cxModelo = new JTextField(20);
    private JTextField cxCor = new JTextField(20);
    private JTextField cxRoda = new JTextField(20);
    private JTextField cxVeloc = new JTextField(20);
    private JTextField cxPist = new JTextField(20);
    private JTextField cxPotencia = new JTextField(20);
    private int larg = 400, alt = 500;

    public void carregaJanela() {

        JLabel rtPas = new JLabel("  Tara");
        JLabel rtCarga = new JLabel("  Carga");
        JLabel rtPlaca = new JLabel("  Placa");
        JLabel rtMarca = new JLabel("  Marca");
        JLabel rtModelo = new JLabel("  Modelo");
        JLabel rtCor = new JLabel("  Cor");
        JLabel rtRoda = new JLabel("  Roda");
        JLabel rtVeloc = new JLabel("  Velocidade");
        JLabel rtPist = new JLabel("  Qtd. Pistoes");
        JLabel rtPotencia = new JLabel("  Potencia");
        telaCarga.add(rtPas);
        telaCarga.add(cxTara);
        telaCarga.add(rtCarga);
        telaCarga.add(cxCarga);
        telaCarga.add(rtPlaca);
        telaCarga.add(cxPlaca);
        telaCarga.add(rtMarca);
        telaCarga.add(cxMarca);
        telaCarga.add(rtModelo);
        telaCarga.add(cxModelo);
        telaCarga.add(rtCor);
        telaCarga.add(cxCor);
        telaCarga.add(rtRoda);
        telaCarga.add(cxRoda);
        telaCarga.add(rtVeloc);
        telaCarga.add(cxVeloc);
        telaCarga.add(rtPist);
        telaCarga.add(cxPist);
        telaCarga.add(rtPotencia);
        telaCarga.add(cxPotencia);
        btCdastrar.setText("Cadastrar");
        btCdastrar.setMnemonic('C');
        btNovo.setText("Novo");
        btNovo.setMnemonic('N');
        btLimpar.setText("Limpar");
        btLimpar.setMnemonic('L');
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        telaCarga.add(btCdastrar);
        telaCarga.add(btNovo);
        telaCarga.add(btLimpar);
        telaCarga.add(btSair);
        telaCarga.setSize(larg, alt);
        telaCarga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaCarga.setLocationRelativeTo(null); 
        telaCarga.setLayout(new GridLayout(13, 2, 10, 10));
        telaCarga.setVisible(true);
        
        
        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    telaCarga.dispose();
                }
            }
        }
        );

        btCdastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    cadastrar();
                } catch (VelocException ex) {
                    Logger.getLogger(JanelaCarga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (VeicExistException ex) {
                    Logger.getLogger(JanelaCarga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (VeiculoPlacaException ex) {
                    Logger.getLogger(JanelaCarga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Valor inválido nos campos numericos");
                }
            }
        }
        );

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                limpar();

            }
        }
        );
    }

    private void cadastrar() throws VelocException, VeicExistException, VeiculoPlacaException {
        veiculoCarga = new Carga();
        veiculoCarga.setPlaca(cxPlaca.getText());
        veiculoCarga.setMarca(cxMarca.getText());
        veiculoCarga.setModelo(cxModelo.getText());
        veiculoCarga.setCor(cxCor.getText());
        veiculoCarga.setVelocMax(Float.parseFloat(cxVeloc.getText()));
        veiculoCarga.setQtdRodas(Integer.parseInt(cxRoda.getText()));
        veiculoCarga.getMotor().setPotencia(Integer.parseInt(cxPotencia.getText()));
        veiculoCarga.getMotor().setQtdPist(Integer.parseInt(cxPist.getText()));
        veiculoCarga.setTara(Integer.parseInt(cxTara.getText()));
        veiculoCarga = bdpass.cadPas(veiculoCarga);
        if (veiculoCarga != null) {
            JOptionPane.showMessageDialog(null, "Veículo incluído com sucesso");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Placa repetida");
            cxPlaca.setText("");
        }
    }

    private void limpar() {
        cxTara.setText("");
        cxCarga.setText("");
        cxPlaca.setText("");
        cxMarca.setText("");
        cxModelo.setText("");
        cxCor.setText("");
        cxRoda.setText("");
        cxVeloc.setText("");
        cxPist.setText("");
        cxPotencia.setText("");
    }

    
}
