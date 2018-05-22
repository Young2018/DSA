package cn.young22.dsa.ch01;
/**
 * 包的具体实现代码框架
 * 类要实现BagInterface<T>的方法
 * */
public class Bag<T> implements BagInterface<T>{

	@Override
	public int getCurrentSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		return false;
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		return false;
	}

	@Override
	public T[] toArray() {
		return null;
	}

	@Override
	public boolean removeAll(T anEntry) {
		return false;
	}

}