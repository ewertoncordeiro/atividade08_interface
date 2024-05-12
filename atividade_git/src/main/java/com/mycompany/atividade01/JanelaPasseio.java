/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.FlowLayout;
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
public class JanelaPasseio {

    private static Passeio veiculoPasseio = new Passeio();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();

    private JFrame telaPasseio = new JFrame("Cadastro Passeio");
    private JButton btCdastrar = new JButton();
    private JButton btLimpar = new JButton();
    private JButton btNovo = new JButton();
    private JButton btSair = new JButton();
    private JTextField cxPas = new JTextField(20);
    private JTextField cxPlaca = new JTextField(20);
    private JTextField cxMarca = new JTextField(20);
    private JTextField cxModelo = new JTextField(20);
    private JTextField cxCor = new JTextField(20);
    private JTextField cxRoda = new JTextField(20);
    private JTextField cxVeloc = new JTextField(20);
    private JTextField cxPist = new JTextField(20);
    private JTextField cxPotencia = new JTextField(20);

    public void carregaJanela() {

        telaPasseio.setSize(400, 500);

        JLabel rtPas = new JLabel("Qtd. Passageiros");
        JLabel rtPlaca = new JLabel("Placa.....................");
        JLabel rtMarca = new JLabel("Marca.................");
        JLabel rtModelo = new JLabel("Modelo...............");
        JLabel rtCor = new JLabel("Cor....................");
        JLabel rtRoda = new JLabel("Roda..................");
        JLabel rtVeloc = new JLabel("Velocidade........");
        JLabel rtPist = new JLabel("Qtd. Pistoes.......");
        JLabel rtPotencia = new JLabel("Potencia..............");
        telaPasseio.add(rtPas);
        telaPasseio.add(cxPas);
        telaPasseio.add(rtPlaca);
        telaPasseio.add(cxPlaca);
        telaPasseio.add(rtMarca);
        telaPasseio.add(cxMarca);
        telaPasseio.add(rtModelo);
        telaPasseio.add(cxModelo);
        telaPasseio.add(rtCor);
        telaPasseio.add(cxCor);
        telaPasseio.add(rtRoda);
        telaPasseio.add(cxRoda);
        telaPasseio.add(rtVeloc);
        telaPasseio.add(cxVeloc);
        telaPasseio.add(rtPist);
        telaPasseio.add(cxPist);
        telaPasseio.add(rtPotencia);
        telaPasseio.add(cxPotencia);

        btCdastrar.setText("Cadastrar");
        btCdastrar.setMnemonic('C');
        btNovo.setText("Novo");
        btNovo.setMnemonic('N');
        btLimpar.setText("Limpar");
        btLimpar.setMnemonic('L');
        btSair.setText("Sair");
        btSair.setMnemonic('S');

        telaPasseio.add(btCdastrar);
        telaPasseio.add(btNovo);
        telaPasseio.add(btLimpar);
        telaPasseio.add(btSair);

        telaPasseio.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        telaPasseio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaPasseio.setVisible(true);
        telaPasseio.setLocationRelativeTo(null);

        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    telaPasseio.dispose();
                }
            }
        }
        );

        btCdastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    cadastrar();
                } catch (VelocException ex) {
                    Logger.getLogger(JanelaPasseio.class.getName()).log(Level.SEVERE, null, ex);

                } catch (VeicExistException ex) {
                    Logger.getLogger(JanelaPasseio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (VeiculoPlacaException ex) {
                    Logger.getLogger(JanelaPasseio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Apenas numeros inteiros nos campos numericos");
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
        veiculoPasseio = new Passeio();
        veiculoPasseio.setPlaca(cxPlaca.getText());
        veiculoPasseio.setMarca(cxMarca.getText());
        veiculoPasseio.setModelo(cxModelo.getText());
        veiculoPasseio.setCor(cxCor.getText());
        veiculoPasseio.setVelocMax(Float.parseFloat(cxVeloc.getText()));
        veiculoPasseio.setQtdRodas(Integer.parseInt(cxRoda.getText()));
        veiculoPasseio.getMotor().setPotencia(Integer.parseInt(cxPotencia.getText()));
        veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(cxPist.getText()));
        veiculoPasseio.setQtdPassageiros(Integer.parseInt(cxPas.getText()));
        veiculoPasseio = bdpass.cadPas(veiculoPasseio);
        if (veiculoPasseio != null) {
            JOptionPane.showMessageDialog(null, "Veículo incluído com sucesso");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Placa repetida");
            cxPlaca.setText("");
        }
    }

    private void limpar() {
        cxPas.setText("");
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
