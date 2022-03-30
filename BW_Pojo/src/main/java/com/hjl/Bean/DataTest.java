package com.hjl.Bean;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTest implements Serializable {

    private Integer id;

    private String name;

    private String pwd;

    private Date createTime;
}