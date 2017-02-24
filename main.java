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
		if(numpoints == 1){
			result = 0;
		}
		else
		{
			for(int x = 0; x <numtrials; x++)
			{
				Prims p = new Prims(numpoints, dimension, flag);
				sum += p.doPrims();
			}
			result = sum/numtrials;
		}
		System.out.println(result + " " + numpoints + " " + numtrials + " " + dimension);
		if (flag ==1){
			result = Math.round(result*100.0)/100.0;
			if(result == .6)
				System.out.println("Test 1: True");
		}
		else if (flag == 2){
			result = Math.round(result*100.0)/100.0;
			if(result == 1.2)
				System.out.println("Test 2: True");
		}
	}
}