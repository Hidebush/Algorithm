package com.yuehuig;

import java.util.PrimitiveIterator.OfDouble;

public class ArrayList {

	/**
	 * 元素的数量
	 */
	private int size;
	
	/**
	 * 所有的元素
	 */
	private int[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = new int[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
		add(size, element);
	}
	
	/**
	 * 获取index位置的元素
	 * @param index
	 */
	public int get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 设置index位置的元素 
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public int set(int index, int element) {
		rangeCheck(index);
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 在index位置插入元素 
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		rangeCheckForAdd(index);
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
	public int remove(int index) {
		rangeCheck(index);
		int old = elements[index];
		for (int i = index + 1; i <= size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		return old;
	}
	
	/**
	 * 查看元素的索引 
	 * @param index
	 * @param element
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
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
