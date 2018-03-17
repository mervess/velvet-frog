package matrix;

import vector.Vector3f;

/**
 * Float Matrix 3x3
 * Represents:
		m00, m01, m02 
	    m10, m11, m12 
	    m20, m21, m22
 *
 * Inspired by com.sun.javafx.geom.Matrix3f
 * 
 * @author mervess
 *
 */
public class Matrix3f extends IMatrix<Matrix3f>
{
	
	public static final Matrix3f IDENTITY = new Matrix3f(); // or UNIT matrix
	
	public Matrix3f()
	{
		this.m = new float[] {1.0f, 0.0f, 0.0f,
							  0.0f, 1.0f, 0.0f,
							  0.0f, 0.0f, 1.0f};
	}
	
	public Matrix3f(float m00, float m01, float m02,
		            float m10, float m11, float m12,
		            float m20, float m21, float m22)
	{
		this.m[0*3+0] = m00;
        this.m[0*3+1] = m01;
        this.m[0*3+2] = m02;
        this.m[1*3+0] = m10;
        this.m[1*3+1] = m11;
        this.m[1*3+2] = m12;
        this.m[2*3+0] = m20;
        this.m[2*3+1] = m21;
        this.m[2*3+2] = m22;
	}
	
	public Matrix3f(float[] matrix)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = matrix[i];
		}
	}
	
	@Override
	public Matrix3f div(float scalar)
	{
		Matrix3f retMatrix = new Matrix3f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i]/scalar;			
		}
		return retMatrix;
	}

	@Override
	public Matrix3f mult(float scalar)
	{
		Matrix3f retMatrix = new Matrix3f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i]*scalar;			
		}
		return retMatrix;
	}
	
	public Matrix3f divI(float scalar)
	{
		for (int i = 0; i < this.size(); i++)
		{
			this.m[i] /= scalar;
		}
		return this;
	}

	public Matrix3f multI(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] *= scalar;
		}
		return this;
	}

	@Override
	public Matrix3f add(Matrix3f matrix)
	{
		Matrix3f retMatrix = new Matrix3f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i]+matrix.m[i];			
		}
		return retMatrix;
	}
	
	public Matrix3f addI(Matrix3f matrix)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] += matrix.m[i];			
		}
		return this;
	}

	@Override
	public Matrix3f sub(Matrix3f matrix)
	{
		Matrix3f retMatrix = new Matrix3f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i]-matrix.m[i];			
		}
		return retMatrix;
	}
	
	public Matrix3f subI(Matrix3f matrix)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] -= matrix.m[i];			
		}
		return this;
	}

	@Override
	public Matrix3f mult(Matrix3f matrix)
	{
		final float[] newMatrix = new float[getRowCount()*matrix.getColumnCount()];
		int index = 0;
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < matrix.getColumnCount(); j++) {
				float value = 0.0f;
                for (int k = 0; k < getColumnCount(); k++) {
                    value += get(i, k) * matrix.get(k, j);
//                    value = Math.fma( get(i, k), matrix.get(k, j), value );
                }
                newMatrix[index++] = value;
			}
		}
		return new Matrix3f(newMatrix);
	}
	
	/**
	 * 
	 * @param Vector3f storage 
	 * @return
	 */
	public Vector3f mult(Vector3f storage)
	{
		return new Vector3f(storage.dot(getRow(0)), 
							storage.dot(getRow(1)),
							storage.dot(getRow(2)));
	}

	@Override
	public float normSquared()
	{
		return (m[0*3+0]*m[0*3+0]) + (m[0*3+1]*m[0*3+1]) + (m[0*3+2]*m[0*3+2]) +
			   (m[1*3+0]*m[1*3+0]) + (m[1*3+1]*m[1*3+1]) + (m[1*3+2]*m[1*3+2]) +
			   (m[2*3+0]*m[2*3+0]) + (m[2*3+1]*m[2*3+1]) + (m[2*3+2]*m[2*3+2]);
	}

	@Override
	public Matrix3f multDiagonal(float scalar)
	{
		return new Matrix3f(m[0]*scalar, m[1], 		  m[2], 
					        m[3], 		 m[4]*scalar, m[5], 
					        m[6], 		 m[7], 		  m[8]*scalar);
	}

	@Override
	public Matrix3f transpose()
	{
		return new Matrix3f(m[0], m[3], m[6], 
					        m[1], m[4], m[7], 
					        m[2], m[5], m[8]);
	}

	@Override
	public Matrix3f negate()
	{
		return new Matrix3f(-m[0], -m[1], -m[2], 
					        -m[3], -m[4], -m[5], 
					        -m[6], -m[7], -m[8]);
	}
	
	public float determinant()
	{
		return m[0*3+0] * ( (m[1*3+1]*m[2*3+2]) - (m[1*3+2]*m[2*3+1]) )
			 - m[0*3+1] * ( (m[1*3+0]*m[2*3+2]) - (m[1*3+2]*m[2*3+0]) )
			 + m[0*3+2] * ( (m[1*3+0]*m[2*3+1]) - (m[1*3+1]*m[2*3+0]) );
	}
	
	/*
	 *  Getters & Setters
	 *  m00, m01, m02 
	    m10, m11, m12 
	    m20, m21, m22
	 */
	
	@Override
	public float get(int index)
	{
		return this.m[index];
	}
	
	@Override
	public Matrix3f set(int index, float value)
	{
		this.m[index] = value;
		return this;
	}

	@Override
	public float get(int row, int col)
	{
		return this.m[row*3+col];
	}
	
	@Override
	public Matrix3f set(int row, int col, float value)
	{
		this.m[row*3+col] = value;
		return this;
	}
	
	public Vector3f getColumn(int col)
	{
		return new Vector3f(m[col], m[3+col], m[6+col]);
	}
	
	public void setColumn(int col, Vector3f vector)
	{
		this.m[col] = vector.get(0);
		this.m[3+col] = vector.get(1);
		this.m[6+col] = vector.get(2);
	}
	
	public Vector3f getRow(int row)
	{
		return new Vector3f(m[row*3], m[row*3+1], m[row*3+2]);
	}
	
	public void setRow(int row, Vector3f vector)
	{
		this.m[row*3] = vector.get(0);
		this.m[row*3+1] = vector.get(1);
		this.m[row*3+2] = vector.get(2);
	}
	
	@Override
	public int getColumnCount()
	{
		return 3;
	}

	@Override
	public int getRowCount()
	{
		return 3;
	}
	
	/*
	 * 3x3 Matrix Inverse Operation
	 * 
	 * About inverse:
	 * A . A^-1 = I
	 * A . x = b
	 * x = A^-1 . b
	 * equations could be solved.
	 */
	
	public Matrix3f inverse()
	{
		if (determinant() != 0) {
			Matrix3f matrix = new Matrix3f();
			calcMatrixOfMinors(matrix);
			calcMatrixOfCofactors(matrix);
			calcAdjointMatrix(matrix);
			multByDeterminant(matrix);
			return matrix;
		} else {
			throw new ArithmeticException("Det(A) = 0, inverse of A can not be calculated.");
		}
	}
	
	/**
	 * m00, m01, m02 
	   m10, m11, m12 
	   m20, m21, m22
	 */
	private void calcMatrixOfMinors(Matrix3f matrixOfMinors)
	{
		matrixOfMinors.m[0*3+0] = (m[1*3+1]*m[2*3+2]) - (m[1*3+2]*m[2*3+1]);
		matrixOfMinors.m[0*3+1] = (m[1*3+0]*m[2*3+2]) - (m[1*3+2]*m[2*3+0]);
		matrixOfMinors.m[0*3+2] = (m[1*3+0]*m[2*3+1]) - (m[1*3+1]*m[2*3+0]);
		matrixOfMinors.m[1*3+0] = (m[0*3+1]*m[2*3+2]) - (m[0*3+2]*m[2*3+1]);
		matrixOfMinors.m[1*3+1] = (m[0*3+0]*m[2*3+2]) - (m[0*3+2]*m[2*3+0]);
		matrixOfMinors.m[1*3+2] = (m[0*3+0]*m[2*3+1]) - (m[0*3+1]*m[2*3+0]);
		matrixOfMinors.m[2*3+0] = (m[0*3+1]*m[1*3+2]) - (m[0*3+2]*m[1*3+1]);
		matrixOfMinors.m[2*3+1] = (m[0*3+0]*m[1*3+2]) - (m[0*3+2]*m[1*3+0]);
		matrixOfMinors.m[2*3+2] = (m[0*3+0]*m[1*3+1]) - (m[0*3+1]*m[1*3+0]);
	}
	
	/**
	 * 
	 * A_ij = (-1)^(i+j)  M_ij
	 * 
	   +, -, + 
	   -, +, - 
	   +, -, +
	 */
	private void calcMatrixOfCofactors(Matrix3f matrix)
	{
		matrix.m[0*3+1] = -matrix.m[0*3+1];
		matrix.m[1*3+0] = -matrix.m[1*3+0];
		matrix.m[2*3+1] = -matrix.m[2*3+1];
		matrix.m[1*3+2] = -matrix.m[1*3+2];
	}
	
	/**
	 * m00, m10, m20 
	   m01, m11, m21 
	   m02, m12, m22
	 * transpose | adjugate
	 */
	private void calcAdjointMatrix(Matrix3f matrix)
	{
		float temp = matrix.m[1];
		matrix.m[1] = matrix.m[3];
		matrix.m[3] = temp;
		
		temp = matrix.m[2];
		matrix.m[2] = matrix.m[6];
		matrix.m[6] = temp;
		
		temp = matrix.m[5];
		matrix.m[5] = matrix.m[7];
		matrix.m[7] = temp;
	}
	
	private void multByDeterminant(Matrix3f matrix)
	{
		 // took from matrix of minors' original form
		float det = (this.m[0] *   matrix.m[0])  -
					(this.m[1] * -(matrix.m[3])) +
					(this.m[2] *   matrix.m[6]);
		
		// Mult by 1/det 
		for (int i = 0; i < size(); i++)
		{
			matrix.m[i] /= det;
		}
	}
	
	@Override
	public Matrix3f copy()
	{
		return new Matrix3f(this.m);
	}
	
	@Override
	public String toString()
	{
		return "Matrix3f:\n" +
				   m[0*3+0] + ", " + m[0*3+1] + ", " + m[0*3+2] + "\n" +
				   m[1*3+0] + ", " + m[1*3+1] + ", " + m[1*3+2] + "\n" +
				   m[2*3+0] + ", " + m[2*3+1] + ", " + m[2*3+2] + "\n";
	}

	@Override
	public int size()
	{
		return 9;
	}
}
