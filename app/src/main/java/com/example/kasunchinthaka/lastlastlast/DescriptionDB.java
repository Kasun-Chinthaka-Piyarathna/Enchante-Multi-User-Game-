package com.example.kasunchinthaka.lastlastlast;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Kasun Chinthaka on 11/22/2016.
 */

public class DescriptionDB {

    LinkedList<Person> persons = new LinkedList<Person>();

    public DescriptionDB() {
        addPeople();
    }



    public Person getRandomPerson() {
        Random generator = new Random();
        return persons.get(generator.nextInt(persons.size()));
    }

    public void removePerson(Person p){
        persons.remove(p);
    }

    public void addPeople(){
        persons.add(new Person("Chinthaka", "Clue of Chinthaka"));
        persons.add(new Person("Tharindu", "Clue of tharindu"));
        persons.add(new Person("Dinusha", "Clue of Dinusha"));
        persons.add(new Person("Rakshitha", "Clue of Rakshitha"));
        persons.add(new Person("Nilantha", "Clue of Nilantha"));
        persons.add(new Person("Manoj", "Clue of Manoj"));
        persons.add(new Person("Randima", "Clue of Randima"));
        persons.add(new Person("Tharindi", "Clue of Tharindi"));
        persons.add(new Person("Uvindi", "Clue of Uvindi"));
        persons.add(new Person("Sachini", "Clue of Sachini"));

    }

   /* public static void main(String [] args){
        DescriptionDB db = new DescriptionDB();
        Person p = db.getRandomPerson();
        // System.out.println(p.toString());
        System.out.println(p.getName());
        System.out.println(p.getDescription());


        System.out.println(db.persons.toString());

        db.removePerson(p);
        System.out.println(db.persons.toString());

        p = db.getRandomPerson();

        //System.out.println(p.toString());
        System.out.println(p.getName());
        System.out.println(p.getDescription());

        db.removePerson(p);

        System.out.println(db.persons.toString());

    }*/
}
