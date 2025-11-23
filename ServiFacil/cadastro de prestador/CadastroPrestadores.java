import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPrestadores {
    private static ArrayList<Prestador> lista = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

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
        System.out.println("3 - Buscar prestador por nome");
        System.out.println("4 - Remover prestador por ID");
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

        Prestador p = new Prestador(contadorId++, nome, servico, telefone);
        lista.add(p);

        System.out.println("Prestador cadastrado com sucesso!");
    }

    private static void listarPrestadores() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum prestador cadastrado!");
            return;
        }

        System.out.println("\n===== LISTA DE PRESTADORES =====");
        for (Prestador p : lista) {
            System.out.println(p);
        }
    }

    private static void buscarPrestador() {
        System.out.print("Digite o nome para busca: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        boolean encontrado = false;

        for (Prestador p : lista) {
            if (p.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum prestador encontrado!");
        }
    }

    private static void removerPrestador() {
        System.out.print("Digite o ID do prestador para remover: ");
        int id = scanner.nextInt();

        Prestador encontrado = null;
        for (Prestador p : lista) {
            if (p.getId() == id) {
                encontrado = p;
                break;
            }
        }

        if (encontrado != null) {
            lista.remove(encontrado);
            System.out.println("Prestador removido com sucesso!");
        } else {
            System.out.println("Prestador não encontrado!");
        }
    }
}
