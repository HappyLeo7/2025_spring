package vo;

public class PersonVo {

	String name;
	int age;
	String tel;
	
	
	@Override
	public String toString() {
		return "PersonVo [name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}


	/**기본생성자*/
	public PersonVo() {
		System.out.println("--- PersonVo() 생성됨 ---");
	}
	
	
	/**String name, int age, String tel 생성자*/
	public PersonVo(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		System.out.println("--- PersonVo(name,age,tel) 생성됨 ---");
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("-- setName(name) --");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
