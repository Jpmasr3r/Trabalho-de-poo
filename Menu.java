import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Hotel> hoteis = new ArrayList<>();

    protected static String lerString() {
        return scanner.nextLine();
    }

    protected static int lerInt() {
        return scanner.nextInt();
    }

    protected static double lerDouble() {
        return scanner.nextDouble();
    }

    protected static void addHotel() {
        System.out.println("\nDigite o nome do hotel:");
        String nomeH = lerString();

        System.out.println("\nDigite a nota do hotel:");
        int notaH = lerInt();

        System.out.println("\nDigite o numero de quartos do hotel:");
        int nQuartosH = lerInt();

        System.out.println("\nDigite o endereço do hotel:");
        String enderecoH = lerString();

        lerString();
        hoteis.add(new Hotel(nomeH, notaH, nQuartosH, enderecoH));
        System.out.println("\nHotel adicionado com sucesso");
    }

    protected static void printHoteis() {
        if (!hoteis.isEmpty()) {
            System.out.println("\nExistem " + hoteis.size() + " cadastrados");
        } else {
            System.out.println("\nNão existem cadastrados");
        }
    }

    protected static void sistema() {
        if (hoteis.isEmpty()) {
            System.out.println("[0] - Criar hotel");

            switch (lerInt()) {
                case 0:
                    addHotel();
                    break;
            }

        } else {
            ArrayList<Hotel> hs = new ArrayList<>();
            int i = 0;
            for (Hotel e : hoteis) {
                System.out.println("[" + i + "] - " + e.getNome());
                hs.add(e);
                i++;
            }
            System.out.println("[" + (i + 1) + "] - Criar hotel");

            int j = lerInt();

            for (Hotel hs2 : hs) {
                
            }
        }
    }

    public static void main(String[] args) {
        sistema();
    }

}
