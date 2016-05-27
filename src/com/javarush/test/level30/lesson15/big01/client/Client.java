package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

/**
 * Created by Prog on 27.05.2016.
 */
public class Client
{

    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {

        String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";


        ConsoleHelper.writeMessage("enter server's ip address");
        String serverAddress = null;
        while (true)
        {
            serverAddress = ConsoleHelper.readString();
            if (serverAddress.matches(IPADDRESS_PATTERN) || serverAddress.equals("localhost"))
            {
                break;
            }

        }

        return serverAddress;
    }

    protected int getServerPort()
    {

        ConsoleHelper.writeMessage("enter server's port");
        int result = ConsoleHelper.readInt();


        return result;
    }

    protected String getUserName()
    {

        String result;
        ConsoleHelper.writeMessage("enter user name");
        result = ConsoleHelper.readString();

        return result;
    }

    protected boolean shouldSentTextFromConsole()
    {

        return true;
    }

    protected SocketThread getSocketThread()
    {

        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {

        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {

            ConsoleHelper.writeMessage("error sending message");
            clientConnected = false;
        }

    }

    public void run()
    {

        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("error");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        String txt = null;
        while (clientConnected){

            txt = ConsoleHelper.readString();

            if (txt.equals("exit")) {
                break;
            }

            if (shouldSentTextFromConsole()){
                sendTextMessage(txt);
            }


        }


    }

    public static void main(String args[]){

        new Client().run();

    }

    public class SocketThread extends Thread
    {


        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " вошел в чат");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " уходит из чата");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){

            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{

            Message message = connection.receive();
            if (message.getType() == MessageType.NAME_REQUEST){

            }

        }

    }
}
