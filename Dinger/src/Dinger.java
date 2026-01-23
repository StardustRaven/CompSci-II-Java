// Dinger - Time Exists.java
// A 15 minute reminder ding to break hyperfocus

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Dinger {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        Toolkit.getDefaultToolkit().beep();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
                () -> {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("[DING " + LocalTime.now().format(fmt) + "]");
                },
                15, 15, TimeUnit.MINUTES);
        // --- System tray controls (no console) ---
        if (!SystemTray.isSupported()) {
            // If tray isn't supported, there's no good way to quit without a console.
            // Bail out rather than running forever.
            System.exit(1);
        }

        SystemTray tray = SystemTray.getSystemTray();

        // Create a tiny 16x16 icon (no external image file needed)
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.fillOval(3, 3, 10, 10);
        g.dispose();

        PopupMenu menu = new PopupMenu();

        MenuItem undingerItem = new MenuItem("Undinger (Quit)");
        menu.add(undingerItem);

        TrayIcon trayIcon = new TrayIcon(img, "Dinger", menu);
        trayIcon.setImageAutoSize(true);

        // Quit action: stop scheduler, remove icon, exit
        undingerItem.addActionListener(e -> {
            scheduler.shutdown();
            tray.remove(trayIcon);
            System.exit(0);
        });

        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            System.exit(1);
        }
    }
}