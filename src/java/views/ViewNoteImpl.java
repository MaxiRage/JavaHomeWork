package views;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ViewNoteImpl implements ViewNote {

    private final ViewOperations viewOperations;

    public void run(){
        boolean isContinue = true;
        viewOperations.showHelp();
        while (isContinue){
            try{
                String command = viewOperations.prompt("Введите команду: ");
                Commands com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT){
                    isContinue = false;
                    continue;
                }

                switch (com) {
                    case CREATE -> viewOperations.create();
                    case READ -> viewOperations.read();
                    case UPDATE -> viewOperations.update();
                    case LIST -> viewOperations.list();
                    case HELP -> viewOperations.showHelp();
                    case DELETE -> viewOperations.delete();
                }
            }catch (Exception e){
                System.out.println("Произошла ошибка");
            }
        }
    }
}