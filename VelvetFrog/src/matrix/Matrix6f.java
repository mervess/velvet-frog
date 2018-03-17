package matrix;

//import Jama.Matrix;
import vector.Vector6f;

/**
 * Float Matrix 6x6
 * Represents:
		m00, m01, m02, m03, m04, m05
		m10, m11, m12, m13, m14, m15
		m20, m21, m22, m23, m24, m25
		m30, m31, m32, m33, m34, m35
		m40, m41, m42, m43, m44, m45
		m50, m51, m52, m53, m54, m55
	    
 * @author mervess
 *
 */
public class Matrix6f extends IMatrix<Matrix6f>
{
	
	/**
	 * Constructs a 6x6 identity matrix in default.
	 */
	public Matrix6f()
	{
		this.m = new float[] {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
	}
	
	/**
	 * Constructs a 6x6 matrix with a scalar float value.
	 */
	public Matrix6f(float scalar)
	{
		set(scalar);
	}
	
	public Matrix6f(float m00, float m01, float m02, float m03, float m04, float m05,
					float m10, float m11, float m12, float m13, float m14, float m15,
					float m20, float m21, float m22, float m23, float m24, float m25,
					float m30, float m31, float m32, float m33, float m34, float m35,
					float m40, float m41, float m42, float m43, float m44, float m45,
					float m50, float m51, float m52, float m53, float m54, float m55)
	{
		this.m[0*6+0] = m00;
		this.m[0*6+1] = m01;
		this.m[0*6+2] = m02;
		this.m[0*6+3] = m03;
		this.m[0*6+4] = m04;
		this.m[0*6+5] = m05;
		this.m[1*6+0] = m10;
		this.m[1*6+1] = m11;
		this.m[1*6+2] = m12;
		this.m[1*6+3] = m13;
		this.m[1*6+4] = m14;
		this.m[1*6+5] = m15;
		this.m[2*6+0] = m20;
		this.m[2*6+1] = m21;
		this.m[2*6+2] = m22;
		this.m[2*6+3] = m23;
		this.m[2*6+4] = m24;
		this.m[2*6+5] = m25;
		this.m[3*6+0] = m30;
		this.m[3*6+1] = m31;
		this.m[3*6+2] = m32;
		this.m[3*6+3] = m33;
		this.m[3*6+4] = m34;
		this.m[3*6+5] = m35;
		this.m[4*6+0] = m40;
		this.m[4*6+1] = m41;
		this.m[4*6+2] = m42;
		this.m[4*6+3] = m43;
		this.m[4*6+4] = m44;
		this.m[4*6+5] = m45;
		this.m[5*6+0] = m50;
		this.m[5*6+1] = m51;
		this.m[5*6+2] = m52;
		this.m[5*6+3] = m53;
		this.m[5*6+4] = m54;
		this.m[5*6+5] = m55;
	}
	
	public Matrix6f(float[] array)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = array[i];
		}
	}
	
	public Matrix6f (double[][] array)
	{
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				this.m[i*6+j] = (float)array[i][j];
			}
		}
	}
	
	public Matrix6f (float[][] array)
	{
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				this.m[i*6+j] = array[i][j];
			}
		}
	}
	
	@Override
	public Matrix6f div(float scalar)
	{
		Matrix6f retMatrix = new Matrix6f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] / scalar;
		}
		return retMatrix;
	}

	@Override
	public Matrix6f mult(float scalar)
	{
		Matrix6f retMatrix = new Matrix6f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] * scalar;
		}
		return retMatrix;
	}
	
	public Matrix6f divI(float scalar)
	{
		for (int i = 0; i < this.size(); i++)
		{
			this.m[i] /= scalar;
		}
		return this;
	}

	public Matrix6f multI(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] *= scalar;
		}
		return this;
	}
	
	@Override
	public Matrix6f add(Matrix6f matrix)
	{
		Matrix6f retMatrix = new Matrix6f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] + matrix.m[i];
		}
		return retMatrix;
	}
	
	public Matrix6f addI(Matrix6f matrix)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] += matrix.m[i];
		}
		return this;
	}

	@Override
	public Matrix6f sub(Matrix6f matrix)
	{
		Matrix6f retMatrix = new Matrix6f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] - matrix.m[i];
		}
		return retMatrix;
	}

	@Override
	public Matrix6f mult(Matrix6f matrix)
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
		return new Matrix6f(newMatrix);
	}

	@Override
	public float normSquared()
	{
		return (m[0*6+0]*m[0*6+0]) + (m[0*6+1]*m[0*6+1]) + (m[0*6+2]*m[0*6+2]) + (m[0*6+3]*m[0*6+3]) + (m[0*6+4]*m[0*6+4]) + (m[0*6+5]*m[0*6+5]) +
			   (m[1*6+0]*m[1*6+0]) + (m[1*6+1]*m[1*6+1]) + (m[1*6+2]*m[1*6+2]) + (m[1*6+3]*m[1*6+3]) + (m[1*6+4]*m[1*6+4]) + (m[1*6+5]*m[1*6+5]) +
			   (m[2*6+0]*m[2*6+0]) + (m[2*6+1]*m[2*6+1]) + (m[2*6+2]*m[2*6+2]) + (m[2*6+3]*m[2*6+3]) + (m[2*6+4]*m[2*6+4]) + (m[2*6+5]*m[2*6+5]) +
			   (m[3*6+0]*m[3*6+0]) + (m[3*6+1]*m[3*6+1]) + (m[3*6+2]*m[3*6+2]) + (m[3*6+3]*m[3*6+3]) + (m[3*6+4]*m[3*6+4]) + (m[3*6+5]*m[3*6+5]) +
			   (m[4*6+0]*m[4*6+0]) + (m[4*6+1]*m[4*6+1]) + (m[4*6+2]*m[4*6+2]) + (m[4*6+3]*m[4*6+3]) + (m[4*6+4]*m[4*6+4]) + (m[4*6+5]*m[4*6+5]) +
			   (m[5*6+0]*m[5*6+0]) + (m[5*6+1]*m[5*6+1]) + (m[5*6+2]*m[5*6+2]) + (m[5*6+3]*m[5*6+3]) + (m[5*6+4]*m[5*6+4]) + (m[5*6+5]*m[5*6+5]);
	}

	@Override
	public Matrix6f inverse()
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
//		final Matrix6f newMatrix = new Matrix6f();
//		
//		for (int i=0; i<getRowCount(); i++) {
//			for (int j=0; j<getColumnCount(); j++) {
//				newMatrix.set(i, j, invMatrix.get(i, j));
//			}
//		}
		
		// JAMA code
		Matrix mat = new Matrix(toDoubleArray());
		Matrix matInv = mat.inverse();
		
		return new Matrix6f(matInv.getArray());
	}

	@Override
	public Matrix6f multDiagonal(float scalar)
	{
		return new Matrix6f(m[0*6+0]*scalar, m[0*6+1],		  m[0*6+2], 		m[0*6+3], 		 m[0*6+4], 		  m[0*6+5],
							m[1*6+0],		 m[1*6+1]*scalar, m[1*6+2], 		m[1*6+3], 		 m[1*6+4], 		  m[1*6+5],
							m[2*6+0], 		 m[2*6+1], 		  m[2*6+2]*scalar,  m[2*6+3], 		 m[2*6+4], 		  m[2*6+5],
							m[3*6+0], 		 m[3*6+1], 		  m[3*6+2], 		m[3*6+3]*scalar, m[3*6+4], 		  m[3*6+5],
							m[4*6+0], 		 m[4*6+1], 		  m[4*6+2], 		m[4*6+3], 		 m[4*6+4]*scalar, m[4*6+5],
							m[5*6+0], 		 m[5*6+1], 		  m[5*6+2], 		m[5*6+3], 		 m[5*6+4], 		  m[5*6+5]*scalar);
	}

	@Override
	public Matrix6f transpose()
	{
		return new Matrix6f(m[0*6+0], m[1*6+0], m[2*6+0], m[3*6+0], m[4*6+0], m[5*6+0],
							m[0*6+1], m[1*6+1], m[2*6+1], m[3*6+1], m[4*6+1], m[5*6+1],
							m[0*6+2], m[1*6+2], m[2*6+2], m[3*6+2], m[4*6+2], m[5*6+2],
							m[0*6+3], m[1*6+3], m[2*6+3], m[3*6+3], m[4*6+3], m[5*6+3],
							m[0*6+4], m[1*6+4], m[2*6+4], m[3*6+4], m[4*6+4], m[5*6+4],
							m[0*6+5], m[1*6+5], m[2*6+5], m[3*6+5], m[4*6+5], m[5*6+5]);
	}

	@Override
	public Matrix6f negate()
	{
		return new Matrix6f(-m[0*6+0], -m[0*6+1], -m[0*6+2], -m[0*6+3], -m[0*6+4], -m[0*6+5],
							-m[1*6+0], -m[1*6+1], -m[1*6+2], -m[1*6+3], -m[1*6+4], -m[1*6+5],
							-m[2*6+0], -m[2*6+1], -m[2*6+2], -m[2*6+3], -m[2*6+4], -m[2*6+5],
							-m[3*6+0], -m[3*6+1], -m[3*6+2], -m[3*6+3], -m[3*6+4], -m[3*6+5],
							-m[4*6+0], -m[4*6+1], -m[4*6+2], -m[4*6+3], -m[4*6+4], -m[4*6+5],
							-m[5*6+0], -m[5*6+1], -m[5*6+2], -m[5*6+3], -m[5*6+4], -m[5*6+5]);
	}
	
	private void set(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = scalar;
		}
	}

	@Override
	public Matrix6f set(int index, float value)
	{
		this.m[index] = value;
		return this;
	}

	@Override
	public Matrix6f set(int row, int col, float value)
	{
		this.m[row * 6 + col] = value;
		return this;
	}
	
	public Matrix6f set(int row, int col, Matrix3f mat)
	{
		this.m[row*6+col]       = mat.get(0);
		this.m[row*6+col+1]     = mat.get(1);
		this.m[row*6+col+2]     = mat.get(2);
		this.m[(row+1)*6+col]   = mat.get(3);
		this.m[(row+1)*6+col+1] = mat.get(4);
		this.m[(row+1)*6+col+2] = mat.get(5);
		this.m[(row+2)*6+col]   = mat.get(6);
		this.m[(row+2)*6+col+1] = mat.get(7);
		this.m[(row+2)*6+col+2] = mat.get(8);
		return this;
	}

	@Override
	public float get(int index)
	{
		return this.m[index];
	}

	@Override
	public float get(int row, int col)
	{
		return this.m[row * 6 + col];
	}
	
	public float[] getColumn(int col, int rowFrom, int rowTo)
	{
		int range = rowTo - rowFrom;
		float[] column = new float[range];
		int offset = 0;
		for (int i = 0; i < range; i++)
		{
			column[i] = this.m[(rowFrom+offset)*6+col];
			offset++;
		}
		return column;
	}
	
	public float[] getRow(int row, int colFrom, int colTo)
	{
		int range = colTo - colFrom;
		float[] rowArray = new float[range];
		int offset = 0;
		for (int i = 0; i < range; i++)
		{
			rowArray[i] = this.m[row*6+colFrom+offset];
			offset++;
		}
		return rowArray;
	}
	
	public Vector6f getRow(int row)
	{
		switch (row) {
			case 0: return new Vector6f(m[0*6+0], m[0*6+1], m[0*6+2], m[0*6+3], m[0*6+4], m[0*6+5]);
			case 1:	return new Vector6f(m[1*6+0], m[1*6+1], m[1*6+2], m[1*6+3], m[1*6+4], m[1*6+5]);
			case 2:	return new Vector6f(m[2*6+0], m[2*6+1], m[2*6+2], m[2*6+3], m[2*6+4], m[2*6+5]);
			case 3:	return new Vector6f(m[3*6+0], m[3*6+1], m[3*6+2], m[3*6+3], m[3*6+4], m[3*6+5]);
			case 4:	return new Vector6f(m[4*6+0], m[4*6+1], m[4*6+2], m[4*6+3], m[4*6+4], m[4*6+5]);
			case 5:	return new Vector6f(m[5*6+0], m[5*6+1], m[5*6+2], m[5*6+3], m[5*6+4], m[5*6+5]);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix6f - getRow("+row+")");
		}
	}
	
	public Vector6f getDiagonal()
	{
		return new Vector6f(m[0], m[7], m[14], m[21], m[28], m[35]);
	}
	
	public float[] getDiagonal(int from, int to)
	{
		final float[] diagonal = new float[to-from];
		int index = 0;
		for (int i = from; i <= to; i++)
		{
			diagonal[index++] = this.m[i*6+i];
		}
		
		return diagonal;
	}
	
	public Matrix6f swap(int row1, int col1, int row2, int col2)
	{
		final float temp = get(row1, col1);
        set(row1, col1, get(row2, col2));
        set(row2, col2, temp);
		return this;
	}

	@Override
	public int getColumnCount()
	{
		return 6;
	}

	@Override
	public int getRowCount()
	{
		return 6;
	}
	
	public MatrixXf toMatrixXf()
	{
		return new MatrixXf(6, 6, new float[]{
				m[0*6+0], m[0*6+1], m[0*6+2], m[0*6+3], m[0*6+4], m[0*6+5],
				m[1*6+0], m[1*6+1], m[1*6+2], m[1*6+3], m[1*6+4], m[1*6+5],
				m[2*6+0], m[2*6+1], m[2*6+2], m[2*6+3], m[2*6+4], m[2*6+5],
				m[3*6+0], m[3*6+1], m[3*6+2], m[3*6+3], m[3*6+4], m[3*6+5],
				m[4*6+0], m[4*6+1], m[4*6+2], m[4*6+3], m[4*6+4], m[4*6+5],
				m[5*6+0], m[5*6+1], m[5*6+2], m[5*6+3], m[5*6+4], m[5*6+5]});
	}
	
	public float[] toArray()
	{
		return new float[]{m[0*6+0], m[0*6+1], m[0*6+2], m[0*6+3], m[0*6+4], m[0*6+5],
						   m[1*6+0], m[1*6+1], m[1*6+2], m[1*6+3], m[1*6+4], m[1*6+5],
						   m[2*6+0], m[2*6+1], m[2*6+2], m[2*6+3], m[2*6+4], m[2*6+5],
						   m[3*6+0], m[3*6+1], m[3*6+2], m[3*6+3], m[3*6+4], m[3*6+5],
						   m[4*6+0], m[4*6+1], m[4*6+2], m[4*6+3], m[4*6+4], m[4*6+5],
						   m[5*6+0], m[5*6+1], m[5*6+2], m[5*6+3], m[5*6+4], m[5*6+5]};
	}
	
	public double[][] toDoubleArray()
	{
		return new double[][] {
				{ m[0*6+0], m[0*6+1], m[0*6+2], m[0*6+3], m[0*6+4], m[0*6+5] },
				{ m[1*6+0], m[1*6+1], m[1*6+2], m[1*6+3], m[1*6+4], m[1*6+5] },
				{ m[2*6+0], m[2*6+1], m[2*6+2], m[2*6+3], m[2*6+4], m[2*6+5] },
				{ m[3*6+0], m[3*6+1], m[3*6+2], m[3*6+3], m[3*6+4], m[3*6+5] },
				{ m[4*6+0], m[4*6+1], m[4*6+2], m[4*6+3], m[4*6+4], m[4*6+5] },
				{ m[5*6+0], m[5*6+1], m[5*6+2], m[5*6+3], m[5*6+4], m[5*6+5] } };
	}
	
	@Override
	public Matrix6f copy()
	{
		return new Matrix6f(
				m[0*6+0], m[0*6+1], m[0*6+2], m[0*6+3], m[0*6+4], m[0*6+5],
				m[1*6+0], m[1*6+1], m[1*6+2], m[1*6+3], m[1*6+4], m[1*6+5],
				m[2*6+0], m[2*6+1], m[2*6+2], m[2*6+3], m[2*6+4], m[2*6+5],
				m[3*6+0], m[3*6+1], m[3*6+2], m[3*6+3], m[3*6+4], m[3*6+5],
				m[4*6+0], m[4*6+1], m[4*6+2], m[4*6+3], m[4*6+4], m[4*6+5],
				m[5*6+0], m[5*6+1], m[5*6+2], m[5*6+3], m[5*6+4], m[5*6+5]);
	}
	
	public void clear()
	{
		set(0.0f);
	}

	public String toString()
	{
		return "Matrix6f: \n" + 
				m[0*6+0] + ", " +  m[0*6+1] + ", " +  m[0*6+2] + ", " +  m[0*6+3] + ", " +  m[0*6+4] + ", " +  m[0*6+5] + "\n" + 
				m[1*6+0] + ", " +  m[1*6+1] + ", " +  m[1*6+2] + ", " +  m[1*6+3] + ", " +  m[1*6+4] + ", " +  m[1*6+5] + "\n" + 
				m[2*6+0] + ", " +  m[2*6+1] + ", " +  m[2*6+2] + ", " +  m[2*6+3] + ", " +  m[2*6+4] + ", " +  m[2*6+5] + "\n" + 
				m[3*6+0] + ", " +  m[3*6+1] + ", " +  m[3*6+2] + ", " +  m[3*6+3] + ", " +  m[3*6+4] + ", " +  m[3*6+5] + "\n" + 
				m[4*6+0] + ", " +  m[4*6+1] + ", " +  m[4*6+2] + ", " +  m[4*6+3] + ", " +  m[4*6+4] + ", " +  m[4*6+5] + "\n" + 
				m[5*6+0] + ", " +  m[5*6+1] + ", " +  m[5*6+2] + ", " +  m[5*6+3] + ", " +  m[5*6+4] + ", " +  m[5*6+5] + "\n";
	}

	@Override
	public int size()
	{
		return 36;
	}
}
