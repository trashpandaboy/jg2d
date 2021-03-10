import com.trashpandainteractive.jg2d.GameObject;
import com.trashpandainteractive.jg2d.Components.BoxCollider;
import com.trashpandainteractive.jg2d.Components.Position;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Position pos = new Position(1,1);
        BoxCollider collider = new BoxCollider(0, 0, 10, 10);

        System.out.println(pos.toString());

        GameObject go = new GameObject(){
            
        };

        go.AddComponent(pos);

        go.AddComponent(pos);

        go.AddComponent(collider);
        
        System.out.println(go.toString());
    }
}
