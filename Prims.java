import java.util.*;

public class Prims
{
	private int numpoints;
	private LinkedList[] vertexList;
	public Prims(int numpoints, LinkedList[] vertexList)
	{
		this.numpoints = numpoints;
		this.vertexList = vertexList;
	}
	public double doPrims() {
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

		dist[numpoints - 1] = 0;

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

		double mst_sum = 0;
		for(int i = 0; i < numpoints; i++) {
			mst_sum += dist[i];
		}

		return mst_sum;
	}
}