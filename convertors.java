package convertors;
import java.util.Arrays;

class Conversions {
    /**
     * Displays the binary format of a number
     *
     * @param number to be displayed in binary
     * @return the binary format of the number parameter
     */
    public int displayBinary(int number) {
        if (number > 1) {
            displayBinary(number / 2);
        }

        return number % 2;
    }

    /**
     * Converts a binary integer into a decimal
     *
     * @param binary the binary number to  be converted into a decimal
     * @return a decimal format of the binary parameter
     */
    public int convertBinaryToDecimal(int binary) {
        int decimal = 0;
        int n = 0;

        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }

        return decimal;
    }

    /**
     * Converts a decimal integer into a binary
     *
     * @param decimal the decimal integer to be converted into a binary
     * @return string of the decimal.
     */
    public StringBuilder convertDecimalToBinary(int decimal) {
        StringBuilder decimalResult = new StringBuilder();
        int[] binary = new int[40];
        int index = 0;

        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }

        for (int i = index - 1; i >= 0; i--) {
            decimalResult.append(binary[i]);
        }

        return decimalResult;
    }

    /**
     * Converts a decimal integer into a hexadecimal format.
     *
     * @param decimal the decimal integer to be converted into a binary
     * @return a String hexadecimal format of the decimal parameter
     */
    public String convertDecimalToHexDecimal(double decimal) {
        int rem;
        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (decimal > 0) {
            rem = (int) (decimal % 16);
            hex.insert(0, hexChars[rem]);
            decimal = decimal / 16;
        }

        return hex.toString();
    }

    /**
     * A helper function to convert a number into a hexadecimal
     *
     * @param number the decimal integer to be converted into a binary
     * @return a hexadecimal.
     */
    public int convertHexDecimalToDecimal(int number) {
        return Integer.parseInt(String.valueOf(number), 16);
    }

    /**
     * Converts a binary integer into a hexadecimal format.
     *
     * @param binary the integer to be converted a hexadecimal
     * @return a String hexadecimal format of the binary parameter
     */
    public String convertBinaryToHexDecimal(long binary) {
        int decimalNumber = 0, i = 0;

        while (binary > 0) {
            decimalNumber += Math.pow(2, i++) * (binary % 10);

            binary /= 10;
        }

        return Integer.toHexString(decimalNumber).toUpperCase();
    }

    public String convertHexDecimalToBinary(String hex) {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");

        return hex;
    }

    /**
     * A function to add two binary numbers together and return their sum
     *
     * @param binaryNumber1 the first binary number to be added.
     * @param binaryNumber2 the second binary number to be added.
     * @return the sum of the binaryNumber1 and binaryNumber2 parameters.
     */
    public int[] binaryAddition(int binaryNumber1, int binaryNumber2) {
        int i = 0, carry = 0;
        int[] sum = new int[10];

        while (binaryNumber1 != 0 || binaryNumber2 != 0) {
            sum[i++] = (binaryNumber1 % 10 + binaryNumber2 % 10 + carry) % 2;
            carry = (binaryNumber1 % 10 + binaryNumber2 % 10 + carry) / 2;

            binaryNumber1 = binaryNumber1 / 10;
            binaryNumber2 = binaryNumber2 / 10;
        }

        if (carry != 0) {
            sum[i++] = carry;
        }

        --i;

        return sum;
    }
}

/**
 * Entry point for the Java_Convertors program
 */
public class convertors {
    public static void main(String[] args) {
        Conversions conversionObj = new Conversions();

        System.out.printf(
                "DISPLAY BINARY: %s \n", conversionObj.displayBinary(911)
        );

        System.out.printf(
                "CONVERT BINARY TO DECIMAL: %s \n", conversionObj.convertBinaryToDecimal(101)
        );

        System.out.printf(
                "CONVERT DECIMAL TO BINARY: %s \n", conversionObj.convertDecimalToBinary(101)
        );

        System.out.printf(
                "CONVERT DECIMAL TO HEXADECIMAL: %s \n", conversionObj.convertDecimalToHexDecimal(190.20)
        );

        System.out.printf(
                "CONVERT HEXADECIMAL TO DECIMAL: %s \n", conversionObj.convertHexDecimalToDecimal(1010)
        );

        System.out.printf(
                "CONVERT BINARY TO HEXADECIMAL: %s \n", conversionObj.convertBinaryToHexDecimal(1010)
        );

        System.out.printf(
                "CONVERT HEXADECIMAL TO DECIMAL: %s \n", conversionObj.convertHexDecimalToBinary("")
        );

        System.out.printf(
                "BINARY ADDITION: %s \n", Arrays.toString(conversionObj.binaryAddition(11100, 10101))
        );
    }
}

