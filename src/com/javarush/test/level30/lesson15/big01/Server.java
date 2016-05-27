package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Prog on 25.05.2016.
 */
public class Server
{

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String args[])
    {

        ConsoleHelper.writeMessage("enter port for serverSocket");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;

        try
        {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("server is started");

            while (true)
            {

                new Handler(serverSocket.accept()).start();

            }


        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
            if (serverSocket != null && !serverSocket.isClosed())
            {
                try
                {
                    serverSocket.close();
                }
                catch (IOException e1)
                {
                    ConsoleHelper.writeMessage(e.getMessage());
                }
            }
        }

    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Connection connection : connectionMap.values())
        {
            try
            {
                connection.send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("error send message");
            }
        }
    }

    private static class Handler extends Thread
    {

        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("connecting with " + socket.getRemoteSocketAddress());
            String userName = null;

            try (Connection connection = new Connection(socket))
            {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("error change data with " + socket.getRemoteSocketAddress());
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("error change data with " + socket.getRemoteSocketAddress());
            }

            if (userName != null)
            {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

            }

            ConsoleHelper.writeMessage("session closed with " + socket.getRemoteSocketAddress());

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {

            String user = null;

            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType() == MessageType.USER_NAME)
                {
                    user = message.getData();

                    if ((user != null) && (!user.isEmpty()))
                        if (!connectionMap.containsKey(user))
                        {

                            connectionMap.put(user, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                            break;

                        }
                }
            }
            return user;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {

            for (String s : connectionMap.keySet())
            {
                if (!s.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {

            while (true)
            {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT)
                {

                    if (message.getData() == null)
                    {
                        ConsoleHelper.writeMessage("null data message");
                        continue;
                    }

                    String txtMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, txtMessage));

                }
            }

        }
    }
}
