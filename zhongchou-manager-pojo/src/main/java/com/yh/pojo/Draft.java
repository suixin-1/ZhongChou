package com.yh.pojo;

import java.io.Serializable;

public class Draft implements Serializable {
	private String usName;
	private String psFile;
	
	public String getPsFile() {
		return psFile;
	}
	public void setPsFile(String psFile) {
		this.psFile = psFile;
	}
	private int usId;
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	private String usIdcard;
	private String usPhone;
	private String proAName;
	private String proAPhone;
	private String usAddress;
	private int pstName;
	private String proCover;
	private String psName;
	private String psGoal;
	private String psAddress;
	private double psMoney;
	private int psDays;
	private String psVideo;
	private String psStory;
	private String psSupport;
	private String psRepay;
	private String psAboutme;
	private int ryType;
	private double ryPaymoney;
	private String ryRule;
	private String ryContent;
	private String ryNumber;
	private String ryTime;
	private int pstId;
	private int psGetpeople;
	public int getPsGetpeople() {
		return psGetpeople;
	}
	public void setPsGetpeople(int psGetpeople) {
		this.psGetpeople = psGetpeople;
	}
	public int getPstId() {
		return pstId;
	}
	public void setPstId(int pstId) {
		this.pstId = pstId;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsIdcard() {
		return usIdcard;
	}
	public void setUsIdcard(String usIdcard) {
		this.usIdcard = usIdcard;
	}
	public String getUsPhone() {
		return usPhone;
	}
	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}
	public String getProAName() {
		return proAName;
	}
	public void setProAName(String proAName) {
		this.proAName = proAName;
	}
	public String getProAPhone() {
		return proAPhone;
	}
	public void setProAPhone(String proAPhone) {
		this.proAPhone = proAPhone;
	}
	public String getUsAddress() {
		return usAddress;
	}
	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}
	public int getPstName() {
		return pstName;
	}
	public void setPstName(int pstName) {
		this.pstName = pstName;
	}
	public String getProCover() {
		return proCover;
	}
	public void setProCover(String proCover) {
		this.proCover = proCover;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public String getPsGoal() {
		return psGoal;
	}
	public void setPsGoal(String psGoal) {
		this.psGoal = psGoal;
	}
	public String getPsAddress() {
		return psAddress;
	}
	public void setPsAddress(String psAddress) {
		this.psAddress = psAddress;
	}
	public double getPsMoney() {
		return psMoney;
	}
	public void setPsMoney(double psMoney) {
		this.psMoney = psMoney;
	}
	public int getPsDays() {
		return psDays;
	}
	public void setPsDays(int psDays) {
		this.psDays = psDays;
	}
	public String getPsVideo() {
		return psVideo;
	}
	public void setPsVideo(String psVideo) {
		this.psVideo = psVideo;
	}
	public String getPsStory() {
		return psStory;
	}
	public void setPsStory(String psStory) {
		this.psStory = psStory;
	}
	public String getPsSupport() {
		return psSupport;
	}
	public void setPsSupport(String psSupport) {
		this.psSupport = psSupport;
	}
	public String getPsRepay() {
		return psRepay;
	}
	public void setPsRepay(String psRepay) {
		this.psRepay = psRepay;
	}
	public String getPsAboutme() {
		return psAboutme;
	}
	public void setPsAboutme(String psAboutme) {
		this.psAboutme = psAboutme;
	}
	public int getRyType() {
		return ryType;
	}
	public void setRyType(int ryType) {
		this.ryType = ryType;
	}
	public double getRyPaymoney() {
		return ryPaymoney;
	}
	public void setRyPaymoney(double ryPaymoney) {
		this.ryPaymoney = ryPaymoney;
	}
	public String getRyRule() {
		return ryRule;
	}
	public void setRyRule(String ryRule) {
		this.ryRule = ryRule;
	}
	public String getRyContent() {
		return ryContent;
	}
	public void setRyContent(String ryContent) {
		this.ryContent = ryContent;
	}
	public String getRyNumber() {
		return ryNumber;
	}
	public void setRyNumber(String ryNumber) {
		this.ryNumber = ryNumber;
	}
	public String getRyTime() {
		return ryTime;
	}
	public void setRyTime(String ryTime) {
		this.ryTime = ryTime;
	}
	
	
	public Draft() {
		super();
	}
	public Draft(String usName, String psFile, int usId, String usIdcard, String usPhone, String proAName,
			String proAPhone, String usAddress, int pstName, String proCover, String psName, String psGoal,
			String psAddress, double psMoney, int psDays, String psVideo, String psStory, String psSupport,
			String psRepay, String psAboutme, int ryType, double ryPaymoney, String ryRule, String ryContent,
			String ryNumber, String ryTime, int pstId, int psGetpeople) {
		super();
		this.usName = usName;
		this.psFile = psFile;
		this.usId = usId;
		this.usIdcard = usIdcard;
		this.usPhone = usPhone;
		this.proAName = proAName;
		this.proAPhone = proAPhone;
		this.usAddress = usAddress;
		this.pstName = pstName;
		this.proCover = proCover;
		this.psName = psName;
		this.psGoal = psGoal;
		this.psAddress = psAddress;
		this.psMoney = psMoney;
		this.psDays = psDays;
		this.psVideo = psVideo;
		this.psStory = psStory;
		this.psSupport = psSupport;
		this.psRepay = psRepay;
		this.psAboutme = psAboutme;
		this.ryType = ryType;
		this.ryPaymoney = ryPaymoney;
		this.ryRule = ryRule;
		this.ryContent = ryContent;
		this.ryNumber = ryNumber;
		this.ryTime = ryTime;
		this.pstId = pstId;
		this.psGetpeople = psGetpeople;
	}
	@Override
	public String toString() {
		return "Draft [usName=" + usName + ", psFile=" + psFile + ", usId=" + usId + ", usIdcard=" + usIdcard
				+ ", usPhone=" + usPhone + ", proAName=" + proAName + ", proAPhone=" + proAPhone + ", usAddress="
				+ usAddress + ", pstName=" + pstName + ", proCover=" + proCover + ", psName=" + psName + ", psGoal="
				+ psGoal + ", psAddress=" + psAddress + ", psMoney=" + psMoney + ", psDays=" + psDays + ", psVideo="
				+ psVideo + ", psStory=" + psStory + ", psSupport=" + psSupport + ", psRepay=" + psRepay
				+ ", psAboutme=" + psAboutme + ", ryType=" + ryType + ", ryPaymoney=" + ryPaymoney + ", ryRule="
				+ ryRule + ", ryContent=" + ryContent + ", ryNumber=" + ryNumber + ", ryTime=" + ryTime + ", pstId="
				+ pstId + ", psGetpeople=" + psGetpeople + "]";
	}
	
	
	
	
	
}
