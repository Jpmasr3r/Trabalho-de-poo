public class Funcionario extends Pessoa {
    protected double salario;

    protected Funcionario(String nome, String sobrenome, String telefone, int idade, double salario) {
        super(nome, sobrenome, telefone, idade);
        this.salario = salario;

    }

    protected String getNome() {
        return this.nome + " " + this.sobrenome;
    }

    protected String getTelefone() {
        return this.telefone;
    }

    protected int getIdade() {
        return this.idade;
    }

    protected double getSalario() {
        return this.salario;
    }

    protected void printInfs() {
        System.out.println("\n*Informações do funcionario*");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: "+getIdade());
        System.out.println("Salario: "+getSalario());
        System.out.println("Telefone:" + getTelefone());
    }


}
