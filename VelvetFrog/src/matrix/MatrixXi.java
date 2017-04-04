package matrix;

public class MatrixXi 
{
	private final int[] data;
	private final int rowCount, colCount, numElements;
	
	private static float norm;
	
	public MatrixXi(int rowCount, int colCount)
	{
		this.rowCount = rowCount;
		this.colCount = colCount;
		numElements = rowCount*colCount;
		data = new int[numElements];
		norm = -1.0f;
	}
	
	public MatrixXi(int rowCount, int colCount, int[] data)
	{
		this.rowCount = rowCount;
		this.colCount = colCount;
		numElements = rowCount*colCount;
		this.data = data;
		norm = -1.0f;
	}
	

	public MatrixXi set(int index, int value)
	{
		data[index] = value;
		return this;
	}

	public MatrixXi set(int row, int col, int value)
	{
		data[row*colCount+col] = value;
		return this;
	}

	public int get(int index)
	{
		return data[index];
	}

	public int get(int row, int col)
	{
		return data[row*colCount+col];
	}

	public int getColumnCount()
	{
		return colCount;
	}

	public int getRowCount()
	{
		return rowCount;
	}
}
