package matrix;

import Jama.Matrix;
import storage.Float6;

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
public class Matrix6f implements IMatrix<Matrix6f>
{
	public float m00, m01, m02, m03, m04, m05,
				 m10, m11, m12, m13, m14, m15,
				 m20, m21, m22, m23, m24, m25,
				 m30, m31, m32, m33, m34, m35,
				 m40, m41, m42, m43, m44, m45,
				 m50, m51, m52, m53, m54, m55;
	
	/**
	 * Constructs a 6x6 identity matrix in default.
	 */
	public Matrix6f()
	{
		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;
		m04 = 0.0f;
		m05 = 0.0f;
			m10 = 0.0f;
			m11 = 1.0f;
			m12 = 0.0f;
			m13 = 0.0f;
			m14 = 0.0f;
			m15 = 0.0f;
				m20 = 0.0f;
				m21 = 0.0f;
				m22 = 1.0f;
				m23 = 0.0f;
				m24 = 0.0f;
				m25 = 0.0f;
					m30 = 0.0f;
					m31 = 0.0f;
					m32 = 0.0f;
					m33 = 1.0f;
					m34 = 0.0f;
					m35 = 0.0f;
						m40 = 0.0f;
						m41 = 0.0f;
						m42 = 0.0f;
						m43 = 0.0f;
						m44 = 1.0f;
						m45 = 0.0f;
							m50 = 0.0f;
							m51 = 0.0f;
							m52 = 0.0f;
							m53 = 0.0f;
							m54 = 0.0f;
							m55 = 1.0f;
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
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m04 = m04;
		this.m05 = m05;
			this.m10 = m10;
			this.m11 = m11;
			this.m12 = m12;
			this.m13 = m13;
			this.m14 = m14;
			this.m15 = m15;
				this.m20 = m20;
				this.m21 = m21;
				this.m22 = m22;
				this.m23 = m23;
				this.m24 = m24;
				this.m25 = m25;
					this.m30 = m30;
					this.m31 = m31;
					this.m32 = m32;
					this.m33 = m33;
					this.m34 = m34;
					this.m35 = m35;
						this.m40 = m40;
						this.m41 = m41;
						this.m42 = m42;
						this.m43 = m43;
						this.m44 = m44;
						this.m45 = m45;
							this.m50 = m50;
							this.m51 = m51;
							this.m52 = m52;
							this.m53 = m53;
							this.m54 = m54;
							this.m55 = m55;
	}
	
	public Matrix6f(float[] array)
	{
		int index = 0;
		
		m00 = array[index++];
		m01 = array[index++];
		m02 = array[index++];
		m03 = array[index++];
		m04 = array[index++];
		m05 = array[index++];
			m10 = array[index++];
			m11 = array[index++];
			m12 = array[index++];
			m13 = array[index++];
			m14 = array[index++];
			m15 = array[index++];
				m20 = array[index++];
				m21 = array[index++];
				m22 = array[index++];
				m23 = array[index++];
				m24 = array[index++];
				m25 = array[index++];
					m30 = array[index++];
					m31 = array[index++];
					m32 = array[index++];
					m33 = array[index++];
					m34 = array[index++];
					m35 = array[index++];
						m40 = array[index++];
						m41 = array[index++];
						m42 = array[index++];
						m43 = array[index++];
						m44 = array[index++];
						m45 = array[index++];
							m50 = array[index++];
							m51 = array[index++];
							m52 = array[index++];
							m53 = array[index++];
							m54 = array[index++];
							m55 = array[index++];
	}
	
