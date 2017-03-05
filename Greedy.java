package MDiaz;/*
   Class: Greedy

   Author: Melany Diaz
   with assistance from: Gerry Howser

   Creation date:  3/5/2016

   Modifications:
        Date        Name        reason
        3/10/2016   Melany Diaz Debugging
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**

 In this project you will implement three solutions to 0/1 Knapsack and compare the quality of those solutions
 and the run-time cost of their solutions.

 This class will implement the Greedy solution: Form a price density array, sort it in non-ascending order,
 and use a greedy strategy to fit the greatest value into the knapsack.

 */
public class Greedy {

    //instance variables
    private static int capacity;
    private static int[] prices;
    private static int[] weight;
    private static int numItems;

    private static int maxValue;
    private static int currentWeight;

    //rearranged weight array
    public static int[] orderedWeights;


    //Constructors
    public Greedy(int capacity, int[] prices, int[] weight, int numItems)
    {
        this.capacity = capacity;
        this.numItems = numItems;
        this.prices = prices;
        this.weight = weight;
        this.orderedWeights = new int[numItems];
    }

    // Methods

    /**
     * finds the solution to the 0/1 knapsack problem
     *
     * Pre-condition:  Array has a length > 0, the integers in the price and weight array are positive, and the
     *                  prices array has the same number of items as the weights array
     *
     * Post condition: The return value is the max value with the capacity allotted.
     **/
    public static int greedy(int capacity, int[] prices, int[] weight, int numItems) {
        //checking preconditions
        assert (numItems > 0);
        assert (prices.length == weight.length);
        for (int i = 0; i < numItems; i++){
            assert (prices[i] >= 0);
            assert (weight[i] >= 0);
        }


        //sort price list in non-ascending order
        HeapSort h = new HeapSort();
        int[] OGPrices = Arrays.copyOf(prices, numItems);

        h.heapSort(prices);
//        System.out.println(Arrays.toString(prices));

        //rearrange weight list accordingly
        orderedWeights = newWeights(prices, OGPrices, weight, numItems);
//        System.out.println(Arrays.toString(orderedWeights));

        //fill the knapsack using the greedy idea
        currentWeight = 0;
        int w =0;
        while(currentWeight <= capacity && w < numItems){
            if(orderedWeights[w] <= (capacity - currentWeight)) {
//                    System.out.print(prices[w] + " ");
                currentWeight += orderedWeights[w];
                maxValue += prices[w];

            }
            w++;
        }
        return maxValue;
    }

    //used to rearrange weight array to match new, ordered, price array
    public static int[] newWeights(int[] newPrices, int[] OGPrices, int[] weight, int numItems){
        for(int j = 0; j < numItems; j++){
            int i = 0;
            boolean found = false;
            while (!found && i <numItems){
                if(newPrices[j] == OGPrices[i]){
                    OGPrices [i] = Integer.MAX_VALUE;
                    orderedWeights[j] = weight[i];
                    found = true;
                }
                i++;
            }
        }
        return orderedWeights;
    }


    //used to time how long it takes to find the solution using greedy algorithm
    //returns the value of the knapscack stolen
    public long TimeToFind(int capacity, int[] prices, int[] weight, int numItems){
        long start = System.nanoTime();
        int value = greedy(capacity, prices, weight, numItems);
        long end = System.nanoTime();
        long duration =  end- start;
        System.out.println("value for greedy algorithm: " + value);
        return duration;
    }

}