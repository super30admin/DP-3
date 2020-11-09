# Time Complexity: O(n)
#Space Complexity: O(n*m)
def pathSum(arr):
    while len(arr) >=2:
        row = arr.pop()
        for i in range(len(row)):
            arr[-1][1] = arr[-1][1] + min(row[max(0,i-1): min(len(row), i+2)])
    return arr[0]

arr = [[1,2,3],[4,5,6],[7,8,9]]
pathSum(arr)