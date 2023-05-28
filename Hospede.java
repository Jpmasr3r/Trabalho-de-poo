import java.util.ArrayList;

public class Hospede {
    public String nome;
    public int numeroDeTelefone;
    public String senha;
    public ArrayList<Integer> quartosList;

    public Hospede(String nome,int numeroDeTelefone,String senha) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
        this.senha = senha;
        this.quartosList = new ArrayList<Integer>();
        
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

    public ArrayList<Integer> getQuartosList() {
        return this.quartosList;
    }


    

}