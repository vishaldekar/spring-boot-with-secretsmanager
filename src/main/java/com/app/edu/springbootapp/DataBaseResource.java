package com.app.edu.springbootapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1.0")
public class DataBaseResource {

    DataSource dataSource;

    private static final String CONNECTION = "connection";

    public DataBaseResource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @GetMapping
    public ResponseEntity<?> getDatabaseDetails() throws SQLException {
        Map<String,String> map = new HashMap<>();
        map.put(CONNECTION, dataSource.getConnection().getMetaData().getURL());
        return ResponseEntity.ok(map);
    }

}
