package com.kev.RestAPI.admin;

import com.kev.RestAPI.factory.DTOFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/admin")
@Validated

public class AdminController {

    private final AdminService adminService;
    private final DTOFactory dtoFactory;

    @PostMapping(path = "/login")
    public AdminDTO checkCredentials(@Valid @RequestBody AdminCheckCredentialsDTO creds)
    {
        return dtoFactory.createDTO(adminService.checkCredentials(creds));
    }




}
