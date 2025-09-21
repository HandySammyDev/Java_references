import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayAreaPanel extends JPanel {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public final JLabel[] labels = new JLabel[9];

    private JLabel activeLabel = null;

    private boolean isClicked;
    private boolean oTurn;
    private boolean xTurn;

    // Alignments & sizes
    int scoreX = 0;
    int scoreO = 0;

    double timer = 0.00;

    int scoreBoardWidth = WIDTH/2;
    int scoreBoardHeight = HEIGHT/4;

    public static int scoreBoardO_AlignmentX = (GamePanel.WIDTH/2) + WIDTH/8;
    int scoreBoardO_AlignmentY = (GamePanel.HEIGHT/2) - HEIGHT/2;
    int scoreBoardX_AlignmentX = scoreBoardO_AlignmentX + WIDTH/2;
    int scoreBoardX_AlignmentY = scoreBoardO_AlignmentY;

    int scoreText_AlignmentX = scoreBoardO_AlignmentX;
    int scoreText_AlignmentY = scoreBoardO_AlignmentY - 10;
    int O_Text_AlignmentX = scoreText_AlignmentX + 15;
    int O_Text_AlignmentY = scoreText_AlignmentY * 2 - 5;
    int X_Text_AlignmentX = O_Text_AlignmentX + 250;
    int X_Text_AlignmentY = O_Text_AlignmentY;
    int O_ScorePoints_AlignmentX = O_Text_AlignmentX + 63;
    int O_ScorePoints_AlignmentY = O_Text_AlignmentY;
    int X_ScorePoints_AlignmentX = X_Text_AlignmentX + 55;
    int X_ScorePoints_AlignmentY = X_Text_AlignmentY;

    int timerBoardWidth = scoreBoardWidth * 2;
    int timerBoardHeight = scoreBoardHeight;
    int timerBoard_AlignmentX = scoreBoardO_AlignmentX;
    int timerBoard_AlignmentY = scoreBoardO_AlignmentY + 175;
    int timerText_AlignmentX = timerBoard_AlignmentX + 15;
    int timerText_AlignmentY = timerBoard_AlignmentY + 82;


    public PlayAreaPanel(){
        setLayout(new GridLayout(3,3));
        setBounds((GamePanel.WIDTH/2) - WIDTH, (GamePanel.HEIGHT/2) - HEIGHT/2,
                WIDTH, HEIGHT);
        setBackground(Color.BLUE);
        createLabels();
    }

    public void createLabels(){
        for(int i=0; i<9; i++){
            JLabel label = new JLabel("" + i);
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
        g2.setFont(new Font("Arial", Font.PLAIN, 60));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.drawRect(scoreBoardO_AlignmentX, scoreBoardO_AlignmentY, scoreBoardWidth, scoreBoardHeight);
        g2.drawRect(scoreBoardX_AlignmentX, scoreBoardX_AlignmentY, scoreBoardWidth, scoreBoardHeight);

        g2.drawString("Score:", scoreText_AlignmentX, scoreText_AlignmentY);

        g2.setColor(Color.CYAN);
        g2.drawString("O:", O_Text_AlignmentX, O_Text_AlignmentY);

        g2.setColor(Color.RED);
        g2.drawString("X:", X_Text_AlignmentX, X_Text_AlignmentY);

        g2.setColor(Color.WHITE);
        g2.drawString("" + scoreO, O_ScorePoints_AlignmentX, O_ScorePoints_AlignmentY);
        g2.drawString("" + scoreX, X_ScorePoints_AlignmentX, X_ScorePoints_AlignmentY);

        g2.drawRect(timerBoard_AlignmentX, timerBoard_AlignmentY, timerBoardWidth, timerBoardHeight);
        g2.drawString("Timer: " + timer, timerText_AlignmentX, timerText_AlignmentY);
    }
}