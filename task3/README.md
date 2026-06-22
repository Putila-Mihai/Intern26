**Pentru a exersa un pic Java Collections:**

link for learning: https://java8.info/collections/collectionovw.html

1. Create an immutable list of names (`String` type). Populate it with five names and print the first letter from each name.

2. What changes are necessary for the above list in order to allow the addition of new elements and to associate a nickname with each name? Please implement these changes in a distinct method.
   > **Ex:** `listBefore = ["Andreea", "Adrian"]` ➔ `listAfter = ["Andreea-Dea", "Adrian-Adi"]`

3. Having a list of colours = `["red", "yellow", "blue", "pink", "purple"]`, write a method that does the following:
    * Converts all colours to uppercase.
    * Replaces the `"red"` colour with `"orange"`.
    * Displays the element from a given index.
    * Displays the first element in the list.
    * Using utility classes, sorts the list descending.
    * Removes the last element from the sorted list.
    * Extracts half of the list, reverses the first half, and prints the resulting list.

4. Write a Java program to iterate through all elements in a list with no duplicates and print each one.

5. Write a Java program to test if a hash set is empty or not. If it’s not empty, then display the number of elements. *(The hash set can be defined directly in the program, no need to read it/create it from the console).*

6. Write a Java program to convert an array to a hash set.                  

7. Given a list of words representing animals, group them by their length:
    * Populate the collection needed.
    * Display the elements.
    * Display the size of the chosen collection, the list of lengths, and the words, all separately (e.g., `size = 2`, `lengthList = {3, 4}`, `words = {"dog", "fish"}`).
    * Retrieve a word for a given length; if the length does not exist, return `"unknown"`.
    * Check if length `7` is missing and, if so, set its value (using Java 8 Map-related features for that).
    * Check if length `3` is present and, if so, add `"cat"` to it.

8. PitchTech acquires tickets for an America business trip, to be shared by employees. 
Create and display a waiting list for employees, where the names should appear in the order of their review points.