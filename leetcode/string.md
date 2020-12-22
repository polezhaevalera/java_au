# String

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)

## Group Anagrams

https://leetcode.com/problems/group-anagrams/


## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/


## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/


## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/
```java
int ans = 0;
public int countSubstrings(String s) {
    if((null == s) || (1 > s.length())) {
        return 0;
    }
    char[] charArray = s.toCharArray();
    int n = charArray.length;

    for(int i = 0; i < n; i++){
        fromCentre(charArray, n, i, i);
        fromCentre(charArray, n, i, i + 1);
    }
    return ans;
}

void fromCentre(char[]chars, int len, int left, int right) {
    while((0 <= left) && (right < len)){
        if(chars[left]!=chars[right]) {
            return;
        }
        right++;
        left--;
        ans++;
    }
}
```
