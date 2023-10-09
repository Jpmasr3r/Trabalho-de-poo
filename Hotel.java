import java.util.ArrayList;

public class Hotel {
    protected String nome;
    protected String endereco;
    protected int nota;
    protected ArrayList<Quarto> quartos;
    protected ArrayList<Hospede> hospedes;
    protected ArrayList<Funcionario> funcionarios;

    protected Hotel(String nome, int nota, int nQuartos, String endereco) {
        setNome(nome);
        setEndereco(endereco);
        setNota(nota);
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();

        setNQuartos(nQuartos);

    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setNota(int nota) {
        this.nota = nota;
    }

    private void setNQuartos(int nQuartos) {
        for (int i = 0; i < nQuartos; i++) {
            this.quartos.add(new Quarto(i));
        }
    }

    protected String getEndereco() {
        return endereco;
    }

    protected String getNome() {
        return nome;
    }

    protected int getNota() {
        return nota;
    }

    protected void getQuartos() {
        for (Quarto e : quartos) {
            e.printInfs();
        }
    }

    protected void printInfs() {
        System.out.println("*Informações do hotel*");
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Nota: " + getNota());
    }

    protected void setHospde() {
        System.out.println("\nDigite o nome");
        String nomeH = Menu.lerString();

        System.out.println("\nDigite o sobrenome");
        String sobrenomeH = Menu.lerString();

        System.out.println("\nDigite a idade");
        int idadeH = Menu.lerInt();

        System.out.println("\nDigite o telefone");
        String telefoneH = Menu.lerString();

        System.out.println("\nDigite a senha");
        String senhaH = Menu.lerString();

        hospedes.add(new Hospede(nomeH, sobrenomeH, telefoneH, senhaH, idadeH));
    }

    protected void setFuncionario() {
        System.out.println("\nDigite o nome");
        String nomeF = Menu.lerString();

        System.out.println("\nDigite o sobrenome");
        String sobrenomeF = Menu.lerString();

        System.out.println("\nDigite a funcao");
        String funcaoF = Menu.lerString();

        System.out.println("\nDigite a idade");
        int idadeF = Menu.lerInt();

        System.out.println("\nDigite o telefone");
        String telefoneF = Menu.lerString();

        System.out.println("\nDigite o salario");
        double salarioF = Menu.lerDouble();

        funcionarios.add(new Funcionario(nomeF, telefoneF, idadeF, salarioF, funcaoF));
    }

}
