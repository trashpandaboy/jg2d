import java.io.File;

import javax.imageio.ImageIO;

import com.trashpandaboy.jg2d.GameLoop;
import com.trashpandaboy.jg2d.Components.PlayerMovement;
import com.trashpandaboy.jg2d.Components.Position;
import com.trashpandaboy.jg2d.Components.SpriteRenderer;
import com.trashpandaboy.jg2d.Core.Sprite;
import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Core.Helpers.KeyBoardHandler;
import com.trashpandaboy.jg2d.Objects.GameObject;
import com.trashpandaboy.jg2d.Objects.GameWindowObject;

public class Example {
    public static void main(String[] args) throws Exception {
		File baseDir = new File(System.getProperty("user.dir"));
		File imageDir = new File(baseDir, "images");

        GameObject player = new GameObject() {
        };

        Sprite pgSprite = new Sprite(ImageIO.read(new File(imageDir, "tile_0024.png")), 64);
        PlayerMovement movementHandler = new PlayerMovement(player);
        SpriteRenderer pgRend = new SpriteRenderer(pgSprite, player);
        Position pgPos = new Position(50,50,player);

        player.AddComponent(pgRend);
        player.AddComponent(pgPos);
        player.AddComponent(movementHandler);
        
        System.out.println(player.toString());

        GameWindowObject gameWindow = new GameWindowObject();
        gameWindow.show();

        do{
            Thread.sleep(10);
        } while(!gameWindow.isReady);

        GameLoop gameWorld = new GameLoop(Environment.CURRENT_GAME_WINDOW.getBufferStrategy());
        gameWorld.SetFPS_CAP(30);
        gameWorld.AddGameObject(player);
        gameWorld.start();
        
        KeyBoardHandler keyHandler = new KeyBoardHandler();
        keyHandler.start();
    }
}
