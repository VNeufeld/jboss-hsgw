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
 *         &lt;element ref="{}DemandedObject"/>
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
    "demandedObject"
})
@XmlRootElement(name = "DemandedObjects")
public class DemandedObjects {

    @XmlElement(name = "DemandedObject")
    protected short demandedObject;

    /**
     * Gets the value of the demandedObject property.
     * 
     */
    public short getDemandedObject() {
        return demandedObject;
    }

    /**
     * Sets the value of the demandedObject property.
     * 
     */
    public void setDemandedObject(short value) {
        this.demandedObject = value;
    }

}
