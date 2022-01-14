# Time Complexity : O(N)
# Space Complexity : O(N) - worst case all the elements in the list are unique
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        count = collections.Counter(nums)
        prev = None
        without_curr_element = with_curr_element = 0
        for k in sorted(count):
            if k - 1 != prev:
                without_curr_element, with_curr_element = max(without_curr_element, with_curr_element), k * count[k] + max(without_curr_element, with_curr_element)
            else:
                without_curr_element, with_curr_element = max(without_curr_element, with_curr_element), k * count[k] + without_curr_element
            prev = k
        return max(without_curr_element, with_curr_element)