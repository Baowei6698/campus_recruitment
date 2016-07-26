package edu.ouc.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 

优惠券是目前较为受用户欢迎的促销手段，为了方便用户使用优惠券，网站在用户提交购买购物车中的商品时自动为用户推荐并使用最合适的优惠券。

目前假设有两类优惠券：

1、“满包邮”：即在单一店铺中购买商品总价满足一定条件时会减免用户的快递费用，例如：满100包邮

2、“红包”：即单一店铺中购买商品总价满足一定条件时会产生一定程度的金额减免，例如：满100减10、满300减20等

请就如上设定，设计购物车提交时优惠券的推荐程序，规定每个店铺只能使用一张优惠券。

问题1：请阐述你的设计方案，形式不限

问题2：请用Java实现推荐程序，代码范围限定使用JDK原生API

 * @author wqx
 *
 */
public class AlibabaDemo2 {
	
	
	/**
	 * 根据输入的用户id和购买的商品列表，返回每个店铺该使用的最优优惠券
	 * 
	 * @return
	 */
	public Map<Integer,Coupon> recommend(int uid,List<Commodity> list){
		Map<Integer,Coupon> result = new HashMap<>();
		//从DB获取该用户所有Coupon
		List<Coupon> coupons = getCouponByUid(uid);
		//key表示店铺id，value：用户在这个店铺购买的物品总价
		Map<Integer,Integer> map = new HashMap<>(0);
		for(Commodity c : list){
			int sellerId = c.getSellerId();
			if(map.get(c) == null){
				map.put(sellerId, c.getPrice());
			}else{
				map.put(sellerId, map.get(sellerId) + c.getPrice());
			}
		}
		Set<Integer> sets = map.keySet();
		Iterator<Integer> it = sets.iterator();
		
		while(it.hasNext()){
			Integer sellerId = it.next();
			//获取该店铺的优惠券
			List<Coupon> cs = getCouonBySid(coupons,sellerId);
			int postage = getPostage(sellerId,uid);
			//选择最佳优惠券
			Coupon c = getBestCoupon(map.get(sellerId),coupons,postage);
			if(c != null){
				result.put(sellerId, c);
			}
		}
		return result;
	}
	/**
	 * 根据店铺id，返回该用户拥有该店铺的所有优惠券
	 * @param coupons
	 * @param sellerId
	 * @return
	 */
	 public List<Coupon> getCouonBySid(List<Coupon> coupons,Integer sellerId){
		 List<Coupon> res = new ArrayList<>(0);
		 for(Coupon c : coupons){
			 if(c.getSellerId() == sellerId){
				 res.add(c);
			 }
		 }
		 return res;
	 }
	 /**
	  * 根据在该店铺购买商品的总金额和拥有的优惠券，
	  * 返回该使用的最佳优惠券
	  */
	 public Coupon getBestCoupon(int totalPrice,List<Coupon> coupons,int postage){
		 int disCount = 0,maxProfit = -1;
		 
		 Coupon res = null;
		 for(Coupon c : coupons){
			 int type =  c.getType();
			 if(type == 1){//满包邮
				 if(totalPrice >= c.getThreshold()){
					 disCount = postage;//
				 }
			 }else{//红包
				 if(totalPrice >= c.getThreshold()){
					 disCount = c.getDiscount();
				 }
			 }
			 if(maxProfit < disCount){
				 res = c;
			 }
		 }
		 return res;
	 }
	 public int getPostage(int uid,int sellerId){
		 int postage = 0;
		 /**
		  * get postage from DB
		  */
		 return postage;
	 }
	/**
	 * 根据用户ID和商家ID，获取该用户的所有优惠券
	 * @param uid
	 * @return
	 */
	public List<Coupon> getCouponByUid(int uid){
		List<Coupon> lists = new ArrayList<>(0);
		/**
		 * get Coupon from DB
		 */
		return lists;
	}
	class Coupon{
		/**
		 * 商家id
		 */
		private int sellerId;
		/**
		 * 优惠券类型：
		 * 1：满包邮
		 * 2：红包
		 */
		private int type;
		/**
		 * 使用优惠券阈值
		 */
		private int threshold;
		/**
		 * 红包优惠金额
		 */
		private int discount;
		
		public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getThreshold() {
			return threshold;
		}
		public void setThreshold(int threshold) {
			this.threshold = threshold;
		}
		public int getDiscount() {
			return discount;
		}
		public void setDiscount(int discount) {
			this.discount = discount;
		}
	}
	class Commodity{
		/**
		 * 商品id
		 */
		private int id;
		/**
		 * 所属商家id
		 */
		private int sellerId;
		/**
		 * 价格
		 */
		private int price;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
	}
}
