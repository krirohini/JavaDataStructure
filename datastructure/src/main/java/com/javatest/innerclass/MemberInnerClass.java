package com.javatest.innerclass;

/**
 * http://www.javatpoint.com/member-inner-class The java compiler creates a
 * class file named Outer$Inner in this case. The Member inner class have the
 * reference of Outer class that is why it can access all the data members of
 * Outer class including private.
 * 
 * import java.io.PrintStream;  
class Outer$Inner  
{  
    final Outer this$0;  
    Outer$Inner()  
    {   super();  
        this$0 = Outer.this;  
    }  
    void msg()  
    {  
        System.out.println((new StringBuilder()).append("data is ")  
                    .append(Outer.access$000(Outer.this)).toString());  
    }  
}  
 *
 */
public class MemberInnerClass {

	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("data access from inner class is " + data);
		}
	}

	public static void main(String args[]) {
		MemberInnerClass obj = new MemberInnerClass();
		MemberInnerClass.Inner inner1 = obj.new Inner();
		Inner inner2 = obj.new Inner();
		inner1.msg();
	}

}
