My ‘suggest’ algorithm aims to make a list of words that are as similar as possible to a target word. It starts by checking if the word is already in the
dictionary, if it is, it will return a List of just that word. If it is not in the dictionary, the algorithm will try to find similar words. It will first 
look for words that share the same common prefix as the target word and gradually reduce the length of the substring of the prefix which will increase the 
search space to find more suggestions. For each prefix, the algorithm calls ‘suggestHelper’ which does a depth-first-search of the tree. The ‘suggestHelper’ 
method goes as deep as possible into the tree branches and visits all nodes that share the same prefix as the target. If it reaches the end of a branch or did 
not find enough suggestions, it will backtrack to the previous node and search other branches. This process repeats until there are enough suggestions.