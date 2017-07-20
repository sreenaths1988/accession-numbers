package org.sreenath.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sreenath.java.App;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
        // input arguments of comma separated accession numbers
        String inputArgs = "A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1";
        // expected list
        List<String> expectedList = new ArrayList<String>(Arrays.asList("A00000", "A0001", "ABCDEFG1", "DRR2110012", "ERR000111-ERR000113", "ERR000115-ERR000116", "ERR100114", "ERR200000001-ERR200000003", "SRR211001"));
        // calculated/actual list
        List<String> actualList = App.getOrderedList(inputArgs);
        
        Assert.assertEquals("Test failed!!!", expectedList, actualList);
      
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
