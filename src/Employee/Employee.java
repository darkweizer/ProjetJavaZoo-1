package Employee;

import Paddock.Paddock;
import Species.Animal;

/**
 * Employee est la classe représentant l'employé (unique) de l'application.
 * Son unicité fait d'elle un singleton.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Employee {

    private String name;
    private boolean sex;
    private int age;

    private Employee(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private static Employee INSTANCE = new Employee("Gerard",true,58);

    public static Employee getINSTANCE() {
        return INSTANCE;
    }

    public String examine(Paddock paddock){
        return paddock.toString();
    }

    public void keeUp(Paddock paddock){
        paddock.keepUp();
    }

    public void restockFood(Paddock paddock, int food){
        paddock.restockFood(food);
    }

    public void moveAnimal(Paddock paddockOut, Animal animal){
        paddockOut.move(animal);
    }
}
