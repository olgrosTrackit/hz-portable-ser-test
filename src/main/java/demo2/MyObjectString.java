package demo2;

import java.io.IOException;

import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

public class MyObjectString extends MyObject {
	
	public static final int ID = PortFact.MYOBJECT_STRING_ID;

	String value;
	
	@Override
	public Object myMethod(Object val) {
		// missing null check & type-validation
		value = (String)val;
		return val;
	}

	@Override
	public int getClassId() {
		return ID;
	}

	@Override
	public void readPortable(PortableReader reader) throws IOException {
		value = reader.readUTF("value");
	}

	@Override
	public void writePortable(PortableWriter writer) throws IOException {
		writer.writeUTF("value", value);
	}
	
	

}
