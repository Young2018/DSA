package cn.young22.dsa.ch01;
/**
 * Set是不包括重复元素的包(Bag),其操作与ADT包的操作类似
 * 一个描述集合(Set)对象操作的接口
 */
public interface SetInterface<T> {
	/**
	 * 获得当前集合中元素的数目
	 * @return 返回集合中的元素个数
	 * */
	public int getCurrentSize();
	
	/**
	 * 判断该集合是否为空
	 * @return 若结合空，返回True,否则返回False
	 * */
	public boolean isEmpty();
	
	/**
	 * 向集合中添加一个元素，且添加的元素不能与集合已有的元素重复
	 * @param newEntry 要加入集合的元素
	 * @return 若添加元素成功，返回True,否则，返回False
	 * */
	public boolean add(T newEntry);
	
	/**
	 * 从集合中删除一个指定的元素，如果可以删除的话
	 * @param anEntry 要被删除的元素
	 * @return 若删除成功返回True,否则返回False 
	 * */
	public boolean remove(T anEntry);
	
	/**
	 * 从集合中删除一个任意的元素，如果可以删除的话
	 * @return 若删除成功的，返回删除的元素，否则，返回null
	 */
	public T remove();
	
	/**
	 * 删除集合中的所有元素
	 * */
	public void clear();
	
	/**
	 * 测试该集合是否含有制定的元素
	 * @param anEntry 要锁定的元素
	 * @return 若含有该元素，返回True,否则，返回False
	 * */
	public boolean contains(T anEntry);
	
	/**
	 * 检索集合中的所有元素
	 * @return 一个由集合中所有元素新分配的数组
	 * */
	public T[] toArray();
}// end SetInterface