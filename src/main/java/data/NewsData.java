package data;

import model.NewsModel;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class NewsData implements Subject {

    private List<Observer<NewsModel>> observers;

    private NewsModel newsModel;

    public NewsData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > -1) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(newsModel);
        }
    }

    public void setPlayerData(NewsModel newsModel) {
        this.newsModel = newsModel;
        notifyObserver();
    }
}
