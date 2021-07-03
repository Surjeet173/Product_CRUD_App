package product_crud_app.model;

class Employee
{
	int age;
	String name;
	public Employee(int age, String name)
	{
	
		this.age = age;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(this == null || this.getClass() != obj.getClass())
		{
			return false;
		}
		Employee emp=(Employee)obj;
		return ! this.name.equals(emp.name) && this.age != emp.age ;
	}
}
public class CompareObject 
{
	

	public static void main(String[] args) 
	{
		Employee e1= new Employee(15,"Ram");
		Employee e2= new Employee(25,"Sam");
		// TODO Auto-generated method stub
		System.out.println(e1.equals(e2));

	}

}
