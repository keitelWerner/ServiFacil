public class Prestador {
    private int id;
    private String nome;
    private String servico;
    private String telefone;

    public Prestador(int id, String nome, String servico) {
        this.id = id;
        this.nome = nome;
        this.servico = servico;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNome: " + nome +
                "\nServiço: " + servico +
                "\nTelefone: " + telefone +
                "\n-------------------------";
    }
}
