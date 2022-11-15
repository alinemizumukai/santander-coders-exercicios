import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class DiaDaSemana {
    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            LocalDate date = LocalDate.now();
            System.out.println("Informe uma data:");
            String data = scan.nextLine();

            String[] camposData = data.split("/", 0);
            DayOfWeek dayOfWeak = date.parse(camposData[2] + "-" + camposData[1] + "-" + camposData[0]).getDayOfWeek();
            String diaSemana = null;

            switch (dayOfWeak) {
                case SUNDAY:
                    diaSemana = "domingo";
                    break;
                case MONDAY:
                    diaSemana = "segunda-feira";
                    break;
                case TUESDAY:
                    diaSemana = "terça-feira";
                    break;
                case WEDNESDAY:
                    diaSemana = "quarta-feira";
                    break;
                case THURSDAY:
                    diaSemana = "quinta-feira";
                    break;
                case FRIDAY:
                    diaSemana = "sexta-feira";
                    break;
                case SATURDAY:
                    diaSemana = "sábado";
                    break;
            }
            if (diaSemana != null)
                System.out.println("O dia da semana para a data " + data + " será " + diaSemana);
        }
        catch(Exception e){
            System.out.println("Data inválida");
        }
    }
}
