import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.NoPermissionException;

public class Main {
  public static void main(String[] args) {
        int opcao;
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=================================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("=================================");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Disciplina");
            System.out.println("4. Cadastrar Turma");
            System.out.println("5. Inserir Nota");
            System.out.println("6. Relatório Alunos");
            System.out.println("7. Relatório Professores");
            System.out.println("8. Relatório Disciplinas");
            System.out.println("9. Relatório Turmas");
            System.out.println("10. Relatório de Aluno x Notas x média");
            System.out.println("11. Quantidade de Alunos Cadastrados");
            System.out.println("12. Nome do aluno que possui a maior nota");
            System.out.println("13. Listar os alunos de uma determinada disciplina");
            System.out.println("14. Listar as turmas que estão associadas a um determinado professor");
            System.out.println("15. Sair");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de nova linha
            switch (opcao) {
                case 1:
                    //codigo para cadastrar aluno aqui
                    System.out.println("Digite o nome do Aluno:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a data de nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.println("Digite o telefone para cadastro: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite a rua: ");
                    String rua = scanner.nextLine();
                    System.out.println("Digite a cidade o estado e o CEP: ");
                    String cidade = scanner.nextLine();
                    String estado = scanner.nextLine();
                    String cep = scanner.nextLine();
                    Endereco endereco = new Endereco(rua,cidade,estado,cep);
                    System.out.println("Digite a matricula que voce quer atribuir a ele e em seguida o ano de ingresso ");
                    String matricula = scanner.nextLine();
                    int anoIngresso = scanner.nextInt();
                    scanner.nextLine();
                    Aluno aluno = new Aluno(nome,dataNascimento,telefone,endereco,matricula,anoIngresso);
                    alunos.add(aluno);
                break;
                case 2:
                    //codigo para cadastrar professor
                    System.out.println("Digite o nome do Aluno:");
                    String nomeP = scanner.nextLine();
                    System.out.println("Digite a data de nascimento: ");
                    String dataNascimentoP = scanner.nextLine();
                    System.out.println("Digite o telefone para cadastro: ");
                    String telefoneP = scanner.nextLine();
                    System.out.println("Digite a rua: ");
                    String ruaP = scanner.nextLine();
                    System.out.println("Digite a cidade o estado e o CEP: ");
                    String cidadeP = scanner.nextLine();
                    String estadoP = scanner.nextLine();
                    String cepP = scanner.nextLine();
                    Endereco enderecoP = new Endereco(ruaP,cidadeP,estadoP,cepP);
                    Professor professor = new Professor(nomeP, dataNascimentoP, telefoneP, enderecoP, cidadeP, estadoP, cepP);
                    professores.add(professor);
                break;
                case 3:
                    //Cadastrar Disciplina
                    System.out.println("Informe o nome da disciplina:");
                    String nomeD = scanner.nextLine();
                    System.out.println("Informe a carga horaria da disciplina:");
                    String cargaHoraria = scanner.nextLine();
                    System.out.println("Digite um codigo pra disciplina");
                    String codigoD = scanner.nextLine();
                    Disciplina disciplina = new Disciplina(nomeD, cargaHoraria, codigoD);
                    System.out.println("Informe a quantidade de professores que lecionam a disciplina:");
                    int quantidadeProfessores = scanner.nextInt();
                    scanner.nextLine();//consumir linha
                    while (quantidadeProfessores > 0) {
                        System.out.println("Informe o nome do professor:");
                        String nomeProfessor = scanner.nextLine();
                        boolean encontrado = false;
                        for (Professor professorLista : professores) {
                          if (professorLista.getNome().equalsIgnoreCase(nomeProfessor)) {
                            encontrado = true;
                            disciplina.AdicionarProfessor(professorLista);
                            break;
                          }
                        }
            
                        if (!encontrado) {
                          System.out.println("Professor " + nomeProfessor + " não encontrado!");
                        } else quantidadeProfessores--;
                      }
                      disciplinas.add(disciplina);
                      System.out.println("Disciplina cadastrada com sucesso!\n\n");
                break;
                case 4:
                    //cadastrar turma --- primeiro passo é verificar se tem disciplinas e professores disponiveis (ja cadastrados)
                    if(disciplinas.isEmpty() || professores.isEmpty()){
                        throw new NoPermissionException("Para cadastrar uma turma, é necessário ter pelo menos uma disciplina e um professor cadastrados.");
                    }
                      //caso tenha, continuar o cadastro
                    System.out.println("Informe o ano letivo da turma:");
                    int anoLetivo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Selecione a disciplina para a turma:");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println(i + ". " + disciplinas.get(i).getNome()); //disciplinas.get(0).getNome ||| .get acessa o indice nesta posicao especifica
                    }
                    // int i = 0;
                    // for (Disciplina percorreDisciplinas : disciplinas) {          |
                    //   System.out.println(i + percorreDisciplinas.getNome());      |- funciona tambem 
                    //   i++;                                                        |
                    // }
                    int indiceDisciplina = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Qual o codigo que sera atribuido à disciplina: ");
                    String codigoDisciplina = scanner.nextLine();
                    Disciplina disciplinaSelecionada = disciplinas.get(indiceDisciplina);
                    Turma turma = new Turma(anoLetivo, codigoDisciplina, disciplinaSelecionada);
                    //marcação de voce sabe o queeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
                    turmas.add(turma);
                break;
                case 5:
                    //inserir nota
                  System.out.println("Qual o valor da nota: ");
                  double valor = scanner.nextDouble();
                  scanner.nextLine();
                  System.out.println("Dar nota a qual aluno: (digite o nome)");
                  for (Aluno percorreAluno : alunos) {
                      System.out.println(percorreAluno.getNome());
                    }
                    String NotaQualAluno = scanner.nextLine();
                    //verificar se este aluno existe
                    boolean encontrado = false;
                    for (Aluno percorreAluno : alunos) {
                      if(percorreAluno.getNome().equalsIgnoreCase(NotaQualAluno)){
                        encontrado = true;
                        System.out.println("Qual a data de lancamento desta nota: ");
                        String LancDataNota = scanner.nextLine();
                        Nota nota = new Nota(valor, LancDataNota);
                        percorreAluno.adicionarNota(nota);//nao pode ser alunoS porque este seria uma lista (ou seja mais de um aluno vc nao ta especificando qual ja este e o desejado)
                        break;
                      }
                    }
                    if(!encontrado){
                      System.out.println("Aluno nao encontrado");
                    }
                break;
                
        }       
    }
}