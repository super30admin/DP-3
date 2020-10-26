// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
find max element
make an array till max element and add sum of each corresponding value to that index
then it becomes a coin
*/
package main

import "fmt"

func deleteAndEarn(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	max := -9999
	for _, v := range nums {
		if v > max {
			max = v
		}
	}

	var p = make([]int, max + 1)
	for _, v := range nums {
		p[v] += v
	}

	skip := 0
	take := p[0]
	for i:=0; i<len(p);i++ {
		temp := skip
		if take > skip {
			skip = take
		}
		take = temp + p[i]
	}
	if skip > take {
		return skip
	}
	return take
}

func MainDeleteEarn() {
	fmt.Println(deleteAndEarn([]int {3, 4, 2})) //expected 6
}
