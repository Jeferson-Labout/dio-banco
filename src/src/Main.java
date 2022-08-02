/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import resource.ContaPoupanca;
import resource.ContaCorrente;

/**
 *
 * @author Jeferson Labout
 */
public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.setSaldo(200.0);
        cc.setLimiteConta(600.0);
        cc.setSaldoTotal(cc.getSaldo() + cc.limiteConta);
        cc.depositar(500.00);
        poupanca.setSaldoTotal(100.00);

        cc.imprimirExtrato();

        cc.transferir(500, poupanca);
        poupanca.imprimirExtrato();

    }

}
