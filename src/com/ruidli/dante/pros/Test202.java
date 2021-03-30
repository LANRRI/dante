package com.ruidli.dante.pros;


import java.util.LinkedList;
import java.util.Queue;

class Test202 {
 int sum(int n){
     int sum = 0;
     while (n / 10 > 0){
         sum += Math.pow(n / 10,2);
         n /=10;
     }
     return  sum + n;
 }

 boolean get(int n){
     int slow = n;
     int fast = sum(n);
     while (fast != 1 && slow != fast){
         slow = sum(slow);
         fast = sum(sum(fast));
     }
     return fast == 1;
 }
}
