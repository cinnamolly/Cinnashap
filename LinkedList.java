import java.util.*;

public class LinkedList{
	// HI
	private Node head;

	public LinkedList(){

	}

	public void add(int nextNode, double weight){
		if(head == null){
			head = new Node(nextNode, weight);
		}

		Node newNode = new Node(nextNode, weight);
		Node currNode = head;

		if(currNode != null){
			while(currNode.getNext() != null){
				currNode = currNode.getNext();
			}
			currNode.setNext(newNode);
		}
	}

	public Object get(int index){
		if(index < 0){
			return null;
		}
		Node currNode = null;
		if(head!=null){
			currNode = head.getNext();
			for (int x = 0; x<index<x++){
				if(currNode.getNext() == null)
					return null;
				currNode = currNode.getNext();
			}
		}
		return currNode;
	}

}

private class Node{
	Node next;
	int nextNodeNum;
	double weight;

	public Node(int nextNode, double weight){
		next = null;
		this.nextNodeNum = nextNode;
		this.weight = weight;
	}

	public int getNextNodeNum(){
		return nextNodeNum;
	}

	public double getWeight(){
		return weight;
	}

	public Node getNext(){
		return next;
	}

	public void setNextNodeNum(int newNum){
		nextNodeNum = newNum;
	}

	public void setWeight(double newWeight){
		weight = newWeight;
	}

	public void setNext(Node nextNode){
		next = nextNode;
	}
}