import java.util.*;

public class LinkedList{
	private Node head;

	public LinkedList(){

	}

	public void add(int vertex, double weight){
		if(head == null){
			head = new Node(vertex, weight);
		}
		else{
			Node newNode = new Node(vertex, weight);
			newNode.setNext(head);
		}

	}

	public Node get(int index){
		if(index < 0){
			return null;
		}
		Node currNode = null;
		if(head!=null){
			currNode = head.getNext();
			for (int x = 0; x<index;x++){
				if(currNode.getNext() == null)
					return null;
				currNode = currNode.getNext();
			}
		}
		return currNode;
	}

	public String toString() {
		String result = "";
		Node currNode = head;
		while(currNode!= null){
			result+= "Vertex: " + currNode.getVertexName() + ", Weight: " + currNode.getWeight() + ", ";
			currNode = currNode.getNext();
		}
		return result;
	}

}