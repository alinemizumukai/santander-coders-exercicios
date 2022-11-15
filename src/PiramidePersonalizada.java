import java.util.Scanner;

public class PiramidePersonalizada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, informe o tamanho da pirâmide: ");
        int tamanho = scanner.nextInt();
        int base = tamanho + tamanho - 1;
        int hash = 1;

        System.out.println();

        for (int linha = 0; linha < tamanho; linha++){
            int hifen = (base-hash)/2;
            for(int coluna = 0; coluna < base; coluna++){
                System.out.print((coluna < hifen || coluna >= base - hifen) ? "-" : "#");
            }
            System.out.println();
            hash += 2;
        }
    }
}
