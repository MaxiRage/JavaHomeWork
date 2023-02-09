package homework_6;

import java.util.ArrayList;
import java.util.List;

/***
 * @count Укажите количество ноутбуков
 */
public class Main {

    public static void main(String[] args) {
        int count = 30;

        List<NoteBook> allNotebook = new ArrayList<>();
        while (count-- > 0){
            allNotebook.add(new NoteBook());
        }
        Service.start(allNotebook);
    }
}