	public Matrix6f (double[][] array)
	{
		int i = 0, j = 0;
		
		m00 = (float)array[i][j++];
		m01 = (float)array[i][j++];
		m02 = (float)array[i][j++];
		m03 = (float)array[i][j++];
		m04 = (float)array[i][j++];
		m05 = (float)array[i][j++];
			j = 0;
			m10 = (float)array[++i][j++];
			m11 = (float)array[i][j++];
			m12 = (float)array[i][j++];
			m13 = (float)array[i][j++];
			m14 = (float)array[i][j++];
			m15 = (float)array[i][j++];
				j = 0;
				m20 = (float)array[++i][j++];
				m21 = (float)array[i][j++];
				m22 = (float)array[i][j++];
				m23 = (float)array[i][j++];
				m24 = (float)array[i][j++];
				m25 = (float)array[i][j++];
					j = 0;
					m30 = (float)array[++i][j++];
					m31 = (float)array[i][j++];
					m32 = (float)array[i][j++];
					m33 = (float)array[i][j++];
					m34 = (float)array[i][j++];
					m35 = (float)array[i][j++];
						j = 0;
						m40 = (float)array[++i][j++];
						m41 = (float)array[i][j++];
						m42 = (float)array[i][j++];
						m43 = (float)array[i][j++];
						m44 = (float)array[i][j++];
						m45 = (float)array[i][j++];
							j = 0;
							m50 = (float)array[++i][j++];
							m51 = (float)array[i][j++];
							m52 = (float)array[i][j++];
							m53 = (float)array[i][j++];
							m54 = (float)array[i][j++];
							m55 = (float)array[i][j++];
	}
	
	@Override
	public Matrix6f div(float scalar)
	{
		return new Matrix6f(
				 m00/scalar, m01/scalar, m02/scalar, m03/scalar, m04/scalar, m05/scalar,
				 m10/scalar, m11/scalar, m12/scalar, m13/scalar, m14/scalar, m15/scalar,
				 m20/scalar, m21/scalar, m22/scalar, m23/scalar, m24/scalar, m25/scalar,
				 m30/scalar, m31/scalar, m32/scalar, m33/scalar, m34/scalar, m35/scalar,
				 m40/scalar, m41/scalar, m42/scalar, m43/scalar, m44/scalar, m45/scalar,
				 m50/scalar, m51/scalar, m52/scalar, m53/scalar, m54/scalar, m55/scalar);
	}
	
	public Matrix6f divI(float scalar)
	{
		m00 /= scalar;
		m01 /= scalar;
		m02 /= scalar;
		m03 /= scalar;
		m04 /= scalar;
		m05 /= scalar;
			m10 /= scalar;
			m11 /= scalar;
			m12 /= scalar;
			m13 /= scalar;
			m14 /= scalar;
			m15 /= scalar;
				m20 /= scalar;
				m21 /= scalar;
				m22 /= scalar;
				m23 /= scalar;
				m24 /= scalar;
				m25 /= scalar;
					m30 /= scalar;
					m31 /= scalar;
					m32 /= scalar;
					m33 /= scalar;
					m34 /= scalar;
					m35 /= scalar;
						m40 /= scalar;
						m41 /= scalar;
						m42 /= scalar;
						m43 /= scalar;
						m44 /= scalar;
						m45 /= scalar;
							m50 /= scalar;
							m51 /= scalar;
							m52 /= scalar;
							m53 /= scalar;
							m54 /= scalar;
							m55 /= scalar;
		return this;
	}

	@Override
	public Matrix6f mult(float scalar)
	{
		return new Matrix6f(
				 m00*scalar, m01*scalar, m02*scalar, m03*scalar, m04*scalar, m05*scalar,
				 m10*scalar, m11*scalar, m12*scalar, m13*scalar, m14*scalar, m15*scalar,
				 m20*scalar, m21*scalar, m22*scalar, m23*scalar, m24*scalar, m25*scalar,
				 m30*scalar, m31*scalar, m32*scalar, m33*scalar, m34*scalar, m35*scalar,
				 m40*scalar, m41*scalar, m42*scalar, m43*scalar, m44*scalar, m45*scalar,
				 m50*scalar, m51*scalar, m52*scalar, m53*scalar, m54*scalar, m55*scalar);
	}
	
