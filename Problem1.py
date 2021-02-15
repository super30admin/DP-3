"""
740. Delete and Earn
Time Complexity - O(n)
Space Complexity - O(10**4) worst case
Creating a result list where index indicates the number and value at that index indicates total sum of that number in list
Implemented choose and dont choose as here we are selecting alternate numbers instead of deleting we are just ignoring that number,Hence
Choose is calculated when previous instances' dont choose + value of current input
Dont Choose is calculated max(choose , Dont Choose of previous instace)
Result is max(choose , Dont Choose) for last element
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        result = [0]*(self.get_max(nums) + 1)
        "Creating a result list where index indicates the number and value at that index indicates total sum of that number in list"
        for x in nums:
            result[x] += x
        
        c = 0
        dc = 0
        "Similar logic as house robber problem: As we have to select alternate values hence using concept of choose ,Dont choose "
        for value in range(1,len(result)):
            temp = c
            c = result[value] + dc
            dc = max(temp,dc)
            
        return max(c,dc)
    "Calculates max value in a list"   
    def get_max(self,nums):
        max_val = float("-inf")
        for x in nums:
            if x > max_val:
                max_val = x
        return max_val
            
        
        
        