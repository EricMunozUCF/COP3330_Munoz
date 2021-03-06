public class Decrypter {
    public static String decrypt(String strDigits)
    {
        // integer array initialize
        int[] intDigits = new int[4];

        // converts string to integer array
        for (int i = 0; i < 4; i++)
            intDigits[i] = charToInt(strDigits, i);


        // calls function swapArr to swap first and third elements
        int[] intSwappedDigits = swapArr(intDigits, 0, 2);
        // calls function swapArr to swap second and fourth elements
        intSwappedDigits = swapArr(intDigits, 1, 3);

        // each integer will have 7 subtracted from it
        // then modulus 10 for its remainder
        for (int i = 0; i < 4; i++)
        {
            intSwappedDigits[i] = (intSwappedDigits[i] - 7);

            if (intSwappedDigits[i] < 0)
                intSwappedDigits[i] = intSwappedDigits[i] + 10;
        }


        // calls intArrToString
        String encryptedDigits = intArrToString(intSwappedDigits);
        return encryptedDigits;
    }

    public static int charToInt(String digits, int i)
    {
        // takes character at i position in the string, converts to a string value, then parses to be an integer
        return Integer.parseInt(String.valueOf(digits.charAt(i)));
    }

    // Action 2
    public static int[] swapArr(int[] arr, int first, int second)
    {
        int temp = arr[first];
        // replace first element with third element
        arr[first] = arr[second];
        // replace third element with first element stored within temp
        arr[second] = temp;

        return arr;
    }

    // Action 3
    public static String intArrToString(int[] intArr)
    {
        String strArr = "";
        // converts each integer to string
        for (int i = 0; i < 4; i++)
            strArr += String.valueOf(intArr[i]);

        return strArr;
    }
}
