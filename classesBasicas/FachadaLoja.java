
package classesBasicas;

import Repositorio.*;

public class FachadaLoja {
    private RepositorioVeiculoArrayList repositorioVeiculo;
    private Loja loja;

    public FachadaLoja(RepositorioVeiculoArrayList repositorioVeiculo, Loja loja) {
        this.repositorioVeiculo = repositorioVeiculo;
        this.loja = loja;
    }

    public void realizarCompra(Veiculo veiculo, Cliente cliente, double valor) {
        Compra compra = new Compra(veiculo, cliente, valor, repositorioVeiculo, loja);
        compra.realizar();
    }

    public void realizarVenda(Veiculo veiculo, Cliente cliente, double valor) {
        Venda venda = new Venda(veiculo, cliente, valor, repositorioVeiculo, loja);
        venda.realizar();
    }

    public void realizarTroca(Veiculo veiculo, Cliente cliente, double valor) {
        Troca troca = new Troca(veiculo, cliente, valor, repositorioVeiculo, loja);
        troca.realizar();
    }
    
    public double getSaldo() {
        return loja.getSaldo();
    }
}
