package nationOfchicken;

import java.util.ArrayList;
import java.util.List;

public class FeedbackList {
    private static List<Feedback> feedbackList = new ArrayList<>();

    FeedbackList() {}
    FeedbackList(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public static List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
