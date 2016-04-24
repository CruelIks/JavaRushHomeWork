package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Prog on 21.04.2016.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int sum;
        while (true){

            try
            {
                ConsoleHelper.writeMessage("enter sum money");
                sum = Integer.parseInt(ConsoleHelper.readString());

                if (!manipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }

                Map<Integer, Integer> map = manipulator.withdrawAmount(sum);
                /*ArrayList<Integer> keys = new ArrayList<>();
                keys.addAll(map.keySet());
                keys.sort(new Comparator<Integer>()
                {
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        return o2.compareTo(o1);
                    }
                });

                for (Integer integer : keys)
                {
                    ConsoleHelper.writeMessage("    " + integer + " - " + map.get(integer));
                }
                ConsoleHelper.writeMessage("the operation was successful");*/
                break;

            }
            catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            catch(NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
            }


        }
    }
}
