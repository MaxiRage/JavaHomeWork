package homework_6;

import lombok.Getter;

@Getter
public class NoteBook {
    double price;
    double diagonal;
    int ram;
    int sizeHDD;
    int videoCard;
    int countUSB;
    String color;
    String brand;

    public NoteBook() {
        this.price = Math.round((Math.random() * ((100_000 - 100_00) + 1)) + 100_00);
        this.diagonal = Math.round((Math.random() * ((30 - 10) + 1)) + 10);
        this.ram = (int) (Math.random() * ((32 - 1) + 1)) + 1;
        this.sizeHDD = (int) (Math.random() * ((1054 - 128) + 1)) + 128;
        this.videoCard = (int) (Math.random() * ((32 - 1) + 1)) + 1;
        this.countUSB = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        this.color = choiceColor();
        this.brand = choiceBrand();
    }

    private String choiceColor() {
        int random = (int) (Math.random() * ((5 - 1) + 1)) + 1;

        return switch (random) {
            case 1 -> "blue";
            case 2 -> "red";
            case 3 -> "orange";
            case 4 -> "white";
            case 5 -> "black";
            default -> "grey";
        };
    }

    private String choiceBrand() {
        int random = (int) (Math.random() * ((5 - 1) + 1)) + 1;

        return switch (random) {
            case 1 -> "MSI";
            case 2 -> "Lenovo";
            case 3 -> "HP";
            case 4 -> "Apple";
            case 5 -> "Samsung";
            default -> "Acer";
        };
    }

    public static int compare(NoteBook nb1, NoteBook nb2) {
        if (nb1.getPrice() > nb2.getPrice())
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "NoteBook " + "\"" + brand + "\"" +
                " Price=" + price +
                ", Diagonal=" + diagonal +
                ", RAM=" + ram +
                ", SizeHDD=" + sizeHDD +
                ", VideoCard=" + videoCard +
                ", CountUSB=" + countUSB +
                ", Color=" + color;
    }
}
