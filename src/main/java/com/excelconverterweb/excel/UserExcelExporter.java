package com.excelconverterweb.excel;


import com.excelconverterweb.model.Illuminator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserExcelExporter {


    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Illuminator> illuminatorList;

    public UserExcelExporter(List<Illuminator> illuminatorList) {
        this.illuminatorList = illuminatorList;
        try (FileInputStream fis = new FileInputStream("D:\\Java\\Projects\\ExcelConverterWeb\\src\\main\\resources\\finalfile\\final.xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet  = workbook.getSheetAt(1);
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
            createCell(row, columnCount++, illuminator.getNumber(), style);
            createCell(row, columnCount++, illuminator.getArticle(), style);
            createCell(row, columnCount++, illuminator.getName(), style);
            ///////Тут добавить остальные колнки и все такое

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
