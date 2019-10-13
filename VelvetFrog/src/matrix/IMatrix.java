package matrix;

public abstract class IMatrix<T>
{
	protected float[] m;
	public abstract T div(float scalar);
	public abstract T mult(float scalar);
	public abstract T add(T matrix);
	public abstract T sub(T matrix);
	public abstract T mult(T matrix);
	
	public abstract float normSquared();
	
	public float norm()
	{
		return (float) Math.sqrt(normSquared());
	}
	
	public float sum()
	{
		float sum = 0.0f;
		for (int i = 0; i < this.size(); i++)
		{
			sum += this.m[i];
		}
		return sum;
	}
	
	public abstract T inverse();
	public abstract T multDiagonal(float scalar);
	public abstract T transpose();
	public abstract T negate();
	
	public abstract T set(int index, float value);
	public abstract T set(int row, int col, float value);
	public abstract float get(int index);
	public abstract float get(int row, int col);
	public abstract int getColumnCount();
	public abstract int getRowCount();
	
	public boolean isSquare()
	{
		return getColumnCount() == getRowCount();
	}
	
	public abstract T copy();
	public abstract String toString();
	public abstract int size();
}
