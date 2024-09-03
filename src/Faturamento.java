public class Faturamento {
    private String dia;
    private double valor;

    public Faturamento(String dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public Faturamento() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Faturamento{" +
                "dia='" + dia + '\'' +
                ", valor=" + valor +
                '}';
    }
}
