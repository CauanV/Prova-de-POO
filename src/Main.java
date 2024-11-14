import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.naming.NameNotFoundException;
import java.io.BufferedReader;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    int opcao;
    boolean continuar = true;
    ArrayList<Turma> turmas = new ArrayList<>();
    ArrayList<Aluno> alunos = new ArrayList<>();
    ArrayList<Disciplina> disciplinas = new ArrayList<>();
    ArrayList<Professor> professores = new ArrayList<>();
    ArrayList<Nota> notas = new ArrayList<Nota>();
    Scanner scanner = new Scanner(System.in);
    String nome, dataNascimento, telefone, rua, cidade, estado, cep;
    String matricula, areaDeFormacao, anoAdmissao, email, cargaHoraria, codigo;
    Endereco endereco;
    int anoLetivo;
    Nota nota;
    Scanner leituraArquivo;
    ArrayList<String> textoArquivo = new ArrayList<String>();

    File caminhoDoArquivoProfessores = new File("professores.txt");

    File caminhoDoArquivoAlunos = new File("alunos.txt");

    File caminhoDoArquivoDisciplinas = new File("Disciplinas.txt");

    File caminhoDoArquivoTurmas = new File("Turmas.txt");

    File caminhoDoArquivoNotas = new File("Notas.txt");

    do {
      try {
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
            if (turmas.size() == 0) {
              System.out.println("Impossível adicionar um aluno antes de ter uma turma cadastrada");
              break;
            }
            System.out.println("Digite os dados do aluno:");
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            System.out.print("Data de nascimento: ");
            dataNascimento = scanner.nextLine();
            System.out.print("Telefone: ");
            telefone = scanner.nextLine();

            System.out.print("Endereço Rua: ");
            rua = scanner.nextLine();
            System.out.print("Cidade: ");
            cidade = scanner.nextLine();
            System.out.print("Estado: ");
            estado = scanner.nextLine();
            System.out.print("CEP: ");
            cep = scanner.nextLine();
            endereco = new Endereco(rua, cidade, estado, cep);

            boolean matriculaExistente;

            // Verificar se a matrícula já existe
            do {
              System.out.print("Matrícula: ");
              matricula = scanner.nextLine();

              matriculaExistente = false;
              for (Aluno a : alunos) {
                if (a.getMatricula().equals(matricula)) {
                  matriculaExistente = true;
                  System.out.println("Matrícula já existente. Por favor, insira outra.");
                  break;
                }
              }
            } while (matriculaExistente);

            System.out.print("Ano de ingresso: ");
            int anoIngresso = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco);
            aluno.cadastrarAluno(matricula, anoIngresso);
            alunos.add(aluno);

            System.out.println("Aluno cadastrado com sucesso!");
            try {
              FileWriter escritor = new FileWriter(caminhoDoArquivoAlunos, true);
              escritor.write(aluno.relatorioAlunos());
              escritor.close();
            } catch (IOException e) {
              System.out.println("Erro ao acessar o arquivo para escrita");
            }
            // nao etou adicionando este aluno dentro de nenhuma turma
            System.out.println("Adicionar este aluno à qual turma ? ");
            for (Turma t : turmas) {
              System.out.println(t.getCodigo());
            }
            String leituraCodigo = scanner.nextLine();
            boolean encontr = false;
            while (!encontr) {
              try {
                encontr = false;
                for (Turma t : turmas) {
                  if (t.getCodigo().equalsIgnoreCase(leituraCodigo)) {
                    t.adicionaAlunos(aluno);
                    encontr = true;
                    break; // Interrompe o loop quando a turma for encontrada
                  }
                }
                if (!encontr) {
                  System.out.println("Código não foi encontrado");
                }
              } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
              }
            }
            break;
          case 2:
            if (disciplinas.size() == 0) {
              System.out.println("Não é possível cadastrar um professor sem pelo menos uma disciplina.");
              break;
            }

            System.out.println("A qual disciplina você quer associar este professor? (digite o código)");
            for (Disciplina disciplina : disciplinas) {
              System.out.println(disciplina.getNome() + " \nCódigo: " + disciplina.getCodigo());
            }

            Disciplina disciplinaAssociada = null;
            while (disciplinaAssociada == null) { // Continua até que uma disciplina válida seja encontrada
              try {
                String disciplinaProfessor = scanner.nextLine();

                // Procura a disciplina escolhida pelo usuário
                for (Disciplina disciplina : disciplinas) {
                  if (disciplina.getCodigo().equalsIgnoreCase(disciplinaProfessor)) {
                    disciplinaAssociada = disciplina;
                    break;
                  }
                }

                // Verifica se a disciplina foi encontrada
                if (disciplinaAssociada == null) {
                  System.err.println("Código não encontrado. Tente novamente:");
                }

              } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
              }
            }

            // A partir daqui, você pode associar o professor à disciplina encontrada
            System.out.println("Disciplina associada: " + disciplinaAssociada.getNome());

            // Agora, começa o cadastro do professor
            System.out.println("Digite o nome do professor:");
            nome = scanner.nextLine();
            System.out.println("Digite a data de nascimento: ");
            dataNascimento = scanner.nextLine();
            System.out.println("Digite o telefone para cadastro: ");
            telefone = scanner.nextLine();
            System.out.print("Endereço Rua: ");
            rua = scanner.nextLine();
            System.out.print("Cidade: ");
            cidade = scanner.nextLine();
            System.out.print("Estado: ");
            estado = scanner.nextLine();
            System.out.print("CEP: ");
            cep = scanner.nextLine();
            endereco = new Endereco(rua, cidade, estado, cep);
            System.out.println("Qual a área de formação deste professor?");
            areaDeFormacao = scanner.nextLine();
            System.out.println("Qual o ano de admissão e o e-mail logo em seguida?");
            anoAdmissao = scanner.nextLine();
            email = scanner.nextLine();

            endereco = new Endereco(rua, cidade, estado, cep);
            Professor professor = new Professor(nome, dataNascimento, telefone, endereco);
            professor.cadastrarProfessor(areaDeFormacao, anoAdmissao, email, disciplinaAssociada);

            professores.add(professor);
            System.out.println("**** Professor cadastrado com sucesso. ****");

            System.out.println("Você deseja associar mais disciplinas a este professor? [S ou N]");
            String resposta = scanner.nextLine();

            while (resposta.equalsIgnoreCase("S") || (resposta.equalsIgnoreCase("SIM"))) {
              // Repetir o processo de associação de disciplina
              System.out.println("Escolha outra disciplina para associar a este professor: ");
              for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina.getNome() + " \nCódigo: " + disciplina.getCodigo());
              }

              String novaDisciplinaProfessor = scanner.nextLine();
              Disciplina novaDisciplina = null;

              // Procura a nova disciplina
              for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equalsIgnoreCase(novaDisciplinaProfessor)) {
                  novaDisciplina = disciplina;
                  break;
                }
              }

              // Verifica se a nova disciplina foi encontrada
              if (novaDisciplina == null) {
                System.err.println("Não foi encontrada a disciplina.");
              } else {
                // Associa a nova disciplina ao professor
                professor.adicionaDisciplinas(novaDisciplina); // Aqui, você pode usar o método que já tem para
                                                               // adicionar a disciplina
                System.out.println("Disciplina associada com sucesso!");
              }

              // Pergunta novamente se o usuário quer associar mais disciplinas
              System.out.println("Deseja associar mais disciplinas a este professor? [S ou N]");
              resposta = scanner.nextLine();
              try {
                FileWriter escritor = new FileWriter(caminhoDoArquivoProfessores, true);
                escritor.write(professor.relatorioProfessor());
                escritor.close();
              } catch (IOException e) {
                System.out.println("Erro ao acessar o arquivo para escrita");
              }
            }
            break;
          case 3:
            System.out.println("Informe o nome da disciplina:");
            nome = scanner.nextLine();
            System.out.println("Informe a carga horaria da disciplina:");
            cargaHoraria = scanner.nextLine();
            codigo = String.valueOf(disciplinas.size() + 1);
            Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);
            if (disciplina != null) {
              System.out.println("**** DISCIPLINA CADASTRADA COM SUCESSO ****");
            }
            disciplinas.add(disciplina);
            try {
              FileWriter escritor = new FileWriter(caminhoDoArquivoDisciplinas, true);
              escritor.write(disciplina.relatorioDisciplina());
              escritor.close();
            } catch (IOException e) {
              System.out.println("Erro ao acessar o arquivo para escrita");
            }
            break;
          case 4:
            anoLetivo = 0;
            while (anoLetivo <= 0) {
              try {
                System.out.println("Informe o ano letivo da turma:");
                anoLetivo = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                if (anoLetivo <= 0) {
                  System.out.println("Ano letivo inválido. Tente novamente.");
                }
              } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número para o ano letivo.");
                scanner.nextLine(); // Limpar o
              }
            }

            Disciplina discEscolhida = null;
            while (discEscolhida == null) {
              System.out.println("Selecione a disciplina para a turma: (digite o código da disciplina)");
              for (Disciplina d : disciplinas) {
                System.out.println("DISCIPLINA: " + d.getNome() + " CODIGO: " + d.getCodigo());
              }

              String codigoDiscSelecionada = scanner.nextLine();
              for (Disciplina d : disciplinas) {
                if (d.getCodigo().equalsIgnoreCase(codigoDiscSelecionada)) {
                  discEscolhida = d;
                  break;
                }
              }
              if (discEscolhida == null) {
                System.out.println("Código da disciplina não encontrado. Tente novamente.");
              }
            }

            // imprime pro usuario os professores apenas da disciplina escolhida
            Professor professorEscolhido = null;
            if (discEscolhida != null) {
              while (professorEscolhido == null) {
                System.out.println("Selecione o professor para a turma: (digite o nome)");

                // Filtra os professores da disciplina escolhida
                List<Professor> professoresDaDisciplina = new ArrayList<>();
                for (Professor p : professores) {
                  if (p.getDisciplinas().contains(discEscolhida)) {
                    professoresDaDisciplina.add(p);
                    System.out.println("PROFESSOR: " + p.getNome());
                  }
                }

                if (professoresDaDisciplina.isEmpty()) {
                  System.out.println("Nenhum professor encontrado para essa disciplina.");
                  break; // Encerra caso não haja professor disponível para a disciplina
                }

                String nomeProfessorSelecionado = scanner.nextLine();
                for (Professor p : professoresDaDisciplina) {
                  if (p.getNome().equalsIgnoreCase(nomeProfessorSelecionado)) {
                    professorEscolhido = p;
                    break;
                  }
                }
                if (professorEscolhido == null) {
                  System.out.println("Nome do professor não encontrado. Tente novamente.");
                }
              }
            }

            // Criar e adicionar a turma
            String codigoTurma = String.valueOf(turmas.size() + 1);
            Turma turma = new Turma(anoLetivo, codigoTurma, discEscolhida,
                professorEscolhido);
            turmas.add(turma);
            System.out.println("**** TURMA CADASTRADA COM SUCESSO ****");

            try {
              FileWriter escritor = new FileWriter(caminhoDoArquivoTurmas, true);
              escritor.write(turma.relatorioTurmas());
              escritor.close();
            } catch (IOException e) {
              System.out.println("Erro ao acessar o arquivo para escrita");
            }
            break;
          case 5:
            if (alunos.size() == 0) {
              System.out.println("Impossível cadastrar notas antes de alunos.");
              break;
            } else {
              System.out.println("Qual o valor da nota: ");
              double valor = scanner.nextDouble();
              scanner.nextLine();
              System.out.println("Qual a data de lançamento desta nota: ");
              String LancDataNota = scanner.nextLine();

              System.out.println("Dar nota a qual aluno? (Digite o nome)");
              for (Aluno percorreAluno : alunos) {
                System.out.println(percorreAluno.getNome());
              }
              String NotaQualAluno = scanner.nextLine();
              boolean alunoEncontrado = false;
              Aluno alunoNota = null;

              // Procurar o aluno
              for (Aluno percorreAluno : alunos) {
                if (percorreAluno.getNome().equalsIgnoreCase(NotaQualAluno)) {
                  alunoEncontrado = true;
                  alunoNota = percorreAluno;
                  System.out.println("\nAssociado ao aluno com sucesso!");
                  break;
                }
              }

              if (!alunoEncontrado) {
                System.out.println("ESTE ALUNO NÃO FOI ENCONTRADO.");
                break;
              }

              // Selecionar disciplina
              System.out.println("\nAssocie a disciplina: [Digite o código]");
              for (Disciplina discAuxiliar : disciplinas) {
                System.out.println("Código: " + discAuxiliar.getCodigo() + " Nome: " + discAuxiliar.getNome());
              }

              String respost = scanner.nextLine(); // Captura o código da disciplina
              boolean disciplinaEncontrada = false;
              Disciplina disciplinaNota = null;

              for (Disciplina auxiliar : disciplinas) {
                if (respost.equals(auxiliar.getCodigo())) { // Comparação correta de String
                  disciplinaNota = auxiliar;
                  disciplinaEncontrada = true;
                  System.out.println("\nDisciplina associada com sucesso!");
                  break;
                }
              }

              if (!disciplinaEncontrada) {
                System.out.println("\nDigite uma disciplina válida!");
              } else {
                // Criar a nota e associar ao aluno e disciplina
                nota = new Nota(valor, LancDataNota, alunoNota, disciplinaNota);
                notas.add(nota);
                alunoNota.adicionarNota(nota);
                System.out.println("**** NOTA ADICIONADA COM SUCESSO ****");
                System.out.println("\n" + nota.getNota() + "\n" + nota.getData() + "\n" + nota.getAluno().getNome()
                    + "\n" + nota.getDisciplina().getNome());
              }

            }
            break;
          case 6:
            leituraArquivo = new Scanner(caminhoDoArquivoAlunos);
            if (caminhoDoArquivoAlunos.exists()) {
              try {
                while (leituraArquivo.hasNextLine()) {
                  textoArquivo.add(leituraArquivo.nextLine());
                }
                leituraArquivo.close();
              } catch (Exception e) {
                System.out.println("Erro ao acessar o arquivo para leitura" + e.getMessage());
              }
              System.out.println("RELATORIO: ");
              for (String i : textoArquivo) {
                System.out.println(i + "\n ");
              }
            }
            break;
          case 7:
            leituraArquivo = new Scanner(caminhoDoArquivoProfessores);
            if (caminhoDoArquivoProfessores.exists()) {
              try {
                while (leituraArquivo.hasNextLine()) {
                  textoArquivo.add(leituraArquivo.nextLine());
                }
                leituraArquivo.close();
              } catch (Exception e) {
                System.out.println("Erro ao acessar o arquivo para leitura" + e.getMessage());
              }
              System.out.println("RELATORIO: ");
              for (String i : textoArquivo) {
                System.out.println(i + "\n ");
              }
            }
            break;
          case 8:
            leituraArquivo = new Scanner(caminhoDoArquivoDisciplinas);
            if (caminhoDoArquivoDisciplinas.exists()) {
              try {
                while (leituraArquivo.hasNextLine()) {
                  textoArquivo.add(leituraArquivo.nextLine());
                }
                leituraArquivo.close();
              } catch (Exception e) {
                System.out.println("Erro ao acessar o arquivo para leitura" + e.getMessage());
              }
              System.out.println("RELATORIO: ");
              for (String i : textoArquivo) {
                System.out.println(i + "\n ");
              }
            }
            break;
          case 9:
            leituraArquivo = new Scanner(caminhoDoArquivoTurmas);
            if (caminhoDoArquivoTurmas.exists()) {
              try {
                while (leituraArquivo.hasNextLine()) {
                  textoArquivo.add(leituraArquivo.nextLine());
                }
                leituraArquivo.close();
              } catch (Exception e) {
                System.out.println("Erro ao acessar o arquivo para leitura" + e.getMessage());
              }
              System.out.println("RELATORIO: ");
              for (String i : textoArquivo) {
                System.out.println(i + "\n ");
              }
            }
            break;
          case 10:
            for (Aluno percorreAluno : alunos) {
              System.out.println(percorreAluno.relatorioAlunoNotasMedia());
            }
            break;
          case 11:
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
                  for (Aluno a : t.getAlunos()) {
                    System.out.println("Nome: " + a.getNome() + " | Matrícula: " + a.getMatricula());
                  }
                  break;
                }
              }
              if (!encont) {
                throw new NameNotFoundException("Disciplina " + nomeDisciplina + " não está cadastrada!");
              }

            } catch (NameNotFoundException e) {
              System.out.println("Erro: " + e.getMessage());
            }
            break;
          case 14:
            boolean encontrado = false;
            System.out.println("Informe o nome do professor que deseja consultar:");
            String nomeProfessor = scanner.nextLine();
            System.out.println("Turmas do professor " + nomeProfessor + ":");
            for (Turma t : turmas) {
              if (t.getProfessor().getNome().equalsIgnoreCase(nomeProfessor)) {
                System.out.println("CODIGO DA TURMA: " + t.getCodigo());
                encontrado = true;
              }
            }
            // Caso não tenha encontrado nenhuma turma para o professor
            if (!encontrado) {
              System.out.println("Nenhuma turma encontrada para o professor " + nomeProfessor + ".");
            }
            break;
          case 15:
            System.out.println("ENCERRANDO O PROGRAMA.....");
            continuar = false;
            break;
          default:
            System.out.println("Opção inválida. Tente novamente.");
        }
      } catch (InputMismatchException ex) {
        System.out.println("Número digitado não corresponde a um inteiro.");
        scanner.nextLine(); // Limpa o buffer
      }
    } while (continuar);
    scanner.close();
  }
}