import java.util.ArrayList;
import java.util.List;

public class Disciplina implements GerenciadorCadastroProfessor {
    private String nome;
    private String cargaHoraria;
    private String codigo;
    private ArrayList<Professor> professores = new ArrayList<>();

    public Disciplina(String nome, String cargaHoraria, String codigo, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professores.add(professor);
    }

    @Override
    public void cadastrarProfessor(String nome, String dataNascimento, String telefone, Endereco endereco,
            String areaDeFormacao, String anoDeAdmissao, String email, Disciplina disciplina) {
        // Criação correta do objeto Professor
        Professor objProfessor = new Professor(areaDeFormacao, anoDeAdmissao, email, nome, anoDeAdmissao, telefone,
                endereco,disciplina);
        professores.add(objProfessor);
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
            professor.adicionarDisciplina(this); // Garante a relação bidirecional
        }
    }
}
