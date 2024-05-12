/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atividade01;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ewerton teste comit
 */
public class Teste {

    private static Passeio veiculoPasseio = new Passeio();
    private static Carga veiculoCarga = new Carga();
    private static final Leitura l = new Leitura();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();
    private static BDVeiculos bdcar = BDVeiculos.gerarGerpes();
    private static boolean opcaoContinuar = true;

    public static void main(String args[]) throws IOException, VeicExistException, VelocException, VeiculoPlacaException {

        boolean continuar = true;
        int opcao = 0;

        while (continuar) {

            System.out.println("\t\t ----MENU----");
            System.out.println("\t1 - Cadastrar veiculo de passeio");
            System.out.println("\t2 - Cadastrar veiculo de carga");
            System.out.println("\t3 - Imprimir Todos os Veiculos de Passeio");
            System.out.println("\t4 - Imprimir Todos os Veiculos de Carga");
            System.out.println("\t5 - Imprimir Veiculo de Passeio pela Placa");
            System.out.println("\t6 - Imprimir Veiculo de Carga pela Placa");
            System.out.println("\t7 - Excluir Veiculo de passeio pela Placa");
            System.out.println("\t8 - Excluir Veiculo de carga pela Placa");
            System.out.println("\t9 - Sair");

            try {
                opcao = Integer.parseInt(l.entDados("Selecione um item:"));
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros");
                l.entDados("");
                continue;
            }

            switch (opcao) {
                case 1:
                    boolean opCad = true;
                    System.out.println("Cadastro do veiculo de Passeio:");

                    while (opCad) {
                        veiculoPasseio = new Passeio();
                        cadastroPasseio(veiculoPasseio);
                        if (opcaoContinuar) {
                            String op = l.entDados("Deseja cadastrar outro veiculo de Passeio? s/n");
                            if (op.equalsIgnoreCase("n")) {
                                opCad = false;
                            }
                        } else {
                            break;
                        }
                    }
                    break;

                case 2:
                    boolean opCad2 = true;
                    System.out.println("Cadastro do veiculo de carga:");

                    while (opCad2) {
                        veiculoCarga = new Carga();
                        cadastroCarga(veiculoCarga);
                        if (opcaoContinuar) {
                            String op = l.entDados("Deseja cadastrar outro veiculo de Carga? s/n");
                            if (op.equalsIgnoreCase("n")) {
                                opCad2 = false;
                            }
                        } else {
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Impressao dos veiculos de passeio");
                    BDVeiculos.achatodasPlacaPasseio();
                    break;

                case 4:

                    System.out.println("Impressao dos veiculos de carga");
                    BDVeiculos.achatodasPlacaCarga();
                    break;

                case 5:
                    System.out.println("Consulta veiculo de passeio por placa");
                    veiculoPasseio = new Passeio();
                    veiculoPasseio.setPlaca(l.entDados("Placa:"));
                    veiculoPasseio = bdpass.achaPlacaPasseio(veiculoPasseio);
                    if (veiculoPasseio != null) {
                        BDVeiculos.imprimePasseio(veiculoPasseio);

                    } else {
                        l.entDados("Veiculo nao localizado");
                    }
                    break;

                case 6:
                    System.out.println("Consulta veiculo de carga por placa");
                    veiculoCarga = new Carga();
                    veiculoCarga.setPlaca(l.entDados("Placa:"));
                    veiculoCarga = bdcar.achaPlacaCarga(veiculoCarga);
                    if (veiculoCarga != null) {
                        BDVeiculos.imprimeCarga(veiculoCarga);

                    } else {
                        l.entDados("Veiculo nao localizado");
                    }
                    break;

                case 7:
                    veiculoPasseio = new Passeio();
                    veiculoPasseio.setPlaca(l.entDados("Informe a placa para exclusao:"));
                    veiculoPasseio = bdpass.removePesCod(veiculoPasseio);
                    if (veiculoPasseio == null) {
                        l.entDados("Veiculo excluido com sucesso");
                    } else {
                        l.entDados("Veiculo nao encontrado");
                    }

                    break;

                case 8:
                    veiculoCarga = new Carga();
                    veiculoCarga.setPlaca(l.entDados("Informe a placa para exclusao:"));
                    veiculoCarga = bdcar.removePesCod(veiculoCarga);
                    if (veiculoCarga == null) {
                        l.entDados("Veiculo excluido com sucesso");
                    } else {
                        l.entDados("Veiculo nao encontrado");
                    }

                    break;

                case 9:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    public static void cadastroPasseio(Passeio veiculoPasseio) throws VelocException, VeicExistException, VeiculoPlacaException {

        boolean continuar = true;
        while (continuar) {
            try {
                try {
                    veiculoPasseio.setPlaca(l.entDados("Placa:"));
                    veiculoPasseio.setMarca(l.entDados("Marca: "));
                    veiculoPasseio.setModelo(l.entDados("Modelo:"));
                    veiculoPasseio.setCor(l.entDados("Cor:"));
                    try {
                        veiculoPasseio.setVelocMax(Float.parseFloat(l.entDados("Velocidade max.:")));
                    } catch (VelocException ve) {
                        veiculoPasseio.setVelocMax((100));
                    }
                    veiculoPasseio.setQtdRodas(Integer.parseInt(l.entDados("Qtd Rodas:")));
                    veiculoPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia:")));
                    veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd pist.:")));
                    veiculoPasseio.setQtdPassageiros(Integer.parseInt(l.entDados("Qtd passageiros.:")));
                    veiculoPasseio = bdpass.cadPas(veiculoPasseio);
                    continuar = false;

                    if (veiculoPasseio != null) {
                        l.entDados("Veiculo passeio incluido. Press enter");
                        opcaoContinuar = true;
                    } else {
                        l.entDados("Veiculo ja existente. Press enter para reiniciar");
                        opcaoContinuar = false;
                    }
                } catch (VeiculoPlacaException vpe) {
                    System.out.println("Placa vazia: " + vpe.getMessage());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros nos atributos numericos. Reiniciando cadastro");
            }
        }
    }

    public static void cadastroCarga(Carga veiculoCarga) throws VelocException, VeicExistException, VeiculoPlacaException {

        boolean continuar = true;
        while (continuar) {
            try {
                try {
                    veiculoCarga.setPlaca(l.entDados("Placa:"));
                    veiculoCarga.setMarca(l.entDados("Marca:"));
                    veiculoCarga.setModelo(l.entDados("Modelo:"));
                    veiculoCarga.setCor(l.entDados("Cor:"));
                    try {
                        veiculoCarga.setVelocMax(Float.parseFloat(l.entDados("Velocidade max.:")));
                    } catch (VelocException ve) {
                        veiculoCarga.setVelocMax(90);
                    }
                    veiculoCarga.setQtdRodas(Integer.parseInt(l.entDados("Qtd Rodas:")));
                    veiculoCarga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia:")));
                    veiculoCarga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd Pist.:")));
                    veiculoCarga.setCargaMax(Integer.parseInt(l.entDados("Carga max..:")));
                    veiculoCarga.setTara(Integer.parseInt(l.entDados("Tara..:")));
                    veiculoCarga = bdcar.cadPas(veiculoCarga);
                    continuar = false;

                    if (veiculoCarga != null) {
                        l.entDados("Veiculo de carga incluido. Press enter");
                        opcaoContinuar = true;
                    } else {
                        l.entDados("Veiculo ja existente. Press enter para reiniciar");
                        opcaoContinuar = false;
                    }
                } catch (VeiculoPlacaException vpe) {
                    System.out.println("Placa vazia: " + vpe.getMessage());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros nos atributos numericos. Reiniciando cadastro");
            }
        }
    }

}
