import java.util.ArrayList;

public class Hotel {
    public String nome;
    public String endereco;
    public String nota;
    public ArrayList<Integer> quartos;

    public Hotel(String nome,String endereco,String nota) {
        this.nome = nome;
        this.endereco = endereco;
        this.nota = nota;
        this.quartos = new ArrayList<>();

    }

    public String getNome() {
        return this.nome;
    }
    
    public String getEndereco() {
        return this.endereco;
    }

    public String getNota() {
        return this.nota;
    }

    public ArrayList<Integer> getQuartos() {
        return this.quartos;
    }


}
