package storage;

import matrix.Matrix6f;
import matrix.MatrixXf;
import vector.VecXf;

public class Float6 implements IStorage<Float6>
{
	private float f0, f1, f2, f3, f4, f5;

	private static float norm;
	private static Float6 normalisedStorage;

	public Float6(Float3 first, Float3 second)
	{
		f0 = first.getX();
		f1 = first.getY();
		f2 = first.getZ();

		f3 = second.getX();
		f4 = second.getY();
		f5 = second.getZ();
		
		resetNorms();
	}

	public Float6(float value)
	{
		f0 = value;
		f1 = value;
		f2 = value;

		f3 = value;
		f4 = value;
		f5 = value;
		
		resetNorms();
	}

	public Float6(float f0, float f1, float f2, float f3, float f4, float f5)
	{
		this.f0 = f0;
		this.f1 = f1;
		this.f2 = f2;

		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		
		resetNorms();
	}

	@Override
	public Float6 add(float scalar)
	{
		return new Float6(f0+scalar, f1+scalar, f2+scalar, f3+scalar, f4+scalar, f5+scalar);
	}

	@Override
	public Float6 sub(float scalar)
	{
		return new Float6(f0-scalar, f1-scalar, f2-scalar, f3-scalar, f4-scalar, f5-scalar);
	}
	
	/**
	 * Subtract a scalar value and assign the result to itself
	 * @param scalar
	 */
	public void subI(float scalar)
	{
		f0 = f0-scalar; 
		f1 = f1-scalar; 
		f2 = f2-scalar; 
		f3 = f3-scalar; 
		f4 = f4-scalar; 
		f5 = f5-scalar;
		
		resetNorms();
	}
	
