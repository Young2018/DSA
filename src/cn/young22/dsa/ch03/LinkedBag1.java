package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;
/**
 *  这个版本的LinkedBag1类在LinkedBag类的基础上实现了:
 *  	构造方法
 *  	isEmpty()方法
 *  	getFrequencyOf()方法
 */
public class LinkedBag1<T> implements BagInterface<T>{
	
	private class Node {
		private T 	data;	// Entry in bag
		private Node next; 	// Link to the next node
		
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode){
			data = dataPortion;
			next = nextNode;
		}
	}
	
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedBag1(){
		firstNode = null;
		numberOfEntries = 0;
	}
	
	@Override
	public int getCurrentSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;	// make new node reference rest of chain
									// (firstNode is null if chain is empty)
									// New node is at beginning of chain
		
		firstNode = newNode;
		numberOfEntries++;
		
		return true;
	}// end add

	@Override
	public T remove() {
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		return false;
	}

	@Override
	public boolean removeAll(T anEntry) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		return numberOfEntries;
	}

	@Override
	public boolean contains(T anEntry) {
		return false;
	}

	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // unchecked cast
		
		int index = 0;
		Node currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
	}
	

}