class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0

        points ={}
        for x in nums:
            points[x] = points.get(x, 0) + x

        values = sorted(points)
        prev = None
        take = skip = 0

        for v in values:
            if prev == v - 1:
                take, skip = skip + points[v], max(take, skip)
            else:
                take, skip = max(take, skip) + points[v], max(take, skip)
            prev = v

        return max(take, skip)