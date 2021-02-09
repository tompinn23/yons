package one.tlph.yonside.registry;

import java.util.HashMap;

public class Registry<T> {

	private HashMap<String, T> data;
	
	public Registry() {
		data = new HashMap<String, T>();
	}

	public T get(String name) {
		return data.get(name);
	}

	public void set(String name, T data) {
		this.data.put(name, data);
	}



	
}
