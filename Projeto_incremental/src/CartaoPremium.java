public class CartaoPremium extends CartaoDeCredito {
    public CartaoPremium(int numero, Cliente cliente) {
        super(numero, cliente, 5000, 2.0);
    }
    
    @Override
    public void realizarCompra(double valor) {
        double cashback = valor * (getTaxaCashback() / 100);
        super.realizarCompra(valor);
        System.out.println("Você ganhou R$" + String.format("%.2f", cashback) + " de cashback!");
    }
} 