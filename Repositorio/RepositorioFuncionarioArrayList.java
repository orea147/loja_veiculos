package Repositorio;

import java.util.ArrayList;
import classesBasicas.*;

public class RepositorioFuncionarioArrayList implements IRepositorioFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public RepositorioFuncionarioArrayList() {
        this.funcionarios = new ArrayList<>();
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void removerFuncionario(String id) {
        Funcionario funcionario = buscarFuncionario(id);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        }
    }

    @Override
    public Funcionario buscarFuncionario(String id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionarioAtualizado) {
        Funcionario funcionario = buscarFuncionario(funcionarioAtualizado.getId());
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            funcionarios.add(funcionarioAtualizado);
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
}

