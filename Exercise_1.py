'''
740 Delete and Earn
https://leetcode.com/problems/delete-and-earn/description/

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1. Return the maximum number of points you can earn by applying the above operation some number of times.


Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.

Constraints:
1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104

Solution:
1. Brute Force (Recursion): At each element, we have two choices: delete or skip. We do this recursively for each element. Thus for N elements, we have a worst case scenario of 2^N possibilities.
Time: O(2^N), Space: O(N)

2. Tabulation 1 (bottom-up approach): We construct a 1-D dp[] array and maintain a hash map to preserve the counts of each element. We define:
dp[i] = max score earned until ith element (curr element) of array, i.e. A[i-1].
      = max(max score from deleting curr element, max score from not deleting curr element)

      = if A[i-1]-1 == A[i-2]:  (curr = A[i-1], prev = A[i-2], pprev = A[i-3])
            yes: max(score from deleting curr + max score from deleting pprev,
                 max score from deleting prev)
            no: max(score from deleting curr + max score from deleting prev,
                 max score from deleting prev)

      = yes: max(count(A[i-1])*A[i-1] + dp[i-2], dp[i-1])
        no:  max(count(A[i-1])*A[i-1] + dp[i-1], dp[i-1])

Step 0: init dp[0] = 0 (max score is 0 before starting to delete)
             dp[1] = count(A[0])*A[0] (score earned from deleting 0th ele)

Step 1: for i:2...N-1, compute dp[i]

Step 2: return dp[N]

Time: O(N log N + N) = O(N log N), Space: O(2N) = O(N)
O(N log N) to sort the array + O(N) to populate the dp array

3. Tabulation 2 (bottom-up approach): For each element in input array A, get the score of that element (score = element * count(element)) and store the element and score in an a separate array where the index of the array is the element itself and the value is the score. After this preprocessing step, the problem becomes identical to the house robber problem.

https://youtu.be/Oepp2HQ7134?t=347

Time: O(N + max(A)), Space: O(max(A))
'''
from collections import Counter
import time

def delete_and_earn(A):
    ''' recursion without memoization '''
    def recurse(A, index, score):
        N = len(A)
        if index >= N:
            return score

        # case 0: dont delete
        case_0 = recurse(A, index+1, score)

        # case 1: delete
        # a) delete all elements whose value is A[index]
        this_element = A[index]
        i, count = index, 0
        while i < N and A[i] == this_element:
            i = i + 1
            count = count + 1
        # b) Now delete all elements whose value is A[index] + 1
        # Note: we will not have any element whose value is A[index] - 1
        # since A has been sorted in ascending order
        while i < N and A[i] == this_element + 1:
            i = i + 1
        case_1 = recurse(A, i, score + count*A[index])

        return max(case_0, case_1)

    N = len(A)
    if N == 0:
        return 0
    A = sorted(A)
    return recurse(A, 0, 0)

def delete_and_earn_dp1(A):
    ''' dynamic programming (bottom-up) '''
    if len(A) == 0:
        return 0

    counts = Counter(A) # T: O(N), S: O(N) (hash table)
    nums = sorted(list(counts.keys())) # T: O(N log N)
    N = len(nums)

    # Define dp[i] = max score earned until ith element of array, i.e. A[i-1]
    dp = [-1]*(N+1) # S: O(N) (dp array)
    dp[0] = 0 # score before we start deleting anything = 0
    dp[1] = nums[0]*counts[nums[0]] # score after delete first elem of array

    for i in range(2, N+1):  # T: O(N)
        curr = nums[i-1]
        prev = nums[i-2]

        # If we delete curr element, we have two cases for considering the max score of prev element:
        if curr-1 == prev: # curr and prev differ by 1
            # don't take the max score from deleting prev ele, instead
            # take the max score from deleting the ele before prev ele
            # e.g. in [2,3,4], if we delete 4, then we take the score from deleting 2 and add the score from curr ele (4)
            score_delete_curr = dp[i-2] + curr*counts[curr]
        else: # curr and prev dont differ by 1
            # since curr and prev element don't differ by one, we are free to take the max score from deleting prev ele
            # e.g. in [2,3,5], if we delete 5, then we are free to take the score from deleting 3 and add the score from curr ele (5)
            score_delete_curr = dp[i-1] + curr*counts[curr]

        # If we dont' delete the curr element
        score_skip_curr = dp[i-1]

        # max score = max(delete, skip)
        dp[i] = max(score_delete_curr,score_skip_curr)

    return dp[N]


def delete_and_earn_dp2(A):
    ''' dynamic programming (bottom-up) '''
    N = len(A)
    if N == 0:
        return 0

    # find max of array A
    max_A = float('-inf')
    for i in range(N): # O(N)
        max_A = max(max_A, A[i])

    # each element in A is a score obtained by deleting that element. Hence, store the score of each element in an array scores where index of scores is the element and value is the freq count * element
    # eg. If A = [1,1,4,4], then
    # scores   = [0, 2, 0, 0, 8]
    #             0  1  2  3  4
    scores = [0]*(max_A+1) # O(Max)
    for i in range(N):
        index = A[i]
        scores[index] += index

    # We can compute the dp values by using a 1-D DP array which takes O(max_A) space or by using two variables which takes O(1) space

    # a) 1-D DP array O(max_A)
    # dp = [0]*(max_A+1)
    # dp[0] = 0
    # dp[1] = scores[1]
    # for i in range(2, max_A+1):
    #     skip =  dp[i-1] # case 0
    #     delete = + dp[i-2] + scores[i]  # case 1
    #     dp[i] = max(skip, delete)
    # return dp[max_A]

    # b) 1two variables O(1)
    skip = 0
    delete = scores[1]
    for i in range(2, max_A + 1): # O(max_A)
        prev_skip = skip
        skip = max(skip, delete) # max (prev skip, prev del)
        delete = prev_skip + scores[i] # prev skip + current score
    return max(skip, delete)


def run_delete_and_earn():
    tests = [([3,4,2],6), ([2,2,3,3,3,4],9), ([1],1), ([1,2,2,2],6), ([7,2,1,8,3,3,6,6],27), ([2,4,4,5,20], 30)]

    for test in tests:
        A, ans = test[0], test[1]
        start = time.time()*1000
        score = delete_and_earn(A)
        elapsed =  time.time()*1000 - start
        print(f"\nmatrix = {A}")
        print(f"score = {score}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == score}")

    for test in tests:
        A, ans = test[0], test[1]
        start = time.time()*1000
        score = delete_and_earn_dp1(A)
        elapsed =  time.time()*1000 - start
        print(f"\nmatrix = {A}")
        print(f"score = {score}, time = {elapsed:.2f} ms (dp-1 tabulation)")
        print(f"Pass: {ans == score}")

    for test in tests:
        A, ans = test[0], test[1]
        start = time.time()*1000
        score = delete_and_earn_dp2(A)
        elapsed =  time.time()*1000 - start
        print(f"\nmatrix = {A}")
        print(f"score = {score}, time = {elapsed:.2f} ms (dp-2 tabulation)")
        print(f"Pass: {ans == score}")

run_delete_and_earn()