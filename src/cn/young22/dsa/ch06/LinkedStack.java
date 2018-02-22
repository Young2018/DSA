package cn.young22.dsa.ch06;

import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
/**	
 * 	LinkedStack实现了StackInterface的所有方法
 * 	使用链表实现了栈
 * 
 * */
public class LinkedStack<T> implements StackInterface<T>{
	
	private Node topNode;	// 头结点的引用
	
	/** 默认构造方法，将头结点初始化为null*/
	public LinkedStack(){
		topNode = null;
	}// end of default constructor
	
	/** 头结点*/
	private class Node{
		private T 	data; // Entry in stack
		private Node next; // link to the next node
		
		/** 结点的构造方法，仅用data域初始化结点*/
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		/** 结点的构造方法，用data和next两个域初始化结点*/
		private Node(T dataPortion, Node linkPortion){
			data = dataPortion;
			next = linkPortion;
		}
		
		@Getter
		private T getData(){
			return data;
		}
		
		@Setter
		private void setData(T newData){
			data = newData;
		}
		
		@Getter
		private Node getNextNode(){
			return next;
		}
		
		@Setter
		private void setNextNode(Node nextNode){
			next = nextNode;
		}
	}// end Node
	
	/** push方法，将客户给的新值加到栈顶*/
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	/** pop方法，将栈顶元素删除*/
	@Override
	public T pop() {
		// 取得栈顶元素的引用
		T top = peek();
		
		// 断言topNode不为空结点
		assert (topNode != null);
		// 将topNode的引用指向它的下一个结点
		topNode = topNode.getNextNode();
		
		// 返回top结点的引用
		return top;
	}

	/** peek方法，获取栈顶元素的值
	 *  若栈为空，则抛出空栈异常
	 *  否则，返回栈顶元素的值
	 * */
	@Override
	public T peek() {
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return topNode.getData();
		}	
	}
	
	/** isEmpty方法，判断栈是否为空*/
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/** clear方法，将栈清空*/
	@Override
	public void clear() {
		// 将栈顶的引用赋值为null即删除了所有的节点
		topNode = null;
	}
	
	

}