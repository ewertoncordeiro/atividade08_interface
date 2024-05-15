/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ewerton
 */
public class JanelaCargaConsulta implements ActionListener {

    private static Carga veiculoCarga = new Carga();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    private JDialog telaCarga = new JDialog();
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
        telaCarga.setTitle("Consultar / Excluir pela placa");
        telaCarga.add(rtPlaca);
        telaCarga.add(cxPlaca);
        telaCarga.add(rtTara);
        telaCarga.add(cxTara);
        telaCarga.add(rtCarga);
        telaCarga.add(cxCarga);
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
        btConsultar.setText("Consultar");
        btConsultar.setMnemonic('C');
        btExcluir.setText("Excluir");
        btExcluir.setMnemonic('E');
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        telaCarga.add(btConsultar);
        telaCarga.add(btExcluir);
        telaCarga.add(btSair);
        btSair.addActionListener(this);
        btConsultar.addActionListener(this);
        btExcluir.addActionListener(this);
        cxTara.setEditable(false);
        cxMarca.setEditable(false);
        cxModelo.setEditable(false);
        cxCor.setEditable(false);
        cxRoda.setEditable(false);
        cxVeloc.setEditable(false);
        cxPist.setEditable(false);
        cxPotencia.setEditable(false);
        cxCarga.setEditable(false);
        telaCarga.setSize(larg, alt);
        telaCarga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaCarga.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        telaCarga.setLocationRelativeTo(null);
        telaCarga.setLayout(new GridLayout(12, 2, 10, 10));
        telaCarga.setVisible(true);
    }

    private void consultar() {
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
            limpar();
        }
    }

    public void excluir() {
        veiculoCarga = new Carga();
        veiculoCarga.setPlaca(cxPlaca.getText());
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

    @Override
    public void actionPerformed(ActionEvent act) {
        if (act.getSource().equals(btSair)) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                telaCarga.dispose();
            }
        } else if (act.getSource().equals(btConsultar)) {
            if (cxPlaca.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo placa está em branco.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                consultar();
            }
        } else if (act.getSource().equals(btExcluir)) {
            excluir();
        }
        throw new UnsupportedOperationException("erro");
    }
}
