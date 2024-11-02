public class Nota {
    private double valor;
    private String dataLancNota;

    public Nota(double valor, String data) {
        this.valor = valor;
        this.dataLancNota = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataLancNota() {
        return dataLancNota;
    }

    public void setDataLancNota(String dataLancNota) {
        this.dataLancNota = dataLancNota;
    }

}
