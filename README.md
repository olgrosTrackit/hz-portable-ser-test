# hz-portable-ser-test
A Test for serialization using the Hazelcast Portable interface


The source contains 2 version (packages) demo and demo2.
The version in "demo" uses an Interface paired with a type argument to specify the type of parameters and returns. The "demo2" version is similar, but does not have type arguments. It uses a plain hierarvy of interface/classes.

The main issue is that the serialization of the list (or any other colletction) within the class MyCollection is dependant on the order of the member of the list as they get serialized by the the writePortable() method.

Therefore it seems to be impossible to serialize collections whose members conform to the same interface but have different implementaions.

<b>[4/20/19]</b> added a third demo version based on the StreamSerializer<T> implementation. This implementation works as expected, but does not have the nice feature of querying and indexing without deserialization of the object.
