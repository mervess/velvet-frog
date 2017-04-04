package matrix;

import Jama.Matrix;
import storage.Float3;
import storage.Float7;

public class Matrix7f implements IMatrix<Matrix7f>
{
	public float m00, m01, m02, m03, m04, m05, m06,
				 m10, m11, m12, m13, m14, m15, m16,
				 m20, m21, m22, m23, m24, m25, m26,
				 m30, m31, m32, m33, m34, m35, m36,
				 m40, m41, m42, m43, m44, m45, m46,
				 m50, m51, m52, m53, m54, m55, m56,
				 m60, m61, m62, m63, m64, m65, m66;
	
	private static float norm;
	
	/**
	* Constructs a 7x7 identity matrix in default.
	*/
	public Matrix7f()
	{
		resetNorm();
		
		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;
		m04 = 0.0f;
		m05 = 0.0f;
		m06 = 0.0f;
			m10 = 0.0f;
			m11 = 1.0f;
			m12 = 0.0f;
			m13 = 0.0f;
			m14 = 0.0f;
			m15 = 0.0f;
			m16 = 0.0f;
				m20 = 0.0f;
				m21 = 0.0f;
				m22 = 1.0f;
				m23 = 0.0f;
				m24 = 0.0f;
				m25 = 0.0f;
				m26 = 0.0f;
					m30 = 0.0f;
					m31 = 0.0f;
					m32 = 0.0f;
					m33 = 1.0f;
					m34 = 0.0f;
					m35 = 0.0f;
					m36 = 0.0f;
						m40 = 0.0f;
						m41 = 0.0f;
						m42 = 0.0f;
						m43 = 0.0f;
						m44 = 1.0f;
						m45 = 0.0f;
						m46 = 0.0f;
							m50 = 0.0f;
							m51 = 0.0f;
							m52 = 0.0f;
							m53 = 0.0f;
							m54 = 0.0f;
							m55 = 1.0f;
							m56 = 0.0f;
								m60 = 0.0f;
								m61 = 0.0f;
								m62 = 0.0f;
								m63 = 0.0f;
								m64 = 0.0f;
								m65 = 0.0f;
								m66 = 1.0f;
	}
	
	public Matrix7f(float scalar)
	{
		resetNorm();
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
		resetNorm();
		
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m04 = m04;
		this.m05 = m05;
		this.m06 = m06;
			this.m10 = m10;
			this.m11 = m11;
			this.m12 = m12;
			this.m13 = m13;
			this.m14 = m14;
			this.m15 = m15;
			this.m16 = m16;
				this.m20 = m20;
				this.m21 = m21;
				this.m22 = m22;
				this.m23 = m23;
				this.m24 = m24;
				this.m25 = m25;
				this.m26 = m26;
					this.m30 = m30;
					this.m31 = m31;
					this.m32 = m32;
					this.m33 = m33;
					this.m34 = m34;
					this.m35 = m35;
					this.m36 = m36;
						this.m40 = m40;
						this.m41 = m41;
						this.m42 = m42;
						this.m43 = m43;
						this.m44 = m44;
						this.m45 = m45;
						this.m46 = m46;
							this.m50 = m50;
							this.m51 = m51;
							this.m52 = m52;
							this.m53 = m53;
							this.m54 = m54;
							this.m55 = m55;
							this.m56 = m56;
								this.m60 = m60;
								this.m61 = m61;
								this.m62 = m62;
								this.m63 = m63;
								this.m64 = m64;
								this.m65 = m65;
								this.m66 = m66;
	}
	
	public Matrix7f(float[] array)
	{
		resetNorm();
		int index = 0;
		
		m00 = array[index++];
		m01 = array[index++];
		m02 = array[index++];
		m03 = array[index++];
		m04 = array[index++];
		m05 = array[index++];
		m06 = array[index++];
			m10 = array[index++];
			m11 = array[index++];
			m12 = array[index++];
			m13 = array[index++];
			m14 = array[index++];
			m15 = array[index++];
			m16 = array[index++];
				m20 = array[index++];
				m21 = array[index++];
				m22 = array[index++];
				m23 = array[index++];
				m24 = array[index++];
				m25 = array[index++];
				m26 = array[index++];
					m30 = array[index++];
					m31 = array[index++];
					m32 = array[index++];
					m33 = array[index++];
					m34 = array[index++];
					m35 = array[index++];
					m36 = array[index++];
						m40 = array[index++];
						m41 = array[index++];
						m42 = array[index++];
						m43 = array[index++];
						m44 = array[index++];
						m45 = array[index++];
						m46 = array[index++];
							m50 = array[index++];
							m51 = array[index++];
							m52 = array[index++];
							m53 = array[index++];
							m54 = array[index++];
							m55 = array[index++];
							m56 = array[index++];
								m60 = array[index++];
								m61 = array[index++];
								m62 = array[index++];
								m63 = array[index++];
								m64 = array[index++];
								m65 = array[index++];
								m66 = array[index++];
	}
	