	public Matrix6f multI(float scalar)
	{
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;
		m03 *= scalar;
		m04 *= scalar;
		m05 *= scalar;
			m10 *= scalar;
			m11 *= scalar;
			m12 *= scalar;
			m13 *= scalar;
			m14 *= scalar;
			m15 *= scalar;
				m20 *= scalar;
				m21 *= scalar;
				m22 *= scalar;
				m23 *= scalar;
				m24 *= scalar;
				m25 *= scalar;
					m30 *= scalar;
					m31 *= scalar;
					m32 *= scalar;
					m33 *= scalar;
					m34 *= scalar;
					m35 *= scalar;
						m40 *= scalar;
						m41 *= scalar;
						m42 *= scalar;
						m43 *= scalar;
						m44 *= scalar;
						m45 *= scalar;
							m50 *= scalar;
							m51 *= scalar;
							m52 *= scalar;
							m53 *= scalar;
							m54 *= scalar;
							m55 *= scalar;
		return this;
	}

	@Override
	public Matrix6f add(Matrix6f matrix)
	{
		return new Matrix6f(
				 m00+matrix.m00, m01+matrix.m01, m02+matrix.m02, m03+matrix.m03, m04+matrix.m04, m05+matrix.m05,
				 m10+matrix.m10, m11+matrix.m11, m12+matrix.m12, m13+matrix.m13, m14+matrix.m14, m15+matrix.m15,
				 m20+matrix.m20, m21+matrix.m21, m22+matrix.m22, m23+matrix.m23, m24+matrix.m24, m25+matrix.m25,
				 m30+matrix.m30, m31+matrix.m31, m32+matrix.m32, m33+matrix.m33, m34+matrix.m34, m35+matrix.m35,
				 m40+matrix.m40, m41+matrix.m41, m42+matrix.m42, m43+matrix.m43, m44+matrix.m44, m45+matrix.m45,
				 m50+matrix.m50, m51+matrix.m51, m52+matrix.m52, m53+matrix.m53, m54+matrix.m54, m55+matrix.m55);
	}
	
	public Matrix6f addI(Matrix6f matrix)
	{
		m00 += matrix.m00;
		m01 += matrix.m01;
		m02 += matrix.m02;
		m03 += matrix.m03;
		m04 += matrix.m04;
		m05 += matrix.m05;
			m10 += matrix.m10;
			m11 += matrix.m11;
			m12 += matrix.m12;
			m13 += matrix.m13;
			m14 += matrix.m14;
			m15 += matrix.m15;
				m20 += matrix.m20;
				m21 += matrix.m21;
				m22 += matrix.m22;
				m23 += matrix.m23;
				m24 += matrix.m24;
				m25 += matrix.m25;
					m30 += matrix.m30;
					m31 += matrix.m31;
					m32 += matrix.m32;
					m33 += matrix.m33;
					m34 += matrix.m34;
					m35 += matrix.m35;
						m40 += matrix.m40;
						m41 += matrix.m41;
						m42 += matrix.m42;
						m43 += matrix.m43;
						m44 += matrix.m44;
						m45 += matrix.m45;
							m50 += matrix.m50;
							m51 += matrix.m51;
							m52 += matrix.m52;
							m53 += matrix.m53;
							m54 += matrix.m54;
							m55 += matrix.m55;
		return this;
	}

	@Override
	public Matrix6f sub(Matrix6f matrix)
	{
		return new Matrix6f(
				 m00-matrix.m00, m01-matrix.m01, m02-matrix.m02, m03-matrix.m03, m04-matrix.m04, m05-matrix.m05,
				 m10-matrix.m10, m11-matrix.m11, m12-matrix.m12, m13-matrix.m13, m14-matrix.m14, m15-matrix.m15,
				 m20-matrix.m20, m21-matrix.m21, m22-matrix.m22, m23-matrix.m23, m24-matrix.m24, m25-matrix.m25,
				 m30-matrix.m30, m31-matrix.m31, m32-matrix.m32, m33-matrix.m33, m34-matrix.m34, m35-matrix.m35,
				 m40-matrix.m40, m41-matrix.m41, m42-matrix.m42, m43-matrix.m43, m44-matrix.m44, m45-matrix.m45,
				 m50-matrix.m50, m51-matrix.m51, m52-matrix.m52, m53-matrix.m53, m54-matrix.m54, m55-matrix.m55);
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
		return (m00*m00) + (m01*m01) + (m02*m02) + (m03*m03) + (m04*m04) + (m05*m05) +
			   (m10*m10) + (m11*m11) + (m12*m12) + (m13*m13) + (m14*m14) + (m15*m15) +
			   (m20*m20) + (m21*m21) + (m22*m22) + (m23*m23) + (m24*m24) + (m25*m25) +
			   (m30*m30) + (m31*m31) + (m32*m32) + (m33*m33) + (m34*m34) + (m35*m35) +
			   (m40*m40) + (m41*m41) + (m42*m42) + (m43*m43) + (m44*m44) + (m45*m45) +
			   (m50*m50) + (m51*m51) + (m52*m52) + (m53*m53) + (m54*m54) + (m55*m55);
	}

