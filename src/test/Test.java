package test;

public class Test {
    public int binarySearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

//    yilog(h(x)) + (1-yi)log(1-h(x))
//    h(x) = 1/(1+e^x);
}
