package demo;

import com.hazelcast.nio.serialization.Portable;

public interface MyInterface<T> extends Portable {

	public T myMethod (T val);
	
}
