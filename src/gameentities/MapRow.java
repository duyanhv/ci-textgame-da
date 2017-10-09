package gameentities;

import bases.events.EventManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by duyanh on 10/7/17.
 *
 * Luu tru toan bo  thong tin cua cells
 * class nay dai dien cho 1 hang
 */
public class MapRow {
    private Map map;
    public String[] cells;
//    public int[] coordinateX = new int[100];

    public MapRow(String line){
        this.cells = line.split("");

    }
    public String getCell(int x){
        return cells[x];
    }

    @Override
    public String toString() {
        return "MapRow{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }

    public void pushUI() {
        for(String cell: cells){
            if(cell.equalsIgnoreCase("/"))
            {
                EventManager.pushUIMessage(" "+ "X"+" ");
            }else{
                EventManager.pushUIMessage(" "+cell+ " ");
            }

        }
    }



//    public void checkWall(int coordinateX[]){
//        for(int xWall = 0; xWall < cells.length; xWall++){
//            if(cells[xWall].equalsIgnoreCase(("/"))){
//                for(int x = 0; x < coordinateX.length; x++ ){
//                    coordinateX[x] = xWall;
//                }
//            }
//        }
//
//    }



    public int findPlayerXAndReplace() {
        for(int x = 0; x<cells.length; x++){
            if(cells[x].equalsIgnoreCase("@")){
                cells[x]= " ";
                return x;
            }
        }
        return -1;
    }
}
