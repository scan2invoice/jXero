/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.softlysoftware.jxero.core;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.NONE)
public class Invoice {

	@XmlElement(name = "InvoiceID")
	private String id;
	public String getId(){return id;}
	public void setId(String id){this.id = id;}

	@XmlElement(name = "InvoiceNumber")
	private String number;
	public String getNumber(){return number;}
	public void setNumber(String number){this.number = number;}

	public enum Type {ACCPAY, ACCREC};

	@XmlElement(name = "Type")
	private String type;

	@XmlElement(name = "AmountDue")
	private String amountDue;
	public double getAmountDue(){return Formats.parseMoney(amountDue);}
	public void setAmountDue(double amountDue){this.amountDue = Formats.formatMoney(amountDue);}
	public void setAmountDue(BigDecimal amountDue){this.amountDue = Formats.formatMoney(amountDue);}

	public Type getType() {
		if (type == null) return null;
		if (type.equals("ACCPAY")) return Type.ACCPAY;
		if (type.equals("ACCREC")) return Type.ACCREC;
		throw new RuntimeException("Bad Invoice type : " + type);
	}
	public void setType(Type type) {this.type = type.toString();}

	@XmlElement(name = "Contact")
	private Contact contact;
	public Contact getContact(){return contact;}
	public void setContact(Contact contact){this.contact = contact;}

	@XmlElement(name = "Date")
	private String date;
	public Date getDate(){return Formats.parseDate(date);}
	public void setDate(Date date){this.date = Formats.formatDate(date);}

	@XmlElement(name = "DueDate")
	private String dueDate;
	public Date getDueDate(){return Formats.parseDate(dueDate);}
	public void setDueDate(Date dueDate){this.dueDate = Formats.formatDate(dueDate);}

	@XmlElement(name = "Reference")
	private String reference;
	public String getReference(){return reference;}
	public void setReference(String reference){this.reference = reference;}

	@XmlElement(name = "BrandingThemeID")
	private String brandingThemeID;
	public String getBrandingThemeID(){return brandingThemeID;}
	public void setBrandingThemeID(String brandingThemeID){this.brandingThemeID = brandingThemeID;}

	@XmlElement(name = "Url")
	private String url;
	public String getUrl(){return url;}
	public void setUrl(String url){this.url = url;}

	@XmlElement(name = "CurrencyCode")
	private String currencyCode;
	public String getCurrencyCode(){return currencyCode;}
	public void setCurrencyCode(String currencyCode){this.currencyCode = currencyCode;}

	public enum Status {DRAFT, SUBMITTED, AUTHORISED, PAID, VOIDED};

	@XmlElement(name = "Status")
	private String status;
	public Status getStatus(){
		if (status == null) return null;
		if (status.equals("DRAFT")) return Status.DRAFT;
		if (status.equals("SUBMITTED")) return Status.SUBMITTED;
		if (status.equals("AUTHORISED")) return Status.AUTHORISED;
		if (status.equals("PAID")) return Status.PAID;
		if (status.equals("VOIDED")) return Status.VOIDED;
		throw new RuntimeException("Bad status : " + status);
	}
	public void setStatus(Status status){this.status = status.toString();}

	@XmlElement(name = "LineAmountTypes")
	private String lineAmountTypes;
	public String getLineAmountTypes(){return lineAmountTypes;}
	public void setLineAmountTypes(String lineAmountTypes){this.lineAmountTypes = lineAmountTypes;}

	@XmlElement(name = "SubTotal")
	private String subTotal;
	public double getSubTotal(){return Formats.parseMoney(subTotal);}
	public void setSubTotal(double subTotal){this.amountDue = Formats.formatMoney(subTotal);}

	@XmlElement(name = "TotalTax")
	private String totalTax;
	public double getTotalTax(){return Formats.parseMoney(totalTax);}
	public void setTotalTax(double totalTax){this.amountDue = Formats.formatMoney(totalTax);} 

	@XmlElement(name = "Total")
	private String total;
	public double getTotal(){return Formats.parseMoney(total);}
	public void setTotal(double total){this.amountDue = Formats.formatMoney(total);}

	@XmlElementWrapper(name = "LineItems")
	@XmlElement(name = "LineItem")
	private List<LineItem> lineItems = new LinkedList<LineItem>();
	public List<LineItem> getLineItems(){return lineItems;}
	public void setLineItems(List<LineItem> lineItems){this.lineItems = lineItems;}

	@XmlElementWrapper(name = "Payments")
	@XmlElement(name = "Payment")
	private List<Payment> payments = new LinkedList<Payment>();
	public List<Payment> getPayments() {return payments;}
	public void setPayments(List<Payment> payments) {this.payments = payments;}

}