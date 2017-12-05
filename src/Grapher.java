import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * See main method for examples of using "graph" and "display" methods.
 * Notes: (1) "graph" must be called for all data before "display".
 * (2) import java.awt.* to use the Color class in other programs.
 *
 * @author1 Ian Waldschmidt
 * @author2 Cormac Dacker cxd289
 */
public class Grapher extends JPanel {
    private JFrame f = new JFrame();
    private ArrayList<int[]> xdatas = new ArrayList<>();
    private ArrayList<int[]> ydatas = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();

    public static void main(String[] args) {
        Grapher grapher = new Grapher(); // Create single Grapher for all lines

        // 1st line data
        int[] xdata1 = {2, 4, 6, 8, 10};
        int[] ydata1 = {100, 200, 300, 400, 500};
        grapher.graph(xdata1, ydata1, Color.BLUE);

        // 2nd line data
        int[] xdata2 = {5, 10, 15, 20};
        int[] ydata2 = {50, 100, 500, 1000};
        grapher.graph(xdata2, ydata2, Color.RED);

        // 3rd line data
        int[] xdata3 = {1, 2, 3, 4, 5};
        int[] ydata3 = {500, 550, 600, 650, 700};
        grapher.graph(xdata3, ydata3, Color.GREEN);

        grapher.display(""); // Display all lines when ready
    }

    void graph(int[] ydata, int[] xdata, Color color) {
        if (xdata.length != ydata.length) {
            System.out.println("Input arrays must be the same length");
            return;
        }

        this.xdatas.add(xdata);
        this.ydatas.add(ydata);
        this.colors.add(color);
    }

    void display(String title) {
        f.add(this);
        f.setSize(800, 800);
        f.setLocation(200, 200);
        f.setTitle(title);
        f.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        //Draw ordinate
        int PAD = 30;
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h - PAD));
        //Draw abcissa
        g2.draw(new Line2D.Double(PAD, h - PAD, w - PAD, h - PAD));
        //Draw labels
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        //Write x axis values
        double[] xaxis = new double[5];
        xaxis[0] = 0;
        xaxis[4] = getMax(xdatas);
        xaxis[1] = xaxis[4] / 4;
        xaxis[2] = xaxis[4] / 2;
        xaxis[3] = xaxis[1] * 3;
        int xcoord = PAD - 4;
        int ycoord = h - (PAD / 4);
        for (int i = 0; i < 5; i++) {
            DecimalFormat form = new DecimalFormat("0.#");
            String value = form.format(xaxis[i]) + "";
            g2.drawString(value, xcoord, ycoord);
            xcoord += (w - 2 * PAD) / 5 + font.getStringBounds(value, frc).getWidth();
        }
        //Write y axis values
        double[] yaxis = new double[5];
        yaxis[0] = 0;
        yaxis[4] = getMax(ydatas);
        yaxis[1] = yaxis[4] / 4;
        yaxis[2] = yaxis[4] / 2;
        yaxis[3] = yaxis[1] * 3;
        xcoord = PAD / 4;
        ycoord = h - PAD + 4;
        for (int i = 0; i < 5; i++) {
            DecimalFormat form = new DecimalFormat("0.#");
            String value = form.format(yaxis[i]) + "";
            g2.drawString(value, xcoord, ycoord);
            ycoord -= (h - 2 * PAD) / 5 + font.getStringBounds(value, frc).getHeight();
        }
        //Draw data
        double xScale = (double) (w - 2 * PAD) / getMax(xdatas);
        double yScale = (double) (h - 2 * PAD) / getMax(ydatas);
        for (int j = 0; j < xdatas.size(); j++) {
            int[] xdata = this.xdatas.get(j);
            int[] ydata = this.ydatas.get(j);
            Color color = this.colors.get(j);
            //Draw lines for each data set
            g2.setPaint(color);
            for (int i = 0; i < xdata.length - 1; i++) {
                double x1 = PAD + xScale * xdata[i];
                double y1 = h - PAD - yScale * ydata[i];
                double x2 = PAD + xScale * xdata[i + 1];
                double y2 = h - PAD - yScale * ydata[i + 1];
                g2.draw(new Line2D.Double(x1, y1, x2, y2));
            }
            //Draw points for each data set
            g2.setPaint(color);
            for (int i = 0; i < xdata.length; i++) {
                double x = PAD + xScale * xdata[i];
                double y = h - PAD - yScale * ydata[i];
                g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
            }
        }
    }

    private int getMax(ArrayList<int[]> data) {
        int max = -Integer.MAX_VALUE;
        for (int[] aData : data) {
            for (int anAData : aData) {
                if (anAData > max) {
                    max = anAData;
                }
            }
        }
        return max;
    }
}