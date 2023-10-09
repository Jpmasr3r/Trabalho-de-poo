public abstract class Pessoa {
    protected String nome;
    protected String telefone;
    protected int idade;

    Pessoa(String nome,String telefone,int idade) {
        setNome(nome);
        setTelefone(telefone);
        setIdade(idade);

    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

}
