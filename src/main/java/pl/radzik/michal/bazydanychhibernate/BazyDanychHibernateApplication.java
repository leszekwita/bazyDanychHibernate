package pl.radzik.michal.bazydanychhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BazyDanychHibernateApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(BazyDanychHibernateApplication.class, args);


    }

    public static class Scheduler {
        @Scheduled(cron ="0 */30 * ? * *")
        public static void cronJobSch() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
            String strDate = sdf.format(now);
            System.out.println("Java cron job expression:: " + strDate);
        }
    }
}


