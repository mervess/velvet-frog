package matrix;

import storage.Float3;
import storage.Float4;
import uk.ac.man.cs.slam.numeric.ArithmeticMatrix;
import uk.ac.man.cs.slam.numeric.ArithmeticVector;
import uk.ac.man.cs.slam.numeric.builder.MatrixBuilder;

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
public class Matrix4f implements IMatrix<Matrix4f>
{
	public float m00, m01, m02, m03,
				 m10, m11, m12, m13,
				 m20, m21, m22, m23,
				 m30, m31, m32, m33;
	
	/**
	 * Constructs a 4x4 identity matrix in default.
	 */
	public Matrix4f()
	{
		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;
			m10 = 0.0f;
			m11 = 1.0f;
			m12 = 0.0f;
			m13 = 0.0f;
				m20 = 0.0f;
				m21 = 0.0f;
				m22 = 1.0f;
				m23 = 0.0f;
					m30 = 0.0f;
					m31 = 0.0f;
					m32 = 0.0f;
					m33 = 1.0f;
	}
	
	public Matrix4f(float scalar)
	{
		m00 = scalar;
		m01 = scalar;
		m02 = scalar;
		m03 = scalar;
			m10 = scalar;
			m11 = scalar;
			m12 = scalar;
			m13 = scalar;
				m20 = scalar;
				m21 = scalar;
				m22 = scalar;
				m23 = scalar;
					m30 = scalar;
					m31 = scalar;
					m32 = scalar;
					m33 = scalar;
	}
	
	public Matrix4f(float m00, float m01, float m02, float m03,
		            float m10, float m11, float m12, float m13,
		            float m20, float m21, float m22, float m23,
		            float m30, float m31, float m32, float m33)
    {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
			this.m10 = m10;
			this.m11 = m11;
			this.m12 = m12;
			this.m13 = m13;
				this.m20 = m20;
				this.m21 = m21;
				this.m22 = m22;
				this.m23 = m23;
					this.m30 = m30;
					this.m31 = m31;
					this.m32 = m32;
					this.m33 = m33;
	}
	
	public Matrix4f(float[] array)
	{
		int index = 0;
		
		m00 = array[index++];
		m01 = array[index++];
		m02 = array[index++];
		m03 = array[index++];
			m10 = array[index++];
			m11 = array[index++];
			m12 = array[index++];
			m13 = array[index++];
				m20 = array[index++];
				m21 = array[index++];
				m22 = array[index++];
				m23 = array[index++];
					m30 = array[index++];
					m31 = array[index++];
					m32 = array[index++];
					m33 = array[index++];
	}
	
	
	@Override
	public Matrix4f div(float scalar)
	{
		return new Matrix4f(
				m00/scalar, m01/scalar, m02/scalar, m03/scalar,
		        m10/scalar, m11/scalar, m12/scalar, m13/scalar,
		        m20/scalar, m21/scalar, m22/scalar, m23/scalar,
		        m30/scalar, m31/scalar, m32/scalar, m33/scalar);
	}
	
	public Matrix4f divI(float scalar)
	{
		m00 /= scalar;
		m01 /= scalar;
		m02 /= scalar;
		m03 /= scalar;
			m10 /= scalar;
			m11 /= scalar;
			m12 /= scalar;
			m13 /= scalar;
				m20 /= scalar;
				m21 /= scalar;
				m22 /= scalar;
				m23 /= scalar;
					m30 /= scalar;
					m31 /= scalar;
					m32 /= scalar;
					m33 /= scalar;
		return this;
	}

	@Override
	public Matrix4f mult(float scalar)
	{
		return new Matrix4f(
				m00*scalar, m01*scalar, m02*scalar, m03*scalar,
		        m10*scalar, m11*scalar, m12*scalar, m13*scalar,
		        m20*scalar, m21*scalar, m22*scalar, m23*scalar,
		        m30*scalar, m31*scalar, m32*scalar, m33*scalar);
	}

