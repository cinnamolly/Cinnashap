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
		if(flag ==0){
			if(numpoints == 1){
				result = 0;
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
		//Test Case 1
		else if(flag == 1){
			ArrayList<Double> values = new ArrayList<Double>();
			values.add(.7);
			values.add(.3);
			values.add(.5);
			test t = new test(values);
			double value = t.run(3);
			if(value == .8){
				System.out.println("true");
			}
			else{
				System.out.println("false");
			}

		}
		else if (flag == 2){
			ArrayList<Double> values = new ArrayList<Double>();
			values.add(.9);
			values.add(.6);
			values.add(.4);
			values.add(.2);
			values.add(.7);
			values.add(.8);
			test t = new test(values);
			double value = t.run(4);
			if(value == 1.2){
				System.out.println("true");
			}
			else{
				System.out.println("false");
			}
		}
		else if (flag == 3){
			ArrayList<Double> values = new ArrayList<Double>();
			values.add(.9);
			values.add(.6);
			values.add(.4);
			values.add(.2);
			values.add(.7);
			values.add(.1);
			values.add(.3);
			values.add(.5);
			values.add(.4);
			values.add(.9);
			test t = new test(values);
			double value = t.run(5);
			if(value == 1.0){
				System.out.println("true");
			}
			else{
				System.out.println("false");
			}
		}
	}
}