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
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}BookingId" minOccurs="0"/>
 *         &lt;element ref="{}PromoCode"/>
 *         &lt;element ref="{}Status"/>
 *         &lt;element ref="{}PickUpDate"/>
 *         &lt;element ref="{}DropOffDate"/>
 *         &lt;element ref="{}PickUpTime"/>
 *         &lt;element ref="{}DropOffTime"/>
 *         &lt;element ref="{}PickUpType"/>
 *         &lt;element ref="{}FlightNo" minOccurs="0"/>
 *         &lt;element ref="{}HotelName" minOccurs="0"/>
 *         &lt;element ref="{}HotelStreet" minOccurs="0"/>
 *         &lt;element ref="{}HotelCity" minOccurs="0"/>
 *         &lt;element ref="{}ServCatId"/>
 *         &lt;element ref="{}CountryId" minOccurs="0"/>
 *         &lt;element ref="{}CityId" minOccurs="0"/>
 *         &lt;element ref="{}PickUpStationId"/>
 *         &lt;element ref="{}DropOffStationId"/>
 *         &lt;element ref="{}PickUpSupplierId"/>
 *         &lt;element ref="{}DropOffSupplierId"/>
 *         &lt;element ref="{}DriverTitle" minOccurs="0"/>
 *         &lt;element ref="{}DriverSalutation" minOccurs="0"/>
 *         &lt;element ref="{}DriverName"/>
 *         &lt;element ref="{}DriverFirstName"/>
 *         &lt;element ref="{}DoBDriver" minOccurs="0"/>
 *         &lt;element ref="{}TotalPrice" minOccurs="0"/>
 *         &lt;element ref="{}RateQualifier" minOccurs="0"/>
 *         &lt;element ref="{}AdditionalDriver" minOccurs="0"/>
 *         &lt;element ref="{}DoBAddDriver" minOccurs="0"/>
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
@XmlRootElement(name = "Travel")
public class Travel {

