import java.io.Serializable;

public class Funcionario extends Usuario implements Serializable{
    protected double salario;
    protected String funcao;

    protected Funcionario(String nome, String sobrenome, String telefone, int idade, String email, String senha,
            String funcao) {
                super(nome, sobrenome, telefone, idade, email, senha, "funcionario");
                setFuncao(funcao);
                setSalario(0);

    }

    protected void setSalario(double salario) {
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
        String string = "\n*Informações do funcionario*" +
                "\nNome: " + getNome() +
                "\nSobrenome: " + getSobrenome() +
                "\nNome completo: " + getNomeCompleto() +
                "\nTelefone: " + getTelefone() +
                "\nIdade: " + getIdade() +
                "\nEmail: " + getEmail() +
                "\nSenha: " + getSenha() +
                "\nFunção: " + getFuncao() +
                "\nSalario: " + getSalario();

        System.out.println(string);
    }

}
