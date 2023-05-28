public class Recepecionista {
    public String nome;
    public int numeroDeTelefone;
    public String senha;

    public Recepecionista(String nome,int numeroDeTelefone,String senha) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
        this.senha = senha;

    }

    public String getNome() {
        return this.nome;
    }

    public int getNumeroDeTelefone() {
        return this.numeroDeTelefone;
    }

    public String getSenha() {
        return this.senha;
    }

}
