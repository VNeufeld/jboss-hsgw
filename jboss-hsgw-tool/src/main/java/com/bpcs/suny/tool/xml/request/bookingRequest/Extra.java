//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.01 at 05:06:49 PM CET 
//


package com.bpcs.suny.tool.xml.request.bookingRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}Id" minOccurs="0"/>
 *         &lt;element ref="{}Code"/>
 *         &lt;element ref="{}Name" minOccurs="0"/>
 *         &lt;element ref="{}Amount" minOccurs="0"/>
 *         &lt;element ref="{}Dim1" minOccurs="0"/>
 *         &lt;element ref="{}Dim2" minOccurs="0"/>
 *         &lt;element ref="{}LowerPrice" minOccurs="0"/>
 *         &lt;element ref="{}UpperPrice" minOccurs="0"/>
 *         &lt;element ref="{}Currency" minOccurs="0"/>
 *         &lt;element ref="{}Status" minOccurs="0"/>
 *         &lt;element ref="{}CurrencyId" minOccurs="0"/>
 *         &lt;element ref="{}Info" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Extra")
public class Extra {

    @XmlElement(name = "Id")
    protected Long id;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Amount")
    protected Short amount;
    @XmlElement(name = "Dim1")
    protected String dim1;
    @XmlElement(name = "Dim2")
    protected String dim2;
    @XmlElement(name = "LowerPrice")
    protected String lowerPrice;
    @XmlElement(name = "UpperPrice")
    protected String upperPrice;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "CurrencyId")
    protected Long currencyId;
    @XmlElement(name = "Info")
    protected String info;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAmount(Short value) {
        this.amount = value;
    }

    /**
     * Gets the value of the dim1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim1() {
        return dim1;
    }

    /**
     * Sets the value of the dim1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim1(String value) {
        this.dim1 = value;
    }

    /**
     * Gets the value of the dim2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim2() {
        return dim2;
    }

    /**
     * Sets the value of the dim2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim2(String value) {
        this.dim2 = value;
    }

    /**
     * Gets the value of the lowerPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowerPrice() {
        return lowerPrice;
    }

    /**
     * Sets the value of the lowerPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowerPrice(String value) {
        this.lowerPrice = value;
    }

    /**
     * Gets the value of the upperPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpperPrice() {
        return upperPrice;
    }

    /**
     * Sets the value of the upperPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpperPrice(String value) {
        this.upperPrice = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the currencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrencyId() {
        return currencyId;
    }

    /**
     * Sets the value of the currencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrencyId(Long value) {
        this.currencyId = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

}
