package com.ebiznext.ecommerce.model;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;



public class Product {
	private Integer id;
	private UUID productUid;
	private String designation;
	private String description;
	private boolean selectionne;
	private String photo;
	private Category category;
	private Date dateAdd;
	
	public Product() {

	}

	public Product(Integer id,UUID productUid, String designation, String description, boolean selectionne,Category category ) {
		super();
		this.id = id;
		this.productUid=productUid;
		this.designation = designation;
		this.description = description;
		this.selectionne = selectionne;
		this.category=category;
	}

	public Product(Integer id,UUID productUid, String designation, String description, boolean selectionne, String photo, Category category) {
		super();
		this.id = id;
		this.productUid=productUid;
		this.designation = designation;
		this.description = description;
		this.selectionne = selectionne;
		this.photo = photo;
		this.category=category;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getProductUid() {
		return productUid;
	}

	public void setProductUid(UUID productUid) {
		this.productUid = productUid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}
	
	

	/**
	 * Override to String method
	 */
	public String toString() {

		Field[] fields = Product.class.getFields();
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
	 * Deep equals method to compare Products
	 * @param anotherObject
	 * @return
	 */
	public boolean deepEquals(Object anotherObject) {
		if (!(anotherObject instanceof Product)) {
			return false;
		}

		Product anotherProduct = (Product) anotherObject;
		// we compare Product unique attributes
		return Objects.equals(productUid, anotherProduct.getProductUid())
				&& Objects.equals(description, anotherProduct.getDescription())
				&& Objects.equals(designation, anotherProduct.getDesignation())
				&& Objects.equals(category, anotherProduct.getCategory());

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateAdd == null) ? 0 : dateAdd.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((productUid == null) ? 0 : productUid.hashCode());
		result = prime * result + (selectionne ? 1231 : 1237);
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateAdd == null) {
			if (other.dateAdd != null)
				return false;
		} else if (!dateAdd.equals(other.dateAdd))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (productUid == null) {
			if (other.productUid != null)
				return false;
		} else if (!productUid.equals(other.productUid))
			return false;
		if (selectionne != other.selectionne)
			return false;
		return true;
	}



	

	
	
}
