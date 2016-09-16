package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 12.06.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            ExceptionHandler.log(e);
        }
        catch (InstantiationException e)
        {
            ExceptionHandler.log(e);
        }
        catch (IllegalAccessException e)
        {
            ExceptionHandler.log(e);
        }
        catch (UnsupportedLookAndFeelException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController()
    {
        return controller;
    }

    public void undo(){
        undoManager.undo();
    }

    public void redo(){
        undoManager.redo();
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void init(){
        initGui();

        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void exit(){
        controller.exit();
    }

    public void selectedTabChanged() {

        int index = tabbedPane.getSelectedIndex();

        if (index == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        else if(index == 1){
            plainTextPane.setText(controller.getPlainText());
        }

        resetUndo();
    }

    public void initMenuBar(){

        JMenuBar menuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor() {

        htmlTextPane.setContentType("text/html");

        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);

        JScrollPane pane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", pane);


        tabbedPane.setPreferredSize(new Dimension(300, 300));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui() {

        initMenuBar();
        initEditor();
        pack();

    }

    public boolean isHtmlTabSelected(){
        return (tabbedPane.getSelectedIndex() == 0);
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){

        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){

        JOptionPane.showMessageDialog(this, "Something about program!", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command){

            case "Новый" : {
                controller.createNewDocument();
                break;
            }
            case "Открыть" : {
                controller.openDocument();
                break;
            }
            case "Сохранить" : {
                controller.saveDocument();
                break;
            }
            case "Сохранить как..." : {
                controller.saveDocumentAs();
                break;
            }
            case "Выход" : {
                controller.exit();
                break;
            }
            case "О программе" : {
                showAbout();
                break;
            }
        }
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }
}
