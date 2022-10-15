class Solution:
    # leetcode URL : https://leetcode.com/problems/delete-and-earn/
    # Problem : 740. Delete and Earn
    # Time Complexity : O(2n+nlogn) = O(nlogn)
    # Space Complexity : O (3n) - arrays and dictionary
    def deleteAndEarn(self, nums: List[int]) -> int:
        num_dict = dict()
        min_num = min(nums)
        max_num = max(nums)
        
        for i in nums:
            if i not in num_dict.keys():
                num_dict[i] = 1
            else:
                num_dict[i] = num_dict[i]+1
        
        arr = list(num_dict.keys())
        arr.sort()
        bottom_up = list()
        bottom_up.append(num_dict[arr[0]]*arr[0])
        
        #base cases
        if len(arr) ==1:
            return bottom_up[-1]
        
        if arr[1]==arr[0]+1:
            bottom_up.append(max(num_dict[arr[0]]*arr[0],(num_dict[arr[1]]*arr[1])))
        else:
            bottom_up.append(bottom_up[0]+num_dict[arr[1]]*arr[1])
        
        if len(arr) ==2:
            return bottom_up[-1]
        

        for i in range(2,len(arr)):
            if arr[i] == arr[i-1]+1:
                bottom_up.append(max(bottom_up[i-1],bottom_up[i-2]+(num_dict[arr[i]]*arr[i])))
            else:
                bottom_up.append(bottom_up[i-1]+(num_dict[arr[i]]*arr[i]))
        return bottom_up[-1]