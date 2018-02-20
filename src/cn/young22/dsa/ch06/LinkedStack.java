package cn.young22.dsa.ch06;

import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
/**	
 * 	LinkedStackʵ����StackInterface�����з���
 * 	ʹ������ʵ����ջ
 * 
 * */
public class LinkedStack<T> implements StackInterface<T>{
	
	private Node topNode;	// ͷ��������
	
	/** Ĭ�Ϲ��췽������ͷ����ʼ��Ϊnull*/
	public LinkedStack(){
		topNode = null;
	}// end of default constructor
	
	/** ͷ���*/
	private class Node{
		private T 	data; // Entry in stack
		private Node next; // link to the next node
		
		/** ���Ĺ��췽��������data���ʼ�����*/
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		/** ���Ĺ��췽������data��next�������ʼ�����*/
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
	
	/** push���������ͻ�������ֵ�ӵ�ջ��*/
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	/** pop��������ջ��Ԫ��ɾ��*/
	@Override
	public T pop() {
		// ȡ��ջ��Ԫ�ص�����
		T top = peek();
		
		// ����topNode��Ϊ�ս��
		assert (topNode != null);
		// ��topNode������ָ��������һ�����
		topNode = topNode.getNextNode();
		
		// ����top��������
		return top;
	}

	/** peek��������ȡջ��Ԫ�ص�ֵ
	 *  ��ջΪ�գ����׳���ջ�쳣
	 *  ���򣬷���ջ��Ԫ�ص�ֵ
	 * */
	@Override
	public T peek() {
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return topNode.getData();
		}	
	}
	
	/** isEmpty�������ж�ջ�Ƿ�Ϊ��*/
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/** clear��������ջ���*/
	@Override
	public void clear() {
		// ��ջ�������ø�ֵΪnull��ɾ�������еĽڵ�
		topNode = null;
	}
	
	

}
