# time complexity : O(n)
# space complexity : O(n) for array
def delete_and_earn(nums):
    max_ele = max(nums)
    arr = [0] * (max_ele+1)
    for num in nums:
        arr[num] += num

    prev = arr[0]
    curr = max(arr[0], arr[1])

    for i in range(2, len(arr)):
        temp = curr
        curr = max(curr, prev+arr[i])
        prev = temp
    
    return curr
    
if __name__ == "__main__":
    nums = [2,2,3,3,3,4]
    print(delete_and_earn(nums))