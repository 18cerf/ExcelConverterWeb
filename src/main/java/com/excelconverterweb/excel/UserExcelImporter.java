package com.excelconverterweb.excel;

import com.excelconverterweb.model.Illuminator;
import com.excelconverterweb.repository.IlluminatorRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExcelImporter {
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private Map<Integer, List<String>> data;

    private IlluminatorRepository illuminatorRepository;
    List<Illuminator> illuminatorList;

//    public UserExcelImporter(String filepath) {
//        OPCPackage pkg = null;
//        try {
//            pkg = OPCPackage.open(new File(filepath));
//            wb = new XSSFWorkbook(pkg);
//            wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//            pkg.close();
//        } catch (InvalidFormatException | IOException e) {
//            e.printStackTrace();
//        }
//
//    }
public UserExcelImporter(File file) {
    try {
        wb = new XSSFWorkbook(file);
        wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
    } catch (InvalidFormatException | IOException e) {
        e.printStackTrace();
    }

}

    public void getData() {
        sheet = wb.getSheetAt(0);
        data = new HashMap<>();
        int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();
        int i = 0;
        for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
            data.put(i, new ArrayList<String>());
            Row r = sheet.getRow(rowNum);
            int lastCol = r.getLastCellNum();
            for (int numCol = 0; numCol < lastCol; numCol++) {
                Cell c = r.getCell(numCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (c == null) {
                    c.setCellValue("");
                }
                switch (c.getCellType()) {
                    case STRING:
                        data.get(i).add(c.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(c)) {
                            data.get(i).add(c.getDateCellValue() + "");
                        } else {
                            data.get(i).add(c.getNumericCellValue() + "");
                        }
                        break;
                    case BOOLEAN:
                        data.get(i).add(c.getBooleanCellValue() + "");
                        break;
                    case FORMULA:
                        data.get(i).add(c.getCellFormula() + "");
                        break;
                    default:
                        data.get(i).add("");
                }
            }
            i++;
        }
    }

    public void setData() {
        getData();
        illuminatorList = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            illuminatorList.add(new Illuminator(data.get(i)));
        }
        illuminatorRepository.saveAll(illuminatorList);
        deleteData();
    }

    public void deleteData() {
        data = null;
        illuminatorList = null;
    }
}