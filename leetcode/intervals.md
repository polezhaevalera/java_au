# Intervals

+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interva](#insert-interval)

## Non-overlapping Intervals

https://leetcode.com/problems/non-overlapping-intervals/


## Merge Intervals

https://leetcode.com/problems/merge-intervals/
```java
public int[][] merge(int[][] intervals) {
    if(intervals == null || intervals.length == 0)
        return new int[0][0];
       
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
	
    int start = intervals[0][0];
    int end = Integer.MAX_VALUE;
       
    List<int[]> result = new ArrayList<>();
       
   for(int[] interval: intervals){
        if(interval[0] <= end)
            end = (end == Integer.MAX_VALUE) ? interval[1]: Math.max(end,interval[1]);
        else{
            result.add(new int[]{start,end});
            start = interval[0];
            end = interval[1];
        }
    }
    result.add(new int[]{start,end});
        

    int[][] res = new int[result.size()][];
    for(int i = 0; i < result.size(); i++)
        res[i] = result.get(i);
       
    return res;
}
```

## Insert Interval

https://leetcode.com/problems/insert-interval/
