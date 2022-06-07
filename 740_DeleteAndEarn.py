# Time Complexity: O(n) + O(max(m))
# Space Complexity: O(max(m))


class Solution:
    def deleteAndEarn(self, nums) -> int:
        maxx = 0

        # find maximum number in given array
        for num in nums:
            maxx = max(num, maxx)
        
        # make new array which can store sum of particular number 
        # for ex: [2,2,3,3,3,4] -> for this below code will make array of size 4+1=5
        # and for loop will store sum of particular value. for this array result will [0,0,4,9,4]
        arr = [0 for i in range(0, maxx+1)] 
        for num in nums:
            arr[num] +=num

        # house robe will implemet on this array 
        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2, len(arr)):
            temp = curr
            curr = max(prev + arr[i], temp)
            prev = temp

        return curr

obj = Solution()
print(obj.deleteAndEarn([2,2,3,3,3,4]))