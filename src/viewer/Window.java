package viewer;

import ImageInterpreter.ImagemHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class Window extends JFrame {
    public HashMap<Integer, ImageIcon> frames = new HashMap<>();
    public Timer timer;
    public int index;

    public Window(String title, int X, int Y, ImagemHandler imagemHandler, int frameSize, int delaySpeed) {
        setup(title, X, Y);
        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
        JLabel ImgOriginal = loadImage(imagemHandler.getFilePath(), 300);
        JLabel ImgAnimationResult = loadFramesAnimation(imagemHandler.getFileCopyPath(), 300, frameSize);
        JLabel arrow = loadImage("assets/Arrow.png", 300);
        panel.add(ImgOriginal);
        panel.add(arrow);
        panel.add(ImgAnimationResult);
        add(panel);
        timer = new Timer(delaySpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == frames.size()-1) {
                    ImgAnimationResult.setIcon(frames.get(frames.size()-1));
                    ((Timer) e.getSource()).stop();
                    return;
                }
                index = (index + 1) % frames.size();
                ImgAnimationResult.setIcon(frames.get(index));
            }
        });
        timer.start();
        setVisible(true);
    }
    public void setup(String title, int X, int Y) {
        HashMap<String, Integer> size = new HashMap<>();
        size.put("X", X);
        size.put("Y", Y);
        setTitle(title);
        setSize(size.get("X"), size.get("Y"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("assets/Icon.png");
        setIconImage(img.getImage());
    }
    public JLabel loadImage(String imagePath, int reScale) {
        ImageIcon image = new ImageIcon(imagePath);
        Image img = image.getImage().getScaledInstance(reScale, reScale, Image.SCALE_FAST);
        ImageIcon imgReScaled = new ImageIcon(img);
        return new JLabel(imgReScaled);
    }
    public JLabel loadFramesAnimation(String framesPath, int reScale, int frameSize) {
        for (int i = 0; i-1 < frameSize; i++) {
            ImageIcon frame = new ImageIcon(
                    new ImageIcon(
                            String.format(
                                    framesPath.replace(
                                            ".png",
                                            ""
                                    )+"_%02d.png",i
                            )
                    ).getImage().getScaledInstance(
                            reScale,
                            reScale,
                            Image.SCALE_FAST
                    )
            );
            frames.put(i, frame);
        }
        return new JLabel(frames.get(0));
    }
}
