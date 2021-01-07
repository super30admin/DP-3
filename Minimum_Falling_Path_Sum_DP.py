# Created by Aashish Adhikari at 4:34 PM 1/6/2021
'''
Time Complexity:
O(m * n) where m and n represent the input array dimension.

Space Complexity:
O(1)
'''

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """

        for idx in range(1, len(A)):

            for idxx in range(0, len(A[0])):

                # left
                if idxx != 0:
                    from_left = A[idx-1][idxx-1]
                else:
                    from_left = 999999

                #right
                if idxx != len(A[0]) - 1:
                    from_right = A[idx-1][idxx+1]
                else:
                    from_right = 999999

                from_mid = A[idx-1][idxx]

                A[idx][idxx] = min(from_left, from_mid, from_right) + A[idx][idxx]


        return min(A[-1])