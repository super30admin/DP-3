class Solution(object):
    nums = []
    solutions = {}
    
    def str_hash(self,d):
        return str(d)
    
    def put(self, d,c,total) :
        h_d = self.str_hash(d)
        h_c = self.str_hash(c)
        if not self.solutions.get(h_c) :
            self.solutions[h_c] = {}
        self.solutions[h_c][h_d] = total
    
    def get(self,d,c):
        h_d = self.str_hash(d)
        h_c = self.str_hash(c)
        if not self.solutions.get(h_c) :
            return None
        return self.solutions[h_c].get(h_d)
    
    def delete(self,d,i):
        e = self.nums[i]
        deleted = []
        for j in range(len(self.nums)):
            if (self.nums[j] == (e +1)) or (self.nums[j] == (e - 1)) :
                if  j not in d :
                    deleted.append(j) 
                    d.add(j)
        return deleted
    
    def helper(self,d,c) :
        if self.get(d,c):
            return self.get(d,c)
        
        max_total = -1
        for i in range(len(self.nums)):
            if (i not in d) and (i not in c) :
                # choose i
                c.add(i)
                deleted = self.delete(d,i)
                r = self.helper(d,c)
                c.remove(i)
                for di in deleted :
                    d.remove(di)
                if max_total < r :
                    max_total = r
        
        # exit condition nothing left to search
        total = sum([self.nums[i] for i in c] ) if max_total == -1 else max_total
        self.put(d,c,total)
        return total
    
    
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums = nums
        self.solutions = {}
        return self.helper(set([]),set([]))

