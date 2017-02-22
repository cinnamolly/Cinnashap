import java.util.*;

public class dimensionOther
{
	private int flag, numpoints, numtrials, dimension;
	private randomGen random;
	private double r;
	public ArrayList<double[]> pointList;
	public LinkedList[] vertexList;
	public dimensionOther(int flag, int numpoints, int dimension){
		this.flag = flag;
		this.numpoints = numpoints;
		this.numtrials = numtrials;
		this.dimension = dimension;
		random = new randomGen();
	}
	public ArrayList<double[]> populate (int numpoints, int dimension){
		pointList = new ArrayList<double[]>();
		for(int x = 0; x<numpoints; x++){
			double[] arrayToAdd = new double[dimension];
			for (int y = 0; y<dimension; y++){
				double r = random.random();
				arrayToAdd[y] = r;
			}
			pointList.add(arrayToAdd);
		}
		for(int x = 0; x<numpoints; x++){
			//System.out.print(Arrays.toString(pointList.get(x))+",");
		}
		this.pointList = pointList;
		return pointList;
	}

	public LinkedList[] populateVertexList (int numpoints){
		vertexList = new LinkedList[numpoints];
		for(int y = 0; y<numpoints; y++){
			LinkedList l = new LinkedList();
			l.add(y, 0);
			vertexList[y] = l;
		}
		for(int x = 0; x<numpoints; x++){
			LinkedList indexList = vertexList[x];
			for(int y=1; y<numpoints;y++){
				if(x<y){
					double[] point1 = pointList.get(x);
					double[] point2 = pointList.get(y);
					double d = calcDist(point1, point2);
					//System.out.println(d);
					indexList.add(y, d);
					LinkedList otherList = vertexList[y];
					otherList.add(x, d);
				}
				
			}
		}
		/*for(int x = 0; x<numpoints; x++){
			System.out.println(x);
			LinkedList l = vertexList[x];
			System.out.println(l.toString());
		}*/
		this.vertexList = vertexList;
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