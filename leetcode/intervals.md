# Intervals
+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge-Intervals](#merge-intervals)
+ [Insert-Interval](#insert-interval)

## Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/

## Merge Intervals
https://leetcode.com/problems/merge-intervals/

## Insert Interval
https://leetcode.com/problems/insert-interval/

```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> out = new ArrayList<>(1);
    int oldLength = intervals.length;
    int i = 0;

    while((i < oldLength) && (intervals[i][1] < newInterval[0])){
        out.add(intervals[i]);
        i++;
    }
    while((i < oldLength) && (intervals[i][0] <= newInterval[1])){
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    out.add(newInterval);

    while(i < oldLength){
        out.add(intervals[i]);
        i++;
    }

    int outSize = out.size();
    return out.toArray(new int[outSize][2]);
}

