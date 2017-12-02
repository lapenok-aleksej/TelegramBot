package ru.ifmo.services.game.tictactoe;

import ru.ifmo.telegram.bot.entity.Player;
import ru.ifmo.telegram.bot.services.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cawa on 02.12.2017.
 */
public class Board {
    //(1,1) - top left
    private List<List<Tile>> tiles;

    boolean makeTurn(int x, int y, int sign) {
        if ((x < 1) || (x > 3) || (y < 1) || (y > 3)) {
            return false;
        }
        return tiles.get(x - 1).get(y - 1).makeTurn(sign);
    }

    void clear() {
        for (List<Tile> list:tiles) {
            for (Tile tile : list) {
                tile.clear();
            }
        }
    }

    boolean hasThreeInARow() {
        // lines
        for (int i = 0; i < 3; i++) {
            Tile t = tiles.get(0).get(i);
            boolean found = true;
            for (int j = 1; j < 3; j++) {
                found &= t.equals(tiles.get(j).get(i));
            }
            if (found) {
                return true;
            }
        }
        // rows
        for (int i = 0; i < 3; i++) {
            Tile t = tiles.get(i).get(0);
            boolean found = true;
            for (int j = 1; j < 3; j++) {
                found &= t.equals(tiles.get(i).get(j));
            }
            if (found) {
                return true;
            }
        }
        // diag
        Tile t = tiles.get(1).get(1);
        if (t.equals(tiles.get(0).get(0)) && t.equals(tiles.get(2).get(2))) {
            return true;
        }
        if (t.equals(tiles.get(0).get(2)) && t.equals(tiles.get(2).get(0))) {
            return true;
        }
        return false;
    }

    Board() {
        tiles = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            tiles.add(new ArrayList<>(3));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Tile> list:tiles) {
            for (Tile tile : list) {
                sb.append(tile.toString());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
