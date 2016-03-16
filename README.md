# Tuple Packing

Tuple packing allows you to store several integers that can be encoded with different bit size into 64-bit or 32-bit values. Tuple packing support storage of both signed and unsigned integers

Example : you want to store  3-tuples consisting of unsigned integers that 
can be respectively encoded in 3, 3 and 2 bits. 

Let the first tuple contains the following values : [7,5,2], this would be stored as follows into a single byte
```
Positions : 012|345|67
Values    : 111|101|10
```
With the difference that we use either 64-bit or 32-bit as the underlying storage.

##Usage

Creating the 

##Maven

Coming soon

##FAQ

### How does this relate to bit packing ? ###

Bit packing solves a different issue, that is, storing integers of fixed bit length. In bitpacking, integers may span over two
units of the underlying storage. In tuple packing, a single unit (32 or 64-bit integer) stores a single tuple.
If you're interested in bit packing with Java, you may have a look [here](https://github.com/lemire/JavaFastPFOR) and [there](https://github.com/apache/lucene-solr/tree/master/lucene/core/src/java/org/apache/lucene/util/packed).

### Do you intend to support tuple spanning across different units ? ###

This would surely yield a better compression, but this is not a part of the plan (at least yet).





