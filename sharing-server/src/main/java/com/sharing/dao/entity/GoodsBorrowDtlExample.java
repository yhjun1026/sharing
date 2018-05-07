package com.sharing.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsBorrowDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public GoodsBorrowDtlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.sumCol = null;
        this.offset = null;
        this.limit = null;
    }

    public String getSumCol() {
        return this.sumCol;
    }

    public void setSumCol(String sumCol) {
        this.sumCol = sumCol;
    }

    public GoodsBorrowDtlExample sumUuid() {
        this.sumCol="uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodsUuid() {
        this.sumCol="goods_uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodsCode() {
        this.sumCol="goods_code";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodsName() {
        this.sumCol="goods_name";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowQty() {
        this.sumCol="borrow_qty";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowDescrip() {
        this.sumCol="borrow_descrip";
        return this;
    }

    public GoodsBorrowDtlExample sumDepositAmt() {
        this.sumCol="deposit_amt";
        return this;
    }

    public GoodsBorrowDtlExample sumDamaged() {
        this.sumCol="damaged";
        return this;
    }

    public GoodsBorrowDtlExample sumReturnDescrip() {
        this.sumCol="return_descrip";
        return this;
    }

    public GoodsBorrowDtlExample sumReturnQty() {
        this.sumCol="return_qty";
        return this;
    }

    public GoodsBorrowDtlExample sumPayAmt() {
        this.sumCol="pay_amt";
        return this;
    }

    public GoodsBorrowDtlExample sumReturnDepositAmt() {
        this.sumCol="return_deposit_amt";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowUuid() {
        this.sumCol="borrow_uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowPayUuid() {
        this.sumCol="borrow_pay_uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumReturnPayUuid() {
        this.sumCol="return_pay_uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumCompensatePayUuid() {
        this.sumCol="compensate_pay_uuid";
        return this;
    }

    public GoodsBorrowDtlExample sumMemo() {
        this.sumCol="memo";
        return this;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public GoodsBorrowDtlExample page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidIsNull() {
            addCriterion("goods_uuid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidIsNotNull() {
            addCriterion("goods_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidEqualTo(String value) {
            addCriterion("goods_uuid =", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidNotEqualTo(String value) {
            addCriterion("goods_uuid <>", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidGreaterThan(String value) {
            addCriterion("goods_uuid >", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidGreaterThanOrEqualTo(String value) {
            addCriterion("goods_uuid >=", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidLessThan(String value) {
            addCriterion("goods_uuid <", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidLessThanOrEqualTo(String value) {
            addCriterion("goods_uuid <=", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidLike(String value) {
            addCriterion("goods_uuid like", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidNotLike(String value) {
            addCriterion("goods_uuid not like", value, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidIn(List<String> values) {
            addCriterion("goods_uuid in", values, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidNotIn(List<String> values) {
            addCriterion("goods_uuid not in", values, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidBetween(String value1, String value2) {
            addCriterion("goods_uuid between", value1, value2, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsUuidNotBetween(String value1, String value2) {
            addCriterion("goods_uuid not between", value1, value2, "goodsUuid");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIsNull() {
            addCriterion("goods_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIsNotNull() {
            addCriterion("goods_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeEqualTo(String value) {
            addCriterion("goods_code =", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotEqualTo(String value) {
            addCriterion("goods_code <>", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThan(String value) {
            addCriterion("goods_code >", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_code >=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThan(String value) {
            addCriterion("goods_code <", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_code <=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLike(String value) {
            addCriterion("goods_code like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotLike(String value) {
            addCriterion("goods_code not like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIn(List<String> values) {
            addCriterion("goods_code in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotIn(List<String> values) {
            addCriterion("goods_code not in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeBetween(String value1, String value2) {
            addCriterion("goods_code between", value1, value2, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotBetween(String value1, String value2) {
            addCriterion("goods_code not between", value1, value2, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyIsNull() {
            addCriterion("borrow_qty is null");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyIsNotNull() {
            addCriterion("borrow_qty is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyEqualTo(BigDecimal value) {
            addCriterion("borrow_qty =", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyNotEqualTo(BigDecimal value) {
            addCriterion("borrow_qty <>", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyGreaterThan(BigDecimal value) {
            addCriterion("borrow_qty >", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_qty >=", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyLessThan(BigDecimal value) {
            addCriterion("borrow_qty <", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_qty <=", value, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyIn(List<BigDecimal> values) {
            addCriterion("borrow_qty in", values, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyNotIn(List<BigDecimal> values) {
            addCriterion("borrow_qty not in", values, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_qty between", value1, value2, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_qty not between", value1, value2, "borrowQty");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripIsNull() {
            addCriterion("borrow_descrip is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripIsNotNull() {
            addCriterion("borrow_descrip is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripEqualTo(String value) {
            addCriterion("borrow_descrip =", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripNotEqualTo(String value) {
            addCriterion("borrow_descrip <>", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripGreaterThan(String value) {
            addCriterion("borrow_descrip >", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_descrip >=", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripLessThan(String value) {
            addCriterion("borrow_descrip <", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripLessThanOrEqualTo(String value) {
            addCriterion("borrow_descrip <=", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripLike(String value) {
            addCriterion("borrow_descrip like", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripNotLike(String value) {
            addCriterion("borrow_descrip not like", value, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripIn(List<String> values) {
            addCriterion("borrow_descrip in", values, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripNotIn(List<String> values) {
            addCriterion("borrow_descrip not in", values, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripBetween(String value1, String value2) {
            addCriterion("borrow_descrip between", value1, value2, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowDescripNotBetween(String value1, String value2) {
            addCriterion("borrow_descrip not between", value1, value2, "borrowDescrip");
            return (Criteria) this;
        }

        public Criteria andDepositAmtIsNull() {
            addCriterion("deposit_amt is null");
            return (Criteria) this;
        }

        public Criteria andDepositAmtIsNotNull() {
            addCriterion("deposit_amt is not null");
            return (Criteria) this;
        }

        public Criteria andDepositAmtEqualTo(BigDecimal value) {
            addCriterion("deposit_amt =", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtNotEqualTo(BigDecimal value) {
            addCriterion("deposit_amt <>", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtGreaterThan(BigDecimal value) {
            addCriterion("deposit_amt >", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_amt >=", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtLessThan(BigDecimal value) {
            addCriterion("deposit_amt <", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_amt <=", value, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtIn(List<BigDecimal> values) {
            addCriterion("deposit_amt in", values, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtNotIn(List<BigDecimal> values) {
            addCriterion("deposit_amt not in", values, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_amt between", value1, value2, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDepositAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_amt not between", value1, value2, "depositAmt");
            return (Criteria) this;
        }

        public Criteria andDamagedIsNull() {
            addCriterion("damaged is null");
            return (Criteria) this;
        }

        public Criteria andDamagedIsNotNull() {
            addCriterion("damaged is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedEqualTo(Integer value) {
            addCriterion("damaged =", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotEqualTo(Integer value) {
            addCriterion("damaged <>", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedGreaterThan(Integer value) {
            addCriterion("damaged >", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedGreaterThanOrEqualTo(Integer value) {
            addCriterion("damaged >=", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedLessThan(Integer value) {
            addCriterion("damaged <", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedLessThanOrEqualTo(Integer value) {
            addCriterion("damaged <=", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedIn(List<Integer> values) {
            addCriterion("damaged in", values, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotIn(List<Integer> values) {
            addCriterion("damaged not in", values, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedBetween(Integer value1, Integer value2) {
            addCriterion("damaged between", value1, value2, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotBetween(Integer value1, Integer value2) {
            addCriterion("damaged not between", value1, value2, "damaged");
            return (Criteria) this;
        }

        public Criteria andReturnDescripIsNull() {
            addCriterion("return_descrip is null");
            return (Criteria) this;
        }

        public Criteria andReturnDescripIsNotNull() {
            addCriterion("return_descrip is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDescripEqualTo(String value) {
            addCriterion("return_descrip =", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripNotEqualTo(String value) {
            addCriterion("return_descrip <>", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripGreaterThan(String value) {
            addCriterion("return_descrip >", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripGreaterThanOrEqualTo(String value) {
            addCriterion("return_descrip >=", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripLessThan(String value) {
            addCriterion("return_descrip <", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripLessThanOrEqualTo(String value) {
            addCriterion("return_descrip <=", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripLike(String value) {
            addCriterion("return_descrip like", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripNotLike(String value) {
            addCriterion("return_descrip not like", value, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripIn(List<String> values) {
            addCriterion("return_descrip in", values, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripNotIn(List<String> values) {
            addCriterion("return_descrip not in", values, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripBetween(String value1, String value2) {
            addCriterion("return_descrip between", value1, value2, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnDescripNotBetween(String value1, String value2) {
            addCriterion("return_descrip not between", value1, value2, "returnDescrip");
            return (Criteria) this;
        }

        public Criteria andReturnQtyIsNull() {
            addCriterion("return_qty is null");
            return (Criteria) this;
        }

        public Criteria andReturnQtyIsNotNull() {
            addCriterion("return_qty is not null");
            return (Criteria) this;
        }

        public Criteria andReturnQtyEqualTo(BigDecimal value) {
            addCriterion("return_qty =", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyNotEqualTo(BigDecimal value) {
            addCriterion("return_qty <>", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyGreaterThan(BigDecimal value) {
            addCriterion("return_qty >", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("return_qty >=", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyLessThan(BigDecimal value) {
            addCriterion("return_qty <", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("return_qty <=", value, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyIn(List<BigDecimal> values) {
            addCriterion("return_qty in", values, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyNotIn(List<BigDecimal> values) {
            addCriterion("return_qty not in", values, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_qty between", value1, value2, "returnQty");
            return (Criteria) this;
        }

        public Criteria andReturnQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_qty not between", value1, value2, "returnQty");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNull() {
            addCriterion("pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNotNull() {
            addCriterion("pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmtEqualTo(BigDecimal value) {
            addCriterion("pay_amt =", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotEqualTo(BigDecimal value) {
            addCriterion("pay_amt <>", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThan(BigDecimal value) {
            addCriterion("pay_amt >", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amt >=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThan(BigDecimal value) {
            addCriterion("pay_amt <", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amt <=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtIn(List<BigDecimal> values) {
            addCriterion("pay_amt in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotIn(List<BigDecimal> values) {
            addCriterion("pay_amt not in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amt between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amt not between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtIsNull() {
            addCriterion("return_deposit_amt is null");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtIsNotNull() {
            addCriterion("return_deposit_amt is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtEqualTo(BigDecimal value) {
            addCriterion("return_deposit_amt =", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtNotEqualTo(BigDecimal value) {
            addCriterion("return_deposit_amt <>", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtGreaterThan(BigDecimal value) {
            addCriterion("return_deposit_amt >", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("return_deposit_amt >=", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtLessThan(BigDecimal value) {
            addCriterion("return_deposit_amt <", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("return_deposit_amt <=", value, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtIn(List<BigDecimal> values) {
            addCriterion("return_deposit_amt in", values, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtNotIn(List<BigDecimal> values) {
            addCriterion("return_deposit_amt not in", values, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_deposit_amt between", value1, value2, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andReturnDepositAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_deposit_amt not between", value1, value2, "returnDepositAmt");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidIsNull() {
            addCriterion("borrow_uuid is null");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidIsNotNull() {
            addCriterion("borrow_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidEqualTo(String value) {
            addCriterion("borrow_uuid =", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidNotEqualTo(String value) {
            addCriterion("borrow_uuid <>", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidGreaterThan(String value) {
            addCriterion("borrow_uuid >", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_uuid >=", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidLessThan(String value) {
            addCriterion("borrow_uuid <", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidLessThanOrEqualTo(String value) {
            addCriterion("borrow_uuid <=", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidLike(String value) {
            addCriterion("borrow_uuid like", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidNotLike(String value) {
            addCriterion("borrow_uuid not like", value, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidIn(List<String> values) {
            addCriterion("borrow_uuid in", values, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidNotIn(List<String> values) {
            addCriterion("borrow_uuid not in", values, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidBetween(String value1, String value2) {
            addCriterion("borrow_uuid between", value1, value2, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowUuidNotBetween(String value1, String value2) {
            addCriterion("borrow_uuid not between", value1, value2, "borrowUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidIsNull() {
            addCriterion("borrow_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidIsNotNull() {
            addCriterion("borrow_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidEqualTo(String value) {
            addCriterion("borrow_pay_uuid =", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotEqualTo(String value) {
            addCriterion("borrow_pay_uuid <>", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidGreaterThan(String value) {
            addCriterion("borrow_pay_uuid >", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_pay_uuid >=", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLessThan(String value) {
            addCriterion("borrow_pay_uuid <", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLessThanOrEqualTo(String value) {
            addCriterion("borrow_pay_uuid <=", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLike(String value) {
            addCriterion("borrow_pay_uuid like", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotLike(String value) {
            addCriterion("borrow_pay_uuid not like", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidIn(List<String> values) {
            addCriterion("borrow_pay_uuid in", values, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotIn(List<String> values) {
            addCriterion("borrow_pay_uuid not in", values, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidBetween(String value1, String value2) {
            addCriterion("borrow_pay_uuid between", value1, value2, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotBetween(String value1, String value2) {
            addCriterion("borrow_pay_uuid not between", value1, value2, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidIsNull() {
            addCriterion("return_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidIsNotNull() {
            addCriterion("return_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidEqualTo(String value) {
            addCriterion("return_pay_uuid =", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidNotEqualTo(String value) {
            addCriterion("return_pay_uuid <>", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidGreaterThan(String value) {
            addCriterion("return_pay_uuid >", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("return_pay_uuid >=", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidLessThan(String value) {
            addCriterion("return_pay_uuid <", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidLessThanOrEqualTo(String value) {
            addCriterion("return_pay_uuid <=", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidLike(String value) {
            addCriterion("return_pay_uuid like", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidNotLike(String value) {
            addCriterion("return_pay_uuid not like", value, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidIn(List<String> values) {
            addCriterion("return_pay_uuid in", values, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidNotIn(List<String> values) {
            addCriterion("return_pay_uuid not in", values, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidBetween(String value1, String value2) {
            addCriterion("return_pay_uuid between", value1, value2, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andReturnPayUuidNotBetween(String value1, String value2) {
            addCriterion("return_pay_uuid not between", value1, value2, "returnPayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIsNull() {
            addCriterion("compensate_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIsNotNull() {
            addCriterion("compensate_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidEqualTo(String value) {
            addCriterion("compensate_pay_uuid =", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotEqualTo(String value) {
            addCriterion("compensate_pay_uuid <>", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidGreaterThan(String value) {
            addCriterion("compensate_pay_uuid >", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("compensate_pay_uuid >=", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLessThan(String value) {
            addCriterion("compensate_pay_uuid <", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLessThanOrEqualTo(String value) {
            addCriterion("compensate_pay_uuid <=", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLike(String value) {
            addCriterion("compensate_pay_uuid like", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotLike(String value) {
            addCriterion("compensate_pay_uuid not like", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIn(List<String> values) {
            addCriterion("compensate_pay_uuid in", values, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotIn(List<String> values) {
            addCriterion("compensate_pay_uuid not in", values, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidBetween(String value1, String value2) {
            addCriterion("compensate_pay_uuid between", value1, value2, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotBetween(String value1, String value2) {
            addCriterion("compensate_pay_uuid not between", value1, value2, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria addConditionSql(String conditionSql) {
            addCriterion(conditionSql);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}