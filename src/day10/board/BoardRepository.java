package day10.board;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BoardRepository {
    static Map<Integer, BoardVO> map = new HashMap<>() {{
        for (int i = 1; i < 33; i++) {
             put(i, new BoardVO("test title hihi","gangi","asdsad"));
        }
    }};









}
