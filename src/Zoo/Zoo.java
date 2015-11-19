package Zoo;

import Animals.Bear;
import Animals.Tiger;
import Animals.Whale;
import Animals.Wolf;
import Employee.Employee;
import java.util.ArrayList;
import java.util.Scanner;

import Paddock.Paddock;
import Paddock.Aquarium;
import Paddock.Aviary;
import Species.Animal;
import Tools.Tools;

import javax.tools.Tool;

/**
 * Created by Darkweizer on 15/11/2015.
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int maxNbPaddock;
    private static ArrayList<Paddock> listPaddock = new ArrayList<>();
    private static ArrayList<ArrayList<Animal>> totalAnimal = new ArrayList<>();

    private Zoo(String name, Employee employee, int maxNbPaddock) {
        this.name = name;
        this.employee = employee;
        this.maxNbPaddock = maxNbPaddock;
    }

    private static Zoo INSTANCE = new Zoo("Ho Land", Employee.getINSTANCE(), 10);

    public static Zoo getINSTANCE() {
        return INSTANCE;
    }

    public static ArrayList<Paddock> getListPaddock() {
        return listPaddock;
    }

    public static ArrayList<ArrayList<Animal>> getTotalAnimal() {
        return totalAnimal;
    }

    public void showNbTotalAnimal(){
        int cpt = 0;
        for(ArrayList<Animal> a : totalAnimal){
            for(Animal a1 : a){
                ++cpt;
            }
        }
        System.out.println("Le nombre d'animal présent dans le zoo est de " + cpt);
    }

    public void showTotalAnimal(){
        int cpt = 0;
        for(ArrayList<Animal> a : totalAnimal){
            for(Animal a1 : a){
                System.out.print(a1.getName() + " ");
                ++cpt;
                if (cpt == 10){
                    cpt = 0;
                    System.out.println("");
                }
            }
        }
    }

    public void showAllPaddock(){
        for(Paddock p : listPaddock){
            System.out.println(p.toString());
        }
    }

    public void run() {

/*      Wolf loupGoerges = new Wolf("wolf1",true, 30000, 160, 5);

        Wolf loupMelissa = new Wolf("wolf2",false, 32767, 165, 4);
        Wolf loupKenny = new Wolf("wolf3",true, 30000, 155, 6);
        Wolf loupLynda = new Wolf("wolf4",false, 30000, 155, 6);
        loupGoerges.setNbWolf(4);

        Paddock paddock1 = new Paddock("paddock1", 32, 8, "bon");
        Paddock paddock2 = new Paddock("paddock2", 32, 8, "bon");

        paddock1.add(loupMelissa);
        paddock1.add(loupLynda);
        paddock1.add(loupGoerges);
        paddock1.add(loupKenny);

        loupGoerges.reproduction(loupMelissa);
        loupLynda.reproduction(loupKenny);
        System.out.println(paddock1.toString());


        Eagle eagle1 = new Eagle("eagle1",true,12,12,2);
        Aviary aviary1 = new Aviary("aviary1",32,8,0,"bon",60);

        aviary1.add(eagle1);
        aviary1.add(loupGoerges);

        paddock1.add(loupGoerges);
        paddock1.add(eagle1);

        paddock1.move(eagle1);

        System.out.println(aviary1.toString());
        System.out.println(paddock1.toString());
*/

        Scanner scannerChoiceAction = new Scanner(System.in);
        Scanner scannerChoiceAnimal = new Scanner(System.in);
        Scanner scannerChoicePaddock = new Scanner(System.in);
        boolean isPaddockFill = false;
        boolean isPaddockCreated = false;
        boolean isAnimalCreated = false;

        while (true) {
            if(isPaddockCreated && !isAnimalCreated)
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\t2: Créer un animal\n" +
                                    "\tq: QUITTER\n" +
                                    "\nChoix : ");
            else if(isAnimalCreated)
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                        "\t1: Créer un enclos\n" +
                        "\t2: Créer un animal\n" +
                        "\t3: Gérer le zoo en tant qu'employé\n" +
                        "\tq: QUITTER\n" +
                        "\nChoix : ");
            else
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\tq: QUITTER\n" +
                                    "\nChoix : ");

            String choiceAction = scannerChoiceAction.next();
            choiceAction = choiceAction.toLowerCase();
            switch (choiceAction) {
                case "1":
                    System.out.print("\nQuel type d'enclos voulez-vous créer ?\n" +
                            "\t1: Enclos (classique)\n" +
                            "\t2: Aquarium\n" +
                            "\t3: Volière\n" +
                            "\tq: QUITTER\n" +
                            "\nChoix : ");

                    String choicePaddock = scannerChoicePaddock.next();
                    choicePaddock = choicePaddock.toLowerCase();
                    switch (choicePaddock) {
                        case "1":case "enclos":
                            Paddock paddock = new Paddock("paddock"+(Paddock.getNbPaddock()+1), Tools.random(40, 500),Tools.random(3,20),"bon");
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos classique !"));
                            this.showAllPaddock();
                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cet enclos, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Loup\n" +
                                        "\t2: Ours\n" +
                                        "\t3: Tigre\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "loup":
                                        do {
                                            Wolf wolf = new Wolf("wolf"+(Wolf.getNbWolf()+1),(Tools.random(0,2) != 0), Tools.random(25,50), Tools.random(80, 120), Tools.random(2,15));
                                            Wolf.setNbWolf(Wolf.getNbWolf() + 1);
                                            paddock.add(wolf);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un loup !"));
                                            wolf.toString();
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "2":case "ours":
                                        do {
                                            Bear bear = new Bear("bear"+(Bear.getNbBear()+1), (Tools.random(0,2) != 0), Tools.random(100,500), Tools.random(120, 150), Tools.random(2,15));
                                            paddock.add(bear);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un ours !"));
                                            bear.toString();
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "3":case "tigre":
                                        do {
                                            Tiger tiger = new Tiger("tiger"+(Tiger.getNbTiger()+1), (Tools.random(0,2) != 0), Tools.random(100,500), Tools.random(120, 150), Tools.random(2,15));
                                            paddock.add(tiger);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un tigre !"));
                                            tiger.toString();
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "2":case "aquarium":
                            Aquarium aquarium = new Aquarium("aquarium"+(Aquarium.getNbAquarium()+1), Tools.random(40, 500),Tools.random(3,20),"bon", Tools.random(10, 50), 50);
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aquarium !"));
                            this.showAllPaddock();
                            isPaddockFill =  Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cet aquarium, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Baleine\n" +
                                        "\t2: Pingouin\n" +
                                        "\t3: Poisson (rouge)\n" +
                                        "\t4: Requin\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "baleine":
                                        do {
                                            Whale whale = new Whale("whale"+(Whale.getNbWhale()+1), (Tools.random(0,2) != 0), Tools.random(150000,170000), Tools.random(120, 150), Tools.random(2,15));
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un baleine !"));
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill);
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "2":case "pingouin":
                                        do {
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un pingouin !"));
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill);
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "3":case "poisson":
                                        do {
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un poisson (rouge) !"));
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill);
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "4":case "requin":
                                        do {
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un requin !"));
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill);
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "3":case "volière":case "voliere":
                            Aviary aviary = new Aviary("aviary"+(Aviary.getNbAviary()+1),Tools.random(40,500),Tools.random(3,10),"bon",Tools.random(5,20));
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" une volière !"));
                            this.showAllPaddock();
                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cette voilière, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Aigle\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "aigle":
                                        do {
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aigle !"));
                                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        } while (isPaddockFill);
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "q":case "quit":case "quitter":case "exit":
                            Tools.exitZoo();
                            break;
                        default:
                            Tools.notProposedOption();
                            scannerChoicePaddock.nextLine();
                            break;
                    } // switch choicePaddock
                    if(!listPaddock.isEmpty())
                        isPaddockCreated = true;
                    if(!totalAnimal.isEmpty())
                        isAnimalCreated = true;
                    scannerChoiceAction.nextLine();
                    break;
                case "2":
                    if(isPaddockCreated){
                        System.out.print("\nQuel animal voulez-vous créer ?\n" +
                                "\t1: Aigle\n" +
                                "\t2: Baleine\n" +
                                "\t3: Loup\n" +
                                "\t4: Ours\n" +
                                "\t5: Pingouin\n" +
                                "\t6: Poisson (rouge)\n" +
                                "\t7: Requin\n" +
                                "\t8: Tigre\n" +
                                "\tq: QUITTER\n" +
                                "\nChoix : ");

                        String choiceAnimal = scannerChoiceAnimal.next();
                        choiceAnimal = choiceAnimal.toLowerCase();
                        switch (choiceAnimal) {
                            case "1":case "aigle":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aigle !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "2":case "baleine":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" une baleine !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "3":case "loup":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un loup !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "4":case "ours":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un ours !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "5":case "pingouin":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un pingouin !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "6":case "poisson":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un poisson rouge !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "7":case "requin":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un requin !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "8":case "tigre":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un tigre !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "q":case "quit":case "quitter":case "exit":
                                Tools.exitZoo();
                                break;
                            default:
                                Tools.notProposedOption();
                                scannerChoiceAnimal.nextLine();
                                break;
                        }// switch choiceAnimal
                    }
                    else
                        Tools.notProposedOption();
                    if(!totalAnimal.isEmpty())
                        isAnimalCreated = true;
                    scannerChoiceAction.nextLine();
                    break;
                case "3":case "gérer":case "gerer":
                    if(isAnimalCreated) {
                        System.out.println(Tools.strColorBlue("Vous entrez dans le mode gestion du zoo.\n"));
                    }
                    else
                        Tools.notProposedOption();
                    //scannerChoice____.nextLine();
                    break;
                case "q":case "quit":case "quitter":case "exit":
                    Tools.exitZoo();
                    break;
                default:
                    Tools.notProposedOption();
                    scannerChoiceAction.nextLine();
                    break;
            } // switch choiceAction
        } // while ()
    } // run()
}
