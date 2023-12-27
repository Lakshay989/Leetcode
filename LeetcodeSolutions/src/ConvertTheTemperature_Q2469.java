public class ConvertTheTemperature_Q2469 {
    public static double[] convertTemperature(double celsius) {
        double[] ans = new double[2] ;
        ans[0] = celsius + 273.15 ;
        ans[1] = (celsius * 1.80) + 32 ;

        return ans ;
    }

    public static void main(String[] args) {
        double celsius = 36.50 ;
        //Output: [309.65000,97.70000]
        double[] result ;
        result = convertTemperature(celsius) ;
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

