* Prepare a frequency-map of each character, And a isIncluded boolean-array that tells if a char has been included in our answer.
* Prepare a stack that will finally stores all characters of result string
*  Iterate over each character and keep updating frequency-map. If isIncluded[character] is already true, then we can skip this character.
*  Since we have to include a character only once AND have to maintain lexicographic order in our answer as well,
a. Before including a character in stack, check if isIncluded[character] is already true
b. If character at top of stack is greater than current character AND the character at top of stack is still left in input string, then we will remove this character from top and make isIncluded[characterAtTop] = false because we can include this character at later point