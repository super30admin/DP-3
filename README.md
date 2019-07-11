# DAY9

## Problem1 (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

## Problem2 (https://leetcode.com/problems/climbing-stairs/)
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2

Output: 2

Explanation: There are two ways to climb to the top.


1. 1 step + 1 step


2. 2 steps

Example 2:

Input: 3

Output: 3

Explanation: There are three ways to climb to the top.


1. 1 step + 1 step + 1 step


2. 1 step + 2 steps


3. 2 steps + 1 step
