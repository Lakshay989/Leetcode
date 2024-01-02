import java.util.*;

public class EncodeAndDecodeStrings_Q271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        // Iterate through the list of strings
        for (String s : strs) {
            // Append each string to the StringBuilder followed by the delimiter
            encodedString.append(s);
            encodedString.append("π");
        }
        // Return the entire encoded string
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        // Split the encoded string at each occurrence of the delimiter
        // Note: We use -1 as the limit parameter to ensure trailing empty strings are included
        String[] decodedStrings = s.split("π", -1);
        // Convert the array to a list and return it
        // Note: We remove the last element because it's an empty string resulting from the final delimiter
        return new ArrayList<>(Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1));
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings_Q271 codec = new EncodeAndDecodeStrings_Q271();

        // Test cases
        List<String> input1 = new ArrayList<>(Arrays.asList("Hello", "World"));
        String encoded1 = codec.encode(input1);
        List<String> decoded1 = codec.decode(encoded1);
        System.out.println("Input: " + input1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);
        System.out.println();

        List<String> input2 = new ArrayList<>(Arrays.asList(""));
        String encoded2 = codec.encode(input2);
        List<String> decoded2 = codec.decode(encoded2);
        System.out.println("Input: " + input2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decoded2);
        System.out.println();

        // Additional test cases
        List<String> input3 = new ArrayList<>(Arrays.asList("OpenAI", "Language", "Model"));
        String encoded3 = codec.encode(input3);
        List<String> decoded3 = codec.decode(encoded3);
        System.out.println("Input: " + input3);
        System.out.println("Encoded: " + encoded3);
        System.out.println("Decoded: " + decoded3);
        System.out.println();
    }
}
