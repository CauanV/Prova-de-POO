import java.util.ArrayList;

public class Turma {
    private int anoLetivo;
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma(int anoLetivo, String codigo, Disciplina disciplina, Professor professor) {
        this.anoLetivo = anoLetivo;
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public String relatorioTurmas() {
        StringBuilder turma = new StringBuilder();
        turma.append("Código da Turma: ").append(this.codigo).append("\n")
             .append("Ano Letivo da Turma: ").append(this.anoLetivo).append("\n")
             .append("Disciplina da Turma: ").append(this.disciplina.getNome()).append("\n")
             .append("Professor: ").append(this.professor.getNome()).append("\n");

        return turma.toString();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void adicionaAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Disciplina getDisciplina(){
        return this.disciplina;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public Professor getProfessor(){
        return this.professor;
    }

    @Override
    public String toString() {
        StringBuilder relatorio = new StringBuilder();
        
        relatorio.append("Ano Letivo: ").append(this.anoLetivo).append("\n")
                 .append("Código da Turma: ").append(this.codigo).append("\n")
                 .append("Disciplina: ").append(this.disciplina.relatorioDisciplina()).append("\n")
                 .append("Professor: ").append(this.professor.relatorioProfessor()).append("\n")
                 .append("Alunos:\n");
        
        for (Aluno aluno : alunos) {
            relatorio.append(aluno.relatorioAlunos()).append("\n"); // Certifique-se de que `relatorioAlunos` existe
        }
        
        return relatorio.toString();
    }
}