	public Matrix7f (double[][] array)
	{
		resetNorm();
		int i = 0, j = 0;
		
		m00 = (float)array[i][j++];
		m01 = (float)array[i][j++];
		m02 = (float)array[i][j++];
		m03 = (float)array[i][j++];
		m04 = (float)array[i][j++];
		m05 = (float)array[i][j++];
		m06 = (float)array[i][j++];
			j = 0;
			m10 = (float)array[++i][j++];
			m11 = (float)array[i][j++];
			m12 = (float)array[i][j++];
			m13 = (float)array[i][j++];
			m14 = (float)array[i][j++];
			m15 = (float)array[i][j++];
			m16 = (float)array[i][j++];
				j = 0;
				m20 = (float)array[++i][j++];
				m21 = (float)array[i][j++];
				m22 = (float)array[i][j++];
				m23 = (float)array[i][j++];
				m24 = (float)array[i][j++];
				m25 = (float)array[i][j++];
				m26 = (float)array[i][j++];
					j = 0;
					m30 = (float)array[++i][j++];
					m31 = (float)array[i][j++];
					m32 = (float)array[i][j++];
					m33 = (float)array[i][j++];
					m34 = (float)array[i][j++];
					m35 = (float)array[i][j++];
					m36 = (float)array[i][j++];
						j = 0;
						m40 = (float)array[++i][j++];
						m41 = (float)array[i][j++];
						m42 = (float)array[i][j++];
						m43 = (float)array[i][j++];
						m44 = (float)array[i][j++];
						m45 = (float)array[i][j++];
						m46 = (float)array[i][j++];
							j = 0;
							m50 = (float)array[++i][j++];
							m51 = (float)array[i][j++];
							m52 = (float)array[i][j++];
							m53 = (float)array[i][j++];
							m54 = (float)array[i][j++];
							m55 = (float)array[i][j++];
							m56 = (float)array[i][j++];
								j = 0;
								m60 = (float)array[++i][j++];
								m61 = (float)array[i][j++];
								m62 = (float)array[i][j++];
								m63 = (float)array[i][j++];
								m64 = (float)array[i][j++];
								m65 = (float)array[i][j++];
								m66 = (float)array[i][j++];
	}
	
	@Override
	public Matrix7f div(float scalar)
	{
		return new Matrix7f(
				 m00/scalar, m01/scalar, m02/scalar, m03/scalar, m04/scalar, m05/scalar, m06/scalar,
				 m10/scalar, m11/scalar, m12/scalar, m13/scalar, m14/scalar, m15/scalar, m16/scalar,
				 m20/scalar, m21/scalar, m22/scalar, m23/scalar, m24/scalar, m25/scalar, m26/scalar,
				 m30/scalar, m31/scalar, m32/scalar, m33/scalar, m34/scalar, m35/scalar, m36/scalar,
				 m40/scalar, m41/scalar, m42/scalar, m43/scalar, m44/scalar, m45/scalar, m46/scalar,
				 m50/scalar, m51/scalar, m52/scalar, m53/scalar, m54/scalar, m55/scalar, m56/scalar,
				 m60/scalar, m61/scalar, m62/scalar, m63/scalar, m64/scalar, m65/scalar, m66/scalar);
	}
	
