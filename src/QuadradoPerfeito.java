import java.util.Random;
import java.util.Scanner;

public class QuadradoPerfeito {

    public static void main(String[] args) {
        int[][] matriz = montarEPreencherQuadrado();

        int[] somaLinhas = new int[matriz.length];
        int[] somaColunas = new int[matriz.length];
        int somaLinhaTotal = 0;
        int somaColunaTotal = 0;
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if(i == j){
                    somaDiagonalPrincipal += matriz[i][j];
                }
                if((j == matriz[i].length - (i + 1))){
                    somaDiagonalSecundaria += matriz[i][j];
                }
                somaLinhas[i] += matriz[i][j];
                somaColunas[j] += matriz[i][j];
            }
        }

        for (int item = 0; item < matriz.length; item++){
            somaLinhaTotal += somaLinhas[item];
            somaColunaTotal += somaColunas[item];
        }
        somaLinhaTotal /= matriz.length;
        somaColunaTotal /= matriz.length;

        if( somaLinhaTotal == somaColunaTotal && somaDiagonalPrincipal == somaDiagonalSecundaria && somaLinhaTotal == somaDiagonalPrincipal){
            System.out.println("Trata-se de um quadrado perfeito!");
        }else{
            System.out.println("Não é um quadrado perfeito!");
        }
    }

    public static int[][] montarEPreencherQuadrado() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o tamanho do quadrado desejado:");
        int tamanho = scanner.nextInt();
        int[][] matriz = new int[tamanho][tamanho];
        for (int linha = 0; linha < matriz.length; linha++) {
            int[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                int valorAleatorio = random.nextInt(1000);
                colunas[coluna] = valorAleatorio;
                System.out.print("[" + valorAleatorio + "]");
            }
            System.out.println();
        }
        return matriz;
    }

}