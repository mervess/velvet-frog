package matrix;

import uk.ac.man.cs.slam.numeric.ArithmeticMatrix;
import uk.ac.man.cs.slam.numeric.ArithmeticVector;
import uk.ac.man.cs.slam.numeric.builder.MatrixBuilder;
import vector.VecXf;

public class MatrixXf implements IMatrix<MatrixXf>
{
	protected final float[] data;
	protected final int rowCount, colCount, numElements;
	
	public MatrixXf(int rowCount, int colCount)
	{
		this.rowCount = rowCount;
		this.colCount = colCount;
		numElements = rowCount*colCount;
		data = new float[numElements];
	}
	
	public MatrixXf(int rowCount, int colCount, float[] data)
	{
		this.rowCount = rowCount;
		this.colCount = colCount;
		numElements = rowCount*colCount;
		this.data = data;
	}
	
	public static MatrixXf createIdentityMatrix(int rowCount, int colCount)
	{
		final MatrixXf identityMatrix = new MatrixXf(rowCount, colCount);
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				identityMatrix.set(i, j, (i != j) ? 0.0f : 1.0f);
			}
		}
		return identityMatrix;
	}
	
	@Override
	public MatrixXf div(float scalar)
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = data[i]/scalar;
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}

	@Override
	public MatrixXf mult(float scalar)
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = data[i]*scalar;
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}

	@Override
	public MatrixXf add(MatrixXf matrix)
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = data[i] + matrix.get(i);
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}

	@Override
	public MatrixXf sub(MatrixXf matrix)
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = data[i] - matrix.get(i);
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}

	@Override
	public MatrixXf mult(MatrixXf matrix)
	{
		if (colCount != matrix.getRowCount()) {
			throw new IllegalArgumentException("In matrix multiplication matrix A columns and matrix B rows must agree!");
		} else {
			final float[] newMatrix = new float[rowCount*matrix.getColumnCount()];
			
			int index = 0;
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < matrix.getColumnCount(); j++) {
					float value = 0.0f;
	                for (int k = 0; k < colCount; k++) {
	                    value += get(i, k) * matrix.get(k, j);
	                }
	                newMatrix[index++] = value;
				}
			}
			
			return new MatrixXf(rowCount, matrix.getColumnCount(), newMatrix);
		}
	}
	
	@Override
	public MatrixXf multDiagonal(float scalar) 
	{
		final MatrixXf newMatrix = new MatrixXf(rowCount, colCount);
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				newMatrix.set(i, j, 
						(i != j) ? get(i, j) : get(i, j) * scalar);
			}
		}
		return newMatrix;
	}

	@Override
	public float normSquared()
	{
		float normSquared = 0.0f;
		for (int i = 0; i < numElements; i++) {
			normSquared += data[i] * data[i];
		}
		return normSquared;
	}

	@Override
	public float sum() 
	{
		float sum = 0.0f;
		for (int i = 0; i < numElements; i++) {
			sum += data[i];
		}
		return sum;
	}

	@Override
	public MatrixXf set(int index, float value)
	{
		data[index] = value;
		return this;
	}

	@Override
	public MatrixXf set(int row, int col, float value)
	{
		data[row*colCount+col] = value;
		return this;
	}
	
	public MatrixXf set(int row, int col, MatrixXf matrix)
	{
		for (int i = 0; i < matrix.getRowCount(); i++) {
			for (int j = 0; j < matrix.getColumnCount(); j++) {
				set(row+i, col+j, matrix.get(i, j));
			}
		}
		return this;
	}
	
	public VecXf getRow(int row)
	{
		final float[] vector = new float[getColumnCount()];
		int index = row * getColumnCount(); // start-up index
		final int endIndex = index + getColumnCount();
		
		for (int i = 0; index < endIndex; index++, i++) {
			vector[i] = data[index];
		}
		return new VecXf(vector);
	}

	public VecXf getDiagonal()
	{
		if (isSquare()) {
			final float[] vector = new float[getColumnCount()];
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					if (i == j) {
						vector[i] = get(i, j);
					}
				}
			}
			return new VecXf(vector);
		}
		return null;
	}
	
	/**
	 * Composes a square matrix containing values within index diagonally.
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public MatrixXf getDiagonalMatrix(int startIndex, int endIndex)
	{
		final int matSize = endIndex-startIndex;
		final MatrixXf newMatrix = new MatrixXf(matSize, matSize);
		
		for (int i = startIndex; i < endIndex; i++) {
			for (int j = startIndex; j < endIndex; j++) {
				newMatrix.set(i, j, 
						(i != j) ? 0.0f : get(i, j));
			}
		}
		return newMatrix;
	}
	
	@Override
	public float get(int index)
	{
		return data[index];
	}

	@Override
	public float get(int row, int col)
	{
		return data[row*colCount+col];
	}
	
	public MatrixXf swap(int row1, int col1, int row2, int col2)
	{
		final float temp = get(row1, col1);
        set(row1, col1, get(row2, col2));
        set(row2, col2, temp);
		return this;
	}
	
	@Override
	public MatrixXf inverse()
	{
		final MatrixBuilder<ArithmeticMatrix, ArithmeticVector> matrix = 
				ArithmeticMatrix.createBuilder(getRowCount(), getColumnCount());
		for (int i=0; i<getRowCount(); i++) {
			for (int j=0; j<getColumnCount(); j++) {
				matrix.set(i, j, get(i, j));
			}
		}
		
		final ArithmeticMatrix invMatrix = matrix.build().inverse();
		final MatrixXf newMatrix = new MatrixXf(getRowCount(), getColumnCount());
		
		for (int i=0; i<getRowCount(); i++) {
			for (int j=0; j<getColumnCount(); j++) {
				newMatrix.set(i, j, invMatrix.get(i, j));
			}
		}
		
		return newMatrix; // TODO fix later
	}

	public MatrixXf subMatrix(int rowFrom, int rowTo, int colFrom, int colTo)
	{
		final MatrixXf subMatrix = new MatrixXf(rowTo-rowFrom, colTo-colFrom);
		
		for (int i = 0, row = rowFrom; i < subMatrix.getRowCount(); i++, row++) {
			for (int j = 0, col = colFrom; j < subMatrix.getColumnCount(); j++, col++) {
				subMatrix.set(i, j, get(row, col));
			}
		}
		return subMatrix;
	}
	
	public MatrixXf subMatrix(int[] rows, int colFrom, int colTo)
	{
		final MatrixXf subMatrix = new MatrixXf(rows.length, colTo-colFrom);
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0, col = colFrom; j < subMatrix.getColumnCount(); j++, col++) {
				subMatrix.set(i, j, get(rows[i], col));
			}
		}
		return subMatrix;
	}

	@Override
	public MatrixXf transpose()
	{
		final MatrixXf newMatrix = new MatrixXf(colCount, rowCount);
		for (int i = 0; i < colCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				newMatrix.set(i, j, get(j, i));
			}
		}
		return newMatrix;
	}

	@Override
	public MatrixXf negate()
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = -data[i];
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}
	
	@Override
	public int getColumnCount()
	{
		return colCount;
	}

	@Override
	public int getRowCount()
	{
		return rowCount;
	}
	
	public int getTotalNumberOfElements()
	{
		return numElements;
	}
	
	public MatrixXf fill(float value)
	{
		for (int i = 0; i < numElements; i++) {
			data[i] = value;
		}
		return this;
	}
	
	protected float[] toArray()
	{
		return data;
	}

	@Override
	public MatrixXf copy()
	{
		final float[] newMatrix = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			newMatrix[i] = data[i];
		}
		return new MatrixXf(rowCount, colCount, newMatrix);
	}
	
	@Override
	public String toString()
	{
		final StringBuilder matToString = new StringBuilder("MatrixXf - "+rowCount+"x"+colCount+":\n");
		final int rows = (rowCount > 10) ? 10 : rowCount;
		final int cols = (colCount > 10) ? 10 : colCount;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				matToString.append(get(r, c) + ", ");
			}
			matToString.delete(matToString.length()-2, matToString.length());
			if (colCount > 10) {
				matToString.append(" ...");
			}
			matToString.append("\n");
		}
		if (rowCount > 10) {
			matToString.append("...\n");
		}
		return matToString.toString();
	}
}
