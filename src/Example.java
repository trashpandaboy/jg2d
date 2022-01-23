import java.io.File;

import javax.imageio.ImageIO;

import com.trashpandaboy.jg2d.World;
import com.trashpandaboy.jg2d.Components.Position;
import com.trashpandaboy.jg2d.Components.SpriteRenderer;
import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Sprite;
import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Core.Helpers.KeyBoardHandler;
import com.trashpandaboy.jg2d.Objects.GameObject;
import com.trashpandaboy.jg2d.Objects.GameWindowObject;
import com.trashpandaboy.jg2d.Objects.PlayerCharacter;

public class Example {
    public static void main(String[] args) throws Exception {
		File baseDir = new File(System.getProperty("user.dir"));
		File imageDir = new File(baseDir, "images");

        Sprite pgSprite = new Sprite(ImageIO.read(new File(imageDir, "tile_0024.png")), 16);
        SpriteRenderer pgRend = new SpriteRenderer(pgSprite);
        Position pgPos = new Position(50,50);

        PlayerCharacter player = new PlayerCharacter(new Component[] { pgRend, pgPos });
        
        System.out.println(player.toString());

        GameWindowObject gameWindow = new GameWindowObject();
        gameWindow.show();

        do{
            Thread.sleep(10);
        } while(!gameWindow.isReady);

        World gameWorld = new World(Environment.CURRENT_GAME_WINDOW.getBufferStrategy());
        gameWorld.AddGameObject(player);
        gameWorld.start();
        
        KeyBoardHandler keyHandler = new KeyBoardHandler();
        keyHandler.start();
    }
}
