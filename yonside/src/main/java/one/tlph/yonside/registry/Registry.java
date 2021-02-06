package one.tlph.yonside.registry;

import java.util.HashMap;

public class Registry<T> {

	private HashMap<String, T> data;
	
	public Registry() {
		data = new HashMap<String, T>();
	}

	
	
}
