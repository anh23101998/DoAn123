package App;

import java.util.Timer;
import java.io.Serializable;
import java.util.Date;

public class Xe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaXe;
	private Date Date;
	private Timer Time;
	private byte[] picture;
public String getMaXe() {
	return MaXe;
}
public void setMaXe(String MaXe) {
	this.MaXe= MaXe;
}

public Date getDate() {
	return Date;
}
public void setDate(Date Date) {
	this.Date= Date;
}
public Timer getTime() {
	return Time;
}
public void setTime(Timer Time) {
	this.Time = Time;
}
public byte[] getPicture() {
	return picture;
}
public void setPicture(byte[] Picture) {
	this.picture = Picture;
}

}
