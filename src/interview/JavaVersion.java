/*
 * Support for Java Version retrieval.
 *
 * More details about the string format can be found here:
 *
 * http://java.sun.com/j2se/versioning_naming.html
 */
package interview;

/**
 * UWJavaVersion class.
 *
 * @author    nusi62000007    2009/11/05 - initial version ( based on lume62000218 findings )
 */
public class JavaVersion
{
    final static String acRcsID =
        "$RCSfile$ $Revision: 38295 $ $Date: 2016-09-28 02:02:48 +0100 (Wed, 28 Sep 2016) $ $Author: nusi62000007 $";

    /**
     * Major ( if version = 1.3.0_12, major = 3 )
     */
    public final int major;

    /**
     * Minor ( if version = 1.3.0_12, minor = 0 )
     */
    public final int minor;

    /**
     * Update ( if version = 1.3.0_12, update = 12 )
     */
    public final int update;

    private final String strJavaVersion = System.getProperty( "java.version" );

    /**
     * Constructor.
     */
    public JavaVersion()
    {
        int iMajor = 0;
        int iMinor = 0;
        int iUpdate = 0;

        String strArr[] = this.strJavaVersion.split( "\\." );

        if ( strArr.length >= 3 )
        {
            iMajor = Integer.parseInt( strArr[ 1 ] );

            if ( strArr[ 2 ].contains( "_" ) )
            {
				String strArr2[] = strArr[ 2 ].split( "-" );

                if ( strArr2.length >= 1 )
				{
					iMinor = Integer.parseInt( strArr2[ 0 ] );

                    if ( strArr2.length > 1 )
                    {
						String strArr3[] = strArr2[ 1 ].split( "_" );

                        iUpdate = Integer.parseInt( strArr3[ 0 ] );
                    }
                }
            }
            else if ( strArr[ 2 ].contains( "-" ) )
            {

                String strArr2[] = strArr[ 2 ].split( "-" );

                if ( strArr2.length >= 1 )
                {
                    iMinor = Integer.parseInt( strArr2[ 0 ] );

                    if ( strArr2.length > 1 )
                    {
                        String strArr3[] = strArr2[ 1 ].split( "-" );

                        strArr3[ 0 ] = strArr3[ 0 ].replace( "u", "" );

                        iUpdate = Integer.parseInt( strArr3[ 0 ] );
                    }
                }
            }
        }

        this.major = iMajor;
        this.minor = iMinor;
        this.update = iUpdate;
    }

    /**
     * Gets Current Java Version.
     *
     * @return    String    java version
     */
    public String getVersion()
    {
        return this.strJavaVersion;
    }
}
