package com.wy.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wy.upms.*.mapper")
public class WyUpmsApplication {

    public static void main(String[] args) {
        //关闭热部署
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(WyUpmsApplication.class, args);
        System.out.println("   (♥◠‿◠)ﾉﾞ        ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |  upms \\  _. /  '       \n" +
                " |(_ o _) / 启动成功 _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

}
