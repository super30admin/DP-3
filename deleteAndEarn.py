#Time Complexity: O(m+n),n=len(nums), m-range of nums
#Space Complexity: O(m)

#Create hashmap to have a count of the occurences of the numbers. 
# Denote by F(i) the maximum number of points that one can earn with numbers in the range[minimum, i]. Then we have the recursive relation F(i) = max(F(i-2)+ dic[i] * i, F(i-1)).
#By iterating i over [minimum, maximum] and each time updating F(i-1) and F(i) with the recursive formula, one can easily get F(maximum), the maximum number of points that one can earn with numbers in the range [minimum, maximum], which is the desired value of the solution.



class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dic = collections.defaultdict(int)
        minimum = float('inf')
        maximum = -float('inf')
        for n in nums:
            dic[n] += 1
            maximum = max(maximum, n)
            minimum = min(minimum, n)
        prev = 0
        curr = 0
        for i in range(minimum, maximum+1):
            prev, curr = curr, max(prev + dic[i]*i, curr)
        return curr
