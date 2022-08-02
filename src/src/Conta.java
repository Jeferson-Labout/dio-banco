/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.text.DecimalFormat;
import lombok.Getter;
import lombok.Setter;
import resource.IConta;
import src.Cliente;

/**
 *
 * @author Jeferson Labout
 */
@Getter
@Setter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Double limiteConta;
    protected Double saldoTotal;
    protected Cliente cliente;

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        System.out.println(" *** REALIZANDO A OPERAÇÃO DE SAQUE *** ");

        if (valor <= 0) {
            System.out.println("Operação não realizada valor menor ou igual a zero");

        } else {

            if (this.saldoTotal >= valor) {
                this.saldoTotal = saldoTotal - valor;
                System.out.println("Operação realizada com sucesso, o novo saldo da conta é: R$ "
                        + df.format(saldoTotal));
            } else {
                System.out.println("Saldo insuficiente.");
            }

        }

        System.out.println(" *** FIM *** ");
    }

    @Override
    public void depositar(double valor) {
        System.out.println(" *** REALIZANDO A OPERAÇÃO DE DEPÓSITO *** ");
        System.out.println("Saldo anterior + limite:  R$ " + df.format(this.saldoTotal));
        System.out.println("Valor do Deposito:  R$ " + df.format(valor));
        if (valor < 0) {
            System.out.println("Operação não realizada valor menor ou igual a zero");
        } else {
            this.saldoTotal += valor;
            System.out.println("Operação realizada com sucesso: ");
            System.out.println("saldo + limite da conta:  R$ " + df.format(this.saldoTotal));
            System.out.println(" *** FIM *** ");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldoTotal));
    }
}
