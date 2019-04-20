package demo3;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class MyCollectionSerializer implements StreamSerializer<MyCollection> {

	@Override
	public int getTypeId() {
		return PortFact.MYCOLLECTION_ID;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void write(ObjectDataOutput out, MyCollection object) throws IOException {
		out.writeInt (object.members.size());
		for (int i = 0; i < object.members.size(); ++i) {
			out.writeObject(object.members.get(i));
		}
	}

	@Override
	public MyCollection read(ObjectDataInput in) throws IOException {
		MyCollection retval = new MyCollection();
		int listSize = in.readInt();
		for (int i = 0; i < listSize; ++i) {
			MyInterface<?> mem = in.readObject();
			retval.members.add(mem);
		}
		return retval;
	}

}
