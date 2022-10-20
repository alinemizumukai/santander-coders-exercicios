import java.util.Scanner;

public class TrianguloInverso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, informe a quantidade de linhas a serem impressas: ");
        int qtdeLinhas = scanner.nextInt();

        System.out.println();

        for (int i = qtdeLinhas; i > 0; i--) {
            String impressao = "";
            for (int j = 0; j < i; j++) {
                impressao += "*";
            }
            System.out.println(impressao);
        }
    }
}
