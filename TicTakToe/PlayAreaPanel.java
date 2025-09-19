import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayAreaPanel extends JPanel {

    public final int WIDTH = 500;
    public final int HEIGHT = 500;
    public final JLabel[] labels = new JLabel[9];

    private JLabel activeLabel = null;

    private boolean isClicked;
    private boolean oTurn;
    private boolean xTurn;

    public PlayAreaPanel(){
        setLayout(new GridLayout(3,3));
        setBounds((GamePanel.WIDTH/2) - WIDTH, (GamePanel.HEIGHT/2) - HEIGHT/2,
                WIDTH, HEIGHT);
        setBackground(Color.BLUE);
        createLabels();
    }

    public void createLabels(){
        for(int i=0; i<9; i++){
            JLabel label = new JLabel();
            label.setFont(new Font(null, Font.BOLD, 200));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            labels[i] = label;

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    activeLabel = label;
                    System.out.println(label.getText());
                }
            });
            this.add(label);
        }
    }
    public void changeLabel(){

    }
    public void update(){

    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect((GamePanel.WIDTH/2) + WIDTH/3, (GamePanel.HEIGHT/2) - HEIGHT/2,
                WIDTH/2, HEIGHT/2);
    }
}