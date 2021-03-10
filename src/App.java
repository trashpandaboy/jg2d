import com.trashpandainteractive.jg2d.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Position pos = new Position(1,1);
        System.out.println(pos.toString());

        GameObject go = new GameObject(){
            
        };

        go.AddComponent(pos);

        go.AddComponent(pos);
        
    }
}
