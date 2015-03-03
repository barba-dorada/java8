# Chapter 2. Exercises
---

1. Write a parallel version of the  for loop in Section 2.1, “From Iteration to
Stream Operations,” on page 22. Obtain the number of processors. Make that
many separate threads, each working on a segment of the list, and total up
the results as they come in. (You don’t want the threads to update a single
counter. Why?)

2. Verify that asking for the first five long words does not call the filter method
once the fifth long word has been found. Simply log each method call.

3. Measure the difference when counting long words with a  parallelStream instead
of a  stream . Call  System.currentTimeMillis before and after the call, and print the
difference. Switch to a larger document (such as War and Peace) if you have
a fast computer.

4. Suppose you have an array  int[] values = { 1, 4, 9, 16 } . What is
Stream.of(values) ? How do you get a stream of  int instead?

5. Using  Stream.iterate , make an infinite stream of random numbers—not by
calling  Math.random but by directly implementing a linear congruential generator.
In such a generator, you start with x 0 = seed and then produce x n + 1 =
(a x n + c)  % m, for appropriate values of a, c, and m. You should implement a
method with parameters  a ,  c ,  m , and  seed that yields a  Stream<Long> . Try out a =
25214903917, c = 11, and m = 2 48 .

6. The  characterStream method in Section 2.3, “The  filter ,  map , and  flatMap Methods,”
on page 25, was a bit clumsy, first filling an array list and then turning it
into a stream. Write a stream-based one-liner instead. One approach is to
make a stream of integers from  0 to  s.length() - 1 and map that with the
s::charAt method reference.

7. Your manager asks you to write a method  public static <T> boolean
isFinite(Stream<T> stream) . Why isn’t that such a good idea? Go ahead and
write it anyway.

8. Write a method  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
that alternates elements from the streams  first and  second , stopping when
one of them runs out of elements.

9. Join all elements in a  Stream<ArrayList<T>> to one  ArrayList<T> . Show how to do
this with the three forms of  reduce .
10. Write a call to  reduce that can be used to compute the average of a  Stream<Double> .
Why can’t you simply compute the sum and divide by  count() ?

11. It should be possible to concurrently collect stream results in a single  ArrayList ,
instead of merging multiple array lists, provided it has been constructed with
the stream’s size, since concurrent  set operations at disjoint positions
are threadsafe. How can you achieve that?

12. Count all short words in a parallel  Stream<String> , as described in Section 2.13,
“Parallel Streams,” on page 40, by updating an array of  AtomicInteger . Use
the atomic getAndIncrement method to safely increment each counter.

13. Repeat the preceding exercise, but filter out the short strings and use the
collect method with  Collectors.groupingBy and  Collectors.counting