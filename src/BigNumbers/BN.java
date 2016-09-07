package BigNumbers;

/**
 * Created by Andrea (Black) Costa on 27/06/16.
 * It belong to BigNumber
 */

public class BN implements Comparable<BN>{
//internal variables
	private String original, abs;
	private char s;
	private String i, d;
	private byte[] I, D;
	private static final char comma = ',', period = '.';
	private static final char p = '+', m = '-';
	private long id;
	private static long counter = 0;
	private boolean initialized = false;


//constructors

	//constructor null
	public BN ()
	{
		I = new byte[]{0};
		D = new byte[]{0};
		s = '+';
		original = "+0";
		abs = "0";
	}

	//constructor with the string that contain the number
	public BN (String input)
	{
		//set original string
		setOriginal(input);

		counter();

		//set id
		setID(BN.getCounter()-1);

		BNInitialize();
	}

	//constructor with number's primitive type
	public <Type extends Number> BN (Type input) throws BNIncompatibleTypeException
	{
		try
		{
			//set original string
			setOriginal(String.valueOf(input));
		}
		catch (Exception e)
		{
			throw new BNIncompatibleTypeException();
		}

		counter();

		//set id
		setID(BN.getCounter()-1);

		BNInitialize();
	}

	//constructor with another BN
	public BN (BN a)
	{
		//set original string
		setOriginal(a.getOriginal());

		counter();

		//set id
		setID(BN.getCounter()-1);

		this.reInitialize();
	}

//manipulators
	public String getOriginal ()
	{
		return original;
	}
	private void setOriginal (String original)
	{
		this.original = original;
	}
	private String getAbs ()
	{
		return abs;
	}
	private void setAbs (String abs)
	{
		this.abs = abs;
	}
	public String geti ()
	{
		return i;
	}
	private void seti (String i)
	{
		this.i = i;
	}
	public String getd ()
	{
		return d;
	}
	private void setd (String d)
	{
		this.d = d;
	}
	public byte[] getI ()
	{
		return I;
	}
	private void setI (byte[] i)
	{
		I = i;
	}
	public byte[] getD ()
	{
		return D;
	}
	private void setD (byte[] d)
	{
		D = d;
	}
	public char getS ()
	{
		return s;
	}
	private void setS (char s)
	{
		this.s = s;
	}
	public long getID ()
	{
		return id;
	}
	private void setID (long id)
	{
		this.id = id;
	}
	public static long getCounter ()
	{
		return counter;
	}
	public boolean isInitialized ()
	{
		return initialized;
	}
	private void setInitialized (boolean initialized)
	{
		this.initialized = initialized;
	}
	public static char getComma ()
	{
		return comma;
	}
	public static char getPeriod ()
	{
		return period;
	}
	public static char getP ()
	{
		return p;
	}
	public static char getM ()
	{
		return m;
	}


//methods

	//create an Exception for integer's array
	private String generateCharacterException (String input) throws BNCharacterException, BNIntegerException
	{
		String str = "";
		boolean exit=false;
		int i = 0;

		while (!exit && i < input.length())
		{
			switch (input.charAt(i))
			{
				case '0':
					if (i == input.length()-1)
						str = input.substring(i);
					i++;
					break;
				case '1':
					str = input.substring(i);
					exit=true;
					break;
				case '2':
					str = input.substring(i);
					exit=true;
					break;
				case '3':
					str = input.substring(i);
					exit=true;
					break;
				case '4':
					str = input.substring(i);
					exit=true;
					break;
				case '5':
					str = input.substring(i);
					exit=true;
					break;
				case '6':
					str = input.substring(i);
					exit=true;
					break;
				case '7':
					str = input.substring(i);
					exit=true;
					break;
				case '8':
					str = input.substring(i);
					exit=true;
					break;
				case '9':
					str = input.substring(i);
					exit=true;
					break;
				case p:
					i++;
					break;
				case m:
					i++;
					break;
				case comma:
					i++;
					break;
				case period:
					i++;
					break;
				default:
					throw new BNCharacterException();
			}
		}
		if(str.equals(""))
			throw new BNIntegerException();

		return str;
	}

	//check original isn't null
	private boolean originalIsNotNull ()
	{
		return !(original.isEmpty() || original.equals(null));
	}

	//count of all objects created with this class
	private static void counter ()
	{
		counter++;
	}

	//return I array length
	private int ILength ()
	{
		return I.length;
	}

