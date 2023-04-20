package com.kev.RestAPI.admin;

import com.kev.RestAPI.util.StringHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository staffRepository;
    private final StringHasher stringHasher;


}
