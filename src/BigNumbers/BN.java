package BigNumbers;

/**
 * Created by Andrea (Black) Costa on 27/06/16.
 * It belong to BigNumbers
 *
 *          This program is free software: you can redistribute it and/or modify
 *		    it under the terms of the GNU General Public License as published by
 *		    the Free Software Foundation, either version 3 of the License, or
 *		    any later version.
 *
 *		    This program is distributed in the hope that it will be useful,
 *		    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *		    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *		    GNU General Public License for more details.
 *
 *		    You should have received a copy of the GNU General Public License
 *		    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class BN implements Comparable<BN>{
//internal variables
	private static final char comma = ',', period = '.', p = '+', m = '-';
	private long id;
	private static long counter = 0;
	private char s;
	private String number;

//constructors

	//constructor null
	public BN ()
	{
		setNumber("+0");
		BNInitialize();
	}

	//constructor with the string that contain the number
	public BN (String input)
	{
		//set number string
		setNumber(input);

		//initialization of internal variables
		BNInitialize();
	}

	//constructor with number's primitive type
	public <Type extends Number> BN (Type input)
	{
		//set number string
		setNumber(String.valueOf(input));

		//initialization of internal variables
		BNInitialize();
	}

	//constructor with another BN
	public BN (BN bn)
	{
		//set number string
		setNumber(bn.getNumber());

		//initialization of internal variables
		BNInitialize();
	}

//manipulators
	public static char getComma() {
		return comma;
	}
	public static char getPeriod() {
		return period;
	}
	public static char getP() {
		return p;
	}
	public static char getM() {
		return m;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	private static long getCounter() {
		//increase the counter value and return this value -1
		return (counter++ -1);
	}
	private static void setCounter(long counter) {
		BN.counter = counter;
	}
	public char getS() {
		return s;
	}
	public void setS(char s) {
		this.s = s;
	}
	public String getNumber() {
		return String.valueOf(getS()).concat(number);
	}
	public void setNumber(String number) {
		this.number = number;
		BNInitialize();
	}

//methods

	//return BN length
	public int length ()
	{
		return getNumber().length();
	}

	//convert a single char to a byte
	private static byte charToByte (char s1)
	{
		byte n;
		n = Byte.parseByte(String.valueOf(s1));
		return n;
	}

	//Return a boolean value depending on the length of the two numbers
	private static boolean identicalLength(BN x, BN y)
	{
		return x.length() == y.length();
	}

	//TRADURRE banana
	//confronta le cifre di due numeri e restituisce -1 se è maggiore il primo, 1 se è maggiore il secondo, 0 se sono uguali
	private static byte confrontaCifre(String s1, String s2)
	{
		byte b=0;
		for (int i = 0; i < s1.length(); i++)
		{
			//caso in cui è maggiore il primo o il secondo
			if (charToByte(s1.charAt(i)) > charToByte(s2.charAt(i)) || charToByte(s1.charAt(i)) < charToByte(s2.charAt(i)))
			{
				b = (byte) Byte.compare(charToByte(s1.charAt(i)), charToByte(s2.charAt(i)));
				break;
			}
		}
		return b;
	}

	//TRADURRE
	//ritorna l'indice del carattere della virgola nella stringa number dell'oggetto BN
	private static long indiceVirgola (BN x)
	{
		return x.getNumber().indexOf(comma); //sarà -1 se il carattere non è presente
	}

	//TRADURRE
	//rende di uguale lunghezza due numeri
	private static void aggiungiZeri(BN x, BN y)
	{
		String zero = "0";
		long differenzaLunghezza;

		differenzaLunghezza = x.length()-y.length();

		if (differenzaLunghezza > 0) //x è più lungo
		{
			if (indiceVirgola(y)<0)
				y.setNumber(y.getNumber().concat(String.valueOf(comma))); //aggiunge la virgola nel caso sia un numero soltanto intero

			for (long i = 0; i < differenzaLunghezza; i++)
			{
				y.setNumber(y.getNumber().concat(zero));
			}
		}
		else //x è più corto
		{
			if (indiceVirgola(x)<0)
				x.setNumber(x.getNumber().concat(String.valueOf(comma))); //aggiunge la virgola nel caso sia un numero soltanto intero

			for (long i = 0; i < Math.abs(differenzaLunghezza); i++)
			{
				x.setNumber(x.getNumber().concat(zero));
			}
		}

		x.BNInitialize(); y.BNInitialize(); //reinizializzazione dei due oggetti
	}

	//invertS sign of BN object
	private static char invertS(char c)
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

	private static String regularize(String s)
	{
		if (s.contains(String.valueOf(period)))
		{
			s = s.replaceAll(String.valueOf(period),String.valueOf(comma));
		}

		return s;
	}

	//create an Exception if number contains a not valid character
	private boolean generateCharacterException (String input)
	{
	 	input = regularize(input);

		boolean generate=false;

		 for (int i = 0; i < input.length(); )
		{
			if (!(((input.charAt(i) == '0') ||
				   (input.charAt(i) == '1') ||
				   (input.charAt(i) == '2') ||
				   (input.charAt(i) == '3') ||
				   (input.charAt(i) == '4') ||
				   (input.charAt(i) == '5') ||
				   (input.charAt(i) == '6') ||
				   (input.charAt(i) == '7') ||
				   (input.charAt(i) == '8') ||
				   (input.charAt(i) == '9') ||
				   (input.charAt(i) == p) ||
				   (input.charAt(i) == m) ||
				   (input.charAt(i) == comma)
				  )
				 )
			   )
			{
				generate = true;
				break;
			}

			if (!generate)
			{
				if ((input.indexOf(comma) != input.lastIndexOf(comma)) ||
					(input.indexOf(p) != input.lastIndexOf(p)) ||
					(input.indexOf(m) != input.lastIndexOf(m)))
				{
					generate = true;
				}
			}
		}

		return generate;
	}

	//check number isn't null
	private boolean numberIsNull()
	{
		return (number.isEmpty() || number.equals(null));
	}

	//constructor for initialize BN objects
	public void BNInitialize()
	{
		//check the characters
		if (generateCharacterException(number))
		{
			try
			{
				//generate the exception
				throw new BNCharacterException();
			}
			catch (BNCharacterException e)
			{
				e.printStackTrace(); //print the error
				setNumber("ERROR"); //set a number value to mark this is a malformed object
				setS('÷'); //set a s value to mark this is a malformed object
				setId(-999); //set a long value to mark this is a malformed object
			}
		}
		else
		{
			if (!numberIsNull())
			{
				//set s
				if (number.charAt(0) != p && number.charAt(0) != m)// if first character of number are a number
				{
					setS(p);
				}
				else //if first character is p or m
				{
					setS(number.charAt(0));
					setNumber(number.substring(1));//setting number string without S
				}

				//set id
				setId(BN.getCounter());
			}
			else
			{
				setS(p); //S are positive
				setNumber("0"); //number equals 0
				setId(getCounter()); //set the id of object
			}
		}
	}

	//CONTROLLARE
	//this method result a order of size of a BN number
	public static BN orderOfSize (long index)
	{
		BN E = new BN("10");
		String e = E.getNumber();
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

		return A;
	}

/*	//return a boolean value if BN equals zero
	public boolean isZero ()
	{
		boolean isZero= false;

		if (getNumber().length() == 1 && getNumber().equals("0"))
		{
			isZero = true;
		}
		else
		{
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt()==)
			}
		}
		return isZero;
	}*/

	//TRADURRE
	//CONTROLLARE
	//implements interface Comparable
	/** ritorna -1 se è maggiore questo oggetto(this), 1 per il parametro (y) e 0 se sono uguali */
	@SuppressWarnings("SuspiciousNameCombination")
	public int compareTo(BN y)
	{
		int compare = 0;

		if (this.getS()!=y.getS())//se il segno (S) è diverso
		{
			if (this.getS()==p) //se il segno di this è positivo sarà lui ad essere il maggiore
				compare = -1;
			else //altrimenti sarà il minore
				compare = 1;
		}
		else //se il sengo è uguale
		{
			if (!identicalLength(this, y)) //caso in cui non hanno la stessa lunghezza
			{
				aggiungiZeri(this,y);
			}

			//PUO' GENERARE ERRORI!!!!!!!!!!!!!!!!!!!!
			if (indiceVirgola(this) == indiceVirgola(y)) //caso in cui la parte intera è di uguale lunghezza
			{
				if (confrontaCifre(this.getNumber().split(String.valueOf(comma))[0], y.getNumber().split(String.valueOf(comma))[0]) == 0) //caso in cui le parti intere si equivalgono
				{
					if (indiceVirgola(this) > 0 && indiceVirgola(y) > 0) //caso in cui entrambi hanno la parte decimale
					{
						compare = confrontaCifre(this.getNumber().split(String.valueOf(comma))[1], y.getNumber().split(String.valueOf(comma))[1]);
					}
					else if (indiceVirgola(this) > 0 ^ indiceVirgola(y) > 0) //caso in cui solo uno dei due ha la parte decimale
					{
						compare = indiceVirgola(this) > 0 ? -1 : 1; //ritorna 1 se this ha una parte decimale altrimenti riporta 1
					}
					else //caso in cui non hanno parte decimale
					{
						compare = 0;
					}
				}
				else
				{
					compare = confrontaCifre(this.getNumber().split(String.valueOf(comma))[0], y.getNumber().split(String.valueOf(comma))[0]);
				}
			}
			else //caso se la parte intera è di diversa lunghezza
			{
				//noinspection SuspiciousNameCombination
				if (indiceVirgola(this) > indiceVirgola(y)) //se l'indice della virgola è maggiore allora la parte intera è maggiore
				{
					compare = -1;
				}
				else //altrimenti è minore
				{
					compare = 1;
				}
			}
		}

		return compare;
	}

	/***********************************************************************************************/

	//this is a method to sum two BN object
	public BN sum (BN addend)
	{
		boolean decimal;
		byte[] b;
		byte[] b1;
		BN R;


		if (addend.getS() == this.getS())//case with same S
		{
			b1 = new byte[1];
			decimal = !(addend.getd().isEmpty() && this.getd().isEmpty());

			if (this.compareTo(addend) > 0) //case A>B
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

				if (decimal)
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
			}
			else if (this.compareTo(addend) < 0) //case A<B
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

				if (decimal)
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
			}
			else //case A=B
			{
				b = new byte[this.ILength()];
				for (int i = 0; i < this.ILength(); i++)
				{
					b[i] = add(addend.IByteAt(i), this.IByteAt(i));
				}

				if (decimal)
				{
					b1 = new byte[this.DLength()];
					for (int i = 0; i < this.DLength(); i++)
					{
						b1[i] = add(addend.DByteAt(i), this.DByteAt(i));
					}
				}
			}

			counter -= 1;

			if (!(b1.length == 1 && b1[0] == 0))//unit rest from D to I
			{
				if (modulo(invertS(b1)).length != b1.length)//check rest is necessary
				{
					b[0] += 1;
					byte[] b2 = modulo(invertS(b1));
					byte[] b3 = new byte[b1.length];
					System.arraycopy(b2, 0, b3, 0, b1.length);
					R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(b3)));
					return R;
				}
				else
				{
					R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(modulo(invertS(b1)))));
					return R;
				}
			}
			else
			{
				R = new BN(charToString(this.getS()).concat(byteArrayToString(modulo(b))));
				return R;
			}
		}
		else//case with different S //TO OPTIMIZE IT!!!
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
						b[i] = add(this.IByteAt(i), invertS(addend.IByteAt(i)));
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

						b[i] = add(addend.IByteAt(i), invertS(this.IByteAt(i)));
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
								b = sumByteAt(b, i, add(this.IByteAt(i), invertS(addend.IByteAt(i))));
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
								b = sumByteAt(b, i, (add(addend.IByteAt(i), invertS(this.IByteAt(i)))));
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
								b1 = sumByteAt(b1, i, (byte) Math.abs(add(this.DByteAt(i), invertS(addend.DByteAt(i)))));
							}
						}
						else
						{
							byte[] b2 = new byte[b1.length];

							System.arraycopy(addend.getD(), 0, b2, 0, addend.DLength());

							//addend.setD(b2);

							BN X = new BN(charToString(m).concat(this.getd())).sum(new BN(byteArrayToString(invertS(b2))));

							counter -= 3;

							/*if (X.getS() == m)
							{
								b = new BN(byteArrayToString(b)).sum(new BN("-1")).getI();
							}*/

							b1 = invertS(X.getI());

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
								b1 = sumByteAt(b1, i, (byte) Math.abs(add(addend.DByteAt(i), invertS(this.DByteAt(i)))));
							}
						}
						else
						{
							byte[] b2 = new byte[b1.length];

							System.arraycopy(this.getD(), 0, b2, 0, this.DLength());


							BN X = new BN(charToString(m).concat(addend.getd())).sum(new BN(byteArrayToString(invertS(b2))));

							counter -= 3;

							b1 = invertS(X.getI());
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
								if (add(addend.DByteAt(i), invertS(this.DByteAt(i))) < 0 && (!Iequals && !Pmajor))
								{
									BN X = orderOfSize(addend.DLength());
									BN Y = new BN(addend.getd());
									BN Z = new BN("-".concat((this.getd())));
									counter = -3;

									try
									{
										b1 = invertS(new BN(generateCharacterException(byteArrayToString((X.sum(Y)).sum(Z).getI()))).getI());
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
									b1 = sumByteAt(b1, i, add(this.DByteAt(i), invertS(addend.DByteAt(i))));
								}
							}
							else if (Byte.compare(addend.DByteAt(i), this.DByteAt(i)) > 0)
							{

								if (add(this.DByteAt(i), invertS(addend.DByteAt(i))) < 0 && (!Iequals && !Pmajor))
								{
									BN X = orderOfSize(addend.DLength());
									BN Y = new BN(this.getd());
									BN Z = new BN("-".concat((addend.getd())));
									counter = -3;

									try
									{
										b1 = invertS(new BN(generateCharacterException(byteArrayToString((X.sum(Y)).sum(Z).getI()))).getI());
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
									b1 = sumByteAt(b1, i, add(addend.DByteAt(i), invertS(this.DByteAt(i))));
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
						b1 = (orderOfSize(b1.length).sum(new BN("-".concat(byteArrayToString(invertS(b1)))))).getI();
						counter -= 4;
						System.arraycopy(invertS(b1), 1, b1, 0, b1.length-1);
					}


					R.setNumber(charToString(c1).concat(byteArrayToString(modulo(b))).concat(",").concat(byteArrayToString(modulo(invertS(b1)))));
					R.BNInitialize();
				}
			}
			else
			{
				R = addend.sum(this);
				//C.setS(invertS(C.getS()));
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

		detract.setS(invertS(detract.getS()));

		R = this.sum(detract);

		return R;
	}

	//return the multiplication between two BN object
	public BN multiplication (BN factor)
	{
		BN R;
		BN C;
		BN N = new BN();
		//BN detract = new BN("1");
		//int i = 2;

		R = N;

		if (this.length() >= factor.length())
		{

			if (this.DLength() == 0 && factor.DLength() == 0)//case without decimal part
			{
				BN partial = new BN();
				BN total = new BN();

				if (factor.isZero() || this.isZero())
				{
					R = N;
				}
				else
				{
					char[] f = invertS(factor.getAbs().toCharArray());
					String s;
					long l = 0;

					for (char c : f)
					{
						s = String.valueOf(c);
						l++;

						for (long l1 = 1; l1 < l; l1++)
						{
							s = s.concat("0");
						}

						for (long l2 = Long.parseLong(s); l2 >= 0; l2--)
						{
							if (l2 != 0)
								partial = partial.sum(this);
							else
								partial = partial.sum(new BN(stringTokenizer("0",s.length() - 1), 'c'));
						}


						total = total.sum(partial);

						partial = new BN();
					}


					if (factor.getS() != this.getS())
					{
						R.setS(m);
					}
					else
					{
						R.setS(p);
					}

					R.setAbs(total.getAbs());
				}

				R.setNumber(String.valueOf(R.getS()).concat(R.getAbs()));
			}
			else//case with decimal part
			{
				//BN D;
				String abs1 = "", abs2 = "", provv = "", result;
				int indexComma;


				for (int j = 0; j < this.length(); j++)
				{
					if (j < this.ILength())
						abs1 = abs1.concat(String.valueOf(this.IByteAt(j)));
					else
					{
						//this.setD(invertS(this.getD()));
						abs1 = abs1.concat(String.valueOf(this.DByteAt(j - this.ILength())));
					}
				}

				for (int j = 0; j < factor.length(); j++)
				{
					if (j < factor.ILength())
						abs2 = abs2.concat(String.valueOf(factor.IByteAt(j)));
					else
					{
						//factor.setD(invertS(factor.getD()));
						abs2 = abs2.concat(String.valueOf(factor.DByteAt(j - factor.ILength())));
					}
				}

				C = (new BN(String.valueOf(abs1)).multiplication(new BN(String.valueOf(abs2))));

				result = C.getAbs();

				indexComma = result.length() - (this.DLength() + factor.DLength());

				if (indexComma <= 0)
				{
					int j = 0;
					{
						j++;
					}
					for (int k = 0; k <= j; k++)
					{
						result = "0".concat(result);
					}

					indexComma = result.length() - (this.DLength() + factor.DLength());
				}

				String s;
				for (int j = 0; j < result.length(); j++)
				{
					s = String.valueOf(result.charAt(j));

					if (j == indexComma)
						provv = provv.concat(String.valueOf(comma));

					provv = provv.concat(s);
				}

				if (factor.getS() != this.getS())
				{
					R.setS(m);
				}
				else
					R.setS(p);

				R.setNumber(String.valueOf(R.getS()).concat(provv));

				counter -= 2;
			}

			R.BNInitialize();

			if (R.geti().length() == 0)//it's probably unnecessary
			{
				R.setNumber(String.valueOf(R.getS()).concat("0").concat(R.getAbs()));
				R.BNInitialize();
			}
		}
		else
		{
			R = factor.multiplication(this);
		}

		return R;
	}

	public static BN pow (BN base, long exponent) /*throws BNExponentException*/ //PROVVISORIO!!!
	{
		BN A;
		BN B;
		BN ten = new BN("10");

		if (base==ten)
			B = BN.orderOfSize(exponent);
		else
		{
			if (exponent < 2)
			{
				if (exponent < 0)
				{
				/*throw new BNExponentException();*/
					B = new BN("0");
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
				for (long i = 2; i < exponent; i++)
				{
					B = B.multiplication(base);
				}
			}
		}

		A = B;

		return A;
	}
}