	//return D array length
	private int DLength ()
	{
		return D.length;
	}

	//return BN length
	public int length ()
	{
		return ILength() + DLength();
	}

	//return a digit of BN byte arrays
	public byte IByteAt (int index)
	{
		return I[index];
	}
	public byte DByteAt (int index)
	{
		return D[index];
	}

	//set a value in the array's index in parameters
	private static byte[] setByteAt (byte[] byteArray, int index, int value)
	{
		byteArray[index] = (byte) value;

		return byteArray;
	}

	//return a string with only a digit (the character input)
	private static String charToString (char c)
	{
		String s;
		s = String.valueOf(c);
		return s;
	}

	//convert a single char to a byte
	private static byte charToByte (String s1)
	{
		byte n;
		n = Byte.parseByte(s1);
		return n;
	}

	//return a String object from a byte array
	private static String byteArrayToString (byte[] array)
	{
		String s1 = "";
		if (array.length>0)
		{
			for (int i = array.length - 1; i >= 0; i--)
			{
				s1 = s1.concat(Byte.toString(array[i]));
			}
		}
		else
			s1="0";

		return s1;
	}

	//convert a string in a byte array
	private static byte[] stringToByte (String s1)
	{
		byte[] b = new byte[s1.length()];
		if (s1.length() == 1)
		{
			b[0] = charToByte(s1);
		}
		else
		{
			for (int i = s1.length() - 1, n = 0; i >= 0; i--, n++)
			{
				b[n] = charToByte(s1.substring(i, i + 1));
			}
		}
		return b;
	}

	//constructor for re-initialize
	private void BNInitialize()
	{
		try
		{
			//check original is not null
			if (!originalIsNotNull())
			{
				throw new BNInputException();
			}

			//check the first character and initialize abs
			try
			{
				generateCharacterException(original);
			}
			catch (BNCharacterException e)
			{
				System.out.println(e.getError());
				System.exit(1002);
			}
			catch (BNIntegerException e)
			{
				System.out.println(e.getError());
				System.exit(1001);
			}


			//set s
			int n = 0;
			if (original.charAt(0) == p || original.charAt(0) == m)
			{
				setS(original.charAt(0));
				n++;
			}
			else
			{
				setS(p);
			}

			//declaration of boolean variable to use it later in try block
			boolean b1 = true;

			//set of i and d
			try
			{
				seti("");
				setd("");
				while (n < original.length())
				{
					char c = original.charAt(n++);
					switch (c)
					{
						case '0':
							if (b1)
							{
								i = i.concat("0");
							}
							else
							{
								d = d.concat("0");
							}
							break;
						case '1':
							if (b1)
							{
								i = i.concat("1");
							}
							else
							{
								d = d.concat("1");
							}
							break;
						case '2':
							if (b1)
							{
								i = i.concat("2");
							}
							else
							{
								d = d.concat("2");
							}
							break;
						case '3':
							if (b1)
							{
								i = i.concat("3");
							}
							else
							{
								d = d.concat("3");
							}
							break;
						case '4':
							if (b1)
							{
								i = i.concat("4");
							}
							else
							{
								d = d.concat("4");
							}
							break;
						case '5':
							if (b1)
							{
								i = i.concat("5");
							}
							else
							{
								d = d.concat("5");
							}
							break;
						case '6':
							if (b1)
							{
								i = i.concat("6");
							}
							else
							{
								d = d.concat("6");
							}
							break;
						case '7':
							if (b1)
							{
								i = i.concat("7");
							}
							else
							{
								d = d.concat("7");
							}
							break;
						case '8':
							if (b1)
							{
								i = i.concat("8");
							}
							else
							{
								d = d.concat("8");
							}
							break;
						case '9':
							if (b1)
							{
								i = i.concat("9");
							}
							else
							{
								d = d.concat("9");
							}
							break;
						case comma:
							b1 = false;
							break;
						case period:
							b1 = false;
							break;
						default:
							throw new BNCharacterException();
					}
				}

				//reinitialize i
				/*if(i.length()>1)
					i = generateCharacterException(i);
				if (i.equals(""))
					throw new BNIntegerException();*/
			}

			//exception if original contains character not valid
			catch (BNCharacterException e)
			{
				System.out.println(e.getError());
				System.exit(1002);
			}
			/*catch (BNIntegerException e)
			{
				System.out.println(e.getError());
				System.exit(1001);
			}*/


			//set I and D
			setI(stringToByte(geti()));
			setD(invert(stringToByte(getd())));
		}
		catch (BNInputException e)
		{
			System.out.println(e.getError());
			System.exit(1003);
		}

		//set abs
		if (d.length()>0)
			setAbs(geti().concat(",").concat(getd()));
		else
			setAbs(geti());
	}

