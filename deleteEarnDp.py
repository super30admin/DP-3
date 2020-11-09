# As taught in class, I followed the skip and take approach and DP to solve this problem.
# time Complexity: O(n)
# Space Complexity: O(n)
# Problems faced: Getting max deptth reached while implementing the recursive solution.
def deleteEarn(arr):
    if  (arr is None or len(arr)==0):
        return 0
    maxi = -99999
    for num in arr:
        maxi = max(maxi,num)
    nmax = maxi+1
    arr1 = [0]*nmax
    for num in arr:
        arr1[num] = arr1[num] + num
    skip = 0
    take = arr1[0]
    for i in range(len(arr1)):
        temp = skip
        skip = max(skip,take)
        take = temp + arr[i]
    max(skip,take)

arr = [2,2,3,3,3,4]
deleteEarn(arr)