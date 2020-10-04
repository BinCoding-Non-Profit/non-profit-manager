package com.bincoding.nonprofit.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "organization", schema = "public", catalog = "np_manager")
public class OrganizationEntity {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String contact;
    private String primaryContact;
    private String primaryContactEmail;
    private String primaryContactPhone;

    @ManyToMany
    private Collection<UserEntity> user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "primary_contact")
    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    @Basic
    @Column(name = "primary_contact_email")
    public String getPrimaryContactEmail() {
        return primaryContactEmail;
    }

    public void setPrimaryContactEmail(String primaryContactEmail) {
        this.primaryContactEmail = primaryContactEmail;
    }

    @Basic
    @Column(name = "primary_contact_phone")
    public String getPrimaryContactPhone() {
        return primaryContactPhone;
    }

    public void setPrimaryContactPhone(String primaryContactPhone) {
        this.primaryContactPhone = primaryContactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationEntity that = (OrganizationEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (primaryContact != null ? !primaryContact.equals(that.primaryContact) : that.primaryContact != null)
            return false;
        if (primaryContactEmail != null ? !primaryContactEmail.equals(that.primaryContactEmail) : that.primaryContactEmail != null)
            return false;
        if (primaryContactPhone != null ? !primaryContactPhone.equals(that.primaryContactPhone) : that.primaryContactPhone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (primaryContact != null ? primaryContact.hashCode() : 0);
        result = 31 * result + (primaryContactEmail != null ? primaryContactEmail.hashCode() : 0);
        result = 31 * result + (primaryContactPhone != null ? primaryContactPhone.hashCode() : 0);
        return result;
    }
}
