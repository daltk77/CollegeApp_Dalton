package com.dalton.collegeapp_dalton;

public abstract class FamilyMember {


    String mfirstName;
    String lastName;

    public String getMfirstName() {
        return mfirstName;
    }

    public void setMfirstName(String mfirstName) {
        this.mfirstName = mfirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FamilyMember() {
        mfirstName = "Family";
        lastName = "Member";
    }
    public FamilyMember(String firstName, String lastName){
       mfirstName = firstName;
       this.lastName = lastName;
    }
}
