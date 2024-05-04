public class CompareVersionNumbers_Q165 {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        //The versions are equal
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers_Q165 versionComparator = new CompareVersionNumbers_Q165();

        // Test case 1: Compare equal versions
        String version1 = "1.2.3";
        String version2 = "1.2.3";
        System.out.println("Test case 1:");
        System.out.println("Input: " + version1 + ", " + version2);
        System.out.println("Output: " + versionComparator.compareVersion(version1, version2)); // Expected output: 0 (equal versions)

        // Test case 2: Compare different major versions
        version1 = "2.0";
        version2 = "1.2.3";
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + version1 + ", " + version2);
        System.out.println("Output: " + versionComparator.compareVersion(version1, version2)); // Expected output: 1 (version1 > version2)

        // Test case 3: Compare different minor versions
        version1 = "1.4";
        version2 = "1.8.9";
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + version1 + ", " + version2);
        System.out.println("Output: " + versionComparator.compareVersion(version1, version2)); // Expected output: -1 (version1 < version2)

        // Test case 4: Compare different patch versions
        version1 = "1.2.5";
        version2 = "1.2.3";
        System.out.println("\nTest case 4:");
        System.out.println("Input: " + version1 + ", " + version2);
        System.out.println("Output: " + versionComparator.compareVersion(version1, version2)); // Expected output: 1 (version1 > version2)

        // Test case 5: Compare versions with trailing zeros
        version1 = "1.0";
        version2 = "1";
        System.out.println("\nTest case 5:");
        System.out.println("Input: " + version1 + ", " + version2);
        System.out.println("Output: " + versionComparator.compareVersion(version1, version2)); // Expected output: 0 (equal versions)
    }
}
