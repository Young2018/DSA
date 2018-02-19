package cn.young22.dsa.ch06;

import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;

public class LinkedStack<T> implements StackInterface<T>{

	private Node topNode;	// Reference the first node in the chain
	
	public LinkedStack(){
		topNode = null;
	}// end of default constructor
	
	
	private class Node{
		private T 	data; //Entry in stack
		private Node next; //link to the next node
		
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node linkPortion){
			data = dataPortion;
			next = linkPortion;
		}
		
		private T getData(){
			return data;
		}
		
		private void setData(T newData){
			data = newData;
		}
		
		private Node getNextNode(){
			return next;
		}
		
		private void setNextNode(Node nextNode){
			next = nextNode;
		}
	}//end Node
	
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	@Override
	public T pop() {
		T top = peek();
		
		assert (topNode != null);
		topNode = topNode.getNextNode();
		
		return top;
	}

	@Override
	public T peek() {
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return topNode.getData();
		}	
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;
	}
	
	

}
