package test.fun;

public class Dog extends Animal{
	private String name;
	public Dog(String type, String name) {
		super(type);
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public static void main(String[] args) {
		Dog dog = new Dog("狗", "哈士奇");
		System.out.println(dog.getType());
	}
	public void Cat(){
		String c = this.getType();
		System.out.println(c);
	}
}
