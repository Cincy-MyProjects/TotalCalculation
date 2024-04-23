import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TotalCalculation {
    public static void main(String[] args) throws IOException {
        File file = new File("items.txt");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
             Scanner scanner = new Scanner(bufferedInputStream)) {

            double subtotal = 0.0;
            while (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                subtotal += value;
            }

            double taxRate = 5.3 / 100;
            double tax = subtotal * taxRate;
            double total = subtotal + tax;

            File file2 = new File("total.txt");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file2)) {
                PrintStream printstream = new PrintStream(fileOutputStream);
                printstream.printf("The sub-total is $%.2f\n", subtotal);
                printstream.printf("The tax is $%.2f\n", tax);
                printstream.printf("The total is $%.2f\n", total);
            }
        }
    }
}
