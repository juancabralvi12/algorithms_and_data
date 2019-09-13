package greedy;

public class Stocksll {
    class Solution {
        // txns = 1
        // profit = 11
        // length = n = 5
        // [0,6,0,6,11]


        // queue solution

        // 2 -->
        // n - 1 = 4
        // profit = 6

        // n - 2 = 3
        // 6 + 5 = 11

        // n -3 = 2
        // 6 + 6 = 12


        // space = (n/2)

        //runtime = 2 log n + (n log n + n-1 + n-2 ... 1)

        // (n + n-1 + n-2 ... 1) = (n2 + n / 2) log n

        // n2logn


        //pointers solution
        //  i j k l
        // [1,0,2,11]

        // i j     k l
        //[2,1,4,5,2,9,7]
        public int maxProfit(int[] prices) {
            int best = 0;

            if (prices.length < 2) return 0;
            else if (prices.length < 3) {
                best = Math.max(prices[1]-prices[0], best);
                return best;
            } else if (prices.length < 4){
                best = Math.max(prices[1]-prices[0], best);
                best = Math.max(prices[2]-prices[0], best);
                best = Math.max(prices[2]-prices[1], best);
                return best;
            }

            int bestKL = 0;
            int bestIJ = 0;
            int bestJL = 0;
            int bestIL = 0;


            for(int i = 0, j=1, k=2, l=3; l<prices.length; l++){
                //best = Math.max(prices[j] - prices[i] +  prices[l] - prices[k], best);


                int p = k;
                while (p < l) {
                    if(prices[p] < prices[k]){
                        k = p;
                    }
                    p++;
                }


                p = j;
                while (p < k) {
                    if(prices[p] > prices[j]){
                        j = p;
                    }
                    p++;
                }

                p = i;
                while (p < j) {
                    if(prices[p] < prices[i]){
                        i = p;
                    }
                    p++;
                }

                System.out.println(String.format("i:%s j:%s k:%s l:%s",i,j,k,l));

                bestKL = Math.max(prices[l] - prices[k], bestKL);
                bestIJ = Math.max(prices[j] - prices[i], bestIJ);
                bestJL = Math.max(prices[l] - prices[j], bestJL);
                bestIL = Math.max(prices[l] - prices[i], bestIL);

            /*
             i j k l
            [3,3,5,0,0,3,1,4]


             i j   k l
            [3,3,5,0,0,3,1,4]


             i j k l
            [3,3,5,0,0,3,1,4]


             i j k l
            [3,3,5,0,0,3,1,4]


             i j k l
            [3,3,5,0,0,3,1,4]

            */



            }

            System.out.println(String.format("bestKL:%s bestIJ:%s bestJL:%s bestIL:%s",bestKL,bestIJ,bestJL,bestIL));


            best = Math.max(bestKL + bestIJ, best);
            best = Math.max(bestJL, best);
            best = Math.max(bestIL, best);

            return best;
        }
    }

}
