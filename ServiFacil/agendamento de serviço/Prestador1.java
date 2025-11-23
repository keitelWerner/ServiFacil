public class Prestador {
    private int id;
    private String nome;
    private String servico;

    public Prestador(int id, String nome, String servico) {
        this.id = id;
        this.nome = nome;
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getServico() {
        return servico;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " - Serviço: " + servico;
    }
}
