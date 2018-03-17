package matrix;

import vector.Vector3f;
import vector.Vector4f;

/**
 * Float Matrix 4x4
 * Represents:
		m00, m01, m02, m03 
	    m10, m11, m12, m13 
	    m20, m21, m22, m23
	    m30, m31, m32, m33
	    
 * @author mervess
 *
 */
public class Matrix4f extends IMatrix<Matrix4f>
{
	/**
	 * Constructs a 4x4 identity matrix in default.
	 */
	public Matrix4f()
	{
		this.m = new float[] {1.0f, 0.0f, 0.0f, 0.0f,
							  0.0f, 1.0f, 0.0f, 0.0f,
							  0.0f, 0.0f, 1.0f, 0.0f,
							  0.0f, 0.0f, 0.0f, 1.0f};
	}
	
	public Matrix4f(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = scalar;
		}
	}
	
	public Matrix4f(float m00, float m01, float m02, float m03,
		            float m10, float m11, float m12, float m13,
		            float m20, float m21, float m22, float m23,
		            float m30, float m31, float m32, float m33)
    {
		this.m[0*4+0] = m00;
		this.m[0*4+1] = m01;
		this.m[0*4+2] = m02;
		this.m[0*4+3] = m03;
		this.m[1*4+0] = m10;
		this.m[1*4+1] = m11;
		this.m[1*4+2] = m12;
		this.m[1*4+3] = m13;
		this.m[2*4+0] = m20;
		this.m[2*4+1] = m21;
		this.m[2*4+2] = m22;
		this.m[2*4+3] = m23;
		this.m[3*4+0] = m30;
		this.m[3*4+1] = m31;
		this.m[3*4+2] = m32;
		this.m[3*4+3] = m33;
	}
	
	public Matrix4f(float[] array)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] = array[i];
		}
	}
	
	
	@Override
	public Matrix4f div(float scalar)
	{
		Matrix4f retMatrix = new Matrix4f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] / scalar;
		}
		return retMatrix;
	}

	@Override
	public Matrix4f mult(float scalar)
	{
		Matrix4f retMatrix = new Matrix4f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] * scalar;
		}
		return retMatrix;
	}
	
	public Matrix4f divI(float scalar)
	{
		for (int i = 0; i < this.size(); i++)
		{
			this.m[i] /= scalar;
		}
		return this;
	}

	public Matrix4f multI(float scalar)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] *= scalar;
		}
		return this;
	}
	
	@Override
	public Matrix4f add(Matrix4f matrix)
	{
		Matrix4f retMatrix = new Matrix4f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] + matrix.m[i];
		}
		return retMatrix;
	}

	public Matrix4f addI(Matrix4f matrix)
	{
		for (int i = 0; i < size(); i++)
		{
			this.m[i] += matrix.m[i];
		}
		return this;
	}
	
	@Override
	public Matrix4f sub(Matrix4f matrix)
	{
		Matrix4f retMatrix = new Matrix4f();
		for (int i = 0; i < size(); i++)
		{
			retMatrix.m[i] = this.m[i] - matrix.m[i];
		}
		return retMatrix;
	}

	@Override
	public Matrix4f mult(Matrix4f matrix)
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
		return new Matrix4f(newMatrix);
	}

	@Override
	public float normSquared()
	{
		return (m[0*4+0]*m[0*4+0]) + (m[0*4+1]*m[0*4+1]) + (m[0*4+2]*m[0*4+2]) + (m[0*4+3]*m[0*4+3]) +
			   (m[1*4+0]*m[1*4+0]) + (m[1*4+1]*m[1*4+1]) + (m[1*4+2]*m[1*4+2]) + (m[1*4+3]*m[1*4+3]) +
			   (m[2*4+0]*m[2*4+0]) + (m[2*4+1]*m[2*4+1]) + (m[2*4+2]*m[2*4+2]) + (m[2*4+3]*m[2*4+3]) +
			   (m[3*4+0]*m[3*4+0]) + (m[3*4+1]*m[3*4+1]) + (m[3*4+2]*m[3*4+2]) + (m[3*4+3]*m[3*4+3]);
	}

	@Override
	public Matrix4f inverse()
	{
		final MatrixXf matrixXf = new MatrixXf(getRowCount(), getColumnCount(), this.m);
		final MatrixXf invMatrix = matrixXf.inverse();
		return new Matrix4f(invMatrix.toArray());
	}

	@Override
	public Matrix4f multDiagonal(float scalar)
	{
		return new Matrix4f(m[0]*scalar, m[1], 			m[2], 		  m[3],
		        			m[4], 		 m[5]*scalar, 	m[6], 		  m[7],
		        			m[8], 		 m[9], 			m[10]*scalar, m[11],
		        			m[12], 		 m[13], 		m[14], 		  m[15]*scalar);
	}

	/*
	 *  Getters & Setters
	 *  m00, m01, m02, m03 
	    m10, m11, m12, m13 
	    m20, m21, m22, m23,
	    m30, m31, m32, m33
	 */
	
	@Override
	public float get(int index)
	{
		return this.m[index];
	}
	
	@Override
	public Matrix4f set(int index, float value)
	{
		this.m[index] = value;
		return this;
	}
	
	@Override
	public float get(int row, int col)
	{
		return this.m[row*4+col];
	}

	@Override
	public Matrix4f set(int row, int col, float value)
	{
		this.m[row*4+col] = value;
		return this;
	}
	
	// public Matrix4f set(int row, int col, Matrix3f mat)
	// {
	// 	switch (row) { 
	//         case 0:
	//         	switch (col) {
	// 	        	case 0:
	// 	        		m00 = mat.m00;
	// 	        		m01 = mat.m01;
	// 	        		m02 = mat.m02;
	// 		        		m10 = mat.m10;
	// 		        		m11 = mat.m11;
	// 		        		m12 = mat.m12;
	// 			        		m20 = mat.m20;
	// 			        		m21 = mat.m21;
	// 			        		m22 = mat.m22;
	// 	        		break;
	// 	        	case 1:
	// 	        		m01 = mat.m00;
	// 	        		m02 = mat.m01;
	// 	        		m03 = mat.m02;
	// 		        		m11 = mat.m10;
	// 		        		m12 = mat.m11;
	// 		        		m13 = mat.m12;
	// 			        		m21 = mat.m20;
	// 			        		m22 = mat.m21;
	// 			        		m23 = mat.m22;
	// 	        		break;
	//         	}
	//         	break;
	        	
	//         case 1:
	//         	switch (col) {
	// 	        	case 0:
	// 	        		m10 = mat.m00;
	// 	        		m11 = mat.m01;
	// 	        		m12 = mat.m02;
	// 		        		m20 = mat.m10;
	// 		        		m21 = mat.m11;
	// 		        		m22 = mat.m12;
	// 			        		m30 = mat.m20;
	// 			        		m31 = mat.m21;
	// 			        		m32 = mat.m22;
	// 	        		break;
	// 	        	case 1:
	// 	        		m11 = mat.m00;
	// 	        		m12 = mat.m01;
	// 	        		m13 = mat.m02;
	// 		        		m21 = mat.m10;
	// 		        		m22 = mat.m11;
	// 		        		m23 = mat.m12;
	// 			        		m31 = mat.m20;
	// 			        		m32 = mat.m21;
	// 			        		m33 = mat.m22;
	// 	        		break;
	//         	}
	//         	break;

	//         default:
	//             throw new ArrayIndexOutOfBoundsException("Matrix4f");
	//     }
	// 	return this;
	// }
	
	public void setColumn(int col, Vector4f vector)
	{
		this.m[0+col] = vector.get(0);
		this.m[4+col] = vector.get(1);
		this.m[8+col] = vector.get(2);
		this.m[12+col] = vector.get(3);
	}
	
	public void setColumn(int col, Vector3f vector)
	{
		this.m[col] = vector.get(0);
		this.m[4+col] = vector.get(1);
		this.m[8+col] = vector.get(2);
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}

	@Override
	public int getRowCount()
	{
		return 4;
	}

	@Override
	public Matrix4f transpose()
	{
		return new Matrix4f(m[0*4+0], m[1*4+0], m[2*4+0], m[3*4+0],
							m[0*4+1], m[1*4+1], m[2*4+1], m[3*4+1],
							m[0*4+2], m[1*4+2], m[2*4+2], m[3*4+2],
							m[0*4+3], m[1*4+3], m[2*4+3], m[3*4+3]);
	}

	@Override
	public Matrix4f negate()
	{
		return new Matrix4f(-m[0*4+0], -m[0*4+1], -m[0*4+2], -m[0*4+3],
							-m[1*4+0], -m[1*4+1], -m[1*4+2], -m[1*4+3],
							-m[2*4+0], -m[2*4+1], -m[2*4+2], -m[2*4+3],
							-m[3*4+0], -m[3*4+1], -m[3*4+2], -m[3*4+3]);
	}
	
	@Override
	public Matrix4f copy()
	{
		return new Matrix4f(this.m);
	}

	@Override
	public String toString()
	{
		return "Matrix4f:\n" +
			   m[0*4+0] + ", " + m[0*4+1] + ", " + m[0*4+2] + ", " + m[0*4+3] + "\n" +
			   m[1*4+0] + ", " + m[1*4+1] + ", " + m[1*4+2] + ", " + m[1*4+3] + "\n" +
			   m[2*4+0] + ", " + m[2*4+1] + ", " + m[2*4+2] + ", " + m[2*4+3] + "\n" +
			   m[3*4+0] + ", " + m[3*4+1] + ", " + m[3*4+2] + ", " + m[3*4+3] + "\n";
	}

	@Override
	public int size()
	{
		return 16;
	}
}
