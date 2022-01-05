  # Time Complexity - O(n)
  # Space Complexity - O(n)
  
 def deleteAndEarn(nums): 
    hmap={} 
    a=max(nums) 
    for i in nums: 
        if i in hmap: 
            hmap[i]+=i 
        else:
            hmap[i]=i 
    for i in range(a+1): 
        if i not in hmap: 
            hmap[i]=0 
            b=[[0]*2 for _ in range(a+1)]
    for i in range(1,a+1):
        b[i][0]=max(b[i-1][0],b[i-1][1])
        b[i][1]=b[i-1][0]+hmap[i]
    return max(b[a][0],b[a][1])
