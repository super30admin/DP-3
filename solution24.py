#Time COmplexity:O(mn)
#Space Complexity:O(1)
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        prev=[]                                     #accessing the previous row
        for l in A:
            if A.index(l)==0:                       #Skipping the first row if the input
                prev=l
                continue
            for i in range(len(l)):                 #for every element in each row
                if i==0:                            #if first element  considering the minimum of first two element of previous row for addition
                    l[i]=l[i]+min(prev[0:2])
                elif i==len(l)-1:                   #if last element considering the minimum of last two elements of previous row for addition
                    l[i]=l[i]+min(prev[i-1:])
                else:
                    l[i]=l[i]+min(prev[i-1:i+2])     #consideing the minimum of previous , current , next columns of previous row for addition
            prev=l
        return min(prev)                               #returning the minimum value of the last row of A