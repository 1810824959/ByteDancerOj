package DP;

/**
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */

public class SharesMax {
    public int maxProfit(int[] prices) {
        if (prices.length<1){return 0;}
        int min = prices[0];
        int P = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            P = Math.max(P, price - min);
        }
        System.out.println(P);
        return P;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        SharesMax sharesMax = new SharesMax();
        sharesMax.maxProfit(prices);
    }
}