	public Matrix7f divI(float scalar)
	{
		resetNorm();
		m00 /= scalar;
		m01 /= scalar;
		m02 /= scalar;
		m03 /= scalar;
		m04 /= scalar;
		m05 /= scalar;
		m06 /= scalar;
			m10 /= scalar;
			m11 /= scalar;
			m12 /= scalar;
			m13 /= scalar;
			m14 /= scalar;
			m15 /= scalar;
			m16 /= scalar;
				m20 /= scalar;
				m21 /= scalar;
				m22 /= scalar;
				m23 /= scalar;
				m24 /= scalar;
				m25 /= scalar;
				m26 /= scalar;
					m30 /= scalar;
					m31 /= scalar;
					m32 /= scalar;
					m33 /= scalar;
					m34 /= scalar;
					m35 /= scalar;
					m36 /= scalar;
						m40 /= scalar;
						m41 /= scalar;
						m42 /= scalar;
						m43 /= scalar;
						m44 /= scalar;
						m45 /= scalar;
						m46 /= scalar;
							m50 /= scalar;
							m51 /= scalar;
							m52 /= scalar;
							m53 /= scalar;
							m54 /= scalar;
							m55 /= scalar;
							m56 /= scalar;
								m60 /= scalar;
								m61 /= scalar;
								m62 /= scalar;
								m63 /= scalar;
								m64 /= scalar;
								m65 /= scalar;
								m66 /= scalar;
		return this;
	}

	@Override
	public Matrix7f mult(float scalar)
	{
		return new Matrix7f(
				 m00*scalar, m01*scalar, m02*scalar, m03*scalar, m04*scalar, m05*scalar, m06*scalar,
				 m10*scalar, m11*scalar, m12*scalar, m13*scalar, m14*scalar, m15*scalar, m16*scalar,
				 m20*scalar, m21*scalar, m22*scalar, m23*scalar, m24*scalar, m25*scalar, m26*scalar,
				 m30*scalar, m31*scalar, m32*scalar, m33*scalar, m34*scalar, m35*scalar, m36*scalar,
				 m40*scalar, m41*scalar, m42*scalar, m43*scalar, m44*scalar, m45*scalar, m46*scalar,
				 m50*scalar, m51*scalar, m52*scalar, m53*scalar, m54*scalar, m55*scalar, m56*scalar,
				 m60*scalar, m61*scalar, m62*scalar, m63*scalar, m64*scalar, m65*scalar, m66*scalar);
	}

	@Override
	public Matrix7f add(Matrix7f matrix)
	{
		return new Matrix7f(
				 m00+matrix.m00, m01+matrix.m01, m02+matrix.m02, m03+matrix.m03, m04+matrix.m04, m05+matrix.m05, m06+matrix.m06,
				 m10+matrix.m10, m11+matrix.m11, m12+matrix.m12, m13+matrix.m13, m14+matrix.m14, m15+matrix.m15, m16+matrix.m16,
				 m20+matrix.m20, m21+matrix.m21, m22+matrix.m22, m23+matrix.m23, m24+matrix.m24, m25+matrix.m25, m26+matrix.m26,
				 m30+matrix.m30, m31+matrix.m31, m32+matrix.m32, m33+matrix.m33, m34+matrix.m34, m35+matrix.m35, m36+matrix.m36,
				 m40+matrix.m40, m41+matrix.m41, m42+matrix.m42, m43+matrix.m43, m44+matrix.m44, m45+matrix.m45, m46+matrix.m46,
				 m50+matrix.m50, m51+matrix.m51, m52+matrix.m52, m53+matrix.m53, m54+matrix.m54, m55+matrix.m55, m56+matrix.m56,
				 m60+matrix.m60, m61+matrix.m61, m62+matrix.m62, m63+matrix.m63, m64+matrix.m64, m65+matrix.m65, m66+matrix.m66);
	}
	
