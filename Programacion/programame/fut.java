import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Evento {
    long tiempo;
    String descripcion;
    public Evento(long tiempo, String descripcion) {
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }
}

class Consulta {
    int q;
    int index;

    public Consulta(int q, int index) {
        this.q = q;
        this.index = index;
    }
}

public class fut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = Integer.parseInt(scanner.nextLine());
            if (N == 0) {
                break;
            }

            List<Evento> eventos = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] linea = scanner.nextLine().split(" ", 2);
                long tiempo = Long.parseLong(linea[0]);
                String descripcion = linea[1];
                eventos.add(new Evento(tiempo, descripcion));
            }

            int Q = Integer.parseInt(scanner.nextLine());

            List<Consulta> consultas = new ArrayList<>();

            for (int i = 0; i < Q; i++) {
                int q = Integer.parseInt(scanner.nextLine());
                consultas.add(new Consulta(q, i));
            }

            // Ordenar eventos por tiempo
            Collections.sort(eventos, Comparator.comparingLong(e -> e.tiempo));

            // Resolver consultas
            int eventosEncontrados = 0;
            int consultaIndex = 0;
            long inicioPeriodo = -1;
            long finPeriodo = -1;

            for (Evento evento : eventos) {
                eventosEncontrados++;

                while (eventosEncontrados >= consultas.get(consultaIndex).q) {
                    if (inicioPeriodo == -1 || evento.tiempo - inicioPeriodo < finPeriodo - inicioPeriodo) {
                        inicioPeriodo = eventos.get(consultas.get(consultaIndex).index).tiempo;
                        finPeriodo = evento.tiempo;
                    }

                    if (eventosEncontrados == consultas.get(consultaIndex).q) {
                        System.out.println(inicioPeriodo + " " + finPeriodo + " " + eventosEncontrados);
                        consultaIndex++;

                        if (consultaIndex == Q) {
                            break;
                        }
                    }

                    eventosEncontrados--;
                    inicioPeriodo = eventos.get(eventosEncontrados).tiempo;
                }

                if (consultaIndex == Q) {
                    break;
                }
            }

            System.out.println("---");
        }
    }
}
