public class Nota {
    private Aluno aluno; // 1 aluno pode ter varias notas
    private Disciplina disciplina;
    private double valor;
    private String data; // registra a data em que a nota foi lancada

    public Nota(double valor, String data, Aluno aluno, Disciplina disciplina) {
        this.valor = valor;
        this.data = data;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public double getNota() {
        return this.valor;
    }

    public String getData() {
        return this.data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String relatorioNotas() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Aluno: ").append(aluno.getNome())
                .append(" - Nota: ").append(this.valor)
                .append(" | Data: ").append(this.data)
                .append(" | Disciplina: ").append(disciplina.getNome())
                .append("\n");

        return relatorio.toString();
    }
}
