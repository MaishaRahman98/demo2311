package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringInstrumentTest {
	String str1 = "G|--------------------------------------------|";
	String str2 = "D|------5-----------------5-------------------|";
	String str3 = "A|-7--7---7--5-------7--7----7--5----5--------|";
	String str4 = "E|-------------8--7----------------8----8--7~-|";
	String str5 = "D|------5-----------------5-------------------|";
	
	
	StringInstrument F = StringInstrument.getBass(str1, str2, str3, str4);
	StringInstrument G = StringInstrument.getBass(str1, str2, str3, str4,str5);
	
	
	

	@Test
	void test2() {
		StringInstrument F = new StringInstrument();
		F.setType('4');
		assertTrue(F.getType() == '4');
		
		
		
	}
	@Test
	void test1() {
		StringInstrument G = new StringInstrument();
		G.setType('5');
		assertTrue(G.getType() == '5');
	}
		
	}


