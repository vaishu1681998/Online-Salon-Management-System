package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto model information")
public class UserDto {

	@Schema(description = "Unique identifier of the user", example = "1")
	private Long id;

	@Schema(description = "Name of the user", example = "John Doe")
	private String name;

	@Schema(description = "Email address of the user", example = "john.doe@example.com")
	private String email;

	@Schema(description = "Mobile number of the user", example = "+1234567890")
	private String mobileNo;
	
	@Schema(description = "Password of the user", example = "123456789")
	private String password;

	@Schema(description = "Sex of the user", example = "Male")
	private String sex;

	@Schema(description = "Role assigned to the user", example = "ADMIN")
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
