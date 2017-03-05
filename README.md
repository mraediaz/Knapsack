# README
# Knapsack

This class will create the knapsack, the items, and implement the three  strategies to it to find their different execution times.

#Synopsis

This is a class made as a homework assignment for Dr. Gerry Howser, Design and Analysis of Algorithms, Kalamazoo College.

0/1 is a classic problem in Computer Science. The idea is to  load a knapsack of fixed capacity with items of known weights and profits such that the profit is maximized and the knapsack is not overloaded.
The 0/1 Knapsack problem is NP-Complete so we do not expect a low-cost solution to the problem.

This project will implement three solutions (brute force, greedy algorithm, and dynamic programming) to 0/1 Knapsack and compare the quality of those solutions and the run-time

This . java class wil1 create the knapsack, the items, and implement the three strategies to it to find their different execution times.

#Report Abstract
The KnapsackPP3 pdf is a report that will be validating and analyzing the time complexity of three different
strategies used for 0/1 Knapsack. We hope to compare how close each strategy gets
to the most optimal solution and each strategy's execution time. The three strategies
used are brute force, dynamic programming, and greedy.


# Report Motivation and Background
The 0/1 Knapsack problem is a classic problem in Computer Science whose applications
can be found in multiple elds, such as Operations Research, Process Scheduling and Com-
puter Networking. It is also a problem that appears in real-world decision-making, as the one
used to describe its premise: imagine a thief, whose knapsack holds only a certain amount
of weight (dened as capacity c). The thief has found n items that they could steal, where
each item has a certain weight and value. Unfortunately for the thief, their knapsack cannot
hold all n items and they must choose the perfect combination of items to steal to gain the
most value from their theft. This is called a 0/1 Knapsack problem because each item may
either be taken by the thief or left behind.

There also exists a fractional knapsack problem, where our thief may take parts of items,
rather than exclusively the whole item. To use another analogy, this problem could be il-
lustrated by a test-taker determining which questions to answer. Questions that take less
time to answer have a smaller weight in terms of points than questions that take longer. If
the test-taker must complete their answer to receive points, we would have a 0/1 knapsack
problem. If they may receive points for partial credit, then this would be a fractional knap-
sack problem.

Both 0/1 Knapsack and Fractional Knapsack illustrate the optimal-substructure prop-
erty required for both greedy algorithms and dynamic programming. In this project, we will
be focusing solely on the take-it-or-leave-it version of the problem. We will implement and
compare three dierent solutions: greedy, dynamic, and by brute force. The goal of this
report is to address two major issues: how close does each strategy come to the optimal
solution, and how do the three strategies compare in terms of execution time.

To better understand the terminology used, we provide the following denitions to our
strategies:
 Brute Force: A trial and error method used to nd solutions through exhaustive
eort. In other words, running through all possible choices to nd the most optimal
solution.
 Greedy Solution: We can assemble a globally optimal solution by making a lo-
cally optimal solution, called the greedy choice. In other words, choosing the option
that looks best in the current position, without consideration to the results from sub-
problems.
 Dynamic Programming: Like divide-and-conquer, dynamic programming solves
problems by combining the solutions to sub-problems. This is especially useful when
sub-problems share sub-problems.
The 0/1 Knapsack problem is classied as NP-Complete, meaning that it is nondeter-
ministic in polynomial time. Due to this property, we do not expect a low-cost solution to
the problem, and we can predict that each solution strategy will yield a dierent result.
