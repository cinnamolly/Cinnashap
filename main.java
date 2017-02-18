import java.util.*;

public class main
{
	public static void main(String[] args){
		int flag = Integer.parseInt(args[0]);
		int numpoints = Integer.parseInt(args[1]);
		int numtrials = Integer.parseInt(args[2]);
		int dimension = Integer.parseInt(args[3]);
		double[] mstTrials = new double[numtrials];
		double sum = 0;
		double result = 0;
		if(numpoints == 1){
			System.out.println("0");
		}
		else
		{
			if (dimension == 0){
				dimension0 d0 = new dimension0(flag, numpoints);
				for (int x = 0; x < numtrials; x++){
					d0.populate(numpoints);
					Prims p = new Prims(numpoints, d0.vertexList);
					mstTrials[x] = p.doPrims();
				}				
			}
			else{
				dimensionOther dOther = new dimensionOther(flag, numpoints, dimension);
				for (int x = 0; x < numtrials; x++){
					dOther.populate(numpoints, dimension);
					dOther.populateVertexList(numpoints);
					Prims p2 = new Prims(numpoints, dOther.vertexList);
					mstTrials[x] = p2.doPrims();
				}
			}
			for(int z=0; z<mstTrials.length; z++)
			{
				sum += mstTrials[z];
			}
			result = sum/(mstTrials.length);
		}
		System.out.println(result + " " + numpoints + " " + numtrials + " " + dimension);
	}
}