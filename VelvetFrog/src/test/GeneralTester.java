package test;

import matrix.Matrix4f;
import matrix.Matrix6f;
import matrix.MatrixXf;
import storage.Float6;
import uk.ac.man.cs.slam.numeric.ArithmeticMatrix;
import uk.ac.man.cs.slam.numeric.ArithmeticVector;
import uk.ac.man.cs.slam.numeric.builder.MatrixBuilder;

public class GeneralTester
{
	public static void main(String[] args)
	{
//		Matrix3f m3f = new Matrix3f(3, 0, 2, -3, 6, 0, 0, 1, 0);
//		Matrix3f m = m3f;
//		m.set(0, 2, 56);
//		System.out.println(m3f);
//		System.out.println(m);
//		System.out.println(m3f.inverse());
		
//		Matrix6f m4f = new Matrix6f(
//				1, 2, 3, 4, 5, 6, 
//				7, 8, 9, 10, 11, 12, 
//				13, 14, 15, 16, 17, 18,
//				19, 20, 21, 22, 23, 24,
//				25, 26, 27, 28, 29, 30,
//				31, 32, 33, 34, 35, 36);
//		System.out.println(m4f.transpose());
//		
//		MatrixXf m6 = new MatrixXf(6, 6,
//				
//				new float[] {1, 2, 3, 4, 5, 6, 
//						     7, 8, 9, 10, 11, 12, 
//						    13, 14, 15, 16, 17, 18,
//						    19, 20, 21, 22, 23, 24,
//						    25, 26, 27, 28, 29, 30,
//						    31, 32, 33, 34, 35, 36});
		
//		System.out.println(m6.submatrix(1, 5, 2, 4));
//		System.out.println(m6.getDiagonal());
//		System.out.println(m6.transpose());
		
//		MatrixXf m32 = new MatrixXf(3, 4,
//				new float[] {1, 2, 3, 17, 
//							4, 5, 6, 18,
//							7, 8, 9, 19});
//		System.out.println(m32.getDiagonalMatrix(0, 3));
//		System.out.println(m32.getDiagonal());
//		System.out.println(m32);
//		System.out.println(m32.transpose());
		
//		MatrixXf multMat = new MatrixXf(4, 1, new float[]{1,2,3,4});
//		System.out.println(m32.mult(multMat));
		
//		MatrixXf m33 = new MatrixXf(3, 3,
//				new float[] {1, 2, 0,
//							3, 4, 5,
//							5, 6, 1});
//		System.out.println(m33.multDiagonal(5));
//		
//		float[] a = new float[2];
//		System.out.println(a[0]);
//		System.out.println(a[1]);
		
//		Matrix4f f4 = new Matrix4f(2,1,0,0,
//									1,3,0,0,
//									0,0,2,3,
//									0,1,0,2);
//		System.out.println(f4.inverse());
		
//		final MatrixBuilder<ArithmeticMatrix, ArithmeticVector> mb = 
//				ArithmeticMatrix.createBuilder(3, 4);
//		mb.set(0, 0, 1);
//		mb.set(0, 1, 2);
//		mb.set(0, 2, 3);
//		mb.set(0, 3, 17);
//			mb.set(1, 0, 4);
//			mb.set(1, 1, 5);
//			mb.set(1, 2, 6);
//			mb.set(1, 3, 18);
//				mb.set(2, 0, 7);
//				mb.set(2, 1, 8);
//				mb.set(2, 2, 9);
//				mb.set(2, 3, 19);
//				
//		ArithmeticMatrix dm = mb.getDiagonal(0, 3).build().asDiagonalMatrix();
//		for (int i=0; i<dm.getRowCount(); i++) {
//			for (int j=0; j<dm.getColumnCount(); j++) {
//				System.out.print(dm.get(i, j) + ", ");
//			}
//			System.out.println();
//		}
		
//		Float6 float6 = new Float6(0, 1, 2, 3, 4, 5);
//		float[] array = float6.slice(2, 6);
//		for (int i=0; i<array.length; i++) {
//			System.out.print(array[i] + ", ");
//		}
		
		float a = -0;
		System.out.println(-a < 0);
	}

}
