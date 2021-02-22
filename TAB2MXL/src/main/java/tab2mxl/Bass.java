package tab2mxl;

public class Bass extends StringInstrument
{
	
	private Bass()
	{
		super();
	}
	
	private Bass(String s1, String s2, String s3, String s4)
	{
		//4 string bass
		super(s1, s2, s3, s4);
	}
	
	private Bass(String s1, String s2, String s3, String s4, String s5)
	{
		//5 string bass
		super(s1, s2, s3, s4, s5);
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4)
	{
		return new Bass(s1, s2, s3, s4);	
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4, String s5)
	{
		return new Bass(s1, s2, s3, s4, s5);	
	}
	
	
	
}