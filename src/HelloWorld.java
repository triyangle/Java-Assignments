
//assume specification is this when resolving ambiguity

import java.awt.*;

import javax.swing.*;
import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stuB

		boolean a = true;
		boolean b = false;
				
		System.out.println(a && (b || !a));
		System.out.println(a && b);

		System.out.println(((a && (b || !a)) == a && b));
		
	}

}
