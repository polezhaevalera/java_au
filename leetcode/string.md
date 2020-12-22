# String

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)

## Group Anagrams

https://leetcode.com/problems/group-anagrams/


## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/
```java
public static boolean isPalindrome(String s) {

    String beautyS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int start = 0;
    int end = beautyS.length() - 1;

    while (start < end) {
        if (beautyS.charAt(start) != beautyS.charAt(end)) {
            return false;
        }
        end--;
        start++;
    }

    return true;
}
```


## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/


## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/
