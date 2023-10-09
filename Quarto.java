public class Quarto {
    protected int numero;
    protected boolean ocupado;

    protected Quarto(int numero) {
        setNumero(numero);
        this.ocupado = false;

    }

    private void setNumero(int numero) {
        this.numero = numero+1;
    }

    protected void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    protected int getNumero() {
        return this.numero;
    }

    protected String getOcupado() {
        if(this.ocupado) {
            return "\nO quarto esta ocupado";
        }else {
            return "\nO não quarto esta ocupado";
        }
    }

    protected void printInfs() {
        System.out.println("\n*Informações do quarto*");
        System.out.println("O numero do quarto é: "+getNumero());
        System.out.println(getOcupado());
    }

}