	public Matrix4f multI(float scalar)
	{
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;
		m03 *= scalar;
			m10 *= scalar;
			m11 *= scalar;
			m12 *= scalar;
			m13 *= scalar;
				m20 *= scalar;
				m21 *= scalar;
				m22 *= scalar;
				m23 *= scalar;
					m30 *= scalar;
					m31 *= scalar;
					m32 *= scalar;
					m33 *= scalar;
		return this;
	}
	
	@Override
	public Matrix4f add(Matrix4f matrix)
	{
		return new Matrix4f(
				m00+matrix.m00, m01+matrix.m01, m02+matrix.m02, m03+matrix.m03, 
				m10+matrix.m10, m11+matrix.m11, m12+matrix.m12, m13+matrix.m13, 
				m20+matrix.m20, m21+matrix.m21, m22+matrix.m22, m23+matrix.m23,
				m30+matrix.m30, m31+matrix.m31, m32+matrix.m32, m33+matrix.m33);
	}

	public Matrix4f addI(Matrix4f matrix)
	{
		m00 += matrix.m00;
		m01 += matrix.m01;
		m02 += matrix.m02;
		m03 += matrix.m03;
			m10 += matrix.m10;
			m11 += matrix.m11;
			m12 += matrix.m12;
			m13 += matrix.m13;
				m20 += matrix.m20;
				m21 += matrix.m21;
				m22 += matrix.m22;
				m23 += matrix.m23;
					m30 += matrix.m30;
					m31 += matrix.m31;
					m32 += matrix.m32;
					m33 += matrix.m33;
		return this;
	}
	
	@Override
	public Matrix4f sub(Matrix4f matrix)
	{
		return new Matrix4f(
				m00-matrix.m00, m01-matrix.m01, m02-matrix.m02, m03-matrix.m03, 
				m10-matrix.m10, m11-matrix.m11, m12-matrix.m12, m13-matrix.m13, 
				m20-matrix.m20, m21-matrix.m21, m22-matrix.m22, m23-matrix.m23,
				m30-matrix.m30, m31-matrix.m31, m32-matrix.m32, m33-matrix.m33);
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
		return (m00*m00) + (m01*m01) + (m02*m02) + (m03*m03) +
			   (m10*m10) + (m11*m11) + (m12*m12) + (m13*m13) +
			   (m20*m20) + (m21*m21) + (m22*m22) + (m23*m23) +
			   (m30*m30) + (m31*m31) + (m32*m32) + (m33*m33);
	}

	@Override
	public float sum()
	{
		return m00 + m01 + m02 + m03 +
			   m10 + m11 + m12 + m13 +
			   m20 + m21 + m22 + m23 +
			   m30 + m31 + m32 + m33;
	}

	@Override
	public Matrix4f inverse()
	{
		// TODO Auto-generated method stub
		final MatrixBuilder<ArithmeticMatrix, ArithmeticVector> matrix = 
				ArithmeticMatrix.createBuilder(getRowCount(), getColumnCount());
		for (int i=0; i<getRowCount(); i++) {
			for (int j=0; j<getColumnCount(); j++) {
				matrix.set(i, j, get(i, j));
			}
		}
		
		final ArithmeticMatrix invMatrix = matrix.build().inverse();
		final Matrix4f newMatrix = new Matrix4f();
		
		for (int i=0; i<getRowCount(); i++) {
			for (int j=0; j<getColumnCount(); j++) {
				newMatrix.set(i, j, invMatrix.get(i, j));
			}
		}
		
		return newMatrix;
	}

	@Override
	public Matrix4f multDiagonal(float scalar)
	{
		return new Matrix4f(
				m00*scalar, m01, 		m02, 		m03,
		        m10, 		m11*scalar, m12, 		m13,
		        m20, 		m21, 		m22*scalar, m23,
		        m30, 		m31, 		m32, 		m33*scalar);
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
		switch (index) {
			case 0:
				return m00;
			case 1:
				return m01;
			case 2:
				return m02;
			case 3:
				return m03;
			case 4:
				return m10;
			case 5:
				return m11;
			case 6:
				return m12;
			case 7:
				return m13;
			case 8:
				return m20;
			case 9:
				return m21;
			case 10:
				return m22;
			case 11:
				return m23;
			case 12:
				return m30;
			case 13:
				return m31;
			case 14:
				return m32;
			case 15:
				return m33;
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix4f - get("+index+")");
		}
	}
	
