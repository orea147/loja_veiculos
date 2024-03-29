
package Repositorio;
import classesBasicas.*;

public interface IRepositorioVeiculo {
    void adicionarVeiculo(Veiculo veiculo);
    void removerVeiculo(String modelo);
    Veiculo buscarVeiculo(String modelo);
    void atualizarVeiculo(Veiculo veiculo);
}