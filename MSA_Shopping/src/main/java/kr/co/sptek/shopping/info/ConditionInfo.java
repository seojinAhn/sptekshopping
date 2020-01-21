package kr.co.sptek.shopping.info;

public class ConditionInfo {
	
	int id;
	
	/* Page Info */
	int 	showPageLimit 		= 10;     	// show page
	int 	showArticleLimit 	= 10;  		// page row num
	int 	pageOffset 			= 0;		// offset
	int 	currentPage 		= 1;		// current page	
	
	int 	showLogLimit 		= 6;     	// show page
	
	String beginDate;
	String endDate;
	
	String userId;
	String userPwd;
	
	/* Product Mgr Info*/	
	String prdName; // '상품명',
	String PrdSubDesc; // '상품부가설명',
	String prdCost; // '원가',
	String prdSellingPrice;// '판매가',
	String prdDiscountPer; //'할인율',
	String prdUseOption; // '옵션유무',
	String prdStock; // '상품재고',
	String prdMainImg; //상품이지미 경로,
	String prdCategory; // 제품카테코리,
	String prdUse; // 판매유무,
	String prdNum; // 제품번호
	String prdSellingCount; //'판매갯수'
	
	public void calsPageOffset() {
		this.pageOffset = (this.currentPage-1) * this.showArticleLimit;
	}


	
	public String getUserId() {
		return userId;
	}



	public void setUserNm(String userId) {
		this.userId = userId;
	}



	public String getUserPwd() {
		return userPwd;
	}



	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShowPageLimit() {
		return showPageLimit;
	}

	public void setShowPageLimit(int showPageLimit) {
		this.showPageLimit = showPageLimit;
	}

	public int getShowArticleLimit() {
		return showArticleLimit;
	}

	public void setShowArticleLimit(int showArticleLimit) {
		this.showArticleLimit = showArticleLimit;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getShowLogLimit() {
		return showLogLimit;
	}

	public void setShowLogLimit(int showLogLimit) {
		this.showLogLimit = showLogLimit;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdSubDesc() {
		return PrdSubDesc;
	}

	public void setPrdSubDesc(String prdSubDesc) {
		PrdSubDesc = prdSubDesc;
	}

	public String getPrdCost() {
		return prdCost;
	}

	public void setPrdCost(String prdCost) {
		this.prdCost = prdCost;
	}

	public String getPrdSellingPrice() {
		return prdSellingPrice;
	}

	public void setPrdSellingPrice(String prdSellingPrice) {
		this.prdSellingPrice = prdSellingPrice;
	}

	public String getPrdDiscountPer() {
		return prdDiscountPer;
	}

	public void setPrdDiscountPer(String prdDiscountPer) {
		this.prdDiscountPer = prdDiscountPer;
	}

	public String getPrdUseOption() {
		return prdUseOption;
	}

	public void setPrdUseOption(String prdUseOption) {
		this.prdUseOption = prdUseOption;
	}

	public String getPrdStock() {
		return prdStock;
	}

	public void setPrdStock(String prdStock) {
		this.prdStock = prdStock;
	}

	public String getPrdMainImg() {
		return prdMainImg;
	}

	public void setPrdMainImg(String prdMainImg) {
		this.prdMainImg = prdMainImg;
	}

	public String getPrdCategory() {
		return prdCategory;
	}

	public void setPrdCategory(String prdCategory) {
		this.prdCategory = prdCategory;
	}

	public String getPrdUse() {
		return prdUse;
	}

	public void setPrdUse(String prdUse) {
		this.prdUse = prdUse;
	}

	public String getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(String prdNum) {
		this.prdNum = prdNum;
	}

	public String getPrdSellingCount() {
		return prdSellingCount;
	}

	public void setPrdSellingCount(String prdSellingCount) {
		this.prdSellingCount = prdSellingCount;
	}
	
	

}
