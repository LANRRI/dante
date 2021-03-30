package com.ruidli.dante.pros;

import java.util.Random;

public class Test121 {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxValue = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice >maxValue) {
                    maxValue = prices[i]-minprice;
                }
            }
            return maxValue;
        }
}
