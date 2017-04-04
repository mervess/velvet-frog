package storage;

/**
 * 
 * @author mervess
 *
 */
public class Float2 implements IStorage<Float2>
{
	private float x;
	private float y;
	
	public Float2(float value)
	{
		this.x = value;
		this.y = value;
	}
	
	public Float2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Float2 add(float scalar)
	{
		return new Float2(x+scalar, y+scalar);
	}

	@Override
	public Float2 sub(float scalar)
	{
		return new Float2(x-scalar, y-scalar);
	}

	@Override
	public Float2 div(float scalar)
	{
		return new Float2(x/scalar, y/scalar);
	}
	
	public Float2 divI(float scalar)
	{
		x /= scalar;
		y /= scalar;
		return this;
	}

	@Override
	public Float2 mult(float scalar)
	{
		return new Float2(x*scalar, y*scalar);
	}
	
	public Float2 multI(float scalar)
	{
		x *= scalar;
		y *= scalar;
		return this;
	}

	@Override
	public Float2 add(Float2 storage)
	{
		return new Float2(x+storage.x, y+storage.y);
	}
	
	public Float2 addI(Float2 storage)
	{
		x += storage.x;
		y += storage.y;
		return this;
	}

	@Override
	public Float2 sub(Float2 storage)
	{
		return new Float2(x-storage.x, y-storage.y);
	}

	@Override
	public Float2 div(Float2 storage)
	{
		return new Float2(x/storage.x, y/storage.y);
	}

	@Override
	public Float2 mult(Float2 storage)
	{
		return new Float2(x*storage.x, y*storage.y);
	}
	
	public Float2 multI(Float2 storage)
	{
		x *= storage.x;
		y *= storage.y;
		return this;
	}

	@Override
	public float dot(Float2 storage)
	{
		/*
		 * mult two vectors (this and storage)
		 * then sum the resulted x and y
		 */
		return (x*storage.x) + (y*storage.y);
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
	public Float2 negate()
	{
		return new Float2(-x, -y);
	}

	@Override
	public float sum()
	{
		return x+y;
	}

	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	@Override
	public float get(int index)
	{
		switch (index) {
			case 0:
				return x;
			case 1:
				return y;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float2 - get("+index+")");
		}
	}

	@Override
	public int getSize()
	{
		return 2;
	}
	
	public void clear()
	{
		x = 0.0f;
		y = 0.0f;
	}
	
	@Override
	public String toString()
	{
		return "Float2 storage values: " + x + ", " + y;
	}
}
