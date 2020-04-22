import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        final Level VIOLATION = Level.forName("VIOLATION", 150); // szint a karantén szabályok megsértésének naplózásához(fatal)
        final Level REQUEST = Level.forName("REQUEST", 350); // szint kérelmek naplózásához(warn)
        int n=Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++) {
            logger.log(VIOLATION, "Zöld erdőben jártam,");
            logger.info("Kék ibolyát láttam,");
            logger.warn("El akart hervadni,");
            logger.log(REQUEST, "Szabad-e locsolni?");
            try {
                Thread.sleep(10); // egy kis késleltetés
            } catch (InterruptedException e) {}
        }
    }
}
