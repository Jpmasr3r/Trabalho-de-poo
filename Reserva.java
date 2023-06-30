public class Reserva {
    protected Quarto quarto;
    protected Hospede hospede;
    protected String dataInicio;
    protected String dataFinal;

    protected Reserva(Quarto quarto, Hospede hospede, String dataInicio, String dataFinal) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;

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
        System.out.println("Hopede: " + getHospede());
        System.out.println("Quarto: " + getQuarto());
        System.out.println("Data de inicio:" + getDataInicio());
        System.out.println("Data de termino:\n" + getDataFinal());

    }
}
