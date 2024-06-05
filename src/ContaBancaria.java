import exceptions.BancoDigitalException;

public abstract class ContaBancaria {
    private static final int AGENCIA = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public int tipo;

    public ContaBancaria (Cliente cliente, int tipo) {
        this.agencia = AGENCIA;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public void sacar(double valor) throws BancoDigitalException {
        if(valor > saldo) throw new BancoDigitalException();
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } catch (BancoDigitalException e) {
            System.out.println("Você não possui saldo o suficiente para realizar a operação.");
        }
    }

    protected void imprimirInfosBancarias () {
        System.out.println(
            "\nCliente: " + this.cliente.getNome() +
            "\nAgencia: " + this.agencia +
            "\nNúmero da conta: " + this.numero +
            "\nTipo de conta: " + (this.tipo == 0 ? "Conta Corrente" : "Conta Poupança") +
            "\nSaldo: " + this.saldo
        );
    }
}
