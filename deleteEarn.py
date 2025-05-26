"""
Make grp of pints by number: Convert nums into freq map. Each x -> points[x] = x * freq
Sort keys, apply DP - If you pick x, leave x-1; else, pick max of previous best.
Return max points using DP over the sorted keys.
"""
"""
Time Complexity: O(n log n) - sorting
Space Complexity: O(n) for the count dictionary
"""

from collections import Counter

class deleteEarn:
    def deleteAndEarn(self, nums: list[int]) -> int:
        count = Counter(nums)
        unique = sorted(count)
        n = len(unique)

        earn1, earn2 = 0, 0

        for i in range(n):
            curr_val = unique[i] * count[unique[i]]

            if i > 0 and unique[i] == unique[i-1] + 1:
                earn1, earn2 = max(earn1, earn2), curr_val + earn1
            else:
                earn1, earn2 = max(earn1, earn2), curr_val + max(earn1, earn2)

        return max(earn1, earn2)
    
if __name__=="__main__":
    obj = deleteEarn()
    nums = [2,2,3,3,3,4]
    print(obj.deleteAndEarn(nums))
