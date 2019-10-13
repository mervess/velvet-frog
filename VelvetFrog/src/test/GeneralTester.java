package test;

import matrix.Matrix3f;
import matrix.Matrix4f;
import matrix.Matrix6f;
import matrix.MatrixXf;
import storage.Float3;
import storage.Float6;

/**
* A general tester class including mixed examples.
*/

public class GeneralTester
{
	public static void main(String[] args)
	{
		Matrix3f m3f = new Matrix3f(3.5f, 0, 2, -3, 6, 0, 0, 1.2f, 0);
		Matrix3f m = m3f;
		m.set(0, 2, 56);
		System.out.println(m3f);
		System.out.println(m);
		System.out.println(m3f.inverse());

		Matrix3f m3f_2 = new Matrix3f(1, 2, 3,
							4.02f, 5.1f, 6,
							7, 8.5f, 9);
		System.out.println(m3f.mult(m3f_2));

		/**
		 Matrix3f:
		 17.5, 24.0, 28.5
		 21.119999, 24.599998, 27.0
		 4.8240004, 6.1200004, 7.2000003
		 */

		Matrix6f m6f = new Matrix6f(
				1, 2, 3, 4, 5, 6,
				7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 36);
		System.out.println(m6f.transpose());


		MatrixXf m33 = new MatrixXf(3, 3,
				new float[] {1, 2, 0,
							3, 4, 5,
							5, 6, 1});
		System.out.println(m33.multDiagonal(5));


		Matrix4f f4 = new Matrix4f(2,1,0,0,
									1,3,0,0,
									0,0,2,3,
									0,1,0,2);
		System.out.println(f4.inverse());

		Float3 f = new Float3(1, 2, 3);
		System.out.println(f.cross( new Float3(0, 1, 2) ));
	}

}
