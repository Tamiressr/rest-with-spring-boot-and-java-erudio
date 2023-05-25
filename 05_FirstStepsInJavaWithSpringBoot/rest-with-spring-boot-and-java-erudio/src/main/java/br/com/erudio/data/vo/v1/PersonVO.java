package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "first_name", "last_name", "gender", "address" })
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
	private static final long serialversionUID = 1L;
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;

	private String address;

	private String gender;

	public PersonVO() {

	}

	public PersonVO(Long id, String firstName, String lastName, String address, String gender) {
		this.key = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Long getKey() {
		return key;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PersonVO person = (PersonVO) o;
		return Objects.equals(key, person.key) && Objects.equals(firstName, person.firstName)
				&& Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address)
				&& Objects.equals(gender, person.gender);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, firstName, lastName, address, gender);
	}
}
