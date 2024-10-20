public class Cartaodecretido {
    int numero;
    String nomeTitular; 
    String cpf;
    double limite;
    double totalFatura;

    public double consultarLimite(){
        return limite;
    }

    public double consultarTotalFatura(){
        return totalFatura;
    }

    public void realizarCompra(double valor) {
        if (valor <= this.limite){
            this.limite -= valor;
            this.totalFatura += valor;
        } 
        else{
            System.out.println("Você não possui limite necessario para essa compra");
        }
    }

}