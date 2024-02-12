"""
    TC: O(m+n)
    SC: O(n)

    Explaination:
        - Find Max number in the array
        - Create a list of length max_num + 1
        - Loop over the nums array
            - Add the num to the value at the num index
        - Approach it like house robber problem from here on
            - Compare the current + prev2 with prev and get the max out of them 
        - Return the max value 
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_num = 0
        for i in nums:
            max_num = max(i, max_num) #O(n)
        
        dae_lst = list()
        for i in range(0, max_num+1): #O(m)
            dae_lst.append(0)
        for i in nums: #O(n)
            dae_lst[i] += i

        max_num = 0
        if len(dae_lst) < 4:
            for i in dae_lst: # O(m)
                max_num = max(max_num, i)
            return max_num                    
        prev2 = dae_lst[0]
        prev = dae_lst[1]
        for i in range(2, len(dae_lst)): #O(m)
            curr = dae_lst[i]
            max_num = max(prev, dae_lst[i] + prev2) 
            prev2 = prev
            prev = max_num

        return max_num