package classesBasicas;

public class Cliente extends Pessoa {
    private static int nextId = 1;
    private String id;
    private Veiculo carro; 

    public Cliente(String nome, String cpf ,Veiculo carro) {
        super(nome, cpf);
        this.id = String.format("%03d", nextId++);
        this.carro = carro;
    }

    // Getters e setters...
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", id='" + id + '\'' +
                ", carro=" + (carro != null ? carro.getModelo() : "null") +
                '}';
    }
}
