import java.util.ArrayList;

public interface IGerenciadorCadastroProfessor {
    public void cadastrarProfessor (String nome, String dataNascimento, String telefone, Endereco endereco,
			String areaFormacao, String anoAdmissao, String email, ArrayList<Disciplina> disciplinas);

  }