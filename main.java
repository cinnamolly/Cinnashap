import java.util.*;

public class main
{
	public static void main(String[] args){
		int flag = Integer.parseInt(args[0]);
		int numpoints = Integer.parseInt(args[1]);
		int numtrials = Integer.parseInt(args[2]);
		int dimension = Integer.parseInt(args[3]);
		double sum = 0;
		double result = 0;
		double tempResult = 0;
		if(flag ==0){
			if(numpoints == 1){
				result = 0;
			}
			else
			{
				for(int x = 0; x <numtrials; x++)
				{
					Prims p = new Prims(numpoints, dimension);
					tempResult = p.doPrims();
					System.out.println(tempResult);
					sum += tempResult;
				}
				result = sum/numtrials;
			}
			System.out.println(result + " " + numpoints + " " + numtrials + " " + dimension);
		}
		/*else if(flag == 1){
			Prims p1 = new Prims(3, 0);
			double result1 = p1.doPrims();
			double min1 = Integer.MAX_VALUE;
			double min2 = Integer.MAX_VALUE;
			for(int x = 0; x<storedWeights.size(); x++){
				double curr = storedWeights.get(x);
				if (curr<min1 && curr < min2){
					min1 = curr;
				}
				else if (curr > min1 && curr < min2)
				{
					min2 = curr;
				}
			}
			if ((min1 + min2) == result1){
				System.out.println("true");
			}
			else{
				System.out.println("false");
			}

		}/*
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
		}*/
	}
}