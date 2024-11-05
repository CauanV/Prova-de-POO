abstract class Pessoa {
    String nome;
    String dataNascimento;
    String telefone;
    Endereco endereco;

    public Pessoa(String nome,String dataNascimento,String telefone,Endereco endereco){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    
}

