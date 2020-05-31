package com.entity;

public class Kaoshianpai {
    private Integer id;
	private String changci;	private String kechengmingcheng;	private String jiaoshihao;	private String kaoshishijian;	private String kaoshishiduan;	private String shuoming;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getChangci() {
        return changci;
    }
    public void setChangci(String changci) {
        this.changci = changci == null ? null : changci.trim();
    }	public String getKechengmingcheng() {
        return kechengmingcheng;
    }
    public void setKechengmingcheng(String kechengmingcheng) {
        this.kechengmingcheng = kechengmingcheng == null ? null : kechengmingcheng.trim();
    }	public String getJiaoshihao() {
        return jiaoshihao;
    }
    public void setJiaoshihao(String jiaoshihao) {
        this.jiaoshihao = jiaoshihao == null ? null : jiaoshihao.trim();
    }	public String getKaoshishijian() {
        return kaoshishijian;
    }
    public void setKaoshishijian(String kaoshishijian) {
        this.kaoshishijian = kaoshishijian == null ? null : kaoshishijian.trim();
    }	public String getKaoshishiduan() {
        return kaoshishiduan;
    }
    public void setKaoshishiduan(String kaoshishiduan) {
        this.kaoshishiduan = kaoshishiduan == null ? null : kaoshishiduan.trim();
    }	public String getShuoming() {
        return shuoming;
    }
    public void setShuoming(String shuoming) {
        this.shuoming = shuoming == null ? null : shuoming.trim();
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
