package com.ruidli.dante.pros;

import java.util.Stack;

class Test84MaxArea {
//这题考的基础模型其实就是：在一维数组中对每一个数找到第一个比自己小的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
//    枚举所有的当前index ，向左找leftmax ，向右找 rightmax
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int ans = 0;
            for (int mid = 0; mid < n; ++mid) {
                // 枚举高
                int height = heights[mid];
                int left = mid, right = mid;
                // 确定左右边界
                while (left - 1 >= 0 && heights[left - 1] >= height) {
                    --left;
                }
                while (right + 1 < n && heights[right + 1] >= height) {
                    ++right;
                }
                // 计算面积
                ans = Math.max(ans, (right - left + 1) * height);
            }
            return ans;
        }


    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }



    /**
     * 给定一个数组[4,3,2,5,6]，每一个数代表一个矩形的高度，组成的一个二维数组，求其中的最大矩形
     * 解法，用最大单调栈的结构来求解，用来求解一个连续的无规则面积中最大的矩形面积
     *
     * @return
     */
    public static int maxRecFromBottom(int[] height) {
        int maxArea = 0;
        if (height.length <= 0)
            return 0;
        //从小到大的单调栈
        Stack<Integer> stack = new Stack<>();
        //这一步是在求每次遇到不是单调递增的时候那个柱子的面积
        for (int i = 0; i < height.length; i++) {
            //如果栈不为空，且当前元素小于栈顶元素,
//            直到出现当前元素小于栈顶元素的情况，此时依次往前弹出，计算面积，求math.max
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                //左边界
                int k = stack.isEmpty() ? -1 : stack.peek();
                //(右边界 - 左边界)*高度
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        //求整个单调递增的面积
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            //当前的右边界就是数组长度
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;

    }
//    自己写的
    public static int maxRecFromBottom2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0;i<height.length;i++){
            while (!stack.empty() && height[i]<=height[stack.peek()]){
                int right = stack.pop();
                int left = stack.isEmpty()?-1 : stack.peek();
//              此处乘以 height[right] 主要是因为栈中的元素已知大小
                area = Math.max(area,(i-left-1)*height[right]);
            }
            stack.push(i);
        }

        while (!stack.empty()){
            int right = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            area = Math.max(area,(height.length-1-left-1)*height[right]);
        }
        return area;
    }


}
