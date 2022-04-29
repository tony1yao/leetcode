import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    List<String> history = new ArrayList<>();
    int currentPageIndex;
    int totalSize;
    public BrowserHistory(String homepage) {
        this.history.add(homepage);
        this.totalSize = this.history.size();
        this.currentPageIndex = 0;
    }

    public void visit(String url) {
        if (this.currentPageIndex + 1 < this.history.size()) {
            this.totalSize = this.currentPageIndex + 1;
            this.history.add(this.totalSize, url);
            this.totalSize++;
        } else {
            this.history.add(url);
            this.totalSize = this.history.size();
        }
        this.currentPageIndex++;
    }

    public String back(int steps) {
        this.currentPageIndex = Math.max(0, this.currentPageIndex - steps);
        return this.history.get(this.currentPageIndex);
    }

    public String forward(int steps) {
        this.currentPageIndex = Math.min(this.currentPageIndex + steps, this.totalSize - 1);
        return this.history.get(this.currentPageIndex);
    }
}