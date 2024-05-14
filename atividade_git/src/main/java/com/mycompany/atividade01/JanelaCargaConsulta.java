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
public class JanelaCargaConsulta {
    private static Carga veiculoCarga = new Carga();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();

    private JFrame telaPasseio = new JFrame("Consulta / Excluir Carga");
    private JButton btConsultar = new JButton();
    private JButton btExcluir = new JButton();
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

        JLabel rtTara = new JLabel("  Tara");
        JLabel rtCarga = new JLabel("  Carga Max.");
        JLabel rtPlaca = new JLabel("  Informe a placa");
        JLabel rtMarca = new JLabel("  Marca");
        JLabel rtModelo = new JLabel("  Modelo");
        JLabel rtCor = new JLabel("  Cor");
        JLabel rtRoda = new JLabel("  Roda");
        JLabel rtVeloc = new JLabel("  Velocidade");
        JLabel rtPist = new JLabel("  Qtd. Pistoes");
        JLabel rtPotencia = new JLabel("  Potencia");
        telaPasseio.add(rtPlaca);
        telaPasseio.add(cxPlaca);
        telaPasseio.add(rtTara);
        telaPasseio.add(cxTara);
        telaPasseio.add(rtCarga);
        telaPasseio.add(cxCarga);
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
        btConsultar.setText("Consultar");
        btConsultar.setMnemonic('C');
        btExcluir.setText("Excluir");
        btExcluir.setMnemonic('E');
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        telaPasseio.add(btConsultar);
        telaPasseio.add(btExcluir);
        telaPasseio.add(btSair);
        telaPasseio.setSize(larg, alt);
        telaPasseio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaPasseio.setLocationRelativeTo(null);
        telaPasseio.setLayout(new GridLayout(12, 2, 10, 10));
        telaPasseio.setVisible(true);

        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    telaPasseio.dispose();
                }
            }
        }
        );

        btConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try {
                    consultar();
                } catch (VeiculoPlacaException ex) {
                    Logger.getLogger(JanelaPasseioConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        btExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                excluir();
            }
        });

    }

    private void consultar() throws VeiculoPlacaException {
        veiculoCarga = new Carga();
        veiculoCarga.setPlaca(cxPlaca.getText());
        veiculoCarga = bdpass.achaPlacaCarga(veiculoCarga);
        if (veiculoCarga != null) {
           cxTara.setText(Integer.toString(veiculoCarga.getTara()));
           cxCarga.setText(Integer.toString(veiculoCarga.getCargaMax()));
           cxCor.setText(veiculoCarga.getCor());
           cxMarca.setText(veiculoCarga.getMarca());
           cxModelo.setText(veiculoCarga.getModelo());
           cxPlaca.setText(veiculoCarga.getPlaca());
           cxRoda.setText(Integer.toString(veiculoCarga.getQtdRodas()));
           cxVeloc.setText(Integer.toString(veiculoCarga.getQtdRodas()));
           cxPist.setText(Integer.toString(veiculoCarga.getMotor().getQtdPist()));
           cxPotencia.setText(Integer.toString(veiculoCarga.getMotor().getPotencia()));

        } else {
            JOptionPane.showMessageDialog(null, "Veículo não localizado");
            cxPlaca.setText("");
        }
    }

    public void excluir() {
        veiculoCarga = new Carga();
        try {
            veiculoCarga.setPlaca(cxPlaca.getText());
        } catch (VeiculoPlacaException ex) {
            Logger.getLogger(JanelaCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        veiculoCarga = bdpass.removeCarCod(veiculoCarga);
        if (veiculoCarga == null) {
            JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não localizado");
            limpar();
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
