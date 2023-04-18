import java.util.Scanner;
public class Main {

    public static class AccountCalc{

        String goods = "Добавленные товары:";
        int goodsCount = 0;
        double account;
        int countPeople;

        public void showAccount(){
            if (goodsCount == 0){
                System.out.println("Товары не были добавлены");
                return;
            }

            System.out.println(goods);
            System.out.println(account);
            System.out.println(countPeople);
        }
        public void addGoods(){
            Scanner scanner = new Scanner(System.in);

            String goodsName, goodsCost;

            System.out.println("Введите название товара");
            goodsName = scanner.next();
            goods += "\n" + goodsName;
            while (true){
                try {
                    System.out.println("Введите цену за товар в формате \"рубли.копейки\"");
                    goodsCost = scanner.next();



                    account += Double.parseDouble(goodsCost);
                    goodsCount++;
                    break; //выходим как только получили корректное значение
                }
                catch (Exception e) {
                    System.out.println("Введено некоректное значение цены товара");
                    scanner.nextLine();
                }
            }

            System.out.println("Товар " + goodsName + " успешно добавлен в корзину");

        }

        public void getGoods(){

            getPeopleCount();

            Scanner scanner = new Scanner(System.in);

            String str;

            while(true){

                System.out.println("Введите любой символ, чтобы добавить товар");
                System.out.println("Или введите \"Заверишить\" чтобы закончить ввод товаров ");
                str = scanner.next();
                if (str.equalsIgnoreCase("завершить")){
                    showAccount();
                    break;
                }
                else addGoods();
            }


        }

        public void getPeopleCount(){

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
                    else {
                        countPeople = getValue;
                        break;
                    }
                }
                catch(Exception e) {
                    System.out.println("Введено некоректное значение, значение людей должно быть целым и больше 1");
                    scanner.nextLine(); //высвобождает значение в считывании
                }
            }

        }
    }

    public static void main(String[] args) {
        AccountCalc calc = new AccountCalc();
        calc.getGoods();
    }


}