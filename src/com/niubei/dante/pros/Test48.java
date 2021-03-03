package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test48 {

    public void rotate(int[][] matrix) {//一圈一圈地变换，layer表示圈数
        int n=matrix[0].length;
        for(int layer=0;layer<n/2;layer++){
            for(int column=layer;column<n-1-layer;++column){//四个点轮流换位置
                int temp=matrix[layer][column];
                matrix[layer][column]=matrix[n-1-column][layer];
                matrix[n-1-column][layer]=matrix[n-1-layer][n-1-column];
                matrix[n-1-layer][n-1-column]=matrix[column][n-1-layer];
                matrix[column][n-1-layer]=temp;
            }
        }
    }

    public static void main(String[] args){
        Test48 t = new Test48();
        int[][] candidates = new int[][]{{1,2},{1,2},{2,3},{3,4}};
        int target = 12;
        t.rotate(candidates);
//        System.out.println(res);

    }
}
