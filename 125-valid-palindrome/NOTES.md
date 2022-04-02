Take two pointers over given string, say `start` and `end`
1. while char at `start` is not in alphanumeric range, do `start`++
2. Similarly while char at `end` is not in alphanumeric range, do `end`--
3. If both char are alphanumeric but not equal, return false
4. start++, end--
Numbers ascii range = 48 to 57
Alphabets A-Z = 65 to 90
Alphabets a-z = 97 to 122