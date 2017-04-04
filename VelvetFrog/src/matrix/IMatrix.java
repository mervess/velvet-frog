package matrix;

public interface IMatrix<T>
{
	public T div(float scalar);
	public T mult(float scalar);
	
	public T add(T matrix);
	public T sub(T matrix);
	public T mult(T matrix);
	
	public float normSquared();
	
	default public float norm()
	{
		return (float) Math.sqrt(normSquared());
	}
	
	public float sum();
	
	public T inverse();
	public T multDiagonal(float scalar);
	public T transpose();
	public T negate();
	
	public T set(int index, float value);
	public T set(int row, int col, float value);
	public float get(int index);
	public float get(int row, int col);
	public int getColumnCount();
	public int getRowCount();
	
	default public boolean isSquare()
	{
		return getColumnCount() == getRowCount();
	}
	
	public T copy();
	public String toString();
}
