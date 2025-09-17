package util;

import java.util.List;

public class MyList {
	List<String> list;

	
	//new myList(list)
	//Constructor Injection
	public MyList(List<String> list) {
		super();
		this.list = list;
	}


	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	
}
