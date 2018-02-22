package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

/**
 *  LinkedBag2类实现了所有的规格说明所需要的方法
 *  
 * */
public class LinkedBag2<T> implements BagInterface<T>{
	/** 包的节点*/
	private class Node {
		private T 	data;	// Entry in bag
		private Node next; 	// Link to the next node
		
		/** 仅使用data初始化的Node*/
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		/** 使用data和nextNode初始化的节点*/
		private Node(T dataPortion, Node nextNode){
			data = dataPortion;
			next = nextNode;
		}
	}
	
	// 包的第一个节点
	private Node firstNode;
	// 包中节点的个数
	private int numberOfEntries;
	
	/** LinkedBag2类的默认构造方法，将第一个节点初始化为null，包中的元素个数初始化为0*/
	public LinkedBag2(){
		firstNode = null;
		numberOfEntries = 0;
	}
	
	/** 返回包中当前的节点个数*/
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	/** 判断包是否为空，若节点个数为0，返回True,否则,返回False*/
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/** 使用头插法往包中新添节点*/
	@Override
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		// 新建一个以newEntry为data值的Node对象
		Node newNode = new Node(newEntry);
		// 将 newNode的下一个节点引用指向头节点
		newNode.next = firstNode;	// make new node reference rest of chain
									// (firstNode is null if chain is empty)
									// New node is at beginning of chain
		// 将头结点的引用指向newNode
		firstNode = newNode;
		// 将包中的元素个数加1
		numberOfEntries++;
		
		return true;
	}// end add

	/** 删除链包中的第一个节点*/
	@Override
	public T remove() {
		// 新建泛型类型的result变量并赋初值为null
		T result = null;
		// 若头结点不为空，则删除包中的头结点
		if(firstNode != null){
			result = firstNode.data;
			firstNode = firstNode.next;
			// 这里不需要写像C或C++中的释放firstNode的方法
			// 因为在Java中没有被引用的对象会被JVM自动回收
			numberOfEntries--;	// 将包中元素的个数减1
		}
		return result;
	}
	
	/** 锁定给定元素在包中的位置
	 * 如果查找成功,返回一个指向这个节点的索引
	 * 否则，返回null
	 * */
	private Node getReferenceTo(T anEntry){
		// 初始化标志变量 found为假
		boolean found = false;
		// 将第一个节点的索引赋给currentNode,从此开始查找给定的值
		Node currentNode = firstNode;
		
		// 当找到data域为anEntry的节点后终止循环， found = true
		// 当遍历完整改链表仍未找到data域为anEntry的节点，结束循环， found 为初始值不变
		while(!found && (currentNode != null)){
			if(anEntry.equals(currentNode.data)){
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}		
		// 返回找到的节点的引用，
		// 若成功在链表中找到给定的anEntry值的节点,则返回该节点的引用
		// 否则，返回null
		return currentNode;		
	}

	/** 如果可行的话，删除指定元素的第一次在链表中的出现*/
	@Override
	public boolean remove(T anEntry) {
		// 初始化删除的结果为false
		boolean result = false;
		// 查找给定值anEntry在链表的第一次出现，并将该节点的引用赋值给nodeN
		Node nodeN = getReferenceTo(anEntry);
		
		// 若该节点的引用不为null,则在链表中删除该节点，并将result赋值为true
		if(nodeN != null){
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}
		// 返回删除结果
		return result;
	}
	
	/** 如果可行的话，删除指定元素在链表中的所有出现*/
	@Override
	public boolean removeAll(T anEntry) {
		// 初始化删除结果为false
		boolean result = false;
		// 查找给定值anEntry在链表的第一次出现，并将该节点的引用赋值给nodeN
		Node nodeN = getReferenceTo(anEntry);
		
		// 当该节点的引用不为null时，进行删除节点的循环, 
		// 每删除一个节点，将包中的节点个数减1，将删除结果赋值为true,
		// 再继续查找包中是否还有改给定值的节点, 继续循环
		// nodeN为null时，结束循环
		while(nodeN != null){
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
			nodeN = getReferenceTo(anEntry);
		}
		// 返回删除结果
		return result;
	}
	
	/** 清除包中的所有节点*/
	@Override
	public void clear() {
		// 当包不空时，调用remove()方法删除包中的第一个节点，直到包空为止
		while(!isEmpty()){
			remove();
		}
	}
	
	/** 查找给定值在包中出现的次数*/
	@Override
	public int getFrequencyOf(T anEntry) {
		// 初始化给定值出现的次数为0
		int frequency = 0;
		// 初始化循环计数器为0
		int loopCounter = 0;
		// 将第一个节点的引用赋值给currentNode
		Node currentNode = firstNode;
		
		// 当循环计数器小于节点个数且当前节点不为空时，进入循环
		while((loopCounter < numberOfEntries) && (currentNode != null)){
			// 比较给定值和当前节点的data域，若相同，则将frequency + 1
			if(anEntry.equals(currentNode.data)){
				frequency++;
			}		
			loopCounter++;						// 循环计数器 + 1
			currentNode = currentNode.next;		// 遍历下一个节点
		}
		// 返回给定值在包中出现的频次
		return frequency;
	}
	
	/** 查找包中是否含有给定值，若有则返回true,否则返回false*/
	@Override
	public boolean contains(T anEntry) {
		// 初始化查找标识为false
		boolean found = false;
		// 将第一个节点的引用赋值给currentNode
		Node currentNode = firstNode;
		
		// 当还没有找到给定值且当前的节点不为空时，进入循环
		while(!found && (currentNode != null)){
			// 若当前节点与给定值相等，则将found赋值为true
			if(anEntry.equals(currentNode.data)){
				found = true;
			}
			// 否则，继续遍历下一个节点
			else{
				currentNode = currentNode.next;
			}
		}
		// 返回查找结果
		return found;
	}
	
	/** 将链包中的值赋给数组并返回该数组*/
	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // unchecked cast
		
		// 循环控制索引
		int index = 0;
		Node currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		// 返回链包的数组形式
		return result;
	}
}