	//re-initialize BN
	public void reInitialize()
	{
		BNInitialize();
		setInitialized(true);
	}

	//invert the order of an array
	private static byte[] invert (byte[] input)
	{
		byte[] array = new byte[input.length];
		int n = input.length - 1;
		for (byte b : input)
		{
			array[n--] = b;
		}
		return array;
	}

	//invert sign of number
	private static byte invert (byte b)
	{
		return (byte) (b * -1);
	}

	//invert sign of number
	private static int invert (int b)
	{
		return (b * -1);
	}

	//invert sign of BN object
	private static char invert (char c)
	{
		char c1 = p;
		switch (c)
		{
			case p:
				c1 = m;
				break;
			case m:
				c1 = p;
				break;
		}
		return c1;
	}

	//compare two byte array
	private int compareByteArrayValue (byte[] x, byte[] y)
	{
		int R = 0;

		for (int i1 = 0; i1 < x.length; i1++)
		{
			int i2 =Integer.compare(x[i1],y[i1]);
			if (i2!=0)
			{
				R = i2;
				break;
			}
			else
				R = 0;
		}

		return R;
	}

	//set the value of array equals the value+parameter's byte
	private static byte[] sumByteAt (byte[] input, int index, int value)
	{
		input[index] += (byte) value;

		return input;
	}

	//sum of two byte
	private static byte add (byte b1, byte b2)
	{
		return (byte) (b1 + b2);
	}

	//return a byte array contains only a digit per index from an array overcrowded
	private static byte[] modulo (byte[] b)
	{
		byte temporary;
		byte rest;
		byte unit = 1;
		for (int i = 0; i < b.length - 1; i++)
		{
			temporary = b[i];
			if (temporary >= 10)
			{
				rest = (byte) (temporary % 10);
				b[i] = rest;
				b[i + 1] = add(b[i + 1], unit);
			}
		}

		byte[] r;
		int i = 0;
		if (b[b.length - 1] >= 10)
		{
			r = new byte[b.length + 1];
			rest = (byte) (b[b.length - 1] % 10);
			b[b.length - 1] = rest;

			for (byte b1 : b)
			{
				r[i++] = b1;
			}
			r[b.length] = unit;
		}
		else
		{
			r = new byte[b.length];
			for (byte b1 : b)
			{
				r[i++] = b1;
			}
		}
		return r;
	}

	//this method result a order of size of a BN number
	public static BN orderOfSize (long index)
	{
		BN E = new BN("10");
		String e = E.geti();
		BN A;

		if (index <= 2)
		{
			A = new BN(String.valueOf(Math.pow(10, index)));
		}
		else
		{
			for (long i = 0; i < index; i++)
			{
				e = e.concat("0");
			}

			A = new BN(e);
		}

		counter -= 2;

		return A;
	}

	//return a boolean value if BN equals zero
	public boolean isZero ()
	{
		boolean isZero;
		byte[] I = this.getI();
		long Icounter = I.length;
		byte[] D = this.getD();
		long Dcounter = D.length;

		for (byte b:I)
		{
			if (b == 0)
				Icounter--;
		}
		for (byte b:D)
		{
			if (b == 0)
				Dcounter--;
		}

		isZero = (Icounter == 0) && (Dcounter == 0);

		return isZero;
	}

	//implements interface Comparable
	public int compareTo(BN y)
	{
		int R;

		if (this.getS()==y.getS()) //case with same S
		{
			if (this.getS()==p) //case if this S is +
			{
				if ((this.DLength() == 0 && y.DLength() == 0)) //case without decimal numbers
				{
					int i = Integer.compare(this.ILength(), y.ILength());
					if (i!=0)
						R = i;
					else
						R = compareByteArrayValue(this.getI(), y.getI());
				}
				else if ((this.DLength() != 0 ^ y.DLength() != 0) && (this.length()==y.length())) //case with a only number with decimal part
				{
					if (this.ILength() != 0)
						R = 1;
					else
						R = -1;
				}
				else
				{
					int i = Integer.compare(this.ILength(), y.ILength());
					if (i!=0)
						R = i;
					else
					{
						int i1 = compareByteArrayValue(this.getI(), y.getI());
						if(i1==0)
							R = compareByteArrayValue(this.getD(),y.getD());
						else
							R = i1;
					}
				}
			}
			else //case if this S is -
			{
				R = invert(y.compareTo(this));
			}
		}
		else //same with different S
		{
			switch (this.getS())
			{
				case p: R = 1; break;
				case m:	R = -1; break;
				default: R = 0; break;
			}
		}

		return R;
	}

