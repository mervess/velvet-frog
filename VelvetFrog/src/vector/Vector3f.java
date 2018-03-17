package vector;

import matrix.Matrix3f;

public class Vector3f implements IVector<Vector3f>
{
	private float[] x = new float[3];
	
	public Vector3f(float value)
	{
		setScalar(value);
	}
	
	public Vector3f(float x, float y, float z)
	{
		this.x[0] = x;
		this.x[1] = y;
		this.x[2] = z;
	}
	
	@Override
	public Vector3f add(float scalar)
	{
		return new Vector3f(x[0]+scalar, x[1]+scalar, x[2]+scalar);
	}

	@Override
	public Vector3f sub(float scalar)
	{
		return new Vector3f(x[0]-scalar, x[1]-scalar, x[2]-scalar);
	}

	@Override
	public Vector3f div(float scalar)
	{
		return new Vector3f(x[0]/scalar, x[1]/scalar, x[2]/scalar);
	}
	
	public Vector3f divI(float scalar)
	{
		x[0] = x[0]/scalar;
		x[1] = x[1]/scalar;
		x[2] = x[2]/scalar;
		return this;
	}

	@Override
	public Vector3f mult(float scalar)
	{
		return new Vector3f(x[0]*scalar, x[1]*scalar, x[2]*scalar);
	}
	
	/**
	 * Cross product 
	 * 
	 * @param otherVector
	 * @return
	 */
	public Vector3f cross(Vector3f otherVector)
	{
        return new Vector3f(this.x[1] * otherVector.x[2] - this.x[2] * otherVector.x[1],
							this.x[2] * otherVector.x[0] - this.x[0] * otherVector.x[2],
							this.x[0] * otherVector.x[1] - this.x[1] * otherVector.x[0]);
	}

	@Override
	public Vector3f add(Vector3f otherVector)
	{
		return new Vector3f(x[0]+otherVector.x[0], x[1]+otherVector.x[1], x[2]+otherVector.x[2]);
	}
	
	public Vector3f addI(Vector3f otherVector)
	{
		x[0] += otherVector.x[0];
		x[1] += otherVector.x[1];
		x[2] += otherVector.x[2];
		return this;
	}
	
	public Vector3f addI(Vector2f otherVector)
	{
		x[0] += otherVector.get(0);
		x[1] += otherVector.get(1);
		return this;
	}

	@Override
	public Vector3f sub(Vector3f otherVector)
	{
		return new Vector3f(x[0]-otherVector.x[0], x[1]-otherVector.x[1], x[2]-otherVector.x[2]);
	}
	
	public Vector3f subI(Vector2f otherVector)
	{
		x[0] -= otherVector.get(0);
		x[1] -= otherVector.get(1);
		return this;
	}

	@Override
	public Vector3f div(Vector3f otherVector)
	{
		return new Vector3f(x[0]/otherVector.x[0], x[1]/otherVector.x[1], x[2]/otherVector.x[2]);
	}

	@Override
	public float dot(Vector3f otherVector)
	{
		return (x[0]*otherVector.x[0]) + (x[1]*otherVector.x[1]) + (x[2]*otherVector.x[2]);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}
	
	public float normOfHeadTwo()
	{
		return (float) Math.sqrt( x[0]*x[0] + x[1]*x[1] );
	}
	
	public float normOfTailTwo()
	{
		return (float) Math.sqrt( x[1]*x[1] + x[2]*x[2] );
	}

	@Override
	public Vector3f negate()
	{
		return new Vector3f(-x[0], -x[1], -x[2]);
	}

	@Override
	public float sum()
	{
		return x[0]+x[1]+x[2];
	}
	
	private void setScalar(float value)
	{
		this.x[0] = value;
		this.x[1] = value;
		this.x[2] = value;
	}
	
	public void set(int index, float value)
	{
		this.x[index] = value;
	}
	
	/**
	 * Turn this otherVector into a matrix, then multiply this matrix with its transpose matrix.
	 * G = V_T . V
	 * Which equals to:
	   [x	x [x	y	z]
	    y
	    z]
	 * @return Matrix3f
	 */
	public Matrix3f getGramianMatrix()
	{
		return new Matrix3f(x[0]*x[0], x[0]*x[1], x[0]*x[2],
							x[1]*x[0], x[1]*x[1], x[1]*x[2],
							x[2]*x[0], x[2]*x[1], x[2]*x[2]);
	}
	
	/**
	 * Influenced by Eigen's OrthoMethods.h - run method in unitOrthogonal_selector<Derived,3>
	 * 
	 * XXX qglviewer and apache's commons-math also have this method. In any problem, you can check these implementations.
	 * http://wiki.icub.org/italk/dox/html/vec_8cpp_source.html -> qglviewer's vec.cpp
	 * @return
	 */
	public Vector3f unitOrthogonal()
	{
		Vector3f orthogonal;
		
		if (!isMuchSmallerThan(x[0], x[2]) || !isMuchSmallerThan(x[1], x[2])) {
			float invnm = 1.0f / normOfHeadTwo();
			orthogonal = new Vector3f(-x[1]*invnm, x[0]*invnm, 0.0f);
		} else {
			float invnm = 1.0f / normOfTailTwo();
			orthogonal = new Vector3f(0.0f, -x[2]*invnm, x[1]*invnm);
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
    	return Math.abs(scalar1) <= Math.abs(scalar2) * 1e-5f;
    }
	
	public Vector3f copy()
	{
		return new Vector3f(x[0], x[1], x[2]);
	}
	
	@Override
	public float get(int index)
	{
		return x[index];
	}

	@Override
	public int getSize()
	{
		return 3;
	}
	
	public void clear()
	{
		setScalar(0.0f);
	}
	
	@Override
	public String toString()
	{
		return "Float3[" + x[0] + ", " + x[1] + ", " + x[2] + "]";
	}
}
