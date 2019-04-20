package demo3;

public class MyObjectString extends MyObject<String> {
	
	public static final int ID = PortFact.MYOBJECT_STRING_ID;

	String value;
	
	@Override
	public String myMethod(String val) {
		value = val;
		return val;
	}
}
