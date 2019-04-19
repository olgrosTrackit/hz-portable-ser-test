package demo2;

import java.io.IOException;

import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

public class MyObjectInteger extends MyObject {

	public static final int ID = PortFact.MYOBJECT_INTEGER_ID;
	
	int value;
	
	@Override
	public Object myMethod(Object val) {
		// missing null check & type-validation
		value = (Integer)val;
		return val;
	}

	@Override
	public int getClassId() {
		return ID;
	}

	@Override
	public void readPortable(PortableReader reader) throws IOException {
		value = reader.readInt("value");
	}

	@Override
	public void writePortable(PortableWriter writer) throws IOException {
		writer.writeInt("value", value);
	}

}
