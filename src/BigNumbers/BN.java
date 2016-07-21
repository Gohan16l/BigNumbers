package BigNumbers;

/**
 * Created by Andrea (Black) Costa on 27/06/16.
 * It belong to BigNumber
 */

public class BN {
//stato interno
	private String original;
	private char s;
	private String i,d;
	private byte[] I,D;
	private static final char comma=',' , period='.';
	private static final char p='+', m='-';


//costruttori
	
	//constructor null
	public BN()
	{
		I=new byte[]{0};
		D=new byte[]{0};
		s='+';
		original="0";
	}

	//constructor with the string that contain the number
	public BN(String input)
	{
		//set original string
		setOriginal(input);
		
		//check the first character
		try
		{
			generateIntegerException();
		}
		catch (BNIntegerException e)
		{
			System.out.println(e.getError());
		}

		//set s
		int n=0;
		if(original.charAt(0)==p || original.charAt(0)==m)
		{
			setS(original.charAt(0));
			n=1;
		}
		else
			setS(p);

		//declaration of boolean variable to use it later in try block
		boolean b1=true;
		
		//set of i and d
		try
		{
			i="";
			d="";
			while (n<original.length())
			{
				char c = original.charAt(n++);
				switch (c)
				{
					case '0':
						if (b1)
						{
							i=i.concat("0");
						}
						else
						{
							d=d.concat("0");
						};
						break;
					case '1':
						if (b1)
						{
							i=i.concat("1");
						}
						else
						{
							d=d.concat("1");
						};
						break;
					case '2':
						if (b1)
						{
							i=i.concat("2");
						}
						else
						{
							d=d.concat("2");
						};
						break;
					case '3':
						if (b1)
						{
							i=i.concat("3");
						}
						else
						{
							d=d.concat("3");
						};
						break;
					case '4':
						if (b1)
						{
							i=i.concat("4");
						}
						else
						{
							d=d.concat("4");
						};
						break;
					case '5':
						if (b1)
						{
							i=i.concat("5");
						}
						else
						{
							d=d.concat("5");
						};
						break;
					case '6':
						if (b1)
						{
							i=i.concat("6");
						}
						else
						{
							d=d.concat("6");
						};
						break;
					case '7':
						if (b1)
						{
							i=i.concat("7");
						}
						else
						{
							d=d.concat("7");
						};
						break;
					case '8':
						if (b1)
						{
							i=i.concat("8");
						}
						else
						{
							d=d.concat("8");
						};
						break;
					case '9':
						if (b1)
						{
							i=i.concat("9");
						}
						else
						{
							d=d.concat("9");
						};
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
		}

		//set I and D if d is not null
		setI(stringToByte(geti()));
		setD(stringToByte(getd()));
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
	private void setI (byte[] n)
	{
		I = n;
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

	private void generateIntegerException() throws BNIntegerException
	{
		switch (original.charAt(0))
		{
			case '0':
				break;
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case '6':
				break;
			case '7':
				break;
			case '8':
				break;
			case '9':
				break;
			default:
				throw new BNIntegerException();
		}
	}

	//convert a single char to a byte
	private byte charToByte(String s1)
	{
		byte n;
		n=Byte.parseByte(s1);
		return n;
	}

	//convert a string in a byte array
	private byte[] stringToByte(String s1)
	{
		byte[] b = new byte[s1.length()];
		if (s1.length()==1)
		{
			b[0] = charToByte(s1.substring(0));
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

	//return a String object from a byte array
	private String byteToString (byte [] array)
	{
		String s1 = "";
		for (int i = array.length-1;i >= 0; i--)
		{
			s1=s1.concat(Byte.toString(array[i]));
		}
		return s1;
	}

	//return BN length
	public int length ()
	{
		return original.length();
	}
	
	//return a digit of BN byte arrays
	public byte IByteAt(int index)
	{
		return I[index];
	}
	public byte DByteAt(int index)
	{
		return D[index];
	}

	//sum of two byte
	private byte add(byte b1, byte b2)
	{
		return (byte) (b1+b2);
	}

	//return a byte array contains only a digit per index from an array overcrowded
	private byte[] modulo (byte[] b)
	{
		byte[] r;
		if(b[b.length-1]>=10)
			r = new byte[b.length+1];
		else
			r = new byte[b.length];
		int index=0;
		for (byte i:b)
		{
			if(i>=10)
			{
				byte rest = (byte) (i%10);
				byte unit = 1;
				r[index] = add(r[index],rest);
				r[index + 1] = add(r[index + 1], unit);
			}
			else
				r[index] = add(r[index],i);

			index++;
		}
		return r;
	}

	//this is a method to sum two BN object
	public BN sum (BN addend)
	{
		String s1="";
		byte[] b;
		if (addend.length()!=this.length())
		{
			if (addend.length() < this.length())
			{
				b=new byte[this.length()];
				for (int i=0;i<addend.length();i++)
				{
					b[i]=add(addend.IByteAt(i), this.IByteAt(i));
				}
				for (int i=addend.length(); i<this.length(); i++)
				{
					b[i]=this.IByteAt(i);
				}
			}
			else
			{
				b=new byte[addend.length()];
				for (int i=0;i<this.length();i++)
				{
					b[i]=add(addend.IByteAt(i), this.IByteAt(i));
				}
				for (int i=this.length(); i<addend.length(); i++)
				{
					b[i]=addend.IByteAt(i);
				}
			}
		}
		else
		{
			b=new byte[this.length()];
			for (int i=0;i<this.length();i++)
			{
				b[i]=add(addend.IByteAt(i), this.IByteAt(i));
			}

		}

		return new BN(byteToString(modulo(b)));
	}

}