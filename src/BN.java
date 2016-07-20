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
			while (n<original.length())
			{
				char c = original.charAt(++n);
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
					case '1':
						if (b1)
						{
							i=i.concat("1");
						}
						else
						{
							d=d.concat("1");
						};
					case '2':
						if (b1)
						{
							i=i.concat("2");
						}
						else
						{
							d=d.concat("2");
						};
					case '3':
						if (b1)
						{
							i=i.concat("3");
						}
						else
						{
							d=d.concat("3");
						};
					case '4':
						if (b1)
						{
							i=i.concat("4");
						}
						else
						{
							d=d.concat("4");
						};
					case '5':
						if (b1)
						{
							i=i.concat("5");
						}
						else
						{
							d=d.concat("5");
						};
					case '6':
						if (b1)
						{
							i=i.concat("6");
						}
						else
						{
							d=d.concat("6");
						};
					case '7':
						if (b1)
						{
							i=i.concat("7");
						}
						else
						{
							d=d.concat("7");
						};
					case '8':
						if (b1)
						{
							i=i.concat("8");
						}
						else
						{
							d=d.concat("8");
						};
					case '9':
						if (b1)
						{
							i=i.concat("9");
						}
						else
						{
							d=d.concat("9");
						};
					case comma:
						b1 = false;
					case period:
						b1 = false;
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
		if(!d.equals(null))
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
		for (int i = 0; i < s1.length(); i++)
		{
			b[i] = charToByte(s1.substring(i, i + 1));
		}
		return b;
	}

}