	public Matrix7f addI(int row, int col, float scalar)
	{
		resetNorm();
		
		switch (row) {
	        case 0:
	        	switch (col) {
		        	case 0:
		        		m00 += scalar; 
		        		break;
	        		case 1:
	        			m01 += scalar;
	        			break;
	        		case 2:
	        			m02 += scalar;
	        			break;
	        		case 3:
	        			m03 += scalar;
	        			break;
	        		case 4:
	        			m04 += scalar;
	        			break;
	        		case 5:
	        			m05 += scalar;
	        			break;
	        		case 6:
	        			m06 += scalar;
	        			break;
	        	}
	        	break;
	        case 1:
	        	switch (col) {
		        	case 0:
		        		m10 += scalar;
		        		break;
	        		case 1:
	        			m11 += scalar;
	        			break;
	        		case 2:
	        			m12 += scalar;
	        			break;
	        		case 3:
	        			m13 += scalar;
	        			break;
	        		case 4:
	        			m14 += scalar;
	        			break;
	        		case 5:
	        			m15 += scalar;
	        			break;
	        		case 6:
	        			m16 += scalar;
	        			break;
	        	}
	        	break; 
	        case 2:
	        	switch (col) {
		        	case 0:
		        		m20 += scalar;
		        		break;
	        		case 1:
	        			m21 += scalar;
	        			break;
	        		case 2:
	        			m22 += scalar;
	        			break;
	        		case 3:
	        			m23 += scalar;
	        			break;
	        		case 4:
	        			m24 += scalar;
	        			break;
	        		case 5:
	        			m25 += scalar;
	        			break;
	        		case 6:
	        			m26 += scalar;
	        			break;
	        	}
	        	break;
	        case 3:
	        	switch (col) {
		        	case 0:
		        		m30 += scalar;
		        		break;
	        		case 1:
	        			m31 += scalar;
	        			break;
	        		case 2:
	        			m32 += scalar;
	        			break;
	        		case 3:
	        			m33 += scalar;
	        			break;
	        		case 4:
	        			m34 += scalar;
	        			break;
	        		case 5:
	        			m35 += scalar;
	        			break;
	        		case 6:
	        			m36 += scalar;
	        			break;
	        	}
	        	break;
	        case 4:
	        	switch (col) {
		        	case 0:
		        		m40 += scalar;
		        		break;
	        		case 1:
	        			m41 += scalar;
	        			break;
	        		case 2:
	        			m42 += scalar;
	        			break;
	        		case 3:
	        			m43 += scalar;
	        			break;
	        		case 4:
	        			m44 += scalar;
	        			break;
	        		case 5:
	        			m45 += scalar;
	        			break;
	        		case 6:
	        			m46 += scalar;
	        			break;
	        	}
	        	break;
	        case 5:
	        	switch (col) {
		        	case 0:
		        		m50 += scalar;
		        		break;
	        		case 1:
	        			m51 += scalar;
	        			break;
	        		case 2:
	        			m52 += scalar;
	        			break;
	        		case 3:
	        			m53 += scalar;
	        			break;
	        		case 4:
	        			m54 += scalar;
	        			break;
	        		case 5:
	        			m55 += scalar;
	        			break;
	        		case 6:
	        			m56 += scalar;
	        			break;
	        	}
	        	break;
	        case 6:
	        	switch (col) {
		        	case 0:
		        		m60 += scalar;
		        		break;
	        		case 1:
	        			m61 += scalar;
	        			break;
	        		case 2:
	        			m62 += scalar;
	        			break;
	        		case 3:
	        			m63 += scalar;
	        			break;
	        		case 4:
	        			m64 += scalar;
	        			break;
	        		case 5:
	        			m65 += scalar;
	        			break;
	        		case 6:
	        			m66 += scalar;
	        			break;
	        	}
	        	break;
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - addI("+row+", "+col+", "+scalar+")");
		}
		return this;
	}

	@Override
	public Matrix7f sub(Matrix7f matrix)
	{
		return new Matrix7f(
				 m00-matrix.m00, m01-matrix.m01, m02-matrix.m02, m03-matrix.m03, m04-matrix.m04, m05-matrix.m05, m06-matrix.m06,
				 m10-matrix.m10, m11-matrix.m11, m12-matrix.m12, m13-matrix.m13, m14-matrix.m14, m15-matrix.m15, m16-matrix.m16,
				 m20-matrix.m20, m21-matrix.m21, m22-matrix.m22, m23-matrix.m23, m24-matrix.m24, m25-matrix.m25, m26-matrix.m26,
				 m30-matrix.m30, m31-matrix.m31, m32-matrix.m32, m33-matrix.m33, m34-matrix.m34, m35-matrix.m35, m36-matrix.m36,
				 m40-matrix.m40, m41-matrix.m41, m42-matrix.m42, m43-matrix.m43, m44-matrix.m44, m45-matrix.m45, m46-matrix.m46,
				 m50-matrix.m50, m51-matrix.m51, m52-matrix.m52, m53-matrix.m53, m54-matrix.m54, m55-matrix.m55, m56-matrix.m56,
				 m60-matrix.m60, m61-matrix.m61, m62-matrix.m62, m63-matrix.m63, m64-matrix.m64, m65-matrix.m65, m66-matrix.m66);
	}

