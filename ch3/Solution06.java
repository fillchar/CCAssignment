package ch3;

import java.util.LinkedList;

/**
 * Created by thushy on 2015/9/21.
 */
public class Solution06 {

    private static final String DOG = "dog";
    private static final String CAT = "cat";

    int id = 0;

    class Animal {
        int time;
        String category;
        public Animal(int time, String category) {
            this.time = time;
            this.category = category;
        }
    }

    LinkedList<Animal> cat = new LinkedList<>(), dog = new LinkedList<>();

    public void enqueue(String category) {
        if (category.equals(DOG)) dog.add(new Animal(id++, DOG));
        if (category.equals(CAT)) cat.add(new Animal(id++, CAT));
    }

    public Animal dequeueAny() throws Exception {
        if (dog.isEmpty() && cat.isEmpty()) throw new Exception("There is no animal!");
        if (dog.isEmpty()) return cat.removeFirst();
        if (cat.isEmpty()) return dog.removeFirst();
        if (cat.getFirst().time < dog.getFirst().time) return cat.removeFirst();
        return dog.removeFirst();
    }

    public Animal dequeueDog() throws Exception {
        if (dog.isEmpty()) throw new Exception("There is no dog!");
        return dog.removeFirst();
    }

    public Animal dequeueCat() throws Exception {
        if (cat.isEmpty()) throw new Exception("There is no cat!");
        return cat.removeFirst();
    }


}
