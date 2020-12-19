# Intervals
+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge-Intervals](#merge-intervals)
+ [Insert-Interval](#insert-interval)

## Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/
```java
 public int eraseOverlapIntervals(int[][] intervals) {
    if(intervals == null || intervals.length==0)
        return 0;
    Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
  
       
    int i = 1;
    int count = 0;
    int prev[] = intervals[0];
    
    while(i<intervals.length){
        int []curr = intervals[i];
        if(curr[0]>=prev[1]){
           
            prev = curr;
        }
        else{
            prev[1] = Math.min(prev[1],curr[1]);
            count++;
                
        }
        i++;
    }
   return count;
}
```

## Merge Intervals
https://leetcode.com/problems/merge-intervals/

## Insert Interval
https://leetcode.com/problems/insert-interval/
