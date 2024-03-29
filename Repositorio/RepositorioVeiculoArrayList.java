package Repositorio;
import classesBasicas.Veiculo;

import java.util.ArrayList;

public class RepositorioVeiculoArrayList implements IRepositorioVeiculo {
    private ArrayList<Veiculo> veiculos;

    public RepositorioVeiculoArrayList() {
        this.veiculos = new ArrayList<>();
        this.veiculos.add(new Veiculo("Fiat", 2020, 5000, 7000));
        this.veiculos.add(new Veiculo("Nissan", 2020, 6000, 8000));
        this.veiculos.add(new Veiculo("Mercedes", 2020, 7000, 9000));
        
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public void removerVeiculo(String modelo) {
        Veiculo veiculo = buscarVeiculo(modelo);
        if (veiculo != null) {
            veiculos.remove(veiculo);
        }
    }

    @Override
    public Veiculo buscarVeiculo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equals(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public void atualizarVeiculo(Veiculo veiculoAtualizado) {
        Veiculo veiculo = buscarVeiculo(veiculoAtualizado.getModelo());
        if (veiculo != null) {
            veiculos.remove(veiculo);
            veiculos.add(veiculoAtualizado);
        }
    }
    public ArrayList<Veiculo> getVeiculos() {
        return this.veiculos;
    }
}