    @XmlElement(name = "BookingId")
    protected String bookingId;
    @XmlElement(name = "PromoCode", required = true)
    protected String promoCode;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "PickUpDate", required = true)
    protected String pickUpDate;
    @XmlElement(name = "DropOffDate", required = true)
    protected String dropOffDate;
    @XmlElement(name = "PickUpTime", required = true)
    protected String pickUpTime;
    @XmlElement(name = "DropOffTime", required = true)
    protected String dropOffTime;
    @XmlElement(name = "PickUpType")
    protected short pickUpType;
    @XmlElement(name = "FlightNo")
    protected String flightNo;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelStreet")
    protected String hotelStreet;
    @XmlElement(name = "HotelCity")
    protected String hotelCity;
    @XmlElement(name = "ServCatId")
    protected long servCatId;
    @XmlElement(name = "CountryId")
    protected Long countryId;
    @XmlElement(name = "CityId")
    protected Long cityId;
    @XmlElement(name = "PickUpStationId")
    protected long pickUpStationId;
    @XmlElement(name = "DropOffStationId")
    protected long dropOffStationId;
    @XmlElement(name = "PickUpSupplierId")
    protected long pickUpSupplierId;
    @XmlElement(name = "DropOffSupplierId")
    protected long dropOffSupplierId;
    @XmlElement(name = "DriverTitle")
    protected String driverTitle;
    @XmlElement(name = "DriverSalutation")
    protected String driverSalutation;
    @XmlElement(name = "DriverName", required = true)
    protected String driverName;
    @XmlElement(name = "DriverFirstName", required = true)
    protected String driverFirstName;
    @XmlElement(name = "DoBDriver")
    protected XMLGregorianCalendar doBDriver;
    @XmlElement(name = "TotalPrice")
    protected String totalPrice;
    @XmlElement(name = "RateQualifier")
    protected String rateQualifier;
    @XmlElement(name = "AdditionalDriver")
    protected String additionalDriver;
    @XmlElement(name = "DoBAddDriver")
    protected XMLGregorianCalendar doBAddDriver;

    /**
     * Gets the value of the bookingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingId(String value) {
        this.bookingId = value;
    }

    /**
     * Gets the value of the promoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the value of the promoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCode(String value) {
        this.promoCode = value;
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
     * Gets the value of the pickUpDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpDate() {
        return pickUpDate;
    }

    /**
     * Sets the value of the pickUpDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpDate(String value) {
        this.pickUpDate = value;
    }

    /**
     * Gets the value of the dropOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffDate() {
        return dropOffDate;
    }

    /**
     * Sets the value of the dropOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffDate(String value) {
        this.dropOffDate = value;
    }

    /**
     * Gets the value of the pickUpTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpTime() {
        return pickUpTime;
    }

    /**
     * Sets the value of the pickUpTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpTime(String value) {
        this.pickUpTime = value;
    }

    /**
     * Gets the value of the dropOffTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffTime() {
        return dropOffTime;
    }

    /**
     * Sets the value of the dropOffTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffTime(String value) {
        this.dropOffTime = value;
    }

    /**
     * Gets the value of the pickUpType property.
     * 
     */
    public short getPickUpType() {
        return pickUpType;
    }

    /**
     * Sets the value of the pickUpType property.
     * 
     */
    public void setPickUpType(short value) {
        this.pickUpType = value;
    }

    /**
     * Gets the value of the flightNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * Sets the value of the flightNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNo(String value) {
        this.flightNo = value;
    }

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelStreet() {
        return hotelStreet;
    }

    /**
     * Sets the value of the hotelStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelStreet(String value) {
        this.hotelStreet = value;
    }

    /**
     * Gets the value of the hotelCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCity() {
        return hotelCity;
    }

    /**
     * Sets the value of the hotelCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCity(String value) {
        this.hotelCity = value;
    }

    /**
     * Gets the value of the servCatId property.
     * 
     */
    public long getServCatId() {
        return servCatId;
    }

    /**
     * Sets the value of the servCatId property.
     * 
     */
    public void setServCatId(long value) {
        this.servCatId = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCountryId(Long value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the cityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets the value of the cityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCityId(Long value) {
        this.cityId = value;
    }

    /**
     * Gets the value of the pickUpStationId property.
     * 
     */
    public long getPickUpStationId() {
        return pickUpStationId;
    }

    /**
     * Sets the value of the pickUpStationId property.
     * 
     */
    public void setPickUpStationId(long value) {
        this.pickUpStationId = value;
    }

    /**
     * Gets the value of the dropOffStationId property.
     * 
     */
    public long getDropOffStationId() {
        return dropOffStationId;
    }

    /**
     * Sets the value of the dropOffStationId property.
     * 
     */
    public void setDropOffStationId(long value) {
        this.dropOffStationId = value;
    }

    /**
     * Gets the value of the pickUpSupplierId property.
     * 
     */
    public long getPickUpSupplierId() {
        return pickUpSupplierId;
    }

    /**
     * Sets the value of the pickUpSupplierId property.
     * 
     */
    public void setPickUpSupplierId(long value) {
        this.pickUpSupplierId = value;
    }

    /**
     * Gets the value of the dropOffSupplierId property.
     * 
     */
    public long getDropOffSupplierId() {
        return dropOffSupplierId;
    }

    /**
     * Sets the value of the dropOffSupplierId property.
     * 
     */
    public void setDropOffSupplierId(long value) {
        this.dropOffSupplierId = value;
    }

    /**
     * Gets the value of the driverTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverTitle() {
        return driverTitle;
    }

    /**
     * Sets the value of the driverTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverTitle(String value) {
        this.driverTitle = value;
    }

    /**
     * Gets the value of the driverSalutation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverSalutation() {
        return driverSalutation;
    }

    /**
     * Sets the value of the driverSalutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverSalutation(String value) {
        this.driverSalutation = value;
    }

    /**
     * Gets the value of the driverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Sets the value of the driverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverName(String value) {
        this.driverName = value;
    }

    /**
     * Gets the value of the driverFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverFirstName() {
        return driverFirstName;
    }

    /**
     * Sets the value of the driverFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverFirstName(String value) {
        this.driverFirstName = value;
    }

    /**
     * Gets the value of the doBDriver property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDoBDriver() {
        return doBDriver;
    }

    /**
     * Sets the value of the doBDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDoBDriver(XMLGregorianCalendar value) {
        this.doBDriver = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPrice(String value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateQualifier() {
        return rateQualifier;
    }

    /**
     * Sets the value of the rateQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateQualifier(String value) {
        this.rateQualifier = value;
    }

    /**
     * Gets the value of the additionalDriver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalDriver() {
        return additionalDriver;
    }

    /**
     * Sets the value of the additionalDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalDriver(String value) {
        this.additionalDriver = value;
    }

    /**
     * Gets the value of the doBAddDriver property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDoBAddDriver() {
        return doBAddDriver;
    }

    /**
     * Sets the value of the doBAddDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDoBAddDriver(XMLGregorianCalendar value) {
        this.doBAddDriver = value;
    }

}
