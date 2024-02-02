#Time Complexity: 2^n
#Space Complexity: O(h)
#Time limit exceeded
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxi=max(nums)
        arr=[0]*(maxi+1)
        for i in range(1,maxi+1):
            count=0
            for j in nums:
                if i==j:
                    count+=j
            arr[i]=count
        print(arr)
        return self.helper(arr,1,0)
    
    def helper(self, arr, pos, amount):
        #base
        if pos>=len(arr):
            return amount
        #logic
        #choose
        case1=self.helper(arr,pos+2,amount+arr[pos])
        #not choose
        case2=self.helper(arr,pos+1,amount)
        return max(case1,case2)
        
#Time Complexity: O(n^2)
#Space Complexity: O(n)       
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxi=max(nums)
        arr=[0]*(maxi+1)
        for i in range(1,maxi+1):
            count=0
            for j in nums:
                if i==j:
                    count+=j
            arr[i]=count
        out_arr=[0]*(maxi)
        if len(out_arr)<2:
            return arr[1]
        out_arr[0]=arr[1]
        out_arr[1]=max(arr[1],arr[2])
        for i in range(2,maxi):
            out_arr[i]=max(out_arr[i-1],arr[i+1]+out_arr[i-2])
        return out_arr[-1]