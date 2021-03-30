package com.ruidli.dante.pros;

public class Test5 {
//    遍历所有长度的子串
//    再遍历每一个位置
//    dp[i][i] 代表i 位 j位是否是回文子串
//
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Test5 t = new Test5();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s = "abcdcba";
        int target = 12;
        t.longestPalindrome(s);
//        System.out.println();

    }
}
