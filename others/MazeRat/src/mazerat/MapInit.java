package mazerat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapInit {
    
   public static String[][] createMap() {
        try {
            int row, col;
            String[][] map;
            BufferedReader br = new BufferedReader(new FileReader("./map.txt"));
            String mapTitle = br.readLine();
            System.out.printf("**** %s ****\n", mapTitle);
            
            String[] size = br.readLine().split(" ");
            row = Integer.parseInt(size[0]);
            col = Integer.parseInt(size[1]);

            System.out.println("[row]: " + row);
            System.out.println("[col]: " + col);
            
            map = new String[row][col];
            
            for(int i=0; i<row; i++) {
                size = br.readLine().split(" ");
                for(int v=0; v<col; v++) {
                    map[i][v] = size[v];
                }
            }
            br.close();
            return map;
            
        } catch(IOException e) {
            System.out.println("Error caught due to " + e);
        }
        
        return null;
    }
    
    public static String printMap(String[][] map) {
        String s = "";
        for(String[] row: map) {
            for(String cell: row) {
                s += cell + " ";
            }
            s += "\n";
        }
        return s;
    }
    
}
