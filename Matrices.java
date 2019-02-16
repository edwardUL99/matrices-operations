import java.util.Arrays;

/**This class is built to demonstrate different operations to be carried out on arrays
 * 
 * @author Eddy's-PC
 * @version 020219-2040
 *
 */
public class Matrices {
	public Matrices() {
	}
	
	public boolean contains(int[] a, int x) {
		for(int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;	
	}
	
	public boolean contains(int[] a, int x, int N) {
		//Will search the first N elements
		if (N <= a.length) {
			for (int i = 0; i < N; i++) {
				if (a[i] == x) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int[] indexesOf(int[] a, int x ) {
		int[] indexes = new int[a.length];
		int count = 0;
		int pos = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				indexes[pos] = i;
				pos++;
				count++;
			}
		}
		int length = a.length;
		if (count < a.length) {
			length = count;
		}
		
		if (count == 0) {
			indexes = null;
		} else {
			indexes = Arrays.copyOf(indexes, length);
		}
		return indexes;		
	}
	
	public int[] append(int[] a, int[] b) {
		int[] ab = new int[a.length + b.length];
		System.arraycopy(a, 0, ab, 0, a.length);
		System.arraycopy(b, 0, ab, a.length, b.length);
		return ab;
	}
	
	public int[] union(int[] a, int[] b) {
		int[] unions = new int[a.length + b.length];
		int nonDuplicate = 0;
		if (b.length > a.length) {
			int[] temp = a;
			a = b;
			b = temp;
		}
		for(int i = 0; i < a.length; i++) {
			if (!contains(unions, a[i], nonDuplicate)) {
				unions[nonDuplicate] = a[i];
				nonDuplicate++;
			}
		}
		
		for(int i = 0; i < b.length; i++) {
			if (!contains(unions, b[i], nonDuplicate)) {
				unions[nonDuplicate] = b[i];
				nonDuplicate++;
			}
		}
		
		if (nonDuplicate < unions.length) {
			unions = Arrays.copyOf(unions, nonDuplicate);
		}
		return unions;
	}
	
	public int[] intersection(int[] a, int[] b) {
		int[] intersects = new int[a.length + b.length];
		int both = 0;
		if (b.length > a.length) {
			int[] temp = a;
			a = b;
			b = temp;
		}
		for (int i = 0; i < a.length; i++) {
			if (contains(b, a[i])) {
				intersects[both] = a[i];
				both++;
			}
		}
		if (both == 0) {
			intersects = null;
		} else if (both < intersects.length) {
			intersects = Arrays.copyOf(intersects, both);
		}
		return intersects;
	}
	
	public int[] divisible(int[] a, int[] b) {
		//Will return an array with integers of a array only if they are divided by corresponding numbers in b evenly
		int[] related = new int[a.length + b.length];
		int modRelated = 0;
		if (b.length > a.length || a.length > b.length) {
			return null;
	    }
		for (int i = 0; i < a.length; i++) {
			if (a[i] % b[i] == 0) {
				related[modRelated] = a[i];
				modRelated++;
			}
		}
		if (modRelated < related.length) {
			related = Arrays.copyOf(related, modRelated);
		}
		return related;
	}
	
	public int[] divisible(int[] a, int x) {
		int[] b = new int[a.length];
		Arrays.fill(b, x);
		return divisible(a, b);
	}
	
	public String[] cartesianProduct(int[] a, int[] b) {
		String[] cartesian = new String[a.length * b.length];
		String product;
		int pos = 0;
		for (int i : a) {
			for (int y : b) {
				product = "(" + i + "," + y + ")";
				cartesian[pos] = product;
				pos++;
			}
		}
		return cartesian;
	}
	
	public int min(int[] a) {
		int smallest = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < smallest) {
				smallest = a[i];
			}
		}
		return smallest;
	}
	
