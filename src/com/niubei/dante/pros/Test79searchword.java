package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.List;

class Test79searchword {
    int[][] directions = new int[][]{{0,1}, {0,-1},{-1,0},{1,0}};
    boolean find = false;
//  除了从00处开始遍历之外，也可以从任意其他位置开始遍历。
    public boolean exist(char[][] board, String word) {
        StringBuilder cur = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = exist(board, word, cur,i, j,visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word,StringBuilder cur,int row,int col,boolean[][] visited) {
        if(cur.length() == word.length()){
            return true;
        }
        if (row>=board.length || col >=board.length || row <0 || col <0) return false;
        boolean res = false;
        for (int i=0;i<directions.length;i++){
            int[] direction = directions[i];
            if(!visited[row][col] && word.charAt(cur.length()) == board[row][col]){
                visited[row][col] =true;
                cur.append(board[row][col]);
                boolean is = exist(board,word,cur,row+direction[0],col+direction[1],visited);
                if (is) {
                    res =  true;
                    break;
                }
                cur.delete(cur.length()-1,cur.length());
                visited[row][col] =false;
            }
        }
        return res;
    }


    public boolean exist1(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;

                }
            }
        }
        return false;
    }
//    用k记录当前长度
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String args[]){
        int [] arr = new int[]{1,2,3};
        Test79searchword t = new Test79searchword();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        t.exist(board,word);
    }

}
