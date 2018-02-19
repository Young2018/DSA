package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

/** 包的链式实现的代码框架
 * 	仅实现了add()和toArray()方法
 * */

public class LinkedBag<T> implements BagInterface<T>{
	/** 包中的节点类*/
	private class Node {
		private T 	data;	// Entry in bag
		private Node next; 	// Link to the next node
		
		/** 节点的构造方法，将客户传入的dataPortion赋值给节点，next赋值为null*/
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		/** 节点的构造方法，将客户端传入的dataPortion和nextNode分别赋值给data和next*/
		private Node(T dataPortion, Node nextNode){
			data = dataPortion;
			next = nextNode;
		}
	}
	//头结点
	private Node firstNode;
	//包中的节点个数
	private int numberOfEntries;
	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
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
