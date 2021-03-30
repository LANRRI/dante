package com.ruidli.dante.pros;

import java.util.Arrays;

public class Test63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i= 0; i<dp.length;){
            if (obstacleGrid[i][0] == 1){
                for (int k = i; k< dp.length;k++){
                    dp[k][0] = 0;
                }
                i = dp.length;
            }else {
                dp[i][0] = 1;
                i++;
            }
        }

        for (int i= 0; i<dp[0].length;){
            if (obstacleGrid[0][i] == 1){
                for (int k = i; k< dp[0].length;k++){
                    dp[0][k] = 0;
                }
                i = dp[0].length;
            }else {
                dp[0][i] = 1;
                i++;
            }
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
