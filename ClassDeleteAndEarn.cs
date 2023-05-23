namespace LeetCodeSubmission.DP3;

public class ClassDeleteAndEarn
{
    public Dictionary<int, int> numsMaps;
    public int Memorization2D(int[] nums)
    {
        int[,] memorization2D = new int[nums.GetLength(0), 3];
        int rows = nums.GetLength(0);
        
        for (int r = 0; r < rows; r++)
        {
            if (r == 0)
            {
                memorization2D[r, 0] = 0;
                memorization2D[r, 1] = nums[r];
            }
            else if (r == 1)
            {
                memorization2D[r, 0] = memorization2D[r - 1,2]; // 1-step back
                memorization2D[r, 1] = nums[r];
            }
            else
            {
                memorization2D[r, 0] = memorization2D[r - 1,2]; // 1-step back
                memorization2D[r, 1] = nums[r]+memorization2D[r - 2,2]; // 2-step back
            }

            memorization2D[r, 2] = Math.Max(memorization2D[r, 0],memorization2D[r, 1]);
        }

        return memorization2D[rows - 1, 2];
    }
    public int DeleteAndEarn(int[] nums)
    {
        // initialize a dictionary
        this.numsMaps = new Dictionary<int, int>();
        int maxVal = Int32.MinValue;

        // create a key-value pair dictionary
        for (int i = 0; i < nums.GetLength(0); i++)
        {
            maxVal = Math.Max(maxVal, nums[i]);
            
            if (numsMaps.ContainsKey(nums[i]) && numsMaps.TryGetValue(nums[i], out int count))
            {
                // key already exist
                numsMaps[nums[i]] = count + 1;
            }
            else
            {
                numsMaps.Add(nums[i],1);    
            }
        }
        
        // create an array of maxValue-1 and store the product in nums[i]-1 index
        int[] product = new int[maxVal];
        foreach (KeyValuePair<int,int> pair in this.numsMaps)
        {
            int idx = pair.Key - 1;
            product[idx] = pair.Key * pair.Value;
        }
        
        //Console.WriteLine("products-array= "+string.Join(",",product));
        
        return this.Memorization2D(product);
    }
}