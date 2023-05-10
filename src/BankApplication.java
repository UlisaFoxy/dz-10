import exceprions.WrongAccountException;
import exceprions.WrongCurrencyException;
import exceprions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankApplication {

    private final List<Account> accounts = new ArrayList<>() {{
        add(new Account("accountId000", 50, "USD"));
        add(new Account("accountId003", 250, "HRV"));
        add(new Account("accountId001", 50, "EUR"));
        add(new Account("accountId001", 50, "USD"));

    }};

    private int noAccount;
    public void process(String accountId, int amount, String currency) throws Exception {


        //я не розумію чого цей код тут? ми ж самі повинні написати process, тому я заремила

//        accounts.stream().filter(account -> account.getId().equals(accountId))
//                .findAny().orElseThrow(WrongAccountException::new);
//
//        accounts.stream().filter(account -> account.getId().equals(accountId))
//                .filter(account -> account.getCurrency().equals(currency))
//                .findAny().orElseThrow(WrongCurrencyException::new);
//
//        accounts.stream().filter(account -> account.getId().equals(accountId))
//                .filter(account -> account.getCurrency().equals(currency))
//                .filter(account -> account.getBalance() >= amount)
//                .findAny().orElseThrow(WrongOperationException::new);
//
//
//        Account desiredAccount = accounts.stream()
//                .filter(account -> account.getId().equals(accountId))
//                .filter(account -> account.getCurrency().equals(currency))
//                .filter(account -> account.getBalance() >= amount).findAny()
//                .orElseThrow();
//
//        int randomInt = new Random().nextInt(2);
//
//       if(randomInt == 1){
//           throw new Exception();
//       }
//
//        desiredAccount.setBalance(desiredAccount.getBalance() - amount);


        List<Account> accountWithCorrectAccountId = new ArrayList<>();
        for (Account account : accounts) {
                    if (account.getId().equals(accountId))  {
                        accountWithCorrectAccountId.add(account);
                    }
                }

                if (accountWithCorrectAccountId.size() == 0) {
                    throw new WrongAccountException();
                }


                List<Account> accountWithCorrectAccountIdAndBalance = new ArrayList<>();
                for (Account account : accountWithCorrectAccountId) {
                    if (account.getBalance()== amount) {
                        accountWithCorrectAccountIdAndBalance.add(account);
                    }
                }


                if (accountWithCorrectAccountIdAndBalance.size() <= amount) {
                    throw new WrongCurrencyException();
                }


                List<Account> accountWithCorrectAll = new ArrayList<>();
                for (Account account : accountWithCorrectAccountIdAndBalance) {
                    if (account.getCurrency().equals(currency)) {
                        accountWithCorrectAll.add(account);
                    }
                }

                if (accountWithCorrectAll.size() == 0) {
                    throw new WrongOperationException();
                } else {
                    noAccount++;
                }

       }

   }



