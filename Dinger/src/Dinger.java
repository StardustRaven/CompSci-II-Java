// Dinger - Time Exists.java
// A 15 minute reminder ding to break hyperfocus
// Custom sound version (KittyCat.wav)

import java.util.concurrent.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.sound.sampled.*;
import java.io.File;

import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;

public class Dinger {

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private static FileLock lock;
    private static FileChannel lockChannel;

    // =============================
    // Prevent multiple instances
    // =============================
    private static void ensureSingleInstance() {
        try {
            Path lockPath = Paths.get(
                    System.getProperty("user.home"),
                    ".dinger.lock"
            );

            lockChannel = FileChannel.open(lockPath,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);

            lock = lockChannel.tryLock();

            if (lock == null) {
                System.exit(0);
            }

        } catch (Exception e) {
            System.exit(1);
        }
    }

    // =============================
    // Custom sound playback
    // =============================
    private static void playSound() {
        try {
            File soundFile = new File(
                    System.getProperty("user.dir"),
                    "KittyCat.wav"
            );

            if (!soundFile.exists()) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            try (AudioInputStream audioStream =
                         AudioSystem.getAudioInputStream(soundFile)) {

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.setFramePosition(0);
                clip.start();

                // Auto close after playing
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
            }

        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    // =============================
    // Main Program
    // =============================
    public static void main(String[] args) {

        ensureSingleInstance();

        if (!SystemTray.isSupported()) {
            System.exit(1);
        }

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor(r -> {
                    Thread t = new Thread(r, "dinger-scheduler");
                    t.setDaemon(true);
                    t.setPriority(Thread.MIN_PRIORITY);
                    return t;
                });

        SystemTray tray = SystemTray.getSystemTray();
        TrayIcon trayIcon = createTrayIcon();

        PopupMenu menu = new PopupMenu();
        MenuItem quitItem = new MenuItem("Undinger (Quit)");
        menu.add(quitItem);
        trayIcon.setPopupMenu(menu);

        quitItem.addActionListener(e -> {
            scheduler.shutdownNow();
            tray.remove(trayIcon);
            System.exit(0);
        });

        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            System.exit(1);
        }

        // ===== 15 minute ding =====
        scheduler.scheduleAtFixedRate(() -> {
            playSound();
            trayIcon.displayMessage(
                    "Dinger",
                    "Ding! " + LocalTime.now().format(FMT),
                    TrayIcon.MessageType.NONE
            );
        }, 15, 15, TimeUnit.MINUTES);
    }

    // =============================
    // Tray Icon
    // =============================
    private static TrayIcon createTrayIcon() {

        BufferedImage img =
                new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = img.createGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g.setColor(Color.RED);
        g.fillOval(3, 3, 10, 10);
        g.dispose();

        TrayIcon trayIcon = new TrayIcon(img, "Dinger");
        trayIcon.setImageAutoSize(true);
        return trayIcon;
    }
}