	@Override
	public float sum()
	{
		return m00 + m01 + m02 + m03 + m04 + m05 +
			   m10 + m11 + m12 + m13 + m14 + m15 +
			   m20 + m21 + m22 + m23 + m24 + m25 +
			   m30 + m31 + m32 + m33 + m34 + m35 +
			   m40 + m41 + m42 + m43 + m44 + m45 +
			   m50 + m51 + m52 + m53 + m54 + m55;
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
		return new Matrix6f(
				m00*scalar, m01, 		m02, 		m03, 		m04, 		m05,
		        m10, 		m11*scalar, m12, 		m13, 		m14, 		m15,
		        m20, 		m21, 		m22*scalar, m23, 		m24, 		m25,
		        m30, 		m31, 		m32, 		m33*scalar, m34, 		m35,
		        m40, 		m41, 		m42, 		m43, 		m44*scalar, m45,
		        m50, 		m51, 		m52, 		m53, 		m54, 		m55*scalar);
	}

	@Override
	public Matrix6f transpose()
	{
		return new Matrix6f(
				m00, m10, m20, m30, m40, m50,
				m01, m11, m21, m31, m41, m51,
				m02, m12, m22, m32, m42, m52,
				m03, m13, m23, m33, m43, m53,
				m04, m14, m24, m34, m44, m54,
				m05, m15, m25, m35, m45, m55);
	}

	@Override
	public Matrix6f negate()
	{
		return new Matrix6f(
				-m00, -m01, -m02, -m03, -m04, -m05,
				-m10, -m11, -m12, -m13, -m14, -m15,
				-m20, -m21, -m22, -m23, -m24, -m25,
				-m30, -m31, -m32, -m33, -m34, -m35,
				-m40, -m41, -m42, -m43, -m44, -m45,
				-m50, -m51, -m52, -m53, -m54, -m55);
	}
	
	private void set(float scalar)
	{
		m00 = scalar;
		m01 = scalar;
		m02 = scalar;
		m03 = scalar;
		m04 = scalar;
		m05 = scalar;
			m10 = scalar;
			m11 = scalar;
			m12 = scalar;
			m13 = scalar;
			m14 = scalar;
			m15 = scalar;
				m20 = scalar;
				m21 = scalar;
				m22 = scalar;
				m23 = scalar;
				m24 = scalar;
				m25 = scalar;
					m30 = scalar;
					m31 = scalar;
					m32 = scalar;
					m33 = scalar;
					m34 = scalar;
					m35 = scalar;
						m40 = scalar;
						m41 = scalar;
						m42 = scalar;
						m43 = scalar;
						m44 = scalar;
						m45 = scalar;
							m50 = scalar;
							m51 = scalar;
							m52 = scalar;
							m53 = scalar;
							m54 = scalar;
							m55 = scalar;
	}

