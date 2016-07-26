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

�Ż�ȯ��Ŀǰ��Ϊ���û���ӭ�Ĵ����ֶΣ�Ϊ�˷����û�ʹ���Ż�ȯ����վ���û��ύ�����ﳵ�е���Ʒʱ�Զ�Ϊ�û��Ƽ���ʹ������ʵ��Ż�ȯ��

Ŀǰ�����������Ż�ȯ��

1���������ʡ������ڵ�һ�����й�����Ʒ�ܼ�����һ������ʱ������û��Ŀ�ݷ��ã����磺��100����

2���������������һ�����й�����Ʒ�ܼ�����һ������ʱ�����һ���̶ȵĽ����⣬���磺��100��10����300��20��

��������趨����ƹ��ﳵ�ύʱ�Ż�ȯ���Ƽ����򣬹涨ÿ������ֻ��ʹ��һ���Ż�ȯ��

����1������������Ʒ�������ʽ����

����2������Javaʵ���Ƽ����򣬴��뷶Χ�޶�ʹ��JDKԭ��API

 * @author wqx
 *
 */
public class AlibabaDemo2 {
	
	
	/**
	 * ����������û�id�͹������Ʒ�б�����ÿ�����̸�ʹ�õ������Ż�ȯ
	 * 
	 * @return
	 */
	public Map<Integer,Coupon> recommend(int uid,List<Commodity> list){
		Map<Integer,Coupon> result = new HashMap<>();
		//��DB��ȡ���û�����Coupon
		List<Coupon> coupons = getCouponByUid(uid);
		//key��ʾ����id��value���û���������̹������Ʒ�ܼ�
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
			//��ȡ�õ��̵��Ż�ȯ
			List<Coupon> cs = getCouonBySid(coupons,sellerId);
			int postage = getPostage(sellerId,uid);
			//ѡ������Ż�ȯ
			Coupon c = getBestCoupon(map.get(sellerId),coupons,postage);
			if(c != null){
				result.put(sellerId, c);
			}
		}
		return result;
	}
	/**
	 * ���ݵ���id�����ظ��û�ӵ�иõ��̵������Ż�ȯ
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
	  * �����ڸõ��̹�����Ʒ���ܽ���ӵ�е��Ż�ȯ��
	  * ���ظ�ʹ�õ�����Ż�ȯ
	  */
	 public Coupon getBestCoupon(int totalPrice,List<Coupon> coupons,int postage){
		 int disCount = 0,maxProfit = -1;
		 
		 Coupon res = null;
		 for(Coupon c : coupons){
			 int type =  c.getType();
			 if(type == 1){//������
				 if(totalPrice >= c.getThreshold()){
					 disCount = postage;//
				 }
			 }else{//���
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
	 * �����û�ID���̼�ID����ȡ���û��������Ż�ȯ
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
		 * �̼�id
		 */
		private int sellerId;
		/**
		 * �Ż�ȯ���ͣ�
		 * 1��������
		 * 2�����
		 */
		private int type;
		/**
		 * ʹ���Ż�ȯ��ֵ
		 */
		private int threshold;
		/**
		 * ����Żݽ��
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
		 * ��Ʒid
		 */
		private int id;
		/**
		 * �����̼�id
		 */
		private int sellerId;
		/**
		 * �۸�
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
