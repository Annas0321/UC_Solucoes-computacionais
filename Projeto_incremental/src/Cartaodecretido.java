public class Cartaodecretido {
    private int numero;
    private String nomeTitular; 
    private String cpf;
    private double limite;
    private double totalFatura;

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

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }

    public double getTotalFatura() {
       return totalFatura;
    }

    public void setTotalFatura(double totalFatura){
        this.totalFatura = totalFatura;
    }

    public double consultarLimite(){
        return getLimite();
    }

    public double consultarTotalFatura(){
        return getTotalFatura();
    }

    public void realizarCompra(double valor) {
        if (valor <= getLimite()){
            setLimite(getLimite() - valor);
            setTotalFatura(getTotalFatura() + valor);
            System.out.println("Compra realizada com sucesso!");
        } 
        else{
            System.out.println("Você não possui limite necessário para essa compra");
        }
    }

}