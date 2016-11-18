
/*
Java has 4 different access modifiers for methods: public, private, protected, and package (no access specifier specified)
	public: everyone can access it
	private: no one can access except for methods defined in the same class
	package (no specification of access specifier): methods defined in the same class and methods in classes that belong to the same package (in the same source file for example)
	protected: methods defined in the same class and classes extends from this class (skip this as it's a topic of CS 1B)
In Java in general to invoke a class method follow this rule:
	if invoked inside the same class: simply use method name and parameter list if any
		<method name> (parameter list) ;
		Examples:   handlePlay ( ) ;    getLoanInfo (principal, interestRate) ;
	if invoked outside of the class in which it's defined: use class name and method name and paramter list if any
		<class name>.<method name>  ( parameter list);
		Example:   Inventory.ship ( ) ;   Math.random ( ) ;  Cashier.sell (item);
Trying to invoke a private method from outside of the class is a syntax error
Trying to invoke a package method from a class defined in a different package is a syntax error
Trying to invoke a public method from a different class without prefixing the method with its class name is a syntax error
*/

// Look at example below to see if you can figure out which lines of code will potentially create a syntax error. Both Product class and Utility class defined in the same Product.java source file

/*public  class Product {

    public static  void main (String [ ] args) {

               Utility.m1 ( );

               Utility.m3 ( );

               Utility.m4 ( );

                m3 ( ) ;

                m4 ( );

               verify ( );

     }

     public static void verify ( ) { Utility.m2 ( ) ;  }

}

class Utility  {
         public static void  m1  ( )  {  m3 ( ) ;       m4  ( ) ; }

         public static void  m2 ( )   {

                   Product.verify ( ) ;

                   Product.main ( ) ;

         }

          static void  m3 ( )   {

                   Product.main ( null ) ;

                   verify ( );

                  m2 ( ) ;

         }

         private static void  m4  ( )  {  m2 ( ) ;    m4  ( ) ; }

}*/
