package coursera.queue;

import java.util.Iterator;

/**
 * Created by 1100413 on 2017. 7. 31..
 */
public class Deque<Item> implements Iterable<Item> {
	//public Deque()                           // construct an empty deque
//	public boolean isEmpty()                 // is the deque empty?
//	public int size()                        // return the number of items on the deque
//	public void addFirst(Item item)          // add the item to the front
//	public void addLast(Item item)           // add the item to the end
//	public Item removeFirst()                // remove and return the item from the front
//	public Item removeLast()                 // remove and return the item from the end
//	public Iterator<Item> iterator()         // return an iterator over items in order from front to end

	private Node<Item> first;
	private Node<Item> last;
	private int size;

	public Deque(){
		size = 0;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public void addFirst(Item item){
		if( item == null ) throw new java.lang.IllegalArgumentException();
		Node<Item> newFirst = new Node<>();
		newFirst.item = item;
		if( first == null ){
			last = newFirst;
		}else{
			newFirst.next = first;
			first.prev = newFirst;
		}
		first = newFirst;
		size++;
	}

	public void addLast(Item item){
		if( item == null ) throw new java.lang.IllegalArgumentException();
		Node<Item> newLast = new Node<>();
		newLast.item = item;
		if( last == null ){
			first = newLast;
		}else{
			newLast.prev = last;
			last.next = newLast;
		}
		last = newLast;
		size++;
	}

	public Item removeFirst(){
		if( size < 1 ) throw new java.util.NoSuchElementException();
		Node<Item> oldFirst = first;
		first = oldFirst.next;
		if( first != null ){
			first.prev = null;
		}else{
			first = null;
			last = null;
		}
		oldFirst.next = null;
		oldFirst.prev = null;
		size--;
		return oldFirst.item;
	}

	public Item removeLast(){
		if( size < 1 ) throw new java.util.NoSuchElementException();
		Node<Item> oldLast = last;
		last = oldLast.prev;
		if(last != null){
			last.next = null;
		}else{
			last = null;
			first = null;
		}
		oldLast.next = null;
		oldLast.prev = null;
		size--;
		return oldLast.item;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> current = first;
			public boolean hasNext() {
				return current != null;
			}

			public Item next() {
				if( current == null ) throw new java.util.NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			}

			public void remove() {
				throw new java.lang.UnsupportedOperationException();
			}
		};
	}

	private class Node<Item>{
		Item item;
		Node<Item> next;
		Node<Item> prev;
	}

	public static void main(String[] args){
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		deque.addFirst(1);
		deque.removeLast();
		deque.addFirst(1);
		deque.addFirst(1);
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		deque.addFirst(1);
		deque.removeLast();
		deque.removeLast();

		for( Integer n : deque ){
			System.out.println(n);
		}

		//System.out.println(deque.removeLast());
	}
}
