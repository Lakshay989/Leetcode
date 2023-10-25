public class DefangingAnIPAddress_Q1108 {

    public static String defangIPaddr(String address)
    {
        // Brute force

        // String result = "";

        // for (int i =0 ; i < address.length() ; i++)
        // {
        //     if(address.charAt(i) == '.')
        //     {
        //         result+= "[.]";
        //     }
        //     else
        //     {
        //         result += address.charAt(i) ;
        //     }
        // }

        // return result ;

        address = address.replaceAll("\\.", "[.]");

        return address ;
    }

    public static void main(String[] args)
    {
        // Test case 1: Normal IP address
        String ip1 = "192.168.1.1";
        String result1 = defangIPaddr(ip1);
        System.out.println("Test Case 1: " + result1); // Expected output: "192[.]168[.]1[.]1"

        // Test case 2: Another IP address
        String ip2 = "10.0.0.1";
        String result2 = defangIPaddr(ip2);
        System.out.println("Test Case 2: " + result2); // Expected output: "10[.]0[.]0[.]1"

        // Test case 3: IP address with no periods
        String ip3 = "19216811";
        String result3 = defangIPaddr(ip3);
        System.out.println("Test Case 3: " + result3); // Expected output: "19216811"
    }
 }


