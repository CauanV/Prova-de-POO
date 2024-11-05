import java.util.ArrayList;

public class Professor extends Pessoa implements GerenciadorCadastroProfessor{
    String areaDeFormacao;
    String anoAdmissao;
    String email;
    ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Professor(String nome, String dataNascimento, String telefone, Endereco endereco, String areaDeFormacao, String anoAdmissao, String email){
        super(nome, dataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;
        this.anoAdmissao = anoAdmissao;
        this.email = email;
    }

    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public String getAnoAdmissao() {
        return anoAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public void CadastrarProfessor() {
      // TODO Auto-generated method stub
    }

}
