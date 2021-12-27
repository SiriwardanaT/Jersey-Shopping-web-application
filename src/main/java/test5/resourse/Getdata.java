package test5.resourse;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("myresource")
public class Getdata {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Home getIt() {
    	owner o1 = new owner("smith");
    	owner o3 = new owner("smith");
    	owner o2 = new owner("smith");
    	List<owner> l = new ArrayList<owner>();
    	l.add(o1);
    	l.add(o3);
    	l.add(o2);
    	
    	Home h = new Home("jems",l);
    	System.out.println(h);
        return h;
        
    }
}

class Home {
	private String name;
	private List<owner> list;
	

	public Home(String name, List<owner> list) {
		super();
		this.name = name;
		this.list = list;
	}

	public List<owner> getList() {
		return list;
	}

	public void setList(List<owner> list) {
		this.list = list;
	}

	public Home( String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

class owner {
	private String name;
	
	public owner( String name) {
		super();
		this.name = name;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
