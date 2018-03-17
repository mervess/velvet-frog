package vector;

public class Vector2f implements IVector<Vector2f>
{
	private float[] x = new float[2];
	
	public Vector2f(float value)
	{
		this.x[0] = value;
		this.x[1] = value;
	}
	
	public Vector2f(float x, float y)
	{
		this.x[0] = x;
		this.x[1] = y;
	}
	
	@Override
	public Vector2f add(float scalar)
	{
		return new Vector2f(x[0]+scalar, x[1]+scalar);
	}

	@Override
	public Vector2f sub(float scalar)
	{
		return new Vector2f(x[0]-scalar, x[1]-scalar);
	}

	@Override
	public Vector2f div(float scalar)
	{
		return new Vector2f(x[0]/scalar, x[1]/scalar);
	}
	
	public Vector2f divI(float scalar)
	{
		x[0] /= scalar;
		x[1] /= scalar;
		return this;
	}

	@Override
	public Vector2f mult(float scalar)
	{
		return new Vector2f(x[0]*scalar, x[1]*scalar);
	}
	
	public Vector2f multI(float scalar)
	{
		x[0] *= scalar;
		x[1] *= scalar;
		return this;
	}

	@Override
	public Vector2f add(Vector2f otherVector)
	{
		return new Vector2f(x[0]+otherVector.x[0], x[1]+otherVector.x[1]);
	}
	
	public Vector2f addI(Vector2f otherVector)
	{
		x[0] += otherVector.x[0];
		x[1] += otherVector.x[1];
		return this;
	}

	@Override
	public Vector2f sub(Vector2f otherVector)
	{
		return new Vector2f(x[0]-otherVector.x[0], x[1]-otherVector.x[1]);
	}

	@Override
	public Vector2f div(Vector2f otherVector)
	{
		return new Vector2f(x[0]/otherVector.x[0], x[1]/otherVector.x[1]);
	}

	@Override
	public float dot(Vector2f otherVector)
	{
		/*
		 * mult two vectors (this and otherVector)
		 * then sum the resulted x and y
		 */
		return (x[0]*otherVector.x[0]) + (x[1]*otherVector.x[1]);
	}
	
	/**
	 * normSquared = lengthSquared
	 */
	@Override
	public float normSquared()
	{
		return dot(this);
	}
	
	@Override
	public Vector2f negate()
	{
		return new Vector2f(-x[0], -x[1]);
	}

	@Override
	public float sum()
	{
		return x[0]+x[1];
	}
	
	@Override
	public float get(int index)
	{
		return x[index];
	}

	@Override
	public int getSize()
	{
		return 2;
	}
	
	public void clear()
	{
		x[0] = 0.0f;
		x[1] = 0.0f;
	}
	
	@Override
	public String toString()
	{
		return String.format("Float2[%.8f, %.8f]", x[0], x[1]);
	}
}