	@Override
	public Matrix7f mult(Matrix7f matrix)
	{
		return new Matrix7f(
				 m00*matrix.m00, m01*matrix.m01, m02*matrix.m02, m03*matrix.m03, m04*matrix.m04, m05*matrix.m05, m06*matrix.m06,
				 m10*matrix.m10, m11*matrix.m11, m12*matrix.m12, m13*matrix.m13, m14*matrix.m14, m15*matrix.m15, m16*matrix.m16,
				 m20*matrix.m20, m21*matrix.m21, m22*matrix.m22, m23*matrix.m23, m24*matrix.m24, m25*matrix.m25, m26*matrix.m26,
				 m30*matrix.m30, m31*matrix.m31, m32*matrix.m32, m33*matrix.m33, m34*matrix.m34, m35*matrix.m35, m36*matrix.m36,
				 m40*matrix.m40, m41*matrix.m41, m42*matrix.m42, m43*matrix.m43, m44*matrix.m44, m45*matrix.m45, m46*matrix.m46,
				 m50*matrix.m50, m51*matrix.m51, m52*matrix.m52, m53*matrix.m53, m54*matrix.m54, m55*matrix.m55, m56*matrix.m56,
				 m60*matrix.m60, m61*matrix.m61, m62*matrix.m62, m63*matrix.m63, m64*matrix.m64, m65*matrix.m65, m66*matrix.m66);
	}
	
	public Float7 mult(Float7 storage)
	{
		return new Float7(storage.dot( getRow(0) ),
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
		return (m00*m00) + (m01*m01) + (m02*m02) + (m03*m03) + (m04*m04) + (m05*m05) + (m06*m06) +
			   (m10*m10) + (m11*m11) + (m12*m12) + (m13*m13) + (m14*m14) + (m15*m15) + (m16*m16) +
			   (m20*m20) + (m21*m21) + (m22*m22) + (m23*m23) + (m24*m24) + (m25*m25) + (m26*m26) +
			   (m30*m30) + (m31*m31) + (m32*m32) + (m33*m33) + (m34*m34) + (m35*m35) + (m36*m36) +
			   (m40*m40) + (m41*m41) + (m42*m42) + (m43*m43) + (m44*m44) + (m45*m45) + (m46*m46) +
			   (m50*m50) + (m51*m51) + (m52*m52) + (m53*m53) + (m54*m54) + (m55*m55) + (m56*m56) +
			   (m60*m60) + (m61*m61) + (m62*m62) + (m63*m63) + (m64*m64) + (m65*m65) + (m66*m66);
	}

	@Override
	public float norm()
	{
		if (-1.0f == norm) {
			norm = (float) Math.sqrt(normSquared());
		}
		return norm;
	}

	@Override
	public float sum()
	{
		return m00 + m01 + m02 + m03 + m04 + m05 + m06 +
			   m10 + m11 + m12 + m13 + m14 + m15 + m16 +
			   m20 + m21 + m22 + m23 + m24 + m25 + m26 +
			   m30 + m31 + m32 + m33 + m34 + m35 + m36 +
			   m40 + m41 + m42 + m43 + m44 + m45 + m46 +
			   m50 + m51 + m52 + m53 + m54 + m55 + m56 +
			   m60 + m61 + m62 + m63 + m64 + m65 + m66;
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
				 m00*scalar, m01, m02, m03, m04, m05, m06,
				 m10, m11*scalar, m12, m13, m14, m15, m16,
				 m20, m21, m22*scalar, m23, m24, m25, m26,
				 m30, m31, m32, m33*scalar, m34, m35, m36,
				 m40, m41, m42, m43, m44*scalar, m45, m46,
				 m50, m51, m52, m53, m54, m55*scalar, m56,
				 m60, m61, m62, m63, m64, m65, m66*scalar);
	}

	@Override
	public Matrix7f transpose()
	{
		return new Matrix7f(
				 m00, m10, m20, m30, m40, m50, m60,
				 m01, m11, m21, m31, m41, m51, m61,
				 m02, m12, m22, m32, m42, m52, m62,
				 m03, m13, m23, m33, m43, m53, m63,
				 m04, m14, m24, m34, m44, m54, m64,
				 m05, m15, m25, m35, m45, m55, m65,
				 m06, m16, m26, m36, m46, m56, m66);
	}

	@Override
	public Matrix7f negate()
	{
		return new Matrix7f(
				 -m00, -m01, -m02, -m03, -m04, -m05, -m06,
				 -m10, -m11, -m12, -m13, -m14, -m15, -m16,
				 -m20, -m21, -m22, -m23, -m24, -m25, -m26,
				 -m30, -m31, -m32, -m33, -m34, -m35, -m36,
				 -m40, -m41, -m42, -m43, -m44, -m45, -m46,
				 -m50, -m51, -m52, -m53, -m54, -m55, -m56,
				 -m60, -m61, -m62, -m63, -m64, -m65, -m66);
	}

