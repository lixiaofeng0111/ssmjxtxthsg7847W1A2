package com.entity;

public class Zuoye {
    private Integer id;
	private String zuoyebianhao;	private String zuoyemingcheng;	private String zuoyeleixing;	private String neirong;	private String fujian;	private String yaoqiushijian;	private String kecheng;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getZuoyebianhao() {
        return zuoyebianhao;
    }
    public void setZuoyebianhao(String zuoyebianhao) {
        this.zuoyebianhao = zuoyebianhao == null ? null : zuoyebianhao.trim();
    }	public String getZuoyemingcheng() {
        return zuoyemingcheng;
    }
    public void setZuoyemingcheng(String zuoyemingcheng) {
        this.zuoyemingcheng = zuoyemingcheng == null ? null : zuoyemingcheng.trim();
    }	public String getZuoyeleixing() {
        return zuoyeleixing;
    }
    public void setZuoyeleixing(String zuoyeleixing) {
        this.zuoyeleixing = zuoyeleixing == null ? null : zuoyeleixing.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getFujian() {
        return fujian;
    }
    public void setFujian(String fujian) {
        this.fujian = fujian == null ? null : fujian.trim();
    }	public String getYaoqiushijian() {
        return yaoqiushijian;
    }
    public void setYaoqiushijian(String yaoqiushijian) {
        this.yaoqiushijian = yaoqiushijian == null ? null : yaoqiushijian.trim();
    }	public String getKecheng() {
        return kecheng;
    }
    public void setKecheng(String kecheng) {
        this.kecheng = kecheng == null ? null : kecheng.trim();
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
