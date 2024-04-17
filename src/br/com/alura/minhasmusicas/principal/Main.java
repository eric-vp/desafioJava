package br.com.alura.minhasmusicas.principal;

import br.com.alura.minhasmusicas.modelos.Cartao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor do limite:");
        double limite = leitura.nextDouble();
        Cartao cartao = new Cartao(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("""
                    Selecione uma opção:
                    1 - Comprar
                    2 - Ver saldo
                    3 - Ver lista de compras
                    4 - Sair
                    """);
            int opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    cartao.compra(leitura);
                    break;
                case 2:
                    cartao.verificaSaldo();
                    break;
                case 3:
                    cartao.exibeLista();
                    break;
                case 4:
                    cartao.sair();
                    sair = 0;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }
}
