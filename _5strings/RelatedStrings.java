package strings;
import java.util.*;

public class RelatedStrings {

   
    //optimized......................................................
public static boolean optimized(String str1, String str2) {
    // Check if lengths are equal
    if (str1.length() != str2.length()) {
        return false;
    }

    // Use an array to count character occurrences
    int[] charCount = new int[256]; // Assuming ASCII characters

    // Increment count for characters in str1
    for (int i = 0; i < str1.length(); i++) {
        charCount[str1.charAt(i)]++;
    }

    // Decrement count for characters in str2
    for (int i = 0; i < str2.length(); i++) {
        charCount[str2.charAt(i)]--;
    }

    // Check if all counts are zero
    for (int count : charCount) {
        if (count != 0) {
            return false;
        }
    }

    return true;
}

    public static boolean areStringsRelated(String str1, String str2) {
        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Check if sorted char arrays are equal
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        // Test case 1
        String str1 = "srlent";
        String str2 = "reslnt";
        System.out.println("Test case 1: " + areStringsRelated(str1, str2)); // Output: true

        // Test case 2
        str1 = "less";
        str2 = "sell";
        System.out.println("Test case 2: " + areStringsRelated(str1, str2)); // Output: false
    }
}

    
