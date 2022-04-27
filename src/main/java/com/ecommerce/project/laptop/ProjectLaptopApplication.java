package com.ecommerce.project.laptop;

import com.ecommerce.project.laptop.common.ERole;
import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Banner;
import com.ecommerce.project.laptop.entitty.Product;
import com.ecommerce.project.laptop.entitty.Role;
import com.ecommerce.project.laptop.reponsitory.AccountReponsitory;
import com.ecommerce.project.laptop.reponsitory.BannerReponsitory;
import com.ecommerce.project.laptop.reponsitory.ProductReponsitory;
import com.ecommerce.project.laptop.services.BannerServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Log4j2
public class ProjectLaptopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectLaptopApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    @Bean
    CommandLineRunner run(BannerReponsitory b, ProductReponsitory productReponsitory, AccountReponsitory accountReponsitory) { return args->{
        List<Banner> list = new ArrayList<>();
        Banner banner1 = Banner.builder().
                name("33").id(1l).link_images("").theme_title("").title_price("fff").slogan("").
                build();
        Banner banner2 = Banner.builder().
                name("33").id(2l).link_images("").theme_title("").title_price("fff").slogan("").
                build();
        Banner banner3 = Banner.builder().
                name("33").id(3l).link_images("").theme_title("").title_price("fff").slogan("").
                build();
        Banner banner4 = Banner.builder().
                name("33").id(4l).link_images("").theme_title("").title_price("fff").slogan("").
                build();
        list.add(banner1);list.add(banner2);list.add(banner3);list.add(banner4);
        b.saveAll(list);
        Account account=Account.builder()
                .email("admin@gmail.com")
                .password("$2a$10$.h89l9FpfjzkzXAHSzuf4O6NV3llr7RH0aBupBjnNe2ypXd9Cak1q")
                .build();
       // accountReponsitory.save(account);
        Product product =new Product(1l,"dđ","add",1,1,null,33,null,null,null,null,null,null,null,null);

        productReponsitory.save(product);
    };

}

}
