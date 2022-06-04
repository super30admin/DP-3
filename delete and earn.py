# time and space: O(nlogn), O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        count = Counter(nums)
        nums = sorted(list(set(nums)))

        e1, e2 = 0, 0  # earn2 is prev max and earn1 is prev to earn2
        for i in range(len(nums)):
            currE = nums[i] * count[nums[i]]  # number* freq
            # when e1 and e2 can't be taken together ie let array is 1,2,3 current max is 3,               #e2 is 2 and e1 is 1 then we can't take e2 and e1 together
            if i > 0 and nums[i] == nums[i - 1] + 1:
                temp = e2
                e2 = max(currE + e1, e2)
                e1 = temp
            # 2,3,5
            else:
                temp = e2
                e2 = currE + e2
                e1 = temp
        return e2
