package vector;

import matrix.Matrix6f;

public class Vector6f implements IVector<Vector6f>
{
	private float[] x = new float[6];

	public Vector6f()
	{
		this(0);
	}
	
	public Vector6f(Vector3f first, Vector3f second)
	{
		x[0] = first.get(0);
		x[1] = first.get(1);
		x[2] = first.get(2);
		x[3] = second.get(0);
		x[4] = second.get(1);
		x[5] = second.get(2);
	}

	public Vector6f(float value)
	{
		x[0] = value;
		x[1] = value;
		x[2] = value;
		x[3] = value;
		x[4] = value;
		x[5] = value;
	}

	public Vector6f(float f0, float f1, float f2, float f3, float f4, float f5)
	{
		this.x[0] = f0;
		this.x[1] = f1;
		this.x[2] = f2;
		this.x[3] = f3;
		this.x[4] = f4;
		this.x[5] = f5;
	}

	@Override
	public Vector6f add(float scalar)
	{
		return new Vector6f(x[0]+scalar, x[1]+scalar, x[2]+scalar, x[3]+scalar, x[4]+scalar, x[5]+scalar);
	}

	@Override
	public Vector6f sub(float scalar)
	{
		return new Vector6f(x[0]-scalar, x[1]-scalar, x[2]-scalar, x[3]-scalar, x[4]-scalar, x[5]-scalar);
	}
	
	/**
	 * Subtract a scalar value and assign the result to itself
	 * @param scalar
	 */
	public Vector6f subI(float scalar)
	{
		x[0] = x[0]-scalar; 
		x[1] = x[1]-scalar; 
		x[2] = x[2]-scalar; 
		x[3] = x[3]-scalar; 
		x[4] = x[4]-scalar; 
		x[5] = x[5]-scalar;
		return this;
	}
	
	public Vector6f subI(int index, float scalar)
	{
		x[index] -= scalar;
		return this;
	}

	@Override
	public Vector6f div(float scalar)
	{
		return new Vector6f(x[0]/scalar, x[1]/scalar, x[2]/scalar, x[3]/scalar, x[4]/scalar, x[5]/scalar);
	}
	
	/**
	 * Divide by scalar value and assign the result to itself
	 * @param scalar
	 */
	public Vector6f divI(float scalar)
	{
		x[0] /= scalar; 
		x[1] /= scalar; 
		x[2] /= scalar; 
		x[3] /= scalar; 
		x[4] /= scalar; 
		x[5] /= scalar;
		return this;
	}
	
	public Vector6f divI(int index, float scalar)
	{
		x[index] /= scalar;
		return this;
	}

	@Override
	public Vector6f mult(float scalar)
	{
		return new Vector6f(x[0]*scalar,
							x[1]*scalar, 
							x[2]*scalar, 
							x[3]*scalar, 
							x[4]*scalar, 
							x[5]*scalar);
	}

	@Override
	public Vector6f add(Vector6f otherVector)
	{
		return new Vector6f(x[0]+otherVector.x[0], 
							x[1]+otherVector.x[1],
							x[2]+otherVector.x[2], 
						    x[3]+otherVector.x[3], 
							x[4]+otherVector.x[4], 
							x[5]+otherVector.x[5]);
	}

	@Override
	public Vector6f sub(Vector6f otherVector)
	{
		return new Vector6f(x[0]-otherVector.x[0], 
							x[1]-otherVector.x[1], 
							x[2]-otherVector.x[2], 
							x[3]-otherVector.x[3], 
							x[4]-otherVector.x[4], 
							x[5]-otherVector.x[5]);
	}
	
	/**
	 * Subtract a Float6 otherVector and assign the result to itself
	 * @param otherVector
	 */
	public Vector6f subI(Vector6f otherVector)
	{
		x[0] -= otherVector.x[0]; 
		x[1] -= otherVector.x[1]; 
		x[2] -= otherVector.x[2]; 
		x[3] -= otherVector.x[3]; 
		x[4] -= otherVector.x[4]; 
		x[5] -= otherVector.x[5];
		return this;
	}

	@Override
	public Vector6f div(Vector6f otherVector)
	{
		return new Vector6f(x[0]/otherVector.x[0], 
							x[1]/otherVector.x[1], 
							x[2]/otherVector.x[2], 
							x[3]/otherVector.x[3], 
							x[4]/otherVector.x[4],
							x[5]/otherVector.x[5]);
	}

