package MDiaz;

/*
   Class: Knapsack

   Author: Melany Diaz

   0/1 is a classic problem in Computer Science. The idea is to  load a knapsack of fixed capacity with
   items of known weights and profits such that the profit is maximized and the knapsack is not overloaded.

    The 0/1 Knapsack problem is NP-Complete so we do not expect a low-cost solution to the problem.


     Modifications:
     Date       Name        reason
     3/10/16    Melany Diaz Debugging and finalizing

     This project will implement three solutions (brute force, greedy algorithm, and dynamic programming) to 0/1 Knapsack
     and compare the quality of those solutions and the run-time
     .
     This class wil1 create the knapsack, the items, and implement the three
     strategies to it to find their different execution tines.
     */

import java.util.Arrays;
import java.util.Random;

public class Knapsack {
    public static void main(String[] args) {
        //the number of items for the robber to take
        int numItems = 20;
            //make random generator for the weights and prices
            Random generator = new Random();

            //capacity of the Knapsack (to remain constant)
            int capacity = 100;



            //Array of prices
            //for brute force
            int[] prices = new int[numItems];
            //for greedy
            int[] pricesg;
            //for dynamic (must be one relevant)
            int[] pricesd = new int[numItems + 1];

            //Array of weights
            //for brute force and greedy
            int[] weight = new int[numItems];
            //for dynamic (must be 1 relevant)
            int[] weightd = new int[numItems + 1];


            //fill the price and weight arrays
            //integers between 5-100
            for (int i = 0; i < numItems; i++) {
                prices[i] = generator.nextInt(96) + 5;
                weight[i] = generator.nextInt(96) + 5;
            }

            //price array for greedy, completed
            pricesg = Arrays.copyOf(prices, numItems);

            //price array for dynamic, completed
            //must be one relevant with the 0 index equal to 0
            for (int i = 1; i < numItems + 1; i++) {
                pricesd[0] = 0;
                weightd[0] = 0;
                pricesd[i] = prices[i - 1];
                weightd[i] = weight[i - 1];
            }

    //        //print scenario details
    //        System.out.println(Arrays.toString(prices) + "\n" + Arrays.toString(weight));
    //        System.out.println();
    //        System.out.println("numTimes: " + numItems);

            /////////////////////////// BRUTE FORCE///////////////////////////////
            //make the cases and print the time it took to each
            BruteForce bf = new BruteForce();
            long timebf = bf.TimeToFind(capacity, prices, weight, numItems);

    //        //To print the time it took to solve and the full value of the knapsack
    //        System.out.println(" Duration for brute force: " + timebf + "\n");


            /////////////////////////// DYNAMIC PROGRAMMING///////////////////////
            Dynamic dp = new Dynamic();
            long timedyn = dp.TimeToFind(capacity, pricesd, weightd, numItems);

    //        //To print the time it took to solve and the full value of the knapsack
    //        System.out.println("duration for dynamic programming: " + timedyn + "\n");


            /////////////////////////// GREEDY ALGORITHM /////////////////////////////
            Greedy greedy = new Greedy(capacity, pricesg, weight, numItems);
            long timegreedy = greedy.TimeToFind(capacity, pricesg, weight, numItems);

    //        //To print the time it took to solve and the full value of the knapsack
    //        System.out.println("duration for greedy: " + timegreedy + "\n");


            ////////////////prints out CSV for results/////////////////////////////////

            // numtimes; brute force; dynamic; greedy
            // for time complexities
            System.out.println(numItems + "; " + timebf + "; " + timedyn + "; " + timegreedy);

    }
}