	@Override
	public Matrix4f set(int index, float value)
	{
		switch (index) {
			case 0:
				m00 = value;
				break;
			case 1:
				m01 = value;
				break;
			case 2:
				m02 = value;
				break;
			case 3:
				m03 = value; //-- end of row 0
				break;
			case 4:
				m10 = value;
				break;
			case 5:
				m11 = value;
				break;
			case 6:
				m12 = value;
				break;
			case 7:
				m13 = value; //-- end of row 1
				break;
			case 8:
				m20 = value;
				break;
			case 9:
				m21 = value;
				break;
			case 10:
				m22 = value;
				break;
			case 11:
				m23 = value; //-- end of row 2
				break;
			case 12:
				m30 = value;
				break;
			case 13:
				m31 = value;
				break;
			case 14:
				m32 = value;
				break;
			case 15:
				m33 = value; //-- end of row 3
				break; 
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix4f - set("+index+", "+value+")");
		}
		return this;
	}
	
	@Override
	public float get(int row, int col)
	{
		switch (row) {
	        case 0:
	        	switch (col) {
		        	case 0:
		        		return m00;
		        	case 1:
		        		return m01;
		        	case 2:
		        		return m02;
		        	case 3:
		        		return m03;
	        	}
	        	
	        case 1:
	        	switch (col) {
		        	case 0:
		        		return m10;
		        	case 1:
		        		return m11;
		        	case 2:
		        		return m12;
		        	case 3:
		        		return m13;
	        	}
	        	
	        case 2:
	        	switch (col) {
		        	case 0:
		        		return m20;
		        	case 1:
		        		return m21;
		        	case 2:
		        		return m22;
		        	case 3:
		        		return m23;
	        	}
	        	
	        case 3:
	        	switch (col) {
		        	case 0:
		        		return m30;
		        	case 1:
		        		return m31;
		        	case 2:
		        		return m32;
		        	case 3:
		        		return m33;
	        	}
	        	
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix4f - get("+row+", "+col+")");
	    }
	}

	@Override
	public Matrix4f set(int row, int col, float value)
	{
		switch (row) {
	        case 0:
	        	switch (col) {
		        	case 0:
		        		m00 = value;
		        		break;
		        	case 1:
		        		m01 = value;
		        		break;
		        	case 2:
		        		m02 = value;
		        		break;
		        	case 3:
		        		m03 = value;
		        		break;
	        	}
	        	break;
	        	
	        case 1:
	        	switch (col) {
		        	case 0:
		        		m10 = value;
		        		break;
		        	case 1:
		        		m11 = value;
		        		break;
		        	case 2:
		        		m12 = value;
		        		break;
		        	case 3:
		        		m13 = value;
		        		break;
	        	}
	        	break;
	        	
	        case 2:
	        	switch (col) {
		        	case 0:
		        		m20 = value;
		        		break;
		        	case 1:
		        		m21 = value;
		        		break;
		        	case 2:
		        		m22 = value;
		        		break;
		        	case 3:
		        		m23 = value;
		        		break;
	        	}
	        	break;
	        	
	        case 3:
	        	switch (col) {
		        	case 0:
		        		m30 = value;
		        		break;
		        	case 1:
		        		m31 = value;
		        		break;
		        	case 2:
		        		m32 = value;
		        		break;
		        	case 3:
		        		m33 = value;
		        		break;
	        	}
	        	break;
	        	
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix4f - set("+row+", "+col+", "+value+")");
	    }
		return this;
	}
	
