import java.io.*;

public class JavaConsoleInput {
	 public static void main (String [ ] args) {
	        int        productID = 0;
	        double  productPrice = 0.0;
	        String   productDescription = "";

	        try {
	                String buffer;
	                BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	                // read integer
	                System.out.print ("Enter product ID --> ") ;
	                buffer = br.readLine ();
	                productID = Integer.parseInt(buffer);

	                // read double
	                System.out.print ("Enter product price --> ") ;
	                buffer = br.readLine ();
	                productPrice = Double.parseDouble(buffer);

	                // read a string
	                System.out.print ("Enter product description --> ") ;
	                buffer = br.readLine ();
	                productDescription = buffer;

	        } catch (IOException e) { e.printStackTrace ( ); }

	      //  br.close ( );
	        // output results without formatting

	        System.out.println ("Product ID: " + productID );
	        System.out.println ("Product price: " + productPrice );
	        System.out.println ("Product description: " + productDescription );

	        // output with some formatting

	        System.out.format ("Product ID:\t%012d%n", productID );
	        System.out.format ("Product price:\t%9.4f%n", productPrice );
	        System.out.format ("Product description:\t%10s%n", productDescription );
	    }
	}

