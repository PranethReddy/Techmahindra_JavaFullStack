public class StringManipulation {
    public static void main(String[] args) {
        // Test all methods
        String inputString = "hello world";
        
        // Test reverseText
        System.out.println("Reversed Text: " + reverseText(inputString));
        
        // Test substringCount
        System.out.println("Occurrences of 'l': " + substringCount(inputString, "l"));
        
        // Test capitalizeWords
        System.out.println("Capitalized Words: " + capitalizeWords(inputString));
    }
    
    // Reversed the string by using a different approach
    static String reverseText(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString();
    }
    
    // Count the occurrences of a substring in a string
    static int substringCount(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }
    
    // Capitalize the first letter of each word
    static String capitalizeWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }
}
