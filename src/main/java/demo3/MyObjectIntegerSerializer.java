package demo3;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class MyObjectIntegerSerializer implements StreamSerializer<MyObjectInteger> {

	@Override
	public int getTypeId() {
		return PortFact.MYOBJECT_INTEGER_ID;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(ObjectDataOutput out, MyObjectInteger object) throws IOException {
		out.writeInt(object.value);
	}

	@Override
	public MyObjectInteger read(ObjectDataInput in) throws IOException {
		MyObjectInteger retval = new MyObjectInteger();
		
		retval.value = in.readInt();
		
		return retval;
	}

}
