import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Cartaodecretido {
    private int numero;
    private double limite;
    private double totalFatura;
    private double taxaCashback; 
    private Cliente cliente;  
    private List<Transacao> historicoDeTransacoes;

    public Cartaodecretido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = 1000;  
        this.totalFatura = 0;
        this.taxaCashback = 0;
        this.historicoDeTransacoes = new ArrayList<>();
    }

    
    public Cartaodecretido(int numero, Cliente cliente, double limite, double taxaCashback) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = limite;
        this.totalFatura = 0;
        this.taxaCashback = taxaCashback;
        this.historicoDeTransacoes = new ArrayList<>();
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getTotalFatura() {
        return totalFatura;
    }

    public void setTotalFatura(double totalFatura) {
        this.totalFatura = totalFatura;
    }

    public double getTaxaCashback() {
        return taxaCashback;
    }

    public void setTaxaCashback(double taxaCashback) {
        this.taxaCashback = taxaCashback;
    }

    public double consultarLimite() {
        return getLimite();
    }

    public double consultarTotalFatura() {
        return getTotalFatura();
    }
    
    public List<Transacao> getHistoricoDeTransacoes() { 
        return historicoDeTransacoes;
    }

    
    public void realizarCompra(double valor) {
        if (valor <= getLimite()) {
            setLimite(getLimite() - valor);
            setTotalFatura(getTotalFatura() + valor);
            Transacao transacao = new Transacao(new Date(), valor, "Compra normal");
            historicoDeTransacoes.add(transacao);
        

            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Você não possui limite necessário para essa compra.");
        }
    }

    
    public void realizarCompra(double valor, boolean aplicarCashback) {
        if (aplicarCashback && taxaCashback > 0) {
            if (valor <= getLimite()) {
                double cashback = valor * (taxaCashback / 100);
                setLimite(getLimite() - valor + cashback);
                setTotalFatura(getTotalFatura() + valor - cashback);
                Transacao transacao = new Transacao(new Date(), valor, "Compra com cashback");
                historicoDeTransacoes.add(transacao);

                System.out.println("Compra com cashback realizada com sucesso! Cashback: R$" + cashback);
            } else {
                System.out.println("Você não possui limite necessário para essa compra.");
            }
        } else {
            realizarCompra(valor); 
        }
    }
}
