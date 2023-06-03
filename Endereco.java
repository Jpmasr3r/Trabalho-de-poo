public class Endereco {
    public String rua;
    public String cidade;
    public int numero;

    public Endereco(String rua,String cidade,int numero) {
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;

    }

    public void print() {
        System.out.println("Endereço: "+this.cidade+" "+this.rua+" "+this.numero);
    }



}
