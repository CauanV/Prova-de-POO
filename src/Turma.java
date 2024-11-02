import java.util.ArrayList;
import java.util.List;

public class Turma implements GerenciadorCadastroAluno {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private int anoLetivo;

    public Turma(String codigo, Disciplina disciplina, Professor professor, int anoLetivo) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.anoLetivo = anoLetivo;
    }

    //construtor2
    public Turma(String codigo, int anoLetivo) {
        this.codigo = codigo;
        this.anoLetivo = anoLetivo;
    }

    @Override
    public void cadastrarAluno(String nome, String dataNascimento, String telefone, Endereco endereco, String matricula, int anoIngresso, ArrayList<Nota> nota){
        //se eu vou cadastrar um aluno eu preciso criar um objeto aluno e adicionar ele na array de alunos logo:
        Aluno objAluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso, nota);
        alunos.add(objAluno);
    } //AQUI TALVEZ EU PUDESSE PASSAR SO UM OBJ DO TIPO ALUNO MAS FIZ DESSE JEITO 

    

    public void setAdicionarAlunos(Aluno aluno){
        this.alunos.add(aluno);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

}
