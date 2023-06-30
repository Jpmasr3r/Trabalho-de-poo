import java.util.ArrayList;

public class Hospede extends Pessoa {
    protected ArrayList<Reserva> reservas;
    private String senha;

    protected Hospede(String nome, String sobrenome, String telefone, String senha) {
        super(nome, sobrenome, telefone);
        this.senha = senha;
        this.reservas = new ArrayList<>();

        printInfs();

    }

    protected String getNome() {
        return this.nome + " " + this.sobrenome;
    }

    protected String getTelefone() {
        return this.telefone;
    }

    protected String getSenha() {
        return this.senha;
    }

    protected String getReservas() {
        if (!reservas.isEmpty()) {
            String res = "";
            for (Reserva e : reservas) {
                res += "Quarto " + e.quarto + "\n";
            }
            return res;
        }
        return "Nenhuma reserva feita";
    }

    protected void printInfs() {
        System.out.println("Nome: " + getNome());
        System.out.println("Senha: " + getSenha());
        System.out.println("Telefone:" + getTelefone());
        System.out.println("Quartos reservados:\n" + getReservas());

    }

    public static void main(String[] args) {
        Hospede h = new Hospede("Joao", "Soares", "3487598", "lgkvnbvl");
        h.reservas.add(new Reserva(null, h, null, null));
        h.reservas.get(0).printInfs();
    }

}