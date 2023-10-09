import java.util.ArrayList;

public class Hospede extends Pessoa {
    protected ArrayList<Reserva> reservas;
    private String senha;

    protected Hospede(String nome, String sobrenome, String telefone, String senha,int idade) {
        super(nome,telefone,idade);
        setSenha(senha);
        this.reservas = new ArrayList<>();

        printInfs();

    }

    private String getSenha() {
        return this.senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    protected String getReservas() {
        if (!reservas.isEmpty()) {
            String res = "";
            for (Reserva e : reservas) {
                res += "Quarto " + e.quarto.getNumero() + "\n";
            }
            return res;
        }
        return "Nenhuma reserva feita";
    }

    protected void setReserva(Hotel hotel) {
        System.out.println("Fazendo uma reserva");
        
        Quarto quarto = null;

        System.out.println("\nQual quarto gostaria de reservar");
        int quartoNumero = Menu.lerInt();

        for (Quarto e : hotel.quartos) {
            if (e.numero == quartoNumero) {
                if (!e.ocupado) {
                    quarto = e;
                    break;
                }
            }
        }

        if (quarto == null) {
            System.out.println("\nHouve um erro ao loclizar o quarto");
        } else {
            System.out.println("\nQuando começara a hospedagem");
            String dataIni = Menu.lerString();

            System.out.println("\nQuando terminara a hospedagem");
            String dataFin = Menu.lerString();

            quarto.ocupado = !quarto.ocupado;
            reservas.add(new Reserva(quarto, this, dataIni, dataFin));
        }

    }

    protected void printInfs() {
        System.out.println("\n*Informações do hospede*");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: "+getIdade());
        System.out.println("Senha: " + getSenha());
        System.out.println("Telefone:" + getTelefone());
        System.out.println("Quartos reservados:\n" + getReservas());

    }

}