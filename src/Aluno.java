import java.util.ArrayList;

public class Aluno extends Pessoa implements GerenciadorCadastroAluno {
    String matricula;
    int anoIngresso;
    ArrayList<Nota> notas = new ArrayList<Nota>(); // ou seja um aluno pode ter varias notas

    public Aluno(String nome, String dataNascimento, String telefone, Endereco endereco, String matricula,
            int anoIngresso) {
        super(nome, dataNascimento, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void adicionarNota(Nota nota) {
        this.notas.add(nota);
    }

    public double calcularMedia() {
        if (notas.isEmpty())
            return 0;
        double soma = 0;
        for (Nota nota : notas) {
            soma += nota.getNota();
        }
        return soma / notas.size();
    }

    public String relatorioNotas() {
        StringBuilder relatorio = new StringBuilder();
        for (Nota nota : notas) {
            relatorio.append("Nome: ").append(this.getNome())
                    .append("\tMatricula: ").append(this.matricula)
                    .append("\tNota: ").append(nota.getNota()).append("\n");
        }
        return relatorio.toString();
    }

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    @Override
    public void CadastrarAluno() {
        // Implementação do método
    }

    // @Override
    public String RelatorioAlunos() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Nome: ").append(this.getNome())
                .append(" | Matrícula: ").append(this.matricula)
                .append(" | Ano de Ingresso: ").append(this.anoIngresso)
                .append(" | Data de Nascimento: ").append(this.getDataNascimento())
                .append(" | Endereço: ").append(this.getEndereco().toString())
                .append(" | Telefone: ").append(this.getTelefone())
                .append("\nNotas:\n");
        for (Nota nota : this.notas) {
            relatorio.append(" - Nota: ").append(nota.getNota())
                    .append(" | Data: ").append(nota.getData())
                    .append("\n");
        }
        return relatorio.toString();
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }
}
