import java.util.*;

public class LinkedList{
	private Node head;

	public LinkedList(){

	}

	public void add(int nextNode, double weight){
		if(head == null){
			head = new Node(nextNode, weight);
		}
		else{
			Node newNode = new Node(nextNode, weight);
			newNode.setNext(head);
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
	int vertexName;
	double weight;

	public Node(int vertex, double weight){
		next = null;
		this.vertexName = vertex;
		this.weight = weight;
	}

	public int getVertexName(){
		return vertexName;
	}

	public double getWeight(){
		return weight;
	}

	public Node getNext(){
		return next;
	}

	public void setVertexName(int newName){
		vertexName = newName;
	}

	public void setWeight(double newWeight){
		weight = newWeight;
	}

	public void setNext(Node nextNode){
		next = nextNode;
	}
}