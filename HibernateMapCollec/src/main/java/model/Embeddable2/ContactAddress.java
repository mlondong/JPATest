package model.Embeddable2;

import javax.persistence.*;

@Embeddable
public class ContactAddress {
		
		@Column(name="STREET")
		private String streetAddress;
		
		@Column(name="STATE")
		private String state;
		
		@Column(name="CITY")
		private String city;
		
		@Column(name="ZIP_CODE")
		private String areaCode;
		
		@Column(name="ADDR_TYPE")
		private String addressType;


		
		
		public String getStreetAddress() {
			return streetAddress;
		}

		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}

		public String getAddressType() {
			return addressType;
		}

		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		

}
