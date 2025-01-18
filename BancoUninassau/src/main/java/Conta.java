public class Conta {
    private double saldo = 0.00;

    public double getSaldo() {
        return saldo;
    }

    public void depositarValor(double valor){
        this.saldo += valor;
    }

    public String sacarValor(double valor){
        String mensagem = null;

        if (saldo < valor){
            mensagem = "Saldo Insuficiente";
        } else {
            this.saldo -= valor;
            mensagem = "Saque realizado com sucesso";
        }

        return mensagem;
    }
}
