# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = collections.defaultdict(lambda: 0)
        highest = 0
        for n in nums:
          freq[n] += 1
          highest = max(highest, n)

        back_two = 0
        back_one = 0
        for i in range(highest + 1):
          temp = back_two
          back_two = back_one
          back_one = max(back_one, i * freq[i] + temp)

        return back_one



        



        
