import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int val;
        val = getPeopleCount();
    }

    public static int getPeopleCount(){

        Scanner scanner = new Scanner(System.in);
        int getValue;
        while (true)
        {
            System.out.println("Введите количество человек");
            try {
                getValue = scanner.nextInt();
                if (getValue <= 1){

                    System.out.println("Введено некоректное значение, значение людей должно быть больше 1");

                }
                else return getValue;
            }
            catch(Exception e) {
                System.out.println("Введено некоректное значение, значение людей должно быть больше 1");
                scanner.nextLine(); //высвобождает значение в считывании
            }



        }

    }
}