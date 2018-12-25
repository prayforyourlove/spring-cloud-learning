package com.dzsw.wqh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user")
@Data
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_name")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Column(name = "pass_word")
    @NotBlank(message = "密码不能为空")
    private String passWord;

    @Size(min=6 ,max= 20 ,message = "手机号码长度不符合标准")
    private String mobile;

    private String sex;

    private Integer age;

    @Email
    private String email;

    @Column(name = "insert_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;

    @Column(name = "update_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}