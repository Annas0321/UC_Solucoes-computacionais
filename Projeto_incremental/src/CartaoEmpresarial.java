import java.util.Date;
public class CartaoEmpresarial extends CartaoDeCredito {
    public CartaoEmpresarial(int numero, Cliente cliente) {
        super(numero, cliente, 10000, 1.0);
    }
    
    public void realizarCompraParcelada(double valor, int parcelas) {
        if (valor <= getLimite()) {
            double valorParcela = valor / parcelas;
            setLimite(getLimite() - valor);
            setTotalFatura(getTotalFatura() + valor);
            Transacao transacao = new Transacao(new Date(), valor, 
                "Compra empresarial em " + parcelas + "x de R$" + String.format("%.2f", valorParcela));
            getHistoricoDeTransacoes().add(transacao);
            System.out.println("Compra parcelada realizada com sucesso!");
            System.out.println(parcelas + "x de R$" + String.format("%.2f", valorParcela));
        } else {
            System.out.println("Limite insuficiente para esta compra.");
        }
    }
} 