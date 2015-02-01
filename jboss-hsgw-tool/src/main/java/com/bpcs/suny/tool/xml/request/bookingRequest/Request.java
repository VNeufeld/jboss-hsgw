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
 *       &lt;sequence>
 *         &lt;element ref="{}CalledFrom"/>
 *         &lt;element ref="{}DemandedObjects"/>
 *         &lt;element ref="{}Administration"/>
 *         &lt;element ref="{}Customer"/>
 *         &lt;element ref="{}Travel"/>
 *         &lt;element ref="{}Car"/>
 *         &lt;element ref="{}Insurance" minOccurs="0"/>
 *         &lt;element ref="{}Extras" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "calledFrom",
    "demandedObjects",
    "administration",
    "customer",
    "travel",
    "car",
    "insurance",
    "extras"
})
@XmlRootElement(name = "Request")
public class Request {

    @XmlElement(name = "CalledFrom")
    protected short calledFrom;
    @XmlElement(name = "DemandedObjects", required = true)
    protected DemandedObjects demandedObjects;
    @XmlElement(name = "Administration", required = true)
    protected Administration administration;
    @XmlElement(name = "Customer", required = true)
    protected Customer customer;
    @XmlElement(name = "Travel", required = true)
    protected Travel travel;
    @XmlElement(name = "Car", required = true)
    protected Car car;
    @XmlElement(name = "Insurance")
    protected Insurance insurance;
    @XmlElement(name = "Extras")
    protected Extras extras;

    /**
     * Gets the value of the calledFrom property.
     * 
     */
    public short getCalledFrom() {
        return calledFrom;
    }

    /**
     * Sets the value of the calledFrom property.
     * 
     */
    public void setCalledFrom(short value) {
        this.calledFrom = value;
    }

    /**
     * Gets the value of the demandedObjects property.
     * 
     * @return
     *     possible object is
     *     {@link DemandedObjects }
     *     
     */
    public DemandedObjects getDemandedObjects() {
        return demandedObjects;
    }

    /**
     * Sets the value of the demandedObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link DemandedObjects }
     *     
     */
    public void setDemandedObjects(DemandedObjects value) {
        this.demandedObjects = value;
    }

    /**
     * Gets the value of the administration property.
     * 
     * @return
     *     possible object is
     *     {@link Administration }
     *     
     */
    public Administration getAdministration() {
        return administration;
    }

    /**
     * Sets the value of the administration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Administration }
     *     
     */
    public void setAdministration(Administration value) {
        this.administration = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the travel property.
     * 
     * @return
     *     possible object is
     *     {@link Travel }
     *     
     */
    public Travel getTravel() {
        return travel;
    }

    /**
     * Sets the value of the travel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Travel }
     *     
     */
    public void setTravel(Travel value) {
        this.travel = value;
    }

    /**
     * Gets the value of the car property.
     * 
     * @return
     *     possible object is
     *     {@link Car }
     *     
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the value of the car property.
     * 
     * @param value
     *     allowed object is
     *     {@link Car }
     *     
     */
    public void setCar(Car value) {
        this.car = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link Insurance }
     *     
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Insurance }
     *     
     */
    public void setInsurance(Insurance value) {
        this.insurance = value;
    }

    /**
     * Gets the value of the extras property.
     * 
     * @return
     *     possible object is
     *     {@link Extras }
     *     
     */
    public Extras getExtras() {
        return extras;
    }

    /**
     * Sets the value of the extras property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extras }
     *     
     */
    public void setExtras(Extras value) {
        this.extras = value;
    }

}