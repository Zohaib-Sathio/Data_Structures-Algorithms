# Arrays

In computer science, an array is a data structure consisting of a collection of elements, each identified by at least one array index or key. 

An array is stored such that the position of each element can be computed from its index tuple by a mathematical formula.
Types of indexing in an array:

0 (zero-based indexing): The first element of the array is indexed by a subscript of 0.

1 (one-based indexing): The first element of the array is indexed by the subscript of 1.

n (N-based indexing): The base index of an array can be freely chosen. Usually, programming languages allowing n-based indexing also allow negative index values, and other scalar data types like enumerations, or characters may be used as an array index.
Array Data Structure

## What are the different operations on the array?
Arrays allow random access to elements. This makes accessing elements by position faster. Hence operation like searching, insertion, and access becomes really efficient. Array elements can be accessed using the loops.

1. Insertion in Array:

We try to insert a value to a particular array index position, as the array provides random access it can be done easily using the assignment operator.

2. Access elements in Array:

Accessing array elements become extremely important, in order to perform operations on arrays.

Pseudo Code:

// to access array element at index position 2, we simply can write

return arr[ 2 ] ;

## Advantages of using arrays:
 
Arrays allow random access to elements. This makes accessing elements by position faster.
Arrays have better cache locality which makes a pretty big difference in performance.
Arrays represent multiple data items of the same type using a single name.
## Disadvantages of using arrays: 
You can’t change the size i.e. once you have declared the array you can’t change its size because of static memory allocation. Here Insertion(s) and deletion(s) are difficult as the elements are stored in consecutive memory locations and the shifting operation is costly too.

Pseudo Code:

// to insert a value= 10 at index position 2;

arr[ 2 ] = 10;
