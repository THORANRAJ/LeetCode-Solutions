package thorproj;

public class user {
	private String name,form,tot,kids,adults,day,mon,yer,price;
	public user(String name,String form,String tot,String kids,String adults,String day,String mon ,String yer,String price)
	{
		this.name=name;
		this.form=form;
		this.tot=tot;
		this.kids=kids;
		this.adults=adults;
		this.day=day;
		this.mon=mon;
		this.yer=yer;
		this.price=price;
	}
	public String getname()
	{
		return name;
	}
	public String getform()
	{
		return form;
	}
	public String gettot()
	{
		return tot;
	}
	public String getkids()
	{
		return kids;
	}public String getadults()
	{
		return adults;
	}public String getday()
	{
		return day;
	}
	public String getmon()
	{
		return mon;
	}
	public String getyer()
	{
		return yer;
	}
	public String getprice()
	{
		return price;
	}
}
