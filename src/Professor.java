import java.util.ArrayList;

public class Professor extends Pessoa implements IGerenciadorCadastroProfessor {
    private String areaDeFormacao;
    private String anoAdmissao;
    private String email;
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Professor(String nome, String dataNascimento, String telefone, Endereco endereco) {
        super(nome, dataNascimento, telefone, endereco);
    }

    public String getNome() {
        return this.nome;
    }

    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void adicionaDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina);
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
        relatorio.append("\nNOME: " + this.nome + "\n").append("DATA DE NASCIMENTO: " + this.dataNascimento + "\n")
                .append("TELEFONE: " + this.telefone + "\n")
                .append("ENDERECO: " + this.endereco.getRua() + "\n" + " Cidade: " + this.endereco.getCidade() + "\n" +
                        " estado: " + this.endereco.getEstado() + "\n" + " cep: " + this.endereco.getCep() + "\n")
                .append(" AREA DE FORMACAO: " + this.areaDeFormacao + "\n")
                .append("Ano admissao: " + this.anoAdmissao + "\n")
                .append("email: " + this.email + "\n").append("Disciplinas: ");
        for (Disciplina d : disciplinas) {
            relatorio.append(d.getNome());
            relatorio.append(" |");
            relatorio.append("\n");
        }
        return relatorio.toString();
    }

    @Override
    public void cadastrarProfessor(String areaDeFormacao, String anoAdmissao, String email, Disciplina disciplina) {
        this.areaDeFormacao = areaDeFormacao;
        this.anoAdmissao = anoAdmissao;
        this.email = email;
        disciplinas.add(disciplina);
    }

}
