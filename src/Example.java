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

        // Sprite pgSprite = new Sprite(ImageIO.read(new File(imageDir, "tile_0024.png")), 64);
        
        Sprite pg1 = new Sprite(ImageIO.read(new File(imageDir, "sprite_1.png")), 128);
        Sprite pg2 = new Sprite(ImageIO.read(new File(imageDir, "sprite_2.png")), 128);
        Sprite pg3 = new Sprite(ImageIO.read(new File(imageDir, "sprite_3.png")), 128);
        SpriteRenderer pgRend = new SpriteRenderer(new Sprite[] { pg1, pg2, pg1, pg3}, player);
        pgRend.SetSpritePerSecond(4);

        Position pgPos = new Position(50,50,player);
        PlayerMovement movementHandler = new PlayerMovement(15,15,player);

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
        // gameWorld.SetFPS_CAP(30);
        gameWorld.AddGameObject(player);
        gameWorld.start();
        
        KeyBoardHandler keyHandler = new KeyBoardHandler();
        keyHandler.start();
    }
}
