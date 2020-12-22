# Arrays
+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
```java
public int[] sortedSquares(int[] A) {
    int[] res = new int[A.length];
    int k=A.length-1;
    int start = 0;
    int end = A.length-1;
    while(start<=end){
        int startSq = A[start]*A[start];
        int endSq = A[end]*A[end];
        if(startSq>endSq){
            start++;
            res[k--] = startSq;
        }else{
            end--;
            res[k--] = endSq;
        }
    }
    return res;
}
```
