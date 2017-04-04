package storage;

import matrix.Matrix4f;

public class Float4 implements IStorage<Float4>
{
	private float x;
	private float y;
	private float z;
	private float w;
	
	private static float norm;
	private static Float4 normalisedStorage;
	
	public Float4(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		
		resetNorms();
	}
	
	public Float4(float value)
	{
		x = value;
		y = value;
		z = value;
		w = value;
		
		resetNorms();
	}
	
	@Override
	public Float4 add(float scalar)
	{
		return new Float4(x+scalar, y+scalar, z+scalar, w+scalar);
	}

	@Override
	public Float4 sub(float scalar)
	{
		return new Float4(x-scalar, y-scalar, z-scalar, w-scalar);
	}

	@Override
	public Float4 div(float scalar)
	{
		return new Float4(x/scalar, y/scalar, z/scalar, w/scalar);
	}
	
	public void divI(float scalar)
	{
		x = x/scalar;
		y = y/scalar;
		z = z/scalar;
		w = w/scalar;
		
		resetNorms();
	}

	@Override
	public Float4 mult(float scalar)
	{
		return new Float4(x*scalar, y*scalar, z*scalar, w*scalar);
	}

	@Override
	public Float4 add(Float4 storage)
	{
		return new Float4(x+storage.x, y+storage.y, 
						  z+storage.z, w+storage.w);
	}

	@Override
	public Float4 sub(Float4 storage)
	{
		return new Float4(x-storage.x, y-storage.y, 
				  		  z-storage.z, w-storage.w);
	}
	
	public void subI(Float4 storage)
	{
		x = x-storage.x; 
		y = y-storage.y; 
		z = z-storage.z; 
		w = w-storage.w;
		
		resetNorms();
	}

	@Override
	public Float4 div(Float4 storage)
	{
		return new Float4(x/storage.x, y/storage.y, 
				  		  z/storage.z, w/storage.w);
	}

	@Override
	public Float4 mult(Float4 storage)
	{
		return new Float4(x*storage.x, y*storage.y, 
				  		  z*storage.z, w*storage.w);
	}

	@Override
	public float dot(Float4 storage)
	{
		return (x*storage.x) + (y*storage.y) + 
		  		  (z*storage.z) + (w*storage.w);
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

	@Override
	public Float4 normalise()
	{
		if (normalisedStorage == null) {
			normalisedStorage = div(norm());
		}
		return normalisedStorage;
	}

	@Override
	public Float4 negate()
	{
		return new Float4(-x, -y, -z, -w);
	}

	@Override
	public float sum()
	{
		return x+y+z+w;
	}

	public Float2 getFloat2()
	{
		return new Float2(x, y);
	}
	
	public Float3 getFloat3()
	{
		return new Float3(x, y, z);
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
	
	public float getW()
	{
		return w;
	}
	
	/**
	 * Turn this storage into a matrix, then multiply this matrix with its transpose matrix.
	 * G = V_T . V
	 * Which equals to:
	   [x	x [x	y	z	w]
	    y
	    z
	    w]
	 * @return Matrix4f
	 */
	public Matrix4f getGramianMatrix()
	{
		return new Matrix4f(x*x, x*y, x*z, x*w,
							y*x, y*y, y*z, y*w,
							z*x, z*y, z*z, z*w,
							w*x, w*y, w*z, w*w);
	}
	
	@Override
	public String toString()
	{
		return "Float4 storage values: " + x + ", " + y
					+ ", " + z + ", " + w;
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
			case 3:
				return w;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float4 - get("+index+")");
		}
	}
	
	private void resetNorms()
	{
		norm = -1.0f;
		normalisedStorage = null;
	}

	@Override
	public int getSize()
	{
		return 4;
	}
}
