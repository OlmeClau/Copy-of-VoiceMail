
public class Contact {
	private String name;
	private int number;
	
   public Contact(String aname, int anumber)
   {
	   name = aname;
	   number = anumber;
   
   }
   public void set_number(int new_number)
   {
	   number=new_number;
   }
   public void set_name(String new_name)
   {
	   name=new_name;
   }
   public int get_number()
   {
	   return number;
   }
   public String get_name()
   {
	   return name;
   }
}
