import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable{
    protected String nome;
    protected String endereco;
    protected int nota;
    protected List<Usuario> hospedes;
    protected List<Funcionario> funcionarios;
    protected List<Quarto> quartos;
    protected Usuario dono;

    protected Hotel(String nome, int nota, int nQuartos, String endereco, Usuario dono) {
        setNome(nome);
        setEndereco(endereco);
        setNota(nota);
        setDono(dono);
        this.quartos = new ArrayList<>();
        setNQuartos(nQuartos);
        this.hospedes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();

    }

    // setters

    private void setDono(Usuario dono) {
        this.dono = dono;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setNota(int nota) {
        this.nota = nota;
    }

    private void setNQuartos(int nQuartos) {
        for (int i = 0; i < nQuartos; i++) {
            this.quartos.add(new Quarto(i));
        }
    }

    protected void setHospedes(Usuario hospede) {
        while (true) {
            boolean hosp = false;
            for (Usuario e : hospedes) {
                if (e.getId() == hospede.getId()) {
                    hosp = true;
                }
            }
            if (!hosp) {
                System.out.println("*Qual a data do inicio da reservar*");
                String dataIni = Menu.lerString();

                System.out.println("*Qual a data do final da reservar*");
                String dataFin = Menu.lerString();

                System.out.println("*Qual quarto gostaria de se hospedar*");
                int i = 0;
                for (Quarto e : quartos) {
                    if (!e.ocupado) {
                        System.out.println("[" + i + "] - Quarto de numero " + e.getNumero());
                    } else {
                        System.out.println("[" + i + "] - Quarto de numero " + e.getNumero() + " (Ocupado)");
                    }
                    i++;
                }
                int quarto = -1;

                try {
                    quarto = Menu.lerInt();
                    try {
                        Quarto quartoSele = quartos.get(quarto);

                        if (quartoSele.ocupado) {
                            System.out.println("*Quarto ocupado*");
                            Menu.lerString();
                            break;
                        }

                        quartos.get(quarto).setOcupado(true);
                        hospede.setReservas(
                                new Reserva(quartoSele, hospede, dataIni, dataFin, this));
                        hospedes.add(hospede);

                        int j = 0;
                        for (Usuario e : Menu.usuarios) {
                            if (e.getId() == hospede.getId()) {
                                Menu.usuarios.remove(e);
                                Menu.usuarios.add(j, hospede);
                                Menu.logado = hospede;
                            }
                            j++;
                        }
                        System.out.println("*Voce se hospedou com sucesso*");

                    } catch (Exception e) {
                        System.out.println("*Quarto não encontrado*");

                    }
                    Menu.lerString();

                } catch (Exception e) {
                    System.out.println("*Digite um numero inteiro*");
                    Menu.lerString();

                }
            } else {
                System.out.println("*Voce já esta hospedado no hotel*");
                Menu.lerString();
            }
            break;
        }
    }

    protected void unsetHospede(Usuario hospede) {
        boolean cancel = false;
        for (Usuario e : hospedes) {
            if (e.getId() == hospede.getId()) {
                hospedes.remove(e);
                e.unsetReservas(this);
                cancel = true;
                System.out.println("*Hospedagem cancelada*");
                Menu.lerString();
                break;
            }
        }

        if (!cancel) {
            System.out.println("*Voce nao esta hospedado neste hotel*");
            Menu.lerString();
        }
    }

    protected void setFuncionarios() {
        while (true) {
            Menu.consoleClear();

            System.out.println("*Qual funcionario deseja contratar*");
            System.out.println("[-1] - Voltar");

            int i = 0;
            for (Funcionario e : Menu.funcionarios) {
                boolean cont = false;
                for (Funcionario r : funcionarios) {
                    if (e.getId() == r.getId()) {
                        cont = true;
                    }
                }
                if (cont) {
                    System.out.println("[" + i + "] - " + e.getNome() + " / " + e.getFuncao() + " (Já contratado)");
                    i++;
                } else {
                    System.out.println("[" + i + "] - " + e.getNome() + " / " + e.getFuncao());
                    i++;
                }
            }

            int escolha = -2;

            try {
                escolha = Menu.lerInt();
            } catch (Exception erro) {
                System.out.println("*Digite um numero inteiro*");
                Menu.lerString();
                Menu.lerString();
            }

            if (escolha == -1) {
                break;
            } else {
                int j = 0;
                boolean erro = false;
                for (Funcionario e : Menu.funcionarios) {
                    if (escolha == j) {
                        for (Funcionario r : funcionarios) {
                            if (e.getId() == r.getId()) {
                                System.out.println("*Funcionario ja contratado*");
                                erro = true;
                                Menu.lerString();

                            }
                        }
                        if (!erro) {
                            Menu.consoleClear();
                            Double salario = 0.0;
                            try {
                                System.out.println("*Qual o salario do funcionario " + e.getNomeCompleto() + "*");
                                salario = Menu.lerDouble();
                            } catch (Exception exception) {
                                System.out.println("*Digite um numero com virgula*");
                            }
                            e.setSalario(salario);
                            funcionarios.add(e);
                            System.out.println("*Funcionario " + e.getNomeCompleto() + " adiciondo ao "
                                    + this.getNome() + "*");
                            Menu.lerString();
                            break;
                        }
                    }
                    j++;
                }
            }
        }
    }

    // getters

    protected Usuario getDono() {
        return dono;
    }

    protected String getEndereco() {
        return endereco;
    }

    protected String getNome() {
        return nome;
    }

    protected int getNota() {
        return nota;
    }

    protected void getQuartos() {
        for (Quarto e : quartos) {
            e.printInfs();
        }
    }

    public String getHospedes() {
        String string = "";
        if (hospedes.isEmpty()) {
            string = "*Não ha hospedes no hotel*";
        } else {
            int i = 0;
            for (Usuario e : hospedes) {
                string += "\n*Hospede " + i + "*" +
                        "\nNome: " + e.getNomeCompleto();
            }
        }
        return string;
    }

    public String getFuncionarios() {
        String string = "";
        if (funcionarios.isEmpty()) {
            string = "*Não ha funcionarios contratados no hotel*";
        } else {
            int i = 0;
            for (Funcionario e : funcionarios) {
                string += "\n*Funcionario " + i + "*" +
                        "\nNome: " + e.getNomeCompleto() +
                        "\nFunção: " + e.getFuncao() +
                        "\nSalario: " + e.getSalario();
            }
        }
        return string;
    }

    // infs
    protected void printInfs() {
        String string = "\n*Informações do hotel*" +
                "\nNome: " + getNome() +
                "\nEndereço: " + getEndereco() +
                "\nNota: " + getNota() +
                "\nDono: " + getDono().getNome();

        System.out.println(string);
    }

}
