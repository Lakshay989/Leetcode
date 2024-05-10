public class KthSmallestPrimeFraction_Q786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        double low = 0;
        double high = 1.0;

        while(low<high)
        {
            double mid = (low+high)/2;
            int res[] = getFractionsLessThanMid(arr, k, n, mid);

            if(res[0] == k) return new int[]{arr[res[1]],arr[res[2]]};
            else if(res[0]>k) high = mid;
            else low = mid;
        }

        return new int[]{};
    }

    private int[] getFractionsLessThanMid(int[] arr, int k, int n, double mid)
    {
        double maxLessThanMid = 0.0;
        int x = 0, y = 0;

        int total = 0;
        int j = 1;

        for(int i=0;i<n-1;i++)
        {
            while(j<n && arr[i]>arr[j]*mid)
            {
                j++;
            }

            if(j==n) break;

            total += (n-j);

            double fraction = (double)arr[i]/arr[j];
            if(fraction > maxLessThanMid)
            {
                maxLessThanMid = fraction;
                x = i;
                y = j;
            }
        }
        return new int[]{total, x ,y};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction_Q786 solution = new KthSmallestPrimeFraction_Q786();

        // Test case 1
        int[] arr1 = {1, 2, 3, 5};
        int k1 = 3;
        int[] result1 = solution.kthSmallestPrimeFraction(arr1, k1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected output: [2, 5]

        // Test case 2
        int[] arr2 = {1, 7, 23, 29, 47};
        int k2 = 8;
        int[] result2 = solution.kthSmallestPrimeFraction(arr2, k2);
        System.out.println("Test case 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected output: [1, 47]

        // Test case 3
        int[] arr3 = {1, 2, 3, 5};
        int k3 = 1;
        int[] result3 = solution.kthSmallestPrimeFraction(arr3, k3);
        System.out.println("Test case 3: [" + result3[0] + ", " + result3[1] + "]"); // Expected output: [1, 3]

        // Add more test cases as needed
    }
}
