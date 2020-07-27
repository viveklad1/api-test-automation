package com.api.test.automation.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String firstName;
    private String lastName;
    @JsonProperty("class")
    private String division;
    private String nationality;
    public boolean checkLogicalEquals(Student student){
        if(!getFirstName().equals(student.getFirstName()))
            return false;
        else if(!getLastName().equals(student.getLastName()))
            return false;
        else if(!getDivision().equals(student.getDivision()))
            return false;
        else if(!getNationality().equals(student.getNationality()))
            return false;
        return true;
    }
}
