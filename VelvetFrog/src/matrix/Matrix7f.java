package matrix;

//import Jama.Matrix;
import vector.Vector3f;
import vector.Vector7f;

public class Matrix7f extends IMatrix<Matrix7f>
{
	
	/**
	* Constructs a 7x7 identity matrix in default.
	*/
	public Matrix7f()
	{

		this.m = new float[] {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
	}
	
	public Matrix7f(float scalar)
	{
		set(scalar);
	}
	
	private Matrix7f(
			 float m00, float m01, float m02, float m03, float m04, float m05, float m06,
			 float m10, float m11, float m12, float m13, float m14, float m15, float m16,
			 float m20, float m21, float m22, float m23, float m24, float m25, float m26,
			 float m30, float m31, float m32, float m33, float m34, float m35, float m36,
			 float m40, float m41, float m42, float m43, float m44, float m45, float m46,
			 float m50, float m51, float m52, float m53, float m54, float m55, float m56,
			 float m60, float m61, float m62, float m63, float m64, float m65, float m66)
	{
		this.m[0*7+0] = m00;
		this.m[0*7+1] = m01;
		this.m[0*7+2] = m02;
		this.m[0*7+3] = m03;
		this.m[0*7+4] = m04;
		this.m[0*7+5] = m05;
		this.m[0*7+6] = m06;
		this.m[1*7+0] = m10;
		this.m[1*7+1] = m11;
		this.m[1*7+2] = m12;
		this.m[1*7+3] = m13;
		this.m[1*7+4] = m14;
		this.m[1*7+5] = m15;
		this.m[1*7+6] = m16;
		this.m[2*7+0] = m20;
		this.m[2*7+1] = m21;
		this.m[2*7+2] = m22;
		this.m[2*7+3] = m23;
		this.m[2*7+4] = m24;
		this.m[2*7+5] = m25;
		this.m[2*7+6] = m26;
		this.m[3*7+0] = m30;
		this.m[3*7+1] = m31;
		this.m[3*7+2] = m32;
		this.m[3*7+3] = m33;
		this.m[3*7+4] = m34;
		this.m[3*7+5] = m35;
		this.m[3*7+6] = m36;
		this.m[4*7+0] = m40;
		this.m[4*7+1] = m41;
		this.m[4*7+2] = m42;
		this.m[4*7+3] = m43;
		this.m[4*7+4] = m44;
		this.m[4*7+5] = m45;
		this.m[4*7+6] = m46;
		this.m[5*7+0] = m50;
		this.m[5*7+1] = m51;
		this.m[5*7+2] = m52;
		this.m[5*7+3] = m53;
		this.m[5*7+4] = m54;
		this.m[5*7+5] = m55;
		this.m[5*7+6] = m56;
		this.m[6*7+0] = m60;
		this.m[6*7+1] = m61;
		this.m[6*7+2] = m62;
		this.m[6*7+3] = m63;
		this.m[6*7+4] = m64;
		this.m[6*7+5] = m65;
		this.m[6*7+6] = m66;
	}
	
	public Matrix7f(float[] array)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = array[i];
		}
	}
	
	public Matrix7f (double[][] array)
	{
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				this.m[i*7+j] = (float)array[i][j];
			}
		}
	}
	
	@Override
	public Matrix7f div(float scalar)
	{
		Matrix7f retMatrix = new Matrix7f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] / scalar;
		}
		return retMatrix;
	}
	
	@Override
	public Matrix7f mult(float scalar)
	{
		Matrix7f retMatrix = new Matrix7f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] * scalar;
		}
		return retMatrix;
	}
	
	public Matrix7f divI(float scalar)
	{
		for (int i = 0; i < this.size(); i++)
		{
			this.m[i] /= scalar;
		}
		return this;
	}

	public Matrix7f multI(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] *= scalar;
		}
		return this;
	}
	
	@Override
	public Matrix7f add(Matrix7f matrix)
	{
		Matrix7f retMatrix = new Matrix7f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] + matrix.m[i];
		}
		return retMatrix;
	}
	
	public Matrix7f addI(int row, int col, float scalar)
	{
		this.m[row*7+col] += scalar;
		return this;
	}

	@Override
	public Matrix7f sub(Matrix7f matrix)
	{
		Matrix7f retMatrix = new Matrix7f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] - matrix.m[i];
		}
		return retMatrix;
	}

	@Override
	public Matrix7f mult(Matrix7f matrix)
	{
		final float[] newMatrix = new float[getRowCount()*matrix.getColumnCount()];
		int index = 0;
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < matrix.getColumnCount(); j++) {
				float value = 0.0f;
                for (int k = 0; k < getColumnCount(); k++) {
                    value += get(i, k) * matrix.get(k, j);
                }
                newMatrix[index++] = value;
			}
		}
		return new Matrix7f(newMatrix);
	}
	
	public Vector7f mult(Vector7f storage)
	{
		return new Vector7f(storage.dot( getRow(0) ),
							storage.dot( getRow(1) ),
							storage.dot( getRow(2) ),
							storage.dot( getRow(3) ),
							storage.dot( getRow(4) ),
							storage.dot( getRow(5) ),
							storage.dot( getRow(6) ));
	}

	@Override
	public float normSquared()
	{
		return (m[0*7+0]*m[0*7+0]) + (m[0*7+1]*m[0*7+1]) + (m[0*7+2]*m[0*7+2]) + (m[0*7+3]*m[0*7+3]) + (m[0*7+4]*m[0*7+4]) + (m[0*7+5]*m[0*7+5]) + (m[0*7+6]*m[0*7+6]) +
			   (m[1*7+0]*m[1*7+0]) + (m[1*7+1]*m[1*7+1]) + (m[1*7+2]*m[1*7+2]) + (m[1*7+3]*m[1*7+3]) + (m[1*7+4]*m[1*7+4]) + (m[1*7+5]*m[1*7+5]) + (m[1*7+6]*m[1*7+6]) +
			   (m[2*7+0]*m[2*7+0]) + (m[2*7+1]*m[2*7+1]) + (m[2*7+2]*m[2*7+2]) + (m[2*7+3]*m[2*7+3]) + (m[2*7+4]*m[2*7+4]) + (m[2*7+5]*m[2*7+5]) + (m[2*7+6]*m[2*7+6]) +
			   (m[3*7+0]*m[3*7+0]) + (m[3*7+1]*m[3*7+1]) + (m[3*7+2]*m[3*7+2]) + (m[3*7+3]*m[3*7+3]) + (m[3*7+4]*m[3*7+4]) + (m[3*7+5]*m[3*7+5]) + (m[3*7+6]*m[3*7+6]) +
			   (m[4*7+0]*m[4*7+0]) + (m[4*7+1]*m[4*7+1]) + (m[4*7+2]*m[4*7+2]) + (m[4*7+3]*m[4*7+3]) + (m[4*7+4]*m[4*7+4]) + (m[4*7+5]*m[4*7+5]) + (m[4*7+6]*m[4*7+6]) +
			   (m[5*7+0]*m[5*7+0]) + (m[5*7+1]*m[5*7+1]) + (m[5*7+2]*m[5*7+2]) + (m[5*7+3]*m[5*7+3]) + (m[5*7+4]*m[5*7+4]) + (m[5*7+5]*m[5*7+5]) + (m[5*7+6]*m[5*7+6]) +
			   (m[6*7+0]*m[6*7+0]) + (m[6*7+1]*m[6*7+1]) + (m[6*7+2]*m[6*7+2]) + (m[6*7+3]*m[6*7+3]) + (m[6*7+4]*m[6*7+4]) + (m[6*7+5]*m[6*7+5]) + (m[6*7+6]*m[6*7+6]);
	}

	@Override
	public float sum()
	{
		float sum = 0.0f;
		for (int i = 0; i < size(); i++)
		{
			sum += this.m[i];
		}
		return sum;
	}

	@Override
	public Matrix7f inverse()
	{
		// TODO Auto-generated method stub
//		final MatrixBuilder<ArithmeticMatrix, ArithmeticVector> matrix = 
//				ArithmeticMatrix.createBuilder(getRowCount(), getColumnCount());
//		for (int i=0; i<getRowCount(); i++) {
//			for (int j=0; j<getColumnCount(); j++) {
//				matrix.set(i, j, get(i, j));
//			}
//		}
//		
//		final ArithmeticMatrix invMatrix = matrix.build().inverse();
////		final ArithmeticMatrix mat2 = matrix.build();
////		final ArithmeticMatrix invMatrix = new LU().initialise(mat2).solve( ArithmeticMatrix.identity(mat2.getRowCount()) );
//		
//		final Matrix7f newMatrix = new Matrix7f();
//		
//		for (int i=0; i<getRowCount(); i++) {
//			for (int j=0; j<getColumnCount(); j++) {
//				newMatrix.set(i, j, invMatrix.get(i, j));
//			}
//		}
		
		// JAMA code
		Matrix mat = new Matrix(toDoubleArray());
		Matrix matInv = mat.inverse();
		
		return new Matrix7f(matInv.getArray());
	}

	@Override
	public Matrix7f multDiagonal(float scalar)
	{
		return new Matrix7f(
			m[0*7+0]*scalar, m[0*7+1], 		  m[0*7+2], 		  m[0*7+3], 		  m[0*7+4], 		  m[0*7+5], 		  m[0*7+6],
			m[1*7+0], 		 m[1*7+1]*scalar, m[1*7+2], 		  m[1*7+3], 		  m[1*7+4], 		  m[1*7+5], 		  m[1*7+6],
			m[2*7+0], 		 m[2*7+1], 		  m[2*7+2]*scalar,	  m[2*7+3], 		  m[2*7+4], 		  m[2*7+5], 		  m[2*7+6],
			m[3*7+0], 		 m[3*7+1], 		  m[3*7+2], 		  m[3*7+3]*scalar,    m[3*7+4], 		  m[3*7+5], 		  m[3*7+6],
			m[4*7+0], 		 m[4*7+1], 		  m[4*7+2], 		  m[4*7+3], 		  m[4*7+4]*scalar,    m[4*7+5], 		  m[4*7+6],
			m[5*7+0], 		 m[5*7+1], 		  m[5*7+2], 		  m[5*7+3], 		  m[5*7+4], 		  m[5*7+5]*scalar,    m[5*7+6],
			m[6*7+0], 		 m[6*7+1], 		  m[6*7+2], 		  m[6*7+3], 		  m[6*7+4], 		  m[6*7+5], 		  m[6*7+6]*scalar);
	}

	@Override
	public Matrix7f transpose()
	{
		return new Matrix7f(
			m[0*7+0], m[1*7+0], m[2*7+0], m[3*7+0], m[4*7+0], m[5*7+0], m[6*7+0],
			m[0*7+1], m[1*7+1], m[2*7+1], m[3*7+1], m[4*7+1], m[5*7+1], m[6*7+1],
			m[0*7+2], m[1*7+2], m[2*7+2], m[3*7+2], m[4*7+2], m[5*7+2], m[6*7+2],
			m[0*7+3], m[1*7+3], m[2*7+3], m[3*7+3], m[4*7+3], m[5*7+3], m[6*7+3],
			m[0*7+4], m[1*7+4], m[2*7+4], m[3*7+4], m[4*7+4], m[5*7+4], m[6*7+4],
			m[0*7+5], m[1*7+5], m[2*7+5], m[3*7+5], m[4*7+5], m[5*7+5], m[6*7+5],
			m[0*7+6], m[1*7+6], m[2*7+6], m[3*7+6], m[4*7+6], m[5*7+6], m[6*7+6]);
	}

	@Override
	public Matrix7f negate()
	{
		return new Matrix7f(
			-m[0*7+0], -m[0*7+1], -m[0*7+2], -m[0*7+3], -m[0*7+4], -m[0*7+5], -m[0*7+6],
			-m[1*7+0], -m[1*7+1], -m[1*7+2], -m[1*7+3], -m[1*7+4], -m[1*7+5], -m[1*7+6],
			-m[2*7+0], -m[2*7+1], -m[2*7+2], -m[2*7+3], -m[2*7+4], -m[2*7+5], -m[2*7+6],
			-m[3*7+0], -m[3*7+1], -m[3*7+2], -m[3*7+3], -m[3*7+4], -m[3*7+5], -m[3*7+6],
			-m[4*7+0], -m[4*7+1], -m[4*7+2], -m[4*7+3], -m[4*7+4], -m[4*7+5], -m[4*7+6],
			-m[5*7+0], -m[5*7+1], -m[5*7+2], -m[5*7+3], -m[5*7+4], -m[5*7+5], -m[5*7+6],
			-m[6*7+0], -m[6*7+1], -m[6*7+2], -m[6*7+3], -m[6*7+4], -m[6*7+5], -m[6*7+6]);
	}

	@Override
	public Matrix7f set(int index, float value)
	{
		this.m[index] = value;
		return this;
	}

	@Override
	public Matrix7f set(int row, int col, float value)
	{
		set(row * 7 + col, value);
		return this;
	}
	
	public Matrix7f set(int row, int col, Matrix3f mat)
	{
		this.m[row*7+col]       = mat.get(0);
		this.m[row*7+col+1]     = mat.get(1);
		this.m[row*7+col+2]     = mat.get(2);
		this.m[(row+1)*7+col]   = mat.get(3);
		this.m[(row+1)*7+col+1] = mat.get(4);
		this.m[(row+1)*7+col+2] = mat.get(5);
		this.m[(row+2)*7+col]   = mat.get(6);
		this.m[(row+2)*7+col+1] = mat.get(7);
		this.m[(row+2)*7+col+2] = mat.get(8);
		return this;
	}
	
	public Matrix7f set(int row, int col, Matrix6f mat)
	{
		if (row > 1 || col > 1)
		{
			throw new ArrayIndexOutOfBoundsException("Matrix7f");
		}
		else
		{
			for (int i = 0; i < 6; i++)
			{
				for (int j = 0; j < 6; j++)
				{
					this.m[(row+i)*7+col+j] = mat.m[i*6+j];
				}
			}
		}
		return this;
	}
	
	private void set(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = scalar;
		}
	}

	public void setColumn(int col, Vector3f vector)
	{
		for (int i = 0; i < 3; i++)
		{
			this.m[i*7+col] = vector.get(i);
		}
	}
	
	@Override
	public float get(int index)
	{
		return this.m[index];
	}

	@Override
	public float get(int row, int col)
	{
		return get(row * 7 + col);
	}
	
	public Vector7f getRow(int row)
	{
		switch (row) {
			case 0:	return new Vector7f(m[0*7+0], m[0*7+1], m[0*7+2], m[0*7+3], m[0*7+4], m[0*7+5], m[0*7+6]);
			case 1:	return new Vector7f(m[1*7+0], m[1*7+1], m[1*7+2], m[1*7+3], m[1*7+4], m[1*7+5], m[1*7+6]);
			case 2:	return new Vector7f(m[2*7+0], m[2*7+1], m[2*7+2], m[2*7+3], m[2*7+4], m[2*7+5], m[2*7+6]);
			case 3:	return new Vector7f(m[3*7+0], m[3*7+1], m[3*7+2], m[3*7+3], m[3*7+4], m[3*7+5], m[3*7+6]);
			case 4:	return new Vector7f(m[4*7+0], m[4*7+1], m[4*7+2], m[4*7+3], m[4*7+4], m[4*7+5], m[4*7+6]);
			case 5:	return new Vector7f(m[5*7+0], m[5*7+1], m[5*7+2], m[5*7+3], m[5*7+4], m[5*7+5], m[5*7+6]);
			case 6:	return new Vector7f(m[6*7+0], m[6*7+1], m[6*7+2], m[6*7+3], m[6*7+4], m[6*7+5], m[6*7+6]);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - getRow("+row+")");
		}
	}
	
	public Vector7f getColumn(int col)
	{
		switch (col) {
			case 0:	return new Vector7f(m[0*7+0], m[1*7+0], m[2*7+0], m[3*7+0], m[4*7+0], m[5*7+0], m[6*7+0]);
			case 1:	return new Vector7f(m[0*7+1], m[1*7+1], m[2*7+1], m[3*7+1], m[4*7+1], m[5*7+1], m[6*7+1]);
			case 2:	return new Vector7f(m[0*7+2], m[1*7+2], m[2*7+2], m[3*7+2], m[4*7+2], m[5*7+2], m[6*7+2]);
			case 3:	return new Vector7f(m[0*7+3], m[1*7+3], m[2*7+3], m[3*7+3], m[4*7+3], m[5*7+3], m[6*7+3]);
			case 4:	return new Vector7f(m[0*7+4], m[1*7+4], m[2*7+4], m[3*7+4], m[4*7+4], m[5*7+4], m[6*7+4]);
			case 5:	return new Vector7f(m[0*7+5], m[1*7+5], m[2*7+5], m[3*7+5], m[4*7+5], m[5*7+5], m[6*7+5]);
			case 6:	return new Vector7f(m[0*7+6], m[1*7+6], m[2*7+6], m[3*7+6], m[4*7+6], m[5*7+6], m[6*7+6]);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - getColumn("+col+")");
		}
	}
	
	public Vector7f getDiagonal()
	{
		return new Vector7f(m[0], m[8], m[16], m[24], m[32], m[40], m[48]);
	}
	
	public boolean isNonsingular()
	{
		return m[0]  != 0.0f &&
			   m[8]  != 0.0f &&
			   m[16] != 0.0f &&
			   m[24] != 0.0f &&
			   m[32] != 0.0f &&
			   m[40] != 0.0f &&
			   m[48] != 0.0f;
	}
	
	public Matrix7f swap(int row1, int col1, int row2, int col2)
	{
		final float temp = get(row1, col1);
        set(row1, col1, get(row2, col2));
        set(row2, col2, temp);
		return this;
	}

	@Override
	public int getColumnCount()
	{
		return 7;
	}

	@Override
	public int getRowCount()
	{
		return 7;
	}
	
	public MatrixXf toMatrixXf()
	{
		return new MatrixXf(7, 7, new float[]{
			m[0*7+0], m[0*7+1], m[0*7+2], m[0*7+3], m[0*7+4], m[0*7+5], m[0*7+6],
			m[1*7+0], m[1*7+1], m[1*7+2], m[1*7+3], m[1*7+4], m[1*7+5], m[1*7+6],
			m[2*7+0], m[2*7+1], m[2*7+2], m[2*7+3], m[2*7+4], m[2*7+5], m[2*7+6],
			m[3*7+0], m[3*7+1], m[3*7+2], m[3*7+3], m[3*7+4], m[3*7+5], m[3*7+6],
			m[4*7+0], m[4*7+1], m[4*7+2], m[4*7+3], m[4*7+4], m[4*7+5], m[4*7+6],
			m[5*7+0], m[5*7+1], m[5*7+2], m[5*7+3], m[5*7+4], m[5*7+5], m[5*7+6],
			m[6*7+0], m[6*7+1], m[6*7+2], m[6*7+3], m[6*7+4], m[6*7+5], m[6*7+6]});
	}
	
	public float[] toArray()
	{
		return new float[]{
			m[0*7+0], m[0*7+1], m[0*7+2], m[0*7+3], m[0*7+4], m[0*7+5], m[0*7+6],
			m[1*7+0], m[1*7+1], m[1*7+2], m[1*7+3], m[1*7+4], m[1*7+5], m[1*7+6],
			m[2*7+0], m[2*7+1], m[2*7+2], m[2*7+3], m[2*7+4], m[2*7+5], m[2*7+6],
			m[3*7+0], m[3*7+1], m[3*7+2], m[3*7+3], m[3*7+4], m[3*7+5], m[3*7+6],
			m[4*7+0], m[4*7+1], m[4*7+2], m[4*7+3], m[4*7+4], m[4*7+5], m[4*7+6],
			m[5*7+0], m[5*7+1], m[5*7+2], m[5*7+3], m[5*7+4], m[5*7+5], m[5*7+6],
			m[6*7+0], m[6*7+1], m[6*7+2], m[6*7+3], m[6*7+4], m[6*7+5], m[6*7+6]};
	}
	
	public double[][] toDoubleArray()
	{
		return new double[][] {
			{ m[0*7+0], m[0*7+1], m[0*7+2], m[0*7+3], m[0*7+4], m[0*7+5], m[0*7+6] },
			{ m[1*7+0], m[1*7+1], m[1*7+2], m[1*7+3], m[1*7+4], m[1*7+5], m[1*7+6] },
			{ m[2*7+0], m[2*7+1], m[2*7+2], m[2*7+3], m[2*7+4], m[2*7+5], m[2*7+6] },
			{ m[3*7+0], m[3*7+1], m[3*7+2], m[3*7+3], m[3*7+4], m[3*7+5], m[3*7+6] },
			{ m[4*7+0], m[4*7+1], m[4*7+2], m[4*7+3], m[4*7+4], m[4*7+5], m[4*7+6] },
			{ m[5*7+0], m[5*7+1], m[5*7+2], m[5*7+3], m[5*7+4], m[5*7+5], m[5*7+6] },
			{ m[6*7+0], m[6*7+1], m[6*7+2], m[6*7+3], m[6*7+4], m[6*7+5], m[6*7+6] } };
	}

	@Override
	public Matrix7f copy()
	{
		return new Matrix7f(
			m[0*7+0], m[0*7+1], m[0*7+2], m[0*7+3], m[0*7+4], m[0*7+5], m[0*7+6],
			m[1*7+0], m[1*7+1], m[1*7+2], m[1*7+3], m[1*7+4], m[1*7+5], m[1*7+6],
			m[2*7+0], m[2*7+1], m[2*7+2], m[2*7+3], m[2*7+4], m[2*7+5], m[2*7+6],
			m[3*7+0], m[3*7+1], m[3*7+2], m[3*7+3], m[3*7+4], m[3*7+5], m[3*7+6],
			m[4*7+0], m[4*7+1], m[4*7+2], m[4*7+3], m[4*7+4], m[4*7+5], m[4*7+6],
			m[5*7+0], m[5*7+1], m[5*7+2], m[5*7+3], m[5*7+4], m[5*7+5], m[5*7+6],
			m[6*7+0], m[6*7+1], m[6*7+2], m[6*7+3], m[6*7+4], m[6*7+5], m[6*7+6]);
	}
	
	public void clear()
	{
		set(0.0f);
	}

	@Override
	public String toString()
	{
		return "Matrix7f: \n" +
			m[0*7+0] + ", " +  m[0*7+1] + ", " +  m[0*7+2] + ", " +  m[0*7+3] + ", " +  m[0*7+4] + ", " +  m[0*7+5] + ", " + m[0*7+6] + "\n" +
			m[1*7+0] + ", " +  m[1*7+1] + ", " +  m[1*7+2] + ", " +  m[1*7+3] + ", " +  m[1*7+4] + ", " +  m[1*7+5] + ", " + m[1*7+6] + "\n" +
			m[2*7+0] + ", " +  m[2*7+1] + ", " +  m[2*7+2] + ", " +  m[2*7+3] + ", " +  m[2*7+4] + ", " +  m[2*7+5] + ", " + m[2*7+6] + "\n" +
			m[3*7+0] + ", " +  m[3*7+1] + ", " +  m[3*7+2] + ", " +  m[3*7+3] + ", " +  m[3*7+4] + ", " +  m[3*7+5] + ", " + m[3*7+6] + "\n" +
			m[4*7+0] + ", " +  m[4*7+1] + ", " +  m[4*7+2] + ", " +  m[4*7+3] + ", " +  m[4*7+4] + ", " +  m[4*7+5] + ", " + m[4*7+6] + "\n" +
			m[5*7+0] + ", " +  m[5*7+1] + ", " +  m[5*7+2] + ", " +  m[5*7+3] + ", " +  m[5*7+4] + ", " +  m[5*7+5] + ", " + m[5*7+6] + "\n" +
			m[6*7+0] + ", " +  m[6*7+1] + ", " +  m[6*7+2] + ", " +  m[6*7+3] + ", " +  m[6*7+4] + ", " +  m[6*7+5] + ", " + m[6*7+6] + "\n";
	}

	@Override
	public int size()
	{
		return 49;
	}
}
