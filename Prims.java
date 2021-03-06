import java.util.*;

public class Prims
{
	private int numpoints, dimension;
	private randomGen random;
	double r = 0;
	double[] dist;
	int[] set;
	int flag;
	int flagCounter;
	double[] x, y, z, w;
	double[] flag1;
	double[] flag2;


	public Prims(int numpoints, int dimension, int flag)
	{
		this.numpoints = numpoints;
		this.dimension = dimension;
		this.flag = flag;
		random = new randomGen();

		dist = new double[numpoints];
		set = new int[numpoints];
		x = new double[numpoints];
		y = new double[numpoints];
		z = new double[numpoints];
		w = new double[numpoints];
		flag1 = new double[]{.2,.6,.4};
		flag2 = new double[]{.4, .8, .9, .2, .1, .6};
		flagCounter = 0;

		// fill dist_list with MAX_INT
		for (int i = 0; i < numpoints; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		//if dimension 2 or 3 or 4 - fill point arrays
		if (dimension != 0){
			for (int i = 0; i<numpoints; i++){
				x[i] = random.random();
				y[i] = random.random();
			}
			//if dimension 3 or 4
			if (dimension != 2){
				for (int i = 0; i<numpoints; i++){
					z[i] = random.random();
				}
				//if just dimension 4
				if (dimension == 4) {
					for (int i = 0; i<numpoints; i++){
						w[i] = random.random();
					}
				}
				
			}
		}
	}

	public double doPrims(){
		//put vertex 0 in the arrays
		dist[0] = 0;
		set[0] = 1;
		//iterate through distance list, generate new distances, compare
		//v is current vertex and w is closest node to MST so far
		int v = 0;
		int w = 1;
		if(flag ==3){
			x = new double[]{.2, .3, .4};
			y = new double[]{.1, .7, .6};
			}
		for(int j = 0; j < numpoints - 1; j++){
			for(int i = 1; i < numpoints; i++) {
				if((v != i) && (set[i] != 1)){
					if(dimension == 0 && flag==0) {
						r = random.random();
					}
					else if (dimension >1 && flag == 0 || flag == 3) {
						r = calcDist(v, i, dimension);
					}
					else if(flag == 1){
						r = flag1[flagCounter];
						flagCounter++;
					}
					else if(flag == 2){
						r = flag2[flagCounter];
						flagCounter++;
					}
					

					if(r < dist[i]) {
						dist[i] = r;
					}
					if ((dist[i] < dist[w]) || (v == w)) {
						w = i;
					}
				}
			}
			set[w] = 1;
			v = w;
		}
		double mst_sum = 0;
		for(int i = 0; i < numpoints; i++) {
			mst_sum += dist[i];
		}
		return mst_sum;

	}

	public double calcDist(int vIndex, int currIndex, int dimension){
		double sum = Math.pow((x[vIndex] - x[currIndex]),2) + Math.pow((y[vIndex] - y[currIndex]),2);
		
		if (dimension != 2) {
			sum += Math.pow((z[vIndex] - z[currIndex]),2);

			if (dimension == 4) {
				sum += Math.pow((w[vIndex] - w[currIndex]),2);	
			}	
		}
		
		return Math.sqrt(sum);
	}
}