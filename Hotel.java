import java.util.ArrayList;

public class Hotel {
    protected String nome;
    protected String endereco;
    protected int nota;
    protected ArrayList<Quarto> quartos;
    protected ArrayList<Hospede> hospedes;

    protected Hotel(String nome,int nota,int nQuartos,String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.nota = nota;
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();

        for(int i = 0; i < nQuartos; i++) {
            this.quartos.add(new Quarto(i));
        }

    }

}
