public class Reserva {
    public Quarto quarto;
    public Hospede hospede;
    public String dataInicio;
    public String dataFinal;

    public Reserva(Quarto quarto,Hospede hospede,String dataInicio,String dataFinal) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;

    }

    public void print() {
        System.out.println("Reserva feita por: "+this.hospede.nome+" "+this.hospede.sobrenome);
        System.out.println("Quarto "+this.quarto.numero+" no "+this.quarto.hotel);
        System.out.println("Reserva valida do dia "+this.dataInicio+" ao dia "+this.dataFinal);
        System.out.println();

    }



}
