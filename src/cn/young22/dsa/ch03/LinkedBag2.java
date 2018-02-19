package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

public class LinkedBag2<T> implements BagInterface<T>{
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
	
	public LinkedBag2(){
		firstNode = null;
		numberOfEntries = 0;
	}
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
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

	//删除链包中的第一个节点
	@Override
	public T remove() {
		T result = null;
		if(firstNode != null){
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		return result;
	}
	
	/** 锁定给定元素在包中的位置
	 * 如果查找成功,返回一个指向这个节点的索引
	 * 否则，返回null
	 * */
	private Node getReferenceTo(T anEntry){
		boolean found = false;
		
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)){
			if(anEntry.equals(currentNode.data)){
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}		
		return currentNode;		
	}

	//如果可行的话，删除制定元素的第一次在链表中的出现
	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		
		if(nodeN != null){
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}
		return result;
	}

	@Override
	public boolean removeAll(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		while(!isEmpty()){
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		
		while((loopCounter < numberOfEntries) && (currentNode != null)){
			if(anEntry.equals(currentNode.data)){
				frequency++;
			}
			
			loopCounter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)){
			if(anEntry.equals(currentNode.data)){
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}
		return found;
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
