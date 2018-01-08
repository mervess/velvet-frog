package storage;

import matrix.Matrix3f;

public class Float3 implements IStorage<Float3>
{
	private float x;
	private float y;
	private float z;
	
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
	
	/**
	 * Cross product 
	 * 
	 * @param storage
	 * @return
	 */
	public Float3 cross(Float3 storage)
	{
        return new Float3(
                y * storage.z - z * storage.y,
                z * storage.x - x * storage.z,
                x * storage.y - y * storage.x);
	}

	@Override
	public Float3 add(Float3 storage)
	{
		return new Float3(x+storage.x, y+storage.y, z+storage.z);
	}
	
	public Float3 addI(Float3 storage)
	{
		x += storage.getX();
		y += storage.getY();
		z += storage.getZ();
		return this;
	}
	
	public Float3 addI(Float2 storage)
	{
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
	public float dot(Float3 storage)
	{
		return (x*storage.x) + (y*storage.y) + (z*storage.z);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}
	
	public float normOfHeadTwo()
	{
		return (float) Math.sqrt( x*x + y*y );
	}
	
	public float normOfTailTwo()
	{
		return (float) Math.sqrt( y*y + z*z );
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
	 * @return Matrix3f
	 */
	public Matrix3f getGramianMatrix()
	{
		return new Matrix3f(x*x, x*y, x*z,
							y*x, y*y, y*z,
							z*x, z*y, z*z);
	}
	
	/**
	 * Influenced by Eigen's OrthoMethods.h - run method in unitOrthogonal_selector<Derived,3>
	 * 
	 * XXX qglviewer and apache's commons-math also have this method. In any problem, you can check these implementations.
	 * http://wiki.icub.org/italk/dox/html/vec_8cpp_source.html -> qglviewer's vec.cpp
	 * @return
	 */
	public Float3 unitOrthogonal()
	{
		Float3 orthogonal;
		
		if (!isMuchSmallerThan(x, z) || !isMuchSmallerThan(y, z)) {
			float invnm = 1.0f / normOfHeadTwo();
			orthogonal = new Float3(-y*invnm, x*invnm, 0.0f);
		} else {
			float invnm = 1.0f / normOfTailTwo();
			orthogonal = new Float3(0.0f, -z*invnm, y*invnm);
		}
		
		return orthogonal;
	}
	
	/**
     * This function is inspired by vcglib's ei_isMuchSmallerThan(float {...}).
     * http://docs.ros.org/electric/api/vcglib/html/MathFunctions_8h_source.html -> vcglib's MathFunctions.h
     * It is also relevant to Eigen's MathFunctions.h
     * 1e-5f =  precision<float>()
     * @param scalar1
     * @param scalar2
     * @return
     */
    public static boolean isMuchSmallerThan(float scalar1, float scalar2)
    {
    	return Math.abs(scalar1) 
    				<= Math.abs(scalar2) * 1e-5f;
    }
	
	public Float3 copy()
	{
		return new Float3(x, y, z);
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
		set(0.0f);
	}
	
	@Override
	public String toString()
	{
		return 
				"Float3[" + 
				x + ", " + y + ", " + z
				+ "]";
	}
}
