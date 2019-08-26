package display;

import model.NewsModel;
import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

public class NewsChannelOne implements Observer<NewsModel>, DisplayElement {

    private Subject subject;

    private NewsModel newsModel;

    public NewsChannelOne(Subject subject) {
            this.subject = subject;
            subject.registerObserver(this);
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append("This is news from Channel 1")
                .append("\n")
                .append("Headline : ")
                .append(newsModel.getTitle())
                .append("\n")
                .append(newsModel.getDesc())
                .append("\n");

        System.out.println(builder.toString());
    }

    @Override
    public void update(NewsModel data) {
        newsModel = data;
        display();
    }
}