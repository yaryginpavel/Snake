package snake;

import org.eclipse.swt.graphics.Image;

public class Fruits {

	public int fruit_x;
	public int fruit_y;	
	private int fruitSize;
	
    private final int rand_pos = 39;

    public Image[] fruits = {
    		new Image(null, "apple.png"),
    		new Image(null, "banana.png"),
    		new Image(null, "pineapple.png")
    };
    
    public Fruits(int dot_zise){
    	fruitSize = dot_zise;
    }
    
    public void locateFruits(){
        int r;
        r = (int) (Math.random() * rand_pos);
        fruit_x = ((r * fruitSize));
        r = (int) (Math.random() * rand_pos);
        fruit_y = ((r * fruitSize));
    } 
}
