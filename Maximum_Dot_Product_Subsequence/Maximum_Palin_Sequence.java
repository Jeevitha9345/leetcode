package Maximum_Dot_Product_Subsequence;

public class Maximum_Palin_Sequence {

    // Function to find the length of the Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Main method for testing
    public static void main(String[] args) {
        Maximum_Palin_Sequence seq=new Maximum_Palin_Sequence();

        String s = "bbbab";
        System.out.println("Longest Palindromic Subsequence Length: "
                + seq.longestPalindromeSubseq(s));
    }
}