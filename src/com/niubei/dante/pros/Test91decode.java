package com.niubei.dante.pros;

class Test91decode {
    public int numDecodings(String s) {
        if (s.length() < 1 || s.charAt(0) == '0') return 0;
        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if (i >= s.length()) return 1;
        int ans = 0;
        if (i + 2 <= s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) ans += dfs(i + 2, s);
        }
        if (s.charAt(i) != '0') ans += dfs(i + 1, s);
        return ans;
    }
    //dp,解码种类，如果当前种类只有一种变化方式，那么总种数，其实就是dp【i-1】或者dp【i-2】的种数
    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int[] dp = new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                //如果前一位不是1或者2,显然无法解码
                if (chars[i - 1] != '1' && chars[i - 1] != '2') return 0;
                //如果当前位置是0，那么他自己肯定单独没法成为一个解码，必须和i-1的值合在一起解码，所以dp[i] = dp[i-2]
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
//                i=1 是代表index=1,i不为1时，当前位置既可以单独解码，也可以与前一位置合起来解码，所以是dp[i-1]+ dp[i-2]
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }






    public static void main(String[] args){
        Test91decode t = new Test91decode();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
        System.out.println(t.numDecodings(s));
//        System.out.println();

    }
}
