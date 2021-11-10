package org.serratec.backend.trabalhofinalapi.exception;

import java.lang.Exception;

@SuppressWarnings("serial")
public class EnumValidationException extends Exception{
	
	private Integer enumValue = null;
	private String enumName = null;

	public Integer getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(Integer enumValue) {
		this.enumValue = enumValue;
	}

	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public EnumValidationException(Integer enumValue, String enumName) {

		this.enumValue = enumValue;
		this.enumName = enumName;
	}

	public EnumValidationException(Integer enumValue, String enumName, Throwable cause) {

		this.enumValue = enumValue;
		this.enumName = enumName;
	}

	public EnumValidationException(String string) {
		// TODO Auto-generated constructor stub
	}
}

