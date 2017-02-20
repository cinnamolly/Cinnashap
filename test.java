import java.util.*;

public class test
{
	private ArrayList<Double> values;
	public LinkedList[] vertexList;
	
	public test(ArrayList<Double> values){
		this.values = values;
	}
	
	public LinkedList[] populate(int numpoints)
	{
		//populate each linked list with info about self
		vertexList = new LinkedList[numpoints];
		int z = 0;
		for(int y = 0; y<numpoints; y++){
			LinkedList l = new LinkedList();
			l.add(y, 0);
			vertexList[y] = l;
		}
		for(int x = 0; x<numpoints; x++){
			LinkedList indexList = vertexList[x];
			for(int y=1; y<numpoints;y++){
				if(x<y){
					indexList.add(y, values.get(z));
					LinkedList otherList = vertexList[y];
					otherList.add(x, values.get(z));
					z++;
				}
				
			}
		}

		for(int x = 0; x<numpoints; x++){
			System.out.println(x);
			LinkedList l = vertexList[x];
			System.out.println(l.toString());
		}
		this.vertexList = vertexList;
		return vertexList;
	}

	public double run(int numpoints){
		populate(numpoints);
		Prims p = new Prims(numpoints, vertexList);
		double value = p.doPrims();
		value = Math.round(value*100.0)/100.0;
		return value;
	}
}