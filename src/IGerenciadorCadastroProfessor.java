import java.util.ArrayList;

interface GerenciadorCadastroProfessor {
    void cadastrarProfessor(String nome, String dataNascimento, String telefone, Endereco endereco, String areaDeFormacao, String anoDeAdmissao, String email, Disciplina disciplina);
}