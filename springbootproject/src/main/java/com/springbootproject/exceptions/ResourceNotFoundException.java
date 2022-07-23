package com.springbootproject.exceptions;


public class ResourceNotFoundException  extends RuntimeException{
String resourceName;
String fieldName;
int fieldValue ;
public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
	//String-format method use
	super(String.format("%s not found with %s : %1", resourceName,fieldName,fieldName));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;

}
public String getResourceName() {
	return resourceName;
}
public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public long getFieldValue() {
	return fieldValue;
}
public void setFieldValue(int fieldValue) {
	this.fieldValue = fieldValue;
}

}
