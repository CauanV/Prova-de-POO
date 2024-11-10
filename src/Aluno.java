import java.util.ArrayList;

public class Aluno extends Pessoa implements GerenciadorCadastroAluno {
    private String matricula;
    private int anoIngresso;
    private ArrayList<Nota> notas = new ArrayList<>();

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

    public String relatorioAlunoNotasMedia() {
        StringBuilder relatorio = new StringBuilder();

        // Relatório de Aluno
        relatorio.append("Relatório de Aluno:\n")
                .append("Nome: ").append(this.getNome()).append("\n")
                .append("Matrícula: ").append(this.matricula).append("\n")
                .append("Ano de Ingresso: ").append(this.anoIngresso).append("\n")
                .append("Data de Nascimento: ").append(this.getDataNascimento()).append("\n")
                .append("Endereço: ").append(this.getEndereco().toString()).append("\n")
                .append("Telefone: ").append(this.getTelefone()).append("\n");

        // Relatório das Notas
        relatorio.append("\nNotas:\n");
        for (Nota nota : this.notas) {
            relatorio.append(" - Nota: ").append(nota.getNota())
                    .append(" | Data: ").append(nota.getData())
                    .append("\n");
        }

        // Média das notas
        relatorio.append("Média das Notas: ").append(this.calcularMedia()).append("\n");

        return relatorio.toString();
    }

    public String relatorioNotas() {
        StringBuilder relatorio = new StringBuilder();
        for (Nota nota : notas) {
            relatorio.append("Nome: ").append(this.getNome())
                    .append("\tMatrícula: ").append(this.matricula)
                    .append("\tNota: ").append(nota.getNota())
                    .append("\n");
        }
        return relatorio.toString();
    }

    @Override
    public void CadastrarAluno() {
        // Implementação do método
    }

    @Override
    public String relatorioAlunos() { // Corrigido para minúscula
        StringBuilder relatorio = new StringBuilder();

        // Relatório de Aluno
        relatorio.append("Relatório de Aluno:\n")
                .append("Nome: ").append(this.getNome()).append("\n")
                .append("Matrícula: ").append(this.matricula).append("\n")
                .append("Ano de Ingresso: ").append(this.anoIngresso).append("\n")
                .append("Data de Nascimento: ").append(this.getDataNascimento()).append("\n")
                .append("Endereço: ").append(this.getEndereco().toString()).append("\n")
                .append("Telefone: ").append(this.getTelefone()).append("\n");

        return relatorio.toString();
    }

    public double getMaiorNota(){
        double maiorNota = 0;
        for (Nota nota : notas) {
            if(nota.getNota() > maiorNota){
            maiorNota = nota.getNota(); 
        }
        }
        return maiorNota;
    }
}
