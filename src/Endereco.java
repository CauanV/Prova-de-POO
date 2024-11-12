public class Endereco {
  private String rua;
  private String cidade;
  private String estado;
  private String cep;

  public Endereco(String rua, String cidade, String estado, String cep) {
    this.rua = rua;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  @Override
  public String toString() {
    return "Cidade: " + this.cidade + " | Estado: " + this.estado + " | CEP: " + this.cep;
  }

  public String getRua() {
    return this.rua;
  }

  public String getCidade() {
    return this.cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public String getCep() {
    return this.cep;
  }

}