import java.util.*;

public class dimensionOther
{
	private int flag, numpoints, numtrials, dimension;
	private randomGen random;
	private double r;
	public ArrayList<double[]> vertexList;
	public dimensionOther(int flag, int numpoints, int numtrials, int dimension){
		this.flag = flag;
		this.numpoints = numpoints;
		this.numtrials = numtrials;
		this.dimension = dimension;
		random = new randomGen();
	}
	public ArrayList<double[]> populate (int numpoints, int dimension){
		vertexList = new ArrayList<double[]>();
		for(int x = 0; x<numpoints; x++){
			double[] arrayToAdd = new double[dimension];
			for (int y = 0; y<dimension; y++){
				double r = random.random();
				arrayToAdd[y] = r;
			}
			vertexList.add(arrayToAdd);
		}
		for(int x = 0; x<numpoints; x++){
			System.out.print(Arrays.toString(vertexList.get(x))+",");
		}
		return vertexList;
	}
	public double calcDist(double[] p1, double[] p2){
		int length = p1.length;
		double sum = 0;
		for(int x=0; x<length; x++){
			sum += Math.pow((p1[x] - p2[x]),2);
		}
		return Math.sqrt(sum);
	}
}