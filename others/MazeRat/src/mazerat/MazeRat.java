package mazerat;

public class MazeRat {
    
    public static void main(String[] args) {
        String[][] map = MapInit.createMap();
        
        System.out.println("_____________________________________");
        
        Maze maze = new Maze(map);       
        
        System.out.println(maze.solve());
    }
    
}
