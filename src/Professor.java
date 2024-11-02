import java.util.ArrayList;

public class Professor extends Pessoa{
    private String areaFormacao;
    private String anoAdmissao;
    private String email;
    private ArrayList<Disciplina> Array_disciplinas= new ArrayList<Disciplina>();

    public Professor(String areaFormacao, String anoAdmissao, String email, String nome, String dataNasc, String telefone, Endereco endereco, Disciplina disciplina){
        super(nome, dataNasc, telefone, endereco);
        this.areaFormacao = areaFormacao;
        this.anoAdmissao = anoAdmissao;
        this.email = email;
        this.Array_disciplinas.add(disciplina);
    }

    public String getAreaFormacao() {
        return areaFormacao;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public String getAnoAdmissao() {
        return anoAdmissao;
    }

    public void setAnoAdmissao(String anoAdmissao) {
        this.anoAdmissao = anoAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Disciplina> getArray_disciplinas() {
        return Array_disciplinas;
    }

    public void setArray_disciplinas(ArrayList<Disciplina> array_disciplinas) {
        Array_disciplinas = array_disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!Array_disciplinas.contains(disciplina)) {
            Array_disciplinas.add(disciplina);
            disciplina.adicionarProfessor(this); // Atualiza a relação bidirecional
        }
    }

    public String getNome(){
        return super.getNome();
    }

    public String getDataNasc(){
        return super.getDataNasc();
    }
    public String getTelefone(){
        return super.getTelefone();
    }

    public Endereco getEndereco(){
        return super.getEndereco();
    }
    
}
