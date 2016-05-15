package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 15.05.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private final static String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";
    private static final String referrer = "http://www.google.com";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        try
        {
            while (true)
            {

                Document doc = getDocument(searchString, page++);
                Elements all = doc.getElementsByClass("job");

                if (all.size() == 0) break;

                for (Element e : all)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName(doc.title());
                    vacancy.setSalary(e.getElementsByClass("salary").first().getElementsByAttributeValue("title", "Зарплата").text());
                    vacancy.setTitle(e.getElementsByClass("info").first().getElementsByAttribute("title").text());
                    vacancy.setUrl("https://moikrug.ru" + e.getElementsByClass("title").first().getElementsByTag("a").attr("href"));
                    vacancy.setCity(e.getElementsByClass("location").text());
                    vacancy.setCompanyName(e.getElementsByClass("company_name").first().getElementsByTag("a").text());
                    list.add(vacancy);
                }

            }

        }

        catch (IOException e)
        {

        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page, searchString);
        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
    }
}
