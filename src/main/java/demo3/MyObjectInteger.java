package demo3;


public class MyObjectInteger extends MyObject<Integer> {

	public static final int ID = PortFact.MYOBJECT_INTEGER_ID;
	
	int value;
	
	@Override
	public Integer myMethod(Integer val) {
		return val;
	}
}
