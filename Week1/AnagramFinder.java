import java.util.*;

public class AnagramFinder {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        // Populate the pCount map with frequencies of characters in p
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            sCount.put(currentChar, sCount.getOrDefault(currentChar, 0) + 1);

            // If the window size exceeds p.length, remove the leftmost character from the window
            if (i >= p.length()) {
                char leftChar = s.charAt(i - p.length());
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (sCount.get(leftChar) == 0) {
                    sCount.remove(leftChar);
                }
            }

            // Compare the frequency maps of the current window and p
            if (pCount.equals(sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
