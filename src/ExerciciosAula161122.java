import java.util.Scanner;

public class ExerciciosAula161122 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("***** OPÇÕES *****");
        System.out.println("1 - Imprimir uma tabuada em formato de um triângulo retângulo");
        System.out.println("2 - Verificar se um número é primo ou não (número primo só é divisível por 1 e por ele mesmo)");
        System.out.println("3 - Verificar se o valor faz parte do Fibonacci. Se sim, imprime os próximos 10 valores da sequência.");
        System.out.println("Qual exercício deseja testar?");
        int flag = scan.nextInt();

        switch (flag){
            case 1 :    imprimirTrianguloTabuada(scan);
                break;
            case 2 :    isPrimo(scan);
                break;
            case 3 :    isFibonacci(scan);
                break;
            default:
                System.out.println("Desculpe, não entendi.");
        }

        scan.close();
    }

    public static void imprimirTrianguloTabuada (Scanner scan){
        System.out.println("Informe qual a tabuada deseja visualizar: ");
        int tabuada = scan.nextInt();

        for (int i = 1; i <= 10; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j * tabuada + " ");
            }
            System.out.println();
        }
    }

    public static void isPrimo(Scanner scan){
        System.out.println("Informe um número inteiro: ");
        int num = scan.nextInt();
        int qtdeDivisoes = 0;
        int maxDivisoesPrimo = 2;

        for (int i = 1; i <= num; i++){
            if(num % i == 0){
                qtdeDivisoes++;
                if (qtdeDivisoes > maxDivisoesPrimo)
                    break;
            }
        }

        if(qtdeDivisoes == maxDivisoesPrimo){
            System.out.println("O número é primo.");
        }else{
            System.out.println("O número não é primo.");
        }
    }

    public static void isFibonacci(Scanner scan){
        System.out.println("Informe um número inteiro: ");
        int num = scan.nextInt();

        int numeroUm = 1;
        if(num == 1) {
            System.out.println("É o 1º ou 2º número 1 da sequência?");
            numeroUm = scan.nextInt();
        }

        int anterior = numeroUm == 1 ? 0 : 1;
        int atual = num == 0 ? 0 : 1;
        int temp;

        while(atual < num) {
            temp = anterior;
            anterior = atual;
            atual += temp;
        }

        if (atual == num) {
            System.out.println("O número " + num + " faz parte da sequência de Fibonacci.");

            System.out.println("Informe a quantidade de elementos: ");
            int parada = scan.nextInt();
            System.out.println("\nPróximos " + parada + " valores da sequência:");
            for (int i = 0; i < parada; i++) {
                System.out.print( atual + ((i == parada - 1) ? ".\n" : ", "));
                temp = atual == 0 ? 1 : anterior;
                anterior = atual;
                atual += temp;
            }
        }
        else {
            System.out.println("O número " + num + " não faz parte da sequência de Fibonacci.");
        }
    }
}
