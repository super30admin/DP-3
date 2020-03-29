//space - constant - for any input the size of hashet and result[] is atmost 366
//time - O(max(length of days[], largest day in days[])) which can be O(366) at worst so constant

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0)
        {
            return 0;
        }
        
        //dependent only days[] and costs[] remains same 
        //so dp array
        //have travel days in a set for constant lookup later
        
        HashSet<Integer> travelDays = new HashSet<Integer>();
        int max_day = Integer.MIN_VALUE;
        for(int day : days)
        {
            travelDays.add(day);
            max_day = Math.max(day, max_day);
        }
        
        int[] result = new int[max_day + 1];
        result[0] = 0; //cost to travel on 0th day is 0
        
        for(int i = 1; i < result.length; i++)
        {
            if(travelDays.contains(i))
            {
                //eg on day 8 i.e i = 8
                //dailyCost = result[7] + costs[0]
                //wweklyCost = result[1] + costs[1]
                //monthlyCost = result[0] + costs[2]
                int daily = Math.max(0, i - 1);
                int weekly = Math.max(0, i - 7);
                int monthly = Math.max(0, i - 30);
                
                int dailyCost = costs[0] + result[daily];
                int weeklyCost = costs[1] + result[weekly];
                int monthlyCost = costs[2] + result[monthly];
                
                result[i] = Math.min(dailyCost, Math.min(weeklyCost, monthlyCost));
            }
            else
            {
                result[i] = result[i - 1]; // if you are not travelling day i then money spent is same as amount till day i - 1
            }
        }
        
        return result[max_day];
    }
}
