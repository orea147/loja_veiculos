
package classesBasicas;
import Repositorio.*;

public abstract class TransacaoAbstrata {
    protected Veiculo veiculo;
    protected Cliente cliente;
    protected double valor;
    protected RepositorioVeiculoArrayList repositorioVeiculo;
    protected Loja loja;

    public TransacaoAbstrata(Veiculo veiculo, Cliente cliente, double valor, RepositorioVeiculoArrayList repositorioVeiculo, Loja loja) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.valor = valor;
        this.repositorioVeiculo = repositorioVeiculo;
        this.loja = loja;
    }

    public abstract void realizar();
}
