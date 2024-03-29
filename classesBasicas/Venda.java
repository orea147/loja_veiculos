
package classesBasicas;
import Repositorio.*;

public class Venda extends TransacaoAbstrata {
    public Venda(Veiculo veiculo, Cliente cliente, double valor, RepositorioVeiculoArrayList repositorioVeiculo, Loja loja) {
        super(veiculo, cliente, valor, repositorioVeiculo, loja);
    }

    @Override
    public void realizar() {
        cliente.setCarro(veiculo);
        repositorioVeiculo.removerVeiculo(veiculo.getModelo());
        loja.aumentarSaldo(valor);
    }
}