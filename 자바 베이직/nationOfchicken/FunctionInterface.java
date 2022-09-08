package nationOfchicken;

import java.io.BufferedReader;
import java.io.IOException;

public interface FunctionInterface {
    void showCommand();
    int selectMenu(BufferedReader bf) throws IOException;
    void register(BufferedReader bf, Shop shop) throws IOException;
    void addFood(BufferedReader bf) throws IOException;
    void order(BufferedReader bf, OrderList orderList) throws IOException;
    void registerStar(BufferedReader bf, FeedbackList feedbackList) throws IOException;
    void viewStars(BufferedReader bf, Feedback feedback) throws IOException;
}
