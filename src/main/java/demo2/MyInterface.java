package demo2;

import com.hazelcast.nio.serialization.Portable;

public interface MyInterface extends Portable {

	public Object myMethod (Object val);
	
}