	@Override
	public Matrix7f set(int index, float value)
	{
		resetNorm();
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
				m05 = value;
				break;
			case 6:
				m06 = value; //-- end of row 0
				break;
				
			case 7:
				m10 = value;
				break;
			case 8:
				m11 = value;
				break;
			case 9:
				m12 = value;
				break;
			case 10:
				m13 = value;
				break;
			case 11:
				m14 = value; 
				break; 
			case 12:
				m15 = value;
				break;
			case 13:
				m16 = value; //-- end of row 1
				break;
				
			case 14:
				m20 = value;
				break;
			case 15:
				m21 = value;
				break;
			case 16:
				m22 = value;
				break;
			case 17:
				m23 = value; 
				break; 
			case 18:
				m24 = value;
				break;
			case 19:
				m25 = value;
				break;
			case 20:
				m26 = value; //-- end of row 2
				break;
				
			case 21:
				m30 = value;
				break;
			case 22:
				m31 = value;
				break;
			case 23:
				m32 = value; 
				break; 
			case 24:
				m33 = value;
				break;
			case 25:
				m34 = value;
				break;
			case 26:
				m35 = value;
				break;
			case 27:
				m36 = value; //-- end of row 3
				break;
				
			case 28:
				m40 = value;
				break;
			case 29:
				m41 = value; 
				break;
			case 30:
				m42 = value;
				break;
			case 31:
				m43 = value;
				break;
			case 32:
				m44 = value;
				break;
			case 33:
				m45 = value;
				break;
			case 34:
				m46 = value; //-- end of row 4
				break;
				
			case 35:
				m50 = value; 
				break;
			case 36:
				m51 = value;
				break;
			case 37:
				m52 = value;
				break;
			case 38:
				m53 = value;
				break;
			case 39:
				m54 = value;
				break;
			case 40:
				m55 = value;
				break;
			case 41:
				m56 = value; //-- end of row 5
				break;
				
			case 42:
				m60 = value; 
				break;
			case 43:
				m61 = value;
				break;
			case 44:
				m62 = value;
				break;
			case 45:
				m63 = value;
				break;
			case 46:
				m64 = value;
				break;
			case 47:
				m65 = value;
				break;
			case 48:
				m66 = value; //-- end of row 6
				break;
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - set("+index+", "+value+")");
		}
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
		resetNorm();
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
	            throw new ArrayIndexOutOfBoundsException("Matrix7f");
	    }
		return this;
	}
	
	public Matrix7f set(int row, int col, Matrix6f mat)
	{
		resetNorm();
		// TODO bu kisim tam degil
		switch (row) {
	        case 0:
	        	switch (col) {
		        	case 0:
		        		m00 = mat.m00;
		        		m01 = mat.m01;
		        		m02 = mat.m02;
		        		m03 = mat.m03;
		        		m04 = mat.m04;
		        		m05 = mat.m05;
			        		m10 = mat.m10;
			        		m11 = mat.m11;
			        		m12 = mat.m12;
			        		m13 = mat.m13;
			        		m14 = mat.m14;
			        		m15 = mat.m15;
				        		m20 = mat.m20;
				        		m21 = mat.m21;
				        		m22 = mat.m22;
				        		m23 = mat.m23;
				        		m24 = mat.m24;
				        		m25 = mat.m25;
					        		m30 = mat.m30;
					        		m31 = mat.m31;
					        		m32 = mat.m32;
					        		m33 = mat.m33;
					        		m34 = mat.m34;
					        		m35 = mat.m35;
						        		m40 = mat.m40;
										m41 = mat.m41;
										m42 = mat.m42;
										m43 = mat.m43;
										m44 = mat.m44;
										m45 = mat.m45;
											m50 = mat.m50;
											m51 = mat.m51;
											m52 = mat.m52;
											m53 = mat.m53;
											m54 = mat.m54;
											m55 = mat.m55;
		        		break;
	        	}
	        	break;
	        default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f");
	    }
		return this;
	}
	
	private void set(float scalar)
	{
		m00 = scalar;
		m01 = scalar;
		m02 = scalar;
		m03 = scalar;
		m04 = scalar;
		m05 = scalar;
		m06 = scalar;
			m10 = scalar;
			m11 = scalar;
			m12 = scalar;
			m13 = scalar;
			m14 = scalar;
			m15 = scalar;
			m16 = scalar;
				m20 = scalar;
				m21 = scalar;
				m22 = scalar;
				m23 = scalar;
				m24 = scalar;
				m25 = scalar;
				m26 = scalar;
					m30 = scalar;
					m31 = scalar;
					m32 = scalar;
					m33 = scalar;
					m34 = scalar;
					m35 = scalar;
					m36 = scalar;
						m40 = scalar;
						m41 = scalar;
						m42 = scalar;
						m43 = scalar;
						m44 = scalar;
						m45 = scalar;
						m46 = scalar;
							m50 = scalar;
							m51 = scalar;
							m52 = scalar;
							m53 = scalar;
							m54 = scalar;
							m55 = scalar;
							m56 = scalar;
								m60 = scalar;
								m61 = scalar;
								m62 = scalar;
								m63 = scalar;
								m64 = scalar;
								m65 = scalar;
								m66 = scalar;
	}

	public void setColumn(int col, Float3 vector)
	{
		resetNorm();
		
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
	        case 4:
	        	m04 = vector.getX();
	        	m14 = vector.getY();
	        	m25 = vector.getZ();
	        	break;
	        case 5:
	        	m05 = vector.getX();
	        	m15 = vector.getY();
	        	m25 = vector.getZ();
	        	break;
	        case 6:
	        	m06 = vector.getX();
	        	m16 = vector.getY();
	        	m26 = vector.getZ();
	        	break;
	        default:
	        	throw new ArrayIndexOutOfBoundsException("Matrix3f.setColumn: "+col+" - "+vector.toString());
		}
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
				return m05;
			case 6:
				return m06; //-- end of row 0
				
			case 7:
				return m10;
			case 8:
				return m11;
			case 9:
				return m12;
			case 10:
				return m13;
			case 11:
				return m14; 
			case 12:
				return m15;
			case 13:
				return m16; //-- end of row 1
				
			case 14:
				return m20;
			case 15:
				return m21;
			case 16:
				return m22;
			case 17:
				return m23; 
			case 18:
				return m24;
			case 19:
				return m25;
			case 20:
				return m26; //-- end of row 2
				
			case 21:
				return m30;
			case 22:
				return m31;
			case 23:
				return m32; 
			case 24:
				return m33;
			case 25:
				return m34;
			case 26:
				return m35;
			case 27:
				return m36; //-- end of row 3
				
			case 28:
				return m40;
			case 29:
				return m41; 
			case 30:
				return m42;
			case 31:
				return m43;
			case 32:
				return m44;
			case 33:
				return m45;
			case 34:
				return m46; //-- end of row 4
				
			case 35:
				return m50; 
			case 36:
				return m51;
			case 37:
				return m52;
			case 38:
				return m53;
			case 39:
				return m54;
			case 40:
				return m55;
			case 41:
				return m56; //-- end of row 5
				
			case 42:
				return m60; 
			case 43:
				return m61;
			case 44:
				return m62;
			case 45:
				return m63;
			case 46:
				return m64;
			case 47:
				return m65;
			case 48:
				return m66; //-- end of row 6
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - get("+index+")");
		}
	}

	@Override
	public float get(int row, int col)
	{
		return get(row * 7 + col);
	}
	
	public Float7 getRow(int row)
	{
		switch (row) {
			case 0:
				return new Float7(m00, m01, m02, m03, m04, m05, m06);
			case 1:
				return new Float7(m10, m11, m12, m13, m14, m15, m16);
			case 2:
				return new Float7(m20, m21, m22, m23, m24, m25, m26);
			case 3:
				return new Float7(m30, m31, m32, m33, m34, m35, m36);
			case 4:
				return new Float7(m40, m41, m42, m43, m44, m45, m46);
			case 5:
				return new Float7(m50, m51, m52, m53, m54, m55, m56);
			case 6:
				return new Float7(m60, m61, m62, m63, m64, m65, m66);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - getRow("+row+")");
		}
	}
	
	public Float7 getColumn(int col)
	{
		switch (col) {
			case 0:
				return new Float7(m00, m10, m20, m30, m40, m50, m60);
			case 1:
				return new Float7(m01, m11, m21, m31, m41, m51, m61);
			case 2:
				return new Float7(m02, m12, m22, m32, m42, m52, m62);
			case 3:
				return new Float7(m03, m13, m23, m33, m43, m53, m63);
			case 4:
				return new Float7(m04, m14, m24, m34, m44, m54, m64);
			case 5:
				return new Float7(m05, m15, m25, m35, m45, m55, m65);
			case 6:
				return new Float7(m06, m16, m26, m36, m46, m56, m66);
			default:
	            throw new ArrayIndexOutOfBoundsException("Matrix7f - getColumn("+col+")");
		}
	}
	
	public Float7 getDiagonal()
	{
		return new Float7(m00, m11, m22, m33, m44, m55, m66);
	}
	
	public boolean isNonsingular()
	{
		return m00 != 0.0f &&
			   m11 != 0.0f &&
			   m22 != 0.0f &&
			   m33 != 0.0f &&
			   m44 != 0.0f &&
			   m55 != 0.0f &&
			   m66 != 0.0f;
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
	
	private void resetNorm()
	{
		norm = -1.0f;
	}
	
	public MatrixXf toMatrixXf()
	{
		return new MatrixXf(7, 7, new float[]{
				m00, m01, m02, m03, m04, m05, m06,
				m10, m11, m12, m13, m14, m15, m16,
				m20, m21, m22, m23, m24, m25, m26,
				m30, m31, m32, m33, m34, m35, m36,
				m40, m41, m42, m43, m44, m45, m46,
				m50, m51, m52, m53, m54, m55, m56,
				m60, m61, m62, m63, m64, m65, m66});
	}
	
	public float[] toArray()
	{
		return new float[]{
				m00, m01, m02, m03, m04, m05, m06,
				m10, m11, m12, m13, m14, m15, m16,
				m20, m21, m22, m23, m24, m25, m26,
				m30, m31, m32, m33, m34, m35, m36,
				m40, m41, m42, m43, m44, m45, m46,
				m50, m51, m52, m53, m54, m55, m56,
				m60, m61, m62, m63, m64, m65, m66};
	}
	
	public double[][] toDoubleArray()
	{
		return new double[][] {
				{ m00, m01, m02, m03, m04, m05, m06 },
				{ m10, m11, m12, m13, m14, m15, m16 },
				{ m20, m21, m22, m23, m24, m25, m26 },
				{ m30, m31, m32, m33, m34, m35, m36 },
				{ m40, m41, m42, m43, m44, m45, m46 },
				{ m50, m51, m52, m53, m54, m55, m56 },
				{ m60, m61, m62, m63, m64, m65, m66 } };
	}

	@Override
	public Matrix7f copy()
	{
		return new Matrix7f(
				m00, m01, m02, m03, m04, m05, m06,
				m10, m11, m12, m13, m14, m15, m16,
				m20, m21, m22, m23, m24, m25, m26,
				m30, m31, m32, m33, m34, m35, m36,
				m40, m41, m42, m43, m44, m45, m46,
				m50, m51, m52, m53, m54, m55, m56,
				m60, m61, m62, m63, m64, m65, m66);
	}
	
	public void clear()
	{
		resetNorm();
		set(0.0f);
	}

	@Override
	public String toString()
	{
		return "Matrix7f: \n" +
				m00 + ", " +  m01 + ", " +  m02 + ", " +  m03 + ", " +  m04 + ", " +  m05 + ", " + m06 + "\n" +
				m10 + ", " +  m11 + ", " +  m12 + ", " +  m13 + ", " +  m14 + ", " +  m15 + ", " + m16 + "\n" +
				m20 + ", " +  m21 + ", " +  m22 + ", " +  m23 + ", " +  m24 + ", " +  m25 + ", " + m26 + "\n" +
				m30 + ", " +  m31 + ", " +  m32 + ", " +  m33 + ", " +  m34 + ", " +  m35 + ", " + m36 + "\n" +
				m40 + ", " +  m41 + ", " +  m42 + ", " +  m43 + ", " +  m44 + ", " +  m45 + ", " + m46 + "\n" +
				m50 + ", " +  m51 + ", " +  m52 + ", " +  m53 + ", " +  m54 + ", " +  m55 + ", " + m56 + "\n" +
				m60 + ", " +  m61 + ", " +  m62 + ", " +  m63 + ", " +  m64 + ", " +  m65 + ", " + m66 + "\n";
	}
}
