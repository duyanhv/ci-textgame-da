package gameentities;

import bases.events.EventManager;

import java.util.ArrayList;

/**
 * Created by duyanh on 10/7/17.
 *
 * la nhieu rows(MapRow) ghep lai voi nhau
 *
 * băm map la thành các hàng nhỏ.
 * 1 map chứa nhiều row, 1 row chứa nhiều cells
 */
public class Map {
    public ArrayList<MapRow> rows;
    static public int width;
    static public int height;

    static public int playerX;
    static public int playerY;
    public int[] coordinateX = new int[100];
    public int[] coordinateY = new int[100];

    public Map(String content){
        /**
         * con nhieu he dieu hanh: \n = \r\n -> replace \n = "" la duoc
        */
        String[] lines = content.replace("\r","").split("\n");

         height = lines.length;
         width = lines[0].length();

         //phai khoi tao rows
         rows = new ArrayList<>();

         for(String line: lines){
             MapRow newRow = new MapRow(line);
             rows.add(newRow);
         }

         for(int y =0; y < rows.size(); y++){
             MapRow row = rows.get(y);
             playerX = row.findPlayerXAndReplace();
             if(playerX != -1){
                 playerY = y;
                 System.out.println("Found: " +playerX+ " "+playerY);
                 break;
             }
         }


         for(int yWall = 0; yWall < rows.size();yWall++){
             MapRow row = rows.get(yWall);
             row.checkWall(coordinateX);
             for(int i = 0; i < coordinateX.length; i ++){
                 if(coordinateX[i] != 0){
                     for(int j = 0; j< coordinateY.length; j++){
                         coordinateY[j] = yWall;
//                         System.out.println("Wall: "+coordinateX[i]+ " "+coordinateY[i]);
                         break;
                     }
                 }
             }
         }

    }

    public boolean checkWall(){
        for(int i = 0; i < coordinateX.length; i ++){
            if(coordinateX[i] != 0){
                for(int j = 0; j< coordinateY.length; j++){
                    if(playerX == coordinateX[i] || playerY == coordinateY[j]){
                        return false;
                    }
//
                }
            }
        }

        return true;
    }

    public String get(int x, int y){
        //TODO: check width, height, if out of range => return null
        if(x < width || y < height){
            MapRow selectedRow = rows.get(y);
            return selectedRow.getCell(x);
        }

        return null;

    }

    //muc tieu la viet mapUI no se hien len toan man hinh
    public void pushUI(){
//        for(MapRow row : rows){
//            row.pushUI();
//            EventManager.pushUIMessageNewLine("");
//        }


        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(x == playerX && y == playerY){
                    EventManager.pushUIMessage(" @ ");
                }else{
                    String cell = get(x,y);
                    EventManager.pushUIMessage(" "+ cell + " ");
                }
            }

            EventManager.pushUIMessageNewLine("");
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "rows=" + rows +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
