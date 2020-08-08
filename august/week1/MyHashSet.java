package august.week1;

import java.util.ArrayList;
import java.util.List;

class MapNode<K, V> {
	K key;
	V value;
	MapNode<K, V> next;

	public MapNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

}

class MyHashSet<K, V> {

	List<MapNode<K, V>> buckets;

	/** Initialize your data structure here. */
	public MyHashSet() {
		buckets = new ArrayList<>();
	}

	public void add(int key) {

	}

	public void remove(int key) {

	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
