#Time Complexity: O(N) + O(max(N)) here N -> length of nums and max(N) -> time required to iter arr whose length is max(N) 
#Space Complexity: O(max(N))
#did your code run on leetcode : yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #find maximum in nums
        maximum = max(nums)
        print(maximum)
        
        #convert arr of maximum of nums + 1 length
        arr = [0]*(maximum + 1)
        
        #calculate individual sum of each in nums and store it in arr
        for num in nums:
            arr[num] += num
            
        #House robber pattern bottom up dp
        if len(arr) == 0: return 0
        if len(arr) < 2: return arr[0]
        
        
        choose = arr[0]
        notChoose = max(arr[0],arr[1])
        
        for i in range(2,len(arr)):
            temp = choose
            choose = max(choose,notChoose)
            notChoose = temp + arr[i]
            
        return max(choose,notChoose)
            
        
        
