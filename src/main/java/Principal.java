import classes.Pagamento;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o preço do produto:\n");
        double precoProduto = Double.parseDouble(teclado.nextLine());
        System.out.println("Agora, digite o quanto o cliente pagou a você:\n");
        double pagamentoCliente = Double.parseDouble(teclado.nextLine());
        Pagamento pagamento = new Pagamento(pagamentoCliente, precoProduto);
        pagamento.calcularEOrganizarPagamento();
        System.out.println(pagamento.apresentarInformacoesDePagamento());
    }
}
