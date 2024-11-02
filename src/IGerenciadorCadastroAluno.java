import java.util.ArrayList;

interface GerenciadorCadastroAluno {
    void cadastrarAluno(String nome, String dataNascimento, String telefone, Endereco endereco, String matricula, int anoIngresso, ArrayList<Nota> nota);
}
