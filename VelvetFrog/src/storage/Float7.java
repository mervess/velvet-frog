package storage;

public class Float7 implements IStorage<Float7>
{
	private float f0, f1, f2, f3, f4, f5, f6;
	
	public Float7(Float3 first, Float4 second)
	{
		f0 = first.getX();
		f1 = first.getY();
		f2 = first.getZ();
		
		f3 = second.getX();
		f4 = second.getY();
		f5 = second.getZ();
		f6 = second.getW();
	}
	
	public Float7(float scalar)
	{
		this.f0 = scalar;
		this.f1 = scalar;
		this.f2 = scalar;
		
		this.f3 = scalar;
		this.f4 = scalar;
		this.f5 = scalar;
		this.f6 = scalar;
	}
	
	public Float7(float f0, float f1, float f2, float f3, 
				  float f4, float f5, float f6)
	{
		this.f0 = f0;
		this.f1 = f1;
		this.f2 = f2;
		
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
	}
	
	@Override
	public Float7 add(float scalar)
	{
		return new Float7(f0+scalar, f1+scalar, f2+scalar, f3+scalar, 
							f4+scalar, f5+scalar, f6+scalar);
	}
	
	public Float7 addI(int index, float scalar)
	{
		switch (index) {
			case 0:
				f0 += scalar;
				break;
			case 1:
				f1 += scalar;
				break;
			case 2:
				f2 += scalar;
				break;
			case 3:
				f3 += scalar;
				break;
			case 4:
				f4 += scalar;
				break;
			case 5:
				f5 += scalar;
				break;
			case 6:
				f6 += scalar;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - addI("+index+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Float7 sub(float scalar)
	{
		return new Float7(f0-scalar, f1-scalar, f2-scalar, f3-scalar, 
							f4-scalar, f5-scalar, f6-scalar);
	}
	
	public Float7 subI(int index, float scalar)
	{
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
			case 6:
				f6 -= scalar;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - subI("+index+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Float7 div(float scalar)
	{
		return new Float7(f0/scalar, f1/scalar, f2/scalar, f3/scalar, 
							f4/scalar, f5/scalar, f6/scalar);
	}
	
	public Float7 divI(float scalar)
	{
		f0 /= scalar; 
		f1 /= scalar; 
		f2 /= scalar; 
		f3 /= scalar; 
		f4 /= scalar; 
		f5 /= scalar; 
		f6 /= scalar;
		return this;
	}
	
	public Float7 divI(int index, float scalar)
	{
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
			case 6:
				f6 /= scalar;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - divI("+index+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Float7 mult(float scalar)
	{
		return new Float7(f0*scalar, f1*scalar, f2*scalar, f3*scalar, 
							f4*scalar, f5*scalar, f6*scalar);
	}
	
	public Float7 multI(float scalar)
	{
		f0 *= scalar; 
		f1 *= scalar; 
		f2 *= scalar; 
		f3 *= scalar; 
		f4 *= scalar; 
		f5 *= scalar; 
		f6 *= scalar;
		return this;
	}

	@Override
	public Float7 add(Float7 storage)
	{
		return new Float7(f0+storage.f0, f1+storage.f1, f2+storage.f2, f3+storage.f3, 
						  		f4+storage.f4, f5+storage.f5, f6+storage.f6);
	}

	@Override
	public Float7 sub(Float7 storage)
	{
		return new Float7(f0-storage.f0, f1-storage.f1, f2-storage.f2, f3-storage.f3, 
		  				  		f4-storage.f4, f5-storage.f5, f6-storage.f6);
	}

	@Override
	public Float7 div(Float7 storage)
	{
		return new Float7(f0/storage.f0, f1/storage.f1, f2/storage.f2, f3/storage.f3, 
		  				  		f4/storage.f4, f5/storage.f5, f6/storage.f6);
	}

	@Override
	public float dot(Float7 storage)
	{
		return (f0*storage.f0) + (f1*storage.f1) + (f2*storage.f2) + (f3*storage.f3) + 
					(f4*storage.f4) + (f5*storage.f5) + (f6*storage.f6);
	}

	@Override
	public float normSquared()
	{
		return dot(this);
	}

	@Override
	public Float7 negate()
	{
		return new Float7(-f0, -f1, -f2, -f3, -f4, -f5, -f6);
	}

	@Override
	public float sum()
	{
		return f0+f1+f2+f3+f4+f5+f6;
	}
	
	/**
	 * Returns a Float3 storage depending on start index in Float7
	 * @param start
	 * @return
	 */
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
			case 4:
				return new Float3(f4, f5, f6);
			default:
				throw new ArrayIndexOutOfBoundsException("Float7 - getFloat3("+start+")");
		}
	}
	
	public Float4 getFloat4(int start)
	{
		switch (start) {
			case 0:
				return new Float4(f0, f1, f2, f3);
			case 1:
				return new Float4(f1, f2, f3, f4);
			case 2:
				return new Float4(f2, f3, f4, f5);
			case 3:
				return new Float4(f3, f4, f5, f6);
			default:
				throw new ArrayIndexOutOfBoundsException("Float7 - getFloat4("+start+")");
		}
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

	public float getF6()
	{
		return f6;
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
			case 6:
				return f6;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - get("+index+")");
		}
	}
	
	public void set(int index, float value)
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
			case 6:
				f6 = value;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - set("+index+", "+value+")");
		}
	}
	
	public void set(int index, Float6 float6)
	{
		switch (index) {
			case 0:
				f0 = float6.getF0();
				f1 = float6.getF1();
				f2 = float6.getF2();
				f3 = float6.getF3();
				f4 = float6.getF4();
				f5 = float6.getF5();
				break;
			case 1:
				f1 = float6.getF0();
				f2 = float6.getF1();
				f3 = float6.getF2();
				f4 = float6.getF3();
				f5 = float6.getF4();
				f6 = float6.getF5();
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Float7 - set("+index+", "+float6.toString()+")");
		}
	}
	
	public Float7 swap(int index1, int index2)
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
	
	public Float7 copy()
	{
		return new Float7(f0, f1, f2, f3, f4, f5, f6);
	}
	
	public void clear()
	{
		f0 = 0.0f;
		f1 = 0.0f;
		f2 = 0.0f;

		f3 = 0.0f;
		f4 = 0.0f;
		f5 = 0.0f;
		f6 = 0.0f;
	}
	
	@Override
	public String toString()
	{
		return "Float7 storage values: " + f0 + ", " + f1 + ", " + f2
				+ ", " + f3 + ", " + f4 + ", " + f5 + ", " + f6;
	}
}
