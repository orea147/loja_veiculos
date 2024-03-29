
package classesBasicas;


public class Veiculo {
    private String modelo;
    private int ano;
    private double valorCompra;
    private double valorVenda;

    public Veiculo(String modelo, int ano, double valorCompra, double valorVenda) {
        this.modelo = modelo;
        this.ano = ano;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", valorCompra=" + valorCompra +
                ", valorVenda=" + valorVenda +
                '}';
    }
}