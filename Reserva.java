public class Reserva {
    protected Quarto quarto;
    protected Hospede hospede;
    protected String dataInicio;
    protected String dataFinal;

    protected Reserva(Quarto quarto, Hospede hospede, String dataInicio, String dataFinal) {
        setDataFinal(dataFinal);
        setDataInicio(dataInicio);
        setHospede(hospede);
        setQuarto(quarto);

    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    protected String getDataFinal() {
        return this.dataFinal;
    }

    protected String getDataInicio() {
        return this.dataInicio;
    }

    protected String getHospede() {
        return this.hospede.nome;
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
}
