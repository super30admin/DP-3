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
1. Brute Force (Recursion): At each element, we have two choices: delete or skip. We do this recursively for each element. There are M elements, M = max value of nums array. For M elements, there are 2^M possibilities.
Time: O(2^M), Space: O(M)
https://youtu.be/IsBihs859dU?t=3998 (Why resort to count sort before running the choose/no-choose exhaustive approach? Till 1:11:46)
https://youtu.be/IsBihs859dU?t=4974  (Why not use hash map to delete elements nums[i]-1 and nums[i]+1?)


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

https://youtu.be/Oepp2HQ7134?t=347 (DP bottom up)
https://youtu.be/IsBihs859dU?t=5200 (DP bottom up w/ backtracking, till 1:31:15)
https://youtu.be/IsBihs859dU?t=5474 (problems with DP bottom up using hash map - a) hash map does not save space since it is still a static array of len = max(nums) under the hood b) hash map keys are not sorted c) bug creeps in
because of absence of keys with 0 freq count but we went for hash map only to
remove keys with 0 freq count)

Time: O(N + M) = O(max(N,M)), Space: O(M), where M = max(nums)
'''

def delete_and_earn(nums):
    ''' recursion '''
    def recurse(counts, index):
        if index >= len(counts):
            return 0

        # logic
        # don't delete
        case_0 = recurse(counts, index+1)

        # delete
        earn = index*counts[index]
        case_1 = recurse(counts, index+2)
        case_1 += earn

        return max(case_0, case_1)

    N = len(nums)
    if N == 0:
        return 0

    # Use the bucket sort technique to
    # place the elements of the nums array
    # as indices
    Mx = 0
    for n in nums:
        Mx = max(Mx, n)

    # Create a counts array (buckets) with len = Mx+1
    # because we prepend [0] to [1,2,...,Mx]
    counts = [0]*(Mx+1)

    for i in range(N):
        counts[nums[i]] += 1
    return recurse(counts, 0)

def delete_and_earn_dp(nums):
    ''' dynamic programming (bottom-up) '''
    N = len(nums)
    if N == 0:
        return 0

    Mx = 0
    for n in nums: # O(N)
        Mx = max(Mx, n)

    counts = [0]*(Mx+1)
    for i in range(N): # O(N)
        counts[nums[i]] += 1

    dp = [0]*(Mx+1)
    for i in range(1, Mx+1): # O(M), where M = max(nums)
        if i == 1:
            dp[i] = max(i*counts[i], dp[i-1])
        else:
            dp[i] = max(i*counts[i] + dp[i-2], dp[i-1])
    return dp[-1]


def run_tests():
    tests = [([3,4,2],6),
             ([2,2,3,3,3,4],9),
             ([1],1), ([1,2,2,2],6),
             ([7,2,1,8,3,3,6,6],27),
             ([2,4,4,5,20], 30),
             ([2,1,8,1,2,4,4,6,4,4,7,3,3,7,7], 41),
    ]

    for test in tests:
        nums, ans = test[0], test[1]
        res1 = delete_and_earn(nums)
        res2 = delete_and_earn_dp(nums)
        print(f"\nnums = {nums}")
        print(f"Max earned = {res1} (recursion)")
        print(f"Max earned = {res2} (dp bottom up)")
        passed = (ans == res1 == res2)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()