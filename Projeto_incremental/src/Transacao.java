import java.util.Date;
import java.text.SimpleDateFormat;

public class Transacao {
    private Date data;
    private double valor;
    private String descricao;

    public Transacao(Date data, double valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data) + " - " + descricao + ": R$" + String.format("%.2f", valor);
    }
}
