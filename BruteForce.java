package MDiaz;/*
   Class: Bruteforce

   Author: Melany Diaz
   with assistance from: Gerry Howser

   Creation date:  3/5/2016

   Modifications:
        Date        Name        reason
       03/09/2016   Melany Diaz Implemented Binary Counter
*/

import java.util.ArrayList;

/**
 This will implement three solutions to 0/1 Knapsack and compare the quality of those solutions
 and the run-time cost of their solutions.

 This class will implement the Brute force solution: Try all possible
 combinations of xi and take the maximum value that fits within the
 given capacity.
 */
public  class BruteForce{

    //instance variables
     private static int capacity;
     private static int[] prices;
     private static Integer[] weight;
     private static int numItems;

     private static int currentValue = 0;
    private static int maxValue = 0;
    private static int currentWeight = 0;

    //the knapsack
    public static Integer[] permutations = new Integer[numItems];

    public static boolean overflow = false;

    //Constructors
    public BruteForce()
    {
    }

    // Methods

    /**
     * finds the solution to the 0/1 knapsack problem
     *
     * Pre-condition:  Array has a length > 0, the integers in the price and weight array are positive, and the
     *                      prices array has the same number of items as the weights array
     * Post condition: The returned array is filled with integer "0" and
     *                      overflow is set to "false".
     *   @returns the value of the best combination
     **/
    public static int bruteForce(int capacity, int[] prices, int[] weight, int numItems) {
        //checking preconditions
        assert (numItems > 0);
        assert (prices.length == weight.length);
        for (int i = 0; i < numItems; i++){
            assert (prices[i] >= 0);
            assert (weight[i] >= 0);

        }


        int[]permutable = new int[numItems];
        permutable = Reset(permutable);   //resets permutable to all 0's

        while (!overflow) {
            //go through the array of permutations
            for (int i = 0; i < permutable.length; i++){

                //if there is an item the thief is taking, add it's weight
                //to the weight the thief is considering taking
                if(permutable[i]  == 1) {
                    currentWeight += weight[i];

                    //if that weight fits in the knapsack, add the
                    //values of the prices
                    if (currentWeight <= capacity) {
                        currentValue += prices[i];
                        //find the most optimal value for the thief
                        if(currentValue > maxValue)
                            maxValue = currentValue;
                    }
                    //if the weight was too much for the knapsack's capacity, value is 0
                    else
                        currentValue = 0;
                }
            }

//            //to print all of the combinations of the knapsack considered
//            //the last one printed is the most optimal
//            if(currentValue == maxValue)
//                System.out.println("the permutation is now:  " + toString(permutable) + " Weight: " + currentWeight + " value: " + currentValue + "\t");

            currentWeight = 0;
            currentValue = 0;

            if (!overflow) {
                permutable = Bump(permutable);
            }
        }

        return maxValue;
    }


    public long TimeToFind(int capacity, int[] prices, int[] weight, int numItems){
        long start = System.nanoTime();
        int value = bruteForce(capacity, prices, weight, numItems);
        long end = System.nanoTime();
        long duration =  end- start;
        System.out.println("value for brute force: " + value);
        return duration;
    }

    /**resets the permutation array to all 0's.
     * Pre-condition:  Array has a length > 0
     * Post condition:  The returned array is filled with integer "0" and
     * overflow is set to "false".
     */
    public static int[] Reset(int[] x)
    {
        assert (x.length > 0);
        int i = 0;
        overflow = false;
        while (i < x.length)
        {
            x[i] = 0;
            i++;
        }
        return x;
    }


    /**returns a permutation of all possible combinations of "1"s and "0"s that an array of
     * size n can have
     *
     * Pre-condition:  Array contains only "0" and "1" and length > 0
     * Post condition:  The returned array is "bumpped" by 1 as a binary counter
     *                If the binary counter overflows, overflow is set to
     *               "true" otherwise overflow is set to "false"
     */
    public static int[] Bump(int[] x)
    {
        assert (x.length > 0);
        assert (isBinary(x));
        int i = x.length - 1;
        overflow = true;
        while ((i >= 0) && (overflow))
        {
            if (x[i] == 1)
            {
                x[i] = 0;
            }
            else
            {
                x[i] = 1;
                overflow = false;
            }
            i--;
        }
        return x;
    }

    //takes the array of permutaitons and transforms it to a printable string
    public static String toString(int[] x)
    {
        String result = " ";
        int i = 0;
        while (i < x.length)
        {
            result = result + x[i];
            i++;
        }
        return result;
    }

    //Prints out the different permutations of a binary array
    public void printPermutations(int[] permutable) {
        permutable = this.Reset(permutable);
        while (!this.overflow) {
            System.out.println("the permutation is now:  " + this.toString(permutable) + "\t");
            if (!this.overflow) {
                permutable = this.Bump(permutable);
            }
        }
    }

    //assert methods
    //confirms that the integers in the permutation array are just 0s and 1s
    public static boolean isBinary(int[] x)
    {
        boolean result = true;
        int i = 0;
        while ((i <= x.length) && (result))
        {
            if ((x[i] != 0) && (x[i] != 1))
            {
                result = false;
            }
            i++;
        }
        return result;
    }
}