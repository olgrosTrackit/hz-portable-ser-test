package demo;

public abstract class MyObject<T> implements MyInterface<T>{

	public int getFactoryId () {
		return PortFact.ID;
	}
	
	
}
