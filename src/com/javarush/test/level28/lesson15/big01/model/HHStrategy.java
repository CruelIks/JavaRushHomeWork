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
 * Created by Prog on 13.05.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final int TIMEOUT = 5 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> allVacancy = new ArrayList<>();

        try
        {

            int count = 0;
            while (true)
            {

                Document doc = getDocument(searchString, count);

                String selector = "[data-qa=vacancy-serp__vacancy]";
                Elements elements = doc.select(selector);

                if (elements.size() == 0) break;

                for (Element element : elements)
                {
                    String stop = "yes";

                    String v_title, v_salary = "", v_city, v_companyName, v_siteName, v_url;

                    Element element_Title = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    v_title = element_Title.text();
                    v_url = element_Title.attr("href");

                    v_companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();
                    v_city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                    Element element_Salary = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();

                    if (element_Salary != null)
                    {
                        v_salary = element_Salary.text();
                    }
                    v_siteName = "http://hh.ua/";

                    Vacancy newVacancy = new Vacancy();
                    newVacancy.setCity(v_city);
                    newVacancy.setCompanyName(v_companyName);
                    newVacancy.setSalary(v_salary);
                    newVacancy.setTitle(v_title);
                    newVacancy.setSiteName(v_siteName);
                    newVacancy.setUrl(v_url);

                    allVacancy.add(newVacancy);

                }

                count++;
            }


        }
        catch (IOException e)
        {

        }
        catch (NullPointerException e) {}


        return allVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer("http://www.google.com").timeout(TIMEOUT).get();
        return doc;
    }
}
