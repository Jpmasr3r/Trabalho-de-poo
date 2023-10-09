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
        int Sint = scanner.nextInt();
        lerString();
        return Sint;

    }

    protected static double lerDouble() {
        double Sdouble = scanner.nextDouble();
        lerString();
        return Sdouble;
    }

    protected static void consoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected static void addHotel() {
        System.out.println("\nDigite o nome do hotel:");
        String nomeH = lerString();

        System.out.println("\nDigite o endereço do hotel:");
        String enderecoH = lerString();

        System.out.println("\nDigite a nota do hotel:");
        int notaH = lerInt();

        System.out.println("\nDigite o numero de quartos do hotel:");
        int nQuartosH = lerInt();

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
        while (true) {
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
                    System.out.println("[" + i + "] - " + hoteis.getNome());

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
                        System.out.println("[" + selectedHotel.getNome() + "] - selecionado");
                        break;

                }

            }

            lerString();
        }
    }

    protected static void sistemaHoteis() {
        while (true) {
            consoleClear();

            System.out.println("[" + selectedHotel.getNome() + "] - Hotel selecionado");
            System.out.println("[-1] - Retornar");
            System.out.println("[0] - Mostrar informações");
            System.out.println("[1] - Mostrar informações dos quartos");
            System.out.println("[2] - Adicionar Hospede");
            System.out.println("[3] - Adicionar Funcionario");
            System.out.println("[4] - Mostrar hospedes");
            System.out.println("[5] - Mostrar funcionarios");

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                selectedHotel = null;
                break;
            } else {
                switch (selected) {
                    case 0:
                        selectedHotel.printInfs();
                        break;

                    case 1:
                        selectedHotel.getQuartos();
                        break;

                    case 2:
                        selectedHotel.setHospde();
                        break;

                    case 3:
                        selectedHotel.setFuncionario();
                        break;

                    case 4:
                        sistemaHospede();
                        break;

                    case 5:
                        sistemaFuncionarios();
                        break;

                }

            }

            lerString();

        }

    }

    protected static void sistemaHospede() {
        while (true) {
            consoleClear();

            System.out.println("Todos os hospdes do hotel " + selectedHotel.getNome());
            System.out.println("[-1] - Retornar");

            if (selectedHotel.hospedes.isEmpty()) {
                System.out.println("Não ha hospedes no hotel " + selectedHotel.getNome());
            } else {
                int i = 0;
                for (Hospede hospede : selectedHotel.hospedes) {
                    System.out.println("[" + i + "] - " + hospede.getNome());
                    i++;
                }

            }

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                break;
            } else {
                int i = 0;
                for (Hospede hospede : selectedHotel.hospedes) {
                    if (selected == i) {
                        consoleClear();
                        sistemaHospede2(hospede);
                    }
                }
            }

            lerString();

        }
    }

    protected static void sistemaHospede2(Hospede hospede) {
        while (true) {
            consoleClear();

            System.out.println("Hospede " + hospede.getNome());
            System.out.println("[-1] - Retornar");
            System.out.println("[0] - Mostrar informaçoes");
            System.out.println("[1] - Fazer reserva");
            System.out.println("[2] - Mostrar reservas");

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                break;
            } else {
                switch (selected) {
                    case 0:
                        hospede.printInfs();
                        break;

                    case 1:
                        hospede.setReserva(selectedHotel);
                        break;

                    case 2:
                        sistemaReservas(hospede);
                }
            }

            lerString();

        }
    }

    protected static void sistemaFuncionarios() {
        while (true) {
            consoleClear();

            System.out.println("Todos os funcionarios do hotel " + selectedHotel.getNome());
            System.out.println("[-1] - Retornar");

            if (selectedHotel.funcionarios.isEmpty()) {
                System.out.println("Não ha funcionarios no hotel " + selectedHotel.getNome());
            } else {
                int i = 0;
                for (Funcionario funcionario : selectedHotel.funcionarios) {
                    System.out.println("[" + i + "] - "+funcionario.getFuncao()+" / " + funcionario.getNome());
                    i++;
                }

            }

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                break;
            } else {
                int i = 0;
                for (Funcionario funcionario : selectedHotel.funcionarios) {
                    if (selected == i) {
                        funcionario.printInfs();
                    }
                }
            }

            lerString();

        }
    }

    protected static void sistemaReservas(Hospede hospede) {
        while (true) {
            consoleClear();

            System.out.println("Todos as reservas do hospede " + hospede.getNome());
            System.out.println("[-1] - Retornar");

            if (hospede.reservas.isEmpty()) {
                System.out.println("Não ha reservas para o hospede " + selectedHotel.getNome());
            } else {
                int i = 0;
                for (Reserva reserva : hospede.reservas) {
                    System.out.println("[" + i + "] - " + reserva.getDataInicio() + " ao " + reserva.getDataFinal());
                    i++;
                }

            }

            int selected = lerInt();

            if (selected == -1) {
                consoleClear();
                break;
            } else {
                int i = 0;
                for (Reserva reserva : hospede.reservas) {
                    if (selected == i) {
                        reserva.printInfs();
                    }
                }
            }

            lerString();

        }
    }

    public static void main(String[] args) {
        sistema();
    }

}
