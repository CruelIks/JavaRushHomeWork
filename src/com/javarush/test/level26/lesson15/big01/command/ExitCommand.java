package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Prog on 21.04.2016.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("really want to exit? y/n:");
        String answer = ConsoleHelper.readString();

        if (answer.equals("y")) {
            ConsoleHelper.writeMessage("bye!");
        }

    }
}
