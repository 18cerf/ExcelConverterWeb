package com.excelconverterweb.excel;


import com.excelconverterweb.model.Illuminator;
import com.excelconverterweb.repository.IlluminatorRepository;
import com.excelconverterweb.service.DateService;
import com.excelconverterweb.service.FileSystemStorageService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UserExcelExporter {


    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    FileSystemStorageService fileSystemStorageService;

    private IlluminatorRepository illuminatorRepository;

    private List<Illuminator> illuminatorList;

    public UserExcelExporter() {
        this.illuminatorList = (List<Illuminator>) illuminatorRepository.findAll();
        try (FileInputStream fis = new FileInputStream("D:\\Java\\Projects\\ExcelConverterWeb\\src\\main\\resources\\finalfile\\final.xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeDataLines();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet = workbook.getSheetAt(1);
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 4;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Illuminator illuminator : illuminatorList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, illuminator.getId(), style);
            createCell(row, columnCount++, illuminator.getArticle(), style);
            createCell(row, columnCount++, illuminator.getName(), style);
            createCell(row, columnCount++, illuminator.getCost(), style);
            createCell(row, columnCount++, illuminator.getCostBeforeDiscount(), style);
            createCell(row, columnCount++, illuminator.getNDS(), style);
            createCell(row, columnCount++, illuminator.getCommercialType(), style);
            createCell(row, columnCount++, illuminator.getBarcode(), style);
            createCell(row, columnCount++, illuminator.getWeightInPackage(), style);
            createCell(row, columnCount++, illuminator.getWidthInPackage(), style);
            createCell(row, columnCount++, illuminator.getHeightInPackage(), style);
            createCell(row, columnCount++, illuminator.getLengthInPackage(), style);
            createCell(row, columnCount++, illuminator.getUrlToMainPic(), style);
            createCell(row, columnCount++, illuminator.getUrlToOtherPic(), style);
            createCell(row, columnCount++, illuminator.getUrlTo360Pic(), style);
            createCell(row, columnCount++, illuminator.getPicArticle(), style);
            createCell(row, columnCount++, illuminator.getBrand(), style);
            createCell(row, columnCount++, illuminator.getModelName(), style);
            createCell(row, columnCount++, illuminator.getProductColor(), style);
            createCell(row, columnCount++, illuminator.getColorName(), style);
            createCell(row, columnCount++, illuminator.getColorSwatch(), style);
            createCell(row, columnCount++, illuminator.getUnitsInOneItem(), style);
            createCell(row, columnCount++, illuminator.getNumberOfLamps(), style);
            createCell(row, columnCount++, illuminator.getMaxLampPower(), style);
            createCell(row, columnCount++, illuminator.getLightTemperature(), style);
            createCell(row, columnCount++, illuminator.getLight(), style);
            createCell(row, columnCount++, illuminator.getType(), style);
            createCell(row, columnCount++, illuminator.getSeries(), style);
            createCell(row, columnCount++, illuminator.getAnnotation(), style);
            createCell(row, columnCount++, illuminator.getArticle(), style);
            createCell(row, columnCount++, illuminator.getGuarantee(), style);
            createCell(row, columnCount++, illuminator.getRichContentJSON(), style);
            createCell(row, columnCount++, illuminator.getModelNameForNamingTemplate(), style);
            createCell(row, columnCount++, illuminator.getTargetAudience(), style);
            createCell(row, columnCount++, illuminator.getTypeOfLamps(), style);
            createCell(row, columnCount++, illuminator.getPlinthType(), style);
            createCell(row, columnCount++, illuminator.getSetWithLightBulbs(), style);
            createCell(row, columnCount++, illuminator.getLightingArea(), style);
            createCell(row, columnCount++, illuminator.getLuminousFlux(), style);
            createCell(row, columnCount++, illuminator.getDesignStyle(), style);
            createCell(row, columnCount++, illuminator.getCeilingMaterial(), style);
            createCell(row, columnCount++, illuminator.getForm(), style);
            createCell(row, columnCount++, illuminator.getSupplyType(), style);
            createCell(row, columnCount++, illuminator.getSupplyVoltage(), style);
            createCell(row, columnCount++, illuminator.getProtectionDegree(), style);
            createCell(row, columnCount++, illuminator.getLength(), style);
            createCell(row, columnCount++, illuminator.getWidth(), style);
            createCell(row, columnCount++, illuminator.getHeight(), style);
            createCell(row, columnCount++, illuminator.getFoundationWidth(), style);
            createCell(row, columnCount++, illuminator.getNumberOfModes(), style);
            createCell(row, columnCount++, illuminator.getSecurity(), style);
            createCell(row, columnCount++, illuminator.getBreakerType(), style);
            createCell(row, columnCount++, illuminator.getLuminaireFeatures(), style);
            createCell(row, columnCount++, illuminator.getFastening(), style);
            createCell(row, columnCount++, illuminator.getFasteningType(), style);
            createCell(row, columnCount++, illuminator.getRoom(), style);
            createCell(row, columnCount++, illuminator.getManufacturerCountry(), style);
            createCell(row, columnCount++, illuminator.getEquipment(), style);
            createCell(row, columnCount++, illuminator.getBoxing(), style);
            createCell(row, columnCount++, illuminator.getWeight(), style);
            createCell(row, columnCount++, illuminator.getNumberOfFactoryPackages(), style);
        }
    }

    public File sendExcelFile() {
        String fileName = "final.xlsx";
        File file = new File(fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return file;
    }
}
