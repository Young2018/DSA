package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

/**
 *  LinkedBag2��ʵ�������еĹ��˵������Ҫ�ķ���
 *  
 * */
public class LinkedBag2<T> implements BagInterface<T>{
	/** ���Ľڵ�*/
	private class Node {
		private T 	data;	// Entry in bag
		private Node next; 	// Link to the next node
		
		/** ������data��ʼ����Node*/
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		
		/** ����data��nextNode��ʼ���Ľڵ�*/
		private Node(T dataPortion, Node nextNode){
			data = dataPortion;
			next = nextNode;
		}
	}
	
	// ���ĵ�һ���ڵ�
	private Node firstNode;
	// ���нڵ�ĸ���
	private int numberOfEntries;
	
	/** LinkedBag2���Ĭ�Ϲ��췽��������һ���ڵ��ʼ��Ϊnull�����е�Ԫ�ظ�����ʼ��Ϊ0*/
	public LinkedBag2(){
		firstNode = null;
		numberOfEntries = 0;
	}
	
	/** ���ذ��е�ǰ�Ľڵ����*/
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	/** �жϰ��Ƿ�Ϊ�գ����ڵ����Ϊ0������True,����,����False*/
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/** ʹ��ͷ�巨����������ڵ�*/
	@Override
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		// �½�һ����newEntryΪdataֵ��Node����
		Node newNode = new Node(newEntry);
		// �� newNode����һ���ڵ�����ָ��ͷ�ڵ�
		newNode.next = firstNode;	// make new node reference rest of chain
									// (firstNode is null if chain is empty)
									// New node is at beginning of chain
		// ��ͷ��������ָ��newNode
		firstNode = newNode;
		// �����е�Ԫ�ظ�����1
		numberOfEntries++;
		
		return true;
	}// end add

	/** ɾ�������еĵ�һ���ڵ�*/
	@Override
	public T remove() {
		// �½��������͵�result����������ֵΪnull
		T result = null;
		// ��ͷ��㲻Ϊ�գ���ɾ�����е�ͷ���
		if(firstNode != null){
			result = firstNode.data;
			firstNode = firstNode.next;
			// ���ﲻ��Ҫд��C��C++�е��ͷ�firstNode�ķ���
			// ��Ϊ��Java��û�б����õĶ���ᱻJVM�Զ�����
			numberOfEntries--;	// ������Ԫ�صĸ�����1
		}
		return result;
	}
	
	/** ��������Ԫ���ڰ��е�λ��
	 * ������ҳɹ�,����һ��ָ������ڵ������
	 * ���򣬷���null
	 * */
	private Node getReferenceTo(T anEntry){
		// ��ʼ����־���� foundΪ��
		boolean found = false;
		// ����һ���ڵ����������currentNode,�Ӵ˿�ʼ���Ҹ�����ֵ
		Node currentNode = firstNode;
		
		// ���ҵ�data��ΪanEntry�Ľڵ����ֹѭ���� found = true
		// ������������������δ�ҵ�data��ΪanEntry�Ľڵ㣬����ѭ���� found Ϊ��ʼֵ����
		while(!found && (currentNode != null)){
			if(anEntry.equals(currentNode.data)){
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}		
		// �����ҵ��Ľڵ�����ã�
		// ���ɹ����������ҵ�������anEntryֵ�Ľڵ�,�򷵻ظýڵ������
		// ���򣬷���null
		return currentNode;		
	}

	/** ������еĻ���ɾ��ָ��Ԫ�صĵ�һ���������еĳ���*/
	@Override
	public boolean remove(T anEntry) {
		// ��ʼ��ɾ���Ľ��Ϊfalse
		boolean result = false;
		// ���Ҹ���ֵanEntry������ĵ�һ�γ��֣������ýڵ�����ø�ֵ��nodeN
		Node nodeN = getReferenceTo(anEntry);
		
		// ���ýڵ�����ò�Ϊnull,����������ɾ���ýڵ㣬����result��ֵΪtrue
		if(nodeN != null){
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}
		// ����ɾ�����
		return result;
	}
	
	/** ������еĻ���ɾ��ָ��Ԫ���������е����г���*/
	@Override
	public boolean removeAll(T anEntry) {
		// ��ʼ��ɾ�����Ϊfalse
		boolean result = false;
		// ���Ҹ���ֵanEntry������ĵ�һ�γ��֣������ýڵ�����ø�ֵ��nodeN
		Node nodeN = getReferenceTo(anEntry);
		
		// ���ýڵ�����ò�Ϊnullʱ������ɾ���ڵ��ѭ��, 
		// ÿɾ��һ���ڵ㣬�����еĽڵ������1����ɾ�������ֵΪtrue,
		// �ټ������Ұ����Ƿ��иĸ���ֵ�Ľڵ�, ����ѭ��
		// nodeNΪnullʱ������ѭ��
		while(nodeN != null){
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
			nodeN = getReferenceTo(anEntry);
		}
		// ����ɾ�����
		return result;
	}
	
	/** ������е����нڵ�*/
	@Override
	public void clear() {
		// ��������ʱ������remove()����ɾ�����еĵ�һ���ڵ㣬ֱ������Ϊֹ
		while(!isEmpty()){
			remove();
		}
	}
	
	/** ���Ҹ���ֵ�ڰ��г��ֵĴ���*/
	@Override
	public int getFrequencyOf(T anEntry) {
		// ��ʼ������ֵ���ֵĴ���Ϊ0
		int frequency = 0;
		// ��ʼ��ѭ��������Ϊ0
		int loopCounter = 0;
		// ����һ���ڵ�����ø�ֵ��currentNode
		Node currentNode = firstNode;
		
		// ��ѭ��������С�ڽڵ�����ҵ�ǰ�ڵ㲻Ϊ��ʱ������ѭ��
		while((loopCounter < numberOfEntries) && (currentNode != null)){
			// �Ƚϸ���ֵ�͵�ǰ�ڵ��data������ͬ����frequency + 1
			if(anEntry.equals(currentNode.data)){
				frequency++;
			}		
			loopCounter++;						// ѭ�������� + 1
			currentNode = currentNode.next;		// ������һ���ڵ�
		}
		// ���ظ���ֵ�ڰ��г��ֵ�Ƶ��
		return frequency;
	}
	
	/** ���Ұ����Ƿ��и���ֵ�������򷵻�true,���򷵻�false*/
	@Override
	public boolean contains(T anEntry) {
		// ��ʼ�����ұ�ʶΪfalse
		boolean found = false;
		// ����һ���ڵ�����ø�ֵ��currentNode
		Node currentNode = firstNode;
		
		// ����û���ҵ�����ֵ�ҵ�ǰ�Ľڵ㲻Ϊ��ʱ������ѭ��
		while(!found && (currentNode != null)){
			// ����ǰ�ڵ������ֵ��ȣ���found��ֵΪtrue
			if(anEntry.equals(currentNode.data)){
				found = true;
			}
			// ���򣬼���������һ���ڵ�
			else{
				currentNode = currentNode.next;
			}
		}
		//���ز��ҽ��
		return found;
	}
	
	/** �������е�ֵ�������鲢���ظ�����*/
	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // unchecked cast
		
		// ѭ����������
		int index = 0;
		Node currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		// ����������������ʽ
		return result;
	}
}
