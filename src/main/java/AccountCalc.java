import java.util.Scanner;
public class AccountCalc{

    String goods = new String();
    int goodsCount = 0;
    double account;
    int countPeople;

    Scanner scanner;
    //функция вывода текстовых итогов
    public void showAccount(){

        String roubleText;
        if (goodsCount == 0){
            System.out.println("Товары не были добавлены");
            return;
        }
        double result = account/countPeople;
        int preResult = (int)Math.floor(account/countPeople); //switch не работает c double....

        switch (preResult%10){
            case 1:
                roubleText = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                roubleText = "рубля";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
            default:
                roubleText = "рублей";
                break;
        }
        System.out.println("Добавленные товары:" + "\n" + goods);
        System.out.println(String.format("Каждый человек заплатит %.2f %s",result,roubleText));
    }
    //функция получения товаров
    public void addGoods(){
        String goodsName, goodsCost;

        System.out.println("Введите название товара");
        goodsName = scanner.nextLine();

        while (true){
            try {
                int idx;
                System.out.println("Введите цену за товар в формате \"рубли.копейки\"");
                goodsCost = scanner.nextLine();

                idx = goodsCost.indexOf(".");
                if ((goodsCost.length() - idx - 3 <= 1 //проверяем кол-во знаков после точки, копейки могут быть в десятичных, отсюда и 1
                        || idx == -1) // или у нас целое значение
                ) // цена может быть только положительной
                {
                    double parsedCost = Double.parseDouble(goodsCost);
                    if (parsedCost > 0) {

                        goods += goodsName + "\n";
                        account += parsedCost;
                        goodsCount++;
                        break; //выходим как только получили корректное значение
                    }
                    else {
                        System.out.println("Введено отрицательное значение цены товара");
                    }
                }
                else{
                    System.out.println("Введено некоректное значение цены товара");
                }
            }
            catch (Exception e) {
                System.out.println("Введено некоректное значение цены товара");
            }
        }

        System.out.println("Товар " + goodsName + " успешно добавлен в корзину");

    }
    //функция получения кол-ва человек для деления
    public void getPeopleCount(){

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
                    scanner.nextLine();
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Введено некоректное значение, значение людей должно быть целым и больше 1");
                scanner.nextLine();//не оставляем следов от излишнего ввода
            }
        }

    }
    // главная функция, получает кол-во людей, запрашивает товары, и выводит итог
    public void getGoods(){

        scanner = new Scanner(System.in);
        getPeopleCount();

        String str;

        while(true){

            System.out.println("Введите любой символ, чтобы добавить товар");
            System.out.println("Или введите \"Завершить\" чтобы закончить ввод товаров ");
            str = scanner.nextLine();
            if (str.equalsIgnoreCase("завершить")){
                showAccount();
                break;
            }
            else addGoods();
        }
    }
}

