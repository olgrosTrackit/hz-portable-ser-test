package demo3;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class MyObjectStringSerializer implements StreamSerializer<MyObjectString> {

	@Override
	public int getTypeId() {
		return PortFact.MYOBJECT_STRING_ID;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(ObjectDataOutput out, MyObjectString object) throws IOException {
		out.writeUTF(object.value);
	}

	@Override
	public MyObjectString read(ObjectDataInput in) throws IOException {
		MyObjectString retval = new MyObjectString();
		
		retval.value = in.readUTF();
		
		return retval;
	}

}
