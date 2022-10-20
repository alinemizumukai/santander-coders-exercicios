import java.util.Scanner;

public class SalarioAnual {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, informe o salário bruto mensal: ");
        double salarioBrutoMes = scanner.nextDouble();

        if (salarioBrutoMes > 0) {
            double salarioBrutoFerias = salarioBrutoMes + salarioBrutoMes / 3;
            double salarioBrutoAno = salarioBrutoMes * 12 + salarioBrutoFerias;
            double salarioCalculo;
            double inssAno = 0;
            double salarioLiquidoAno;

            for (int i = 0; i < 2; i++) {

                salarioCalculo = (i == 0) ? salarioBrutoMes : salarioBrutoFerias;

                if (salarioCalculo <= 1212.00) {
                    inssAno += (salarioCalculo * 0.075);
                }
                else if (salarioCalculo <= 2427.35) {
                    inssAno += (salarioCalculo * 0.09);
                }
                else if (salarioCalculo <= 3641.03) {
                    inssAno += (salarioCalculo * 0.12);
                }
                else if (salarioCalculo <= 7087.22) {
                    inssAno += (salarioCalculo * 0.14);
                }
                else {
                    inssAno += (salarioCalculo - 900.00);
                }

                if (i == 0) {
                    inssAno *= 12;
                }
            }

            salarioLiquidoAno = salarioBrutoAno - inssAno;

            System.out.println("\nSalário Bruto Anual = " + String.format("%.2f", salarioBrutoAno));
            System.out.println("(-) Desconto INSS no ano = " + String.format("%.2f", inssAno));
            System.out.println("(=) Salario Liquido Anual = " + String.format("%.2f", salarioLiquidoAno));
        }
        else {
            System.out.println("O valor do salário informado não é válido.");
        }
    }
}
