import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable{
    private String nome;
    private String sobrenome;
    private String nomeCompleto;

    private String telefone;
    private int idade;
    private String email;
    private String senha;

    private static int ultimoId = 0;
    private int id;

    protected List<Reserva> reservas;

    private String tipo;

    Usuario(String nome, String sobrenome, String telefone, int idade, String email, String senha, String tipo) {
        this.id = setId();
        setNome(nome);
        setSobrenome(sobrenome);
        setNomeCompleto();
        setTelefone(telefone);
        setIdade(idade);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo);
        this.reservas = new ArrayList<>();
    }

    // setters

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private static int setId() {
        ultimoId++;
        return ultimoId;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    protected void setNomeCompleto() {
        this.nomeCompleto = getNome() + " " + getSobrenome();
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // getters

    protected String getTipo() {
        return tipo;
    }

    protected String getSenha() {
        return senha;
    }

    protected String getEmail() {
        return email;
    }

    protected int getId() {
        return id;
    }

    protected String getNome() {
        return nome;
    }

    protected String getSobrenome() {
        return sobrenome;
    }

    protected String getNomeCompleto() {
        return nomeCompleto;
    }

    protected int getIdade() {
        return idade;
    }

    protected String getTelefone() {
        return telefone;
    }

    // infs
    protected void printInfs() {
        String string = "\n*Informações do hospde*" +
                "\nNome: " + getNome() +
                "\nSobrenome: " + getSobrenome() +
                "\nNome completo: " + getNomeCompleto() +
                "\nTelefone: " + getTelefone() +
                "\nIdade: " + getIdade() +
                "\nEmail: " + getEmail() +
                "\nSenha: " + getSenha() +
                "\nQuartos reservados:\n" + getReservas();

        System.out.println(string);
    }

    protected void setReservas(Reserva reserva) {
        reservas.add(reserva);
    }

    protected void unsetReservas(Hotel hotel) {
        for (Reserva e : reservas) {
            if (e.getHotel() == hotel) {
                e.quarto.setOcupado(false);
                reservas.remove(e);
                break;
            }
        }
    }

    // protected void setReserva(Hotel hotel) {
    // System.out.println("Fazendo uma reserva");

    // Quarto quarto = null;

    // System.out.println("\nQual quarto gostaria de reservar");
    // int quartoNumero = Menu.lerInt();

    // for (Quarto e : hotel.quartos) {
    // if (e.numero == quartoNumero) {
    // if (!e.ocupado) {
    // quarto = e;
    // break;
    // }
    // }
    // }

    // if (quarto == null) {
    // System.out.println("\nHouve um erro ao loclizar o quarto");
    // } else {
    // System.out.println("\nQuando começara a hospedagem");
    // String dataIni = Menu.lerString();

    // System.out.println("\nQuando terminara a hospedagem");
    // String dataFin = Menu.lerString();

    // quarto.ocupado = !quarto.ocupado;
    // reservas.add(new Reserva(quarto, this, dataIni, dataFin));
    // }

    // }

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

    public void setReserva(Hotel selectedHotel) {
    }
}
