package Max_Dot_Product;
public class Max_Dot_Prod {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int cur = nums1[i - 1] * nums2[j - 1];

                dp[i][j] = Math.max(cur, cur + dp[i - 1][j - 1]);

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Max_Dot_Prod sol = new Max_Dot_Prod();

        int[] nums1a = {2, 1, -2, 5};
        int[] nums2a = {3, 0, -6};
        System.out.println(sol.maxDotProduct(nums1a, nums2a)); 

        int[] nums1b = {3, -2};
        int[] nums2b = {2, -6, 7};
        System.out.println(sol.maxDotProduct(nums1b, nums2b));

        int[] nums1c = {-1, -1};
        int[] nums2c = {1, 1};
        System.out.println(sol.maxDotProduct(nums1c, nums2c));
    }
}