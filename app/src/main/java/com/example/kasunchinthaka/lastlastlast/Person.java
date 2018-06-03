package com.example.kasunchinthaka.lastlastlast;

/**
 * Created by Kasun Chinthaka on 11/22/2016.
 */

public class Person {
    private String name;
    private String description;

    public Person(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public boolean equals(Object o){
        if(o instanceof Person){
            Person p = (Person)o;
            if(p.description == this.description && p.name == this.name)
                return true;
            else
                return false;
        }else
            return false;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name + "  " + description;
    }
}
