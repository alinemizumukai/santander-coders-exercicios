import java.util.Scanner;

public class MatrizDiagonal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, informe o tamanho da matriz: ");
        int size = scanner.nextInt();
        int[][] matriz = new int[size][size];

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = (j == matriz[i].length - (i + 1)) ? 1 : 0;
            }
        }

        System.out.println("-------------");
        System.out.println("--Resultado--");
        System.out.println("-------------");

        for (int[] ints : matriz) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
}
