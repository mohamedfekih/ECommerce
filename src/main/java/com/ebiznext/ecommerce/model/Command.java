package com.ebiznext.ecommerce.model;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.Objects;

public class Command {
	private Integer id;
	private Instant dateCommande;
	private Customer customer;

	public Command(Integer id, Instant dateCommande, Customer customer) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.customer = customer;
	}

	public Command() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Instant dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String toString() {

		Field[] fields = Command.class.getFields();
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
	 * Deep equals method to compare Command
	 * 
	 * @param anotherObject
	 * @return
	 */
	public boolean deepEquals(Object anotherObject) {
		if (!(anotherObject instanceof Command)) {
			return false;
		}

		Command anotherCommand = (Command) anotherObject;
		// we compare command unique attributes
		return Objects.equals(customer, anotherCommand.getCustomer())
				&& Objects.equals(dateCommande, anotherCommand.getDateCommande());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateCommande == null) ? 0 : dateCommande.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateCommande == null) {
			if (other.dateCommande != null)
				return false;
		} else if (!dateCommande.equals(other.dateCommande))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
