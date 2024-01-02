'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

I construct a hashmap to keep count of elements in the array, and it's occurences
Then I sort the keys of the hashmaps and traverse thru it finding the max points I can accumulate

'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maps = defaultdict(int)

        for i in nums:
            if i in maps:
                maps[i] += 1
            else:
                maps[i] = 1

        elements = sorted(maps.keys())
        res = []
        res.append(elements[0] * maps[elements[0]])

        for i in range(1,len(elements)):
            if elements[i] - 1 == elements[i-1]:
                if i - 2 >= 0:
                    res.append(max(elements[i] * maps[elements[i]] + res[i-2], res[i-1]))
                else:
                    res.append(max(elements[i] * maps[elements[i]], res[i-1]))
            else:
                res.append(elements[i] * maps[elements[i]] + res[i-1])

        return res[-1]