	@Override
	public float dot(Vector6f otherVector)
	{
		return  (x[0]*otherVector.x[0]) + 
				(x[1]*otherVector.x[1]) + 
				(x[2]*otherVector.x[2]) + 
				(x[3]*otherVector.x[3]) +
				(x[4]*otherVector.x[4]) + 
				(x[5]*otherVector.x[5]);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}

	@Override
	public Vector6f negate()
	{
		return new Vector6f(-x[0], -x[1], -x[2], -x[3], -x[4], -x[5]);
	}

	@Override
	public float sum()
	{
		return  x[0]+
				x[1]+
				x[2]+
				x[3]+
				x[4]+
				x[5];
	}
	
	/**
	 * Turn this otherVector into a matrix, then multiply this matrix with its transpose matrix.
	 * G = V_T . V
	 * Which equals to:
	   [f0	x [f0	f1	f2	f3	f4	f5]
	    f1
	    f2
	    f3
	    f4
	    f5]
	 * @return Matrix6f
	 */
	public Matrix6f getGramianMatrix()
	{
		return new Matrix6f(x[0]*x[0], x[0]*x[1], x[0]*x[2], x[0]*x[3], x[0]*x[4], x[0]*x[5],
							x[1]*x[0], x[1]*x[1], x[1]*x[2], x[1]*x[3], x[1]*x[4], x[1]*x[5],
							x[2]*x[0], x[2]*x[1], x[2]*x[2], x[2]*x[3], x[2]*x[4], x[2]*x[5],
							x[3]*x[0], x[3]*x[1], x[3]*x[2], x[3]*x[3], x[3]*x[4], x[3]*x[5],
							x[4]*x[0], x[4]*x[1], x[4]*x[2], x[4]*x[3], x[4]*x[4], x[4]*x[5],
							x[5]*x[0], x[5]*x[1], x[5]*x[2], x[5]*x[3], x[5]*x[4], x[5]*x[5]);
	}

	@Override
	public float get(int index)
	{
		return x[index];
	}
	
	public void set(int index, float value)
	{
		x[index] = value;
	}
	
	public void setScalar(float value)
	{
		x[0] = value;
		x[1] = value;
		x[2] = value;
		x[3] = value;
		x[4] = value;
		x[5] = value;
	}
	
	public Vector3f getFloat3(int start)
	{
		switch (start) {
			case 0:	return new Vector3f(x[0], x[1], x[2]);
			case 1:	return new Vector3f(x[1], x[2], x[3]);
			case 2:	return new Vector3f(x[2], x[3], x[4]);
			case 3:	return new Vector3f(x[3], x[4], x[5]);
			default:
				throw new ArrayIndexOutOfBoundsException("Float6 - getFloat3("+start+")");
		}
	}
	
	public Vector6f swap(int index1, int index2)
	{
        final float temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
        return this;
    }
	
	// Non-inclusive
	// slice(0,2) returns elements 0 and 1
	public float[] slice(int from, int to)
	{
		final float[] slice = new float[to-from];
		int index = 0;
		
		switch (from) {
			case 0:
				slice[index++] = x[0];
			case 1:
				if (index == slice.length) {
					break;
				}
				slice[index++] = x[1];
			case 2:
				if (index == slice.length) {
					break;
				}
				slice[index++] = x[2];
			case 3:
				if (index == slice.length) {
					break;
				}
				slice[index++] = x[3];
			case 4:
				if (index == slice.length) {
					break;
				}
				slice[index++] = x[4];
			case 5:
				if (index == slice.length) {
					break;
				}
				slice[index++] = x[5];
		}
		
		return slice;
	}
	
	public void clear()
	{
		this.setScalar(0.0f);
	}

	@Override
	public int getSize()
	{
		return 6;
	}
	
	public Vector6f copy()
	{
		return new Vector6f(x[0], 
							x[1], 
							x[2], 
							x[3], 
							x[4], 
							x[5]);
	}
	
	// public Matrix6f toMatrix6f()
	// {
	// 	return new Matrix6f( new float[] {
	// 								f0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
	// 								f1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
	// }
	
	// public MatrixXf toMatrixXf()
	// {
	// 	return new MatrixXf(6, 6, new float[] {
	// 								f0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
	// 								f1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
	// 								f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
	// }
	
	@Override
	public String toString()
	{
		return "Float6 values: " + x[0] + ", " + 
								   x[1] + ", " + 
								   x[2] + ", " + 
								   x[3] + ", " + 
								   x[4] + ", " + 
								   x[5];
	}
}
