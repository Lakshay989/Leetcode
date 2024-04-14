public class LatestTimeYouCanObtainAfterReplacingCharacters_Q3114 {
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0) == '?'){
            if(s.charAt(1) == '1' || s.charAt(1) == '0' || s.charAt(1) == '?'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        else{
            sb.append(s.charAt(0));
        }

        if(s.charAt(1) == '?'){
            if(s.charAt(0) == '1' || s.charAt(0) == '?'){
                sb.append('1');
            }
            else if (s.charAt(0) == '0'){
                sb.append('9');
            }
            else{
                sb.append('1');
            }
        }
        else{
            sb.append(s.charAt(1));
        }
        sb.append(':');

        if(s.charAt(3) == '?' ){
            sb.append(5);
        }
        else{
            sb.append(s.charAt(3));
        }

        if(s.charAt(4) == '?'){
            sb.append(9);
        }
        else{
            sb.append(s.charAt(4));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        LatestTimeYouCanObtainAfterReplacingCharacters_Q3114 solution = new LatestTimeYouCanObtainAfterReplacingCharacters_Q3114();

        // Test cases
        System.out.println(solution.findLatestTime("??:4?")); // Expected: "11:49"
        System.out.println(solution.findLatestTime("1?:3?")); // Expected: "11:39"
        System.out.println(solution.findLatestTime("?4:?6")); // Expected: "04:56"
        System.out.println(solution.findLatestTime("??:??")); // Expected: "11:59"
    }
}
