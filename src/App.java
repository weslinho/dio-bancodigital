public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("Wesley");

        ContaBancaria contaCorrente = banco.criarConta(cliente, 0); // tipo 0 representa conta corrente
        ContaBancaria contaPoupanca = banco.criarConta(cliente, 1); // tipo 1 representa conta poupança
    }
}
