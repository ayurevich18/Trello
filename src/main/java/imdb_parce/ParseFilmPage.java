package imdb_parce;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ParseFilmPage {

    @Test
    public void parsePage() throws IOException {

        Map<String,String> directorRate= new HashMap<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.imdb.com/chart/top?ref_=nv_mv_250").build();
        Response response = client.newCall(request).execute();
        String html = response.body().string();
        List<FilmPage> filmPages = new ArrayList<>();
        List<String> topfilms = new ArrayList<>();
        List<String> directors = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select(".titleColumn a");
        for (Element element : elements) {
            String filmsUrls = element.attr("href");
//            System.out.println(filmsUrls);
            topfilms.add(filmsUrls);
        }




        for (int i = 0; i < 30; i++) {
            String urls = topfilms.get(i);

            Request request1 = new Request.Builder().url("https://www.imdb.com" + urls + "\"").build();
            Response response1 = client.newCall(request1).execute();
            String html1 = response1.body().string();
            Document document1 = Jsoup.parse(html1);
            Elements elements1 = document1.select("div #pagecontent");
            for (Element element : elements1) {
                String filmName = element.select(".title_wrapper > h1").text();
                double rating = Double.parseDouble(element.select("span[itemprop='ratingValue']").text());
                String director = element.select(".plot_summary :nth-child(2) > a").text();
                String urlDirector = element.select(".plot_summary :nth-child(2) > a").attr("href");
                String a = element.select(".metacriticScore > span").text();
                if (a.equals("")) {
                    a = "0";
                }
                int metascore = Integer.parseInt(a);
                int year = Integer.parseInt(element.select("#titleYear > a").text());
                String actors = element.select(".plot_summary :nth-child(4) :nth-child(2)").text();
                String genres = element.select(".subtext :nth-child(4)").text();
                String r1 = element.select(".txt-block > time[datetime]").text();
                if (r1.equals("")) {
                    r1 = "120 min";
                }
                System.out.println(r1);
                System.out.println(urls);

                int runtime = Integer.parseInt(r1.substring(0, r1.indexOf("m") - 1));
                directors.add(director);
                filmPages.add(new FilmPage(filmName, rating, director, metascore, year, actors, genres, runtime, urlDirector));


            }


        }
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Integer item;
        for (String wrd : directors) {


            item = hm.get(wrd);
            if (item == null) hm.put(wrd, 1); // если нет в списке то добавить со значением 1
            else hm.put(wrd, item + 1); // если есть такая фамилия(Key), то +1
        }

        System.out.println(hm);
        System.out.println("************************************");

        /* 1. Отсортировать список фильмов по году выхода и вывести в консоль */
        Collections.sort(filmPages, new SortByYear());
        for (FilmPage filmPage : filmPages) {
            System.out.println(filmPage);
        }
        System.out.println("************************************");

        /* 2. Отсортировать список фильтов по метаскору и вывести в консоль       */
        Collections.sort(filmPages, new SortByMetaScore());
        for (FilmPage filmPage : filmPages) {
            System.out.println(filmPage);
        }
        System.out.println("************************************");

        /* 3. Отсортировать список фильмов по продолжительности. Вывести в консоль самый короткий фильм.       */
        Collections.sort(filmPages, new SortByRuntime());
        System.out.println(filmPages.get(0));
        System.out.println("************************************");




        Set<String> directorsList = filmPages.stream().map(film -> film.director).collect(Collectors.toSet());
        for(String i:directorsList){
            System.out.println("********************1");
            System.out.println(i);
            System.out.println("********************1");
        }




        directorRate.put("","");


    }
}
