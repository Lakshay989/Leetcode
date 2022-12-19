import java.util.HashMap;
import java.util.Map;

public class RansomNote_Q383
{
    public static void main(String[] args)
    {
       String ransomNote = "a";
       String magazine = "b" ;
       System.out.println(canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine)
    {
        Map<Character,Integer> ransomMap = new HashMap<>() ;
        Map<Character,Integer> magazineMap = new HashMap<>() ;

        for(int i = 0; i< ransomNote.length() ; i++)
        {
            char c = ransomNote.charAt(i);
            ransomMap.put(c, ransomMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i< magazine.length() ; i++)
        {
            char c = magazine.charAt(i);
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0 ; i< ransomNote.length() ; i++)
        {
            if(magazineMap.get(ransomNote.charAt(i))== null)
            {
                return false ;
            }

            if(ransomMap.get(ransomNote.charAt(i)) <= magazineMap.get(ransomNote.charAt(i)))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true ;
    }
}
