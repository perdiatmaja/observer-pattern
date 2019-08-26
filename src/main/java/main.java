import data.NewsData;
import display.NewsCahnnelThree;
import display.NewsChannelOne;
import display.NewsChannelTwo;
import model.NewsModel;

public class main {
    private static NewsData newsData;
    private static NewsChannelOne newsChannelOne;
    private static NewsChannelTwo newsChannelTwo;
    private static NewsCahnnelThree newsCahnnelThree;

    public static void main(String[] args) {
        init();
        changeDate(0);
    }

    private static void init() {
        newsData = new NewsData();
        newsChannelOne = new NewsChannelOne(newsData);
        newsChannelTwo = new NewsChannelTwo(newsData);
        newsCahnnelThree = new NewsCahnnelThree(newsData);
    }

    private static void changeDate(int count) {
        if (count == 5) {
            newsData.removeObserver(newsChannelOne);
        }

        if (count == 10) {
            newsData.removeObserver(newsChannelTwo);
        }

        String countStr = String.valueOf(count);
        newsData.setPlayerData(new NewsModel("Headline : " + countStr, "This is news " + countStr));

        if (count < 15) {
            changeDate(count+1);
        } else {
            newsData.removeObserver(newsCahnnelThree);
        }
    }
}