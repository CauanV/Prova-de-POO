import java.io.FileWriter;
import java.util.ArrayList;

public class Disciplina {
    String nome;
    String cargaHoraria;
    String codigo;
    ArrayList<Professor> professores = new ArrayList<Professor>(); // responsaveis por lecionar a disciplina

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

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public String relatorioDisciplina() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("NOME: " + this.nome + "\n").append("CARGA HORARIA: " + this.cargaHoraria + "\n")
                .append("CODIGO: " + this.codigo + "\n");
        for (Professor professor : professores) { // se tiver professores sera acrescentado no relatorio
            relatorio.append(professor.relatorioProfessor()).append("\n");
        }
        return relatorio.toString();
    }

    public void CadastrarDisciplina(Disciplina disciplina) {
        try {
            FileWriter escrita = new FileWriter("Disciplinas.txt", true);
            ArrayList<Professor> professores = disciplina.getProfessores();

            String dadosProfessores = "";

            escrita.append(disciplina.getNome() + " - " + disciplina.getCargaHoraria() + " - " + disciplina.getCodigo()
                    + "\n");
            for (Professor professor : professores) {
                dadosProfessores += professor.getNome() + " - ";
            }

            escrita.append(dadosProfessores + "\n");

            escrita.close();
        } catch (Exception e) {
            System.out.println("Falha na escrita da disciplina!");
        }
    }

}