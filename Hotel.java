import java.util.ArrayList;

public class Hotel {
    protected String nome;
    protected String endereco;
    protected int nota;
    protected ArrayList<Quarto> quartos;
    protected ArrayList<Hospede> hospedes;
    protected ArrayList<Funcionario> funcionarios;

    protected Hotel(String nome, int nota, int nQuartos, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.nota = nota;
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();

        for (int i = 0; i < nQuartos; i++) {
            this.quartos.add(new Quarto(i));
        }

    }

    protected void printQuartos() {
        for (Quarto e : quartos) {
            e.printInfs();
        }
    }

    protected void printHospedes() {
        for (Hospede e : hospedes) {
            e.printInfs();
        }
        if (hospedes.isEmpty()) {
            System.out.println("\nNão há hospdes no hotel");
        }
    }

    protected String getNome() {
        return this.nome;
    }

    protected String getEndereco() {
        return this.endereco;
    }

    protected int getNota() {
        return this.nota;
    }

    protected void printInfs() {
        System.out.println("*Informações do hotel*");
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Nota: " + getNota());
    }
    

    protected void addHospde() {
        System.out.println("\nDigite o seu nome");
        String nomeH = Menu.lerString();

        System.out.println("\nDigite o seu sobrenome");
        String sobrenomeH = Menu.lerString();

        System.out.println("\nDigite sua idade");
        int idadeH = Menu.lerInt();

        System.out.println("\nDigite seu telefone");
        String telefoneH = Menu.lerString();

        System.out.println("\nDigite sua senha");
        String senhaH = Menu.lerString();

        hospedes.add(new Hospede(nomeH, sobrenomeH, telefoneH, senhaH, idadeH));
    }

    protected void addFuncionario() {
        System.out.println("\nDigite o seu nome");
        String nomeF = Menu.lerString();

        System.out.println("\nDigite o seu sobrenome");
        String sobrenomeF = Menu.lerString();

        System.out.println("\nDigite sua idade");
        int idadeF = Menu.lerInt();

        System.out.println("\nDigite seu telefone");
        String telefoneF = Menu.lerString();

        System.out.println("\nDigite seu salario");
        double salarioF = Menu.lerDouble();

        funcionarios.add(new Funcionario(nomeF, sobrenomeF, telefoneF, idadeF, salarioF));
    }

}
