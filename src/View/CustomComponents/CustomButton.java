package View.CustomComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class CustomButton extends JButton {

    private Color normalColor;
    private Color hoverColor;
    private Color textColor;
    private Color borderColor;

    public CustomButton(String label, int x, int y, int w, int h) {
        normalColor = new Color(0, 51, 102);
        hoverColor = new Color(0, 102, 204);
        textColor = Color.WHITE;
        borderColor = new Color(0, 51, 102);

        setForeground(textColor);
        setBackground(normalColor);
        setText(label);
        setBounds(x, y, w, h);

        Font font = new Font("Arial", Font.BOLD, 18);
        setFont(font);

        setContentAreaFilled(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(0, 0, getBackground(), 0, getHeight(), getBackground().darker()));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(borderColor);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }
}
