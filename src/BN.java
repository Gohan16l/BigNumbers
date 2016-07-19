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
	static final char comma=',' , period='.';
	static final char p='+', m='-';


//costruttori

	BN()
	{
		I=new byte[]{0};
		D=new byte[]{0};
		s='+';
		original="0";
	}

	BN(String input)
	{
		setOriginal(input);

		int n=0;
		if(original.charAt(0)==p || original.charAt(0)==m)
		{
			setS(original.charAt(0));
			n=1;
		}
		else
			setS(p);

		String s1="";
		boolean i1=true;

		try
		{
			for (; n < original.length(); n++)
			{
				char c = original.charAt(n);
				switch (c)
				{
					case '0':
						s1 = "0";
					case '1':
						s1 = "1";
					case '2':
						s1 = "2";
					case '3':
						s1 = "3";
					case '4':
						s1 = "4";
					case '5':
						s1 = "5";
					case '6':
						s1 = "6";
					case '7':
						s1 = "7";
					case '8':
						s1 = "8";
					case '9':
						s1 = "9";
					case comma:
						i1 = false;
					case period:
						i1 = false;
					default:
						throw new BNCharacterException();
				}
				if (i1)
				{
					i+=s1;
				}
				else
				{
					d+=s1;
				}
			}
		}
		catch (BNCharacterException e)
		{
			System.out.println(e.getError());
		}
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
	public void setI (byte[] n)
	{
		I = n;
	}
	public byte[] getD ()
	{
		return D;
	}
	public void setD (byte[] d)
	{
		D = d;
	}
	public char getS ()
	{
		return s;
	}
	public void setS (char s)
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

}
