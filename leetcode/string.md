# String

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)

## Group Anagrams

https://leetcode.com/problems/group-anagrams/

```java

public LinkedList groupAnagrams(String[] strings) {

    Map<String, List<String>> map = new HashMap(1);

    for(String s : strings){
        char [] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String temp = new String(charArray);

        if (!map.containsKey(temp)) {
            map.put(temp, new LinkedList());
            }
        List<String> stringList = map.get(temp);
        stringList.add(s);
    }

    return new LinkedList(map.values());
}
```

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/


## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/


## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/
