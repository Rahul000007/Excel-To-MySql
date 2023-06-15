package com.example.excelmysql.helper;

import com.example.excelmysql.entity.Employee;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dumping {
    public static List<Employee> excelToList(InputStream input) {
        List<Employee> list = new ArrayList<>();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(input);
            HSSFSheet sheet = workbook.getSheet("data");
            Iterator<Row> iterator = sheet.iterator();

            int rowNumber = 0;

            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 0;
                Employee e = new Employee();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0 -> e.setEmployeeID(cell.getStringCellValue());
                        case 1 -> e.setFullName(cell.getStringCellValue());
                        case 2 -> e.setJobTitle(cell.getStringCellValue());
                        case 3 -> e.setDepartment(cell.getStringCellValue());
                        case 4 -> e.setBusinessUnit(cell.getStringCellValue());
                        case 5 -> e.setGender(cell.getStringCellValue());
                        case 6 -> e.setEthnicity(cell.getStringCellValue());
                        case 7 -> e.setAge((int) cell.getNumericCellValue());
                        case 8 -> e.setHireDate(String.valueOf(cell.getDateCellValue()));
                        case 9 -> e.setAnnualSalary(String.valueOf(cell.getNumericCellValue()));
                        case 10 -> e.setBonus(String.valueOf(cell.getNumericCellValue()));
                        case 11 -> e.setCountry(cell.getStringCellValue());
                        case 12 -> e.setCity(cell.getStringCellValue());
                        case 13 -> {
                            if (cell.getCellType() == CellType.STRING) {
                                e.setExitDate((cell.getStringCellValue()));
                            } else {
                                e.setExitDate(String.valueOf(cell.getDateCellValue()));
                            }
                        }
                        default -> {
                        }
                    }
                    cid++;
                }
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
