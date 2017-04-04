package vector;

import matrix.MatrixXf;

public class VecXf
{
	private final float[] data;
	
	public VecXf(float[] data)
	{
		this.data = data;
	}
	
	public VecXf(int length)
	{
		data = new float[length];
	}
	
	public void set(int index, float value)
	{
		data[index] = value;
	}
	
	public float get(int index)
	{
		return data[index];
	}
	
	public VecXf swap(int index1, int index2)
	{
        final float temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
        return this;
    }
	
	public VecXf fill(float value)
	{
		for (int i = 0; i < data.length; i++) {
			data[i] = value;
		}
		return this;
	}
	
	public VecXf copy()
	{
		return new VecXf(arrayCopy());
	}
	
	public float[] arrayCopy()
	{
		final float[] copy = new float[data.length];
		for (int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}
		return copy;
	}
	
	public MatrixXf toMatrixXf()
	{
		return new MatrixXf(data.length, 1, data);
	}
	
	public int length()
	{
		return data.length;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder vecToString = new StringBuilder("VecXf - 1x" + length() + ":\n");
		final int cols = length() > 10 ? 10 : length();
		for (int i = 0; i < cols; i++) {
			vecToString.append(data[i] + ", ");
		}
		vecToString.delete(vecToString.length()-2, vecToString.length());
		vecToString.append(cols > 10 ? "...\n" : "\n");
		return vecToString.toString();
	}
}
