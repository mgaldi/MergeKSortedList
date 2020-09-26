**Programmer:** Marco Galdi

**Class:** CS245

**Date:** 25/11/2020

### Functions
The program consists of three main functions.

The function `mergeSortedLists` is responsible for merging two sorted lists `a` and `b`, passed as parameters, into a third sorted list, which is then returned.

The function `splitMerge` is a recursive function that takes as parameters the outer list, the starting index, and the size. The function returns sorted inner lists.

The function `mergeList` is a function that takes as a parameter a list comprised of sorted lists and returns a single sorted list containing all the elements of the sorted lists. The `mergeLists` function makes the first call to the `mergeSplit` function.

### Complexity
The time complexity for the algorithm is `O(nlogm)` where n represent the elements in the array and m represent the inner arrays.
The space complexity for the algorithm will also be `O(nlogm)`.