import com.trashpandainteractive.jg2d.Objects.GameObject;
import com.trashpandainteractive.jg2d.Objects.GameWindowObject;

import java.io.File;

import javax.imageio.ImageIO;

import com.trashpandainteractive.jg2d.World;
import com.trashpandainteractive.jg2d.Components.Position;
import com.trashpandainteractive.jg2d.Components.SpriteRenderer;
import com.trashpandainteractive.jg2d.Core.Component;
import com.trashpandainteractive.jg2d.Core.Sprite;

public class Example {
    public static void main(String[] args) throws Exception {
		File baseDir = new File(System.getProperty("user.dir"));
		File imageDir = new File(baseDir, "images");

        Sprite pgSprite = new Sprite(ImageIO.read(new File(imageDir, "tile_0024.png")), 16);
        SpriteRenderer pgRend = new SpriteRenderer(pgSprite);
        Position pgPos = new Position(50,50);
        GameObject pg = new GameObject(new Component[] { pgRend, pgPos }){
            
        };

        
        System.out.println(pg.toString());

        GameWindowObject gameWindow = new GameWindowObject();
        gameWindow.show();

        while(!gameWindow.isReady)
        {
            Thread.sleep(10);
        }
        World gameWorld = new World(gameWindow.get_BufferStrategy());
        gameWorld.AddGameObject(pg);
        gameWorld.Update();
    }
}
