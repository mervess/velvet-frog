package matrix;

import storage.Float3;

/**
 * Float Matrix 3x3
 * Represents:
		m00, m01, m02 
	    m10, m11, m12 
	    m20, m21, m22
 *
 * @author mervess
 *
 */
public class Matrix3f extends com.sun.javafx.geom.Matrix3f implements IMatrix<Matrix3f>
{

	public static final Matrix3f IDENTITY = new Matrix3f();
	
	public Matrix3f()
	{
		super();
	}
	
	public Matrix3f(float m00, float m01, float m02,
		            float m10, float m11, float m12,
		            float m20, float m21, float m22)
	{
		super(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}
	
	public Matrix3f(float[] matrix)
	{
		super(matrix);
	}
	
	@Override
	public Matrix3f div(float scalar)
	{
		return new Matrix3f(m00/scalar, m01/scalar, m02/scalar, 
					        m10/scalar, m11/scalar, m12/scalar, 
					        m20/scalar, m21/scalar, m22/scalar);
	}

	@Override
	public Matrix3f mult(float scalar)
	{
		return new Matrix3f(m00*scalar, m01*scalar, m02*scalar, 
					        m10*scalar, m11*scalar, m12*scalar, 
					        m20*scalar, m21*scalar, m22*scalar);
	}

	@Override
	public Matrix3f add(Matrix3f matrix)
	{
		return new Matrix3f(m00+matrix.m00, m01+matrix.m01, m02+matrix.m02, 
							m10+matrix.m10, m11+matrix.m11, m12+matrix.m12,
							m20+matrix.m20, m21+matrix.m21, m22+matrix.m22);
	}
	
	public Matrix3f addI(Matrix3f matrix)
	{
		m00 += matrix.m00;
		m01 += matrix.m01; 
		m02 += matrix.m02; 
			m10 += matrix.m10; 
			m11 += matrix.m11; 
			m12 += matrix.m12;
		        m20 += matrix.m20; 
		        m21 += matrix.m21; 
		        m22 += matrix.m22;
		return this;
	}

	@Override
	public Matrix3f sub(Matrix3f matrix)
	{
		return new Matrix3f(m00-matrix.m00, m01-matrix.m01, m02-matrix.m02, 
							m10-matrix.m10, m11-matrix.m11, m12-matrix.m12,
							m20-matrix.m20, m21-matrix.m21, m22-matrix.m22);
	}
	
	public Matrix3f subI(Matrix3f matrix)
	{
		m00 -= matrix.m00;
		m01 -= matrix.m01; 
		m02 -= matrix.m02; 
			m10 -= matrix.m10; 
			m11 -= matrix.m11; 
			m12 -= matrix.m12;
		        m20 -= matrix.m20; 
		        m21 -= matrix.m21; 
		        m22 -= matrix.m22;
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
                }
                newMatrix[index++] = value;
			}
		}
		return new Matrix3f(newMatrix);
	}
	
	/**
	 * 
	 * @param Float3 storage 
	 * @return
	 */
	public Float3 mult(Float3 storage)
	{
		return new Float3(storage.dot( getRow(0) ), 
						  storage.dot( getRow(1) ),
						  storage.dot( getRow(2) ));
	}

	@Override
	public float normSquared()
	{
		return (m00*m00) + (m01*m01) + (m02*m02) +
			   (m10*m10) + (m11*m11) + (m12*m12) +
			   (m20*m20) + (m21*m21) + (m22*m22);
	}

	@Override
	public float sum()
	{
		return m00 + m01 + m02 +
			   m10 + m11 + m12 +
			   m20 + m21 + m22;
	}

	@Override
	public Matrix3f multDiagonal(float scalar)
	{
		return new Matrix3f(m00*scalar, m01, 		m02, 
					        m10, 		m11*scalar, m12, 
					        m20, 		m21, 		m22*scalar);
	}

	@Override
	public Matrix3f transpose()
	{
		return new Matrix3f(m00, m10, m20, 
					        m01, m11, m21, 
					        m02, m12, m22);
	}

	@Override
	public Matrix3f negate()
	{
		return new Matrix3f(-m00, -m01, -m02, 
					        -m10, -m11, -m12, 
					        -m20, -m21, -m22);
	}
	
	public float determinant()
	{
		return m00 * ( (m11*m22) - (m12*m21) )
			 - m01 * ( (m10*m22) - (m12*m20) )
			 + m02 * ( (m10*m21) - (m11*m20) );
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
		switch (index) {
			case 0:
				return m00;
			case 1:
				return m01;
			case 2:
				return m02;
			case 3:
				return m10;
			case 4:
				return m11;
			case 5:
				return m12;
			case 6:
				return m20;
			case 7:
				return m21;
			case 8:
				return m22;
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f - get("+index+")");
		}
	}
	
	@Override
	public Matrix3f set(int index, float value)
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
				m10 = value;
				break;
			case 4:
				m11 = value;
				break;
			case 5:
				m12 = value;
				break;
			case 6:
				m20 = value;
				break;
			case 7:
				m21 = value;
				break;
			case 8:
				m22 = value;
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f");
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
	        	}
	        	
	        case 1:
	        	switch (col) {
		        	case 0:
		        		return m10;
		        	case 1:
		        		return m11;
		        	case 2:
		        		return m12;
	        	}
	        	
	        case 2:
	        	switch (col) {
		        	case 0:
		        		return m20;
		        	case 1:
		        		return m21;
		        	case 2:
		        		return m22;
	        	}
	        	
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f");
	    }
	}
	
	@Override
	public Matrix3f set(int row, int col, float value)
	{
		switch (row) {
	        case 0:
	        	switch (col) {
		        	case 0:
		        		this.m00 = value;
		        		break;
		        	case 1:
		        		this.m01 = value;
		        		break;
		        	case 2:
		        		this.m02 = value;
		        		break;
	        	}
	        	break;
	        	
	        case 1:
	        	switch (col) {
		        	case 0:
		        		this.m10 = value;
		        		break;
		        	case 1:
		        		this.m11 = value;
		        		break;
		        	case 2:
		        		this.m12 = value;
		        		break;
	        	}
	        	break;
	        	
	        case 2:
	        	switch (col) {
		        	case 0:
		        		this.m20 = value;
		        		break;
		        	case 1:
		        		this.m21 = value;
		        		break;
		        	case 2:
		        		this.m22 = value;
		        		break;
	        	}
	        	break;
	        	
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f");
	    }
		return this;
	}
	
	public Float3 getColumn(int col)
	{
		switch (col) {
	        case 0:
	        	return new Float3(m00, m10, m20);
	        case 1:
	        	return new Float3(m01, m11, m21);
	        case 2:
	        	return new Float3(m02, m12, m22);
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f");
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
	        default:
	        	throw new ArrayIndexOutOfBoundsException("Matrix3f.setColumn: "+col+" - "+vector.toString());
		}
	}
	
	public Float3 getRow(int row)
	{
		switch (row) {
	        case 0:
	        	return new Float3(m00, m01, m02);
	        case 1:
	        	return new Float3(m10, m11, m12);
	        case 2:
	        	return new Float3(m20, m21, m22);
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix3f - getRow("+row+")");
	    }
	}
	
	public void setRow(int row, Float3 vector)
	{
		switch (row) {
	        case 0:
	        	m00 = vector.getX();
	        	m01 = vector.getY();
	        	m02 = vector.getZ();
	        	break;
	        case 1:
	        	m10 = vector.getX();
	        	m11 = vector.getY();
	        	m12 = vector.getZ();
	        	break;
	        case 2:
	        	m20 = vector.getX();
	        	m21 = vector.getY();
	        	m22 = vector.getZ();
	        	break;
	        default:
	        	throw new ArrayIndexOutOfBoundsException("Matrix3f-setRow: "+row+" - "+vector.toString());
		}
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
	 */
	
	public Matrix3f inverse()
	{
		Matrix3f matrix = new Matrix3f();
		calcMatrixOfMinors(matrix);
		calcMatrixOfCofactors(matrix);
		calcAdjointMatrix(matrix);
		multByDeterminant(matrix);
		return matrix;
	}
	
	/**
	 * m00, m01, m02 
	   m10, m11, m12 
	   m20, m21, m22
	 */
	private void calcMatrixOfMinors(Matrix3f matrixOfMinors)
	{
		matrixOfMinors.m00 = (m11*m22) - (m12*m21);
		matrixOfMinors.m01 = (m10*m22) - (m12*m20);
		matrixOfMinors.m02 = (m10*m21) - (m11*m20);
		
		matrixOfMinors.m10 = (m01*m22) - (m02*m21);
		matrixOfMinors.m11 = (m00*m22) - (m02*m20);
		matrixOfMinors.m12 = (m00*m21) - (m01*m20);
		
		matrixOfMinors.m20 = (m01*m12) - (m02*m11);
		matrixOfMinors.m21 = (m00*m12) - (m02*m10);
		matrixOfMinors.m22 = (m00*m11) - (m01*m10);
	}
	
	/**
	   +, -, + 
	   -, +, - 
	   +, -, +
	 */
	private void calcMatrixOfCofactors(Matrix3f matrix)
	{
		matrix.m01 = -matrix.m01;
		matrix.m10 = -matrix.m10;
		matrix.m21 = -matrix.m21;
		matrix.m12 = -matrix.m12;
	}
	
	/**
	 * m00, m10, m20 
	   m01, m11, m21 
	   m02, m12, m22
	 * transpose | adjugate
	 */
	private void calcAdjointMatrix(Matrix3f matrix)
	{
		float temp = matrix.m01;
		matrix.m01 = matrix.m10;
		matrix.m10 = temp;
		
		temp = matrix.m02;
		matrix.m02 = matrix.m20;
		matrix.m20 = temp;
		
		temp = matrix.m12;
		matrix.m12 = matrix.m21;
		matrix.m21 = temp;
	}
	
	private void multByDeterminant(Matrix3f matrix)
	{
		float det = (this.m00*matrix.m00) // took from matrix of minors' original form
						- (this.m01*-(matrix.m10))
						+ (this.m02*matrix.m20);
		
		// Mult by 1/det 
		matrix.m00 /= det;
		matrix.m01 /= det;
		matrix.m02 /= det;
			matrix.m10 /= det;
			matrix.m11 /= det;
			matrix.m12 /= det;
				matrix.m20 /= det;
				matrix.m21 /= det;
				matrix.m22 /= det;
	}
	
	@Override
	public Matrix3f copy()
	{
		return new Matrix3f(m00, m01, m02, 
					        m10, m11, m12, 
					        m20, m21, m22);
	}
	
	@Override
	public String toString()
	{
		return "Matrix3f:\n" + super.toString();
	}
}
