package program05;

public class DynArray
{
	private double[] array;
	private int size;
	private int nextIndex;

	public DynArray()
	{
		array = new double[1];
		size = 1;
		nextIndex = 0;
	}

	public int arraySize()
	{
		return size;
	}

	public int elements()
	{
		return nextIndex;
	}

	public double at(int index)
	{
		if (0 <= index && index < nextIndex)
			return array[index];
		else
			return Double.NaN;
	}

	private void grow()
	{
		double arrayNew[];
		size = size * 2;
		arrayNew = new double[size];
		for (int i = 0; i < array.length; i++)
		{
			double temp;
			temp = array[i];
			arrayNew[i] = temp;
		}
		array = arrayNew;
	}

	private void shrink()
	{
		double arrayNew[];
		size = array.length / 2;
		arrayNew = new double[size];
		for (int i = 0; i < size; i++)
		{
			double temp;
			temp = array[i];
			arrayNew[i] = temp;
		}
		array = arrayNew;
	}

	public void insertAt(int index, double value)
	{
		if (index >= 0 && index <= nextIndex)
		{
			double temp1;
			for (int i = index; i <= nextIndex; ++i)
			{
				if (nextIndex == array.length)
				{
					grow();
				}
				temp1 = array[i];
				array[i] = value;
				value = temp1;
			}
		}
		nextIndex = nextIndex + 1;
	}

	public void insert(double value)
	{
		if (nextIndex == array.length)
		{
			grow();
		}
		array[nextIndex] = value;
		nextIndex = nextIndex + 1;
	}

	public double removeAt(int index)
	{
		if (index >= 0 && index < nextIndex)
		{
			double temp1;
			double temp2 = 0;
			double value = array[index];
			for (int i = nextIndex - 1; i >= index; --i)
			{

				temp1 = array[i];
				array[i] = temp2;
				temp2 = temp1;
			}
			nextIndex = nextIndex - 1;
			return value;
		} else
			return Double.NaN;
	}

	public double remove()
	{
		double value1;
		if (nextIndex == 0)
			return Double.NaN;
		else
		{
			if (nextIndex == array.length / 2)
			{
				shrink();
			}
			value1 = array[nextIndex - 1];
			nextIndex = nextIndex - 1;
		}
		return value1;
	}

	public void printArray()
	{
		for (int i = 0; i < nextIndex; ++i)
		{
			System.out.println("array.at(" + i + ") = " + array[i] + " ");
		}
	}
}
