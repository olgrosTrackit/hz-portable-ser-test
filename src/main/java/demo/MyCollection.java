package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

public class MyCollection implements Portable {
	
	public static final int ID = PortFact.MYCOLLECTION_ID;

	private List<MyInterface<?>> members = new ArrayList<MyInterface<?>> ();
	
	public void addMember (MyInterface<?> member) {
		members.add(member);
	}
	
	@Override
	public String toString () {
		return members.toString();
	}
	
	@Override
	public int getClassId() {
		return ID;
	}

	@Override
	public int getFactoryId() {
		return PortFact.ID;
	}

	@Override
	public void readPortable(PortableReader reader) throws IOException {
		int listSize = reader.readInt("size");
		for (int i = 0; i < listSize; ++i) {
			MyInterface<?> mem = reader.readPortable("member." + i);
			members.add(mem);
		}
	}

	@Override
	public void writePortable(PortableWriter writer) throws IOException {
		writer.writeInt ("size", members.size());
		for (int i = 0; i < members.size(); ++i) {
			writer.writePortable("member."+i, members.get(i));
		}

	}

}
