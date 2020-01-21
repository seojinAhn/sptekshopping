package kr.co.sptek.shopping.shoppingMgr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sptek.shopping.common.PageHtmlUtil;
import kr.co.sptek.shopping.common.Utility;

import kr.co.sptek.shopping.info.ConditionInfo;
import kr.co.sptek.shopping.info.ProductInfo;
import kr.co.sptek.shopping.shoppingMgr.service.ProductMgrService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductMgrController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductMgrController.class);
	
	@Autowired
	private ProductMgrService productMgrService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/productInfoSelect", method = RequestMethod.GET)
	public String productInfoSelect(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoSelect(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("UserInfo") == null){
    		return "jsp/login";
    	}    	
    	
		/* 현재 page index를 통한 page offset을 구함 */
		condition.calsPageOffset();
		
		/* 검사이력정보  조회조건에 따른 전체 수 조회 */
		double totalNum = 0;
		if(productMgrService.getSelectProductInfoTotalNum(condition) != null){
			totalNum = productMgrService.getSelectProductInfoTotalNum(condition).getTotalNum();
		}		
		
		PageHtmlUtil pageHtmlUtil = new PageHtmlUtil();
		String pageHtml = pageHtmlUtil.getPageHtml(condition, totalNum);		
		
		List<ProductInfo> productInfoList = productMgrService.selectListProductInfo(condition);
		
		model.addAttribute("Condition", condition );
		model.addAttribute("PageHtml", pageHtml);
		model.addAttribute("ProductInfoList", productInfoList );
		
		return "jsp/productMgr/productInfoSelect";
	}
	
	@RequestMapping(value = "/productInfoInsert", method = RequestMethod.GET)
	public String productInfoInsert(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoInsert(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("ProductInfo") == null){
    		return "jsp/login";
    	}    	
    	
		model.addAttribute("Condition", condition );
		
		return "jsp/productMgr/productInfoInsert";
	}	
	
	@RequestMapping(value = "/productInfoSave", method = RequestMethod.GET)
	public String productInfoSave(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoSave(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("ProductInfo") == null){
    		return "jsp/login";
    	}    
    	
		model.addAttribute("Condition", condition );

		if(StringUtils.isNotEmpty(condition.getPrdName())==true && StringUtils.isNotEmpty(condition.getPrdNum())==true){		
				
			ProductInfo productInfo = new ProductInfo();			
			
			productInfo.setPrdName(condition.getPrdName()); // '상품명',
			productInfo.setPrdSubDesc(condition.getPrdSubDesc()); // '상품부가설명',
			productInfo.setPrdCost(condition.getPrdCost()); // '원가',
			productInfo.setPrdSellingPrice(condition.getPrdSellingPrice());// '판매가',
			productInfo.setPrdDiscountPer(condition.getPrdDiscountPer()); //'할인율',
			productInfo.setPrdUseOption(condition.getPrdUseOption()); // '옵션유무',
			productInfo.setPrdStock(condition.getPrdStock()); // '상품재고',
			productInfo.setPrdMainImg(condition.getPrdMainImg()); //상품이지미 경로,
			productInfo.setPrdCategory(condition.getPrdCategory()); // 제품카테코리,
			productInfo.setPrdUse(condition.getPrdUse()); // 판매유무,
			productInfo.setPrdNum(condition.getPrdNum()); // 제품번호
			productInfo.setPrdSellingCount(condition.getPrdSellingCount()); //'판매갯수'
			
			productMgrService.insertProductInfo(productInfo);
		}
		
		return "redirect:productInfoSelect";
	}	
	
	
	@RequestMapping(value = "/productInfoDelete", method = RequestMethod.GET)
	public String productInfoDelete(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoDelete(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("ProductInfo") == null){
    		return "jsp/login";
    	}   
    	
		productMgrService.deleteProductInfo(condition);
		
		return "redirect:productInfoSelect";
	}
	
	@RequestMapping(value = "/productInfoUpdate", method = RequestMethod.GET)
	public String productInfoUpdate(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoUpdate(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("ProductInfo") == null){
    		return "jsp/login";
    	}   
    	
    	model.addAttribute("Condition", condition );
		
		if(StringUtils.isNotEmpty(condition.getPrdName())==true && StringUtils.isNotEmpty(condition.getPrdNum())==true){		
			
			ProductInfo productInfo = new ProductInfo();			
			
			productInfo.setPrdName(condition.getPrdName()); // '상품명',
			productInfo.setPrdSubDesc(condition.getPrdSubDesc()); // '상품부가설명',
			productInfo.setPrdCost(condition.getPrdCost()); // '원가',
			productInfo.setPrdSellingPrice(condition.getPrdSellingPrice());// '판매가',
			productInfo.setPrdDiscountPer(condition.getPrdDiscountPer()); //'할인율',
			productInfo.setPrdUseOption(condition.getPrdUseOption()); // '옵션유무',
			productInfo.setPrdStock(condition.getPrdStock()); // '상품재고',
			productInfo.setPrdMainImg(condition.getPrdMainImg()); //상품이지미 경로,
			productInfo.setPrdCategory(condition.getPrdCategory()); // 제품카테코리,
			productInfo.setPrdUse(condition.getPrdUse()); // 판매유무,
			productInfo.setPrdNum(condition.getPrdNum()); // 제품번호
			productInfo.setPrdSellingCount(condition.getPrdSellingCount()); //'판매갯수'
			
			productMgrService.updateProductInfo(productInfo);
		}
		
		return "redirect:productInfoDetail?id="+ condition.getId();
	}
	
	@RequestMapping(value = "/productInfoDetail", method = RequestMethod.GET)
	public String productInfoDetail(ConditionInfo condition, HttpSession session, Model model) {
		logger.info("Autowired :  productMgrController.productInfoDetail(condition)");
		
		/* 세션 사용자 정보 확인 */
    	if(session.getAttribute("ProductInfo") == null){
    		return "jsp/login";
    	}   
    	
		ProductInfo productInfo = productMgrService.selectProductInfo(condition);
		
		model.addAttribute("Condition", condition );
		model.addAttribute("ProductInfo", productInfo );
		
		return "jsp/productMgr/productInfoDetail";
	}	
	//--------------------------------------------------------------------------------------------
		
	
}
