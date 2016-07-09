/**
 * Created by andrea on 27/06/16.
 * It belong to BigNumber
 */
public class BN {
//stato interno
	private String original;
	private char s;
	private byte[] I,D;
	static final char comma=',' , period='.';


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
		original=input;

	}



//manipolatori
	public String getOriginal ()
	{
		return original;
	}
	public void setOriginal (String original)
	{
		this.original = original;
	}
	public byte[] getN ()
	{
		return I;
	}
	public void setN (byte[] n)
	{
		I = n;
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

//metodi

	//convert a single char to a byte
	private byte charToByte(String s1)
	{
		//if
		byte n;
		n=Byte.parseByte(s1);
		return n;
	}

}
