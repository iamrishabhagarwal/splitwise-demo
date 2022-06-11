package com.setu.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paid_by", referencedColumnName = "id")
	@Fetch(FetchMode.JOIN)
	private User paidBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paid_for", referencedColumnName = "id")
	@Fetch(FetchMode.JOIN)
	private User paidFor;
	
	@Column
	private double due;
	@Column(name = "is_settled")
	private String isSettled;
	@Column(name = "cleared_dues")
	private double clearedDues;

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(double amount, User paidBy, User paidFor, double due, String isSettled, double clearedDues) {
		super();
		this.amount = amount;
		this.paidBy = paidBy;
		this.paidFor = paidFor;
		this.due = due;
		this.isSettled = isSettled;
		this.clearedDues = clearedDues;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}

	public User getPaidFor() {
		return paidFor;
	}

	public void setPaidFor(User paidFor) {
		this.paidFor = paidFor;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	public String getIsSettled() {
		return isSettled;
	}

	public void setIsSettled(String isSettled) {
		this.isSettled = isSettled;
	}

	public double getClearedDues() {
		return clearedDues;
	}

	public void setClearedDues(double clearedDues) {
		this.clearedDues = clearedDues;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", paidBy=" + paidBy + ", paidFor=" + paidFor + ", due="
				+ due + ", isSettled=" + isSettled + ", clearedDues=" + clearedDues + "]";
	}

}
