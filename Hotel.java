import java.util.ArrayList;

public class Hotel {
    public String nome;
    public Endereco endereco;
    public int nota;
    public ArrayList<Quarto> quartos;
    public ArrayList<Hospede> hospedes;

    public Hotel(String nome,Endereco endereco,int nota,int nQuartos) {
        this.nome = nome;
        this.endereco = endereco;
        this.nota = nota;
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();

        for(int i = 0; i < nQuartos; i++) {
            this.quartos.add(new Quarto(i+1,this.nome));

        }

    }

    public void print() {
        System.out.println("Nome: "+this.nome);
        this.endereco.print();
        
        System.out.println("Possui "+this.quartos.size()+" quartos no hotel");
        
        System.out.println();

        

    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel(
        "Hotel da praia",
        new Endereco("Janio Quadros", "Charqueadas", 212),
        5,
        10);

        h1.print(); 

        h1.hospedes.add(new Hospede("João Pedro", "Soares", "12345678", "senha1234"));
        h1.hospedes.get(0).print();

        h1.hospedes.get(0).reservas.add(new Reserva(
            h1.quartos.get(0), 
            h1.hospedes.get(0), 
            "12/03/09", 
            "23/06/10"));

        h1.hospedes.get(0).reservas.get(0).print();

    }

}