	@Override
	public Matrix6f set(int index, float value)
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
				m03 = value;
				break;
			case 4:
				m04 = value;
				break;
			case 5:
				m05 = value; //-- end of row 0
				break; 
			case 6:
				m10 = value;
				break;
			case 7:
				m11 = value;
				break;
			case 8:
				m12 = value;
				break;
			case 9:
				m13 = value;
				break;
			case 10:
				m14 = value;
				break;
			case 11:
				m15 = value; //-- end of row 1
				break; 
			case 12:
				m20 = value;
				break;
			case 13:
				m21 = value;
				break;
			case 14:
				m22 = value;
				break;
			case 15:
				m23 = value;
				break;
			case 16:
				m24 = value;
				break;
			case 17:
				m25 = value; //-- end of row 2
				break; 
			case 18:
				m30 = value;
				break;
			case 19:
				m31 = value;
				break;
			case 20:
				m32 = value;
				break;
			case 21:
				m33 = value;
				break;
			case 22:
				m34 = value;
				break;
			case 23:
				m35 = value; //-- end of row 3
				break; 
			case 24:
				m40 = value;
				break;
			case 25:
				m41 = value;
				break;
			case 26:
				m42 = value;
				break;
			case 27:
				m43 = value;
				break;
			case 28:
				m44 = value;
				break;
			case 29:
				m45 = value; //-- end of row 4
				break;
			case 30:
				m50 = value;
				break;
			case 31:
				m51 = value;
				break;
			case 32:
				m52 = value;
				break;
			case 33:
				m53 = value;
				break;
			case 34:
				m54 = value;
				break;
			case 35:
				m55 = value; //-- end of row 5
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix6f - set("+index+", "+value+")");
		}
		return this;
	}

	@Override
	public Matrix6f set(int row, int col, float value)
	{
		set(row * 6 + col, value);
		return this;
	}
	
	public Matrix6f set(int row, int col, Matrix3f mat)
	{
		// TODO bu kisim tam degil
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
		        	case 3:
		        		m03 = mat.m00;
		        		m04 = mat.m01;
		        		m05 = mat.m02;
			        		m13 = mat.m10;
			        		m14 = mat.m11;
			        		m15 = mat.m12;
				        		m23 = mat.m20;
				        		m24 = mat.m21;
				        		m25 = mat.m22;
		        		break;
	        	}
	        	break;
	        	
	        case 3:
	        	switch (col) {
		        	case 3:
		        		m33 = mat.m00;
		        		m34 = mat.m01;
		        		m35 = mat.m02;
			        		m43 = mat.m10;
			        		m44 = mat.m11;
			        		m45 = mat.m12;
				        		m53 = mat.m20;
				        		m54 = mat.m21;
				        		m55 = mat.m22;
		        		break;
	        	}
	        	break;
	        	
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix6f");
	    }
		return this;
	}

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
				return m04;
			case 5:
				return m05; //-- end of row 0
			case 6:
				return m10;
			case 7:
				return m11;
			case 8:
				return m12;
			case 9:
				return m13;
			case 10:
				return m14;
			case 11:
				return m15; //-- end of row 1
			case 12:
				return m20;
			case 13:
				return m21;
			case 14:
				return m22;
			case 15:
				return m23;
			case 16:
				return m24;
			case 17:
				return m25; //-- end of row 2
			case 18:
				return m30;
			case 19:
				return m31;
			case 20:
				return m32;
			case 21:
				return m33;
			case 22:
				return m34;
			case 23:
				return m35; //-- end of row 3
			case 24:
				return m40;
			case 25:
				return m41;
			case 26:
				return m42;
			case 27:
				return m43;
			case 28:
				return m44;
			case 29:
				return m45; //-- end of row 4
			case 30:
				return m50;
			case 31:
				return m51;
			case 32:
				return m52;
			case 33:
				return m53;
			case 34:
				return m54;
			case 35:
				return m55; //-- end of row 5
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix6f - get("+index+")");
		}
	}

	@Override
	public float get(int row, int col)
	{
		return get(row * 6 + col);
	}
	
	public float[] getColumn(int col, int rowFrom, int rowTo)
	{
		final float[] column = new float[rowTo-rowFrom];
		int index = 0;
		// TODO!!
		switch (col) {
			case 0:
				
			case 1:
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
				
		}
		
		return column;
	}
	
	public float[] getRow(int row, int colFrom, int colTo)
	{
		// TODO!!
		return null;
	}
	
	public Float6 getRow(int row)
	{
		switch (row) {
			case 0:
				return new Float6(m00, m01, m02, m03, m04, m05);
			case 1:
				return new Float6(m10, m11, m12, m13, m14, m15);
			case 2:
				return new Float6(m20, m21, m22, m23, m24, m25);
			case 3:
				return new Float6(m30, m31, m32, m33, m34, m35);
			case 4:
				return new Float6(m40, m41, m42, m43, m44, m45);
			case 5:
				return new Float6(m50, m51, m52, m53, m54, m55);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix6f - getRow("+row+")");
		}
	}
	
	public Float6 getDiagonal()
	{
		return new Float6(m00, m11, m22, m33, m44, m55);
	}
	
	public float[] getDiagonal(int from, int to)
	{
		final float[] diagonal = new float[to-from];
		int index = 0;
		
		switch (from) {
			case 0:
				diagonal[index++] = m00;
			case 1:
				if (index == diagonal.length) {
					break;
				}
				diagonal[index++] = m11;
			case 2:
				if (index == diagonal.length) {
					break;
				}
				diagonal[index++] = m22;
			case 3:
				if (index == diagonal.length) {
					break;
				}
				diagonal[index++] = m33;
			case 4:
				if (index == diagonal.length) {
					break;
				}
				diagonal[index++] = m44;
			case 5:
				if (index == diagonal.length) {
					break;
				}
				diagonal[index++] = m55;
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
				m00, m01, m02, m03, m04, m05,
				m10, m11, m12, m13, m14, m15,
				m20, m21, m22, m23, m24, m25,
				m30, m31, m32, m33, m34, m35,
				m40, m41, m42, m43, m44, m45,
				m50, m51, m52, m53, m54, m55});
	}
	
	public float[] toArray()
	{
		return new float[]{
				m00, m01, m02, m03, m04, m05,
				m10, m11, m12, m13, m14, m15,
				m20, m21, m22, m23, m24, m25,
				m30, m31, m32, m33, m34, m35,
				m40, m41, m42, m43, m44, m45,
				m50, m51, m52, m53, m54, m55};
	}
	
	public double[][] toDoubleArray()
	{
		return new double[][] {
				{ m00, m01, m02, m03, m04, m05 },
				{ m10, m11, m12, m13, m14, m15 },
				{ m20, m21, m22, m23, m24, m25 },
				{ m30, m31, m32, m33, m34, m35 },
				{ m40, m41, m42, m43, m44, m45 },
				{ m50, m51, m52, m53, m54, m55 } };
	}
	
	@Override
	public Matrix6f copy()
	{
		return new Matrix6f(
				m00, m01, m02, m03, m04, m05,
				m10, m11, m12, m13, m14, m15,
				m20, m21, m22, m23, m24, m25,
				m30, m31, m32, m33, m34, m35,
				m40, m41, m42, m43, m44, m45,
				m50, m51, m52, m53, m54, m55);
	}
	
	public void clear()
	{
		set(0.0f);
	}

	public String toString()
	{
		return "Matrix6f: \n" +
		m00 + ", " +  m01 + ", " +  m02 + ", " +  m03 + ", " +  m04 + ", " +  m05 + "\n" + 
		m10 + ", " +  m11 + ", " +  m12 + ", " +  m13 + ", " +  m14 + ", " +  m15 + "\n" + 
		m20 + ", " +  m21 + ", " +  m22 + ", " +  m23 + ", " +  m24 + ", " +  m25 + "\n" + 
		m30 + ", " +  m31 + ", " +  m32 + ", " +  m33 + ", " +  m34 + ", " +  m35 + "\n" + 
		m40 + ", " +  m41 + ", " +  m42 + ", " +  m43 + ", " +  m44 + ", " +  m45 + "\n" + 
		m50 + ", " +  m51 + ", " +  m52 + ", " +  m53 + ", " +  m54 + ", " +  m55 + "\n";
	}
}
