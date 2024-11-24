import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do cliente:");
        String nome = sc.nextLine();
        
        System.out.println("Digite o CPF do cliente:");
        String cpf = sc.nextLine();
        
        System.out.println("Digite o CNPJ do cliente (se aplicável):");
        String cnpj = sc.nextLine();
        
        System.out.println("Digite o e-mail do cliente:");
        String email = sc.nextLine();
        
        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.nextLine();
        
        Cliente cliente = new Cliente(nome, cpf, cnpj, email, telefone);
        
        System.out.println("Escolha o tipo de cartão:");
        System.out.println("1 - Cartão Básico");
        System.out.println("2 - Cartão Premium");
        System.out.println("3 - Cartão Empresarial");
        int tipoCartao = sc.nextInt();

        System.out.println("Digite o número do cartão:");
        int numero = sc.nextInt();

        CartaoDeCredito c;
        switch (tipoCartao) {
            case 1:
                c = new CartaoBasico(numero, cliente);
                break;
            case 2:
                c = new CartaoPremium(numero, cliente);
                break;
            case 3:
                c = new CartaoEmpresarial(numero, cliente);
                break;
            default:
                c = new CartaoBasico(numero, cliente);
                break;
        }

        int opcao;
        do {
            System.out.println("1 - Consultar Limite");
            System.out.println("2 - Consultar Fatura");
            System.out.println("3 - Realizar compra básica");
            System.out.println("4 - Realizar compra com cashback");
            System.out.println("5 - Exibir Histórico de Transações");
            if (c instanceof CartaoEmpresarial) {
                System.out.println("6 - Realizar compra parcelada");
            }
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
                case 5:
                    System.out.println("Histórico de Transações:");
                    for (Transacao transacao : c.getHistoricoDeTransacoes()) {
                        System.out.println(transacao);
                    }
                    break;
                case 6:
                    if (c instanceof CartaoEmpresarial) {
                        System.out.println("Digite o valor da compra:");
                        valor = sc.nextDouble();
                        System.out.println("Digite o número de parcelas:");
                        int parcelas = sc.nextInt();
                        ((CartaoEmpresarial) c).realizarCompraParcelada(valor, parcelas);
                    }
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

