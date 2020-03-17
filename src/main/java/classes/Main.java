package classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um o quanto o cliente pagou:\n");
        String pagamentoCliente = teclado.nextLine();
        System.out.println("Agora, digite o valor que vale o (s) produto (s):\n");
        String precoProduto = teclado.nextLine();
        Pagamento pagamento = new Pagamento(Double.parseDouble(pagamentoCliente), Double.parseDouble(precoProduto));
        String teste = pagamento.pagarOCliente();
    }
}
