package many2many.both;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private int id;
	private String name;
	private Set<Category> categories = new HashSet<>();

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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
