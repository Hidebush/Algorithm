package com.yuehuig;

public class ArrayList<E> extends AbstractList<E> {
	
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	
	/**
	 * 获取index位置的元素
	 * @param index
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 设置index位置的元素 
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 在index位置插入元素 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 * 删除index位置的元素 
	 * @param index
	 * @param element
	 */
	public E remove(int index) {
		rangeCheck(index);
		E old = elements[index];
		for (int i = index + 1; i <= size - 1; i++) {
			elements[i - 1] = elements[i];
		}
//		size--;
//		elements[size] = null;
		elements[--size] = null;
		return old;
	}
	
	/**
	 * 查看元素的索引 
	 * @param index
	 * @param element
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 保证capacity的容量
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量
		int newCapacity = oldCapacity + oldCapacity >> 1;
		Object[] newElements = new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = (E[]) newElements;
	}  
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size:").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
