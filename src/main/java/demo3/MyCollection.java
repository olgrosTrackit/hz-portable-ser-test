package demo3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

public class MyCollection {
	
	public static final int ID = PortFact.MYCOLLECTION_ID;

	protected List<MyInterface<?>> members = new ArrayList<MyInterface<?>> ();
	
	public void addMember (MyInterface<?> member) {
		members.add(member);
	}
	
	@Override
	public String toString () {
		return members.toString();
	}
}
