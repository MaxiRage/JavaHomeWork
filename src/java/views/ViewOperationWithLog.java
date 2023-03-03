package views;

import loggers.Logger;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ViewOperationWithLog implements ViewOperations {

    private ViewOperations viewOperations;
    private Logger logger;

    private String logText(String method){
        return logText(LocalDateTime.now(), method);
    }

    private String logText(LocalDateTime dateTime, String method){
        return String.format("\ndate: %s, method: %s", dateTime.toString(), method);
    }

    @Override
    public void read() throws Exception {
        String text = logText("read");
        logger.log(text);
        viewOperations.read();
    }

    @Override
    public void delete() throws Exception {
        String text = logText("delete");
        logger.log(text);
        viewOperations.delete();
    }

    @Override
    public void update() throws Exception {
        String text = logText("update");
        logger.log(text);
        viewOperations.update();
    }

    @Override
    public void list() throws Exception {
        String text = logText("list");
        logger.log(text);
        viewOperations.list();
    }

    @Override
    public void create() throws Exception {
        String text = logText("create");
        logger.log(text);
        viewOperations.create();
    }

    @Override
    public void showHelp() {
        String text = logText("showHelp");
        logger.log(text);
        viewOperations.showHelp();
    }

    @Override
    public String prompt(String message) {
        return viewOperations.prompt(message);
    }
}
