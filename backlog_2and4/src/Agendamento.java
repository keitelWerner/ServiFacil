import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
    private Prestador prestador;
    private String cliente;
    private LocalDateTime dataHora;

    public Agendamento(Prestador prestador, String cliente, LocalDateTime dataHora) {
        this.prestador = prestador;
        this.cliente = cliente;
        this.dataHora = dataHora;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "\nCliente: " + cliente +
                "\nPrestador: " + prestador.getNome() +
                "\nServiço: " + prestador.getServico() +
                "\nHorário: " + dataHora.format(f) +
                "\n-------------------------------";
    }
}

