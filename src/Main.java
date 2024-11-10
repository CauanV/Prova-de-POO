import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.NameNotFoundException;
import javax.naming.NoPermissionException;

public class Main {
  public static void main(String[] args) {
    int opcao;
    boolean continuar = true;
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
          // codigo para cadastrar aluno aqui **** INFORMACAO NOVA: aluno so pode ser
          // cadastrado se ja tiver UMA TURMA CADASTRADA
          if (turmas.size() == 0) {
            System.out.println("Impossivel adicionar um aluno antes de ter uma turma cadastrada");
            break;
          }
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
          Endereco endereco = new Endereco(rua, cidade, estado, cep);
          System.out.println("Digite a matricula que voce quer atribuir a ele e em seguida o ano de ingresso ");
          String matricula = scanner.nextLine();
          // verificar se a matricula ja
          // existe-----------------------------------------------------------------------------------------
          // try {
          // for (Aluno aluno : alunos) {
          // if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
          // throw new IllegalArgumentException("Esta matrícula já existe.");
          // }
          // }
          // } catch (IllegalArgumentException e) {
          // System.out.println(e.getMessage());
          // }
          // int anoIngresso = scanner.nextInt();
          // scanner.nextLine();
          // Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula,
          // anoIngresso);
          // alunos.add(aluno);
          // System.out.println("Em qual turma este aluno sera alocado ?");
          // for (Turma listaDeTurmas : turmas) {
          // System.out.println(listaDeTurmas.getCodigo());
          // }
          // String turmaEscolhida = scanner.nextLine();
          // for (Turma turma : turmas) {
          // if (turma.getCodigo().equalsIgnoreCase(turmaEscolhida)) {
          // turma.adicionaAlunos(aluno);
          // System.out.println("**** Aluno cadastrado com sucesso ****");
          // } else {
          // System.out.println("Turma nao encontrada.");
          // break;
          // }
          // }------------------------------------------------------------------------------------
          while (true) {
            try {
              // Verificar se a matrícula já existe
              boolean matriculaExiste = false;
              for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                  matriculaExiste = true;
                  break; // Sai do loop se a matrícula for encontrada
                }
              }

              if (matriculaExiste) {
                throw new IllegalArgumentException("Esta matrícula já existe.");
              }

              // Se a matrícula não existir, solicita o ano de ingresso e cria o aluno
              System.out.println("Digite o ano de ingresso do aluno:");
              int anoIngresso = scanner.nextInt();
              scanner.nextLine(); // Consumir o buffer do scanner

              Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso);
              alunos.add(aluno);

              System.out.println("Em qual turma este aluno será alocado?");
              for (Turma listaDeTurmas : turmas) {
                System.out.println(listaDeTurmas.getCodigo());
              }

              String turmaEscolhida = scanner.nextLine();
              boolean turmaEncontrada = false;
              for (Turma turma : turmas) {
                if (turma.getCodigo().equalsIgnoreCase(turmaEscolhida)) {
                  turma.adicionaAlunos(aluno);
                  System.out.println("**** Aluno cadastrado com sucesso ****");
                  turmaEncontrada = true;
                  break;
                }
              }

