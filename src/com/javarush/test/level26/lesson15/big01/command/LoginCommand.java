package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Admin on 23.04.2016.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        /*String cardNumber = "123456789012";
        String pin = "1234";*/

        while (true){

            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String str1 = ConsoleHelper.readString();
            String str2 = ConsoleHelper.readString();

            if ((!str1.matches("^\\d{12}$")) || (!str2.matches("^\\d{4}$")))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (validCreditCards.containsKey(str1)){

                if (validCreditCards.getString(str1).equals(str2)){
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), str1));
                    break;
                }
            }
            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), str1));
            continue;

        }
    }
}
