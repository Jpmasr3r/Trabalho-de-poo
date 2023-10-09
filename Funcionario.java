public class Funcionario extends Pessoa {
    protected double salario;
    protected String funcao;

    protected Funcionario(String nome,String telefone, int idade, double salario, String funcao) {
        super(nome, telefone, idade);
        setSalario(salario);
        setFuncao(funcao);

    }

    private void setSalario(double salario) {
        this.salario = salario;
    }

    private void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    protected double getSalario() {
        return this.salario;
    }

    protected String getFuncao() {
        return funcao;
    }

    protected void printInfs() {
        System.out.println("*Informações do funcionario*");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Função: " + getFuncao());
        System.out.println("Salario: " + getSalario());
        System.out.println("Telefone:" + getTelefone());
    }

}
