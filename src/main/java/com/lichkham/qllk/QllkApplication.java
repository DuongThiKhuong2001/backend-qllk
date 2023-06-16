package com.lichkham.qllk;

import com.lichkham.qllk.entity.QuyenEnum;
import com.lichkham.qllk.entity.User;
import com.lichkham.qllk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class QllkApplication implements ApplicationListener<ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(QllkApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createAdminUser();
    }

    private void createAdminUser() {
        if (!userRepository.existsByTaiKhoan("admin")) {
        User adminUser = new User();
        adminUser.setTaiKhoan("admin");
        adminUser.setMatKhau( encoder.encode("123456"));
        adminUser.setEmail("admin@example.com");
        adminUser.setQuyen(QuyenEnum.ADMIN);
        userRepository.save(adminUser);}
    }
}
