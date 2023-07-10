import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Hotel> hoteis = new ArrayList<>();
    protected static Hotel selectedHotel = null;

    protected static String lerString() {
        return scanner.nextLine();
    }

    protected static int lerInt() {
        return scanner.nextInt();
    }

    protected static double lerDouble() {
        return scanner.nextDouble();
    }

    protected static void consoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected static void addHotel() {
        lerString();
        System.out.println("\nDigite o nome do hotel:");
        String nomeH = lerString();

        System.out.println("\nDigite o endereço do hotel:");
        String enderecoH = lerString();

        System.out.println("\nDigite a nota do hotel:");
        int notaH = lerInt();

        System.out.println("\nDigite o numero de quartos do hotel:");
        int nQuartosH = lerInt();

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
        boolean sys = true;
        while (sys) {
            consoleClear();

            if (selectedHotel != null) {
                sistemaHoteis();

            }

            System.out.println("[-1] - Sair do sistema");
            System.out.println("[0] - Adicionar Hotel");

            if (!hoteis.isEmpty()) {
                int i = 0;
                for (Hotel hoteis : hoteis) {
                    i++;
                    System.out.println("[" + i + "] - " + hoteis.nome);

                }
                ;

            }

            int selected = lerInt();

            if (selected == -1) {
                System.out.println("Obrigado por usar o sistema de hoteis ;)");
                break;

            } else {
                switch (selected) {
                    case 0:
                        addHotel();
                        break;

                    default:
                        selectedHotel = hoteis.get(selected - 1);
                        System.out.println("[" + selectedHotel.nome + "] - selecionado");
                        lerString();
                        break;

                }

            }

            lerString();
        }
    }

    protected static void sistemaHoteis() {
        boolean sys = true;
        while (sys) {
            consoleClear();

            System.out.println("[" + selectedHotel.nome + "] - Hotel selecionado");
            System.out.println("[-1] - Retornar");
            System.out.println("[0] - Mostrar informações");
            System.out.println("[1] - Mostrar informações dos quartos");
            System.out.println("[2] - Adicionar Hospede");
            System.out.println("[3] - Adicionar Funcionario");

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                selectedHotel = null;
                break;
            } else {
                switch (selected) {
                    case 0:
                        selectedHotel.printInfs();
                        lerString();
                        break;

                    case 1: 
                        selectedHotel.printQuartos();
                        lerString();
                        break;

                }

            }

            lerString();

        }

    }

    public static void main(String[] args) {
        hoteis.add(new Hotel("Hotel teste 1", 10, 100, "Rua do teste 1"));
        hoteis.add(new Hotel("Hotel da Floresta", 5, 15, "Floresta no meio do mato"));
        sistema();
    }

}
