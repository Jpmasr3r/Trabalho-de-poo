import java.io.Serializable;

public class Reserva implements Serializable{
    protected Quarto quarto;
    protected Usuario hospede;
    protected String dataInicio;
    protected String dataFinal;
    protected Hotel hotel;

    protected Reserva(Quarto quarto, Usuario usuario, String dataInicio, String dataFinal,Hotel hotel) {
        setDataFinal(dataFinal);
        setDataInicio(dataInicio);
        setHospede(usuario);
        setQuarto(quarto);
        setHotel(hotel);

    }

    private void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    private void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    private void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    private void setHospede(Usuario hospede) {
        this.hospede = hospede;
    }

    private void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    protected String getDataFinal() {
        return this.dataFinal;
    }

    protected String getDataInicio() {
        return this.dataInicio;
    }

    protected String getHospede() {
        return this.hospede.getNome();
    }

    protected int getQuarto() {
        return this.quarto.numero;
    }

    protected void printInfs() {
        System.out.println("\n*Informações da reserva*");
        System.out.println("Hopede: " + getHospede());
        System.out.println("Quarto: " + getQuarto());
        System.out.println("Data de inicio:" + getDataInicio());
        System.out.println("Data de termino:\n" + getDataFinal());
    }

    public Hotel getHotel() {
        return hotel;
    }
}
