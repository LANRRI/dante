package com.ruidli.dante.pros;

import java.util.Arrays;

public class Test322CoinChange {
    public int res = Integer.MAX_VALUE;
//   超时
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        find(coins,amount,0,0);
        return res == Integer.MAX_VALUE? -1:res;
    }

    public void find(int[] coins, int amount, int cur,int count){
        if (cur == amount){
            res = Math.min(count,res);
            return;
        }
        if (cur > amount) return;
        for (int i = 0;i<coins.length;i++){
            if (amount-cur>coins[i]){
                find(coins,amount,cur+coins[i],count+1);
            }
        }
    }
//    主要在于保存之前已经计算过的结果
    private int coinChange(int[] coins, int rem, int[] count) {
        // 结束条件：此路径不通
        if (rem < 0) return -1;
        // 结束条件：余额为0，成功结束
        if (rem == 0) return 0;
        // 之前已经计算过这种情况，直接返回结果，避免重复计算
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        // 遍历当前递归子树的每一种情况
        for (int coin : coins) {
            // 用一下coin这个面值的硬币会怎样？res是这个方法的最优情况
            int res = coinChange(coins, rem - coin, count);
            // res<0 即为 res=-1,此法失败，res>min不是最优情况，舍去
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        // count[rem - 1]存储着给定金额amount的解
        // 若为Integer.MAX_VALUE则该情况无解
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String args[]){
        Test322CoinChange t = new Test322CoinChange();
        t.coinChange(new int[]{1,2147483647},2);
    }
}