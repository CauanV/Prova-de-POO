import java.util.ArrayList;

public class Disciplina {
    String nome;
    String cargaHoraria;
    String codigo;
    ArrayList<Professor> professores = new ArrayList<Professor>(); //responsaveis porlecionar a disciplina

    public Disciplina(String nome, String cargaHoraria, String codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }

    public void AdicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public String getNome() {
        return this.nome;
      }
}
