package demo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(using = BrokerDeserializer.class)
@Entity
@Table(name = "broker", schema="web_iws")
public class Broker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String SFID = "SFID";
	public static final String ACTION = "action";
	public static final String BIRTHDATE = "birthdate";
	public static final String ACCOUNT_NAME = "accountName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String TITLE = "title";
	public static final String SSN = "ssn"; 
	public static final String PHONE = "phone";
	public static final String MOBILE_PHONE = "mobile_phone";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String MAILING_STREET = "mailingStreet";
	public static final String MAILING_CITY = "mailingCity";
	public static final String MAILING_STATE = "mailingState";
	public static final String MAILING_POSTAL_CODE = "mailingPostalCode";
	public static final String MAILING_COUNTRY = "mailingCountry";
	public static final String BROKER_NUMBER = "brokerNumber";
	public static final String NPN = "npn";
	public static final String GA = "ga";
	public static final String GA_NUMBER = "gaNumber";
	public static final String STATUS = "status";
	public static final String LEGAL_ENTITY = "legalEntity";
	


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "web_iws.broker_id_seq")
	@SequenceGenerator(name = "web_iws.broker_id_seq", sequenceName = "web_iws.broker_id_seq", allocationSize=1)
	@Column(name = "id", unique=true, nullable = false)
	private Long id;
	
	@Transient
	private String action;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "first_name")
	private String firstName;	

	@Column(name = "last_name")
	private String lastName;		

	@Column(name = "title")
	private String title;
	
	@Column(name = "ssn")
	private String ssn;	
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "mobile_phone")
	private String mobile_phone;
	
	@Column(name = "fax")
	private String fax;		
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mailing_street")
	private String mailingStreet;
	
	@Column(name = "mailing_city")
	private String mailingCity;
	
	@Column(name = "mailing_state")
	private String mailingState;
	
	@Column(name = "mailing_postal_code")
	private String mailingPostalCode;
	
	@Column(name = "mailing_country")
	private String mailingCountry;
	
	@Column(name = "broker_number")
	private String brokerNumber;
	
	@Column(name = "npn")
	private String npn;
	
	@Column(name = "ga")
	private String ga;
	
	@Column(name = "ga_number")
	private String gaNumber;
	
	@Column(name = "birthdate")
	private Date birthdate;
	
	@Column(name = "appointed")
	private String status;
	
	@Column(name = "indor_corp")
	private String legalEntity;
	
	@Column(name ="sfid")
	private String saleforceId;
	
	@Column(name = "deleted")
	private Boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailingStreet() {
		return mailingStreet;
	}

	public void setMailingStreet(String mailingStreet) {
		this.mailingStreet = mailingStreet;
	}

	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public String getMailingPostalCode() {
		return mailingPostalCode;
	}

	public void setMailingPostalCode(String mailingPostalCode) {
		this.mailingPostalCode = mailingPostalCode;
	}

	public String getMailingCountry() {
		return mailingCountry;
	}

	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}

	public String getBrokerNumber() {
		return brokerNumber;
	}

	public void setBrokerNumber(String brokerNumber) {
		this.brokerNumber = brokerNumber;
	}

	public String getNpn() {
		return npn;
	}

	public void setNpn(String npn) {
		this.npn = npn;
	}

	public String getGa() {
		return ga;
	}

	public void setGa(String ga) {
		this.ga = ga;
	}

	public String getGaNumber() {
		return gaNumber;
	}

	public void setGaNumber(String gaNumber) {
		this.gaNumber = gaNumber;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getSaleforceId() {
		return saleforceId;
	}

	public void setSaleforceId(String saleforceId) {
		this.saleforceId = saleforceId;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
}
