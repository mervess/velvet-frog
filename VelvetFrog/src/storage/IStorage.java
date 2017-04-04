package storage;

public interface IStorage<T>
{
	public T add(float scalar);
	public T sub(float scalar);
	public T div(float scalar);
	public T mult(float scalar);
	
	public T add(T storage);
	public T sub(T storage);
	public T div(T storage);
	public T mult(T storage);
	
	public float dot(T storage);
	public float normSquared();
	public float norm(); //called also "length" in some other resources
	public T normalise();
	public T negate();
	public float sum();
	
	public float get(int index);
	public int getSize();
	
//	public T slice(int from, int to);
}