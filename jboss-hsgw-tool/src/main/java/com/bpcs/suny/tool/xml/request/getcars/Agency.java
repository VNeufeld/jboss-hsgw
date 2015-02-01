package com.bpcs.suny.tool.xml.request.getcars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Agency")
public class Agency {
    @XmlElement(name = "TerminalId", namespace = "common")
    protected String terminalId;
    @XmlElement(name = "AgencyNo", namespace = "common")
    protected String agencyNo;
    @XmlElement(name = "AgencyId", namespace = "common")
    protected Integer agencyId;
    @XmlElement(name = "TravelAgentBooking", namespace = "common")
    protected Integer travelAgentBooking;

    public Integer getTravelAgentBooking() {
        return travelAgentBooking;
    }

    public void setTravelAgentBooking(Integer value) {
        this.travelAgentBooking = value;
    }

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getAgencyNo() {
		return agencyNo;
	}

	public void setAgencyNo(String agencyNo) {
		this.agencyNo = agencyNo;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}


}
