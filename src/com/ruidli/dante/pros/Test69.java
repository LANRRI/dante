package com.ruidli.dante.pros;

class Test69 {
//    二分查找
    public int mySqrt(int x) {
        int l =0, r =x ,result = -1;
        while (l <= r){
            int mid = (l+r)/2;
//            必须设置为long 否则对于最大值，可能会导致mid * mid 永远小于 x
            if ((long)mid * mid <=x){
                result = mid;
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return result;
    }

}
