
package classesBasicas;

import Repositorio.RepositorioClienteArrayList;
import Repositorio.RepositorioVeiculoArrayList;
import Repositorio.RepositorioFuncionarioArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Createmenu {
    
    public static void menuSistema(Scanner scanner, RepositorioClienteArrayList repositorioCliente,
                                        RepositorioVeiculoArrayList repositorioVeiculo, RepositorioFuncionarioArrayList repositorioFuncionario, FachadaLoja fachadaLoja) {
        while (true) {
            try {
            System.out.println("-------------------------------\n");
            System.out.println("Menu do sistema \n ");
            System.out.println("Digite uma opção: \n ");
            System.out.println("1. Entrar como Funcionário");
            System.out.println("2. Entrar como Administrador");
            System.out.println("3. Sair");
            System.out.println("\n-------------------------------");
            String opcaoLogin = scanner.nextLine();
            System.out.println("-------------------------------");
            
            switch (opcaoLogin) {
                case "1":
                    // Entrar como Funcionário
                    System.out.println("Digite o ID do funcionário:");
                    String idFuncionario = scanner.nextLine();
                    Funcionario funcionarioSelecionado = repositorioFuncionario.buscarFuncionario(idFuncionario);
                    if (funcionarioSelecionado != null) {
                        Createmenu.menuFuncionario(scanner, repositorioCliente, repositorioVeiculo, funcionarioSelecionado, fachadaLoja);
                    }
                    else {
                        System.out.println("Funcionario não existe!");
                    }
                    break;
                case "2":
                    // Entrar como Administrador
                    System.out.println("Digite a senha do administrador:");
                    String senha = scanner.nextLine();
                    if (senha.equals("123")) {
                        Createmenu.menuAdministrador(scanner,repositorioCliente, repositorioFuncionario, repositorioVeiculo , fachadaLoja);
                    } else {
                        System.out.println("Senha incorreta. Tente novamente.");
                    }
                    break;
                case "3":
                    // Sair do programa
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }
    
    public static void menuFuncionario(Scanner scanner, RepositorioClienteArrayList repositorioCliente,
                                        RepositorioVeiculoArrayList repositorioVeiculo, Funcionario funcionario, FachadaLoja fachadaLoja) {        
        while (true) {
            try {
                System.out.println("-------------------------------\n");
                System.out.println("Menu Funcionário: " + funcionario.getNome() );
                System.out.println("Digite uma opção: \n");
                System.out.println("1. Cadastrar cliente");
                System.out.println("2. Selecionar cliente");
                System.out.println("3. Remover cliente");
                System.out.println("4. Atualizar cliente");
                System.out.println("5. Verificar saldo da loja");
                System.out.println("6. Listar clientes");
                System.out.println("7. Listar veiculos");
                System.out.println("8. Voltar");
                System.out.println("\n-------------------------------");
                String opcao = scanner.nextLine();
                System.out.println("-------------------------------");

                switch (opcao) {
                    case "1":
                        // Cadastrar cliente
                        System.out.println("Digite o nome do cliente:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CPF do cliente:");
                        String cpf = scanner.nextLine();
                        System.out.println("O cliente possui um veículo? (s/n)");
                        String possuiVeiculo = scanner.nextLine();
                        Veiculo carro = null;
                        if (possuiVeiculo.equalsIgnoreCase("s")) {
                            System.out.println("Digite o modelo do veículo:");
                            String modelo = scanner.nextLine();
                            System.out.println("Digite o ano do veículo:");
                            int ano = scanner.nextInt();
                            System.out.println("Digite o valor de compra do veículo:");
                            double valorCompra = scanner.nextDouble();
                            System.out.println("Digite o valor de venda do veículo:");
                            double valorVenda = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a linha restante
                            carro = new Veiculo(modelo, ano, valorCompra, valorVenda);
                        }
                        Cliente cliente = new Cliente(nome, cpf, carro);
                        funcionario.adicionarCliente(cliente);
                        break;
                    case "2":

                        // Selecionar cliente
                        System.out.println("Digite o ID do cliente a ser selecionado:");
                        String idSelecionar = scanner.nextLine();
                        Cliente clienteSelecionado = repositorioCliente.buscarCliente(idSelecionar);
                        if (clienteSelecionado != null) {
                            System.out.println("Cliente selecionado: " + clienteSelecionado);
                            String opcaoFachada = "";
                            while (!opcaoFachada.equals("4")) {
                                System.out.println("Menu de transação \n");
                                System.out.println("Digite uma opção:\n");
                                System.out.println("1. Realizar compra");
                                System.out.println("2. Realizar venda");
                                System.out.println("3. Realizar troca");
                                System.out.println("4. Voltar");
                                opcaoFachada = scanner.nextLine();

                                switch (opcaoFachada) {
                                    case "1":
                                        // Realizar compra
                                        String idClienteCompra = idSelecionar;
                                        Cliente clienteCompra = repositorioCliente.buscarCliente(idClienteCompra);

                                        // Verifica se o cliente existe
                                        if (clienteCompra != null) {
                                            Veiculo veiculoCompra = clienteCompra.getCarro(); // Obtém o veículo do cliente
                                            if (veiculoCompra != null) {
                                                double valorCompra = veiculoCompra.getValorCompra(); // Obtém o valor de compra do veículo
                                                funcionario.realizarCompra(veiculoCompra, clienteCompra, valorCompra);
                                                System.out.println("Veículo adicionado ao estoque da loja.");
                                            } else {
                                                System.out.println("Este cliente não possui um veículo para comprar.");
                                            }
                                        } else {
                                            System.out.println("Cliente não encontrado.");
                                        }
                                        break;
                                    case "2":
                                        // Realizar venda
                                        String idClienteVenda = idSelecionar;
                                        Cliente clienteVenda = repositorioCliente.buscarCliente(idClienteVenda);
                                        if (clienteVenda != null) {
                                            System.out.println("Digite o modelo do veículo:");
                                            String modeloVeiculoVenda = scanner.nextLine();
                                            Veiculo veiculoVenda = repositorioVeiculo.buscarVeiculo(modeloVeiculoVenda);
                                            if (veiculoVenda != null) {
                                                double valorVenda = veiculoVenda.getValorVenda(); // Obtém o valor de venda do veículo
                                                funcionario.realizarVenda(veiculoVenda, clienteVenda, valorVenda);
                                                System.out.println("Venda realizada com sucesso!");
                                            } else {
                                                System.out.println("Veículo não encontrado.");
                                            }
                                        } else {
                                            System.out.println("Cliente não encontrado.");
                                        }
                                        break;
                                    case "3":
                                        // Realizar troca
                                        String idClienteTroca = idSelecionar;
                                        Cliente clienteTroca = repositorioCliente.buscarCliente(idClienteTroca);
                                        if (clienteTroca != null) {
                                            Veiculo veiculoAntigo = clienteTroca.getCarro();
                                            if (veiculoAntigo != null) {
                                                System.out.println("Digite o modelo do veículo novo:");
                                                String modeloVeiculoNovo = scanner.nextLine();
                                                Veiculo veiculoNovo = repositorioVeiculo.buscarVeiculo(modeloVeiculoNovo);
                                                if (veiculoNovo != null) {
                                                    double valorTroca = 0;
                                                    // Realizar troca
                                                    funcionario.realizarTroca(veiculoNovo, clienteTroca, valorTroca);

                                                    System.out.println("Troca realizada com sucesso!");
                                                } else {
                                                    System.out.println("Veículo novo não encontrado.");
                                                }
                                            } else {
                                                System.out.println("Cliente não possui veículo para troca.");
                                            }
                                        } else {
                                            System.out.println("Cliente não encontrado.");
                                        }
                                        break;
                                    case "4":
                                        System.out.println("Voltando para o menu anterior...");
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                            }
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;
                    case "3":
                        // Remover cliente
                        System.out.println("Digite o ID do cliente a ser removido:");
                        String idRemover = scanner.nextLine();
                        funcionario.removerCliente(idRemover);
                        break;
                    case "4":
                        // Atualizar cliente
                        System.out.println("Digite o ID do cliente a ser atualizado:");
                        String idAtualizar = scanner.nextLine();
                        Cliente clienteAtualizar = repositorioCliente.buscarCliente(idAtualizar);
                        if (clienteAtualizar != null) {
                            funcionario.removerCliente(clienteAtualizar.getId());
                            System.out.println("Digite o nome do cliente:");
                            String newNome = scanner.nextLine();
                            System.out.println("Digite o CPF do cliente:");
                            String newCpf = scanner.nextLine();
                            System.out.println("O cliente possui um veículo? (s/n)");
                            String newPossuiVeiculo = scanner.nextLine();
                            Veiculo newCarro = null;
                            if (newPossuiVeiculo.equalsIgnoreCase("s")) {
                                System.out.println("Digite o modelo do veículo:");
                                String modelo = scanner.nextLine();
                                System.out.println("Digite o ano do veículo:");
                                int ano = scanner.nextInt();
                                System.out.println("Digite o valor de compra do veículo:");
                                double valorCompra = scanner.nextDouble();
                                System.out.println("Digite o valor de venda do veículo:");
                                double valorVenda = scanner.nextDouble();
                                scanner.nextLine();
                                newCarro = new Veiculo(modelo, ano, valorCompra, valorVenda);
                            }
                            Cliente novocliente = new Cliente(newNome, newCpf, newCarro);
                            funcionario.adicionarCliente(novocliente);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;
                    case "5":
                        // Verificar Saldo
                        System.out.println("Saldo atual da loja: " + fachadaLoja.getSaldo());
                        break;
                    case "6":
                        // Listar clientes
                        ArrayList<Cliente> clientes = repositorioCliente.getClientes();
                        for (Cliente c : clientes) {
                            System.out.println(c);
                            System.out.println();
                        }
                        break;
                    case "7":
                        // Listar veículos
                        ArrayList<Veiculo> veiculos = repositorioVeiculo.getVeiculos();
                        for (Veiculo v : veiculos) {
                            System.out.println(v);
                            System.out.println();
                        }
                        break;
                    case "8":
                        // Sair do programa
                        System.out.println("Voltando ao menu de login...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        } 
    }
    
    public static void menuAdministrador(Scanner scanner, RepositorioClienteArrayList repositorioCliente,
                                         RepositorioFuncionarioArrayList repositorioFuncionario, RepositorioVeiculoArrayList repositorioVeiculo ,FachadaLoja fachadaLoja) {
        while (true) {
            try {
                System.out.println("-------------------------------\n");
                System.out.println("Menu Administrador \n");
                System.out.println("Digite uma opção: \n");
                System.out.println("1. Adicionar funcionário");
                System.out.println("2. Remover funcionário");
                System.out.println("3. Listar funcionários");
                System.out.println("4. Listar saldo da loja");
                System.out.println("5. Voltar");
                System.out.println("\n-------------------------------");
                String opcao = scanner.nextLine();
                System.out.println("-------------------------------");

                switch (opcao) {
                    case "1":
                        // Adicionar funcionário
                        System.out.println("Digite o nome do Funcionario:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CPF do Funcionario:");
                        String cpf = scanner.nextLine();
                        Funcionario funcionario = new Funcionario(nome, cpf, repositorioCliente, repositorioVeiculo, fachadaLoja);
                        repositorioFuncionario.adicionarFuncionario(funcionario);
                        break;
                    case "2":
                        // Remover funcionário
                        System.out.println("Digite o ID do Funcionario a ser removido:");
                        String idRemover = scanner.nextLine();
                        repositorioFuncionario.removerFuncionario(idRemover);
                        break;
                    case "3":
                        // Listar funcionários
                        ArrayList<Funcionario> funcionarios = repositorioFuncionario.getFuncionarios();
                        for (Funcionario f : funcionarios) {
                            System.out.println(f);
                            System.out.println();
                        }
                        break;
                    case "4":
                        // Listar saldo da loja
                        System.out.println("Saldo atual da loja: " + fachadaLoja.getSaldo());
                        break;
                    case "5":
                        System.out.println("Voltando ao menu de login...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }   
}
