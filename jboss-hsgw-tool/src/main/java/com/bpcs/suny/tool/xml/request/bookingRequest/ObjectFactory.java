//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.01 at 05:06:49 PM CET 
//


package com.bpcs.suny.tool.xml.request.bookingRequest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bpcs.suny.tool.xml.request.bookingRequest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BrokerId_QNAME = new QName("", "BrokerId");
    private final static QName _BrokerSubExtRef_QNAME = new QName("", "BrokerSubExtRef");
    private final static QName _FaxCountry_QNAME = new QName("", "FaxCountry");
    private final static QName _PickUpDate_QNAME = new QName("", "PickUpDate");
    private final static QName _DropOffSupplierId_QNAME = new QName("", "DropOffSupplierId");
    private final static QName _DriverSalutation_QNAME = new QName("", "DriverSalutation");
    private final static QName _LowerPrice_QNAME = new QName("", "LowerPrice");
    private final static QName _Holder_QNAME = new QName("", "Holder");
    private final static QName _FaxArea_QNAME = new QName("", "FaxArea");
    private final static QName _MarkUpRel_QNAME = new QName("", "MarkUpRel");
    private final static QName _FlightNo_QNAME = new QName("", "FlightNo");
    private final static QName _Currency_QNAME = new QName("", "Currency");
    private final static QName _UserType_QNAME = new QName("", "UserType");
    private final static QName _CustomerType_QNAME = new QName("", "CustomerType");
    private final static QName _Amount_QNAME = new QName("", "Amount");
    private final static QName _BookingId_QNAME = new QName("", "BookingId");
    private final static QName _GroupName_QNAME = new QName("", "GroupName");
    private final static QName _DriverTitle_QNAME = new QName("", "DriverTitle");
    private final static QName _Number_QNAME = new QName("", "Number");
    private final static QName _CalledFrom_QNAME = new QName("", "CalledFrom");
    private final static QName _PhoneArea_QNAME = new QName("", "PhoneArea");
    private final static QName _DemandedObject_QNAME = new QName("", "DemandedObject");
    private final static QName _LogIn_QNAME = new QName("", "LogIn");
    private final static QName _PartnerNo_QNAME = new QName("", "PartnerNo");
    private final static QName _PhoneExt_QNAME = new QName("", "PhoneExt");
    private final static QName _LanguageId_QNAME = new QName("", "LanguageId");
    private final static QName _DropOffHotelName_QNAME = new QName("", "DropOffHotelName");
    private final static QName _DateOfBirth_QNAME = new QName("", "DateOfBirth");
    private final static QName _Active_QNAME = new QName("", "Active");
    private final static QName _DoBDriver_QNAME = new QName("", "DoBDriver");
    private final static QName _Price_QNAME = new QName("", "Price");
    private final static QName _CountryId_QNAME = new QName("", "CountryId");
    private final static QName _Id_QNAME = new QName("", "Id");
    private final static QName _HotelCity_QNAME = new QName("", "HotelCity");
    private final static QName _DocChannel_QNAME = new QName("", "DocChannel");
    private final static QName _Provider_QNAME = new QName("", "Provider");
    private final static QName _Street_QNAME = new QName("", "Street");
    private final static QName _CityId_QNAME = new QName("", "CityId");
    private final static QName _EMail_QNAME = new QName("", "EMail");
    private final static QName _Type_QNAME = new QName("", "Type");
    private final static QName _CurrencyId_QNAME = new QName("", "CurrencyId");
    private final static QName _Password_QNAME = new QName("", "Password");
    private final static QName _TotalPrice_QNAME = new QName("", "TotalPrice");
    private final static QName _RateQualifier_QNAME = new QName("", "RateQualifier");
    private final static QName _CustomerNo_QNAME = new QName("", "CustomerNo");
    private final static QName _DropOffHotelStreet_QNAME = new QName("", "DropOffHotelStreet");
    private final static QName _GroupId_QNAME = new QName("", "GroupId");
    private final static QName _Code_QNAME = new QName("", "Code");
    private final static QName _PickUpType_QNAME = new QName("", "PickUpType");
    private final static QName _ServCatId_QNAME = new QName("", "ServCatId");
    private final static QName _CVC_QNAME = new QName("", "CVC");
    private final static QName _SalutationId_QNAME = new QName("", "SalutationId");
    private final static QName _DoBAddDriver_QNAME = new QName("", "DoBAddDriver");
    private final static QName _PhoneCountry_QNAME = new QName("", "PhoneCountry");
    private final static QName _DropOffHotelCity_QNAME = new QName("", "DropOffHotelCity");
    private final static QName _FirstName_QNAME = new QName("", "FirstName");
    private final static QName _Producer_QNAME = new QName("", "Producer");
    private final static QName _DriverFirstName_QNAME = new QName("", "DriverFirstName");
    private final static QName _OperatorId_QNAME = new QName("", "OperatorId");
    private final static QName _AdditionalDriver_QNAME = new QName("", "AdditionalDriver");
    private final static QName _DropOffTime_QNAME = new QName("", "DropOffTime");
    private final static QName _HotelName_QNAME = new QName("", "HotelName");
    private final static QName _PickUpSupplierId_QNAME = new QName("", "PickUpSupplierId");
    private final static QName _Flag_QNAME = new QName("", "Flag");
    private final static QName _FaxExt_QNAME = new QName("", "FaxExt");
    private final static QName _DriverName_QNAME = new QName("", "DriverName");
    private final static QName _PromoCode_QNAME = new QName("", "PromoCode");
    private final static QName _Dim2_QNAME = new QName("", "Dim2");
    private final static QName _UpperPrice_QNAME = new QName("", "UpperPrice");
    private final static QName _Dim1_QNAME = new QName("", "Dim1");
    private final static QName _DropOffDate_QNAME = new QName("", "DropOffDate");
    private final static QName _ZipCode_QNAME = new QName("", "ZipCode");
    private final static QName _City_QNAME = new QName("", "City");
    private final static QName _Name_QNAME = new QName("", "Name");
    private final static QName _Status_QNAME = new QName("", "Status");
    private final static QName _PickUpTime_QNAME = new QName("", "PickUpTime");
    private final static QName _ValidUntil_QNAME = new QName("", "ValidUntil");
    private final static QName _DropOffStationId_QNAME = new QName("", "DropOffStationId");
    private final static QName _BrokerNo_QNAME = new QName("", "BrokerNo");
    private final static QName _Info_QNAME = new QName("", "Info");
    private final static QName _PickUpStationId_QNAME = new QName("", "PickUpStationId");
    private final static QName _AgencyId_QNAME = new QName("", "AgencyId");
    private final static QName _HotelStreet_QNAME = new QName("", "HotelStreet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bpcs.suny.tool.xml.request.bookingRequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Extra }
     * 
     */
    public Extra createExtra() {
        return new Extra();
    }

    /**
     * Create an instance of {@link ErrorFormat }
     * 
     */
    public ErrorFormat createErrorFormat() {
        return new ErrorFormat();
    }

    /**
     * Create an instance of {@link BonusCard }
     * 
     */
    public BonusCard createBonusCard() {
        return new BonusCard();
    }

    /**
     * Create an instance of {@link Travel }
     * 
     */
    public Travel createTravel() {
        return new Travel();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link DemandedObjects }
     * 
     */
    public DemandedObjects createDemandedObjects() {
        return new DemandedObjects();
    }

    /**
     * Create an instance of {@link Administration }
     * 
     */
    public Administration createAdministration() {
        return new Administration();
    }

    /**
     * Create an instance of {@link OutputConfiguration }
     * 
     */
    public OutputConfiguration createOutputConfiguration() {
        return new OutputConfiguration();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link Insurance }
     * 
     */
    public Insurance createInsurance() {
        return new Insurance();
    }

    /**
     * Create an instance of {@link Extras }
     * 
     */
    public Extras createExtras() {
        return new Extras();
    }

    /**
     * Create an instance of {@link RequestorRequestContent }
     * 
     */
    public RequestorRequestContent createRequestorRequestContent() {
        return new RequestorRequestContent();
    }

    /**
     * Create an instance of {@link RequestorRequest }
     * 
     */
    public RequestorRequest createRequestorRequest() {
        return new RequestorRequest();
    }

    /**
     * Create an instance of {@link RequestorName }
     * 
     */
    public RequestorName createRequestorName() {
        return new RequestorName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BrokerId")
    public JAXBElement<Long> createBrokerId(Long value) {
        return new JAXBElement<Long>(_BrokerId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BrokerSubExtRef")
    public JAXBElement<String> createBrokerSubExtRef(String value) {
        return new JAXBElement<String>(_BrokerSubExtRef_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FaxCountry")
    public JAXBElement<String> createFaxCountry(String value) {
        return new JAXBElement<String>(_FaxCountry_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PickUpDate")
    public JAXBElement<String> createPickUpDate(String value) {
        return new JAXBElement<String>(_PickUpDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffSupplierId")
    public JAXBElement<Long> createDropOffSupplierId(Long value) {
        return new JAXBElement<Long>(_DropOffSupplierId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DriverSalutation")
    public JAXBElement<String> createDriverSalutation(String value) {
        return new JAXBElement<String>(_DriverSalutation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LowerPrice")
    public JAXBElement<String> createLowerPrice(String value) {
        return new JAXBElement<String>(_LowerPrice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Holder")
    public JAXBElement<String> createHolder(String value) {
        return new JAXBElement<String>(_Holder_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FaxArea")
    public JAXBElement<String> createFaxArea(String value) {
        return new JAXBElement<String>(_FaxArea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MarkUpRel")
    public JAXBElement<String> createMarkUpRel(String value) {
        return new JAXBElement<String>(_MarkUpRel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FlightNo")
    public JAXBElement<String> createFlightNo(String value) {
        return new JAXBElement<String>(_FlightNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Currency")
    public JAXBElement<String> createCurrency(String value) {
        return new JAXBElement<String>(_Currency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UserType")
    public JAXBElement<String> createUserType(String value) {
        return new JAXBElement<String>(_UserType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CustomerType")
    public JAXBElement<Short> createCustomerType(Short value) {
        return new JAXBElement<Short>(_CustomerType_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Amount")
    public JAXBElement<Short> createAmount(Short value) {
        return new JAXBElement<Short>(_Amount_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BookingId")
    public JAXBElement<String> createBookingId(String value) {
        return new JAXBElement<String>(_BookingId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GroupName")
    public JAXBElement<String> createGroupName(String value) {
        return new JAXBElement<String>(_GroupName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DriverTitle")
    public JAXBElement<String> createDriverTitle(String value) {
        return new JAXBElement<String>(_DriverTitle_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Number")
    public JAXBElement<String> createNumber(String value) {
        return new JAXBElement<String>(_Number_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CalledFrom")
    public JAXBElement<Short> createCalledFrom(Short value) {
        return new JAXBElement<Short>(_CalledFrom_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PhoneArea")
    public JAXBElement<String> createPhoneArea(String value) {
        return new JAXBElement<String>(_PhoneArea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DemandedObject")
    public JAXBElement<Short> createDemandedObject(Short value) {
        return new JAXBElement<Short>(_DemandedObject_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LogIn")
    public JAXBElement<String> createLogIn(String value) {
        return new JAXBElement<String>(_LogIn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PartnerNo")
    public JAXBElement<String> createPartnerNo(String value) {
        return new JAXBElement<String>(_PartnerNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PhoneExt")
    public JAXBElement<String> createPhoneExt(String value) {
        return new JAXBElement<String>(_PhoneExt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LanguageId")
    public JAXBElement<String> createLanguageId(String value) {
        return new JAXBElement<String>(_LanguageId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffHotelName")
    public JAXBElement<String> createDropOffHotelName(String value) {
        return new JAXBElement<String>(_DropOffHotelName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DateOfBirth")
    public JAXBElement<XMLGregorianCalendar> createDateOfBirth(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateOfBirth_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Active")
    public JAXBElement<String> createActive(String value) {
        return new JAXBElement<String>(_Active_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DoBDriver")
    public JAXBElement<XMLGregorianCalendar> createDoBDriver(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DoBDriver_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Price")
    public JAXBElement<String> createPrice(String value) {
        return new JAXBElement<String>(_Price_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CountryId")
    public JAXBElement<Long> createCountryId(Long value) {
        return new JAXBElement<Long>(_CountryId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Id")
    public JAXBElement<Long> createId(Long value) {
        return new JAXBElement<Long>(_Id_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HotelCity")
    public JAXBElement<String> createHotelCity(String value) {
        return new JAXBElement<String>(_HotelCity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DocChannel")
    public JAXBElement<String> createDocChannel(String value) {
        return new JAXBElement<String>(_DocChannel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Provider")
    public JAXBElement<String> createProvider(String value) {
        return new JAXBElement<String>(_Provider_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Street")
    public JAXBElement<String> createStreet(String value) {
        return new JAXBElement<String>(_Street_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CityId")
    public JAXBElement<Long> createCityId(Long value) {
        return new JAXBElement<Long>(_CityId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EMail")
    public JAXBElement<String> createEMail(String value) {
        return new JAXBElement<String>(_EMail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CurrencyId")
    public JAXBElement<Long> createCurrencyId(Long value) {
        return new JAXBElement<Long>(_CurrencyId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TotalPrice")
    public JAXBElement<String> createTotalPrice(String value) {
        return new JAXBElement<String>(_TotalPrice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RateQualifier")
    public JAXBElement<String> createRateQualifier(String value) {
        return new JAXBElement<String>(_RateQualifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CustomerNo")
    public JAXBElement<String> createCustomerNo(String value) {
        return new JAXBElement<String>(_CustomerNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffHotelStreet")
    public JAXBElement<String> createDropOffHotelStreet(String value) {
        return new JAXBElement<String>(_DropOffHotelStreet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GroupId")
    public JAXBElement<Long> createGroupId(Long value) {
        return new JAXBElement<Long>(_GroupId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PickUpType")
    public JAXBElement<Short> createPickUpType(Short value) {
        return new JAXBElement<Short>(_PickUpType_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServCatId")
    public JAXBElement<Long> createServCatId(Long value) {
        return new JAXBElement<Long>(_ServCatId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CVC")
    public JAXBElement<String> createCVC(String value) {
        return new JAXBElement<String>(_CVC_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SalutationId")
    public JAXBElement<String> createSalutationId(String value) {
        return new JAXBElement<String>(_SalutationId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DoBAddDriver")
    public JAXBElement<XMLGregorianCalendar> createDoBAddDriver(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DoBAddDriver_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PhoneCountry")
    public JAXBElement<String> createPhoneCountry(String value) {
        return new JAXBElement<String>(_PhoneCountry_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffHotelCity")
    public JAXBElement<String> createDropOffHotelCity(String value) {
        return new JAXBElement<String>(_DropOffHotelCity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FirstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Producer")
    public JAXBElement<String> createProducer(String value) {
        return new JAXBElement<String>(_Producer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DriverFirstName")
    public JAXBElement<String> createDriverFirstName(String value) {
        return new JAXBElement<String>(_DriverFirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OperatorId")
    public JAXBElement<Long> createOperatorId(Long value) {
        return new JAXBElement<Long>(_OperatorId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AdditionalDriver")
    public JAXBElement<String> createAdditionalDriver(String value) {
        return new JAXBElement<String>(_AdditionalDriver_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffTime")
    public JAXBElement<String> createDropOffTime(String value) {
        return new JAXBElement<String>(_DropOffTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HotelName")
    public JAXBElement<String> createHotelName(String value) {
        return new JAXBElement<String>(_HotelName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PickUpSupplierId")
    public JAXBElement<Long> createPickUpSupplierId(Long value) {
        return new JAXBElement<Long>(_PickUpSupplierId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Flag")
    public JAXBElement<String> createFlag(String value) {
        return new JAXBElement<String>(_Flag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FaxExt")
    public JAXBElement<String> createFaxExt(String value) {
        return new JAXBElement<String>(_FaxExt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DriverName")
    public JAXBElement<String> createDriverName(String value) {
        return new JAXBElement<String>(_DriverName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PromoCode")
    public JAXBElement<String> createPromoCode(String value) {
        return new JAXBElement<String>(_PromoCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Dim2")
    public JAXBElement<String> createDim2(String value) {
        return new JAXBElement<String>(_Dim2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UpperPrice")
    public JAXBElement<String> createUpperPrice(String value) {
        return new JAXBElement<String>(_UpperPrice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Dim1")
    public JAXBElement<String> createDim1(String value) {
        return new JAXBElement<String>(_Dim1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffDate")
    public JAXBElement<String> createDropOffDate(String value) {
        return new JAXBElement<String>(_DropOffDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ZipCode")
    public JAXBElement<String> createZipCode(String value) {
        return new JAXBElement<String>(_ZipCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "City")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PickUpTime")
    public JAXBElement<String> createPickUpTime(String value) {
        return new JAXBElement<String>(_PickUpTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ValidUntil")
    public JAXBElement<String> createValidUntil(String value) {
        return new JAXBElement<String>(_ValidUntil_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DropOffStationId")
    public JAXBElement<Long> createDropOffStationId(Long value) {
        return new JAXBElement<Long>(_DropOffStationId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BrokerNo")
    public JAXBElement<String> createBrokerNo(String value) {
        return new JAXBElement<String>(_BrokerNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Info")
    public JAXBElement<String> createInfo(String value) {
        return new JAXBElement<String>(_Info_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PickUpStationId")
    public JAXBElement<Long> createPickUpStationId(Long value) {
        return new JAXBElement<Long>(_PickUpStationId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AgencyId")
    public JAXBElement<Long> createAgencyId(Long value) {
        return new JAXBElement<Long>(_AgencyId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HotelStreet")
    public JAXBElement<String> createHotelStreet(String value) {
        return new JAXBElement<String>(_HotelStreet_QNAME, String.class, null, value);
    }

}
