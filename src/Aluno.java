import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private int anoIngresso;
    private ArrayList<Nota> Array_notas;

    public Aluno(String nome, String dataNasc, String telefone, Endereco endereco, String matricula, int anoIngresso,
            ArrayList<Nota> notas) {
        super(nome, dataNasc, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
        this.Array_notas = new ArrayList<Nota>();;
    }

    // construtor2
    public Aluno(String nome, String dataNasc, String telefone, Endereco endereco, String matricula, int anoIngresso) {
        super(nome, dataNasc, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public ArrayList<Nota> getArray_notas() {
        return Array_notas;
    }

    public void setArray_notas(ArrayList<Nota> array_notas) {
        Array_notas = array_notas;
    }

    // metodos get da superclasse
    public String getNome() {
        return super.getNome();
    }

    public String getDataNasc() {
        return super.getDataNasc();
    }

    public String getTelefone() {
        return super.getTelefone();
    }

    public Endereco getEndereco() {
        return super.getEndereco();
    }
}
