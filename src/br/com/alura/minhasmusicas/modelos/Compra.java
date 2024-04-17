package br.com.alura.minhasmusicas.modelos;

public class Compra implements Comparable<Compra>{
    private String descricao;
    private Double valor;

    public Compra(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("""
                Produto:
                    Descrição: %s
                    Valor: R$ %.2f 
                """, getDescricao(), getValor()
        );
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return this.getValor().compareTo(outraCompra.getValor());
    }
}
