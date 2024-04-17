package br.com.alura.minhasmusicas.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cartao {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean lancaCompra(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }
        return false;
    }

    public void compra(Scanner leitura) {
        System.out.println("Digite a descrição da compra:");
        String compraDescricao = leitura.next();
        System.out.println("Digite o valor da compra:");
        double compraValor = leitura.nextDouble();
        Compra compra = new Compra(compraDescricao, compraValor);

        if (this.lancaCompra(compra)) {
            System.out.println("Produto " + compra.getDescricao() + " adicionado com sucesso");
            this.exibeLista();
        } else {
            System.out.println(String.format("Você tem apenas %.2f de saldo", this.getSaldo()));
        }
    }

    public void verificaSaldo() {
        System.out.println(String.format("Seu saldo é: R$ %.2f", this.getSaldo()));
    }

    public void exibeLista() {
        Collections.sort(this.compras);
        System.out.println(compras);
    }

    public void sair() {
        System.out.println("Sua lista de compras:");
        this.exibeLista();
        System.out.println("Você saiu!");
    }
}
