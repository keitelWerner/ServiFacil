import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPrestadores {

    private static ArrayList<Prestador> lista = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;

    public static void iniciar() {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPrestador();
                case 2 -> listarPrestadores();
                case 3 -> buscarPrestador();
                case 4 -> removerPrestador();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== CADASTRO DE PRESTADORES =====");
        System.out.println("1 - Cadastrar prestador");
        System.out.println("2 - Listar prestadores");
        System.out.println("3 - Buscar prestador");
        System.out.println("4 - Remover prestador");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarPrestador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Serviço: ");
        String servico = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Prestador p = new Prestador(contadorId++, nome, servico);
        lista.add(p);

        System.out.println("Prestador cadastrado!");
    }

    private static void listarPrestadores() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum prestador cadastrado!");
            return;
        }

        for (Prestador p : lista) {
            System.out.println(p);
        }
    }

    private static void buscarPrestador() {
        System.out.print("Buscar por nome: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        boolean achou = false;

        for (Prestador p : lista) {
            if (p.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println(p);
                achou = true;
            }
        }

        if (!achou) {
            System.out.println("Nenhum prestador encontrado.");
        }
    }

    private static void removerPrestador() {
        System.out.print("ID para remover: ");
        int id = scanner.nextInt();

        Prestador apagar = null;

        for (Prestador p : lista) {
            if (p.getId() == id) {
                apagar = p;
                break;
            }
        }

        if (apagar != null) {
            lista.remove(apagar);
            System.out.println("Removido com sucesso!");
        } else {
            System.out.println("Prestador não encontrado.");
        }
    }
}
