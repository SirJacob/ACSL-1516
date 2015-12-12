
import java.util.Scanner;

/**
 *
 * @author Sir Jacob <https://github.com/SirJacob>
 */
public class CHMOD {

    static int[] input = new int[4];
    static String[] binary = new String[3];
    static String[] permissions = new String[3];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //--->Accept Input
        Scanner s = new Scanner(System.in);
        for (int x = 0; x < input.length; x++) {
            input[x] = s.nextInt();
        }
        //--->Integers to Strings
        for (int x = 0; x < 3; x++) {
            binary[x] = toBinaryString(input[x + 1]);
        }
        toPermissions();
        //--->Print Result
        System.out.println(String.format("%s %s %s and %s %s %s",
                binary[0], binary[1], binary[2],
                permissions[0], permissions[1], permissions[2]));
    }

    /**
     * Converts binary to binary string.
     *
     * @param binary
     * @return
     */
    private static String toBinaryString(int binary) {
        String binaryString = Integer.toBinaryString(binary);
        while (binaryString.length() < 3) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }

    /**
     * Updates the permissions array
     */
    private static void toPermissions() {
        for (int x = 0; x < 3; x++) {
            //--->Handles read (r) permissions
            if (binary[x].substring(0, 1).equals("1")) {
                permissions[x] = "r";
            } else {
                permissions[x] = "-";
            }

            //--->Handles write (w) permissions
            if (binary[x].substring(1, 2).equals("1")) {
                permissions[x] += "w";
            } else {
                permissions[x] += "-";
            }

            //--->Handles execute (s/t/x) permissions
            if (binary[x].substring(2, 3).equals("1")) {
                if (input[0] == x + 1) {
                    permissions[x] += "s";
                } else if (input[0] == 4 && x == 2) {
                    permissions[x] += "t";
                } else {
                    permissions[x] += "x";
                }
            } else {
                permissions[x] += "-";
            }
        }
    }
}
