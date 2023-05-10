import exceprions.WrongAccountException;
import exceprions.WrongCurrencyException;
import exceprions.WrongOperationException;

public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        try {
            //перевіряла по одному

            //bankApplication.process("accountId000", 700, "SEK"); // +-- видає має рахунок в іншій валюті - переробити
            //bankApplication.process("accountId003", 250, "SEK"); // ++-  right
            bankApplication.process("accountId001", 50, "EUR");  //+++ видає має рахунок в іншій валюті - переробит
            //bankApplication.process("accountId007", 777, "SEK");//---right
        } catch (WrongAccountException wrongAccountException) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }

    }

}

