package kr.co.sptek.shopping.shoppingMgr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sptek.shopping.info.ConditionInfo;
import kr.co.sptek.shopping.info.ProductInfo;


@Repository
public class ProductMgrDaoImpl implements ProductMgrDao {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
	       this.sqlSession = sqlSession;
	}
	
	//Product_Info
    public int insertProductInfo(ProductInfo productInfo){
    	 return  sqlSession.insert("kr.co.sptek.productMgrSql.mapper.insertProductInfo", productInfo);
    }
    
    public List<ProductInfo> selectListProductInfo(ConditionInfo condition){
    	return  sqlSession.selectList("kr.co.sptek.productMgrSql.mapper.selectListProductInfo", condition);
    }
    
    public ProductInfo selectProductInfo(ConditionInfo condition){
   	return  (ProductInfo)sqlSession.selectOne("kr.co.sptek.productMgrSql.mapper.selectProductInfo", condition);
    }
    
    public ProductInfo getSelectProductInfoTotalNum(ConditionInfo condition){
    	return (ProductInfo)sqlSession.selectOne("kr.co.sptek.productMgrSql.mapper.getProductInfoTotalNum", condition);
    }
    
    public int deleteProductInfo(ConditionInfo condition){
    	return  sqlSession.delete("kr.co.sptek.productMgrSql.mapper.deleteProductInfo", condition);
    }
    
    public int updateProductInfo(ProductInfo productInfo){
    	return  sqlSession.update("kr.co.sptek.productMgrSql.mapper.updateProductInfo", productInfo);
    }
}
