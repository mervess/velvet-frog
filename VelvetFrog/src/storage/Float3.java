package storage;

import matrix.Matrix3f;

public class Float3 implements IStorage<Float3>
{
	private float x;
	private float y;
	private float z;
	
	private static float norm = -1.0f;
	private static Float3 normalisedStorage = null;
	
	public Float3(float value)
	{
		set(value);
	}
	
	public Float3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public Float3 add(float scalar)
	{
		return new Float3(x+scalar, y+scalar, z+scalar);
	}

	@Override
	public Float3 sub(float scalar)
	{
		return new Float3(x-scalar, y-scalar, z-scalar);
	}

	@Override
	public Float3 div(float scalar)
	{
		return new Float3(x/scalar, y/scalar, z/scalar);
	}
	
	public Float3 divI(float scalar)
	{
		resetNorms();
		x = x/scalar;
		y = y/scalar;
		z = z/scalar;
		return this;
	}

	@Override
	public Float3 mult(float scalar)
	{
		return new Float3(x*scalar, y*scalar, z*scalar);
	}

	@Override
	public Float3 add(Float3 storage)
	{
		return new Float3(x+storage.x, y+storage.y, z+storage.z);
	}
	
	public Float3 addI(Float2 storage)
	{
		resetNorms();
		x += storage.getX();
		y += storage.getY();
		return this;
	}

	@Override
	public Float3 sub(Float3 storage)
	{
		return new Float3(x-storage.x, y-storage.y, z-storage.z);
	}
	
	public Float3 subI(Float2 storage)
	{
		resetNorms();
		x -= storage.getX();
		y -= storage.getY();
		return this;
	}

	@Override
	public Float3 div(Float3 storage)
	{
		return new Float3(x/storage.x, y/storage.y, z/storage.z);
	}

	@Override
	public Float3 mult(Float3 storage)
	{
		return new Float3(x*storage.x, y*storage.y, z*storage.z);
	}

	@Override
	public float dot(Float3 storage)
	{
		return (x*storage.x) + (y*storage.y) + (z*storage.z);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}
	
	@Override
	public float norm()
	{
		if (norm == -1.0f) {
			norm = (float) Math.sqrt(normSquared());
		} 
		return norm;
	}
	
	public float normOfTwo()
	{
		return (float) Math.sqrt( x*x + y*y );
	}

	@Override
	public Float3 normalise()
	{
		if (normalisedStorage == null) {
			normalisedStorage = div(norm());
		}
		return normalisedStorage;
	}

	@Override
	public Float3 negate()
	{
		return new Float3(-x, -y, -z);
	}

	@Override
	public float sum()
	{
		return x+y+z;
	}

	public Float3 cross(Float3 storage)
	{
        return new Float3(
                y * storage.z - z * storage.y,
                z * storage.x - x * storage.z,
                x * storage.y - y * storage.x);
	}
	
	public Float2 getFloat2()
	{
		return new Float2(x, y);
	}
	
	private void set(float value)
	{
		this.x = value;
		this.y = value;
		this.z = value;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public void setZ(float z)
	{
		this.z = z;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	/**
	 * Turn this storage into a matrix, then multiply this matrix with its transpose matrix.
	 * G = V_T . V
	 * Which equals to:
	   [x	x [x	y	z]
	    y
	    z]
	 * @return Matrix4f
	 */
	public Matrix3f getGramianMatrix()
	{
		return new Matrix3f(x*x, x*y, x*z,
							y*x, y*y, y*z,
							z*x, z*y, z*z);
	}
	
	public Float3 copy()
	{
		return new Float3(x, y, z);
	}
	
	private void resetNorms()
	{
		norm = -1.0f;
		normalisedStorage = null;
	}
	
	@Override
	public float get(int index)
	{
		switch (index) {
			case 0:
				return x;
			case 1:
				return y;
			case 2:
				return z;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float3 - get("+index+")");
		}
	}

	@Override
	public int getSize()
	{
		return 3;
	}
	
	public void clear()
	{
		resetNorms();
		set(0.0f);
	}
	
	@Override
	public String toString()
	{
		return "Float3 storage values: " + x + ", " + y
					+ ", " + z;
	}
}
