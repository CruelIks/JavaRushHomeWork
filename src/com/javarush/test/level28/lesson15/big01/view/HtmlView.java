package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "\\/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        System.out.println(vacancies.size());
        System.out.println(filePath);

        try
        {
            String fileName = getUpdatedFileContent(vacancies);
            updateFile(fileName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {

        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {

        Document document = getDocument();

        Element original = document.getElementsByClass("template").first();
        Element clone = original.clone();
        clone.removeAttr("style");
        clone.removeClass("template");

        document.getElementsByAttributeValue("class", "vacancy").remove();


        for (Vacancy vacancy : vacancies)
        {
            Element newElement = clone.clone();
            newElement.getElementsByAttributeValue("class", "city").first().text(vacancy.getCity());
            newElement.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
            newElement.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
            Element link = newElement.getElementsByTag("a").first();
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());
            original.before(newElement.outerHtml());
        }

        return document.html();
    }

    private void updateFile(String fileBody)
    {

        if (fileBody == null) return;

        try
        {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fileBody);

            bufferedWriter.close();
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    protected Document getDocument() throws IOException
    {

        Document document = Jsoup.parse(new File(filePath), "UTF-8");

        return document;
    }
}
