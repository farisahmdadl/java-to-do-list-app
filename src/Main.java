// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }
    public static void showToDoList(){
        System.out.println("To Do List");
        for (var i = 0; i < model.length; i++){
            var toDo = model[i];
            var number = i + 1;

            if(toDo != null) {
                System.out.println(number + ". " + toDo);
            }
        }
    }

    public static void testShowToDoList(){
        model[0] = "Basic Java";
        model[1] = "Study Case";
        showToDoList();
    }

    public static void addToDoList(String toDo){
        var isFull = true;
        for (int i=0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var tempModel = model;
            model = new String[model.length * 2];

            for (int i =0; i < tempModel.length; i++) {
                model[i] = tempModel[i];
            }
        }

        for (var i=0; i<model.length; i++){
            if (model[i] == null){
                model[i] = toDo;
                break;
            }
        }
    }

    public static void testAddToDoList() {
        for (int i = 1; i <= 30; i++){
            addToDoList("ToDo List: " + i);
        }
        showToDoList();
    }

    public static boolean removeToDoList(Integer number){

        if((number - 1) >= model.length) {
            return false;
        }

        if (model[number - 1] == null){
            return false;
        } else {
            model[number -1] = null;

            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveToDoList(){
        addToDoList("One");
        addToDoList("Two");
        addToDoList("Three");
        addToDoList("Four");
        addToDoList("Five");

        removeToDoList(5);
        showToDoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Name");
        System.out.println("Hi " + name);

        var organization = input("Organization");
        System.out.println("Welcome to " + organization);
    }

    public static void viewShowToDoList(){
        while (true){
            showToDoList();

            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Sign Out");

            var input = input("Select");
            if(input.equals("1")){
                viewAddToDoList();
            }else if(input.equals("2")){
                viewRemoveToDoList();
            }else if(input.equals("3")){
                break;
            }
            else {
                System.out.println("Wrong Input!");
            }
        }
    }

    public static void testViewShowToDoList(){
        addToDoList("One");
        addToDoList("Two");
        addToDoList("Three");
        addToDoList("Four");
        addToDoList("Five");
        viewShowToDoList();
    }

    public static void viewAddToDoList(){
        System.out.println("Add To Do List");

        var toDo = input("To Do (0 To Cancel)");

        if (toDo.equals("0")){

        } else {
            addToDoList(toDo);
        }
    }

    public static void testViewAddToDoList(){
        addToDoList("One");
        addToDoList("Two");
        addToDoList("Three");
        addToDoList("Four");
        addToDoList("Five");

        viewAddToDoList();

        showToDoList();
    }

    public static void viewRemoveToDoList(){
        System.out.println("Remove To Do List");

        var number = input("Removed List (0 To Cancel)");

        if(number.equals("0")){

        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Failed to remove " + number);
            }
        }
    }

    public static void testViewRemoveToDoList () {
        addToDoList("One");
        addToDoList("Two");
        addToDoList("Three");
        addToDoList("Four");
        addToDoList("Five");

        showToDoList();

        viewRemoveToDoList();

        showToDoList();
    }
}