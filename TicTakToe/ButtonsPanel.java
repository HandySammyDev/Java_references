import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {

    private final int width = PlayAreaPanel.WIDTH;
    private final int height = 125;
    private final int x = PlayAreaPanel.scoreBoardO_AlignmentX;
    private final int y = 485;
    private JButton rematch = new JButton("Rematch");
    private JButton reset = new JButton("reset");

    private int gridRows = 1;
    private int gridCols = 2;
    private int hGap = 4;

    public ButtonsPanel(){
        setBounds(x, y, width, height);
        setBackground(Color.BLACK);
        setLayout(new GridLayout(gridRows, gridCols, hGap, 0));

        rematch.setFont(new Font("Arial", Font.BOLD, 25));
        rematch.setFocusable(false);

        reset.setFont(new Font("Arial", Font.BOLD, 25));
        reset.setFocusable(false);

        add(rematch);
        add(reset);
    }
}
