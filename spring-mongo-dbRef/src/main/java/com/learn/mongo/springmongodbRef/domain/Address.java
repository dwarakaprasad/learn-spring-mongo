package com.learn.mongo.springmongodbRef.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ADDRESS")
public class Address {

    public enum AddressTypeEnum {
        RESIDENTIAL, MAILING, BILLING, LEGAL
    }

    @Id
    private String id;
    private String street01;
    private String street02;
    private String city;
    private String zip;
    private String county;
    private String state;
    private String country;
    private AddressTypeEnum addressType;

    public Address() {

    }

    /**
     * @return the addressType
     */
    public AddressTypeEnum getAddressType() {
        return addressType;
    }

    /**
     * @param addressType the addressType to set
     */
    public void setAddressType(AddressTypeEnum addressType) {
        this.addressType = addressType;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param street01 the street01 to set
     */
    public void setStreet01(String street01) {
        this.street01 = street01;
    }

    /**
     * @return the street01
     */
    public String getStreet01() {
        return street01;
    }

    /**
     * @param street02 the street02 to set
     */
    public void setStreet02(String street02) {
        this.street02 = street02;
    }

    /**
     * @return the street02
     */
    public String getStreet02() {
        return street02;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;

    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
