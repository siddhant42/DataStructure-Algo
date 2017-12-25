package design;

import java.util.LinkedHashMap;

public class LRUCacheImpl2 {
	private final int capacity;
	private final LinkedHashMap<Object,Object> map = new LinkedHashMap<>();
	public LRUCacheImpl2(int capacity) {
		this.capacity = capacity;
	}
	public Object get(Object key) {
		Object v = map.get(key);
		if(v==null) return null;
		map.remove(key);
		map.put(key, v);
		return v;
	}
	public void set(Object key,Object value) {
		if(map.containsKey(key)) {
			map.remove(key);
		}
		if(map.size()>=capacity){
			Object k = map.keySet().iterator().next();
			map.remove(k);
		}
		map.put(key, value);
	}
}
