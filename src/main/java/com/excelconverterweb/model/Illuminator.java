package com.excelconverterweb.model;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
@Entity
@Data
@Getter
@Setter
public class Illuminator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String article;
    private String name;
    private int cost;
    private long costBeforeDiscount;
    private String NDS;
    private String commercialType;
    private long barcode;
    private double weightInPackage;
    private double widthInPackage;
    private double heightInPackage;
    private double lengthInPackage;
    private String urlToMainPic;
    private String urlToOtherPic;
    private String urlTo360Pic;
    private long picArticle;
    private String brand;
    private String modelName;
    private String productColor;
    private String colorName;
    private String colorSwatch;
    private long unitsInOneItem;
    private String numberOfLamps;
    private String maxLampPower;
    private String lightTemperature;
    private String light;
    private String type;
    private String series;
    private String annotation;
    private String Guarantee;
    private String RichContentJSON;
    private String ModelNameForNamingTemplate;
    private String targetAudience;
    private String typeOfLamps;
    private String plinthType;
    private String setWithLightBulbs;
    private long lightingArea;
    private long luminousFlux;
    private String designStyle;
    private String ceilingColor;
    private String ceilingMaterial;
    private String form;
    private String supplyType;
    private long supplyVoltage;
    private String protectionDegree;
    private double length;
    private double width;
    private double height;
    private long foundationWidth;
    private long numberOfModes;
    private String security;
    private String breakerType;
    private String luminaireFeatures;
    private String fastening;
    private String fasteningType;
    private String room;
    private String manufacturerCountry;
    private String equipment;
    private String boxing;
    private long weight;
    private long numberOfFactoryPackages;

    public Illuminator() {
    }

    public Illuminator(List<String> list) {
        this.article = list.get(0).equals("") ? null : list.get(0);
        this.cost = list.get(6).equals("") ? 0 : Integer.parseInt(list.get(6).split("\\.")[0]);
        this.NDS = "Не облагается";
        this.commercialType = list.get(3).equals("") ? null : list.get(3);
        this.weightInPackage = list.get(11).equals("") ? 0 : (Double.parseDouble(list.get(11)) * 1000);
        String[] dimension = list.get(10).split("/").length < 2 ? new String[]{"0", "0", "0"} : list.get(10).split("/");
        this.lengthInPackage = Double.parseDouble(dimension[0]) * 10;
        this.widthInPackage = Double.parseDouble(dimension[1]) * 10;
        this.heightInPackage = Double.parseDouble(dimension[2]) * 10;
        this.urlToMainPic = list.get(8).equals("") ? null : list.get(8);
        this.brand = list.get(16).equals("") ? null : list.get(16);
        this.modelName = list.get(23).equals("") ? null : list.get(23);
        this.type = list.get(1).equals("") ? null : list.get(1);
        this.costBeforeDiscount = list.get(7).equals("") ? 0 : Integer.parseInt(list.get(7).split("\\.")[0]);
        String pic[] = list.get(9).equals("") ? new String[]{" "} : list.get(9).split(";");
        StringBuilder otherPic = new StringBuilder();
        Arrays.stream(pic).forEach(item -> otherPic.append(item + " "));
        this.urlToOtherPic = otherPic.toString();
        this.productColor = list.get(24).equals("") ? null : list.get(24);
        this.colorName = productColor;
        this.unitsInOneItem = 1;
        this.typeOfLamps = list.get(18).contains("LED") ? "Светодиодная" : null;
        this.numberOfLamps = list.get(18).contains("LED") ? "1" : null;
        this.maxLampPower = list.get(30).equals("") ? null : list.get(30).split("W")[0];
        this.name = list.get(12).equals("") ? null : list.get(12);
        this.lightTemperature = list.get(43).equals("") ? null : list.get(43).replace(" ", "")
                .replace("К", "")
                .replace("K", "");
        this.targetAudience = "Взрослая;Детская";
        this.plinthType = list.get(17).equals("") ? null : list.get(17);
        this.setWithLightBulbs = list.get(31).equals("") ? null : list.get(31);
        this.luminousFlux = list.get(44).equals("") ? 0 : Long.parseLong(list.get(44).replace("лм", ""));
        this.ceilingColor = list.get(34).equals("") ? null : list.get(34);
        this.ceilingMaterial = list.get(33).equals("") ? null : list.get(33);
        this.supplyType = list.get(20).equals("") ? null : "От сети " + list.get(20).replace("V", "") + "В";
        this.supplyVoltage = list.get(20).equals("") ? 0 : Long.parseLong(list.get(20).replace("V", ""));
        this.protectionDegree = list.get(27).equals("") ? null : "IP" + list.get(27);
        this.width = list.get(19).equals("") ? 0 : Double.parseDouble(list.get(19).replace("мм", ""));
        this.length = list.get(26).equals("") ? 0 : Double.parseDouble(list.get(26).replace("мм", ""));
        this.height = list.get(25).equals("") ? 0 : Double.parseDouble(list.get(25).replace("мм", ""));
        this.security = "Без защиты";
        this.fastening = "На планку";
        this.fasteningType = "Планка";
        this.equipment = list.get(3).equals("") ? null : list.get(3);
        this.boxing = "Картонная";
    }


    public Illuminator(String article, String name, int cost, long costBeforeDiscount, String NDS, String commercialType, long barcode, double weightInPackage, double widthInPackage, double heightInPackage, double lengthInPackage, String urlToMainPic, String urlToOtherPic, String urlTo360Pic, long picArticle, String brand, String modelName, String productColor, String colorName, String colorSwatch, long unitsInOneItem, String numberOfLamps, String maxLampPower, String lightTemperature, String light, String type, String series, String annotation, String guarantee, String richContentJSON, String modelNameForNamingTemplate, String targetAudience, String typeOfLamps, String plinthType, String setWithLightBulbs, long lightingArea, long luminousFlux, String designStyle, String ceilingColor, String ceilingMaterial, String form, String supplyType, long supplyVoltage, String protectionDegree, double length, double width, double height, long foundationWidth, long numberOfModes, String security, String breakerType, String luminaireFeatures, String fastening, String fasteningType, String room, String manufacturerCountry, String equipment, String boxing, long weight, long numberOfFactoryPackages) {
        this.article = article;
        this.name = name;
        this.cost = cost;
        this.costBeforeDiscount = costBeforeDiscount;
        this.NDS = NDS;
        this.commercialType = commercialType;
        this.barcode = barcode;
        this.weightInPackage = weightInPackage;
        this.widthInPackage = widthInPackage;
        this.heightInPackage = heightInPackage;
        this.lengthInPackage = lengthInPackage;
        this.urlToMainPic = urlToMainPic;
        this.urlToOtherPic = urlToOtherPic;
        this.urlTo360Pic = urlTo360Pic;
        this.picArticle = picArticle;
        this.brand = brand;
        this.modelName = modelName;
        this.productColor = productColor;
        this.colorName = colorName;
        this.colorSwatch = colorSwatch;
        this.unitsInOneItem = unitsInOneItem;
        this.numberOfLamps = numberOfLamps;
        this.maxLampPower = maxLampPower;
        this.lightTemperature = lightTemperature;
        this.light = light;
        this.type = type;
        this.series = series;
        this.annotation = annotation;
        Guarantee = guarantee;
        RichContentJSON = richContentJSON;
        ModelNameForNamingTemplate = modelNameForNamingTemplate;
        this.targetAudience = targetAudience;
        this.typeOfLamps = typeOfLamps;
        this.plinthType = plinthType;
        this.setWithLightBulbs = setWithLightBulbs;
        this.lightingArea = lightingArea;
        this.luminousFlux = luminousFlux;
        this.designStyle = designStyle;
        this.ceilingColor = ceilingColor;
        this.ceilingMaterial = ceilingMaterial;
        this.form = form;
        this.supplyType = supplyType;
        this.supplyVoltage = supplyVoltage;
        this.protectionDegree = protectionDegree;
        this.length = length;
        this.width = width;
        this.height = height;
        this.foundationWidth = foundationWidth;
        this.numberOfModes = numberOfModes;
        this.security = security;
        this.breakerType = breakerType;
        this.luminaireFeatures = luminaireFeatures;
        this.fastening = fastening;
        this.fasteningType = fasteningType;
        this.room = room;
        this.manufacturerCountry = manufacturerCountry;
        this.equipment = equipment;
        this.boxing = boxing;
        this.weight = weight;
        this.numberOfFactoryPackages = numberOfFactoryPackages;
    }
}