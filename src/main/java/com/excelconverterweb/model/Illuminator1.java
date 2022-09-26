package com.excelconverterweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Illuminator1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;
    private String article;
    private String name;
    private long cost;
    private long costBeforeDiscount;
    private String NDS;
    private String commercialType;
    private long barcode;
    private long weightInPackage;
    private long widthInPackage;
    private long heightInPackage;
    private long lengthInPackage;
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
    private long numberOfLamps;
    private long maxLampPower;
    private long lightTemperature;
    private String light;
    private String type;
    private String series;
    private String annotation;
    private String partNumber;
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
    private long length;
    private long width;
    private long height;
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

    public Illuminator1() {
    }


    public Illuminator1(String article, String name, long cost, long costBeforeDiscount, String NDS, String commercialType, long barcode, long weightInPackage, long widthInPackage, long heightInPackage, long lengthInPackage, String urlToMainPic, String urlToOtherPic, String urlTo360Pic, long picArticle, String brand, String modelName, String productColor, String colorName, String colorSwatch, long unitsInOneItem, long numberOfLamps, long maxLampPower, long lightTemperature, String light, String type, String series, String annotation, String partNumber, String guarantee, String richContentJSON, String modelNameForNamingTemplate, String targetAudience, String typeOfLamps, String plinthType, String setWithLightBulbs, long lightingArea, long luminousFlux, String designStyle, String ceilingColor, String ceilingMaterial, String form, String supplyType, long supplyVoltage, String protectionDegree, long length, long width, long height, long foundationWidth, long numberOfModes, String security, String breakerType, String luminaireFeatures, String fastening, String fasteningType, String room, String manufacturerCountry, String equipment, String boxing, long weight, long numberOfFactoryPackages) {
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
        this.partNumber = partNumber;
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
