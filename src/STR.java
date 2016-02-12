
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Sir Jacob <https://github.com/SirJacob>
 */
public class STR {

    private static boolean isPositive = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int k = 1; k <= 5; k++) {
            System.out.print("Input #" + k + ": ");
            String input = scanner.nextLine();
            isPositive = input.contains("+");
            input = input.replaceAll("\\s", "");
            StringTokenizer st = new StringTokenizer(input, ",");
            System.out.println("Output #" + k + ": " + str(Float.parseFloat(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    private static String str(float f, int length, int decimal) {
        String strFloat = String.valueOf(f);
        String numberFormat = ".";
        //--->  Adds decimal placeholders  <---\\
        for (int x = 0; x < decimal; x++) {
            if (numberFormat.length() < length) {
                numberFormat += "#";
            }
        }
        String output = "";
        if (isPositive) {
            output = "+";
        }
        //--->  Adds placeholders to the right of the decimal  <---\\
        while (numberFormat.length() < length) {
            numberFormat = "#" + numberFormat;
        }
        //--->  A length value that does not allow a value to be printed  <---\\
        if (strFloat.substring(0, strFloat.indexOf(".") + 1).length() + decimal + output.length() > length) {
            return numberFormat;
        }
        //--->  Rounding  <---\\
        DecimalFormat df = new DecimalFormat(numberFormat);
        df.setRoundingMode(RoundingMode.HALF_UP);
        output += String.valueOf(df.format(f));
        //---> A length value greater than the float  <---\\
        while (output.length() < length) {
            output = "#" + output;
        }
        return output;
    }
}
