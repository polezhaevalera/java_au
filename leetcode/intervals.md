# Intervals

+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interva](#insert-interval)

## Non-overlapping Intervals

https://leetcode.com/problems/non-overlapping-intervals/

```java
public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if(intervals.length == 0 || intervals[0].length == 0)
            return res;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                res++;
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return res;
}
```

## Merge Intervals

https://leetcode.com/problems/merge-intervals/


## Insert Interval

https://leetcode.com/problems/insert-interval/
