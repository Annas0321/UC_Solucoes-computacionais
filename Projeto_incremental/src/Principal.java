import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cartaodecretido c;

        System.out.println("Bem-vindo ao sistema de criação de cartão de crédito!");
        System.out.println("Escolha uma opção para criar o cartão:");
        System.out.println("1 - Criar cartão com informações básicas");
        System.out.println("2 - Criar cartão com limite personalizado e cashback");

        int escolha = sc.nextInt();

        System.out.println("Digite o número do cartão:");
        int numero = sc.nextInt();
        sc.nextLine();  

        System.out.println("Digite o nome do titular:");
        String nomeTitular = sc.nextLine();

        System.out.println("Digite o CPF do titular:");
        String cpf = sc.nextLine(); // Coletando o CPF

        if (escolha == 1) {
            c = new Cartaodecretido(numero, nomeTitular, cpf); 
        } else {
            System.out.println("Digite o limite de crédito:");
            double limite = sc.nextDouble();

            System.out.println("Digite a taxa de cashback (%):");
            double taxaCashback = sc.nextDouble();

            c = new Cartaodecretido(numero, nomeTitular, cpf, limite, taxaCashback); 
        }

        int opcao;
        do {
            System.out.println("1 - Consultar Limite");
            System.out.println("2 - Consultar Fatura");
            System.out.println("3 - Realizar compra básica");
            System.out.println("4 - Realizar compra com cashback");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Limite disponível: " + c.consultarLimite());
                    break;
                case 2:
                    System.out.println("Total fatura: " + c.consultarTotalFatura());
                    break;
                case 3:
                    System.out.println("Digite o valor da compra:");
                    double valor = sc.nextDouble();
                    c.realizarCompra(valor);
                    break;
                case 4:
                    System.out.println("Digite o valor da compra:");
                    valor = sc.nextDouble();
                    c.realizarCompra(valor, true);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
