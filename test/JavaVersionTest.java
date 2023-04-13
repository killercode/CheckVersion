/*
 * UWJavaVersion Tests.
 *
 * $RCSfile$ $Revision: 26007 $ $Date: 2014-01-25 00:22:17 +0000 (Sat, 25 Jan 2014) $ $Author: nusi62000007 $
 */


import org.junit.Assert;
import org.junit.Test;
import interview.JavaVersion;


public class JavaVersionTest
{

    @Test
    public void printJavaVersion()
    {
		JavaVersion clsVersion = new JavaVersion();

		System.out.println( "Java Version: " + clsVersion.getVersion() );
		System.out.println( "Major: " + clsVersion.major );
		System.out.println( "Minor: " + clsVersion.minor );
		System.out.println( "Update: " + clsVersion.update );

		// note: support for official releases only
		String strVersion = System.getProperty( "java.version" );

		if ( strVersion.contains( "_" ) )
		{
			Assert.assertEquals(	System.getProperty( "java.version" ),
									String.format( "1.%d.%d_%d", clsVersion.major, clsVersion.minor, clsVersion.update ) );
		}
	}
}
