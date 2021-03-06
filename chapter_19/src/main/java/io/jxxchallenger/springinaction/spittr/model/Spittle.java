package io.jxxchallenger.springinaction.spittr.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class Spittle {

    private long id;
    
    private String message;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    
    private double latitude;
    
    private double longitude;
    
    public Spittle() {
    }

    public Spittle(String message, LocalDateTime time) {
        this(-1, message, time, 0, 0);
    }

    public Spittle(long id, String message, LocalDateTime time, double latitude, double longitude) {
        super();
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, message);
        //return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Spittle)) {
            return false;
        }
        Spittle other = (Spittle) obj;
        return Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
                && Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
                && Objects.equals(message, other.message);
        
        //return EqualsBuilder.reflectionEquals(this, obj, "id", "time");
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
}
