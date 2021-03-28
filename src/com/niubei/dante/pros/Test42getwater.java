package com.niubei.dante.pros;

import java.util.Stack;

class Test42getwater {
//    暴力操作
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
//   和方法 2 相比，我们不从左和从右分开计算，我们想办法一次完成遍历。
//从动态编程方法的示意图中我们注意到，只要 \text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] （元素 0 到元素 6），积水高度将由 left_max 决定，类似地 \text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i]（元素 8 到元素 11）。
//所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
//我们必须在遍历时维护 \text{left\_max}left_max 和 \text{right\_max}right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
//
//    双指针
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

//    单调栈，从下到上单调减的栈 与 84 面积刚好相反，84使用单调增栈
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.pop()]; //取出要出栈的元素
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
//              雨水的多少取决于当前高度和左侧高度的min
                int min = Math.min(height[stack.peek()], height[current]);
//               纵向 一层一层往上加
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }




    public int getWater(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0;i<height.length;i++){
            while (!stack.empty() && height[stack.peek()]<height[i]){
                int h = stack.pop();
                if (stack.empty()) { // 栈空就出去,代表没有左边界，接不到水
                    break;
                }
                int min = Math.min(stack.peek(),height[i]);
//                为什么是sum？？
                sum += (min-h)*(i-stack.peek()-1);
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String args[]){
        Test42getwater t = new Test42getwater();
        t.trap6(new int[]{5,9,8,7,3,2,4});
    }
}
