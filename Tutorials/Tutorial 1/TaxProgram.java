import java.text.DecimalFormat;
import java.util.Scanner;

public class TaxProgram {
    public static void main(String[] args) {
        double income, fedTax, provTax;
        int dependents;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your taxable income: ");
        income = input.nextDouble();
        System.out.println();

        System.out.print("Please enter the amount of dependents: ");
        dependents = input.nextInt();
        System.out.println();

        fedTax = 0.0;
        provTax = 0.0;

        // for fedTax
        if (income <= 29590) {
            fedTax = (0.17 * income);
        }
        else if((29590.01 <= income) & (income <= 59179.99)) {
            fedTax = (0.17 * 29590) + (0.26 * (income - 29590));
        }
        else if(income >= 59180) {
            fedTax = (0.17 * 29590) + (0.26 * 29590) + (0.29 * (income - 59180));
        }
        // for provTax
        double bprovTax = (0.425 * fedTax);
        if (bprovTax < (160.5 + (328*dependents))) {
            provTax = 0.0;
        }
        else {
            provTax = bprovTax - (160.5 + (328*dependents));
        }
        // for total tax
        double totalTax = fedTax + provTax;

        System.out.println("Here is your tax breakdown:");
        System.out.println();
        DecimalFormat format = new DecimalFormat("$###,###,###,###,###,###.00");
        System.out.println(String.format("%6s%30s", "Income", format.format(income)));
        System.out.println(String.format("%6s%26s", "Dependents", dependents));
        System.out.println("----------------------------------------");
        System.out.println(String.format("%6s%25s", "Federal Tax", format.format(fedTax)));
        System.out.println(String.format("%6s%22s", "Provincial Tax", format.format(provTax)));
        System.out.println("========================================");
        System.out.println(String.format("%6s%27s", "Total Tax", format.format(totalTax)));
    }
}
