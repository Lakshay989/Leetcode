public class ExistenceOfASubstringInAStringAndItsReverse_Q3083 {
    public boolean isSubstringPresent(String s) {
        if(s.length() == 1) return false ;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return true ;
            }
        }
        for(int i = 0 ; i < s.length() - 2 ; i++){
            if(s.charAt(i) == s.charAt(i + 1) || s.charAt(i) == s.charAt(i +2) || s.charAt(i + 1) == s.charAt(i + 2)){
                return true ;
            }
        }
        return false ;
    }
}
