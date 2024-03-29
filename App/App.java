
package App;

import classesBasicas.*;
import Repositorio.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
         // Criando o repositório de carros
        RepositorioVeiculoArrayList repositorioVeiculo = new RepositorioVeiculoArrayList();

        // Criando o repositório de clientes
        RepositorioClienteArrayList repositorioCliente = new RepositorioClienteArrayList();
        
        // Criando o repositorio de funcionarios
        
        RepositorioFuncionarioArrayList repositorioFuncionario = new RepositorioFuncionarioArrayList();
        
        // Criando fachada loja
        FachadaLoja fachadaLoja = new FachadaLoja(repositorioVeiculo,new Loja());
        
        // Criando um scanner para ler a entrada do console
        Scanner scanner = new Scanner(System.in);
       
        // Criando o menu principal do sistema
        Createmenu.menuSistema(scanner, repositorioCliente, repositorioVeiculo, repositorioFuncionario, fachadaLoja);
    }
}