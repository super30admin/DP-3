class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = Counter()

        for num in nums:
            points[num] += num

        prev_num = None
        take = 0
        skip = 0

        for num in sorted(points):
            curr_points = points[num]

            if prev_num is not None and num == prev_num + 1:
                new_take = skip + curr_points
                new_skip = max(take, skip)
            else:
                best_so_far = max(take, skip)
                new_take = best_so_far + curr_points
                new_skip = best_so_far

            take = new_take
            skip = new_skip
            prev_num = num

        return max(take, skip)

# Time Complexity: O(n + k log k), where n is len(nums) and k is the number of unique values
# Space Complexity: O(k), for storing points for each unique number