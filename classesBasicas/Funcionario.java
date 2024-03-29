package classesBasicas;
import Repositorio.*;

public class Funcionario extends Pessoa {
    private static int nextId = 1;
    private String id;
    private int transacoes;
    private RepositorioClienteArrayList repositorioCliente;
    private RepositorioVeiculoArrayList repositorioVeiculo;
    private FachadaLoja fachadaLoja;

    public Funcionario(String nome, String cpf, RepositorioClienteArrayList repositorioCliente, RepositorioVeiculoArrayList repositorioVeiculo, FachadaLoja fachadaLoja) {
        super(nome, cpf);
        this.id = String.format("%03d", nextId++);
        this.repositorioCliente = repositorioCliente;
        this.repositorioVeiculo = repositorioVeiculo;
        this.fachadaLoja = fachadaLoja;
        this.transacoes = 0;
    }
    
    public void adicionarCliente(Cliente cliente) {
        repositorioCliente.adicionarCliente(cliente);
    }

    public void removerCliente(String idCliente) {
        repositorioCliente.removerCliente(idCliente);
    }
    
    public void realizarCompra(Veiculo veiculo, Cliente cliente, double valorCompra) {
        fachadaLoja.realizarCompra(veiculo, cliente, valorCompra);
        this.transacoes++;
    }

    public void realizarVenda(Veiculo veiculo, Cliente cliente, double valorVenda) {
        fachadaLoja.realizarVenda(veiculo, cliente, valorVenda);
        this.transacoes++;
    }

    public void realizarTroca(Veiculo veiculoNovo, Cliente cliente, double valorTroca) {
        fachadaLoja.realizarTroca(veiculoNovo, cliente, valorTroca);
        this.transacoes++;
    }

    public int getTransacoes() {
        return transacoes;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Funcionario{" +
                "id='" + id + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", transacoes=" + transacoes +
                '}';
    }
}