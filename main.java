import java.util.*;

public class main
{
	public static void main(String[] args){
		int flag = Integer.parseInt(args[0]);
		int numpoints = Integer.parseInt(args[1]);
		int numtrials = Integer.parseInt(args[2]);
		int dimension = Integer.parseInt(args[3]);
		if (dimension == 0){
			dimension0 d0 = new dimension0(flag, numpoints, numtrials);
		}
	}
}