package BigNumbers;

/**
 * Created by Andrea (Black) Costa on 27/06/16.
 * It belong to BigNumber
 */

public class BN {
//internal variables
	private String original, abs;
	private char s;
	private String i, d;
	private byte[] I, D;
	private static final char comma = ',', period = '.';
	private static final char p = '+', m = '-';
	private long id;
	private static long counter = 0;


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
	private void generateIntegerException () throws BNIntegerException
	{
		switch (original.charAt(0))
		{
			case '0':
				setAbs(original);
				break;
			case '1':
				setAbs(original);
				break;
			case '2':
				setAbs(original);
				break;
			case '3':
				setAbs(original);
				break;
			case '4':
				setAbs(original);
				break;
			case '5':
				setAbs(original);
				break;
			case '6':
				setAbs(original);
				break;
			case '7':
				setAbs(original);
				break;
			case '8':
				setAbs(original);
				break;
			case '9':
				setAbs(original);
				break;
			case p:
				setAbs(original.substring(1));
				break;
			case m:
				setAbs(original.substring(1));
				break;
			default:
				throw new BNIntegerException();
		}
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
	private static byte[] setByteAt (byte[] input, int index, int value)
	{
		input[index] = (byte) value;

		return input;
	}

	//return a string with only a digit(the character input)
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
	private static String byteToString (byte[] array)
	{
		String s1 = "";
		for (int i = array.length - 1; i >= 0; i--)
		{
			s1 = s1.concat(Byte.toString(array[i]));
		}
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

			//check the first character
			try
			{
				generateIntegerException();
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
				n = 1;
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
			}

			//exception if original contains character not valid
			catch (BNCharacterException e)
			{
				System.out.println(e.getError());
				System.exit(1002);
			}

			//set I and D
			setI(stringToByte(geti()));
			setD(invert(stringToByte(getd())));
		}
		catch (BNInputException e)
		{
			System.out.println(e.getError());
			System.exit(1003);
		}
	}

	//re-initialize BN
	private void reInitialize()
	{
		BNInitialize();
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

	//invert sign
	private static char invert (char c) /*throws BNCharacterException*/
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
			//default: throw new BNCharacterException();
		}
		return c1;
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

	//this is a method to sum two BN object
	public BN sum (BN addend)
	{
		//String s1="";
		byte[] b;
		byte[] b1;
		BN C;
//		if (addend.length()!=this.length())
//		{

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
			else
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
					b3[0] = 0;
					System.arraycopy(b2, 1, b3, 1, b1.length - 1);
					return new BN(charToString(this.getS()).concat(byteToString(modulo(b))).concat(",").concat(byteToString(b3)));
				}
				else
				{
					return new BN(charToString(this.getS()).concat(byteToString(modulo(b))).concat(",").concat(byteToString(modulo(invert(b1)))));
				}
			}
			else
			{
				return new BN(charToString(this.getS()).concat(byteToString(modulo(b))));
			}
		}
		else//case with different S
		{
			char c1 = p;
			boolean Iequals = false;

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
							while (z < this.ILength())
							{
								if (this.IByteAt(z) <= 0 && z < this.length() - 1)
								{
									this.setI(sumByteAt(this.getI(), z + n, -1));
									this.setI(sumByteAt(this.getI(), z, +10));
								}
								z++;
							}
						}
						b[i] = add(this.IByteAt(i), invert(addend.IByteAt(i)));
					}
					for (int i = addend.ILength(); i < this.ILength(); i++)
					{
						b[i] = this.IByteAt(i);
					}
					C = new BN(byteToString(modulo(b)));
				}
				else if (addend.ILength() > this.ILength()) //case A>B
				{
					b = new byte[addend.ILength()];
					for (int i = 0, n = i + 1; i < this.ILength(); i++)
					{
						if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i <= this.ILength() - 1) //rest and unit
						{
							int z = i;
							while (z < addend.ILength())
							{
								if (addend.IByteAt(z) <= 0 && z < addend.ILength() - 1)
								{
									addend.setI(sumByteAt(addend.getI(), z + n, -1));
									addend.setI(sumByteAt(addend.getI(), z, +10));
								}
								z++;
							}
						}

						b[i] = add(addend.IByteAt(i), invert(this.IByteAt(i)));
					}
					for (int i = this.ILength(); i < addend.ILength(); i++)
					{
						b[i] = addend.IByteAt(i);
					}
					C = new BN(byteToString(modulo(b)));
					C.setS(m);
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
								Iequals = true;

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
								c1 = m;

								i--;
							}
						}
						else
						{
							Iequals = true;
						}

						i--;
					}
					C = new BN(charToString(c1).concat(byteToString(modulo(b))));
				}

				if (addend.getd().isEmpty() && this.getd().isEmpty())
				{
					b1 = new byte[1];
				}
				else
				{
					//decimal
					if (addend.DLength() < this.DLength()) //case A<B
					{
						b1 = new byte[this.DLength()];

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
							}/*ammaccabanane*/
							b1 = sumByteAt(b1, i ,(byte) Math.abs(add(this.DByteAt(i), invert(addend.DByteAt(i)))));
						}
					}
					else if (addend.DLength() > this.DLength()) //case A>B
					{
						b1 = new byte[addend.DLength()];

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
							b1 = sumByteAt(b1,i,(byte) Math.abs(add(addend.DByteAt(i), invert(this.DByteAt(i)))));

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
								if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0 && i < this.DLength() - 1) //rest and unit
								{
									this.setD(sumByteAt(this.getD(), i + 1, -1));
									this.setD(sumByteAt(this.getD(), i, +10));
								}
								b1[i] = add(this.DByteAt(i), invert(addend.DByteAt(i)));
							}
							else if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0)
							{
								if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) < 0 && i < this.DLength() - 1) //rest and unit
								{
									addend.setD(sumByteAt(addend.getD(), i + 1, -1));
									addend.setD(sumByteAt(addend.getD(), i, +10));
								}
								b1[i] = add(addend.DByteAt(i), invert(this.DByteAt(i)));
								if (Iequals)
									c1 = m;
							}

							i++;
						}
					}


					if ((addend.DLength() == 0 || this.DLength() == 0) && !C.getAbs().equals("0"))
					{
						BN provv = new BN(byteToString(b));
						b = provv.sum(new BN("-1")).getI();
						b1 = (new BN(String.valueOf((long) Math.pow(10,b1.length)))).sum(new BN("-".concat(byteToString(invert(b1))))).getI();
						System.arraycopy(invert(b1),1,b1,0,b1.length-1);//b1 = invert(b1);
					}

					if ((modulo(invert(b1)).length != b1.length))//check rest is necessary
					{
						b[0] += 1;
						byte[] b2 = modulo(invert(b1));
						byte[] b3 = new byte[b1.length];
						b3[0] = 0;
						System.arraycopy(b2, 1, b3, 1, b1.length - 1);
						C.setOriginal(charToString(c1).concat(byteToString(modulo(b))).concat(",").concat(byteToString(b3)));
						C.reInitialize();
					}
					else
					{
						C.setOriginal(charToString(c1).concat(byteToString(modulo(b))).concat(",").concat(byteToString(modulo(invert(b1)))));
						C.reInitialize();
					}
				}
			}
			else
			{
				C = addend.sum(this);
				//C.setS(invert(C.getS()));
			}
		}

		//re-initialization members of sum
		this.reInitialize();
		addend.reInitialize();

		//return statement
		return C;
	}

	public static String abs(BN bn)
	{
		return bn.getAbs();
	}

}