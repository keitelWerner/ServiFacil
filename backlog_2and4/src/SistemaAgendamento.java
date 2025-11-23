import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAgendamento {

    private static ArrayList<Prestador> prestadores = new ArrayList<>();
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private static int contadorPrestador = 1;

    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void iniciar() {

        int op;
        do {
            menu();
            op = scanner.nextInt();
            scanner.nextLine();

            switch(op) {
                case 1 -> cadastrarPrestador();
                case 2 -> listarPrestadores();
                case 3 -> agendarServico();
                case 4 -> listarAgendamentos();
                case 5 -> verificarDisponibilidade();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void menu() {
        System.out.println("\n===== SISTEMA DE AGENDAMENTO =====");
        System.out.println("1 - Cadastrar prestador");
        System.out.println("2 - Listar prestadores");
        System.out.println("3 - Agendar serviço");
        System.out.println("4 - Listar agendamentos");
        System.out.println("5 - Verificar disponibilidade");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarPrestador() {
        System.out.print("Nome do prestador: ");
        String nome = scanner.nextLine();

        System.out.print("Serviço prestado: ");
        String servico = scanner.nextLine();

        prestadores.add(new Prestador(contadorPrestador++, nome, servico));
        System.out.println("Prestador cadastrado com sucesso!");
    }

    private static void listarPrestadores() {
        if (prestadores.isEmpty()) {
            System.out.println("Nenhum prestador cadastrado!");
            return;
        }

        System.out.println("\n--- LISTA DE PRESTADORES ---");
        prestadores.forEach(System.out::println);
    }

    private static void agendarServico() {
        if (prestadores.isEmpty()) {
            System.out.println("Nenhum prestador disponível!");
            return;
        }

        listarPrestadores();
        System.out.print("Escolha o ID do prestador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Prestador escolhido = null;
        for (Prestador p : prestadores) {
            if (p.getId() == id) {
                escolhido = p;
                break;
            }
        }

        if (escolhido == null) {
            System.out.println("Prestador não encontrado!");
            return;
        }

        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        String dataStr = scanner.nextLine();

        LocalDateTime dataHora = LocalDateTime.parse(dataStr, formato);

        // Verificar se o prestador já está ocupado no horário
        if (!estaDisponivel(escolhido, dataHora)) {
            System.out.println("⚠ Prestador não disponível nesse horário!");
            return;
        }

        agendamentos.add(new Agendamento(escolhido, cliente, dataHora));
        System.out.println("Agendamento realizado com sucesso!");
    }

    private static boolean estaDisponivel(Prestador p, LocalDateTime horario) {
        for (Agendamento a : agendamentos) {
            if (a.getPrestador().getId() == p.getId() &&
                    a.getDataHora().equals(horario)) {
                return false;
            }
        }
        return true;
    }

    private static void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento realizado!");
            return;
        }

        System.out.println("\n--- AGENDAMENTOS ---");
        agendamentos.forEach(System.out::println);
    }

    private static void verificarDisponibilidade() {
        listarPrestadores();
        System.out.print("ID do prestador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Prestador prest = null;
        for (Prestador p : prestadores) {
            if (p.getId() == id) prest = p;
        }

        if (prest == null) {
            System.out.println("Prestador não encontrado!");
            return;
        }

        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        String data = scanner.nextLine();

        LocalDateTime dataHora = LocalDateTime.parse(data, formato);

        if (estaDisponivel(prest, dataHora)) {
            System.out.println("✔ Disponível!");
        } else {
            System.out.println("❌ Ocupado!");
        }
    }
}

