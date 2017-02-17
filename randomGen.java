import java.util.*;

public class randomGen
{
	private double rNum;
	private Random rand;
	public randomGen()
	{
		rNum = -1; 
		rand = new Random(System.currentTimeMillis());
	}

	public double random()
	{
		rNum = (1.0) * rand.nextDouble();
		return rNum;
	}
}