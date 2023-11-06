import javax.swing.*;
import java.awt.*;
import java.util.*;


public class DrawPolygons extends Component{
    //private ArrayList<String> polygonNames;
    //private ArrayList<Point>  centerPoints;
    private ArrayList<Polygon> polygons;

    public DrawPolygons(){
        polygons = new ArrayList<>(10);
        polygons.add(new Polygon("square", new Point(100,100)));
        polygons.add(new Polygon("triangle", new Point(150,150)));
        polygons.add(new Polygon("rectangle", new Point(100,200)));


        /*
        polygonNames = new ArrayList<>(10);
        centerPoints = new ArrayList<>(10);
        polygonNames.add("square");
        polygonNames.add("triangle");
        polygonNames.add("rectangle");
        centerPoints.add(new Point(100,100));
        centerPoints.add(new Point(150,150));
        centerPoints.add(new Point(100,200));
        */
        
    }//constructor

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygons.size(); i++) {
            Polygon currentPolygon = polygons.get(i);
            String currentShape = currentPolygon.name;
            Point currentCenter = currentPolygon.centerPoint;
            if (currentShape.equals("square"))
                g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
            else if (currentShape.equals("triangle")) {
                g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10,
                        currentCenter.y+10);
                g.drawLine(currentCenter.x-10, currentCenter.y+10,
                        currentCenter.x+10, currentCenter.y+10);
                g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x,
                        currentCenter.y-10);
            } else if (currentShape.equals("rectangle"))
                g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);
    }//main
}//DrawPolygons


class Polygon {
    String name;
    Point centerPoint;

    public Polygon(String newName, Point point) {
        name = newName;
        centerPoint = point;
    }
}