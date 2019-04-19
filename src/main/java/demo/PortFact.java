package demo;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public final class PortFact implements PortableFactory {

	public static final int ID = 1;
	
	public static final int MYOBJECT_STRING_ID = 1;
	public static final int MYOBJECT_INTEGER_ID = 2;
	
	public static final int MYCOLLECTION_ID = 100;

	@Override
	public Portable create(int id) {
		Portable retval = null;
		switch (id) {
		case MyObjectString.ID: retval = new MyObjectString (); break;
		case MyObjectInteger.ID: retval = new MyObjectInteger (); break;
		case MyCollection.ID: retval = new MyCollection (); break;
		}
		
		return retval;
	}
}
