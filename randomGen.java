import java.util.*;

public class randomGen
{
	private double rNum;
	private static Random rand = new Random(System.currentTimeMillis());
	public randomGen()
	{
		rNum = -1; 
	}

	public double random()
	{
		rNum = (1.0) * rand.nextDouble();
		return rNum;
	}
}