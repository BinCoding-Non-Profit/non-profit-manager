package com.bincoding.nonprofit.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "event", schema = "public", catalog = "np_manager")
public class EventEntity {
    private int id;
    private String title;
    private String description;
    private String headerImage;
    private String address;
    private String state;
    private String zipcode;
    private Timestamp dateTime;
    private Integer invited;
    private Integer going;
    private String type;
    private Integer maxAllowed;
    private String contactPhone;
    private String contactEmail;
    private Time startTime;
    private Time endTime;
    private Date date;
    private Double price;
    private Timestamp closeTicketSalesDate;
    private String status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "header_image")
    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
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
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "invited")
    public Integer getInvited() {
        return invited;
    }

    public void setInvited(Integer invited) {
        this.invited = invited;
    }

    @Basic
    @Column(name = "going")
    public Integer getGoing() {
        return going;
    }

    public void setGoing(Integer going) {
        this.going = going;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "max_allowed")
    public Integer getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(Integer maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    @Basic
    @Column(name = "contact_phone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Basic
    @Column(name = "contact_email")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "start_time")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "close_ticket_sales_date")
    public Timestamp getCloseTicketSalesDate() {
        return closeTicketSalesDate;
    }

    public void setCloseTicketSalesDate(Timestamp closeTicketSalesDate) {
        this.closeTicketSalesDate = closeTicketSalesDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (headerImage != null ? !headerImage.equals(that.headerImage) : that.headerImage != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (invited != null ? !invited.equals(that.invited) : that.invited != null) return false;
        if (going != null ? !going.equals(that.going) : that.going != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (maxAllowed != null ? !maxAllowed.equals(that.maxAllowed) : that.maxAllowed != null) return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (closeTicketSalesDate != null ? !closeTicketSalesDate.equals(that.closeTicketSalesDate) : that.closeTicketSalesDate != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (headerImage != null ? headerImage.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (invited != null ? invited.hashCode() : 0);
        result = 31 * result + (going != null ? going.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (maxAllowed != null ? maxAllowed.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (closeTicketSalesDate != null ? closeTicketSalesDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
