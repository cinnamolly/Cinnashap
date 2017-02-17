import java.util.*;

public class dimension0
{
	private int flag, numpoints, numtrials;
	private randomGen random;
	private double r;
	public LinkedList[] vertexList;
	public dimension0(int flag, int numpoints, int numtrials){
		this.flag = flag;
		this.numpoints = numpoints;
		this.numtrials = numtrials;
		random = new randomGen();
	}
	public LinkedList[] populate(int numpoints)
	{
		//populate each linked list with info about self
		LinkedList[] vertexList = new LinkedList[numpoints];
		for(int y = 0; y<numpoints; y++){
			LinkedList l = new LinkedList();
			l.add(y, 0);
			vertexList[y] = l;
			System.out.println(l.toString());
		}
		for(int x = 0; x<numpoints; x++){
			LinkedList indexList = vertexList[x];
			for(int y=1; y<numpoints;y++){
				r = random.random();
				indexList.add(y, r);
				LinkedList otherList = vertexList[y];
				otherList.add(x, r);
			}
		}

		for(int x = 0; x<numpoints; x++){
			System.out.println(x);
			LinkedList l = vertexList[x];
			System.out.println(l.toString());
			/*for(int y = 0; y<numpoints-1;y++){
				Node z = l.get(y);
				//System.out.print("Vertex: " + z.getVertexName() + ", Weight: " + z.getWeight());
			}*/
		}
		return vertexList;
	}
}