	public Matrix4f set(int row, int col, Matrix3f mat)
	{
		switch (row) { 
	        case 0:
	        	switch (col) {
		        	case 0:
		        		m00 = mat.m00;
		        		m01 = mat.m01;
		        		m02 = mat.m02;
			        		m10 = mat.m10;
			        		m11 = mat.m11;
			        		m12 = mat.m12;
				        		m20 = mat.m20;
				        		m21 = mat.m21;
				        		m22 = mat.m22;
		        		break;
		        	case 1:
		        		m01 = mat.m00;
		        		m02 = mat.m01;
		        		m03 = mat.m02;
			        		m11 = mat.m10;
			        		m12 = mat.m11;
			        		m13 = mat.m12;
				        		m21 = mat.m20;
				        		m22 = mat.m21;
				        		m23 = mat.m22;
		        		break;
	        	}
	        	break;
	        	
	        case 1:
	        	switch (col) {
		        	case 0:
		        		m10 = mat.m00;
		        		m11 = mat.m01;
		        		m12 = mat.m02;
			        		m20 = mat.m10;
			        		m21 = mat.m11;
			        		m22 = mat.m12;
				        		m30 = mat.m20;
				        		m31 = mat.m21;
				        		m32 = mat.m22;
		        		break;
		        	case 1:
		        		m11 = mat.m00;
		        		m12 = mat.m01;
		        		m13 = mat.m02;
			        		m21 = mat.m10;
			        		m22 = mat.m11;
			        		m23 = mat.m12;
				        		m31 = mat.m20;
				        		m32 = mat.m21;
				        		m33 = mat.m22;
		        		break;
	        	}
	        	break;

	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix4f");
	    }
		return this;
	}
	
	public void setColumn(int col, Float4 vector)
	{
		switch (col) {
	        case 0:
	        	m00 = vector.getX();
	        	m10 = vector.getY();
	        	m20 = vector.getZ();
	        	m30 = vector.getW();
	        	break;
	        case 1:
	        	m01 = vector.getX();
	        	m11 = vector.getY();
	        	m21 = vector.getZ();
	        	m31 = vector.getW();
	        	break;
	        case 2:
	        	m02 = vector.getX();
	        	m12 = vector.getY();
	        	m22 = vector.getZ();
	        	m32 = vector.getW();
	        	break;
	        case 3:
	        	m03 = vector.getX();
	        	m13 = vector.getY();
	        	m23 = vector.getZ();
	        	m33 = vector.getW();
	        	break;
	        default:
	        	throw new ArrayIndexOutOfBoundsException("Matrix4f.setColumn: "+col+" - "+vector.toString());
		}
	}
	
	public void setColumn(int col, Float3 vector)
	{
		switch (col) {
	        case 0:
	        	m00 = vector.getX();
	        	m10 = vector.getY();
	        	m20 = vector.getZ();
	        	break;
	        case 1:
	        	m01 = vector.getX();
	        	m11 = vector.getY();
	        	m21 = vector.getZ();
	        	break;
	        case 2:
	        	m02 = vector.getX();
	        	m12 = vector.getY();
	        	m22 = vector.getZ();
	        	break;
	        case 3:
	        	m03 = vector.getX();
	        	m13 = vector.getY();
	        	m23 = vector.getZ();
	        	break;
	        default:
	        	throw new ArrayIndexOutOfBoundsException("Matrix4f.setColumn: "+col+" - "+vector.toString());
		}
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
		return new Matrix4f(m00, m10, m20, m30,
							m01, m11, m21, m31,
							m02, m12, m22, m32,
							m03, m13, m23, m33);
	}

	@Override
	public Matrix4f negate()
	{
		return new Matrix4f(-m00, -m01, -m02, -m03,
							-m10, -m11, -m12, -m13,
							-m20, -m21, -m22, -m23,
							-m30, -m31, -m32, -m33);
	}
	
	@Override
	public Matrix4f copy()
	{
		return new Matrix4f(m00, m01, m02, m03,
							m10, m11, m12, m13,
							m20, m21, m22, m23,
							m30, m31, m32, m33);
	}

	@Override
	public String toString()
	{
		return "Matrix4f:\n" +
			   m00 + ", " + m01 + ", " + m02 + ", " + m03 + "\n" +
			   m10 + ", " + m11 + ", " + m12 + ", " + m13 + "\n" +
			   m20 + ", " + m21 + ", " + m22 + ", " + m23 + "\n" +
			   m30 + ", " + m31 + ", " + m32 + ", " + m33 + "\n";
	}
}
