public class Node{
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