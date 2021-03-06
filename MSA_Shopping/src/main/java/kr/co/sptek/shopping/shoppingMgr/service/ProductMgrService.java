package kr.co.sptek.shopping.shoppingMgr.service;

import java.util.List;


import kr.co.sptek.shopping.info.ConditionInfo;
import kr.co.sptek.shopping.info.ProductInfo;


public interface ProductMgrService {
	
	//Product_Info
	int insertProductInfo(ProductInfo productInfo);
	List<ProductInfo> selectListProductInfo(ConditionInfo condition);
	ProductInfo selectProductInfo(ConditionInfo condition);
	ProductInfo getSelectProductInfoTotalNum(ConditionInfo condition);
	int deleteProductInfo(ConditionInfo condition);
	int updateProductInfo(ProductInfo productInfo);
}