	public Float6 subI(int index, float scalar)
	{
		resetNorms();
		
		switch (index) {
			case 0:
				f0 -= scalar;
				break;
			case 1:
				f1 -= scalar;
				break;
			case 2:
				f2 -= scalar;
				break;
			case 3:
				f3 -= scalar;
				break;
			case 4:
				f4 -= scalar;
				break;
			case 5:
				f5 -= scalar;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float6 - subI("+index+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Float6 div(float scalar)
	{
		return new Float6(f0/scalar, f1/scalar, f2/scalar, f3/scalar, f4/scalar, f5/scalar);
	}
	
	/**
	 * Divide by scalar value and assign the result to itself
	 * @param scalar
	 */
	public void divI(float scalar)
	{
		f0 = f0/scalar; 
		f1 = f1/scalar; 
		f2 = f2/scalar; 
		f3 = f3/scalar; 
		f4 = f4/scalar; 
		f5 = f5/scalar;
		
		resetNorms();
	}
	
	public Float6 divI(int index, float scalar)
	{
		resetNorms();
		
		switch (index) {
			case 0:
				f0 /= scalar;
				break;
			case 1:
				f1 /= scalar;
				break;
			case 2:
				f2 /= scalar;
				break;
			case 3:
				f3 /= scalar;
				break;
			case 4:
				f4 /= scalar;
				break;
			case 5:
				f5 /= scalar;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float6 - divI("+index+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Float6 mult(float scalar)
	{
		return new Float6(f0*scalar, f1*scalar, f2*scalar, f3*scalar, f4*scalar, f5*scalar);
	}

	@Override
	public Float6 add(Float6 storage)
	{
		return new Float6(f0+storage.f0, f1+storage.f1, f2+storage.f2, 
						  f3+storage.f3, f4+storage.f4, f5+storage.f5);
	}

	@Override
	public Float6 sub(Float6 storage)
	{
		return new Float6(f0-storage.f0, f1-storage.f1, f2-storage.f2, 
				  		  f3-storage.f3, f4-storage.f4, f5-storage.f5);
	}
	
	/**
	 * Subtract a Float6 storage and assign the result to itself
	 * @param storage
	 */
	public void subI(Float6 storage)
	{
		f0 = f0-storage.f0; 
		f1 = f1-storage.f1; 
		f2 = f2-storage.f2; 
		f3 = f3-storage.f3; 
		f4 = f4-storage.f4; 
		f5 = f5-storage.f5;
		
		resetNorms();
	}

	@Override
	public Float6 div(Float6 storage)
	{
		return new Float6(f0/storage.f0, f1/storage.f1, f2/storage.f2, 
				  		  f3/storage.f3, f4/storage.f4, f5/storage.f5);
	}

	@Override
	public Float6 mult(Float6 storage)
	{
		return new Float6(f0*storage.f0, f1*storage.f1, f2*storage.f2, 
				  		  f3*storage.f3, f4*storage.f4, f5*storage.f5);
	}

	@Override
	public float dot(Float6 storage)
	{
		return (f0*storage.f0) + (f1*storage.f1) + (f2*storage.f2) + 
		  	   		(f3*storage.f3) + (f4*storage.f4) + (f5*storage.f5);
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
	public Float6 normalise()
	{
		if (normalisedStorage == null) {
			normalisedStorage = div(norm());
		}
		return normalisedStorage;
	}

	@Override
	public Float6 negate()
	{
		return new Float6(-f0, -f1, -f2, -f3, -f4, -f5);
	}

	@Override
	public float sum()
	{
		return f0+f1+f2+f3+f4+f5;
	}
	
	/**
	 * Turn this storage into a matrix, then multiply this matrix with its transpose matrix.
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
		return new Matrix6f(f0*f0, f0*f1, f0*f2, f0*f3, f0*f4, f0*f5,
							f1*f0, f1*f1, f1*f2, f1*f3, f1*f4, f1*f5,
							f2*f0, f2*f1, f2*f2, f2*f3, f2*f4, f2*f5,
							f3*f0, f3*f1, f3*f2, f3*f3, f3*f4, f3*f5,
							f4*f0, f4*f1, f4*f2, f4*f3, f4*f4, f4*f5,
							f5*f0, f5*f1, f5*f2, f5*f3, f5*f4, f5*f5);
	}
	
	public float getF0()
	{
		return f0;
	}

	public float getF1()
	{
		return f1;
	}

	public float getF2()
	{
		return f2;
	}

	public float getF3()
	{
		return f3;
	}

	public float getF4()
	{
		return f4;
	}

	public float getF5()
	{
		return f5;
	}

	@Override
	public float get(int index)
	{
		switch (index) {
			case 0:
				return f0;
			case 1:
				return f1;
			case 2:
				return f2;
			case 3:
				return f3;
			case 4:
				return f4;
			case 5:
				return f5;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float6 - get("+index+")");
		}
	}
	
	public Float6 set(int index, float value)
	{
		switch (index) {
			case 0:
				f0 = value;
				break;
			case 1:
				f1 = value;
				break; 
			case 2:
				f2 = value;
				break;
			case 3:
				f3 = value;
				break;
			case 4:
				f4 = value;
				break;
			case 5:
				f5 = value;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float6 - set("+index+", "+value+")");
		}
		return this;
	}
	
	public Float3 getFloat3(int start)
	{
		switch (start) {
			case 0:
				return new Float3(f0, f1, f2);
			case 1:
				return new Float3(f1, f2, f3);
			case 2:
				return new Float3(f2, f3, f4);
			case 3:
				return new Float3(f3, f4, f5);
			default:
				throw new ArrayIndexOutOfBoundsException("Float6 - getFloat3("+start+")");
		}
	}
	
	public Float6 swap(int index1, int index2)
	{
        final float temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
        return this;
    }
	
	public float[] slice(int from, int to)
	{
		final float[] slice = new float[to-from];
		int index = 0;
		
		switch (from) {
			case 0:
				slice[index++] = f0;
			case 1:
				if (index == slice.length) {
					break;
				}
				slice[index++] = f1;
			case 2:
				if (index == slice.length) {
					break;
				}
				slice[index++] = f2;
			case 3:
				if (index == slice.length) {
					break;
				}
				slice[index++] = f3;
			case 4:
				if (index == slice.length) {
					break;
				}
				slice[index++] = f4;
			case 5:
				if (index == slice.length) {
					break;
				}
				slice[index++] = f5;
		}
		
		return slice;
	}
	
	private void resetNorms()
	{
		norm = -1.0f;
		normalisedStorage = null;
	}
	
	public void clear()
	{
		f0 = 0.0f;
		f1 = 0.0f;
		f2 = 0.0f;

		f3 = 0.0f;
		f4 = 0.0f;
		f5 = 0.0f;
		
		resetNorms();
	}

	@Override
	public int getSize()
	{
		return 6;
	}
	
	public Float6 copy()
	{
		return new Float6(f0, f1, f2, f3, f4, f5);
	}
	
	public VecXf toVecXf()
	{
		return new VecXf( new float[] {f0, f1, f2, f3, f4, f5} );
	}
	
	public Matrix6f toMatrix6f()
	{
		return new Matrix6f( new float[] {
									f0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
									f1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
	}
	
	public MatrixXf toMatrixXf()
	{
		return new MatrixXf(6, 6, new float[] {
									f0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
									f1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
									f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
	}
	
	@Override
	public String toString()
	{
		return "Float6 storage values: " + f0 + ", " + f1 + ", " + f2
				+ ", " + f3 + ", " + f4 + ", " + f5;
	}
}
