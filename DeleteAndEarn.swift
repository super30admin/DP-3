//
//  DeleteAndEarn.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/5/26.
//


/*
 We can create hash map for delete and earn problem. Can keep the count for a particular key.
 Many situations where keys of the hashmap are not sorted. If we sort the keys then we will add O(n log n) time complexity.
 Once we learned advanced data structes, then mind will ask to use Heap or treeMap (orderedMap) - binary search tree. They are not hashing based data strtures.
 In BST - time complexity - O(log n) for insertion and deletion
 for n elements - O(n log n) for sorting the keys only.
 solution 3 - hash map using priority queue. In which we are getting priority of the keys according to priority queue. Priority queu also O(log n). equivalent to heap sort. again O(n log n)
 
 all these can be mitigated by bucket sort. FAANMG favorite. In real world, the keys of hashmap will be in certain range
 minimum - 1, maxiumum - 8. Just iterate over this range. Don't sort the keys. iterations are done in ordered manner.
 
 let's do the same thing on parent data structure of hash map i.e. array.
 */
/*
 If we take exhaustive approach, the choose 1. delete 2 2. or not delete 2.
 We have multiple 2's. We don't know which indexed 2 should be deleted. It will be cumbersome initially. Additional complexity.
 
 In 0,1 problem, we always used to go ahead. Here, we would have to take in consider previous indexes as well. Since there are multiple count of the same number.
 This complexity of the data can be removed using -> if we take things in order, 0,1,2,3,.... and take the the value add for each no
 Number are between 0 and 8. Create an array.0,1,2,3,4 5 6 7 8
 Preprocessign the data.
 In some complications - we can use hash map. Under the hood, hash map is an array
 */


class DeleteAndEarn {
    
    
    init() {
        //input - [2, 1, 8,1,2,4,4,6,4,4,7,3,3,7,7]
        let maximumPointsEarned = deleteAndEarn()
        print("maximum points earned *** \(maximumPointsEarned)")
    }
    
    /*
     time complexity - O(m+n)
     Space complexity - O(m)
     */
    func deleteAndEarn() -> Int {
        
        let input = [2, 1, 8,1,2,4,4,6,4,4,7,3,3,7,7]
        
        //First take the range of the numbers in array. Create those many indices in array. Keep the sum of each no in array. Thenwe can choose elements which provides us the maximum amount.
        //Prerocess the data
        var maximumValue = Int.min
        for number in input { //O(n)
            maximumValue = max(number, maximumValue)
        }
        var arr = Array(repeating: -1, count: maximumValue + 1)
        for number in input {
            arr[number] = arr[number] + number
        }
        
        //house robber problem
        var prev = arr[0]
        var curr = max(arr[0], arr[1]) //arr[0] will always be 0, so just keep arr[1]
        
        for i in 2..<arr.count - 1 { //O(max(n)) -> m
            let temp = curr
            curr = max(curr, arr[i] + prev)
            prev = temp
        }
        
        return curr
    }
}
