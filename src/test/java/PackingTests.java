import Model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackingTests {

    @Test
    public void PackingTest1(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 2, 1, 1));
        Container container = new Container(4,3,3);

        Packing packing = new Packing(boxes, container);
        while(!packing.getBoxes().isEmpty()) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }
        assertEquals(6, packing.getLevels().get(0).getPackedBoxes().size());
        assertEquals(4, packing.getLevels().get(1).getPackedBoxes().size());
                assertEquals(10, packing.CountOfBoxesFit());


    }
    @Test
    public void PackingTest2(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 1, 1, 1));
        Container container = new Container(2,2,3);

        Packing packing = new Packing(boxes, container);
        while(!packing.getBoxes().isEmpty()) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }

        assertEquals(4, packing.getLevels().get(0).getPackedBoxes().size());
        assertEquals(4, packing.getLevels().get(1).getPackedBoxes().size());
        assertEquals(2, packing.getLevels().get(2).getPackedBoxes().size());
        assertEquals(10, packing.CountOfBoxesFit());


    }
    @Test
    public void PackingTest3(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 1, 1, 1));
        Container container = new Container(3,3,2);

        Packing packing = new Packing(boxes, container);
        while(!packing.getBoxes().isEmpty()) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }

        assertEquals(9, packing.getLevels().get(0).getPackedBoxes().size());
        assertEquals(1, packing.getLevels().get(1).getPackedBoxes().size());
        assertEquals(10, packing.CountOfBoxesFit());



    }



    @Test
    public void PackingTest4(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 1, 2, 6));
        boxes.addAll(Box.GenerateBoxes("2", 10, 2, 3, 4));
        Container container = new Container(8,7,15);

        boolean canFit = false;

        Packing packing = new Packing(boxes, container);


        while(!packing.getBoxes().isEmpty()) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }

        assertEquals(20, packing.CountOfBoxesFit());


    }

    @Test
    public void PackingTest5(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 1, 1, 1));
        Container container = new Container(0,0,0);

        Packing packing = new Packing(boxes, container);
        while(!packing.getBoxes().isEmpty()) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }

        assertEquals(0, packing.CountOfBoxesFit());


    }

    @Test
    public void PackingTest6(){
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Box.GenerateBoxes("1", 10, 5, 3, 4));
        boxes.addAll(Box.GenerateBoxes("2", 5, 2, 4, 3));
        Container container = new Container(10,8,4);

        Packing packing = new Packing(boxes, container);
        while(!packing.getBoxes().isEmpty() ) {
            packing.PackLevel();
            if(packing.getLevels().get(packing.getLevels().size()-1).getPackedBoxes().isEmpty()) break;
        }

        assertEquals(7, packing.CountOfBoxesFit());


    }

}
