package coursera.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created by 1100413 on 2017. 7. 31..
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
//	public RandomizedQueue()                 // construct an empty randomized queue
//	public boolean isEmpty()                 // is the queue empty?
//	public int size()                        // return the number of items on the queue
//	public void enqueue(Item item)           // add the item
//	public Item dequeue()                    // remove and return a random item
//	public Item sample()                     // return (but do not remove) a random item
//	public Iterator<Item> iterator()         // return an independent iterator over items in random order
//	public static void main(String[] args)   // unit testing (optional)

	private Node<Item> first;
	private int size;

	public RandomizedQueue(){
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public void enqueue(Item item){
		if( item == null ) throw new java.lang.IllegalArgumentException();
		Node<Item> newFirst = new Node<>();
		newFirst.item = item;
		if( first != null ){
			newFirst.next = first;
		}
		first = newFirst;
		size++;
	}

	public Item dequeue(){
		if( size < 1 ) throw new java.util.NoSuchElementException();
		int randomNum = StdRandom.uniform(size);
		Node<Item> targetNode = first;
		if( randomNum < 1 ){
			first = first.next;
		}else{
			Node<Item> befNode = targetNode;
			for( int inx = 0 ; inx < randomNum; inx++ ){
				befNode = targetNode;
				targetNode = targetNode.next;
			}
			befNode.next = targetNode.next;
		}
		size--;
		targetNode.next = null;
		if( size < 1 ) first = null;
		return targetNode.item;
	}

	public Item sample(){
		if( size < 1 ) throw new java.util.NoSuchElementException();
		int randomNum = StdRandom.uniform(size);
		Node<Item> targetNode = first;
		for( int inx = 0 ; inx < randomNum; inx++ ){
			targetNode = targetNode.next;
		}
		return targetNode.item;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> current = first;
			private RandomizedQueue<Item> randomizedQueue;

			public boolean hasNext() {
				if( randomizedQueue == null ) makeRandom();
				return !randomizedQueue.isEmpty();
			}

			public Item next() {
				if( randomizedQueue == null ) makeRandom();
				if( !hasNext() ) throw new java.util.NoSuchElementException();
				return randomizedQueue.dequeue();
			}

			private void makeRandom(){
				randomizedQueue = new RandomizedQueue<>();
				if(current == null) return;
				randomizedQueue.enqueue(current.item);
				while( current.next != null ){
					current = current.next;
					randomizedQueue.enqueue(current.item);
				}
			}

			public void remove() {
				throw new java.lang.UnsupportedOperationException();
			}
		};
	}

	private class Node<Item>{
		Item item;
		Node<Item> next;
	}

	public static void main(String[] args){
		RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
		randomizedQueue.enqueue(1);
		randomizedQueue.enqueue(2);
		randomizedQueue.enqueue(3);
		randomizedQueue.enqueue(4);
		randomizedQueue.enqueue(5);
		randomizedQueue.enqueue(6);
		randomizedQueue.enqueue(7);
		randomizedQueue.enqueue(8);
		randomizedQueue.enqueue(9);
		randomizedQueue.enqueue(10);
		randomizedQueue.enqueue(11);

		for( Integer n : randomizedQueue ){
			System.out.print(n + " ");
		}

		System.out.println();
		for( Integer n : randomizedQueue ){
			System.out.print(n + " ");
		}
	}
}
