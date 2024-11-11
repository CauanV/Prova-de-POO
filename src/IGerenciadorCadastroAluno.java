import java.util.ArrayList;

public interface IGerenciadorCadastroAluno{
	public void cadastrarAluno(String nome, String dataNascimento, String telefone, Endereco endereco,
			String matricula, int anoIngresso, ArrayList<Nota> notas);
}
