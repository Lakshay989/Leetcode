public class BestTimeToBuyAndSellStock_Q121
{
    public static void main(String args[])
    {
        int[] prices = {7,1,5,3,6,4} ;

        System.out.println("Max Profit = " +maxProfit(prices));
    }

    public static int maxProfit(int[] prices)
    {
        int minPrice = prices[0] ;
        int maxProfit = 0 ;

        for(int i = 1 ; i< prices.length ; i++)
        {
            if(minPrice > prices[i])
            {
                minPrice = prices[i] ;
            }

            if(maxProfit < prices[i] - minPrice)
            {
                maxProfit = prices[i] - minPrice ;
            }
        }
        return maxProfit ;
    }
}
