package many2many;

public class Item {
	private int id;
	private String name;
	
	public Item(String name) {
		super();
		this.name = name;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
