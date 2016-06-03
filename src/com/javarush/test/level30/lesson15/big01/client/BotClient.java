package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Prog on 30.05.2016.
 */
public class BotClient extends Client
{

    private static int botNumber = -1;

    public static void main(String[] args)
    {
        new BotClient().run();
    }


    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {

        if (botNumber == -1 || botNumber == 99)
        {
            botNumber = (int)(Math.random() * 99);
        }
        else botNumber++;


        return "date_bot_" + botNumber;
    }

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {

            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);

            String array[] = message.split(": ");
            if (array.length < 2) return;

            String msg = array[1].trim();

            Date date = new Date();
            if (msg.equalsIgnoreCase("дата")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("день")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("месяц")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("год")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("время")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("час")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("минуты")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }
            else if (msg.equalsIgnoreCase("секунды")){

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s");

                sendTextMessage("Информация для " + array[0] + ": " + simpleDateFormat.format(date));
            }



        }
    }
}
