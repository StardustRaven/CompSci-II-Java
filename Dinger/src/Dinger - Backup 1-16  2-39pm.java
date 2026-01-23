// Dinger - Time Exists.java
// A 15 minute reminder ding to break hyperfocus

import java.awt.Toolkit;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dinger {
    public static void main(String[] args) {
        System.out.println("Dinger started. Ding now, then every 15 minutes.");
        System.out.println("Type 'undinger' and Press Enter to stop.");

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

        Toolkit.getDefaultToolkit().beep();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
                () -> {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("[DING " + LocalTime.now().format(fmt) + "]");
        },
                10, 10, TimeUnit.SECONDS);
        Scanner input = new Scanner(System.in);
        while (true) {
            String cmd = input.nextLine().trim().toLowerCase();
            if (cmd.equals("undinger")) {
                break;
            }
        }
        scheduler.shutdown();
        input.close();
        System.out.println("Dinger stopped.");

    }
}