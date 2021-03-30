package com.ruidli.dante.pros;

class Test75 {
//    i p q 分别代表要插入的元素的位置
//    方法一需要进行两次遍历，那么我们是否可以仅使用一次遍历呢？我们可以额外使用一个指针，即使用两个指针分别用来交换 00 和 11。
//
//具体地，我们用指针 p_0p
//0

//  来交换 00，p_1p
//1

//  来交换 11，初始值都为 00。当我们从左向右遍历整个数组时：
//
//如果找到了 11，那么将其与 \textit{nums}[p_1]nums[p
//1

// ] 进行交换，并将 p_1p
//1

//  向后移动一个位置，这与方法一是相同的；
//
//如果找到了 00，那么将其与 \textit{nums}[p_0]nums[p
//0

// ] 进行交换，并将 p_0p
//0

//  向后移动一个位置。这样做是正确的吗？我们可以注意到，因为连续的 00 之后是连续的 11，因此如果我们将 00 与 \textit{nums}[p_0]nums[p
//0

// ] 进行交换，那么我们可能会把一个 11 交换出去。当 p_0 < p_1p
//0

// <p
//1

//  时，我们已经将一些 11 连续地放在头部，此时一定会把一个 11 交换出去，导致答案错误。因此，如果 p_0 < p_1p
//0

// <p
//1

// ，那么我们需要再将 \textit{nums}[i]nums[i] 与 \textit{nums}[p_1]nums[p
//1

// ] 进行交换，其中 ii 是当前遍历到的位置，在进行了第一次交换后，\textit{nums}[i]nums[i] 的值为 11，我们需要将这个 11 放到「头部」的末端。在最后，无论是否有 p_0 < p_1p
//0

// <p
//1

// ，我们需要将 p_0p
//0

//  和 p_1p
//1

//  均向后移动一个位置，而不是仅将 p_0p
//0

//  向后移动一个位置。
//
    public void sort(int[] nums) {
        int n = nums.length;
//        p代表存放 0的位置， q代表存放2的位置，直接原地调整
        int p = 0, q = n - 1;
        for (int i = 0; i <= q; ++i) {
            if (nums[i] == 0) {
//                交换 i与 p的取值的位置
                nums[i] = nums[p];
                nums[p] = 0;
                ++p;
            }
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q] = 2;
                --q;
                if (nums[i] != 1) {
                    --i;
                }
            }
        }
    }




    public static void main(String[] args){
        Test75 t = new Test75();
        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        int target = 12;
        t.sort(candidates);
//        System.out.println();

    }
}
