package teitelbaum.dictionary;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest 
{
	@Test 
	public void testExists() throws Exception
	{
		Dictionary d = new Dictionary();
		boolean exists = d.exists("cow");
		Assert.assertTrue(exists);
		
		exists = d.exists("cowmoo");
		Assert.assertFalse(exists);
		
		exists = d.exists("banana");
		Assert.assertTrue(exists);
		
		exists = d.exists("monkeybanana");
		Assert.assertFalse(exists);
		
		exists = d.exists("apple");
		Assert.assertTrue(exists);
		
		exists = d.exists("hello");
		Assert.assertTrue(exists);
		
		exists = d.exists("WORLD");
		Assert.assertTrue(exists);
		
		exists = d.exists("helloWorld");
		Assert.assertFalse(exists);
		
		exists = d.exists("");
		Assert.assertFalse(exists);
		
		exists = d.exists(null);
		Assert.assertFalse(exists);
		
		Assert.assertTrue(d.exists("Driver"));
		
		Assert.assertFalse(d.exists("Tombronese"));
	}
}
