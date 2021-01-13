#Time Complexity=O(n)
#Space Complexity=O(3n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        l=max(nums)                             #retreiving the maxiumum element from nums
        arr=[0 for i in range(l+1)]             #initializing an array of length l+1 with values 0
        for x in nums:
            arr[x]+=x                           #Adding Summation of element x at the xth position in new array
        result=[]                               #Creating the matrix result
        for i in range(l+1):                    #For each index in the new array take or skip the element and add both values in the matrix
            if i==0:                            #result.Once the matrix is completed, return the maximum value obtained at the last the row.
                r=[0,arr[i]]
            else:
                prev=result[i-1]                #obtaining previous row of the matrix
                r=[max(prev),prev[0]+arr[i]]    #initializing the current row values
            result.append(r)                    #adding the current row to the matrix
        return max(r)                           #returning the maximum value of the last row