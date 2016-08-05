package BigNumbers;

/**
 * Created by Andrea (Black) Costa on 27/06/16.
 * It belong to BigNumber
 */

public class BN {
	//stato interno
	private String original, abs;
	private char s;
	private String i, d;
	private byte[] I, D;
	private static final char comma = ',', period = '.';
	private static final char p = '+', m = '-';
	private long id;
	private static long counter = -1;


//costruttori

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

		BNInitialize();
	}


//manipolatori
	public String getOriginal ()
	{
		return original;
	}
	private void setOriginal (String original)
	{
		this.original = original;
	}
	public String getAbs ()
	{
		return abs;
	}
	public void setAbs (String abs)
	{
		this.abs = abs;
	}
	public String geti ()
	{
		return i;
	}
	public void seti (String i)
	{
		this.i = i;
	}
	public String getd ()
	{
		return d;
	}
	public void setd (String d)
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


//metodi

	//create an Exception for integer's array
	private void generateIntegerException () throws BNIntegerException
	{
		switch (original.charAt(0))
		{
			case '0':
				abs = original;
				break;
			case '1':
				abs = original;
				break;
			case '2':
				abs = original;
				break;
			case '3':
				abs = original;
				break;
			case '4':
				abs = original;
				break;
			case '5':
				abs = original;
				break;
			case '6':
				abs = original;
				break;
			case '7':
				abs = original;
				break;
			case '8':
				abs = original;
				break;
			case '9':
				abs = original;
				break;
			case p:
				abs = original.substring(1);
				break;
			case m:
				abs = original.substring(1);
				break;
			default:
				throw new BNIntegerException();
		}
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
		String s = "";
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

		counter();

		//set id
		setID(BN.getCounter());


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
			i = "";
			d = "";
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
						;
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
						;
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
						;
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
						;
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
						;
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
						;
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
						;
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
						;
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
						;
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
						;
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

	//re-initialize BN
	public void reinitialize()
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
			if (addend.getd().isEmpty() && this.getd().isEmpty()) //case without d string
			{
				b1 = new byte[1];
				//b1[0]=0;
				if (addend.length() < this.length()) //case A<B
				{
					b = new byte[this.length()];
					for (int i = 0; i < addend.length(); i++)
					{
						b[i] = add(addend.IByteAt(i), this.IByteAt(i));
					}
					for (int i = addend.length(); i < this.length(); i++)
					{
						b[i] = this.IByteAt(i);
					}
				}
				else //other case
				{
					b = new byte[addend.length()];
					for (int i = 0; i < this.length(); i++)
					{
						b[i] = add(addend.IByteAt(i), this.IByteAt(i));
					}
					for (int i = this.length(); i < addend.length(); i++)
					{
						b[i] = addend.IByteAt(i);
					}
				}
			}
			else //case with d string
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
			//}
//		else //this is a repetition, to optimize!
//		{
//			if (addend.getd().isEmpty())
//			{
//				b1 = new byte[0];
//				b = new byte[this.length()];
//				for (int i = 0; i < this.length(); i++)
//				{
//					b[i] = add(addend.IByteAt(i), this.IByteAt(i));
//				}
//			}
//			else
//			{
//				if(addend.ILength()>this.ILength()) //integer
//				{
//					b = new byte[addend.ILength()];
//					for (int i = 0; i < addend.ILength(); i++)
//					{
//						b[i] = add(addend.IByteAt(i), this.IByteAt(i));
//					}
//					for (int i = this.ILength(); i < addend.ILength(); i++)
//					{
//						b[i] = addend.IByteAt(i);
//					}
//				}
//				else if(addend.ILength()<this.ILength())
//				{
//					b = new byte[this.ILength()];
//					for (int i = 0; i < this.ILength(); i++)
//					{
//						b[i] = add(addend.IByteAt(i), this.IByteAt(i));
//					}
//					for (int i = addend.ILength(); i < this.ILength(); i++)
//					{
//						b[i] = this.IByteAt(i);
//					}
//				}
//				else
//				{
//					b = new byte[this.ILength()];
//					for (int i = 0; i < this.ILength(); i++)
//					{
//						b[i] = add(addend.IByteAt(i), this.IByteAt(i));
//					}
//				}
//				if(addend.DLength()>this.DLength()) //decimal
//				{
//					b1 = new byte[addend.DLength()];
//					for (int i = 0; i < addend.DLength(); i++)
//					{
//						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
//					}
//					for (int i = this.DLength(); i < addend.DLength(); i++)
//					{
//						b1[i] = addend.DByteAt(i);
//					}
//				}
//				else if (addend.DLength()<this.DLength())
//				{
//					b1 = new byte[this.DLength()];
//					for (int i = 0; i < this.DLength(); i++)
//					{
//						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
//					}
//					for (int i = addend.DLength(); i < this.DLength(); i++)
//					{
//						b1[i] = this.DByteAt(i);
//					}
//				}
//				else
//				{
//					b1 = new byte[addend.DLength()];
//					for (int i = 0; i < addend.DLength(); i++)
//					{
//						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
//					}
//				}
//			}
//		}

			if (!(b1.length == 1 && b1[0] == 0))//unit rest from D to I
			{
				if (modulo(invert(b1)).length != b1.length)//check rest is necessary
				{
					b[0] += 1;
					byte[] b2 = modulo(invert(b1));
					byte[] b3 = new byte[b1.length];
					b3[0] = 0;
					for (int i = 1; i < b1.length; i++)
					{
						b3[i] = b2[i];
					}
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
			if (addend.getS() == m)//case S is -
			{
				if (addend.getd().isEmpty() && this.getd().isEmpty()) //case without d string
				{
					b1 = new byte[1];
					if (addend.ILength() < this.ILength()) //case A<B
					{
						b = new byte[this.length()];
						for (int i = 0, n = i + 1;  i < addend.length(); i++)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < addend.ILength()) //rest and unit
							{
								int z=i;
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
						for (int i = addend.length(); i < this.length(); i++)
						{
							b[i] = this.IByteAt(i);
						}
						C = new BN(byteToString(modulo(b)));
					}
					else if (addend.ILength() > this.ILength()) //case A>B
					{
						b = new byte[addend.length()];
						for (int i = 0, n = i + 1; i < this.length(); i++)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i <= this.ILength() - 1) //rest and unit
							{
								int z=i;
								while (z < addend.ILength())
								{
									if (addend.IByteAt(z) <= 0 && z < addend.length() - 1)
									{
										addend.setI(sumByteAt(addend.getI(), z + n, -1));
										addend.setI(sumByteAt(addend.getI(), z + n - 1, +10));
									}
									else
									{
										n++;
									}

									z++;
								}
							}

							b[i] = add(addend.IByteAt(i), invert(this.IByteAt(i)));
						}
						for (int i = this.length(); i < addend.length(); i++)
						{
							b[i] = addend.IByteAt(i);
						}
						C = new BN(byteToString(modulo(b)));
						C.setS(m);
					}
					else //case A=B
					{
						char c1=p;
						int i = this.ILength() - 1;
						b = new byte[addend.length()];
						while (i >= 0)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < this.ILength() - 1) //rest and unit
								{
									this.setI(sumByteAt(this.getI(), i + 1, -1));
									this.setI(sumByteAt(this.getI(), i, +10));
								}
								b[i] = add(this.IByteAt(i), invert(addend.IByteAt(i)));
							}
							else if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i < this.ILength() - 1) //rest and unit
								{
									addend.setI(sumByteAt(addend.getI(), i + 1, -1));
									addend.setI(sumByteAt(addend.getI(), i, +10));
								}
								b[i] = add(addend.IByteAt(i), invert(this.IByteAt(i)));
								c1=m;
							}

							i--;
						}
						C = new BN(charToString(c1).concat(byteToString(modulo(b))));
					}
				}
				else //case with d string
				{
					char c1 = p;
					boolean Iequals=false;

					//integer
					if (addend.ILength() < this.ILength()) //case A<B
					{
						b = new byte[this.ILength()];
						for (int i = 0, n = i + 1; i < addend.ILength(); i++)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < this.ILength() - 1) //rest and unit
							{
								int z=i;
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
					}
					else if (addend.ILength() > this.ILength()) //case A>B
					{
						b = new byte[addend.ILength()];
						for (int i = 0, n = i + 1; i < this.ILength(); i++)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i < this.ILength() - 1) //rest and unit
							{
								int z=i;
								while (z < addend.ILength())
								{
									if (addend.IByteAt(z) <= 0 && z < addend.length() - 1)
									{
										addend.setI(sumByteAt(addend.getI(), z + n, -1));
										addend.setI(sumByteAt(addend.getI(), z + n - 1, +10));
									}
									else
									{
										n++;
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
							c1 = m;//provvissorio e non necessario, forse
					}
					else //case A=B
					{
						int i = this.ILength() - 1;
						b = new byte[addend.ILength()];
						while (i >= 0)
						{
							if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0 && i < this.ILength() - 1) //rest and unit
								{
									this.setI(sumByteAt(this.getI(), i + 1, -1));
									this.setI(sumByteAt(this.getI(), i, +10));
								}
								b[i] = add(this.IByteAt(i), invert(addend.IByteAt(i)));
								Iequals=true;
							}
							else if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) > 0)
							{
								if (Byte.compare(addend.IByteAt(i), this.IByteAt(i)) < 0 && i < this.ILength() - 1) //rest and unit
								{
									addend.setI(sumByteAt(addend.getI(), i + 1, -1));
									addend.setI(sumByteAt(addend.getI(), i, +10));
								}
								b[i] = add(addend.IByteAt(i), invert(this.IByteAt(i)));
								c1=m;
							}

							i--;
						}
					}

					//decimal
					addend.setD(invert(addend.getD()));
					this.setD(invert(this.getD()));
					if (addend.DLength() < this.DLength()) //case A<B
					{
						b1 = new byte[this.DLength()];
						for (int i = 0, n = i + 1; i < addend.DLength(); i++)
						{
							if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0 && i < this.DLength() - 1) //rest and unit
							{
								int z=i;
								while (z < this.DLength())
								{
									if (this.DByteAt(z) <= 0 && z < this.DLength() - 1 )
									{
										this.setD(sumByteAt(this.getD(), z + n, -1));
										this.setD(sumByteAt(this.getD(), z + n - 1, +10));
									}
									else
									{
										n++;
									}

									z++;
								}
							}/*ammaccabanane*/
							b1[i] = add(this.DByteAt(i), invert(addend.DByteAt(i)));
						}
						for (int i = addend.DLength(); i < this.DLength(); i++)
						{
							b1[i] = this.DByteAt(i);
						}
					}
					else if (addend.DLength() > this.DLength()) //case A>B
					{
						b1 = new byte[addend.DLength()];
						for (int i = 0, n = i + 1; i < this.DLength(); i++)
						{
							if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) < 0 && i < this.DLength() - 1) //rest and unit
							{
								int z=i;
								while (z < addend.DLength())
								{
									if (addend.DByteAt(z) <= 0 && z < addend.DLength() - 1)
									{
										addend.setD(sumByteAt(addend.getD(), z + n, -1));
										addend.setD(sumByteAt(addend.getD(), z + n - 1, +10));
									}
									else
									{
										n++;
									}

									z++;
								}
							}
							b1[i] = add(addend.DByteAt(i), invert(this.DByteAt(i)));
						}
						for (int i = this.DLength(); i < addend.DLength(); i++)
						{
							b1[i] = addend.DByteAt(i);
						}
						if (Iequals)
							c1 = m;
					}/*ammmaccabaae*/
					else //case A=B
					{
						int i = this.DLength() - 1;
						b1 = new byte[addend.DLength()];
						while (i >= 0)
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
								c1=m;
							}

							i--;
						}
					}

						/*if (!(b1.length==1 && b1[0]==0))//unit rest from D to I
						{*/
					if ((modulo(invert(b1)).length != b1.length) /*&& this.DLength()>=addend.DLength()*/)//check rest is necessary
					{
						b[0] += 1;
						byte[] b2 = modulo(invert(b1));
						byte[] b3 = new byte[b1.length];
						b3[0] = 0;
						for (int i = 1; i < b1.length; i++)
						{
							b3[i] = b2[i];
						}
						C = new BN(charToString(c1).concat(byteToString(modulo(b))).concat(",").concat(byteToString(b3)));
					}
					else
					{
						C = new BN(charToString(c1).concat(byteToString(modulo(b))).concat(",").concat(byteToString(modulo(invert(b1)))));
					}
						/*}*/
				}
			}
			else
			{
				C = new BN();
				/*****************************************************************************/
			}
		}

		this.BNInitialize();
		addend.BNInitialize();

		return C;
	}

}