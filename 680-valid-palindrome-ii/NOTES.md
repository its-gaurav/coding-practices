Given string s can be palindrome by deleting at most one character only when:
1. The string itself is a palindrome OR
2. If s.charAt(i)!=s.charAt(j), then s can be palindrome by deleting
one character (either charAt(i) OR charAt(j)) only when s[i,j-1] OR s[i+1,j] is a palindrome.
​
**Finding a palindrome**
/*
Take two pointers start and end
Compare characters at `start` and `end` and keep updating the pointers
If at any point two characters are not equal, return false
*/
​
​