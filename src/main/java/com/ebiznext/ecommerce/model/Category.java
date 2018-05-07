package com.ebiznext.ecommerce.model;

import java.lang.reflect.Field;
import java.util.Objects;

public class Category {
	private Integer id;
	private String nameCategory;
	private String picture;
	private String description;

	public Category(Integer id, String nameCategory,  String description) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.description = description;
	}
	
	public Category(Integer id, String nameCategory, String picture, String description) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.picture = picture;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {

		Field[] fields = Category.class.getFields();
		StringBuffer sb = new StringBuffer();

		for (Field field : fields) {
			try {
				if (field.get(this) != null) {
					sb.append(field.getName() + " = " + field.get(this) + "\r\n");
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * Deep equals method to compare Category
	 * 
	 * @param anotherObject
	 * @return
	 */
	public boolean deepEquals(Object anotherObject) {
		if (!(anotherObject instanceof Category)) {
			return false;
		}

		Category anotherCategory = (Category) anotherObject;
		// we compare customer unique attributes
		return Objects.equals(description, anotherCategory.getDescription())
				&& Objects.equals(nameCategory, anotherCategory.getNameCategory())
				&& Objects.equals(picture, anotherCategory.getPicture());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameCategory == null) ? 0 : nameCategory.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameCategory == null) {
			if (other.nameCategory != null)
				return false;
		} else if (!nameCategory.equals(other.nameCategory))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}
	
	
	
}
