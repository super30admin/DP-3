#Time Complexity O(n)
#Space Complexity O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #Goal is to find max number
        if nums ==None or len(nums)==0:
            return 0
        
        data=dict()
        mx = 0
        for x in nums:
            mx = max(mx,x)
        
        arr = [0] * (mx+1)
        
        for x in range(len(nums)):
            arr[nums[x]] += nums[x]
        sk =0
        tk =0
        
        for x in range(1, len(arr)):
            tmp = sk
            sk = max(sk,tk)
            tk = tmp + arr[x]
        return max(sk,tk)
        
            
            
#         data = dict()
        
#         for x in nums:
#             if x in data:
#                 val = data[x]
#                 data[x] = val+x
#             else:
#                 data[x]=x
        
#         keys = sorted(list(data.keys()))
        
#         if 1 in keys:
#             mat = [[0 for col in range(3)] for row in range(len(keys)+1)]
#         else:
#             mat = [[0 for col in range(3)] for row in range(len(keys)+2)]
            
#         counter = 2
#         for x in keys:
#             if x !=1:
#                 mat[counter][0] = x
#                 counter+=1
            
#         mat[1][0] = 1
#         val = 0
#         if 1 in data:
#             val = data[1]
            
#         mat[1][1] = 0
#         mat[1][2] = val
        
        
#         #Looping though the mat to get max value
#         if 1 in keys:
#             keys.remove(1)
        
#         for x in range(2,len(mat)):
#             mat[x][1] = max(mat[x-1][1],mat[x-1][2])
#             mat[x][2] = mat[x-1][1]+data[keys[x-2]]
        
#         return max(mat[-1][1],mat[-1][2])
            
            
            
        
