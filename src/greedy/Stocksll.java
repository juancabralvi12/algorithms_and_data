package greedy;

public class Stocksll {
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

    public static void main(String []args){

        /*System.out.println(new Stocksll().maxProfit(new int[]{3,3,5,0,0,3,1,4}));     // [3,3,5,0,0,3,1,4] --> 6
        System.out.println(new Stocksll().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0})); // [1,2,4,2,5,7,2,4,9,0] --> 13
        System.out.println(new Stocksll().maxProfit(new int[]{1,2,7,4})); // [1,2,7,4] --> 6
        System.out.println(new Stocksll().maxProfit(new int[]{2,1,7,4})); // [2,1,7,4] --> 6 [2,1,7,4]
        System.out.println(new Stocksll().maxProfit(new int[]{1,3,5,4,3,7,6,9,2,4})); // --> 10*/
        System.out.println(new Stocksll().maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6})); // --> 11

        // 5 8 and 9 10


    }

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
        int bestIK = 0;
        int bestKJ = 0;
        int bestIJKL = 0;


        for(int i = 0, j=1, k=2, l=3; l<prices.length; l++){
            //best = Math.max(prices[j] - prices[i] +  prices[l] - prices[k], best);

            int pk = k;
            int pj = j;
            int pi = i;

            while (pk < l ) {
                if(prices[pk] <= prices[k]){
                    k = pk;
                }

                while (pj < k) {
                    if(prices[pj] >= prices[j]){
                        j = pj;
                    }
                    while (pi < j) {
                        if(prices[pi] <= prices[i]){
                            i = pi;
                        }
                        pi++;
                    }
                    pj++;
                }

                pk++;
            }







            bestIJKL = Math.max(Math.max(0,prices[l] - prices[k]) + Math.max(0,prices[j] - prices[i]), bestKL);
            bestJL = Math.max(prices[l] - prices[j], bestJL);
            bestIL = Math.max(prices[l] - prices[i], bestIL);
            bestIK = Math.max(prices[k] - prices[i], bestIK);
            bestKJ = Math.max(prices[k] - prices[j], bestKJ);


            bestKL  = Math.max(prices[l] - prices[k], bestIJ);
            bestIJ = Math.max(prices[j] - prices[i], bestIJ);

//            System.out.println(String.format("i:%s j:%s k:%s l:%s max:%s ",i,j,k,l, bestIJKL));
            //System.out.println(String.format("bestIJKL:%s, bestKL:%s bestIJ:%s bestJL:%s bestIL:%s, bestIK:%s, bestKJ: %s",bestIJKL, bestKL,bestIJ,bestJL,bestIL, bestIK, bestKJ));

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




        best = Math.max(bestIJKL , best);
        //best = Math.max(bestJL, best);
        best = Math.max(bestIL, best);
        best = Math.max(bestIK, best);
        best = Math.max(bestKJ, best);


        return best;
    }
}
