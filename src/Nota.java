public class Nota {
    Aluno aluno; //1 aluno pode ter varias notas
    Disciplina disciplina;
    double valor;
    String data; //registra a data em qwue a not foi lancada 

    public Nota(double nota, String data){
        this.valor = nota;
        this.data = data;
    }

    public double getNota() {
        return this.valor;
    }
  
    public String getData() {
        return this.data;
    }

}
