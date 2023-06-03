import java.util.ArrayList;

public class Hospede {
    public String nome;
    public String sobrenome;
    public String telefone;
    public String senha;
    public ArrayList<Reserva> reservas; 

    public Hospede(String nome,String sobrenome,String telefone,String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.senha = senha;
        this.reservas = new ArrayList<>(); 

    }

    public void print() {
        System.out.println("Nome: "+this.nome+" "+this.sobrenome);
        System.out.println("Numero de telefone de "+this.nome+": "+this.telefone);
        System.out.println("Senha de "+this.nome+": "+this.senha);
        
        if(reservas.size() != 0) {
            for(int i = 0;i < this.reservas.size(); i++) {
                System.out.println();
                
            }
        }
        System.out.println();
        
    }



}