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
```java
public static String longestPalindrome(String s) {
    int sLength = s.length();
    if (1 >= sLength) {
        return s;
    }

    String result = "";
    for (int i = 0; i < sLength; i++) {
        String odd = readPalFromCenter(s, i, i);
        String even = readPalFromCenter(s, i, i + 1);
           
        if (odd.length() > result.length()) {
            result = odd;
        }
        if (even.length() > result.length()) {
            result = even;
        }
    }
    return result;
}


private static String readPalFromCenter(String s, int left, int right) {
    int length = s.length();
    while (0 <= left) {
        if (!((right < length) && (s.charAt(left) == s.charAt(right)))) {
            break;
        }
        left--;
        right++;
    }
    return s.substring(left + 1, right);
}
```


## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/