	//this is a method to sum two BN object
	public BN sum (BN addend)
	{
		byte[] b;
		byte[] b1;
		BN R;


		if (addend.getS() == this.getS())//case with same S
		{
			//integer
			if (addend.ILength() > this.ILength()) //case A>B
			{
				b = new byte[addend.ILength()];
				for (int i = 0; i < this.ILength(); i++)
				{
					b[i] = add(addend.IByteAt(i), this.IByteAt(i));
				}
				for (int i = this.ILength(); i < addend.ILength(); i++)
				{
					b[i] = addend.IByteAt(i);
				}
			}
			else if (addend.ILength() < this.ILength()) //case A<B
			{
				b = new byte[this.ILength()];
				for (int i = 0; i < addend.ILength(); i++)
				{
					b[i] = add(addend.IByteAt(i), this.IByteAt(i));
				}
				for (int i = addend.ILength(); i < this.ILength(); i++)
				{
					b[i] = this.IByteAt(i);
				}
			}
			else //case A=B
			{
				b = new byte[this.ILength()];
				for (int i = 0; i < this.ILength(); i++)
				{
					b[i] = add(addend.IByteAt(i), this.IByteAt(i));
				}
			}

			if (addend.getd().isEmpty() && this.getd().isEmpty()) //case without d string
			{
				b1 = new byte[1];
			}
			else//TO OPTIMIZE IT!!!!
			{
				//decimal
				if (addend.DLength() > this.DLength()) //case A>B
				{
					b1 = new byte[addend.DLength()];
					for (int i = 0; i < this.DLength(); i++)
					{
						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
					}
					for (int i = this.DLength(); i < addend.DLength(); i++)
					{
						b1[i] = addend.DByteAt(i);
					}
				}
				else if (addend.DLength() < this.DLength()) //case A<B
				{
					b1 = new byte[this.DLength()];
					for (int i = 0; i < addend.DLength(); i++)
					{
						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
					}
					for (int i = addend.DLength(); i < this.DLength(); i++)
					{
						b1[i] = this.DByteAt(i);
					}
				}
				else //case A=B
				{
					b1 = new byte[this.DLength()];
					for (int i = 0; i < this.DLength(); i++)
					{
						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
					}
				}
			}

			if (!(b1.length == 1 && b1[0] == 0))//unit rest from D to I
			{
				if (modulo(invert(b1)).length != b1.length)//check rest is necessary
				{
					b[0] += 1;
					byte[] b2 = modulo(invert(b1));
					byte[] b3 = new byte[b1.length];
					System.arraycopy(b2, 0, b3, 0, b1.length);
					R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(b3)));
					return R;
				}
				else
				{
					R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(modulo(invert(b1)))));
					return R;
				}
			}
			else
			{
				R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))));
				return R;
			}
		}
		else//case with different S
		{
			char c1 = p;
			boolean Iequals = false;
			boolean Pmajor = true;

			if (addend.getS() == m)//case S is -
			{
				//integer
				if (addend.ILength() < this.ILength()) //case A<B
				{
					b = new byte[this.ILength()];
					for (int i = 0, n = i + 1; i < addend.ILength(); i++)
					{
						if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < addend.ILength()) //rest and unit
						{
							int z = i;
							while (z < this.ILength() - 1)
							{
								this.setI(sumByteAt(this.getI(), z + n, -1));
								this.setI(sumByteAt(this.getI(), z, +10));
								z++;
							}

						}
						b[i] = add(this.IByteAt(i), invert(addend.IByteAt(i)));
					}
					for (int i = addend.ILength(); i < this.ILength(); i++)
					{
						b[i] = this.IByteAt(i);
					}
					R = new BN(byteArrayToString(modulo(b)));

					Pmajor = true;
				}
				else if (addend.ILength() > this.ILength()) //case A>B
				{
					b = new byte[addend.ILength()];
					for (int i = 0, n = i + 1; i < this.ILength(); i++)
					{
						if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i <= this.ILength() - 1) //rest and unit
						{
							int z = i;
							while (z < addend.ILength() - 1)
							{
								addend.setI(sumByteAt(addend.getI(), z + n, -1));
								addend.setI(sumByteAt(addend.getI(), z, +10));
								z++;
							}
						}

						b[i] = add(addend.IByteAt(i), invert(this.IByteAt(i)));
					}
					for (int i = this.ILength(); i < addend.ILength(); i++)
					{
						b[i] = addend.IByteAt(i);
					}
					R = new BN(byteArrayToString(modulo(b)));
					c1 = m;
					R.setS(c1);

					Pmajor = false;
				}
				else //case A=B
				{
					int i = this.ILength() - 1;
					b = new byte[addend.ILength()];
					while (i >= 0)
					{
						if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0)
						{
							while (i >= 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < this.ILength() - 1) //rest and unit
								{
									b = sumByteAt(b, i + 1, -1);
									b = sumByteAt(b, i, 10);
								}
								b = sumByteAt(b, i, add(this.IByteAt(i), invert(addend.IByteAt(i))));
								Iequals = false;
								Pmajor = true;

								i--;
							}
						}
						else if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0)
						{
							while (i >= 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i < this.ILength() - 1) //rest and unit
								{
									b = sumByteAt(b, i + 1, -1);
									b = sumByteAt(b, i, 10);
								}
								b = sumByteAt(b, i, (add(addend.IByteAt(i), invert(this.IByteAt(i)))));
								Iequals = false;
								Pmajor = false;
								c1 = m;

								i--;
							}
						}
						else
						{
							Iequals = true;
							Pmajor = false;
						}

						i--;
					}
					R = new BN(charToString(c1).concat(byteArrayToString(modulo(b))));
				}

				if (!addend.getd().isEmpty() || !this.getd().isEmpty())
				{
					//decimal
					if (addend.DLength() < this.DLength()) //case A<B
					{
						b1 = new byte[this.DLength()];

						if (Pmajor)
						{
							for (int i = this.DLength() - 1; i >= addend.DLength(); i--)
							{
								b1[i] = this.DByteAt(i);
							}
							for (int i = addend.DLength() - 1; i >= 0; i--)
							{
								if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0 && i >= 0) //rest and unit
								{
									int z = i;
									while (z > 0)
									{
										if (this.DByteAt(z) <= 0 && z > 0)
										{
											this.setD(sumByteAt(this.getD(), z - 1, -1));
											this.setD(sumByteAt(this.getD(), z, +10));
										}
										z--;
									}
								}
								b1 = sumByteAt(b1, i, (byte) Math.abs(add(this.DByteAt(i), invert(addend.DByteAt(i)))));
							}
						}
						else
						{
							byte[] b2 = new byte[b1.length];

							System.arraycopy(addend.getD(), 0, b2, 0, addend.DLength());

							//addend.setD(b2);

							BN X = new BN(charToString(m).concat(this.getd())).sum(new BN(byteArrayToString(invert(b2))));

							counter -= 3;

							/*if (X.getS() == m)
							{
								b = new BN(byteArrayToString(b)).sum(new BN("-1")).getI();
								counter -= 2;
							}*/

							b1 = invert(X.getI());

						}
					}  /*ammaccabanane*/
					else if (addend.DLength() > this.DLength()) //case A>B
					{
						b1 = new byte[addend.DLength()];

						if (!Pmajor)
						{
							for (int i = addend.DLength() - 1; i >= this.DLength(); i--)
							{
								b1[i] = addend.DByteAt(i);
							}

							for (int i = this.DLength() - 1; i >= 0; i--)
							{
								if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) < 0 && i >= 0) //rest and unit
								{
									int z = i;
									while (z > 0)
									{
										if (addend.DByteAt(z) <= 0 && z > 0)
										{
											addend.setD(sumByteAt(addend.getD(), z - 1, -1));
											addend.setD(sumByteAt(addend.getD(), z, +10));
										}
										z--;
									}
								}
								b1 = sumByteAt(b1, i, (byte) Math.abs(add(addend.DByteAt(i), invert(this.DByteAt(i)))));
							}
						}
						else
						{
							byte[] b2 = new byte[b1.length];

							System.arraycopy(this.getD(), 0, b2, 0, this.DLength());


							BN X = new BN(charToString(m).concat(addend.getd())).sum(new BN(byteArrayToString(invert(b2))));

							counter -= 3;

							/*if (X.getS() == m)
							{
								b = new BN(byteArrayToString(b)).sum(new BN("-1")).getI();
								counter -= 2;
							}*/

							b1 = invert(X.getI());
						}

						if (Iequals)
							c1 = m;

					}/*ammmaccabaae*/
					else //case A=B
					{
						b1 = new byte[addend.DLength()];
						int i = 0;
						while (i < this.DLength())
						{
							if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) < 0)
							{
								if (add(addend.DByteAt(i), invert(this.DByteAt(i))) < 0 && (!Iequals && !Pmajor))
								{
									BN X = orderOfSize(addend.DLength());
									BN Y = new BN(addend.getd());
									BN Z = new BN("-".concat((this.getd())));
									counter = -3;

									try
									{
										b1 = invert(new BN(generateCharacterException(byteArrayToString((X.sum(Y)).sum(Z).getI()))).getI());
									}
									catch (BNCharacterException | BNIntegerException e)
									{
										e.printStackTrace();
										System.exit(1010);
									}
									b = new BN(byteArrayToString(b)).sum(new BN("-1")).getI();
									break;
								}
								else
								{
									b1 = sumByteAt(b1, i, add(this.DByteAt(i), invert(addend.DByteAt(i))));
								}
							}
							else if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0)
							{

								if (add(this.DByteAt(i), invert(addend.DByteAt(i))) < 0 && (!Iequals && !Pmajor))
								{
									BN X = orderOfSize(addend.DLength());
									BN Y = new BN(this.getd());
									BN Z = new BN("-".concat((addend.getd())));
									counter = -3;

									try
									{
										b1 = invert(new BN(generateCharacterException(byteArrayToString((X.sum(Y)).sum(Z).getI()))).getI());
									}
									catch (BNCharacterException | BNIntegerException e)
									{
										e.printStackTrace();
										System.exit(1010);
									}
									b = new BN(byteArrayToString(b)).sum(new BN("-1")).getI();
									break;
								}
								else
								{
									b1 = sumByteAt(b1, i, add(addend.DByteAt(i), invert(this.DByteAt(i))));
								}
									if (Iequals)
										c1 = m;
							}

							i++;
						}
					}


					//union between decimal part and integer part for algebraic sum
					if ((addend.DLength() == 0 ^ this.DLength() == 0) && !R.getAbs().equals("0"))
					{
						BN provv = new BN(byteArrayToString(b));
						b = provv.sum(new BN("-1")).getI();
						b1 = (orderOfSize(b1.length).sum(new BN("-".concat(byteArrayToString(invert(b1)))))).getI();
						counter -= 4;
						System.arraycopy(invert(b1),1,b1,0,b1.length-1);
					}


					R.setOriginal(charToString(c1).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(modulo(invert(b1)))));
					R.BNInitialize();
				}
			}
			else
			{
				R = addend.sum(this);
				//C.setS(invert(C.getS()));
			}
		}

		//re-initialization members of sum
		this.BNInitialize();
		addend.BNInitialize();

		//return statement
		return R;
	}

	//return the difference between two BN object
	public BN difference (BN detract)
	{
		BN R;

		counter -= 1;

		detract.setS(invert(detract.getS()));

		R = this.sum(detract);

		return R;
	}

	//return the multiplication between two BN object
	public BN multiplication (BN factor)//it doesn't work with decimal BN numbers!!
	{
		BN R;
		BN detract = new BN("1");

		R = this;
		factor = factor.difference(detract);

		while (!factor.isZero())
		{
			R = R.sum(this);
			factor = factor.difference(detract);
		}

		if (factor.getS()!=this.getS())
			R.setS(invert(R.getS()));

		counter -= 2;

		R.setOriginal(String.valueOf(R.getS()).concat(R.getAbs()));

		factor.BNInitialize();
		R.BNInitialize();

		return R;
	}

	public static String abs(BN bn)
	{
		return bn.getAbs();
	}

	public static BN pow (BN base, long exponent) throws BNExponentException //PROVVISORIO!!!
	{
		BN A;
		BN B;

		if (exponent < 2)
		{
			if (exponent < 0)
			{
				throw new BNExponentException();
			}
			else if (exponent < 1)
			{
				B = new BN("1");
			}
			else
			{
				B = base;
			}
		}
		else
		{
			B = base.multiplication(base);
			for (long i = 1; i < exponent; i++)
			{
				B = B.multiplication(base);
			}
		}

		A = B;

		return A;
	}
}