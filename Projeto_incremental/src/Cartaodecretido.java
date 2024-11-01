public class Cartaodecretido {
    private int numero;
    private String nomeTitular;
    private String cpf; 
    private double limite;
    private double totalFatura;
    private double taxaCashback; 

    
    public Cartaodecretido(int numero, String nomeTitular, String cpf) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf; 
        this.limite = 1000; 
        this.totalFatura = 0;
        this.taxaCashback = 0;
    }

   
    public Cartaodecretido(int numero, String nomeTitular, String cpf, double limite, double taxaCashback) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf; 
        this.limite = limite;
        this.totalFatura = 0;
        this.taxaCashback = taxaCashback;
    }

    // Getters e setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    
    public void realizarCompra(double valor) {
        if (valor <= getLimite()) {
            setLimite(getLimite() - valor);
            setTotalFatura(getTotalFatura() + valor);
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
                System.out.println("Compra com cashback realizada com sucesso! Cashback: R$" + cashback);
            } else {
                System.out.println("Você não possui limite necessário para essa compra.");
            }
        } else {
            realizarCompra(valor); 
        }
    }
}
