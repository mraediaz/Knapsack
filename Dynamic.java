package MDiaz;/*
   Class: Dynamic

   Author: Melany Diaz
   with assistance from cs.princeton.edu and Gerry Howser

   Creation date:  3/5/2016

   Modifications:
        Date    Name        reason
        3/10/16 Melany Diaz enhansed
*/

import java.util.ArrayList;
import java.util.Arrays;

/**

 In this project you will implement three solutions to 0/1 Knapsack and compare the quality of those solutions
 and the run-time cost of their solutions.

 This class will implement the Dynamic Programming solution.

 */
public class Dynamic {

    //instance variables
    private static int capacity;
    private static int[] prices;
    private static Integer[] weight;
    private static int numItems;

    private static int maxValue;

    //Constructors
    public Dynamic()
    {
    }

    // Methods

    /**
     * finds the solution to the 0/1 knapsack problem
     *
     * Pre-condition:  Array has a length > 0, the integers in the price and weight array are positive, the
     *                  prices array has the same number of items as the weights array, and the weights are integers
     *
     * Post condition: The return value is the max value with the capacity allotted.
     **/
    public static int dynamic(int capacity, int[] prices, int[] weight, int numItems) {
        //checking preconditions
        assert (numItems > 0);
        assert (prices.length == weight.length);
        for (int i = 0; i < numItems; i++){
            assert (prices[i] >= 0);
            assert (weight[i] >= 0);
        }


        int[][] f = new int[numItems + 1][capacity + 1];
        boolean[][] knapsack = new boolean[numItems + 1][capacity + 1];

        //Build table k[][] in bottom up manner
        for (int i = 1; i <= numItems; i++) {
            for (int w = 1; w <= capacity; w++) {
                //don't take the item
                int f1 = f[i - 1][w];

                //take it
                int f2 = Integer.MIN_VALUE;
                if (weight[i] <= w) {
                    f2 = prices[i] + f[i - 1][w - weight[i]];
                }
                    //select the better of two options
                    f[i][w] = Math.max(f1, f2);
                    knapsack[i][w] = (f2 > f1);

            }
        }

            //determine which items to take
            boolean[] take = new boolean[numItems + 1];
            for (int n = numItems, w = capacity; n > 0; n--) {
                if (knapsack[n][w]) {
                    take[n] = true;
                    w = w- weight[n];
                } else
                    take[n] = false;
            }

//            //print results
//            System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
//            for (int n = 1; n < numItems+1; n++)
//                System.out.println(n + "\t" + prices[n] + "\t" + weight[n] + "\t" + take[n]);

            //finds the max value of the most optimal knapsack the thief can fill
            for(int i = 0; i < take.length; i++){
                if(take[i]) {
                    maxValue += prices[i];
                }
            }
            return maxValue;
        }


    //used to time how long it takes to find the solution using dynamic programming
    //returns the value of the knapsack stolen
    public long TimeToFind(int capacity, int[] prices, int[] weight, int numItems){
        long start = System.nanoTime();
        int value = dynamic(capacity, prices, weight, numItems);
        long end = System.nanoTime();
        long duration =  end- start;
        System.out.println("Value for dynamic programming: " + value);
        return duration;
    }

}