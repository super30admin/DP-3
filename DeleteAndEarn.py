#time complexity: O(max(list))
#Space complexity: O(max(list))
class Solution:
    def deleteAndEarn(self, nums) -> int:
        res=[0]*(max(nums)+1)
        for num in nums:
            res[num]+=num
        choose=res[0]
        notchoose= res[1]
        for i in range(2,len(res)):
            temp=choose
            choose=max(choose,notchoose)
            notchoose=temp+res[i]
        return max(choose,notchoose)
            
        