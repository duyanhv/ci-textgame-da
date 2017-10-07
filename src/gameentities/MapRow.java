package gameentities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by duyanh on 10/7/17.
 *
 * Luu tru toan bo  thong tin cua cells
 * class nay dai dien cho 1 hang
 */
public class MapRow {
    public String[] cells;

    public MapRow(String line){
        this.cells = line.split(" ");

    }

    @Override
    public String toString() {
        return "MapRow{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}
