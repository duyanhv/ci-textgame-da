package gameentities;

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
    public int width;
    public int heigth;

    public Map(String content){
        /**
         * con nhieu he dieu hanh: \n = \r\n -> replace \n = "" la duoc
        */
        String[] lines = content.replace("\r","").split("\n");

         heigth = lines.length;
         width = lines[0].length();

         //phai khoi tao rows
         rows = new ArrayList<>();

         for(String line: lines){
             MapRow newRow = new MapRow(line);
             rows.add(newRow);
         }

    }

    @Override
    public String toString() {
        return "Map{" +
                "rows=" + rows +
                ", width=" + width +
                ", heigth=" + heigth +
                '}';
    }
}
