public class Quarto {
    public int numero;
    public String hotel;
    public boolean ocupado;


    public Quarto(int numero,String hotel) {
        this.numero = numero;
        this.hotel = hotel;
        this.ocupado = false;


    } 

    public void print() {
        System.out.println("Quarto fica no "+this.hotel);
        System.out.println("No numero "+this.numero);
        System.out.println();

    } 


}
