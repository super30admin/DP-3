# Using a array of size equal to the size of a row in the matrix
# This is for first function
# Time complexity : O(mn) where n is the size of the matrix and m is the size of the row in the matrix
# Space complexity : Its constant. O(2m) where m is the size of the row in the matrix
# This is for the second function
# Time complexity : O(mn) where n is the size of the matrix and m is the size of the row in the matrix
# Space complexity : O(mn) where n is the size of the matrix and m is the size of the row in the matrix
# Both the solutions worked on leetcode

class Problem2:
	def FindMinPath1(self, arr):
		dp_arr = arr[0][:]
		for i in range(1, len(arr)):
			temp = dp_arr[:]
			for j in range(len(arr[0])):
				if j == 0:
					dp_arr[j] = min(temp[j], temp[j + 1]) + arr[i][j]
				elif j == len(arr[0]) - 1:
					dp_arr[j] = min(temp[j], temp[j - 1]) + arr[i][j]
				else:
					dp_arr[j] = min(temp[j], temp[j + 1], temp[j - 1]) + arr[i][j]
		return min(dp_arr)

	def FindMinPath2(self, arr):
		nrows = len(arr)
		ncols = len(arr[0])
		dp_arr = [[None for i in range(ncols)] for j in range(nrows)]
		dp_arr[0] = arr[0][:]
		for i in range(1, nrows):
			for j in range(ncols):
				if j == 0:
					dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1]) + arr[i][j]
				elif j == len(arr[0]) - 1:
					dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j - 1]) + arr[i][j]
				else:
					dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1], dp_arr[i - 1][j - 1]) + arr[i][j]
		return min(dp_arr[-1])

if __name__ == '__main__':
	fmp = Problem2()
	#print(fmp.FindMinPath([[1,2,3],[4,5,6],[7,8,9]]))
	print(fmp.FindMinPath1([[-19,57],[-40,-5]]))
	print(fmp.FindMinPath2([[-19,57],[-40,-5]]))
	print(fmp.FindMinPath2([[1,2,3],[4,5,6],[7,8,9]]))