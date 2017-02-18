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
		}
		for(int x = 0; x<numpoints; x++){
			LinkedList indexList = vertexList[x];
			for(int y=1; y<numpoints;y++){
				if(x<y){
					r = random.random();
					System.out.println(r);
					indexList.add(y, r);
					LinkedList otherList = vertexList[y];
					otherList.add(x, r);
				}
				
			}
		}

		for(int x = 0; x<numpoints; x++){
			System.out.println(x);
			LinkedList l = vertexList[x];
			System.out.println(l.toString());
		}
		this.vertexList = vertexList;
		return vertexList;
	}

	public double prims() {
		double[] dist = new double[numpoints];
		int[] prev = new int[numpoints];
		Node v = new Node(-1, -1);
		Node w = new Node(-1, -1);
		int[] set = new int[numpoints];
		MinHeap min = new MinHeap(numpoints*(numpoints - 1)/2);
		LinkedList[] g = this.vertexList;
		

		min.add(g[0].get(0));

		for (int i = 0; i < numpoints; i++) {
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}

		dist[0] = 0;

		while (!min.isEmpty()) {
			v = min.remove();
			set[v.vertexName] = 1;
			for (int i = 0; i < numpoints; i++) {
				w = g[v.vertexName].get(i); 
				if (set[w.vertexName] != 1) {
					if (dist[w.vertexName] > w.weight) {
						dist[w.vertexName] = w.weight;
						prev[w.vertexName] = v.vertexName;
						
						min.add(w);
					}
				}
			}

		}

	//now find the last vertex added to the set and follow its prev pointers to the start, adding up the distances from the dist array to get the weight of the MST?
		double mst_sum = 0;
		for(int i = 0; i < numpoints; i++) {
			mst_sum += dist[i];
		}

		return mst_sum;
	}
}