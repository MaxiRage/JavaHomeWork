import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {
    Object data;
    private Element next;
    private Element previous;
    public Element(Object data) {
        this.data = data;
    }

}