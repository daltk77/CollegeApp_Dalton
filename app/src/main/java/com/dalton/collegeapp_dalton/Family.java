package com.dalton.collegeapp_dalton;

import java.util.ArrayList;

public class Family {

    private final String TAG = Family.class.getName();

    private ArrayList<FamilyMember> family;

    private static Family sFamily;

    private Family(){
        family = new ArrayList<>();
        Guardian Guardian1 = new Guardian("Bob", "Saget");
        Guardian mom = new Guardian("my","mother");
        family.add(Guardian1);
    }
    public static Family getFamily(){
        if (sFamily == null){
            sFamily = new Family();
        }
        return sFamily;
    }
    public ArrayList<FamilyMember> getFamilyList(){
        return family;
    }

    public void setFamily(ArrayList<FamilyMember> family){
        this.family = family;
    }
}
