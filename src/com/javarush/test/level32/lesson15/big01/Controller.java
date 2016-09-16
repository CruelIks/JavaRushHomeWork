package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Admin on 12.06.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public void init()
    {
        createNewDocument();
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();


    }

    public void resetDocument()
    {

        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }

        HTMLEditorKit htmlKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        try
        {
            htmlKit.read(reader, document, 0);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){

        StringWriter writer = new StringWriter();
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        try
        {
            htmlKit.write(writer, document, 0, document.getLength());
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }

        return writer.toString();

    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void exit()
    {
        System.exit(0);
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            resetDocument();
            try(FileReader fr = new FileReader(currentFile))
            {

                HTMLEditorKit htmlKit = new HTMLEditorKit();

                htmlKit.read(fr, document, 0);
                view.resetUndo();

            }
            catch (IOException e)
            {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e)
            {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument()
    {
        if (currentFile == null){
            saveDocumentAs();
        }
        else {
            view.selectHtmlTab();
            try(FileWriter fw = new FileWriter(currentFile))
            {

                HTMLEditorKit htmlKit = new HTMLEditorKit();
                htmlKit.write(fw, document, 0, document.getLength());

            }
            catch (IOException e)
            {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e)
            {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocumentAs()
    {

        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        if (chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter fw = new FileWriter(currentFile))
            {

                HTMLEditorKit htmlKit = new HTMLEditorKit();
                htmlKit.write(fw, document, 0, document.getLength());

            }
            catch (IOException e)
            {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e)
            {
                ExceptionHandler.log(e);
            }
        }
        else{

        }
    }
}
