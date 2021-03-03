package com.niubei.dante.pros;

import java.util.*;

class Test51 {

//    public List<String> solveNQueens(int n) {
//        int[][] table = new int[n][n];
//        List<String> result = new ArrayList<>();
//        backTrace(table,1,n,result);
//        return null;
//    }

    public void backTrace(int[][] table,int idx,int n,List<String> result){
        if (idx == n){
            result.add(Arrays.stream(table).toString());
            return;
        }
        for (int i = 0;i< n;i++){
            for (int j = 0;j<n;j++){
                if(isAccessable(table,i,j,n)){
                    table[i][j] = 1;
                    backTrace(table,idx+1,n,result);
                    table[i][j] = 0;
                    backTrace(table,idx,n,result);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }
//    对角线上的元素， 行-列/行+列的  值为固定值

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }




    public boolean isAccessable(int[][] table,int i,int j,int n){
        for (int ii = 0 ; ii < n;ii ++){
            if (table[ii][j] > 0){
                return false;
            }
        }

        for (int jj = 0 ; jj < n;jj ++){
            if (table[i][jj] > 0){
                return false;
            }
        }
        for (int k=1;i+k<n && j+k<n;k++){
            if (table[i+k][j+k] > 0){
                return false;
            }
        }

        for (int k=1;i-k>0 && j-k>0;k++){
            if (table[i-k][j-k] > 0){
                return false;
            }
        }
        for (int k=1;i+k<n && j-k>0;k++){
            if (table[i+k][j-k] > 0){
                return false;
            }
        }

        for (int k=1;i-k>0 && j+k<n;k++){
            if (table[i-k][j+k] > 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Test51 t = new Test51();
        int[][] candidates = new int[][]{{1,2},{1,2},{2,3},{3,4}};
        int target = 12;
        t.solveNQueens(target);
//        System.out.println(res);

    }
}
