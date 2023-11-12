import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);

    protected static List<Hotel> hoteis = new ArrayList<>();

    protected static List<Usuario> usuarios = new ArrayList<>();
    protected static List<Funcionario> funcionarios = new ArrayList<>();

    protected static Hotel selectedHotel = null;
    protected static Usuario logado = null;

    public static void main(String[] args) {
        carregarDeArquivo("dados.txt");
        sistema();
    }

    protected static void sistema() {
        while (true) {
            if (logado == null) {
                consoleClear();

                System.out.println("[-1] - Sair do sistema");
                System.out.println("[0] - Criar conta");
                System.out.println("[1] - Logar");

                int escolha = -2;

                try {
                    escolha = lerInt();
                } catch (Exception erro) {
                    System.out.println("*Digite um numero inteiro*");
                    lerString();
                    lerString();
                }

                if (escolha == -1) {
                    break;
                } else {
                    switch (escolha) {
                        case 0:
                            criarConta();
                            break;
                        case 1:
                            logar();
                            break;

                        default:
                            System.out.println("*Opção não disponivel*");
                            lerString();
                            break;
                    }
                }

            } else {
                while (true) {
                    consoleClear();

                    if (selectedHotel != null) {
                        sistemaHoteis();

                    }

                    System.out.println("[-1] - Deslogar");
                    System.out.println("[0] - Adicionar Hotel");

                    if (!hoteis.isEmpty()) {
                        int i = 0;
                        for (Hotel hoteis : hoteis) {
                            i++;
                            System.out.println("[" + i + "] - " + hoteis.getNome());

                        }
                        ;

                    }

                    int escolha = -2;

                    try {
                        escolha = lerInt();
                    } catch (Exception erro) {
                        System.out.println("*Digite um numero inteiro*");
                        lerString();
                        lerString();
                    }

                    if (escolha == -1) {
                        logado = null;
                        break;

                    } else {
                        switch (escolha) {
                            case 0:
                                addHotel();
                                break;

                            default:
                                try {
                                    selectedHotel = hoteis.get(escolha - 1);
                                    System.out.println("[" + selectedHotel.getNome() + "] - selecionado");
                                } catch (Exception e) {
                                    System.out.println("*Hotel não encontrado*");
                                }
                                break;

                        }

                    }

                    lerString();
                }

            }
        }
    }

    protected static void logar() {
        if (usuarios.isEmpty()) {
            System.out.println("*Nao ha usuarios cadastrados*");
            lerString();
        } else {
            while (true) {
                consoleClear();
                System.out.println("Digite seu email");
                String email = lerString();

                System.out.println("Digite sua senha");
                String senha = lerString();

                for (Usuario e : usuarios) {
                    if (e.getEmail().equals(email) && e.getSenha().equals(senha)) {
                        logado = e;
                    }
                }

                if (logado == null) {
                    System.out.println("*Usuario nao encontrado*");
                    lerString();
                } else {
                    System.out.println("*Logado com sucesso*");
                    lerString();
                    break;
                }
            }
        }
    }

    protected static void criarConta() {
        while (true) {
            consoleClear();
            System.out.println("*Voce é?*");
            System.out.println("[-1] - Voltar");
            System.out.println("[0] - Hospede");
            System.out.println("[1] - Funcionario");

            int escolha = -2;

            try {
                escolha = lerInt();
            } catch (Exception erro) {
                System.out.println("*Digite um numero inteiro*");
                lerString();
                lerString();
            }

            if (escolha == -1) {
                break;
            } else {
                switch (escolha) {
                    case 0:
                        addHospde();
                        break;

                    case 1:
                        addFuncionario();
                        break;

                    default:
                        System.out.println("*Opção não disponivel*");
                        lerString();
                        break;
                }
            }
            if (logado != null) {
                salvarEmArquivo("dados.txt");
                break;
            }

        }
    }

    protected static void addHospde() {
        while (true) {
            System.out.println("\nDigite o nome");
            String nomeU = lerString();

            System.out.println("\nDigite o sobrenome");
            String sobrenomeU = lerString();

            System.out.println("\nDigite a idade");
            int idadeU = 0;

            try {
                idadeU = lerInt();
            } catch (Exception e) {
                System.out.println("*Digite um inteiro*");
                break;
            }

            System.out.println("\nDigite o email");
            String emailU = lerString();

            boolean erro = false;
            for (Usuario e : usuarios) {
                if (e.getEmail().equals(emailU)) {
                    erro = true;
                    break;
                }
            }

            if (erro) {
                System.out.println("*Conta ja existe*");
                lerString();

            } else {
                System.out.println("\nDigite a senha");
                String senhaU = lerString();

                System.out.println("\nDigite o telefone");
                String telefoneU = lerString();

                Usuario usuario = new Usuario(nomeU, sobrenomeU, telefoneU, idadeU, emailU, senhaU, "usuario");
                usuarios.add(usuario);
                logado = usuario;

                System.out.println("*Conta criada com sucesso*");
                logado.printInfs();
                lerString();

            }
            break;

        }

    }

    protected static void addFuncionario() {
        while (true) {
            System.out.println("\nDigite o nome");
            String nomeF = lerString();

            System.out.println("\nDigite o sobrenome");
            String sobrenomeF = lerString();

            System.out.println("\nDigite a idade");
            int idadeF = 0;

            try {
                idadeF = lerInt();
            } catch (Exception e) {
                System.out.println("*Digite um inteiro*");
                break;
            }

            System.out.println("\nDigite o telefone");
            String telefoneF = lerString();

            System.out.println("\nDigite o email");
            String emailF = lerString();

            boolean erro = false;
            for (Usuario e : usuarios) {
                if (e.getEmail().equals(emailF)) {
                    erro = true;
                    break;
                }
            }

            if (erro) {

                System.out.println("*Conta ja existe*");
                lerString();
                consoleClear();
            } else {
                System.out.println("\nDigite a senha");
                String senhaF = lerString();

                System.out.println("\nDigite a funcao");
                String funcaoF = lerString();

                Funcionario funcionario = new Funcionario(nomeF, sobrenomeF, telefoneF, idadeF, emailF, senhaF,
                        funcaoF);
                usuarios.add(funcionario);
                funcionarios.add(funcionario);
                logado = funcionario;

                System.out.println("*Conta criada com sucesso*");

                logado.printInfs();
                lerString();
                break;
            }

        }

    }

    protected static void sistemaHoteis() {
        while (true) {
            consoleClear();

            System.out.println("[" + selectedHotel.getNome() + "] - Hotel selecionado");
            System.out.println("[-1] - Retornar");
            System.out.println("[0] - Mostrar informações");
            System.out.println("[1] - Mostrar informações dos quartos");

            if (selectedHotel.getDono().equals(logado)) {
                System.out.println("[2] - Contratar");
                System.out.println("[3] - Mostrar hospedes");
                System.out.println("[4] - Mostrar funcionarios");
            } else {
                System.out.println("[2] - Hospedar");
                System.out.println("[3] - Cancelar hospedagem");
            }

            for (Reserva e : logado.reservas) {
                if (e.getHotel() == selectedHotel) {
                    System.out.println("\n");
                    System.out.println("*Sua reserva*");
                    e.printInfs();
                    System.out.println("\n");
                    break;
                }
            }

            int escolha = -2;

            try {
                escolha = lerInt();
            } catch (Exception erro) {
                System.out.println("*Digite um numero inteiro*");
                lerString();
                lerString();
            }

            if (selectedHotel.getDono().equals(logado)) {
                if (escolha == -1) {
                    consoleClear();
                    selectedHotel = null;
                    break;
                } else {
                    switch (escolha) {
                        case 0:
                            selectedHotel.printInfs();
                            break;

                        case 1:
                            selectedHotel.getQuartos();
                            break;

                        case 2:
                            selectedHotel.setFuncionarios();
                            salvarEmArquivo("dados.txt");
                            break;

                        case 3:
                            System.out.println(selectedHotel.getHospedes());
                            break;

                        case 4:
                            System.out.println(selectedHotel.getFuncionarios());
                            break;

                        default:
                            System.out.println("*Opção não disponivel*");
                            lerString();
                            break;

                    }
                }
                lerString();

            } else {
                if (escolha == -1) {
                    consoleClear();
                    selectedHotel = null;
                    break;

                } else {
                    switch (escolha) {
                        case 0:
                            selectedHotel.printInfs();
                            break;

                        case 1:
                            selectedHotel.getQuartos();
                            break;

                        case 2:
                            selectedHotel.setHospedes(logado);
                            salvarEmArquivo("dados.txt");
                            break;

                        case 3:
                            selectedHotel.unsetHospede(logado);
                            salvarEmArquivo("dados.txt");
                            break;

                        default:
                            System.out.println("*Opção não disponivel*");
                            lerString();
                            break;
                    }
                    lerString();

                }
            }
        }
    }

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
        while (true) {
            System.out.println("\nDigite o nome do hotel:");
            String nomeH = lerString();

            System.out.println("\nDigite o endereço do hotel:");
            String enderecoH = lerString();

            System.out.println("\nDigite o numero de quartos do hotel:");
            int nQuartosH = 0;

            try {
                nQuartosH = lerInt();
            } catch (Exception erro) {
                System.out.println("*Não foi possivel adicionar o hotel*");
                lerString();
                lerString();
                break;

            }

            System.out.println("\nDigite a nota do hotel:");
            int notaH = lerInt();

            hoteis.add(new Hotel(nomeH, notaH, nQuartosH, enderecoH, logado));
            System.out.println("\nHotel adicionado com sucesso");
            salvarEmArquivo("dados.txt");
            break;
        }
    }

    public static void salvarEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(hoteis);
            out.writeObject(usuarios);
            out.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarDeArquivo(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            hoteis = (List<Hotel>) in.readObject();
            usuarios = (List<Usuario>) in.readObject();
            funcionarios = (List<Funcionario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
