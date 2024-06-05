import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    ContaBancaria criarConta (Cliente cliente, int tipo) {
        ContaBancaria conta = null;
        
        switch (tipo) {
            case 0:
                conta = new ContaCorrente(cliente);
                break;
            case 1: 
                conta = new ContaPoupanca(cliente);
                break;
        }

        addConta(conta);
        return conta;
    }

    protected void addConta (ContaBancaria conta) {
        this.contas.add(conta);
    }

    protected void imprimirContas () {
        System.out.println(contas);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
