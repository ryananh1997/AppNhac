package com.atn.anhtuankg1997.appnhac.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

@SerializedName("IdPlayList")
@Expose
private String idPlayList;
@SerializedName("TenPlayList")
@Expose
private String tenPlayList;
@SerializedName("HinhPlayList")
@Expose
private String hinhPlayList;
@SerializedName("IconPlayList")
@Expose
private String iconPlayList;

public String getIdPlayList() {
return idPlayList;
}

public void setIdPlayList(String idPlayList) {
this.idPlayList = idPlayList;
}

public String getTenPlayList() {
return tenPlayList;
}

public void setTenPlayList(String tenPlayList) {
this.tenPlayList = tenPlayList;
}

public String getHinhPlayList() {
return hinhPlayList;
}

public void setHinhPlayList(String hinhPlayList) {
this.hinhPlayList = hinhPlayList;
}

public String getIconPlayList() {
return iconPlayList;
}

public void setIconPlayList(String iconPlayList) {
this.iconPlayList = iconPlayList;
}

}