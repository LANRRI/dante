package com.niubei.dante.pros;

public class nixu {
    public static void main(String args[]){
        int[] arr = new int[5];
        int x = 5;


    }


    public int nixu(int[] arr,int x){
        int ans = -1;
        for(int i = arr.length-1;i>0;i++){
            if(arr[i]>=x){
                ans = i;
            }
        }
        return ans;
    }

    public int nixu(int[] arr,int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x && arr[mid+1]<x) {
                return ans;
            } else if(arr[mid] >=x && arr[mid+1]>x) {
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

}
