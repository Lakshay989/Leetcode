import java.util.Arrays;

public class Main {

    // Write a method to replace all the spaces in a String with %20.


    static String URLify(char[] sentence, int trueLength) {

        int count = 0 ;
        for (int i = 0; i < trueLength; i++) {
            if (sentence[i] == ' ') {
                count ++ ;
            }
        }
        int index = trueLength + count*2 ;

        for(int i = trueLength -1 ; i >= 0 ; i--)
        {
            if (sentence[i] == ' ')
            {
                sentence[index - 1] = '0';
                sentence[index - 2] = '2';
                sentence[index - 3] = '%';
                index-= 3;
            }
            else {
                sentence[index - 1] = sentence[i] ;
                index -- ;
            }
        }
        return Arrays.toString(sentence);
    }

    public static void main(String[] args) {

        char[] sentence = {'M', 'r', ' ', 'J', 'o' , 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '} ;
        System.out.println(URLify(sentence, 13));
    }
}