# SC = 2 * O(max(N)) =  O(max(N))
# TC = O(max(N))
# LC = yes
from collections import Counter
from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        frequencyMap = Counter(nums)
        counterMap = dict()
        for i in range(max(frequencyMap)+1):
            counterMap[i] = (i * frequencyMap[i])if i in frequencyMap else 0
        # print(frequencyMap)
        # print(counterMap)
        table = [[0 for i in range(2)] for i in range(max(frequencyMap)+1)]
        for i in range(len(table)):
            #choose
            table[i][0] = max(table[i-1]) if i > 0 else 0
            #not choose
            table[i][1] = (table[i-1][0] + counterMap[i] )if i > 0 else 0
        # print(table)
        return max(table[-1])
        
        