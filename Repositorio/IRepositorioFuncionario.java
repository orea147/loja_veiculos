package Repositorio;

import classesBasicas.Funcionario;

public interface IRepositorioFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    void removerFuncionario(String id);
    Funcionario buscarFuncionario(String id);
    void atualizarFuncionario(Funcionario funcionario);
}
