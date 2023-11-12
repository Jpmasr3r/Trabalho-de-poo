import java.io.Serializable;

public class Quarto implements Serializable{
    protected int numero;
    protected boolean ocupado;

    protected Quarto(int numero) {
        setNumero(numero);
        this.ocupado = false;

    }

    private void setNumero(int numero) {
        this.numero = numero + 1;
    }

    protected void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    protected int getNumero() {
        return this.numero;
    }

    protected String getOcupado() {
        if (this.ocupado) {
            return "\nO quarto esta ocupado";
        } else {
            return "\nO não quarto esta ocupado";
        }
    }

    protected void printInfs() {
        String string = "\n*Informações do quarto*" +
                "\nO numero do quarto é: " + getNumero() +
                "\n" + getOcupado();

        System.out.println(string);
    }

}