              if (!turmaEncontrada) {
                System.out.println("Turma não encontrada.");
              }
              break; // Sai do loop quando tudo estiver correto

            } catch (IllegalArgumentException e) {
              // Se a matrícula já existir, pede uma nova matrícula
              System.out.println(e.getMessage());
              System.out.println("Digite a matrícula que você quer atribuir a ele:");
              matricula = scanner.nextLine(); // Atualiza a variável matricula
            }
          }
          break;
        case 2:
          // codigo para cadastrar professor
          if (disciplinas.size() == 0) {
            System.out.println("Nao e possivel cadastrar um professor se nao tiver pelo menos 1 disciplina.");
            break;
          } else {
            System.out.println("A qual disciplina voce quer associar este professor? (digite o codigo)");
            for (Disciplina disciplina : disciplinas) {
              System.out.println(disciplina.getNome() + " \nCódigo: " + disciplina.getCodigo());
            }
            String disciplinaProfessor = scanner.nextLine(); // lendo o codigo da disciplina
            Disciplina disciplinaAssociada = null;
            for (Disciplina disciplina : disciplinas) {
              if (disciplina.getCodigo().equalsIgnoreCase(disciplinaProfessor)) {
                disciplinaAssociada = disciplina;
                break;
              }
            }
            // Verifica se a disciplina foi encontrada
            if (disciplinaAssociada == null) {
              System.err.println("Não foi encontrada tal disciplina.");
              break; // Encerra o case 2 se não for encontrada
            }
            System.out.println("Digite o nome do professor:");
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
            System.out.println("Qual a area de formacao deste professor");
            String areaDeFormacao = scanner.nextLine();
            System.out.println("qual o ano Admissao e o email logo em seguida");
            String anoAdmissao = scanner.nextLine();
            String email = scanner.nextLine();
            Endereco enderecoP = new Endereco(ruaP, cidadeP, estadoP, cepP);
            Professor professor = new Professor(nomeP, dataNascimentoP, telefoneP, enderecoP, areaDeFormacao,
                anoAdmissao, email, disciplinaAssociada);
            if (professor != null) {
              System.out.println("**** Professor cadastrado com sucesso. ****");
            }
            professores.add(professor);
          }
          break;
        case 3:
          // Cadastrar Disciplina
          System.out.println("Informe o nome da disciplina:");
          String nomeD = scanner.nextLine();
          System.out.println("Informe a carga horaria da disciplina:");
          String cargaHoraria = scanner.nextLine();
          String codigoD = String.valueOf(disciplinas.size() + 1);
          Disciplina disciplina = new Disciplina(nomeD, cargaHoraria, codigoD);
          if (disciplina != null) {
            System.out.println("**** DISCIPLINA CADASTRADA COM SUCESSO ****");
          }
          disciplinas.add(disciplina);
          break;

        case 4:
          // cadastrar turma --- primeiro passo é verificar se tem disciplinas e
          // professores disponiveis (ja cadastrados)
          if (disciplinas.isEmpty() || professores.isEmpty()) {
            try {
              throw new NoPermissionException(
                  "Para cadastrar uma turma, é necessário ter pelo menos uma disciplina e um professor cadastrados.");
            } catch (NoPermissionException e) {
              System.out.println(e.getMessage());
              break; // Sai do case, pois não é possível cadastrar a turma
            }
          }
          // caso tenha, continuar o cadastro
          System.out.println("Informe o ano letivo da turma:");
          int anoLetivo = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Selecione a disciplina para a turma: (digite o codigo da disciplina)");
          for (Disciplina d : disciplinas) {
            System.out.println("DISCIPLINA: " + d.getNome() + " CODIGO: " + d.getCodigo() + "\n");
          }
          String codigoDiscSelecionada = scanner.nextLine();
          Disciplina discEscolhida = null;
          for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigoDiscSelecionada)) {
              discEscolhida = d;
            }
          }
          // agora eu preciso de um professor, uma vez que a disciplina ja esta
          // selecionada (discEscolhida)
          System.out.println("Selecione o professor para a turma: (digite o nome)");
          for (Professor p : professores) {
            System.out.println(p.getNome() + " \n");
          }
          String nomeProfessorSelecionado = scanner.nextLine();
          Professor professorEscolhido = null;
          for (Professor p : professores) {
            if (p.getNome().equalsIgnoreCase(nomeProfessorSelecionado)) {
              professorEscolhido = p;// agora eu tambem tenho o professor
            }
          }
          String codigoTurma = String.valueOf(turmas.size() + 1);
          Turma turma = new Turma(anoLetivo, codigoTurma, discEscolhida, professorEscolhido);
          if (turma != null) {
            System.out.println("**** TURMA CADASTRADA COM SUCESSO ****");
          }
          turmas.add(turma);
          break;

        case 5:
          // inserir nota
          System.out.println("Qual o valor da nota: ");
          double valor = scanner.nextDouble();
          scanner.nextLine();
          System.out.println("Dar nota a qual aluno: (digite o nome)");
          for (Aluno percorreAluno : alunos) {
            System.out.println(percorreAluno.getNome());
          }
          String NotaQualAluno = scanner.nextLine();
          // verificar se este aluno existe
          boolean encontrado = false;
          for (Aluno percorreAluno : alunos) {
            if (percorreAluno.getNome().equalsIgnoreCase(NotaQualAluno)) {
              encontrado = true;
              System.out.println("Qual a data de lancamento desta nota: ");
              String LancDataNota = scanner.nextLine();
              Nota nota = new Nota(valor, LancDataNota);
              percorreAluno.adicionarNota(nota);
              System.out.println("**** NOTA ADICIONADA COM SUCESSO ****");
              break;
            }
          }
          if (!encontrado) {
            System.out.println("Aluno nao encontrado");
          }
          break;
        case 6:
          // relatorio de alunos
          for (Aluno alun : alunos) {
            System.out.println(alun.relatorioAlunos());
          }
          break;
        case 7:
          // relatorio professores
          for (Professor professor : professores) {
            System.out.println(professor.relatorioProfessor());
            System.out.println("*******************************");
          }
          break;
        case 8:
          // relatorio de disciplinas
          for (Disciplina percorreDisciplina : disciplinas) {
            System.out.println(percorreDisciplina.relatorioDisciplina());
          }
          break;
        case 9:
          // relatorio de turmas
          for (Turma percorreTurma : turmas) {
            System.out.println(percorreTurma.relatorioTurmas());
          }
          break;
        case 10:
          for (Aluno percorreAluno : alunos) {
            System.out.println(percorreAluno.relatorioAlunoNotasMedia());
          }
          break;
        case 11:
          // quantidade de alunos cadastrados
          System.out.println(alunos.size());
          break;
        case 12:
          double maiorNota = 0;
          String nomeMaiorNota = "";
          for (Aluno al : alunos) {
            if (al.getMaiorNota() > maiorNota) {
              nomeMaiorNota = al.getNome();
              maiorNota = al.getMaiorNota();
            }
          }
          System.out.println("ALUNO DE MAIOR NOTA: " + nomeMaiorNota + " | NOTA: ");
          System.out.printf("%.2f\n", maiorNota);
          break;
        case 13:
          System.out.println("Informe a disciplina que deseja visualizar:");
          String nomeDisciplina = scanner.nextLine();
          boolean encont = false;

          try {
            // Loop para procurar a disciplina
            for (Turma t : turmas) {
              if (t.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplina)) {
                encont = true;
                // Listando alunos da disciplina
                for (Aluno a : t.getAlunos()) {// talvez trocar aluno por arraylist aluno
                  System.out.println("Nome: " + a.getNome() + " | Matrícula: " + a.getMatricula());
                }
                break; // Se encontrar a disciplina, sai do loop
              }
            }

            // Se a disciplina não for encontrada, lança a exceção
            if (!encont) {
              throw new NameNotFoundException("Disciplina " + nomeDisciplina + " não está cadastrada!");
            }

          } catch (NameNotFoundException e) {
            // Captura a exceção e imprime a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
          }
          break;
        case 14:
          System.out.println("Informe o nome do professor que deseja consultar:");
          String nomeProfessor = scanner.nextLine();
          boolean encontrad = false;
          System.out.println("Turmas do professor " + nomeProfessor + ":");
          for (Turma t : turmas) {
            if (t.getProfessor().getNome().equalsIgnoreCase(nomeProfessor)) {
              System.out.println("- " + t.getCodigo());
              encontrad = true;
            }
          }
          if (!encontrad) {
            System.out.println("Nenhuma turma encontrada para o professor " + nomeProfessor + ".");
          }
          scanner.close();
          break;
        case 15:
          System.out.println("ENCERRANDO O PROGRAMA.....");
          continuar = false;
          break;
      }
    } while (continuar);
    scanner.close();
  }
}