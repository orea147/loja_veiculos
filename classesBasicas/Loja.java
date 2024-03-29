
package classesBasicas;

public class Loja {
    private double saldo;

    public Loja() {
        this.saldo = 100000;
    }

    public void diminuirSaldo(double valor) {
        this.saldo -= valor;
    }

    public void aumentarSaldo(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
