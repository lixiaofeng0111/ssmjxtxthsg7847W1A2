package com.entity;

public class Wenjuandiaocha {
    private Integer id;
	private String bianhao;	private String wenti1;	private String wenti2;	private String wenti3;	private String wenti4;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }	public String getWenti1() {
        return wenti1;
    }
    public void setWenti1(String wenti1) {
        this.wenti1 = wenti1 == null ? null : wenti1.trim();
    }	public String getWenti2() {
        return wenti2;
    }
    public void setWenti2(String wenti2) {
        this.wenti2 = wenti2 == null ? null : wenti2.trim();
    }	public String getWenti3() {
        return wenti3;
    }
    public void setWenti3(String wenti3) {
        this.wenti3 = wenti3 == null ? null : wenti3.trim();
    }	public String getWenti4() {
        return wenti4;
    }
    public void setWenti4(String wenti4) {
        this.wenti4 = wenti4 == null ? null : wenti4.trim();
    }	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
