public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock=new BestTimetoBuyandSellStock();
        System.out.println(bestTimetoBuyandSellStock.maxProfit(new int[]{1,2}));
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices == null || prices.length < 2) {
            return result;
        }
        int left = 0;
        int right = 1;
        int tmp = 0;
        while (right < prices.length) {
            tmp = prices[right] - prices[left];
            if (tmp>result) {
                result=tmp;
            }
            if(prices[left]>prices[right]){
                left=right;
            }
            right+=1;
        }
        return result;
    }
}
