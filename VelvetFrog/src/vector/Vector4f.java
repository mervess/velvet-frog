package vector;

import matrix.Matrix4f;

public class Vector4f implements IVector<Vector4f>
{
	private float[] x = new float[4];
	
	public Vector4f(float x, float y, float z, float w)
	{
		this.x[0] = x;
		this.x[1] = y;
		this.x[2] = z;
		this.x[3] = w;
	}
	
	public Vector4f(float value)
	{
		setScalar(value);
	}
	
	@Override
	public Vector4f add(float scalar)
	{
		return new Vector4f(x[0]+scalar, x[1]+scalar, x[2]+scalar, x[3]+scalar);
	}

	@Override
	public Vector4f sub(float scalar)
	{
		return new Vector4f(x[0]-scalar, x[1]-scalar, x[2]-scalar, x[3]-scalar);
	}

	@Override
	public Vector4f div(float scalar)
	{
		return new Vector4f(x[0]/scalar, x[1]/scalar, x[2]/scalar, x[3]/scalar);
	}
	
	public Vector4f divI(float scalar)
	{
		x[0] = x[0]/scalar;
		x[1] = x[1]/scalar;
		x[2] = x[2]/scalar;
		x[3] = x[3]/scalar;
		return this;
	}

	@Override
	public Vector4f mult(float scalar)
	{
		return new Vector4f(x[0]*scalar, x[1]*scalar, x[2]*scalar, x[3]*scalar);
	}

	@Override
	public Vector4f add(Vector4f otherVector)
	{
		return new Vector4f(x[0]+otherVector.x[0], x[1]+otherVector.x[1], 
						    x[2]+otherVector.x[2], x[3]+otherVector.x[3]);
	}

	@Override
	public Vector4f sub(Vector4f otherVector)
	{
		return new Vector4f(x[0]-otherVector.x[0], x[1]-otherVector.x[1], 
				  		    x[2]-otherVector.x[2], x[3]-otherVector.x[3]);
	}
	
	public Vector4f subI(Vector4f otherVector)
	{
		x[0] = x[0]-otherVector.x[0]; 
		x[1] = x[1]-otherVector.x[1]; 
		x[2] = x[2]-otherVector.x[2]; 
		x[3] = x[3]-otherVector.x[3];
		return this;
	}

	@Override
	public Vector4f div(Vector4f otherVector)
	{
		return new Vector4f(x[0]/otherVector.x[0], x[1]/otherVector.x[1], 
				  		    x[2]/otherVector.x[2], x[3]/otherVector.x[3]);
	}

	@Override
	public float dot(Vector4f otherVector)
	{
		return (x[0]*otherVector.x[0]) + 
			   (x[1]*otherVector.x[1]) + 
			   (x[2]*otherVector.x[2]) + 
			   (x[3]*otherVector.x[3]);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}
	
	@Override
	public Vector4f negate()
	{
		return new Vector4f(-x[0], -x[1], -x[2], -x[3]);
	}

	@Override
	public float sum()
	{
		return x[0]+x[1]+x[2]+x[3];
	}

	private void setScalar(float value)
	{
		this.x[0] = value;
		this.x[1] = value;
		this.x[2] = value;
		this.x[3] = value;
	}

	public Vector2f getVector2f()
	{
		return new Vector2f(x[0], x[1]);
	}
	
	public Vector3f getVector3f()
	{
		return new Vector3f(x[0], x[1], x[2]);
	}
	
	/**
	 * Turn this otherVector into a matrix, then multiply this matrix with its transpose matrix.
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
		return new Matrix4f(x[0]*x[0], x[0]*x[1], x[0]*x[2], x[0]*x[3],
							x[1]*x[0], x[1]*x[1], x[1]*x[2], x[1]*x[3],
							x[2]*x[0], x[2]*x[1], x[2]*x[2], x[2]*x[3],
							x[3]*x[0], x[3]*x[1], x[3]*x[2], x[3]*x[3]);
	}
	
	@Override
	public String toString()
	{
		return "Float4 otherVector values: " + x[0] + ", " + x[1]
					+ ", " + x[2] + ", " + x[3];
	}

	@Override
	public float get(int index)
	{
		return x[index];
	}
	
	@Override
	public int getSize()
	{
		return 4;
	}
	
	public Vector4f copy()
	{
		return new Vector4f(x[0], x[1], x[2], x[3]);
	}
}
