package com.niubei.dante.pros;


import java.util.Stack;

//主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
//
//如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
//
//如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
//
//即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
//
public class TestMaxsubValue {
    public int maxSubValue(int[] arr) {
        int n = arr.length;
        int dp[] = new int[arr.length+1];
        dp[0] = arr[0];
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        } ;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[i] <= arr[s.peek()]) {
                int peak = arr[s.peek()];
                s.pop();
                int l = s.empty() ? -1 : s.peek();
                int r = i;
                //l和r是边界，因此区间是[l+1,r-1]，其区间和dp[r+1]-dp[l]
                int dist = dp[r] - dp[l + 1];
                res = Math.max(res, peak * dist);
            }
            s.push(i);
        }
        while (!s.empty()) {
            int peak = arr[s.peek()];
            s.pop();
            int l = s.empty() ? -1 : s.peek();
            int r = n;
            int dist = dp[r] - dp[l + 1];
            res = Math.max(res, peak * dist);
        }
        return res;
    }

    public  static  void main(String args[]){
        int[] arr = new int[]{1,5,6,32,4,1};
        TestMaxsubValue t = new TestMaxsubValue();
        t.maxSubValue(arr);
    }
}
