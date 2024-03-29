
package classesBasicas;
import Repositorio.*;

public class Compra extends TransacaoAbstrata {
    public Compra(Veiculo veiculo, Cliente cliente, double valor, RepositorioVeiculoArrayList repositorioVeiculo, Loja loja) {
        super(veiculo, cliente, valor, repositorioVeiculo, loja);
    }

    @Override
    public void realizar() {
        cliente.setCarro(null);
        repositorioVeiculo.adicionarVeiculo(veiculo);
        loja.diminuirSaldo(valor);
    }
}