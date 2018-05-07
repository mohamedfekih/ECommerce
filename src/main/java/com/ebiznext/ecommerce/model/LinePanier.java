package com.ebiznext.ecommerce.model;

import java.lang.reflect.Field;
import java.util.Objects;

public class LinePanier {
	private Integer id;
	private Integer quantite;
	private Product product;
	private Command command;
	private Panier panier;
	private Long price;

	public LinePanier() {

	}

	public LinePanier(Integer quantite, Long price, Product product, Command command, Panier panier, Integer id) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.price = price;
		this.product = product;
		this.command = command;
		this.panier = panier;
	}

	public LinePanier(Integer quantite, Long price,Product product, Command command, Panier panier) {
		super();
		this.quantite = quantite;
		this.price = price;
		this.product = product;
		this.command = command;
		this.panier = panier;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	public String toString() {

		Field[] fields = LinePanier.class.getFields();
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
	 * Deep equals method to compare LinePanier
	 * 
	 * @param anotherObject
	 * @return
	 */
	public boolean deepEquals(Object anotherObject) {
		if (!(anotherObject instanceof LinePanier)) {
			return false;
		}

		LinePanier anotherLinePanier = (LinePanier) anotherObject;
		// we compare LinePanier unique attributes
		return Objects.equals(command, anotherLinePanier.getCommand())
				&& Objects.equals(panier, anotherLinePanier.getPanier())
				&& Objects.equals(quantite, anotherLinePanier.getQuantite())
				&& Objects.equals(price, anotherLinePanier.getPrice())
				&& Objects.equals(product, anotherLinePanier.getProduct());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((panier == null) ? 0 : panier.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		LinePanier other = (LinePanier) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (panier == null) {
			if (other.panier != null)
				return false;
		} else if (!panier.equals(other.panier))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		return true;
	}

}
