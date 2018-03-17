package vector;

public class Vector7f implements IVector<Vector7f>
{
	private float[] x = new float[7];
	
	public Vector7f(Vector3f first, Vector4f second)
	{
		x[0] = first.get(0);
		x[1] = first.get(1);
		x[2] = first.get(2);
		x[3] = second.get(0);
		x[4] = second.get(1);
		x[5] = second.get(2);
		x[6] = second.get(3);
	}
	
	public Vector7f(float value)
	{
		x[0] = value;
		x[1] = value;
		x[2] = value;
		x[3] = value;
		x[4] = value;
		x[5] = value;
		x[6] = value;
	}
	
	public Vector7f(float f0, float f1, float f2, float f3, 
				    float f4, float f5, float f6)
	{
		this.x[0] = x[0];
		this.x[1] = x[1];
		this.x[2] = x[2];
		this.x[3] = x[3];
		this.x[4] = x[4];
		this.x[5] = x[5];
		this.x[6] = x[6];
	}
	
	@Override
	public Vector7f add(float scalar)
	{
		return new Vector7f(x[0]+scalar, 
							x[1]+scalar, 
							x[2]+scalar, 
							x[3]+scalar, 
							x[4]+scalar, 
							x[5]+scalar, 
							x[6]+scalar);
	}
	
	public Vector7f addI(int index, float scalar)
	{
		x[index] += scalar;
		return this;
	}

	@Override
	public Vector7f sub(float scalar)
	{
		return new Vector7f(x[0]-scalar, 
							x[1]-scalar, 
							x[2]-scalar, 
							x[3]-scalar, 
							x[4]-scalar, 
							x[5]-scalar, 
							x[6]-scalar);
	}
	
	public Vector7f subI(int index, float scalar)
	{
		x[index] -= scalar;
		return this;
	}

	@Override
	public Vector7f div(float scalar)
	{
		return new Vector7f(x[0]/scalar, 
							x[1]/scalar, 
							x[2]/scalar, 
							x[3]/scalar, 
							x[4]/scalar, 
							x[5]/scalar, 
							x[6]/scalar);
	}
	
	public Vector7f divI(float scalar)
	{
		x[0] /= scalar; 
		x[1] /= scalar; 
		x[2] /= scalar; 
		x[3] /= scalar; 
		x[4] /= scalar; 
		x[5] /= scalar; 
		x[6] /= scalar;
		return this;
	}
	
	public Vector7f divI(int index, float scalar)
	{
		x[index] /= scalar;
		return this;
	}

	@Override
	public Vector7f mult(float scalar)
	{
		return new Vector7f(x[0]*scalar, 
							x[1]*scalar, 
							x[2]*scalar, 
							x[3]*scalar, 
							x[4]*scalar, 
							x[5]*scalar, 
							x[6]*scalar);
	}
	
	public Vector7f multI(float scalar)
	{
		x[0] *= scalar; 
		x[1] *= scalar; 
		x[2] *= scalar; 
		x[3] *= scalar; 
		x[4] *= scalar; 
		x[5] *= scalar; 
		x[6] *= scalar;
		return this;
	}

	@Override
	public Vector7f add(Vector7f otherVector)
	{
		return new Vector7f(x[0]+otherVector.x[0], 
							x[1]+otherVector.x[1], 
							x[2]+otherVector.x[2], 
							x[3]+otherVector.x[3], 
						  	x[4]+otherVector.x[4], 
							x[5]+otherVector.x[5], 
							x[6]+otherVector.x[6]);
	}

	@Override
	public Vector7f sub(Vector7f otherVector)
	{
		return new Vector7f(x[0]-otherVector.x[0], 
							x[1]-otherVector.x[1], 
							x[2]-otherVector.x[2], 
							x[3]-otherVector.x[3], 
		  				  	x[4]-otherVector.x[4], 
							x[5]-otherVector.x[5], 
							x[6]-otherVector.x[6]);
	}

	@Override
	public Vector7f div(Vector7f otherVector)
	{
		return new Vector7f(x[0]/otherVector.x[0], 
							x[1]/otherVector.x[1], 
							x[2]/otherVector.x[2], 
							x[3]/otherVector.x[3], 
		  				  	x[4]/otherVector.x[4], 
							x[5]/otherVector.x[5], 
							x[6]/otherVector.x[6]);
	}

	@Override
	public float dot(Vector7f otherVector)
	{
		return  (x[0]*otherVector.x[0]) + 
				(x[1]*otherVector.x[1]) + 
				(x[2]*otherVector.x[2]) + 
				(x[3]*otherVector.x[3]) + 
				(x[4]*otherVector.x[4]) + 
				(x[5]*otherVector.x[5]) + 
				(x[6]*otherVector.x[6]);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}

	@Override
	public Vector7f negate()
	{
		return new Vector7f(-x[0], -x[1], -x[2], -x[3], -x[4], -x[5], -x[6]);
	}

	@Override
	public float sum()
	{
		return x[0]+x[1]+x[2]+x[3]+x[4]+x[5]+x[6];
	}
	
	/**
	 * Returns a Float3 otherVector depending on start index in Float7
	 * @param start
	 * @return
	 */
	public Vector3f getFloat3(int start)
	{
		switch (start) {
			case 0: return new Vector3f(x[0], x[1], x[2]);
			case 1:	return new Vector3f(x[1], x[2], x[3]);
			case 2:	return new Vector3f(x[2], x[3], x[4]);
			case 3:	return new Vector3f(x[3], x[4], x[5]);
			case 4:	return new Vector3f(x[4], x[5], x[6]);
			default:
				throw new ArrayIndexOutOfBoundsException("Float7 - getFloat3("+start+")");
		}
	}
	
	public Vector4f getFloat4(int start)
	{
		switch (start) {
			case 0:	return new Vector4f(x[0], x[1], x[2], x[3]);
			case 1:	return new Vector4f(x[1], x[2], x[3], x[4]);
			case 2:	return new Vector4f(x[2], x[3], x[4], x[5]);
			case 3: return new Vector4f(x[3], x[4], x[5], x[6]);
			default:
				throw new ArrayIndexOutOfBoundsException("Float7 - getFloat4("+start+")");
		}
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
	
	public void set(int index, Vector6f float6)
	{
		switch (index) {
			case 0:
				x[0] = float6.get(0);
				x[1] = float6.get(1);
				x[2] = float6.get(2);
				x[3] = float6.get(3);
				x[4] = float6.get(4);
				x[5] = float6.get(5);
				break;
			case 1:
				x[1] = float6.get(0);
				x[2] = float6.get(1);
				x[3] = float6.get(2);
				x[4] = float6.get(3);
				x[5] = float6.get(4);
				x[6] = float6.get(5);
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - set("+index+", "+float6.toString()+")");
		}
	}
	
	public Vector7f swap(int index1, int index2)
	{
        final float temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
        return this;
    }
	
	@Override
	public int getSize()
	{
		return 7;
	}
	
	public Vector7f copy()
	{
		return new Vector7f(x[0], x[1], x[2], x[3], x[4], x[5], x[6]);
	}
	
	public void clear()
	{
		x[0] = 0.0f;
		x[1] = 0.0f;
		x[2] = 0.0f;
		x[3] = 0.0f;
		x[4] = 0.0f;
		x[5] = 0.0f;
		x[6] = 0.0f;
	}
	
	@Override
	public String toString()
	{
		return "Float7 otherVector values: " + x[0] + ", " + 
											   x[1] + ", " + 
											   x[2] + ", " + 
											   x[3] + ", " + 
											   x[4] + ", " + 
											   x[5] + ", " + 
											   x[6];
	}
}
