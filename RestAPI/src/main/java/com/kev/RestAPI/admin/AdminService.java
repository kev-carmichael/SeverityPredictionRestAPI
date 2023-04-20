package com.kev.RestAPI.admin;

import com.kev.RestAPI.entity.Admin;
import com.kev.RestAPI.util.StringHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final StringHasher stringHasher;

    public Admin checkCredentials(AdminCheckCredentialsDTO creds) {
        Admin admin = adminRepository.findByEmail(creds.getEmail());

        if (admin != null && admin.getPassword().equals(creds.getPassword())) {
            String token =
                    stringHasher.hashString(
                            admin.getEmail() + ":" + LocalDateTime.now());
            admin.setToken(token);
            admin = adminRepository.save(admin);
            return admin;
        }
        return null;
    }


}
