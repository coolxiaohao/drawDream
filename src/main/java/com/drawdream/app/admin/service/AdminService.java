package com.drawdream.app.admin.service;

import com.drawdream.app.admin.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
@Component
public interface AdminService {
    public Admin getAdmin(@Param("id") int id);
}
