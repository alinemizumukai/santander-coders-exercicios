import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        String[][] tabuleiro = inicializarTabuleiro();

        Scanner scan = new Scanner(System.in);
        int contador = 0;
        String primeiro;
        String segundo;
        String ganhador = null;

        do {
            System.out.println("Quem joga primeiro? X ou O");
            primeiro = scan.next();
        } while ( !( primeiro.equals("X") || primeiro.equals("O") ) );

        segundo = primeiro.equals("X") ? "O" : "X";

        System.out.println("\nVamos começar!\n");
        imprimirTabuleiro(tabuleiro);

        while (ganhador == null && contador < 9) {

            System.out.println("Insira a linha: ");
            int linha = scan.nextInt();
            System.out.println("Insira a coluna: ");
            int coluna = scan.nextInt();

            if (tabuleiro[linha][coluna].equals("_")){
                if (contador % 2 == 0){
                    tabuleiro[linha][coluna] = primeiro;
                }else {
                    tabuleiro[linha][coluna] = segundo;
                }

                System.out.println();
                imprimirTabuleiro(tabuleiro);

                ganhador = conferirResultado(tabuleiro);

                contador++;
            }
            else{
                System.out.println("Este campo já foi preenchido! Tente novamente!\n");
            }
        }
        System.out.println("Fim de jogo!");
        System.out.println(ganhador != null ? "O ganhador foi o jogador " + ganhador : "Deu empate!");
    }

    public static String[][] inicializarTabuleiro(){
        String[][] tabuleiro = new String[3][3];

        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = "_";
            }
        }
        return tabuleiro;
    }

    public static void imprimirTabuleiro (String[][] tabuleiro){

        System.out.println("* Tabuleiro *");
        System.out.println();
        System.out.println("\t0\t1\t2");
        System.out.println();
        for (int i = 0; i < tabuleiro.length; i++){
            if (i == 0){
                System.out.print(i + "\t");
            }
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println();
            if (i != 2)
                System.out.print( i + 1 + "\t");
        }
        System.out.println();
    }

    public static String conferirResultado (String[][] tabuleiro){
        String ganhador = null;
        for (int variavel = 0; variavel < tabuleiro.length; variavel++){
            int fixo = 0;
            //checagem das linhas
            if( !tabuleiro[variavel][fixo].equals("_") && tabuleiro[variavel][fixo].equals(tabuleiro[variavel][fixo+1]) && tabuleiro[variavel][fixo].equals(tabuleiro[variavel][fixo+2])){
                ganhador = tabuleiro[variavel][fixo];
            }
            //checagem das colunas
            else if (!tabuleiro[fixo][variavel].equals("_") && tabuleiro[fixo][variavel].equals(tabuleiro[fixo+1][variavel]) && tabuleiro[fixo][variavel].equals(tabuleiro[fixo+2][variavel])){
                ganhador = tabuleiro[fixo][variavel];
            }
        }
        //checagem das diagonais
        int meio = 1;
        var centro = tabuleiro[meio][meio];
        if(  !centro.equals("_") &&
                (( centro.equals(tabuleiro[meio-1][meio-1]) && centro.equals(tabuleiro[meio+1][meio+1])) ||
                        ( centro.equals(tabuleiro[meio-1][meio+1]) && centro.equals(tabuleiro[meio+1][meio-1]))) ){
            ganhador = centro;
        }
        return ganhador;
    }
}
