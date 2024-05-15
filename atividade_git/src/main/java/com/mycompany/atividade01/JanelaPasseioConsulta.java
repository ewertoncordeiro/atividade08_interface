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
public class JanelaPasseioConsulta implements ActionListener {

    private static Passeio veiculoPasseio = new Passeio();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    private JDialog telaPasseio = new JDialog();
    private JButton btConsultar = new JButton();
    private JButton btExcluir = new JButton();
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
    private int larg = 400, alt = 500;

    public void carregaJanela() {

        JLabel rtPas = new JLabel("  Qtd. Passageiros");
        JLabel rtPlaca = new JLabel("  Informe a placa");
        JLabel rtMarca = new JLabel("  Marca");
        JLabel rtModelo = new JLabel("  Modelo");
        JLabel rtCor = new JLabel("  Cor");
        JLabel rtRoda = new JLabel("  Roda");
        JLabel rtVeloc = new JLabel("  Velocidade");
        JLabel rtPist = new JLabel("  Qtd. Pistoes");
        JLabel rtPotencia = new JLabel("  Potencia");
        telaPasseio.setTitle("Consultar / Excluir pela placa");
        telaPasseio.add(rtPlaca);
        telaPasseio.add(cxPlaca);
        telaPasseio.add(rtPas);
        telaPasseio.add(cxPas);
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
        cxPas.setEditable(false);
        cxMarca.setEditable(false);
        cxModelo.setEditable(false);
        cxCor.setEditable(false);
        cxRoda.setEditable(false);
        cxVeloc.setEditable(false);
        cxPist.setEditable(false);
        cxPotencia.setEditable(false);
        btConsultar.setText("Consultar");
        btConsultar.setMnemonic('C');
        btExcluir.setText("Excluir");
        btExcluir.setMnemonic('E');
        btSair.setText("Sair");
        btSair.setMnemonic('S');
        telaPasseio.add(btConsultar);
        telaPasseio.add(btExcluir);
        telaPasseio.add(btSair);
        btSair.addActionListener(this);
        btExcluir.addActionListener(this);
        btConsultar.addActionListener(this);
        telaPasseio.setSize(larg, alt);
        telaPasseio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaPasseio.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        telaPasseio.setLocationRelativeTo(null);
        telaPasseio.setLayout(new GridLayout(12, 2, 10, 10));
        telaPasseio.setVisible(true);

    }

    private void consultar() {
        veiculoPasseio = new Passeio();
        veiculoPasseio.setPlaca(cxPlaca.getText());
        veiculoPasseio = bdpass.achaPlacaPasseio(veiculoPasseio);
        if (veiculoPasseio != null) {
           cxPas.setText(Integer.toString(veiculoPasseio.getQtdPassageiros()));
           cxCor.setText(veiculoPasseio.getCor());
           cxMarca.setText(veiculoPasseio.getMarca());
           cxModelo.setText(veiculoPasseio.getModelo());
           cxPlaca.setText(veiculoPasseio.getPlaca());
           cxRoda.setText(Integer.toString(veiculoPasseio.getQtdRodas()));
           cxVeloc.setText(Integer.toString(veiculoPasseio.getQtdRodas()));
           cxPist.setText(Integer.toString(veiculoPasseio.getMotor().getQtdPist()));
           cxPotencia.setText(Integer.toString(veiculoPasseio.getMotor().getPotencia()));

        } else {
            JOptionPane.showMessageDialog(null, "Veículo não localizado");
             limpar();
        }
    }

    public void excluir() {
        veiculoPasseio = new Passeio();
        veiculoPasseio.setPlaca(cxPlaca.getText());
        veiculoPasseio = bdpass.removePesCod(veiculoPasseio);
        if (veiculoPasseio == null) {
            JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não localizado");
            limpar();
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

    @Override
    public void actionPerformed(ActionEvent act) {

        if (act.getSource().equals(btSair)) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                telaPasseio.dispose();
            }

        } else if (act.getSource().equals(btExcluir)) {
            excluir();
        } else if (act.getSource().equals(btConsultar)) {
            if (cxPlaca.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo placa está em branco.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                consultar();
            }
            throw new UnsupportedOperationException("Erro");
        }
    }
}
