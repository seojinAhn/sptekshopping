package kr.co.sptek.shopping.shoppingMgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sptek.shopping.info.ConditionInfo;
import kr.co.sptek.shopping.info.ProductInfo;
import kr.co.sptek.shopping.shoppingMgr.dao.ProductMgrDao;

@Service
public class ProductMgrServiceImpl implements ProductMgrService {
	
	@Autowired
    private ProductMgrDao productMgrDao;
	
	
	//Product_Info
    public int insertProductInfo(ProductInfo productInfo){
     	return productMgrDao.insertProductInfo(productInfo);
    }
    
    public List<ProductInfo> selectListProductInfo(ConditionInfo condition){
    	return productMgrDao.selectListProductInfo(condition); 
    }
    
    public ProductInfo selectProductInfo(ConditionInfo condition){
    	return productMgrDao.selectProductInfo(condition);
    }
    
    public ProductInfo getSelectProductInfoTotalNum(ConditionInfo condition){
    	return productMgrDao.getSelectProductInfoTotalNum(condition);
    }
    
    public int deleteProductInfo(ConditionInfo condition){
    	return productMgrDao.deleteProductInfo(condition);
    }
    
    public int updateProductInfo(ProductInfo adminInfo){
    	return productMgrDao.updateProductInfo(adminInfo);
    }
    
   

}