	public int max(int[] a) {
		int largest = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > largest) {
				largest = a[i];
			}
		}
		return largest;
	}
	
	public int arrayRange(int[] a) {
	    return max(a) - min(a);
	}
	
	public int arrayAverage(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
        return sum / a.length;
	}
	
	public int[] randomArray(int rangeFrom, int rangeTo, int length) {
		rangeFrom += 1;
		int[] randArray = new int[length];
		for (int i = 0; i < length; i++) {
			randArray[i] = (int)(Math.random() * (rangeTo - rangeFrom) + rangeFrom);
		}
		return randArray;
	}
	
	/**Returns an array with any integers starting with the specified digit.
	 * Note that is the digit provided is 0, any integers less than 10 is considered to be padded with a leading zero and will be returned
	 * @param a -The array to be passed in
	 * @param digit -The digit to search for at the start of the integers(Read note)
	 * @return the array populated with the satisfying integers
	 */
	public int[] startDigit(int[] a, int digit) {
		int[] returned = new int[a.length];
		int y;
		int pos = 0;
		for (int i : a) {
			if (digit == 0 && i < 10 ) {
				returned[pos] = i;
				pos++;
			} else {
				y = i;
				while (y > 9) {
					y /= 10;
				}
				if (y == digit) {
				returned[pos] = i;
				pos++;
				}
			}
		}
		if (pos < a.length) {
			returned = Arrays.copyOf(returned, pos);
		}
		return returned;
	}
	
	public int[] rangeOf(int[] a, int start, int end) {
		int[] returned = new int[a.length];
		Arrays.sort(a);
		int pos = 0;
		for (int i : a) {
			if (i >= start && i <= end) {
				if (!contains(returned, i)) {
				returned[pos] = i;
				pos++;
				}
			}
		}
		if (pos < a.length) {
			returned = Arrays.copyOf(returned, pos);
		}
		return returned;
	}
	
	public int[] shuffle(int[] a) {
		int[] shuffled = Arrays.copyOf(a, a.length);
		Arrays.sort(shuffled);
		for (int i = 0; i < shuffled.length; i++) {
			int pos = (int)(Math.random() * shuffled.length);
			int pos1 = (int)(Math.random() * shuffled.length);
			int temp = shuffled[pos];
			shuffled[pos] = shuffled[pos1];
			shuffled[pos1] = temp;
		}
		return shuffled;
	}
	
	public String[] shuffle(String[] a) {
		String[] shuffled = Arrays.copyOf(a,  a.length);
		Arrays.sort(shuffled);
		for (int i = 0; i < shuffled.length; i++) {
			int pos = (int)(Math.random() * shuffled.length);
			int pos1 = (int)(Math.random() * shuffled.length);
			String temp = shuffled[pos];
			shuffled[pos] = shuffled[pos1];
			shuffled[pos1] = temp;
		}
		return shuffled;
	}
	
	public int[] reverse(int[] a) {
		int[] reversed = Arrays.copyOf(a, a.length);
		int left = 0;
		int right = reversed.length - 1;
		while (left < right) {
			int temp = reversed[left];
			reversed[left++] = reversed[right];
			reversed[right--] = temp;
		}
		return reversed;
	}
	
	public String[] reverse(String[] a) {
		String[] reversed = Arrays.copyOf(a, a.length);
		int left = 0;
		int right  = reversed.length - 1;
		while (left < right) {
			String temp = reversed[left];
			reversed[left++] = reversed[right];
			reversed[right--] = temp;
		}
		return reversed;
	}
	
	public int[][] half(int[] a) {
		int[][] halved;
		int midpoint = a.length / 2;
		int length;
		if (a.length % 2 != 0) {
			length = midpoint + 1;
		} else {
			length = midpoint;
		}
		int[] array1 =  Arrays.copyOf(a, midpoint);
		int[] array2 = new int[length];
		System.arraycopy(a, midpoint, array2, 0, length);
		halved = new int[][] {array1, array2};
		return halved;
	}
	
	public String[][] half(String[] a) {
		String[][] halved;
		int midpoint = a.length / 2;
		int length;
		if (a.length % 2 != 0) {
			length = midpoint + 1;
		} else {
			length = midpoint;
		}
		String[] array1 =  Arrays.copyOf(a, midpoint);
		String[] array2 = new String[length];
		System.arraycopy(a, midpoint, array2, 0, length);
		halved = new String[][] {array1, array2};
		return halved;
	}
	
	public void display2D(int[][] a) {
        if (a != null) {
            System.out.println();
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[0].length; col++) {
                    System.out.print("\t" + a[row][col]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Array is null");
        }
	}

    public void display2D(double[][] a) {
        if (a != null) {
            System.out.println();
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[0].length; col++) {
                    System.out.print("\t" + a[row][col]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Array is null");
        }
    }
	
	private void shift(char direction, int from, int[] a) {
		if (direction == 'L') {
            if (a.length - from >= 0) System.arraycopy(a, from, a, from - 1, a.length - from);
		} else if (direction == 'R') {
            if (a.length - 1 >= 0) System.arraycopy(a, 1, a, 0, a.length - 1);
		}
	}
	
	private void shift(char direction, int from, String[] a) {
		if (direction == 'L') {
            if (a.length - from >= 0) System.arraycopy(a, from, a, from - 1, a.length - from);
		} else if (direction == 'R') {
            if (a.length - 1 >= 0) System.arraycopy(a, 1, a, 0, a.length - 1);
		}
	}
	
	private int index(int[] a, int element) {
		int i;
		for (i = 0; i < a.length && a[i] != element; i++);
		if (i < a.length) {
			return i;
		}
		return -1;
	}
	
	private int index(String[] a, String element) {
		int i;
		for (i = 0; i < a.length && element.compareToIgnoreCase(a[i]) != 0; i++);
		if (i < a.length) {
			return i;
		}
		return -1;
	}
	
	public int[] remove(int[] a, int element) {
		int pos = index(a, element);
		if (pos > 0) {
			int temp = a[pos - 1];
			shift('L', pos, a);
			a[pos - 1] = temp;
			a = Arrays.copyOf(a, a.length - 1);
		} else if (pos == 0) {
			shift('R', pos, a);
			a =  Arrays.copyOf(a, a.length - 1);
		}
		return a;
	}
	
	public String[] remove(String[] a, String element) {
		int pos = index(a, element);
		if (pos > 0) {
			String temp = a[pos - 1];
			shift('L', pos, a);
			a[pos - 1] = temp;
			a = Arrays.copyOf(a, a.length - 1);
		} else if (pos == 0) {
			shift('R', pos, a);
			a =  Arrays.copyOf(a, a.length - 1);
		}
		return a;
	}

	public int[][] matrixMultiply(int[][] a, int[][] b) {
	    if (a[0].length == b.length) {
	        int[][] product = new int[a.length][b[0].length];
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    product[i][j] = product[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
	        return product;
        }
        return new int[][]{{0,0,0,0}, {0,0,0,0}};
    }

    public int[][] scalarMultiplication(int[][] a, int k) {
	    int[][] product = new int[a.length][a[0].length];
	    for (int row = 0; row < a.length; row++) {
	        for (int col = 0; col < a[0].length; col++) {
	            product[row][col] = a[row][col] * k;
            }
        }
	    return product;
    }

    private double[][] scalarMultiplication(int[][] a, double k) {
        double[][] product = new double[a.length][a[0].length];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[0].length; col++) {
                product[row][col] = a[row][col] * k;
            }
        }
        return product;
    }

    public int[][] matrixAddition(int[][] a, int[][] b) {
	    if(a.length == b.length && a[0].length == b[0].length) {
	        int[][] sum = new int[a.length][a[0].length];
	        for (int row = 0; row < a.length; row++) {
	            for (int col = 0; col < a[0].length; col++) {
	                sum[row][col] = a[row][col] + b[row][col];
                }
            }
	        return sum;
        }
	    return null;
    }

    public int[][] matrixSubtraction(int[][] a, int[][] b) {
        if(a.length == b.length && a[0].length == b[0].length) {
            int[][] sum = new int[a.length][a[0].length];
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[0].length; col++) {
                    sum[row][col] = a[row][col] - b[row][col];
                }
            }
            return sum;
        }
        return null;
    }

    public int[][] matrixMinor(int[][] a, int exclRow, int exclCol) {
	    if (a.length == a[0].length) {
	        int[][] minor = new int[a.length-1][a[0].length-1];
	        int r = 0;
	        int c = 0;
	        for (int row = 0; row < a.length; row++) {
	            for (int col = 0; col < a[0].length; col++) {
	                if (row != exclRow && col != exclCol) {
                        minor[r][c] = a[row][col];
                        if (c < minor[0].length-1) {
                            c++;
                        } else if (c == minor[0].length - 1) {
                            r++;
                            c = 0;
                        }
                    }
                }
            }
	        return minor;
        }
	    return null;
    }

    public int matrixDeterminant(int[][] a) {
	    if (a.length == 2 && a[0].length == 2) {
	        return (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        } else if (a.length >= 3 && a[0].length >= 3) {
	        int determinant = 0;
	        for (int col = 0; col < a[0].length; col++) {
	            if (col % 2 != 0) {
	                determinant = determinant + (-(a[0][col]) * matrixDeterminant(matrixMinor(a, 0, col)));
                } else {
                    determinant = determinant + (a[0][col] * matrixDeterminant(matrixMinor(a, 0, col)));
                }
            }
	        return determinant;
        }
	    return 0;
    }

    public int[][] matrixTranspose(int[][] a) {
	    int[][] transpose = new int[a.length][a[0].length];
	    for (int row = 0; row < a.length; row++) {
	        for (int col = 0; col < a[0].length; col++) {
	            transpose[row][col] = a[col][row];
            }
        }
	    return transpose;
    }

    public double[][] matrixInverse(int[][] a) {
	    if (a.length == a[0].length && matrixDeterminant(a) != 0) {
           if (a.length > 2) {
                int[][] inverse = new int[a.length][a[0].length];
                double determinant = 1 / (double)(matrixDeterminant(a));
                int minorDeterminant;
                int[][] transposed = matrixTranspose(a);
                for (int row = 0; row < a.length; row++) {
                    for (int col = 0; col < a[0].length; col++) {
                        minorDeterminant = matrixDeterminant(matrixMinor(transposed, row, col));
                        if (row % 2 != 0) {
                            if (col % 2 == 0) {
                                minorDeterminant = -(minorDeterminant);
                            }
                        } else if (row % 2 == 0) {
                            if (col % 2 != 0) {
                                minorDeterminant = -(minorDeterminant);
                            }
                        }
                        inverse[row][col] = minorDeterminant;
                    }
                }
                return scalarMultiplication(inverse, determinant);
            } else {
                double determinant = 1 / (double)(matrixDeterminant(a));
                int temp = a[0][0];
                a[0][0] = a[1][1];
                a[1][1] = temp;
                a[0][1] = -(a[0][1]);
                a[1][0] = -(a[1][0]);
                display2D(a);
                return scalarMultiplication(a, determinant);
            }
       }
	    return null;
    }
}
