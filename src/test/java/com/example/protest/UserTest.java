package com.example.protest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    @Sql("/data-test.sql")
   // @Sql(scripts ="classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void PageRequestTest() {
       // Pageable pageable = PageRequest.of(1,2);
        PageRequest pg = PageRequest.of(0,3);
        Page<UserDes> userDesList =  userRepo.findAll(pg);
        System.out.println(userDesList.getContent());

    }
    @Test
    @Sql("/data-test.sql")
    // @Sql(scripts ="classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void CriteriaRequestTest() {
        Specification<UserDes> specification = Specification.where(null);
        specification = specification.and((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("firstName"),"%"+"value"+"%");
        });
        System.out.println(userRepo.findAll(specification));

    }

    @Test
    @Sql("/data-test.sql")
    // @Sql(scripts ="classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void CriteriaRequestAndPageRequestTest() {
         Specification<UserDes> specification = Specification.where(null);
        specification = specification.and((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("firstName"),"%"+"value3"+"%");
        });

        specification = specification.or((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("firstName"),"%"+"value5"+"%");
        });

        PageRequest pg = PageRequest.of(0,10);
        System.out.println(userRepo.findAll(specification,pg).getContent());

    }

    @Test
    @Sql("/data-test.sql")
    // @Sql(scripts ="classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void  ExCellTest() {
        try {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Hello Sheet");
        XSSFRow row = sheet.createRow((short)0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Hello Excel.");

            FileOutputStream out = new FileOutputStream("C:\\poi\\HelloExcel.xlsx");
            wb.write(out);
           // wb.close();
            out.close();


  
            System.out.println("Excel created successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


}
