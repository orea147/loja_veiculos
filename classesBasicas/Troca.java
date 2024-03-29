
package classesBasicas;
import Repositorio.*;

public class Troca extends TransacaoAbstrata {
    public Troca(Veiculo veiculo, Cliente cliente, double valor, RepositorioVeiculoArrayList repositorioVeiculo, Loja loja) {
        super(veiculo, cliente, valor, repositorioVeiculo, loja);
    }

    @Override
    public void realizar() {
        Veiculo veiculoAntigo = cliente.getCarro();
        double valorAntigo = veiculoAntigo.getValorCompra();
        double valorNovo = veiculo.getValorVenda();

        if (valorAntigo < valorNovo) {
            double diferenca = valorNovo - valorAntigo;
            loja.aumentarSaldo(diferenca);
        } else if (valorAntigo > valorNovo) {
            double diferenca = valorAntigo - valorNovo;
            loja.diminuirSaldo(diferenca);
        }

        // Troca os carros
        cliente.setCarro(veiculo);
        repositorioVeiculo.removerVeiculo(veiculo.getModelo());
        repositorioVeiculo.adicionarVeiculo(veiculoAntigo);
    }
}