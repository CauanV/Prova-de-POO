import java.util.ArrayList;

public class Professor extends Pessoa implements GerenciadorCadastroProfessor {
    String areaDeFormacao;
    String anoAdmissao;
    String email;
    ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Professor(String nome, String dataNascimento, String telefone, Endereco endereco, String areaDeFormacao,
            String anoAdmissao, String email, Disciplina disciplina) {
        super(nome, dataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;
        this.anoAdmissao = anoAdmissao;
        this.email = email;
        disciplinas.add(disciplina);
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

    public String relatorioProfessor() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("NOME: " + this.nome + "\n").append("DATA DE NASCIMENTO: " + this.dataNascimento + "\n")
                .append("TELEFONE: " + this.telefone + "\n")
                .append("ENDERECO: " + this.endereco.getRua()  + "\n" + " Cidade: " + this.endereco.getCidade() + "\n"+
                        " estado: " + this.endereco.getEstado()  + "\n" + " cep: " + this.endereco.getCep() + "\n")
                .append(" AREA DE FORMACAO: " + this.areaDeFormacao + "\n").append("Ano admissao: " + this.anoAdmissao + "\n")
                .append("email: " + this.email + "\n").append("Disciplinas: " + this.getDisciplinas() + "\n"); // nao sei se este de disciplinas esta funcionando , verificar.
        return relatorio.toString();
    }

    @Override
    public void CadastrarProfessor() {
        // TODO Auto-generated method stub
    }

}
