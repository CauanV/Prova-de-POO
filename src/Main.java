import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        ArrayList<Turma> turmas = new ArrayList<Turma>();

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
                    System.out.println("Opção escolhida: Cadastrar Aluno");
                    System.out.println("Digite o nome do Aluno: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do Aluno (dd-mm-aaaa)");
                    String data = scanner.nextLine();
                    System.out.println("Digite o telefone a ser cadastrado para este aluno: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Endereco a ser cadastrado para este aluno: ");
                    System.out.println("Digite a rua, cidade, Estado e CEP ");
                    String rua = scanner.nextLine();
                    String cidade = scanner.nextLine();
                    String estado = scanner.nextLine();
                    String cep = scanner.nextLine();
                    System.out.println(
                            "Digite a matricula que sera associada a este aluno e em seguida o ano de ingresso");
                    String matricula = scanner.nextLine();
                    int anoIngresso = scanner.nextInt();
                    scanner.nextLine();
                    Endereco endereco = new Endereco(rua, cidade, estado, cep);
                    Aluno objAluno = new Aluno(nome, data, telefone, endereco, matricula, anoIngresso);
                    // O CADASTRO ESTA FUNCIONAL
                    // percorrer todas as turmas para perguntar em qual quer colocar
                    System.out.println("Em qual turma voce deseja adicionar este aluno (digite o codigo da turma)");
                    for (Turma turma : turmas) {
                        System.out.println("========== TURMAS NO SISTEMA ===========");
                        System.out.println(turma.getCodigo());
                        System.out.println("=============================");
                    }
                    String codigoT = scanner.nextLine();
                    for (Turma turma : turmas) {
                        if (turma.getCodigo().equalsIgnoreCase(codigoT)) {
                            turma.setAdicionarAlunos(objAluno);
                            System.out.println("Aluno " + objAluno.getNome() + " adicionado com sucesso na turma "
                                    + turma.getCodigo());
                        } else {
                            System.out.println("Codigo de turma nao encontrado");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Opção escolhida: Cadastrar Professor");
                    System.out.println("Digite o nome do professor:");
                    String nomeP = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do novo professor (dd-mm-aaaa): ");
                    String dataP = scanner.nextLine();
                    System.out.println("Digite o telefone a ser cadastrado para este aluno: ");
                    String telefonep = scanner.nextLine();
                    System.out.println("Endereco a ser cadastrado para este aluno: ");
                    System.out.println("Digite a rua, cidade, Estado e CEP ");
                    String ruaP = scanner.nextLine();
                    String cidadeP = scanner.nextLine();
                    String estadoP = scanner.nextLine();
                    String cepP = scanner.nextLine();
                    Endereco endereco2 = new Endereco(ruaP, cidadeP, estadoP, cepP);
                    System.out.println("Qual a formacao deste professor e o ano que foi admitido: ");
                    String areaDeFormacao = scanner.nextLine();
                    String anoAdmissao = scanner.nextLine();
                    System.out.println("Digite o email deste professor: ");
                    String email = scanner.nextLine();
                    //adicionar o professor dentro de uma disciplina
                    

                    break;
                case 3:
                    System.out.println("Opção escolhida: Cadastrar Disciplina");// este tem que ser feito dentro da classe professor
                    System.out.println("Digite o nome da disc");

                    break;
                case 4:
                    System.out.println("Opção escolhida: Cadastrar Turma");
                    System.out.println("Digite o codigo da turma: ");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite o ano letivo: ");
                    int anoLetivo = scanner.nextInt();
                    Turma turma = new Turma(codigo, anoLetivo);
                    turmas.add(turma);
                    break;
                case 5:
                    System.out.println("Opção escolhida: Inserir Nota");
                    // Implementar a lógica de inserção de nota
                    break;
                case 6:
                    System.out.println("Opção escolhida: Relatório Alunos");
                    // Implementar a lógica de relatório de alunos
                    break;
                case 7:
                    System.out.println("Opção escolhida: Relatório Professores");
                    // Implementar a lógica de relatório de professores
                    break;
                case 8:
                    System.out.println("Opção escolhida: Relatório Disciplinas");
                    // Implementar a lógica de relatório de disciplinas
                    break;
                case 9:
                    System.out.println("Opção escolhida: Relatório Turmas");
                    // Implementar a lógica de relatório de turmas
                    break;
                case 10:
                    System.out.println("Opção escolhida: Relatório de Aluno x Notas x média");
                    // Implementar a lógica de relatório de notas e média de alunos
                    break;
                case 11:
                    System.out.println("Opção escolhida: Quantidade de Alunos Cadastrados");
                    // Implementar a lógica para contar alunos cadastrados
                    break;
                case 12:
                    System.out.println("Opção escolhida: Nome do aluno que possui a maior nota");
                    // Implementar a lógica para encontrar o aluno com a maior nota
                    break;
                case 13:
                    System.out.println("Opção escolhida: Listar os alunos de uma determinada disciplina");
                    // Implementar a lógica para listar alunos de uma disciplina
                    break;
                case 14:
                    System.out.println(
                            "Opção escolhida: Listar as turmas que estão associadas a um determinado professor");
                    // Implementar a lógica para listar turmas de um professor
                    break;
                case 15:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 15);

        scanner.close();
    }
}