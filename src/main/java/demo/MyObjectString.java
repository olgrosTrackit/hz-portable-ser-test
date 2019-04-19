package demo;

import java.io.IOException;

import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

public class MyObjectString extends MyObject<String> {
	
	public static final int ID = PortFact.MYOBJECT_STRING_ID;

	String value;
	
	@Override
	public String myMethod(String val) {
		value = val;
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
